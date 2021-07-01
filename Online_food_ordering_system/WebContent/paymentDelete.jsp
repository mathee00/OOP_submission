<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 	String userId = (String)request.getSession().getAttribute("uid");  
	String Name = (String)request.getSession().getAttribute("name");
	String Email = (String)request.getSession().getAttribute("email");
	String Method = (String)request.getSession().getAttribute("method");
	String Amount = (String)request.getSession().getAttribute("amount");
	String Payed_date = (String)request.getSession().getAttribute("pay_date");
	
%>

<h1>Information to be deleted</h1>

	<form name="paymentForm" method="post" action="PaymentDeleteServlet">
		<div>
		Customer ID => ${uid} <br>
		Customer Name => ${name} <br>
		Email =>${email}  <br>
		Payed date => ${pay_date}<br>
		Payment method => ${method}<br>
		Amount =>  ${amount}<br>
		</div>
		<div>
			<input type = "submit" value = "Delete">
		</div>
	</form>
</body>
</html>