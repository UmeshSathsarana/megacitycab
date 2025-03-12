<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
    <style>
        body {
            background-color: black;
            color: white;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: #222;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px yellow;
            text-align: center;
            width: 300px;
        }
        h2 {
            color: yellow;
        }
        label {
            font-size: 18px;
            color: yellow;
            display: block;
            margin: 10px 0 5px;
        }
        input {
            width: 90%;
            padding: 8px;
            margin: 5px 0 15px;
            border: 1px solid yellow;
            border-radius: 5px;
            background-color: black;
            color: white;
        }
        button {
            background-color: yellow;
            color: black;
            padding: 10px 20px;
            border: none;
            font-size: 18px;
            cursor: pointer;
            border-radius: 5px;
        }
        button:hover {
            background-color: white;
            color: black;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Admin Login</h2>
        <form action="adminLogin" method="post">
            <label>Email:</label>
            <input type="email" name="email" id="email" required><br>
            <label>Password:</label>
            <input type="password" name="password" id="password" required><br>
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
