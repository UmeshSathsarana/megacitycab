<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.model.DriverModel" %>
<%@ page import="com.example.service.DriverService" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="javax.servlet.*" %>
<%
    String drvIdParam = request.getParameter("drvId");
    
    if (drvIdParam == null || drvIdParam.isEmpty()) {
        response.sendRedirect("errorPage.jsp?error=Invalid Driver ID");
        return;
    }

    int drvId = Integer.parseInt(drvIdParam);
    DriverService service = DriverService.getInstance();
    DriverModel driver = service.getDriverDetails(drvId);

    if (driver == null) {
        response.sendRedirect("errorPage.jsp?error=Driver not found");
        return;
    }
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Driver Profile</title>
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
    form {
        display: inline-block;
        text-align: left;
        background-color: #222;
        padding: 20px;
        border-radius: 10px;
    }
    label {
        display: block;
        margin: 10px 0 5px;
        color: yellow;
    }
    input[type="text"], input[type="email"], input[type="file"], input[type="password"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        border: none;
        border-radius: 5px;
    }
    button {
        display: inline-block;
        background-color: yellow;
        color: black;
        padding: 10px 20px;
        text-decoration: none;
        font-weight: bold;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    button:hover {
        background-color: white;
    }
</style>
</head>
<body>

<h2>Edit Driver Profile</h2>

<form action="updateDriver" method="post" enctype="multipart/form-data">
    
    <input type="hidden" name="drvId" value="<%= driver.getDrvId() %>">

    <label for="fullName">Full Name:</label>
    <input type="text" id="fullName" name="fullName" value="<%= driver.getFullName() %>" required>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" value="<%= driver.getAddress() %>" required>

    <label for="phoneNumber">Phone Number:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" value="<%= driver.getPhoneNumber() %>" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="<%= driver.getEmail() %>" required>

    <label for="nicNumber">NIC Number:</label>
    <input type="text" id="nicNumber" name="nicNumber" value="<%= driver.getNicNumber() %>" required>

    <label for="licNumber">License Number:</label>
    <input type="text" id="licNumber" name="licNumber" value="<%= driver.getLicNumber() %>" required>

   <label for="image">Profile Image:</label>
    <input type="file" name="image">
    <% if(driver.getImage() != null) { %>
        <img src="<%= driver.getImage() %>" width="100">
    <% } %>

    <!-- You can also show the current image if you store image path -->
    <% if(driver.getImage() != null && !driver.getImage().isEmpty()) { %>
        <p>Current Image: <%= driver.getImage() %></p>
    <% } %>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" value="<%= driver.getPassword() %>" required>

    <br><br>
    <a href="<%=request.getContextPath() %>driverEdit.jsp?drvId=<%=driver.getDrvId()%>">Edit</a>
    
</form>

</body>
</html>
