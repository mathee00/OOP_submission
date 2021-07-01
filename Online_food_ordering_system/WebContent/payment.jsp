<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
</head>
<body>

<%
 	String username = (String)request.getSession().getAttribute("user");  
	String lastname = (String)request.getSession().getAttribute("lastname");

%>

   <form name="paymentForm" method="post" action="PaymentNewServlet">
		<div>
		<!-- Customer Name = <input type = "text" name = "custname"> <br> -->
		Customer first name = <input type = "text" name = "user" value = "${user}"> <br>
		Email = <input type = "text" name = "email">  <br>
		Payed date = <input type = "text" name = "date">  <br>
		Payment method = <input type = "text" name = "method">  <br>
		Amount = <input type = "Integer" name = "amount"> <br>
		</div>
		<div>
			<input type = "submit" value = "Pay">
		</div>
	</form>

	
<%-- 	<h1>Payment</h1>
	<h2>Hello ${user}!<br></h2>
	
	
	<div>
		First Name = ${user} <br>
		Last Name = ${lastname}
	</div> --%>
	
	
</body>
</html>