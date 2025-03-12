<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Admin Dashboard</a>
    <div class="collapse navbar-collapse">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a class="nav-link" href="viewDrivers.jsp">View Drivers</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="viewVehicles.jsp">View Vehicles</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="alogin.jsp">Logout</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="container mt-5">
  <div class="row">
    <div class="col-md-6 offset-md-3">
      <div class="card">
        <div class="card-header bg-primary text-white text-center">
          Admin Actions
        </div>
        <div class="card-body">
          <a href="viewDrivers.jsp" class="btn btn-success w-100 mb-3">Manage Drivers</a>
          <a href="viewVehicles.jsp" class="btn btn-info w-100 mb-3">Manage Vehicles</a>
        </div>
      </div>
    </div>
  </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
