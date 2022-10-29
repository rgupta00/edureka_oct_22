<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Champ bank application</title>
</head>
<body>
<form:form action="transfer" method="post" modelAttribute="transferDto">
	Enter from account:<form:input path="fromAccId"/><br/>
	Enter to amount:<form:input path="toAccId"/><br/>
	Enter money to transfer:<form:input path="amount"/><br/>
	<input type ="submit"/>
</form:form>

</body>
</html>