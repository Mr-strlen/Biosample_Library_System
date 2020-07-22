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
		<!-- Default panel contents -->
		<div class="col-xs-2" id="myScrollspy">
			<ul class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="70">
              <li class="active"><a href="<%=basePath%>warehouse/controlquery">仓库控制表</a></li>
              <li ><a href="<%=basePath%>warehouse/alterquery">仓库变动表</a></li>
          </ul>
        </div>
		  	
  		<div id="tables" class="col-xs-10">
  		    <form style="width:100%; margin-top:10px; margin-bottom:10px;" action="<%=basePath%>warehouse/controlquery" method="get">
					<div style="width:100%;" class="col-lg-6">
		    			<div style="width:100%;" class="input-group">
		      				<input type="text" name="word" class="form-control" placeholder="Please enter keywords ...">
		      				<input type="hidden" name="type" id="type" value="1">
		      				<div class="input-group-btn">
		        				<button id="searchbutton" class="btn btn-default" type="submit">样本名称查找</button>	
		      					<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			        				<span class="caret"></span>
	    							<span class="sr-only">Toggle Dropdown</span>
	  							</button>
	  							<ul class="dropdown-menu">
	    							<li><a href="#table-5">样本名称查找</a></li>
	    							<li><a href="#table-5">存储条件查找</a></li>
	    							<li><a href="#table-5">存储区域查找</a></li>
	    							<li><a href="#table-5">存储日期查找</a></li>
	  							</ul>
		      				</div>
		    			</div><!-- /input-group -->
		  			</div><!-- /.col-lg-6 -->
		   </form>
		   
		    <br></br>
	  	    <br/>
  			<div class="panel panel-default">
  			<!-- Default panel contents -->
  			<div class="panel-heading">仓库存储表</div>
  			<!-- Table -->
  			<table class="table">
  				<tr>
					<th>样本名称</th>
					<th>最近变动日期</th>
					<th>存储条件</th>
					<th>存储区域</th>
					<th>现存数量</th>
					<th>附加说明</th>
				</tr>
				<c:forEach items="${controlquery}" var="node">
					<tr>
						<td> <c:out value="${node.sample_name}"></c:out> </td>
						<td> <c:out value="${fn:substring(node.warehousing_date,0,19)}"></c:out> </td>
						<td> <c:out value="${node.storage_conditions}"></c:out> </td>
						<td> <c:out value="${node.storage_area}"></c:out> </td>
						<td> <c:out value="${node.quantity}"></c:out> </td>
						<td> <c:out value="${node.additional_notes}"></c:out> </td>
						<td>
							<button type="button" class="btn btn-sm btn-primary" onclick="javascript:window.location.href='<%=basePath%>warehouse/alter_namequery?type=${node.sample_name}';" data-toggle="modal" data-target="#checkModal">
	  						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;查看变动信息
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
        	if(text == "样本名称查询"){
        		type.value = "1";
        	}
        	else if(text == "存储条件查询"){
        		type.value = "2";
        	}
        	else if(text == "存储区域查询"){
        		type.value = "3";
        	}
        	else if(text == "存储日期查询"){
        		type.value = "4";
        	}
        });
    </script>
</body>
</html>