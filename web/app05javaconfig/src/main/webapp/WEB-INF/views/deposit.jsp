<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>Champ bank application</title>
</head>
<body>
<form:form action="deposit" method="post" modelAttribute="depositDto">
	Enter account Id:<form:input path="accId"/><br/>
	Enter money to deposit:<form:input path="amount"/><br/>
	<input type ="submit"/>
</form:form>
</body>
</html>