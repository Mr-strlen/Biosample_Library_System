<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
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

    <title>库位状态-区域划分</title>

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
		<ul class="nav nav-pills">
		  <li role="presentation"><a href="<%=basePath%>warehouse/areastate">按照区域查询</a></li>
		  <li role="presentation" class="active"><a href="<%=basePath%>warehouse/conditionstate">按照条件查询</a></li>
		</ul>
  		<div class="panel panel-default">
  		<!-- Default panel contents -->
  		<div class="panel-heading">样本存储条件状态表</div>
  		<!-- Table -->
  		<table class="table">
  			<tr>
  			    <th>存储条件</th>
  			    <th>所属仓库</th>
				<th>剩余库存</th>
				<th>总库存</th>
			</tr>
			<c:forEach items="${conditionstate}" var="node">
				<tr>
				    <td> <c:out value="${node.storage_conditions}"></c:out> </td>
					<td> <c:out value="${node.warehouse_area}"></c:out> </td>
					<td> <c:out value="${node.warehouse_balance}"></c:out> </td>
					<td> <c:out value="${node.warehouse_total}"></c:out> </td>
				</tr>
	   		</c:forEach>
  		</table>
	    </div> 
	</div>
</body>
</html>