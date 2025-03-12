<%@ page import="java.util.List, com.example.model.VehicleModel, com.example.service.VehicleService" %>
<!DOCTYPE html>
<html>
<head><title>Vehicle List</title></head>
<body>
    <h2>All Vehicles</h2>
    <table border="1">
        <tr>
             <th>DriverID</th>
            <th>ID</th>
            <th>Model</th>
            <th>Number</th>
            <th>Type</th>
            <th>Action</th>
        </tr>
        <%
            List<VehicleModel> vehicles = VehicleService.getAllVehicles();
            for (VehicleModel vehicle : vehicles) {
        %>
        <tr>
             <td><%= vehicle.getDrvId() %></td>
            <td><%= vehicle.getVehicleId() %></td>
            <td><%= vehicle.getModel() %></td>
            <td><%= vehicle.getVehiclenumber() %></td>
            <td><%= vehicle.getType() %></td>
            <td>
               
                <a href="deleteVehicle?id=<%= vehicle.getVehicleId() %>" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
