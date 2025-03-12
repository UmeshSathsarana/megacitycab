<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login & Signup Form</title>
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap");
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Poppins", sans-serif;
        }
        body {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background: #1a1a1a;
        }
        .wrapper {
            position: relative;
            max-width: 470px;
            width: 100%;
            border-radius: 12px;
            padding: 20px 30px 120px;
            background: #ffd700;
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.3);
            overflow: hidden;
        }
        .form.login {
            position: absolute;
            left: 50%;
            bottom: -86%;
            transform: translateX(-50%);
            width: calc(100% + 220px);
            padding: 20px 140px;
            border-radius: 50%;
            height: 100%;
            background: #fff;
            transition: all 0.6s ease;
        }
        .wrapper.active .form.login {
            bottom: -15%;
            border-radius: 35%;
            box-shadow: 0 -5px 10px rgba(0, 0, 0, 0.2);
        }
        .form header {
            font-size: 30px;
            text-align: center;
            color: #000;
            font-weight: 600;
            cursor: pointer;
        }
        .form.login header {
            color: #333;
            opacity: 0.6;
        }
        .wrapper.active .form.login header {
            opacity: 1;
        }
        .wrapper.active .signup header {
            opacity: 0.6;
        }
        .wrapper form {
            display: flex;
            flex-direction: column;
            gap: 20px;
            margin-top: 40px;
        }
        form input {
            height: 60px;
            outline: none;
            border: 2px solid #000;
            padding: 0 15px;
            font-size: 16px;
            font-weight: 400;
            color: #000;
            border-radius: 8px;
            background: #fff;
        }
        form input::placeholder {
            color: #666;
        }
        .form.login form .checkbox {
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .checkbox input[type="checkbox"] {
            height: 16px;
            width: 16px;
            accent-color: #ffd700;
            cursor: pointer;
        }
        form .checkbox label {
            cursor: pointer;
            color: #000;
        }
        form a {
            color: #000;
            text-decoration: none;
        }
        form a:hover {
            text-decoration: underline;
        }
        form input[type="submit"] {
            margin-top: 15px;
            padding: none;
            font-size: 18px;
            font-weight: 500;
            cursor: pointer;
            background: #000;
            color: #ffd700;
            border: none;
            transition: all 0.3s ease;
        }
        form input[type="submit"]:hover {
            background: #333;
        }
        .login-link {
            text-align: center;
            margin-top: 20px;
            color: #000;
            font-size: 16px;
        }
        .login-link a {
            color: #000;
            font-weight: 600;
            text-decoration: none;
            margin-left: 8px;
        }
        .login-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <section class="wrapper">
        <div class="form signup">
            <header>Signup</header>
            <form action="customerReg" method="post">
                <input type="text" id="fullName" name="fullName" placeholder="Full name" required />
                <input type="text" id="NicNumber" name="NicNumber" placeholder="Nic Number" required />
                <input type="text" id="adress" name="address" placeholder="Address" required />
                <input type="text" id="phoneNumber" name="phoneNumber" placeholder="phonenumber" required />
                <input type="email" id="Email" name="Email" placeholder="Email address" required />
                <input type="password" id="Password" name="Password" placeholder="Password" required />
                <input type="submit" value="Signup" />
            </form>
            <div class="login-link">
                Already have an account? <a href="login.jsp">Login</a>
            </div>
        </div>
    </section>
</body>
</html>