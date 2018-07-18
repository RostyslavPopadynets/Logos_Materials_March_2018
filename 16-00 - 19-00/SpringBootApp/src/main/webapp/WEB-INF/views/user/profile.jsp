<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User profile</title>
</head>
<body>
	
	User info: <br>
	- id: ${ userProfile.id } <br>
	- first name: ${ userProfile.firstName } <br>
	- last name: ${ userProfile.lastName } <br>
	- email: ${ userProfile.email } <br>
	
	<a href="/users/list">Back</a>
</body>
</html>