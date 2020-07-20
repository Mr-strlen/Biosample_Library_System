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

    <title>生物样本库管理系统-入库记录</title>

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
  		<form style="margin-top:10px; margin-bottom:10px;" action="<%=basePath%>stockin/stockin_appnotfinished" method="get">	
  		<div class="panel panel-default" style="margin-top:20px;">
  			<div class="panel-heading">已通过未登记申请</div>
  			<!-- Table -->
  			<table class="table">
  				<tr>
					<th>申请单编号</th>
					<th>样本名称</th>
					<th>样本规格</th>
					<th>需求建议</th>
					<th>审核结果</th>
				</tr>
				<c:forEach items="${appnotfinished}" var="node">
					<tr>
						<td> <c:out value="${node.id}"></c:out> </td>
						<td> <c:out value="${node.name}"></c:out> </td>
						<td> <c:out value="${node.size}"></c:out> </td>
						<td> <c:out value="${node.request}"></c:out> </td>
						<td> <c:out value="${node.result}"></c:out> </td>
					</tr>
	   			</c:forEach>
  			</table>
  		</div>
  		</form>
  		
		<form action="<%=basePath%>stockin/stockin_recordsubmit" method="get">
		<div class="panel panel-default">
  			<!-- Default panel contents -->
  			<div class="panel-heading">入库登记</div>
  			<!-- Table -->
  			<table class="table">
  				<tr>					
					<th>申请单编号</th>
					<th>样本名称</th>
					<th>样本规格</th>	
					<th>样本编码</th>														
				</tr>
					<tr>						
						<td> <input type="text" name="application_id" class="form-control" > </td>						
						<td> <input type="text" name="sample_name" class="form-control" > </td>
						<td> <input type="text" name="sample_quantity" class="form-control" > </td>
						<td> <input type="text" name="sample_id" class="form-control" > </td>										
					</tr>	   			
  			</table>
		</div> 
		<button style="width:100px; display:block;margin:0 auto" class="btn btn-primary" type="submit">提交</button>
		</form>
		
		<div class="panel panel-default" style="margin-top:20px;">
  			<!-- Default panel contents -->
  			<div class="panel-heading">入库记录</div>
  			<form style="margin-top:10px; margin-bottom:10px;" action="<%=basePath%>stockin/stockin_findrecord" method="get">
			<div style="width:100%;" class="col-lg-6">
	    		<!-- <div class="input-group">
	      			<input type="text" name="sample_id" class="form-control" placeholder="输入样本编码...">
	      			<span class="input-group-btn">
	        			<button style="width:100px;" class="btn btn-default" type="submit">查询</button>
	      			</span>
	    		</div>/input-group -->
	  		</div><!-- /.col-lg-6 -->
	  		</form>
  			<!-- Table -->
  			<table class="table">
  				<tr>
					<th>记录编号</th>
					<th>入库日期</th>
					<th>申请单编号</th>
					<th>样本名称</th>
					<th>样本编码</th>
					<th>是否已存储</th>									
				</tr>
				<c:forEach items="${stockin_record}" var="node">
					<tr>
						<td> <c:out value="${node.id}"></c:out> </td>
						<td> <c:out value="${node.date}"></c:out> </td>
						<td> <c:out value="${node.application_id}"></c:out> </td>
						<td> <c:out value="${node.sample_name}"></c:out> </td>
						<td> <c:out value="${node.sample_id}"></c:out> </td>
						<td> <c:out value="${node.stockin_state}"></c:out> </td>
						<td> <button class="btn btn-default" type="button" onclick="javascript:window.location.href='<%=basePath%>stockin/stockin_appdetail?id=${node.application_id}';">查看</button> </td>					
					</tr>
	   			</c:forEach>
  			</table>
		</div>
		
		<form>
		<!-- attention to fix -->
		<input type="hidden" name="id" value="${stockin_appdetail[0].id}">		
        <!-- <button style="display:block;margin:0 auto" class="btn btn-default" type="submit">提交</button> -->
        </form>
		
	</div>
	
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath%>static/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePath%>static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script>
	    $(".table tr td").each(function(){
	    	if($(this).text() == ' 未存储 '||$(this).text() == ' 未通过 '){
	    		$(this).css("color", "red");
	    	}
	    	if($(this).text() == ' 已存储 '||$(this).text() == ' 通过 '){
	    		$(this).css("color", "green");
	    	}
	    });
	    </script>
</body>
</html>