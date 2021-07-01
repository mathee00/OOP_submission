<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Welcome to our online store</h1>
	
	<form name="loginForm" method="post" action="LoginServlet">
		<div>
		UserName := <input type = "text" name = "username"> <br>
		Password := <input type = "text" name = "password">
		</div>
		<div>
			<input type = "submit" value = "submit">
		</div>
	</form>
	
	
	<!-- 	<form name="loginForm" action="loginServlet">
		<div>
		UserName := <input type = "text" name = "username">
		Password := <input type = "text" name = "password"> 
		</div>
		<div>
			<input type = "submit" value = "submit">
		</div>
	</form> -->
</body>
</html>