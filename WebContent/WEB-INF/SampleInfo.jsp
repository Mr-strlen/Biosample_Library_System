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

    <title>生物样本库管理系统-信息管理</title>

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
        <div id="tables" class="col-xs-10">
            <p id="table-1" style="height: 50px;"></p>
			<div class="panel panel-default">
  			<!-- Default panel contents -->
  				<div class="panel-heading">样本信息</div>
  				<form style="margin-top:10px; margin-bottom:10px;" action="<%=basePath%>sampleinfo/query" method="get">
					<div style="width:100%;" class="col-lg-6">
		    			<div class="input-group">
		      				<input type="text" name="word" class="form-control" placeholder="Search...">
		      				<input type="hidden" name="type" id="type" value="1">
		      				<div class="input-group-btn">
		        				<button id="searchbutton" class="btn btn-default" type="submit">信息查询</button>
			        			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			        				<span class="caret"></span>
	    							<span class="sr-only">Toggle Dropdown</span>
	  							</button>
	  							<ul class="dropdown-menu">
	    							<li><a href="#table-5">通过样本名称查询</a></li>
	    							<li><a href="#table-5">通过样本位置查询</a></li>
	    							<li><a href="#table-5">通过入库员查询</a></li>
	    							<li><a href="#table-5">通过样本来源查询</a></li>
	    							<li><a href="#table-5">通过入库时间查询</a></li>
	    							<li><a href="#table-5">通过存储类型查询</a></li>
	  							</ul>
		      				</div>
		    			</div><!-- /input-group -->
		  			</div><!-- /.col-lg-6 -->
		  		</form>
  				<!-- Table -->
	  			<table class="table table-hover">
	  				<tr>
						<th style="text-align:center;">位置编号</th>
						<th style="text-align:center;">样本编号</th>
						<th style="text-align:center;">样本名称</th>
						<th style="text-align:center;">规格</th>
						<th style="text-align:center;">入库时间</th>
						<th style="text-align:center;">入库员</th>
						<th style="text-align:center;">来源</th>
						<th style="text-align:center;">存储说明</th>
					</tr>
					<c:forEach items="${searchresult}" var="node">
						<tr>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.position}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.id}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.name}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.size}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.time}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.auditor}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.source}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.evnm}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;">
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
    	$(".dropdown-menu li a").click(function () {
        	var text = $(this).text();
        	var type = document.getElementById("type");
        	document.getElementById("searchbutton").innerHTML = text;
        	if(text == "信息查询"){
        		type.value = "0";
        	}
        	else if(text == "通过样本名称查询"){
        		type.value = "1";
        	}
        	else if(text == "通过存储类型查询"){
        		type.value = "2";
        	}
        	else if(text == "通过入库员查询"){
        		type.value = "3";
        	}
        	else if(text == "通过样本来源查询"){
        		type.value = "4";
        	}
        	else if(text == "通过入库时间查询"){
        		type.value = "5";
        	}
        	else if(text == "通过样本位置查询"){
        		type.value = "6";
        	}
        });
    </script>
</body>
</html>