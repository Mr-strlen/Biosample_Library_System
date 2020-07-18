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

    <title>生物样本库管理系统-出库成功</title>

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
    <!-- 控制五秒跳转 -->
    <meta http-equiv="refresh" content='5; url=<%=basePath%>index'>
</head>

<body>
	<jsp:include page="navbar.jsp" flush="true"/>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					申请成功!
				</h2>
				<p>
					点击下方按钮或<span id="ss" style="color:red;">5</span>秒后将自动跳转到登陆页面。
				</p>
				<p>
					<button class="btn btn-primary btn-large" onclick="javascript:window.location.href='<%=basePath%>index';">返回首页</button>
				</p>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
                //先声明一个时间变量
                var count = 6;
                //声明时间递减的方法
                var time = function(){
                    count = count - 1;
                    //将时间显示到页面上
                    $("#ss").text(count);
                    //设置一个定时器，每隔一秒自动递归调用自己一次
                    setTimeout(time, 1000);
                };
                time();
</script>
</body>
</html>
