<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/static/bootstrap/css/bootstrap.css'/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/static/font-awesome/css/font-awesome.css'/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/static/fancytree/css/ui.fancytree.css'/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/static/huaguo/css/nav.css'/>"></link>
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
				<li><a href="<c:url value='/home'/>"><i class="fa fa-home"></i>花果金融</a></li>
				<li>系统管理</li>
				<li class="active">菜单管理</li>
			</ol>
			<div class="container-fluid">
				<div class="row">
					<div class="col-xs-12">
						<div class="btngroup">
							<button id="createMenuBtn" role="button" class="btn btn-primary">创建</button>
							<button id="modifyMenuBtn" role="button" class="btn btn-primary">修改</button>
							<button id="deleteMenuBtn" role="button" class="btn btn-primary">删除</button>
						</div>
						<div class="widget-box">
							<div id="menu-tree"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			
		</div>
		
	</div>
	<div id="dialog" class="modal fade modal-wrapper" role="dialog" aria-labelledby="dialogTitle">
		<div class="modal-dialog">
			<div class="modal-content">
			</div>
		</div>
	</div>
	<script src="<c:url value='/static/js/jquery-1.10.2.js'/>"></script>
	<script src="<c:url value='/static/bootstrap/js/bootstrap.js'/>"></script>
	<script src="<c:url value='/static/jqueryui/jquery-ui-1.10.4.custom.min.js'/>"></script>
	<script src="<c:url value='/static/fancytree/jquery.fancytree-all.min.js'/>"></script>
	<script src="<c:url value='/static/huaguo/js/nav.js'/>"></script>
	<script src="<c:url value='/static/huaguo/modal.js'/>"></script>
	<script type="text/javascript">
	$(function() {
		$("#navtest").hgNav(${NAV_DATA}, "<%=request.getContextPath()%>");
		var tree = $("#menu-tree").fancytree({
			checkbox : false,
			selectMode : 1,
			source : ${menuFancyTreeJson},
			activate : function(event, data) {
				
			}
		}); 
		
		$("#createMenuBtn").click(function() {
			var activeNode = tree.fancytree("getActiveNode");
			$.hgModal({remote : "<c:url value='/system/menu/create'/>"});
		});
		$("#modifyMenuBtn").click(function() {
			var activeNode = tree.fancytree("getActiveNode"),
				key;
			if(activeNode != null) {
				key = activeNode.key;
				$.hgModal({remote : "<c:url value='/system/menu/modify/'/>" + key});
			} else {
				alert("请选择要修改的菜单");
			}
		});
		$("#deleteMenuBtn").click(function() {
			var activeNode = tree.fancytree("getActiveNode"),
				key;
			if(activeNode != null) {
				key = activeNode.key;
				$.ajax({
					url : "<c:url value='/system/menu/delete'/>",
					type : "post",
					data : {id : key},
					success : function() {
						window.location.reload(true);
					}
				});
			} else {
				alert("请选择要删除的菜单");
			}
		});
	})
	</script>
</body>
</html>