<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.VehicleModel" %>
<%@ page import="com.example.service.VehicleService" %>
<%@ page import="javax.servlet.http.HttpSession" %>



<%

    List<VehicleModel> vehicles = VehicleService.getAllVehicles();
%>

<html>
<head>
    <title>Book a Vehicle</title>
    <style>
        #map { height: 400px; width: 100%; margin-bottom: 20px; }
    </style>
</head>
<body>



<form action="BookingController" method="post">
    <input type="hidden" name="action" value="createBooking">

    <label>Pickup Location:</label>
    <input type="text" name="pickupLocation" id="pickupLocation" readonly required><br><br>

    <label>Drop Location:</label>
    <input type="text" name="dropLocation" id="dropLocation" readonly required><br><br>

    <input type="hidden" name="pickupLat" id="pickupLat">
    <input type="hidden" name="pickupLng" id="pickupLng">
    <input type="hidden" name="dropLat" id="dropLat">
    <input type="hidden" name="dropLng" id="dropLng">

    <div id="map"></div>

    <label>Distance (KM):</label>
    <input type="text" name="distance" id="distance" readonly required><br><br>

    <label>Select Vehicle:</label>
    <select name="vehicleId" id="vehicleId" onchange="updatePrice()" required>
        <option value="">--Select Vehicle--</option>
        <% for (VehicleModel v : vehicles) { %>
            <option value="<%= v.getVehicleId() %>" data-price="<%= v.getPricePerKm() %>">
                <%= v.getVehiclenumber() %> - <%= v.getModel() %>-<%= v.getSeatingcapacity() %> (Rs. <%= v.getPricePerKm() %>/KM)
            </option>
        <% } %>
    </select><br><br>

    <label>Total Price (Rs.):</label>
    <input type="text" name="price" id="price" readonly required><br><br>

    <button type="submit">Confirm Booking</button>
</form>

<%
    String message = request.getParameter("message");
    String error = request.getParameter("error");

    if (message != null) {
%>
    <p style="color:green;"><%= message %></p>
<% } else if (error != null) { %>
    <p style="color:red;"><%= error %></p>
<% } %>

<script src="https://cdn.jsdelivr.net/gh/somanchiu/Keyless-Google-Maps-API@v6.8/mapsJavaScriptAPI.js" async defer></script>
<script>
    let map, pickupMarker, dropMarker;

    function initMap() {
        const center = { lat: 6.9271, lng: 79.8612 };
        map = new google.maps.Map(document.getElementById("map"), {
            zoom: 10,
            center: center
        });

        map.addListener("click", (event) => {
            if (!pickupMarker) {
                addPickupMarker(event.latLng);
            } else if (!dropMarker) {
                addDropMarker(event.latLng);
                calculateDistance();
            } else {
                resetMarkers();
                addPickupMarker(event.latLng);
            }
        });
    }

    function addPickupMarker(location) {
        pickupMarker = new google.maps.Marker({ position: location, map: map, label: "P" });
        document.getElementById("pickupLat").value = location.lat();
        document.getElementById("pickupLng").value = location.lng();
        geocodeLocation(location, "pickupLocation");
    }

    function addDropMarker(location) {
        dropMarker = new google.maps.Marker({ position: location, map: map, label: "D" });
        document.getElementById("dropLat").value = location.lat();
        document.getElementById("dropLng").value = location.lng();
        geocodeLocation(location, "dropLocation");
    }

    function resetMarkers() {
        if (pickupMarker) pickupMarker.setMap(null);
        if (dropMarker) dropMarker.setMap(null);
        pickupMarker = dropMarker = null;
        document.getElementById("pickupLocation").value = "";
        document.getElementById("dropLocation").value = "";
        document.getElementById("distance").value = "";
        document.getElementById("price").value = "";
    }

    function geocodeLocation(latlng, elementId) {
        const geocoder = new google.maps.Geocoder();
        geocoder.geocode({ location: latlng }, (results, status) => {
            if (status === "OK" && results[0]) {
                document.getElementById(elementId).value = results[0].formatted_address;
            }
        });
    }

    function calculateDistance() {
        const pickup = new google.maps.LatLng(
            parseFloat(document.getElementById("pickupLat").value),
            parseFloat(document.getElementById("pickupLng").value)
        );
        const drop = new google.maps.LatLng(
            parseFloat(document.getElementById("dropLat").value),
            parseFloat(document.getElementById("dropLng").value)
        );

        const service = new google.maps.DistanceMatrixService();
        service.getDistanceMatrix({
            origins: [pickup],
            destinations: [drop],
            travelMode: google.maps.TravelMode.DRIVING,
            unitSystem: google.maps.UnitSystem.METRIC
        }, (response, status) => {
            if (status === "OK") {
                const distanceInKm = response.rows[0].elements[0].distance.value / 1000;
                document.getElementById("distance").value = distanceInKm.toFixed(2);
                updatePrice();
            }
        });
    }

    function updatePrice() {
        const distance = parseFloat(document.getElementById("distance").value);
        const vehicleDropdown = document.getElementById("vehicleId");
        const pricePerKm = vehicleDropdown.options[vehicleDropdown.selectedIndex].getAttribute("data-price");

        if (!isNaN(distance) && pricePerKm) {
            const totalPrice = (distance * parseFloat(pricePerKm)).toFixed(2);
            document.getElementById("price").value = totalPrice;
        }
    }

    window.initMap = initMap;
</script>

</body>
</html>
