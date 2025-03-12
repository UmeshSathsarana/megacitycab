<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.model.DriverModel" %>
<%@ page import="com.example.service.DriverService" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="javax.servlet.*" %>

<%
    int drvId = (int) session.getAttribute("driverId");
    DriverService service = DriverService.getInstance();
    DriverModel driver = service.getDriverDetails(drvId);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Driver Profile</title>
<style>
    body {
        background-color: black;
        color: white;
        font-family: Arial, sans-serif;
        text-align: center;
    }
    h2 {
        color: yellow;
    }
    p {
        font-size: 18px;
        margin: 10px 0;
    }
    a {
        display: inline-block;
        background-color: yellow;
        color: black;
        padding: 10px 20px;
        text-decoration: none;
        font-weight: bold;
        border-radius: 5px;
        margin-top: 15px;
    }
    a:hover {
        background-color: white;
        color: black;
    }
</style>
</head>
<body>

<h2>Driver Profile</h2>
<p>Name: <%= driver.getFullName() %></p>
<p>Address: <%= driver.getAddress() %></p>
<p>Phone: <%= driver.getPhoneNumber() %></p>
<p>Email: <%= driver.getEmail() %></p>
<p>NIC: <%= driver.getNicNumber() %></p>

<a href="driverEdit.jsp?drvId=<%= driver.getDrvId() %>">Edit Profile</a>

</body>
</html>
