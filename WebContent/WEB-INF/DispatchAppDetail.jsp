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

    <title>生物样本库管理系统-出库申请详情</title>

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
		<div class="panel panel-default">
  			<!-- Default panel contents -->
  			<div class="panel-heading">出库申请内容</div>
  			<!-- Table -->
  			<table class="table">
  				<tr>
					<th>申请单号</th>
					<th>样本名称</th>
					<th>样本数量</th>
					<th>样本状态</th>
					<th>审核结果</th>
					<th>未通过原因</th>
					
				</tr>
				<c:forEach items="${app_detail}" var="node">
					<tr>
						<td> <c:out value="${node.order}"></c:out> </td>
						<td> <c:out value="${node.type}"></c:out> </td>
						<td> <c:out value="${node.num}"></c:out> </td>
						<td> <c:out value="${node.condition}"></c:out> </td>
						<td> <c:out value="${node.result}"></c:out> </td>
						<td>  			
							<c:if test="${node.result == '未通过'}">
								<c:out value="${node.reason_pos}"></c:out> 
							</c:if>
							<c:if test="${node.result == '已通过'}">
								<c:out value="无"></c:out> 
							</c:if>
						</td>
					</tr>
	   			</c:forEach>
  			</table>
		</div> 
		
		
	</div>
	
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath%>static/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePath%>static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
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