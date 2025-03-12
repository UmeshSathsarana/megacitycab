<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.example.model.DriverModel, com.example.service.DriverService" %>
<%
List<DriverModel> drivers = DriverService.getInstance().getAllDrivers();

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin - Manage Drivers</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            text-align: center;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid black;
        }
        th {
            background-color: black;
            color: white;
        }
        tr:nth-child(even) {
            background-color: yellow;
        }
        tr:nth-child(odd) {
            background-color: white;
        }
        tr:hover {
            background-color: darkgoldenrod;
            color: black;
        }
        .button {
            padding: 8px;
            text-decoration: none;
            color: white;
            background-color: blue;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .delete-btn {
            background-color: red;
        }
        .button:hover {
            background-color: darkblue;
        }
        .delete-btn:hover {
            background-color: darkred;
        }
    </style>
</head>
<body>

    <h2>Manage Drivers</h2>

    <table>
        <tr>
            <th>Driver ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>NIC</th>
            <th>License</th>
            <th>Actions</th>
             <th>status</th>
        </tr>
        <% for (DriverModel driver : drivers) { %>
            <tr>
            
                <td><%= driver.getDrvId() %></td>
                <td><%= driver.getFullName() %></td>
                <td><%= driver.getEmail() %></td>
                <td><%= driver.getNicNumber() %></td>
                <td><%= driver.getLicNumber() %></td>
               
                <td>
                   
                    <a href="javascript:void(0);" class="button delete-btn" onclick="deleteDriver(<%= driver.getDrvId() %>)">Delete</a>
                </td>
                 <td><%= driver.getStatus() %></td>
            </tr>
        <% } %>
    </table>
    

    <script>
    function deleteDriver(drvId) {
        if (confirm("Are you sure you want to delete this driver?")) {
            fetch('<%= request.getContextPath() %>/AdminLoginController2?action=deleteDriver&drvId=' + drvId, {
                method: 'POST'
            })
            .then(response => response.text())
            .then(data => {
                alert(data);
                location.reload();
            })
            .catch(error => console.error('Error:', error));
        }
    }
</script>
    

</body>
</html>
