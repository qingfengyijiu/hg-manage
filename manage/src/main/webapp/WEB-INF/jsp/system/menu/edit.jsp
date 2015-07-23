<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="modal-header">
		<button id="dialogCloseBtn" type="button" class="close" data-dismiss="modal" aria-lable="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title" id="dialogTitle">新建菜单</h4>
	</div>
	<div class="modal-body container-fluid">
		<form:form class="form form-horizontal" modelAttribute="menu" method="post">
			<form:hidden path="id"/>
			<div class="form-group">
				<form:label path="key" class="control-label col-sm-2">菜单代号</form:label>
				<div class="col-sm-10">
					<form:input path="key" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<form:label path="title" class="control-label col-sm-2">菜单名称</form:label>
				<div class="col-sm-10">
					<form:input path="title" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<form:label path="href" class="control-label col-sm-2">路径</form:label>
				<div class="col-sm-10">
					<form:input path="href" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<form:label path="parent" class="control-label col-sm-2">父菜单</form:label>
				<div class="col-sm-10">
					<form:select path="parent" items="${abstractMenuList}" itemLabel="title" itemValue="id">
					</form:select>
				</div>
			</div>
		</form:form>
	</div>
	<div class="modal-footer">
		<button id="cancelCreateMenu" type="button" class="btn btn-default">取消</button>
		<button id="doCreateMenu" type="button" class="btn btn-primary">确定</button>
	</div>
	<script type="text/javascript">
		$("#cancelCreateMenu").on("click", function() {
			$("#dialogCloseBtn").click();
		});
		$("#doCreateMenu").on("click", function() {
			var menu = {
				id : $("#id").val(),
				key : $("#key").val(),
				title : $("#title").val(),
				href : $("#href").val(),
				menuLevel : $("#menuLevel").val(),
				parent : {id : $("#parent").val()}
			}
			$.ajax({
				type : "post",
				url : "<c:url value='/system/menu/create/do'/>",
				data : JSON.stringify(menu),
				contentType : "application/json;charset=UTF-8",
				dataType : "json",
				success : function() {
					$("#dialogCloseBtn").click();
				}
			});
		});
	</script>
</body>
</html>