<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="/users/add-user">Go to Add user Form</a>
	
	<br><br>
	
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Profile</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ usersListFromDB }" var="user">
				<tr>
					<td>${ user.id }</td>
					<td>${ user.firstName }</td>
					<td>${ user.lastName }</td>
					<td>${ user.email }</td>
					<td><a href="/users/profile/${ user.id }?user_email=${user.email}">show</a></td>
					<td><a href="/users/delete/${ user.id }">delete</a></td>
				</tr>				
			</c:forEach>
		</tbody>
	</table>
</body>
</html>