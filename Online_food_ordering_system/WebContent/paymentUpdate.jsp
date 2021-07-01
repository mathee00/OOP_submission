<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Here</title>
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

	<form name="paymentForm" method="post" action="PaymentUpdateServlet">
		<div>
		Customer ID = <input type = "text" name = "user" value = "${uid}"> <br>
		Customer Name = <input type = "text" name = "lastname" value = "${name}"> <br>
		Email = <input type = "text" name = "email" value = "${email}">  <br>
		Payed date = <input type = "text" name = "date" value = "${pay_date}">  <br>
		Payment method = <input type = "text" name = "method">  <br>
		Amount = <input type = "Integer" name = "amount"> <br>
		</div>
		<div>
			<input type = "submit" value = "Save">
		</div>
	</form>

</body>
</html>