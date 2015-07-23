<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
</head>
<body>
	<div class="modal-header">
		<button id="dialogCloseBtn" type="button" class="close" data-dismiss="modal" aria-lable="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<h4 class="modal-title" id="dialogTitle">新建用户</h4>
	</div>
	<div class="modal-body container-fluid">
		<form:form modelAttribute="user"  class="form form-horizontal" method="post">
			<div class="form-group">
				<form:label path="username" class="control-label col-sm-2">用户名</form:label>
				<div class="col-sm-10">
					<form:input path="username" type="text" class="form-control"/>
					<form:errors path="username"></form:errors>
				</div>
			</div>
			<div class="form-group">
				<form:label path="password" class="control-label col-sm-2">密码</form:label>
				<div class="col-sm-10">
					<form:input path="password" type="password" class="form-control"/>
					<form:errors path="password"></form:errors>
				</div>
				
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="passwordAgain">重复密码</label>
				<div class="col-sm-10">
					<input type="text" id="passwordAgain" name="passwordAgain" class="form-control"/>
				</div>
				
			</div>
			<div class="form-group">
				<div class="col-sm-2"></div>
				<div class="col-sm-5 checkbox">
					<label>
						<form:checkbox path="accountNonExpired"/>有效
					</label>
				</div>
				<div class="col-sm-5 checkbox">
					<label>
						<form:checkbox path="accountNonLocked"/>解锁
					</label>
				</div>
				
				<%-- <form:label path="accountNonExpired" class="control-label col-sm-2">有效</form:label>
				<div class="col-sm-10">
					<form:checkbox path="accountNonExpired"/>
					<form:errors path="accountNonExpired"></form:errors>
				</div> --%>
			</div>
			<div class="form-group">
				<div class="col-sm-2"></div>
				<div class="col-sm-5 checkbox">
					<label>
						<form:checkbox path="credentialsNonExpired"/>密码有效
					</label>
				</div>
				<div class="col-sm-5 checkbox">
					<label>
						<form:checkbox path="enabled"/>激活
					</label>
				</div>
			</div>
			<div class="form-group">
				<table id="userList" data-pager="userListPager" data-role="hggrid" data-height=250 data-datatype="local" data-multiselect=true data-caption="角色" data-localdata='${roleList}'>
					<thead>
						<tr>
							<th data-name="id" data-index="id" data-width="60" data-sorttype="string">id</th>
							<th data-name="username" data-index="username" data-width="60" data-sorttype="string">username</th>
							<th data-name="accountNonExpired" data-index="accountNonExpired" data-width="60" data-formatter="testFormatter" data-formatter-custom=true>accountNonExpired</th>
							<th data-name="accountNonLocked" data-index="accountNonLocked" data-width="60" data-formatter="testFormatter" data-formatter-custom=true>accountNonLocked</th>
							<th data-name="credentialsNonExpired" data-index="credentialsNonExpired" data-width="60" data-formatter="testFormatter" data-formatter-custom=true>credentialsNonExpired</th>
							<th data-name="enabled" data-index="enabled" data-width="60" data-formatter="testFormatter" data-formatter-custom=true>enabled</th>
						</tr>
					</thead>
				</table>
			</div>
		</form:form>
	</div>
	<div class="modal-footer">
		<button></button>
	</div>
	<script src="<c:url value='/static/jqueryui/jquery-ui-1.10.4.custom.js'/>"></script>
	<script src="<c:url value='/static/jqgrid/jquery.jqGrid.js'/>"></script>
	<script src="<c:url value='/static/huaguo/grid.js'/>"></script>
</body>
</html>

