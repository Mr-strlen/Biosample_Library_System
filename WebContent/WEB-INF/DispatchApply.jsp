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
		<button type="button" onclick="history.back(-1)" class="btn btn-default btn-sm float-right">
	  		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>&nbsp;返回
	  	</button>
	  	<br></br>
	  	<br/>
	  	
		<form action="<%=basePath%>dispatch/apply_deliversum" method="get" class="form-inline">
		<div class="panel panel-default">
  			<!-- Default panel contents -->
  			<div class="panel-heading">出库申请</div>
			<br/>
  			<!-- Table -->
  			<table class="table">
  				<tr>
					<th>样本名称</th>
					<th>样本数量</th>
					<th>样本状态</th>					
				</tr>
				<tr>
					<td> 
						<input style="width: 250px;" type="text" id = "type" name="type" class="form-control" placeholder = "样本名称（逗号分隔）">
					</td>
					<td>
						<input style="width: 250px;" type="text" name="snum" class="form-control" placeholder = "样本数量（逗号分隔）">
					</td>
					<td> 
						<input style="width: 250px;" type="text" name="condition" value = "默认" class="form-control" placeholder = "样本状态（逗号分隔）">
					</td>
					</tr>
  			</table>
		</div> 
		<!-- 
		<button style = "vertical-align:middle" type="button" class="btn btn-success btn-sm float-right" onclick="javascript:window.location.href='<%=basePath%>dispatch/apply_deliverdetail?type&snum&condition';">
 				<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;确定
		</button>
		-->
		
		<label>申请单位：	<input style="width: 200px;" type="text" name="applicant" class="form-control" placeholder = "出库申请单位"></label>
		
		<br></br>
		<button style = "vertical-align:middle" type="submit" class="btn btn-success btn-sm float-right">
 				<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;完成
		</button>
        </form>
		
	</div>
	
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath%>static/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePath%>static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html> 