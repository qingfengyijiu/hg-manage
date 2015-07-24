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
<link rel="stylesheet" type="text/css" href="<c:url value='/static/huaguo/css/nav.css'/>"/>
</head>
<body>
	<div class="container" style="background:none;">
		<div id="header" style="position:relative;height:80px;width:100%;">
			<div style="">
				<span id="logo">logo</span>
				<span>花果金融</span>
			</div>
		</div>
		<div id="navbar" style="width:205px;position:relative;float:left;">
			<nav class="huaguo-nav">
				<ul id="navtest">
				</ul>
			</nav>
		</div>
			
		<div id="content" class="helper-clearfix" style="position:relative;margin-left:205px;width:auto;margin-right:0;min-height:500px;">
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-home"></i>花果金融</a></li>
				<li class="active">首页</li>
			</ol>
			<div class="container-fluid">
				<div class="row">
					<div class="col-xs-12">
						<div class="alert alert-info">
							欢迎使用<strong>花果金融业务管理平台</strong>
							<a class="close" data-dismiss="alert" href="#">x</a>
						</div>
						<div class="widget-box">
							test
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<nav class="huaguo-nav">
				<ul id="navtest"></ul>
			</nav>
			
		</div>
		<div id="userNav"></div>
	</div>
	<script src="<c:url value='/static/js/jquery-1.10.2.js'/>"></script>
	<script src="<c:url value='/static/bootstrap/js/bootstrap.js'/>"></script>
	<script src="<c:url value='/static/huaguo/js/nav.js'/>"></script>
	<script type="text/javascript">
	$(function() {
		$("#navtest").hgNav(${NAV_DATA}, "<%=request.getContextPath()%>");
	})
	</script>
</body>
</html>