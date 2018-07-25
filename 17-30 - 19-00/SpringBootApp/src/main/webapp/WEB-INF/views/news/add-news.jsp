<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- add-news  -->
	
	<form method="POST" action="/news/add">
		News title: <input type="text" name="title"> <br>
		News description: <textarea rows="5" cols="20" name="description"></textarea>
		
		<!-- <input type="submit" value="Add news"> -->
		<button type="submit">Add news</button>
	</form>
	
</body>
</html>