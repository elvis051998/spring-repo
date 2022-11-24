<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Create Account</h1>
<form method="post" action="openAccount">
	Enter your name: <input name= "name"/><br/>
	Account type:
	<select name="type">
	<option value="Savings">Savings</option>
	<option value="Current">Current</option>
	</select><br/>
	Initial Balance : <input name ="balance"><br/>
	
	<button type="submit">Open Account</button>
</form>
</body>
</html>