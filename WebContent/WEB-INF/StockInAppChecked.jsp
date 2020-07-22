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

    <title>生物样本库管理系统-入库申请</title>

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
<body>
	<!-- Fixed navbar -->
    <jsp:include page="navbar.jsp" flush="true"/>

	<div class="container theme-showcase" role="main">
		<div class="panel panel-default">
  			<!-- Default panel contents -->
  			<div class="panel-heading">已审核申请</div>
  			<!-- Table -->
  			<table class="table">
  				<tr>
					<th>申请单编号</th>
					<th>申请日期</th>
					<th>申请单位</th>
					<th>审核人</th>
					<th>申请内容</th>
					
				</tr>
				<c:forEach items="${stockin_checked}" var="node">
					<tr>
						<td> <c:out value="${node.id}"></c:out> </td>
						<td> <c:out value="${node.date}"></c:out> </td>
						<td> <c:out value="${node.applicant}"></c:out> </td>
						<td> <c:out value="${node.auditor}"></c:out> </td>
						<td> 
						<button type="button" class="btn btn-primary btn-sm"  onclick="javascript:window.location.href='<%=basePath%>stockin/stockin_appdetail?id=${node.id}';">
  							<span class="glyphicon glyphicon-search"></span> 查看
						</button>
						</td>	     			         											
					</tr>
	   			</c:forEach>
  			</table>
		</div> 
		<div class="panel-heading">申请单查询</div>
		<form action="<%=basePath%>stockin/stockin_appdetail" method="get">
		<div class="col-lg-6">
    		<div class="input-group">
      			<input type="number" name="id" class="form-control" placeholder="输入申请单号...">
      			<span class="input-group-btn">
        			<button class="btn btn-default" type="submit">
        				<span class="glyphicon glyphicon-ok"></span> 查询
        			</button>
      			</span>
    		</div><!-- /input-group -->
  		</div><!-- /.col-lg-6 -->
  		</form>
		<br/>
		<br/>
		<br/>
		<br/>
	</div>
	
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath%>static/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePath%>static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>