<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">

    <title>库存存储表</title>

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
	    <button type="button" onclick="javascript:window.location.href='<%=basePath%>index'" class="btn btn-default btn-sm float-right">
	  		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>&nbsp;返回主页
	  	</button>
	  	<br></br>
	  	<br/>
		<ul class="nav nav-pills">
		  <li role="presentation" class="active"><a href="<%=basePath%>warehouse/areastate">按照区域查询</a></li>
		  <li role="presentation"><a href="<%=basePath%>warehouse/conditionstate">按照条件查询</a></li>
		</ul>
		<br></br>
	  	<br/>
  		<div class="panel panel-default">
  		<!-- Default panel contents -->
  		<div class="panel-heading">库位状态表</div>
  		<!-- Table -->
  		<table class="table">
  			<tr>
				<th>存储区域</th>
				<th>库存余量</th>
				<th>库存状态</th>
				<th>最近修改日期</th>
			</tr>
			<c:forEach items="${areastate}" var="node">
				<tr>
					<td> <c:out value="${node.warehouse_area}"></c:out> </td>
					<td> <c:out value="${node.warehouse_state}"></c:out> </td>
					<td> <c:out value="${node.warehouse_balance}"></c:out> </td>
					<td> <c:out value="${fn:substring(node.state_duration,0,19)}"></c:out> </td>
				</tr>
	   		</c:forEach>
  		</table>
	    </div> 
	</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath%>static/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePath%>static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script>
	    $(".table tr td").each(function(){
	    	if($(this).text() == ' 充足 '){
	    		$(this).css("color", "green");
	    	}
	    	if($(this).text() == ' 拥挤 '){
	    		$(this).css("color", "orange");
	    	}
	    	if($(this).text() == ' 不足 '){
	    		$(this).css("color", "red");
	    	}
	    });
    </script>
</body>
</html>