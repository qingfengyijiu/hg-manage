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
<link rel="stylesheet" type="text/css" href="<c:url value='/static/jqueryui/jquery-ui.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/static/jqgrid/ui.jqgrid.css'/>"/>
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
					<li class="active"><a href="#">首页</a></li>
				</ul>
			</nav>
		</div>
			
		<div id="content" class="helper-clearfix" style="position:relative;margin-left:205px;width:auto;margin-right:0;min-height:500px;">
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-home"></i>花果金融</a></li>
				<li class="active">用户管理</li>
			</ol>
			<div class="container-fluid">
				<div class="row">
					<div class="col-xs-12">
						<div class="btngroup">
							<button id="create" class="btn btn-primary" role="button">新建</button>
							<button id="modify" class="btn btn-primary" role="button">修改</button>
							<button id="delete" class="btn btn-primary" role="button">删除</button>
						</div>
						<div class="widget-box">
							<table id="userList" data-pager="userListPager" data-role="hggrid" data-height=250 data-datatype="local" data-multiselect=true data-caption="Test" data-localdata='${userList}'>
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
							<div id="userListPager" data-total=${pager.totalPage} data-current=${pager.currentPageNo}></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			
		</div>
		<div id="userNav"></div>
	</div>
	<script src="<c:url value='/static/js/jquery-1.10.2.js'/>"></script>
	<script src="<c:url value='/static/jqueryui/jquery-ui-1.10.4.custom.js'/>"></script>
	<script src="<c:url value='/static/bootstrap/js/bootstrap.js'/>"></script>
	<script src="<c:url value='/static/jqgrid/jquery.jqGrid.js'/>"></script>
	<script src="<c:url value='/static/huaguo/nav.js'/>"></script>
	<script src="<c:url value='/static/huaguo/grid.js'/>"></script>
	<script src="<c:url value='/static/huaguo/modal.js'/>"></script>
	<script type="text/javascript">
	$(function() {
		var data2 = [{title:"菜单管理", url :"<c:url value='/system/menu/'/>", children : []}];
		var data1 = [{title:"test11", children : [], url:"http://www.baidu.com"}, {title:"test12", children : [], url:"http://www.sina.com.cn"}];
		var data = [{title:"债权管理", children : data1, url:"#"}, {title:"系统管理", children : data2, url:"#"}];
		$("#navtest").hgNav(data);
		$("#create").click(function() {
			$.hgModal({remote : "<c:url value='/security/user/create'/>"});
		});
		$("#modify").click(function() {
			$.hgModal({remote : "<c:url value='/security/user/modify/1'/>"});
		});
	});
	function testFormatter(cellvalue, options, rowObject) {
		if(cellvalue == 0) {
			return "否";
		} else {
			return "是";
		}
	}
	</script>
</body>
</html>