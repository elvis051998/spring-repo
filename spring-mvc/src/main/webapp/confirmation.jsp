<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Your acc no. is :<h2>${ result }</h2>

<h1>Transfer money</h1>
<form method="post" action="transfer">
	From account no: <input name = "fromAcc" ${ result }><br />
	To account no: <input name = "toAcc" ><br />
	Amount: <input name = "amount" ><br />
	
	<button type="submit">SEND</button>
</form>


</body>
</html>