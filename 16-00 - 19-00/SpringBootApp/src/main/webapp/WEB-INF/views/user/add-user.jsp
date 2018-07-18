<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add user form</title>
</head>
<body>
	
	<form method="POST" action="/users/add-user-save">
		First Name: <input type="text" name="first"> <br>
		Last Name: <input type="text" name="last"> <br>
		Email: <input type="email" name="email"> <br>
		
		<!-- <input type="submit" value="Add user"> -->
		<button type="submit">Add user</button>
	</form>
</body>
</html>