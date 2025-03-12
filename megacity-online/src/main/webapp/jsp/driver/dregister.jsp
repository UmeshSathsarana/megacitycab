<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        :root {
            --black: #000000;
            --white: #FFFFFF;
            --yellow: #FFD700;
        }

        body {
            background: linear-gradient(45deg, var(--black), #2c2c2c);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: 'Segoe UI', sans-serif;
        }

        .form-card {
            background: var(--white);
            padding: 2.5rem;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
            width: 450px;
            transition: transform 0.3s;
        }

        .form-card:hover {
            transform: translateY(-5px);
        }

        .form-title {
            color: var(--black);
            text-align: center;
            margin-bottom: 2rem;
            font-size: 1.8rem;
            position: relative;
        }

        .form-title::after {
            content: '';
            width: 60px;
            height: 3px;
            background: var(--yellow);
            position: absolute;
            bottom: -10px;
            left: 50%;
            transform: translateX(-50%);
        }

        .input-group {
            margin-bottom: 1.5rem;
            position: relative;
        }

        .input-group input {
            width: 100%;
            padding: 12px;
            border: 2px solid #e0e0e0;
            border-radius: 8px;
            font-size: 1rem;
            transition: border-color 0.3s;
        }

        .input-group input:focus {
            outline: none;
            border-color: var(--yellow);
            box-shadow: 0 0 8px rgba(255,215,0,0.2);
        }

        .input-group label {
            display: block;
            margin-bottom: 8px;
            color: var(--black);
            font-weight: 500;
        }

        .submit-btn {
            background: var(--yellow);
            color: var(--black);
            padding: 14px 0;
            width: 100%;
            border: none;
            border-radius: 8px;
            font-size: 1.1rem;
            cursor: pointer;
            transition: all 0.3s;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        .submit-btn:hover {
            background: #FFC000;
            box-shadow: 0 5px 15px rgba(255,215,0,0.3);
        }

        .form-links {
            text-align: center;
            margin-top: 1.5rem;
        }

        .form-links a {
            color: var(--black);
            text-decoration: none;
            font-weight: 500;
            transition: color 0.3s;
        }

        .form-links a:hover {
            color: var(--yellow);
        }

        /* Custom checkmark for terms */
        .terms-check {
            display: flex;
            align-items: center;
            gap: 10px;
            margin: 1rem 0;
        }

        .terms-check input[type="checkbox"] {
            accent-color: var(--yellow);
            width: 18px;
            height: 18px;
        }
    </style>
    <!-- Include Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
    <div class="form-card">
        <h2 class="form-title">Driver Registration</h2>
        
        <form action="driverReg" method="post">
            <div class="input-group">
                <label for="fullname"><i class="fas fa-user"></i> Full Name</label>
                <input type="text" id="fullName" name="fullName" placeholder="John Doe">
            </div>

            <div class="input-group">
                <label for="address"><i class="fas fa-id-card"></i> Address</label>
                <input type="text" id="address" name="address" placeholder="">
            </div>

            <div class="input-group">
                <label for="Phone"><i class="fas fa-car"></i> Phone Number</label>
                <input type="text" id="phoneNumber" name="phoneNumber" placeholder="XX-XXXXXXX">
            </div>

            <div class="input-group">
                <label for="email"><i class="fas fa-envelope"></i>Email</label>
                <input type="email" id="Email" name="Email" placeholder="john@gmail.com">
            </div>
            
            <div class="input-group">
                <label for="nic"><i class="fas fa-envelope"></i>NIC Number</label>
                <input type="text" id="nicNumber" name="nicNumber" placeholder="XXXXXXXXXXX">
            </div>
            
            <div class="input-group">
                <label for="lic"><i class="fas fa-envelope"></i>License Number</label>
                <input type="text" id="licNumber" name="licNumber" placeholder="XXXXXXXXXXX">
            </div>
            
            <div class="input-group">
                <label for="image"><i class="fas fa-envelope"></i>Upload License Card image </label>
                <input type="file" id="image" name="image" >
            </div>
            
             <div class="input-group">
                <label for="password"><i class="fas fa-envelope"></i>Password </label>
                <input type="password" id="password" name="password" placeholder"XXXXXXXXXXX">
            </div>
            

            

            <button type="submit" class="submit-btn">Register Now</button>
        </form>

        <div class="form-links">
            <a href="dlogin.jsp">Already have an account? Login</a>
        </div>
    </div>
</body>
</html>