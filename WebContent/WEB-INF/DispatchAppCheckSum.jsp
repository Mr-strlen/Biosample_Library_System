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

    <title>生物样本库管理系统-出库申请</title>

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
		<!-- Default panel contents -->
		<div class="col-xs-2" id="myScrollspy">
			<ul class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="70">
              <li class="active"><a href="<%=basePath%>dispatch/app_checksum">审核</a></li>
              <li><a href="<%=basePath%>dispatch/app_select">查询</a></li>
          </ul>
        </div>
           
  		<div id="tables" class="col-xs-10">
  			<div class="panel panel-default">
  			<div class="panel-heading">待审核出库申请信息</div>
  			<!-- Table -->
  			<table class="table">
  				<tr>
					<th>申请单号</th>
					<th>申请单位</th>
					<th>申请时间</th>
					<th>审核结果</th>
				</tr>
				<c:forEach items="${app_checksum}" var="node">
					<tr>
						<td> <c:out value="${node.order}"></c:out> </td>
						<td> <c:out value="${node.applicant}"></c:out> </td>
						<td> <c:out value="${node.time}"></c:out> </td>
						<td> <c:out value="${node.result}"></c:out> </td>
						<td>
							<button type="button" class="btn btn-sm btn-primary" onclick="javascript:window.location.href='<%=basePath%>dispatch/app_checkdetail?type=${node.order}';" data-toggle="modal" data-target="#checkModal">
	  						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;审核
							</button>
						</td>
					</tr>
	   			</c:forEach>
  			</table>
		</div> 
	
		</div>
	</div>
	
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath%>static/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePath%>static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>