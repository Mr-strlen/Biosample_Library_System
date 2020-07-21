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

    <title>生物样本库管理系统-记录记录</title>

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
        <div class="col-xs-2" id="myScrollspy">
            <ul class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="70">
                <li class="active"><a href="#table-1">全部记录</a></li>
                <li><a href="#table-2">待销毁记录</a></li>
                <li><a href="#table-3">销毁中记录</a></li>
                <li><a href="#table-4">已完成记录</a></li>
            </ul>
        </div>
        <div id="tables" class="col-xs-10">
            <p id="table-1" style="height: 50px;"></p>
			<div class="panel panel-default">
  			<!-- Default panel contents -->
  				<div class="panel-heading">全部记录</div>
  				<form style="margin-top:10px; margin-bottom:10px;" action="<%=basePath%>destroy/order#table-1" method="get">
					<div style="width:100%;" class="col-lg-6">
		    			<div class="input-group">
		      				<input type="text" name="word" class="form-control" placeholder="Search...">
		      				<input type="hidden" name="type" id="type" value="1">
		      				<div class="input-group-btn">
		        				<button id="searchbutton" class="btn btn-default" type="submit">通过编号查询</button>
			        			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			        				<span class="caret"></span>
	    							<span class="sr-only">Toggle Dropdown</span>
	  							</button>
	  							<ul class="dropdown-menu">
	    							<li><a href="#table-1">通过编号查询</a></li>
	    							<li><a href="#table-1">通过用户查询</a></li>
	    							<li><a href="#table-1">通过技术人员查询</a></li>
	    							<li><a href="#table-1">通过时间查询</a></li>
	  							</ul>
		      				</div>
		    			</div><!-- /input-group -->
		  			</div><!-- /.col-lg-6 -->
		  		</form>
  				<!-- Table -->
	  			<table class="table table-hover">
	  				<tr>
						<th style="text-align:center;">记录编号</th>
						<th style="text-align:center;">申请用户</th>
						<th style="text-align:center;">技术人员</th>
						<th style="text-align:center;">状态</th>
						<th style="text-align:center;">记录创建时间</th>
						<th style="text-align:center;">记录内容</th>
					</tr>
					<c:forEach items="${searchresult}" var="node">
						<tr>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.id}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.user}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.buyer}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.state}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.time}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;">
								<button type="button" class="btn btn-default btn-sm" onclick="javascript:window.location.href='<%=basePath%>destroy/ordercontent?id=${node.id}&type=1';">
	  								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;查看
								</button>
							</td>
						</tr>
		   			</c:forEach>
	  			</table>
			</div>
			
			<p id="table-2" style="height: 50px;"></p>
			<div class="panel panel-default">
  			<!-- Default panel contents -->
  			<div class="panel-heading">待销毁记录</div>
  			<!-- Table -->
  			<table class="table table-hover">
  				<tr>
					<th style="text-align:center;">记录编号</th>
					<th style="text-align:center;">申请用户</th>
					<th style="text-align:center;">采购员</th>
					<th style="text-align:center;">状态</th>
					<th style="text-align:center;">记录创建时间</th>
					<th style="text-align:center;">记录内容</th>
				</tr>
				<c:forEach items="${unstartdestroy}" var="node">
					<tr>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.id}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.user}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.buyer}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.state}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.time}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;">
							<button type="button" class="btn btn-default btn-sm" onclick="javascript:window.location.href='<%=basePath%>destroy/ordercontent?id=${node.id}&type=1';">
	  							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;查看
							</button>
						</td>
					</tr>
	   			</c:forEach>
  			</table>
			</div>
			
			<p id="table-3" style="height: 50px;"></p>
			<div class="panel panel-default">
  			<!-- Default panel contents -->
  			<div class="panel-heading">销毁中记录</div>
  			<!-- Table -->
  			<table class="table table-hover">
  				<tr>
					<th style="text-align:center;">记录编号</th>
					<th style="text-align:center;">申请用户</th>
					<th style="text-align:center;">技术人员</th>
					<th style="text-align:center;">状态</th>
					<th style="text-align:center;">记录创建时间</th>
					<th style="text-align:center;">记录内容</th>
				</tr>
				<c:forEach items="${starteddestroy}" var="node">
					<tr>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.id}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.user}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.buyer}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.state}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.time}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;">
							<button type="button" class="btn btn-default btn-sm" onclick="javascript:window.location.href='<%=basePath%>destroy/ordercontent?id=${node.id}&type=1';">
	  							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;查看
							</button>
						</td>
					</tr>
	   			</c:forEach>
  			</table>
			</div>
			
			<p id="table-4" style="height: 50px;"></p>
			<div class="panel panel-default">
  			<!-- Default panel contents -->
  			<div class="panel-heading">已完成记录</div>
  			<!-- Table -->
  			<table class="table table-hover">
  				<tr>
					<th style="text-align:center;">记录编号</th>
					<th style="text-align:center;">申请用户</th>
					<th style="text-align:center;">技术人员</th>
					<th style="text-align:center;">状态</th>
					<th style="text-align:center;">记录创建时间</th>
					<th style="text-align:center;">记录内容</th>
				</tr>
				<c:forEach items="${finisheddestroy}" var="node">
					<tr>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.id}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.user}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.buyer}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.state}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.time}"></c:out> </td>
						<td style="vertical-align:middle; text-align:center;">
							<button type="button" class="btn btn-default btn-sm" onclick="javascript:window.location.href='<%=basePath%>destroy/ordercontent?id=${node.id}&type=1';">
	  							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;查看
							</button>
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
        	if(text == "通过编号查询"){
        		type.value = "1";
        	}
        	else if(text == "通过用户查询"){
        		type.value = "2";
        	}
        	else if(text == "通过采购员查询"){
        		type.value = "3";
        	}
        	else if(text == "通过时间查询"){
        		type.value = "4";
        	}
        });
    </script>
    <script>
	    $(".table tr td").each(function(){
	    	if($(this).text() == ' 待销毁 '){
	    		$(this).css("color", "red");
	    	}
	    	if($(this).text() == ' 销毁中 '){
	    		$(this).css("color", "green");
	    	}
	    });
    </script>
</body>
</html>