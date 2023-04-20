<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
	<h1>Customers List</h1>
	<button class="btn btn-info" type="button" onclick="location.href='/test/customers/save'">고객 등록하기</button>
	<c:if test="${param.deleteStatus }">
		<h5>삭제 성공</h5>
	</c:if>
	<div>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>CustomerName</th>
					<th>ContactName</th>
					<th>Address</th>
					<th>City</th>
					<th>PostalCode</th>
					<th>Country</th>
					<th>edit</th>
					<th>delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customers }" var="c">
					<tr>
						<td>${c.id }</td>
						<td>${c.name }</td>
						<td>${c.contactName }</td>
						<td>${c.address }</td>
						<td>${c.city }</td>
						<td>${c.postalCode }</td>
						<td>${c.country }</td>
						<td><button type="button" onclick="location.href='/test/customers/${c.id}/edit'">수정</button></td>
						<td><button id="deleteButton" type="button" onclick="location.href='/test/customers/${c.id}/delete'">삭제</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script>
		$("#deleteButton").click(function () {
			let result = confirm("삭제?");
			console.log(result);
			if (result) {
				onclick="location.href='/test/customers/${c.id}/delete'";
			} else {
				onclick="location.href='/test/customers'";
			}
		});
	</script>
	
	
</body>
</html>