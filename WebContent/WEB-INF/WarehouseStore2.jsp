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
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">

    <title>样本存储创建</title>

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
	<jsp:include page="navbar.jsp" flush="true"/>
	<%
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = df.format(d);
	%>
	<div class="container theme-showcase" role="main">
	
		<form action="<%=basePath%>warehouse/store2_submit" method="get">
			<input name="type" id="type" type="hidden" value="">
			<label for="basic-url">样本存储信息</label>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon2">样本名称</span>
  					<input type="text" class="form-control" name="name" value="${forfun1}" aria-describedby="basic-addon2" readonly>
  				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon2">入库日期</span>
  					<input type="text" class="form-control" name="date" value="${forfun2}" aria-describedby="basic-addon2" readonly>
  				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon2">变化数量</span>
  					<input type="text" class="form-control" name="num" value="${forfun3}" aria-describedby="basic-addon2" readonly>
  				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon2">储存条件</span>
					<select class="form-control"name="con" aria-describedby="basic-addon2">
                       <option>常温</option>
                       <option>冷藏</option>
                       <option>冷冻</option>
                    </select>
                    <!--<input type="text" class="form-control" name="con" aria-describedby="basic-addon2">-->
  				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon2">储存区域</span>
					<select class="form-control"name="area" aria-describedby="basic-addon2">
                       <option>动物组织库</option>
                       <option>动物器官库</option>
                       <option>植物组织库</option>
                       <option>植物果实库</option>
                       <option>精细样本库</option>
                       <option>信息样本库</option>
                    </select>
  					 <!--<input type="text" class="form-control" name="area" aria-describedby="basic-addon2">-->
  				</div>
			</div>
			<div class="form-group">
				<span class="input-group-btn">
        			<button class="btn btn-success" type="submit">结束存储</button>
        			<button class="btn btn-default" type="reset">清空输入</button>
      			</span>
			</div>
  		</form>
  	</div>
	
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath%>static/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePath%>static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>