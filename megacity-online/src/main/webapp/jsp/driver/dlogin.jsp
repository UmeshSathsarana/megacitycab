<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <style>
      :root {
            --black: #000;
            --white: #fff;
            --yellow: #FFEB3B;
            --dark-bg: #1a1a1a;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', sans-serif;
            display: flex;
            min-height: 100vh;
        }

        .graphic-side {
            flex: 1;
            background: var(--dark-bg);
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 2rem;
        }

        .graphic-content {
            color: var(--white);
            text-align: center;
        }

        .graphic-content h2 {
            font-size: 2.5rem;
            margin-bottom: 1rem;
            color: var(--yellow);
        }

        .form-side {
            flex: 1;
            background: var(--white);
            padding: 4rem;
            display: flex;
            align-items: center;
        }

        .login-form {
            width: 100%;
            max-width: 400px;
            margin: 0 auto;
        }

        .form-title {
            color: var(--black);
            margin-bottom: 2.5rem;
        }

        .input-container {
            margin-bottom: 1.5rem;
            position: relative;
        }

        .input-container input {
            width: 100%;
            padding: 14px;
            border: 2px solid var(--black);
            border-radius: 8px;
            font-size: 1rem;
        }

        .input-container input:focus {
            border-color: var(--yellow);
            outline: none;
            box-shadow: 0 0 8px rgba(255,235,59,0.3);
        }

        .checkbox-container {
            margin: 1.5rem 0;
            display: flex;
            align-items: center;
            gap: 8px;
        }

        .checkbox-container input[type="checkbox"] {
            accent-color: var(--yellow);
        }

        .submit-btn {
            background: var(--yellow);
            color: var(--black);
            width: 100%;
            padding: 14px;
            border: none;
            border-radius: 8px;
            font-size: 1.1rem;
            cursor: pointer;
            transition: all 0.3s;
        }

        .submit-btn:hover {
            background: #FFD600;
        }

        .social-login {
            margin-top: 2rem;
            text-align: center;
        }

        .social-icons {
            display: flex;
            gap: 15px;
            justify-content: center;
            margin-top: 1rem;
        }

        .social-icon {
            width: 40px;
            height: 40px;
            border: 2px solid var(--black);
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            cursor: pointer;
            transition: all 0.3s;
        }

        .social-icon:hover {
            border-color: var(--yellow);
            color: var(--yellow);
        }

        @media (max-width: 768px) {
            body {
                flex-direction: column;
            }
            .graphic-side {
                padding: 2rem 1rem;
            }
            .form-side {
                padding: 2rem;
            }
        }
    </style>
</head>
<body>
    <div class="graphic-side">
        <div class="graphic-content">
            <h2>Welcome Back!</h2>
            <p>Driver Management System</p>
        </div>
    </div>
    
    <div class="form-side">
        <div class="login-form">
            <h1 class="form-title">Driver Login</h1>
            
            <form action="driverLogin" method="post">
                <div class="input-container">
                    <input type="Email" name="Email" placeholder="Email Address">
                </div>

                <div class="input-container">
                    <input type="password" name="password" placeholder="Password">
                </div>

                <div class="checkbox-container">
                    <input type="checkbox" id="remember">
                    <label for="remember">Remember me</label>
                </div>

                <button type="submit" class="submit-btn">Sign In</button>

                <div class="social-login">
                    <p>Or continue with</p>
                    <div class="social-icons">
                        <div class="social-icon"><i class="fab fa-google"></i></div>
                        <div class="social-icon"><i class="fab fa-facebook-f"></i></div>
                        <div class="social-icon"><i class="fab fa-twitter"></i></div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
<!-- Add Font Awesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</html>