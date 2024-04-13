<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 250px; /* Increased width */
        }

        .login-container h2 {
            color: #333;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group input {
            width: calc(100% - 22px); /* Increased width */
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            outline: none;
        }

        .form-group input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        .form-group input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>

<body>
    <div class="login-container">
        <% 
		    // Check if 'error' attribute exists in session
		    String message = (String) session.getAttribute("message");
		    if (message != null) { 
		%>
		    <% if (message.equals("SUCCESS")) { %>
		        <h5 style="color:green">Login successfull</h5>
		    <% } else { %>
		        <h5 style="color:red">Error: <%= message %></h5>
		    <% } %>
		<% } %>
 
        <h2>Login Form</h2>
        
        <form action="admin-login" method="POST">
            <div class="form-group">
                <input type="text" name="username" placeholder="Username" required>
            </div>
            <div class="form-group">
                <input type="password" name="password" placeholder="Password" required>
            </div>
            <div class="form-group">
                <input type="submit" value="Login">
            </div>
        </form>
        
        
    </div>
</body>

</html>
