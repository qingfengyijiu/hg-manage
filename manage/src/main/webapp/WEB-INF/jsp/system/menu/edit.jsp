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
<style type="text/css">
.modal-wrapper{
      display: table;
      height: 100%;
      margin: 0px auto;
}
.modal-dialog{
	display: table-cell;
	vertical-align: middle;
}
</style>
</head>
<body>
	<div class="modal-header">
		<button id="dialogCloseBtn" type="button" class="close" data-dismiss="modal" aria-lable="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title" id="dialogTitle">新建菜单</h4>
	</div>
	<div class="modal-body container-fluid">
		<form class="form form-horizontal">
			<div class="form-group">
				<label>label1</label>
				<input type="text"/>
			</div>
			<div class="form-group">
				<label>label1</label>
				<input type="text"/>
			</div>
			<div class="form-group">
				<label>label1</label>
				<input type="text"/>
			</div>
			<div class="form-group">
				<label>label1</label>
				<input type="text"/>
			</div>
		</form>
	</div>
	<div class="modal-footer">
		<button></button>
	</div>
	<script src="<c:url value='/static/js/jquery-1.10.2.js'/>"></script>
	<script src="<c:url value='/static/bootstrap/js/bootstrap.js'/>"></script>
	<script type="text/javascript">
	</script>
</body>
</html>