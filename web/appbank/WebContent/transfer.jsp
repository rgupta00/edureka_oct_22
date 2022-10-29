<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fund transfer application</title>
</head>
<body>
<form action="transfer" method="post">
	Enter from Acc id : <input type="text" name ="fromId"><br/>
	Enter to Acc id : <input type="text" name ="toId"><br/>
	Enter Amout to transfer : <input type="text" name ="amount"><br/>
	<input type="submit">
</form>
</body>
</html>