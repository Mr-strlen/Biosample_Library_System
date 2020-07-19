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
              <li ><a href="<%=basePath%>dispatch/app_checksum">审核</a></li>
              <li class="active"><a href="<%=basePath%>dispatch/app_select">查询</a></li>
          </ul>
        </div>
           
  		<div id="tables" class="col-xs-10">
  			<div class="panel panel-default">
  			<div class="panel-heading">查询出库申请信息</div>
  			
  			<form style="width:100%; margin-top:10px; margin-bottom:10px;" action="<%=basePath%>dispatch/app_select" method="get">
				<div style="width:100%;" class="col-lg-6">
		    		<div style="width:100%;" class="input-group">
		      			<input id="wordinput" type="text" name="word" class="form-control" value="D" placeholder="Search for ...">
		      			<input type="hidden" name="type" id="type" value="1">
		      			<div class="input-group-btn">		        				
		      				<button id="searchbutton" class="btn btn-default" type="submit">申请单号查询</button>	
	      					<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		        				<span class="caret"></span>
	    						<span class="sr-only">Toggle Dropdown</span>
	  						</button>
	  						<ul class="dropdown-menu">
	    						<li><a href="#table-5">申请单号查询</a></li>
	    						<li><a href="#table-5">申请单位查询</a></li>
	    						<li><a href="#table-5">申请时间查询</a></li>
	    						<li><a href="#table-5">审核结果查询</a></li>
	  						</ul>
		      			</div>
		    		</div><!-- /input-group -->
		  		</div><!-- /.col-lg-6 -->
		  	</form>
  			<!-- Table -->
  			<table class="table">
  				<tr>
					<th>申请单号</th>
					<th>申请单位</th>
					<th>申请时间</th>
					<th>审核结果</th>
					<th>审核员</th>
					<th>申请内容</th>
				</tr>
				<c:forEach items="${app_select}" var="node">
					<tr>
						<td> <c:out value="${node.order}"></c:out> </td>
						<td> <c:out value="${node.applicant}"></c:out> </td>
						<td> <c:out value="${node.time}"></c:out> </td>
						<td> <c:out value="${node.result}"></c:out> </td>
						<td> <c:out value="${node.auditor}"></c:out> </td>
						<td>
							<button type="button" class="btn btn-default btn-sm" onclick="javascript:window.location.href='<%=basePath%>dispatch/app_detail?type=${node.order}';" data-toggle="modal" data-target="#messageModal">
	  							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;查看
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
    <script>
    	$(".dropdown-menu li a").click(function () {
        	var text = $(this).text();
        	var type = document.getElementById("type");
        	document.getElementById("searchbutton").innerHTML = text;
        	if(text == "申请单号查询"){
        		type.value = "1";
        		document.getElementById("wordinput").type = "text";
        		document.getElementById("wordinput").value = "DA";
        	}
        	else if(text == "申请单位查询"){
        		type.value = "2";
        		document.getElementById("wordinput").type = "text";
        		document.getElementById("wordinput").value = "";
        	}
        	else if(text == "申请时间查询"){
        		type.value = "3";
        		document.getElementById("wordinput").type = "date";
        	}
        	else if(text == "审核结果查询"){
        		type.value = "4";
        		document.getElementById("wordinput").type = "text";
        		document.getElementById("wordinput").value = "";
        	}
        });
    </script>
    <script>
	    $(".table tr td").each(function(){
	    	if($(this).text() == ' 未通过 '){
	    		$(this).css("color", "red");
	    	}
	    	if($(this).text() == ' 已通过 '){
	    		$(this).css("color", "green");
	    	}
	    });
    </script>
</body>
</html>