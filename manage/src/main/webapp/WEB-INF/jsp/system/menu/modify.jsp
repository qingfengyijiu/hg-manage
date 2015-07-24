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
					<form:select path="parent" class="form-control" >
						<option value=""></option>
						<c:forEach items="${abstractMenuList}" var="abstractMenu">
							<option value="${abstractMenu.id}" data-menu-level=${abstractMenu.menuLevel}>${abstractMenu.title}</option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<form:label path="description" class="control-label col-sm-2">描述</form:label>
				<div class="col-sm-10">
					<form:input path="description" class="form-control"/>
				</div>
			</div>
		</form:form>
	</div>
	<div class="modal-footer">
		<button id="cancelModifyMenu" type="button" class="btn btn-default">取消</button>
		<button id="doModifyMenu" type="button" class="btn btn-primary">确定</button>
	</div>
	<script type="text/javascript">
		var parentId = '${menu.parent.id}';
		$("select#parent option").each(function() {
			var _this = $(this);
			if(_this.val() == parentId) {
				_this.prop("selected", true);
			}
		});
		$("#cancelModifyMenu").on("click", function() {
			$("#dialogCloseBtn").click();
		});
		$("#doModifyMenu").on("click", function() {
			var selectedParentView,
				parentMenuLevel,
				menuLevel,
				menu;
			selectedParentView = $("#parent option:selected");
			parentMenuLevel = selectedParentView.data("menu-level");
			if(parentMenuLevel == null || parentMenuLevel === "") {
				menuLevel = 1;
			} else {
				menuLevel = Number(parentMenuLevel) + 1;
			}
			menu = {
				id : $("#id").val(),
				key : $("#key").val(),
				title : $("#title").val(),
				href : $("#href").val(),
				menuLevel : menuLevel,
				description : $("#description").val(),
				parent : {id : $("#parent").val()}
			}
			$.ajax({
				type : "post",
				url : "<c:url value='/system/menu/modify/do'/>",
				data : JSON.stringify(menu),
				contentType : "application/json",
				dataType : "json",
				success : function() {
					$("#dialogCloseBtn").click();
					window.location.reload();
				}
			});
		});
	</script>
</body>
</html>