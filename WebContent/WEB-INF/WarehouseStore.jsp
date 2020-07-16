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
	
		<form action="<%=basePath%>check/sample_submit" method="get">
			<input name="type" id="type" type="hidden" value="">
			<label for="basic-url">盘点样本信息</label>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon2">入库时间</span>
  					<input type="text" value="<%=now %>"class="form-control" name="check_ctt" aria-describedby="basic-addon2" readonly>
  				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon2">样本编码</span>
  					<input type="text" class="form-control" name="sample_id" aria-describedby="basic-addon2">
  				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon2">存储位置</span>
  					<input type="text" class="form-control" name="position_id" aria-describedby="basic-addon2">
  				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon2">存储条件</span>
  					<input type="text" class="form-control" name="check_id" aria-describedby="basic-addon2">
  				</div>
			</div>
			<div class="form-group">
				<span class="input-group-btn">
					<button id="btn1" onclick="next()" class="btn btn-default" type="button">下一个样本</button>
        			<button id="btn2" onclick="quit()" class="btn btn-success" type="button">结束存储</button>
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
    <script>
    	function next(){
    		document.getElementById("type").value='next';
    		document.forms[0].submit();
    	}
    	function quit(){
    		document.getElementById("type").value='quit';
    		document.forms[0].submit();
    	}
    </script>
</body>
</html>