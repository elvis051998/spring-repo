<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>



<script >
$(function() {
    $("form").submit(function(event) {
      event.preventDefault();
      let acno = $("#acno").val();
      let url = 'http://localhost:8080/spring-mvc/account-detail?acno='+acno;
      $.ajax({
          url : url,
          method : 'GET',
          success : function(data) {
              alert(JSON.stringify(data));
              let resultDiv = $("#result");
              resultDiv.append($("<p />").text("Account No " + data.acno));
              resultDiv.append($("<p />").text("Account holder name " + data.name));
              //$.each(data.passengers, function(passengers, index){
              for(let t of data.transactions) {
                 let p = $("<p />")
                 .html(" Account No " + t.acno +  "<br />"
                       +"Account Holder Name " + t.name + "<br />"
                 + "Type " + t.type + "<br />"
                 + "Balance " + t.balance + "<br />"
                 + "<hr />");
                 resultDiv.append(p);
              }
                  
              }
          
          })
        })
})
</script>
</head>
<body>



<form >
   Enter ACCOUNT No : <input id="acno" />
   <button type="submit">Check Status</button>
</form>
<div id="result"></div>



</body>
</html>