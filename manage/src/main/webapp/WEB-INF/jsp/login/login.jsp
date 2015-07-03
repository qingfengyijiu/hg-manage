<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/static/bootstrap/css/bootstrap.css'/>"/>
</head>
<body>
			<button type="button" class="close" aria-label="Close"><span>&times;</span></button>
	<address>fdsfdsf终于能够</address>
	
	<abbr title="test">test</abbr>
	<dl class="dl-horizontal">
	  <dt>Coffee</dt>
	  <dd>Black hot drink</dd>
	  <dd>Red hot drink</dd>
	  <dt>Milk</dt>
	  <dd>White cold drink</dd>
	  <dd>Yellow cold drink</dd>
	</dl>
	
	<form action="<c:url value='/login'/>" method="POST">
		<label class="text-uppercase text-primary">username :</label> <input id="username" name="username"/>
		password : <input id="password" type="password" name="password"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="submit"/>
	</form>
	${SPRING_SECURITY_LAST_EXCEPTION.message}
</body>
</html>