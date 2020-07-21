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

    <title>生物样本库管理系统-销毁申请详情</title>

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
<body style="padding-top:90px" data-spy="scroll" data-target="#myScrollspy">
	<!-- Fixed navbar -->
    <jsp:include page="navbar.jsp" flush="true"/>

	<div class="container theme-showcase" role="main">
        <form autocomplete="off" id="frm" action="<%=basePath%>destroy/requestsubmit" method="get">
	        <div class="panel panel-default">
	  			<!-- Default panel contents -->
	  			<div style="position:relative" class="panel-heading">
	  				<button type="button" onclick="history.back(-1)" class="btn btn-default btn-sm float-right">
	  					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>&nbsp;返回
	  				</button>
	  				&nbsp;销毁申请&nbsp;<c:out value="${id}"></c:out>&nbsp;详细信息
	  				<c:if test="${type == '1'}" var="flag" scope="session">
	  					<input type="hidden" name="tableid" value="${id}">
		  				<button id="btn" style="position:absolute; right:13px;" type="button" class="btn btn-success btn-sm float-right">
		  					<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;提交
		  				</button>
	  				</c:if>
	  			</div>
	  			<!-- Table -->
	  			<table class="table table-hover">
	  				<tr>
						<th style="text-align:center;">样本名称</th>
						<th style="text-align:center;">样本数量</th>
						<th style="text-align:center;">样本备注</th>
						<th style="text-align:center;">审核状态</th>
						<c:if test="${type == '1'}" var="flag" scope="session">
						<th style="text-align:center;">审核</th>
						</c:if>
						<th style="text-align:center;">驳回原因</th>
					</tr>
					<c:forEach items="${contents}" var="node">
						<tr>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.name}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.number}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.notes}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.state}"></c:out> </td>
							<c:if test="${type == '1'}" var="flag" scope="session">
								<td style="width:100px; vertical-align:middle; text-align:center;">
									<select name="state" class="form-control">
										<option value ="1">通过</option>
	  									<option value ="-1">驳回</option>
									</select>
								</td>
								<input type="hidden" name="id" value="${node.id}">
								<td style="vertical-align:middle; text-align:center;">
									<input class="form-control reason" name="reason" value="${node.reason}">
								</td>
							</c:if>
							<c:if test="${not flag}">
								<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.reason}"></c:out> </td>
							</c:if>
						</tr>
		   			</c:forEach>
	  			</table>
	        </div>
        </form>
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
	<script>
		$("#btn").click(function(){
	    	$(".reason").each(function(){
	        	if($(this).val() == ''){
	            	$(this).val('-');
	           	}
	        });
	    	document.getElementById('frm').submit();
	    });   
	</script>  
</body>
</html>