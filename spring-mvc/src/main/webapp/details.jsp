<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Enter the Account Number To View the Details</h1>



<body>
<form method="post" action="detail">
Account no <input name="accNo"/></br>
<button type="submit">Submit</button>
</form>
<c:if test="${AccountNumber !=null }">
    <h1>Account Details:-</h1>
    Account No:${AccountNumber.acno }</br>
    Account Name:${AccountNumber.name }</br>
    Account Type:${AccountNumber.type }</br>
    Account Balance:${AccountNumber.balance }</br></br>
    
    <h1>Transaction Details:-</h1>
    <table>
        <tr>
            <th>Transaction No</th>
            <th>Amount</th>
            <th>Date And Time</th>
            <th>Transaction Type</th>
        </tr>
        <c:forEach items="${AccountNumber.transaction }" var="t">
            <tr>
                <td>${t.txno }</td>
                <td>${t.amount }</td>
                <td>${t.date }</td>
                <td>${t.type }</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
	

</form>
</body>
</html>