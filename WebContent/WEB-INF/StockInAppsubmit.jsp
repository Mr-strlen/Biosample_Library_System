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
		<div class="panel panel-default" style="margin-top:20px;">
  			<!-- Default panel contents -->
  			<div class="panel-heading">(提示：若一次申请多个样本入库，请在填写申请时填写您第一次看见的申请单号)</div>
  			<!-- Table -->
  			<table class="table">
  				<tr>
					<th>本次申请单号</th>																		
				</tr>
				
				<tr>
					<td>${warehouse_nextappid}</td>
				</tr>
  			</table>
		</div>
		
		<form action="<%=basePath%>warehouse//warehouse_appsubmit" method="get">
		<div class="panel panel-default">
  			<!-- Default panel contents -->
  			<div class="panel-heading">入库申请</div>
  			<!-- Table -->
  			<table class="table">
  				<tr>					
					<th>申请单编号</th>
					<th>样本名称</th>
					<th>样本规格</th>
					<th>申请单位</th>															
				</tr>
					<tr>						
						<td> <input type="text" name="id" class="form-control" > </td>						
						<td> <input type="text" name="name" class="form-control" > </td>
						<td> <input type="text" name="size" class="form-control" > </td>	
						<td> <input type="text" name="applicant" class="form-control" ></td>															
					</tr>
	   			
  			</table>
		</div> 
		<button style="width:100px; display:block;margin:0 auto" class="btn btn-default" type="submit">提交</button>
		</form>
	</div>
    
</body>
</html>