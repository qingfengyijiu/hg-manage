<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/static/bootstrap/css/bootstrap.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/static/font-awesome/css/font-awesome.css'/>"/>
<style type="text/css">
.nav li {
	float:none;
}
nav.huaguo-nav {
	width:100px;
	height:100%;
	background:lightblue;
}
nav.huaguo-nav ul {
	list-style-image:none;
	list-style-type:none;
	padding:0;
	font-size:18px;
}
nav.huaguo-nav ul ul {
	display:none;
	padding-left:15px;
	font-size:16px;
}
nav.huaguo-nav ul ul ul {
	font-size:14px;
}
</style>
</head>
<body>
	<div class="container" style="background:none;">
		<div id="header" style="position:relative;height:80px;width:100%;">
			<div style="">
				<span id="logo">logo</span>
				<span>花果金融</span>
			</div>
		</div>
		<div id="content" style="height:600px;width:100%;border:1px solid red;">
			<div id="content-menu" style="height:100%;">
				<nav class="huaguo-nav">
					<ul>
						<li class="active"><a href="#">首页</a></li>
						<li class="has-children">
							<a href="#">债权管理</a><span class="arrow fa fa-chevron-right" style="font-size:14px;"></span>
							<ul>
								<li class="has-children">
									<a href="#">债权管理</a>
									<ul>
										<li><a href="#">新建债权</a></li>
										<li><a href="#">编辑债权</a></li>
										<li><a href="#">查询债权</a></li>
									</ul>
								</li>
								<li><a href="#">编辑债权</a></li>
								<li><a href="#">查询债权</a></li>
							</ul>
						</li>
						<li><a href="#">债权管理</a><span class="arrow fa fa-chevron-left" style="transform:rotate(90deg);font-size:14px;"></span></li>
						<li><a href="#">债权管理</a></li>
						<li><a href="#">债权管理</a></li>
						<li><a href="#">债权管理</a></li>
						<li><a href="#">债权管理</a></li>
						<li><a href="#">债权管理</a></li>
						<li><a href="#">债权管理</a></li>
					</ul>
				</nav>
			</div>
			<div id="content-body">
				
			</div>
		</div>
		<div id="footer"></div>
		<div id="userNav"></div>
	</div>
	<script src="<c:url value='/static/js/jquery-1.10.2.js'/>"></script>
	<script src="<c:url value='/static/bootstrap/js/bootstrap.js'/>"></script>
	<script type="text/javascript">
	$(function() {
		$(".huaguo-nav li.has-children").on("click", function() {
			$(this).children("ul:first").show();
		});
	})
	</script>
</body>
</html>