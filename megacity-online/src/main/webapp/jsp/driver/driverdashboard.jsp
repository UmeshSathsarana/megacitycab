<%@page import="com.example.model.BookingModel"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
    HttpSession sessionObj = request.getSession(false);
    Integer driverId = (sessionObj != null) ? (Integer) sessionObj.getAttribute("driverId") : null;
    String driverName = (sessionObj != null) ? (String) sessionObj.getAttribute("fullName") : "Guest";

    if (driverId == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // ✅ Get the list of pending and accepted rides
    List<BookingModel> bookings = (List<BookingModel>) request.getAttribute("bookings");
    if (bookings == null) {
        bookings = new java.util.ArrayList<>();
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Driver Dashboard</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; }
        .navbar { background: #1a1a1a; color: white; display: flex; justify-content: space-between; align-items: center; padding: 15px 30px; }
        .profile-section { display: flex; align-items: center; gap: 10px; }
        .dashboard-container { max-width: 800px; margin: 40px auto; padding: 20px; background: white; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); text-align: center; }
        table { width: 80%; margin: 20px auto; border-collapse: collapse; box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); }
        th, td { padding: 12px; text-align: center; border: 1px solid black; }
        th { background-color: black; color: white; }
        .accept-btn { padding: 8px; background-color: green; color: white; border: none; border-radius: 5px; cursor: pointer; }
        .accept-btn:hover { background-color: darkgreen; }
    </style>
</head>
<body>
 <!-- Navbar -->
    <div class="navbar">
        <div class="logo">Driver Dashboard</div>
        <div class="nav-links">
            <a href="driverDashboard.jsp">Home</a>
            <a href="addVehicle.jsp">Add Vehicle</a>
            <a href="logout.jsp">Logout</a>
          <!--    <a href="DriverDetails.jsp">view Data</a>-->
        </div>
        <div class="profile-section">
        <a href="DriverDetails.jsp">
    <img src="https://www.pngall.com/wp-content/uploads/5/Profile-PNG-File.png" 
         alt="Driver Profile" 
         width="120" 
         height="120" 
         style="border-radius: 50%; border: 2px solid black; cursor: pointer;">
</a>
            <span class="profile-name"  ><%= driverName %></span>
        </div>
    </div>


    <!-- Dashboard Content -->
    <div class="dashboard-container">
        <h1>Welcome, <%= driverName %>!</h1>
        <h3>Your Pending and Accepted Rides</h3>
    </div>
<h2 style="text-align:center;">Assigned Bookings</h2>

<h2>Your Bookings</h2>

<<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Booking ID</th>
        <th>Pickup</th>
        <th>Drop</th>
        <th>Distance</th>
        <th>Price</th>
        <th>Status</th>
        <th>Action</th>
    </tr>

    <% for (BookingModel booking : bookings) { %>
        <tr>
            <td><%= booking.getBookingId() %></td>
            <td><%= booking.getPickupLocation() %></td>
            <td><%= booking.getDropLocation() %></td>
            <td><%= booking.getDistance() %> km</td>
            <td>Rs <%= booking.getPrice() %></td>
            <td><%= booking.getStatus() %></td>
            <td>
                <form action="BookingController" method="post" style="display:inline;">
    <input type="hidden" name="action" value="updateStatus">
    <input type="hidden" name="bookingId" value="<%= booking.getBookingId() %>">

    <% if ("Pending".equals(booking.getStatus())) { %>
        <button type="submit" name="status" value="Accepted" class="accept-btn">Accept</button>
        <button type="submit" name="status" value="Rejected" class="accept-btn" style="background-color:red;">Reject</button>
    <% } else if ("Accepted".equals(booking.getStatus())) { %>
        <button type="submit" name="status" value="Completed" class="accept-btn" style="background-color:orange;">Mark as Completed</button>
    <% } else { %>
        No actions available
    <% } %>
</form>
            </td>
        </tr>
    <% } %>
</table>

   
</body>
</html>
