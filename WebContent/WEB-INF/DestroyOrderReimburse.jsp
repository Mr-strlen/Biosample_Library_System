<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>生物样本库管理系统-记录报销</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath%>static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="<%=basePath%>static/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="<%=basePath%>static/css/theme.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body style="padding-top: 0px;" data-spy="scroll" data-target="#myScrollspy">
	<!-- Fixed navbar -->
    <jsp:include page="navbar.jsp" flush="true"/>

	<div class="container theme-showcase" role="main">
        <div class="col-xs-2" id="myScrollspy">
            <ul class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="70">
                <li class="active"><a href="#table-1">已完成记录</a></li>
                <li><a href="#table-2">报销中记录</a></li>
                <li><a href="#table-3">已报销记录</a></li>
            </ul>
        </div>
        <div id="tables" class="col-xs-10">	
			<p id="table-1" style="height: 50px;"></p>
			<div class="panel panel-default">
  			<!-- Default panel contents -->
  			<div class="panel-heading">已完成记录</div>
  			<!-- Table -->
  			<table class="table table-hover">
  				<tr>
					<th style="text-align:center;">记录编号</th>
					<th style="text-align:center;">申请用户</th>
					<th style="text-align:center;">执行人</th>
					<th style="text-align:center;">状态</th>
					<th style="text-align:center;">记录创建时间</th>
					<th style="text-align:center;">记录内容</th>
				</tr>
				<c:forEach items="${unreimburseddestroy}" var="node">
					<tr>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.id}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.user}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.buyer}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.state}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.time}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;">
							<button type="button" class="btn btn-primary btn-sm" onclick="javascript:window.location.href='<%=basePath%>destroy/ordercontent?id=${node.id}&type=4';">
	  							<span class="glyphicon glyphicon-usd" aria-hidden="true"></span>&nbsp;报销
							</button>
						</td>
					</tr>
	   			</c:forEach>
  			</table>
			</div>
			
			<p id="table-2" style="height: 50px;"></p>
			<div class="panel panel-default">
  			<!-- Default panel contents -->
  			<div class="panel-heading">报销中记录</div>
  			<!-- Table -->
  			<table class="table table-hover">
  				<tr>
					<th style="text-align:center;">记录编号</th>
					<th style="text-align:center;">申请用户</th>
					<th style="text-align:center;">销毁员</th>
					<th style="text-align:center;">状态</th>
					<th style="text-align:center;">记录创建时间</th>
					<th style="text-align:center;">记录内容</th>
				</tr>
				<c:forEach items="${reimbursingdestroy}" var="node">
					<tr>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.id}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.user}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.buyer}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.state}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.time}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;">
							<button type="button" class="btn btn-default btn-sm" onclick="javascript:window.location.href='<%=basePath%>destroy/ordercontent?id=${node.id}&type=5';">
	  							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;查看
							</button>
						</td>
					</tr>
	   			</c:forEach>
  			</table>
			</div>
			
			<p id="table-3" style="height: 50px;"></p>
			<div class="panel panel-default">
  			<!-- Default panel contents -->
  			<div class="panel-heading">已报销记录</div>
  			<!-- Table -->
  			<table class="table table-hover">
  				<tr>
					<th style="text-align:center;">记录编号</th>
					<th style="text-align:center;">申请用户</th>
					<th style="text-align:center;">销毁员</th>
					<th style="text-align:center;">状态</th>
					<th style="text-align:center;">记录创建时间</th>
					<th style="text-align:center;">记录内容</th>
				</tr>
				<c:forEach items="${reimburseddestroy}" var="node">
					<tr>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.id}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.user}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.buyer}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.state}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.time}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;">
							<button type="button" class="btn btn-default btn-sm" onclick="javascript:window.location.href='<%=basePath%>destroy/ordercontent?id=${node.id}&type=5';">
	  							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;查看
							</button>
						</td>
					</tr>
	   			</c:forEach>
  			</table>
			</div>
			
			<p style="height: 150px;"></p>
			<a style="text-decoration:none; color:black;" class="btn btn-link btn-sm btn-block" href="#table-1">返回顶部</a>
			<p style="height: 70px;"></p>
        </div>
	</div>
	
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath%>static/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePath%>static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script>
	    $(".table tr td").each(function(){
	    	if($(this).text() == ' 报销中 '){
	    		$(this).css("color", "orange");
	    	}
	    	if($(this).text() == ' 已报销 '){
	    		$(this).css("color", "green");
	    	}
	    });
    </script>
</body>
</html>