<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Welcome to our online store</h1>

	<form name="loginForm" method="post" action="LoginServlet">
		<div>
		UserName := <input type = "text" name = "username"> <br>
		Password := <input type = "text" name = "password"> <br>
		</div>
		<div>
			<input type = "submit" value = "submit">
		</div>
	</form>
</body>
</html>