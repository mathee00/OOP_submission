<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Your Payment is Successful!</h1>

	Customer Name :=  ${first_name} <br>
	Customer Email := ${email} <br>
	Amount = ${amount} <br>
	Payed date :=  ${pay} <br>
	Payment method :=  ${method} <br>
	
	
	<form name="loginForm" method = "post" action="PaymentViewServlet">
		<div>
			<input type = "submit" value = "View payment">
		</div>
	</form>
	
</body>
</html>