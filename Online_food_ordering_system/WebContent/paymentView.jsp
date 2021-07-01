<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Details</title>
</head>
<body>
<%
 	String userID = (String)request.getSession().getAttribute("id");  
	String Name = (String)request.getSession().getAttribute("name");
	String email = (String)request.getSession().getAttribute("email");
	String date = (String)request.getSession().getAttribute("date");
	String method = (String)request.getSession().getAttribute("method");
	String amount = (String)request.getSession().getAttribute("amount");
%>

<h1>Payment Details of ${name}</h1>

		Customer ID :=  ${id} <br>
		Customer Name :=  ${name} <br>
		Customer Email := ${email} <br>
		Amount = ${amount} <br>
		Payment method :=  ${method} <br>
		Payed date :=  ${date} <br>
		
	<form name="Update_or_Delete_Form" method = "post" action="UpdateInfoServlet">
		<div>
			<input type = "submit" value = "Update">
		</div>
	</form>
	
	
	<form name="Update_or_Delete_Form" method = "post" action="DeleteInfoServlet">
		<div>
			<input type = "submit" value = "Delete">
		</div>
	</form>

				 
</body>
</html>