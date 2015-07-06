<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/static/bootstrap/css/bootstrap.css'/>"/>
</head>
<body style="background:gray;">
	<div class="container">
		<div id="loginBox" style="border-radius:8px;background:white;padding:20px;width:400px;height:260px;margin-top:200px;margin-left:auto;margin-right:auto;">
			<form action="<c:url value='/login'/>" method="POST" class="form">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<div class="form-group text-center">
					<p>请输入用户名和密码</p>
				</div>
				<div class="form-group">
					<label for="username" class="control-label sr-only">username:</label>
					<div class="input-group">
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-user"></span>
						</span>
						<input id="username" name="username" class="form-control" type="text"/>
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="control-label sr-only">password:</label>
					<div class="input-group">
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-lock glyphicon-lg"></span>
						</span>
						<input id="password" name="password" class="form-control" type="password"/>
					</div>
				</div>
				<div class="form-group">
					<input type="submit" value="登录" class="btn btn-success btn-lg btn-block" role="button"/>
				</div>
				<div class="form-group">
					<div class="clearfix" style="float:right;">
						<button id="register" role="button" class="btn btn-primary btn-sm" style="margin-left:10px;">申请成为管理员</button>
					</div>
				</div>
			</form>
			<div class="error-info-zone clearfix">
				<div class="error-info text-center">
					${SPRING_SECURITY_LAST_EXCEPTION.message}
				</div>
			</div>
		</div>
		
	</div>
	
	
	<script src="<c:url value='/static/js/jquery-1.10.2.js'/>"></script>
	<script src="<c:url value='/static/bootstrap/js/bootstrap.js'/>"></script>
</body>
</html>