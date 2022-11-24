<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.js" ></script>
<script>
$(function(){
	$("form").submit(function(event){
		event.preventDefault();
		let pnrNo = $("#pnrNo").val();
		let url = 'http://localhost:8090/spring-mvc/pnr-status?pnrNo=' + pnrNo;
		$.ajax({
			url : url,
			method : 'GET',
			success : function(data) {
				let resultDiv = $('#result');
				resultDiv.append($("<p />").text("Train No " + data.trainNo));
				resultDiv.append($("<p />").text("Travel Date " + data.travelDate));
				//$.each(data.passenger, function(index, passenger))
				for(let passenger of data.passenger) {
					let p = $("<p />")
									.html("Passenger Name " + passenger.name + "<br />"
									  + "Gender " + passenger.gender + "<br />"
									  + "Status " + passenger.status + "</br >" 
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
	<form>
		Enter PNR No: <input id="pnrNo" />
		<button type="submit">Check Status</button>
	</form>
	<div id="result"></div>
</body>
</html>