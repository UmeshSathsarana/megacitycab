<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Vehicle - Mega City Cab</title>
    <style>
    body {
    font-family: Arial, sans-serif;
    background-color: #ffffcc; /* Light Yellow Background */
    color: #000; /* Black Text */
    margin: 0;
    padding: 0;
}

.container {
    width: 40%;
    margin: 50px auto;
    background-color: #fff; /* White Container */
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

h2 {
    text-align: center;
    color: #000; /* Black */
}

form {
    display: flex;
    flex-direction: column;
}

label {
    margin-top: 10px;
    font-weight: bold;
    color: #000; /* Black */
}

input, select {
    padding: 8px;
    margin-top: 5px;
    border: 1px solid #000; /* Black Border */
    border-radius: 5px;
}

button {
    margin-top: 15px;
    padding: 10px;
    background-color: #ffcc00; /* Yellow */
    color: #000; /* Black */
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-weight: bold;
}

button:hover {
    background-color: #ffdb4d; /* Lighter Yellow */
}

a {
    display: block;
    text-align: center;
    margin-top: 15px;
    color: #000; /* Black */
    text-decoration: none;
    font-weight: bold;
}

a:hover {
    text-decoration: underline;
}
    
    </style>
</head>
<body>
    <div class="container">
        <h2>Add Vehicle</h2>
        <form action="AddVehicle" method="post">
            <label for="vehicleNumber">Vehicle Number:</label>
            <input type="text" id="vehiclenumber" name="vehiclenumber" required>

            <label for="model">Model:</label>
            <input type="text" id="model" name="model" required>

            <label for="type">Vehicle Type:</label>
            <select id="type" name="type" required>
                <option value="Sedan">Sedan</option>
                <option value="SUV">SUV</option>
                <option value="Mini">Mini</option>
                <option value="Luxury">Luxury</option>
            </select>
            
            <label for="type">vehicle</label>
            <select id="vtype" name="vtype" required>
            <option value="Car">Car</option>
            <option value="Bike">Bike</option>
            <option value="Tuk tuk">Tuk tuk</option>
            <option value="Van">Van</option>
             <option value="Lorry">Lorry</option>
            </select>
            

            <label for="seatingCapacity">Seating Capacity:</label>
            <input type="number" id="seatingcapacity" name="seatingcapacity" min="1" required>

          <label for="pricePerKm">Price</label>
          <input type="text" id="pricePerKm" name="pricePerKm" required="required">

            <button type="submit">Add Vehicle</button>
        </form>

        <br>
        <a href="vehicle_list.jsp">View Vehicle List</a>
    </div>
</body>
</html>
