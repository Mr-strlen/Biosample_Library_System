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

    <title>生物样本库管理系统-销毁记录详情</title>

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
        <form autocomplete="off" action="<%=basePath%>destroy/ordersubmit" method="get">
	        <div class="panel panel-default">
	  			<!-- Default panel contents -->
	  			<div style="position:relative" class="panel-heading">
	  				<button type="button" onclick="history.back(-1)" class="btn btn-default btn-sm float-right">
	  					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>&nbsp;返回
	  				</button>
	  				&nbsp;销毁记录&nbsp;<c:out value="${id}"></c:out>&nbsp;详细信息
	  				<c:if test="${type == '2'}">
	  					<input type="hidden" name="tableid" value="${id}">
	  					<input type="hidden" name="type" value="start">
		  				<button style="position:absolute; right:13px;" type="submit" class="btn btn-success btn-sm float-right">
		  					<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;开始销毁
		  				</button>
	  				</c:if>
	  				<c:if test="${type == '3'}">
	  					<input type="hidden" name="tableid" value="${id}">
	  					<input type="hidden" name="type" value="submit">
		  				<button style="position:absolute; right:155px;" type="button" onclick="selectall()" class="btn btn-default btn-sm">全选</button>
		  				<button style="position:absolute; right:90px;" type="button" onclick="unselectall()" class="btn btn-default btn-sm">全不选</button>
		  				<button style="position:absolute; right:13px;" type="submit" class="btn btn-success btn-sm">
		  					<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;提交
		  				</button>
	  				</c:if>
	  				<c:if test="${type == '4'}">
	  					<input type="hidden" name="tableid" value="${id}">
	  					<input type="hidden" name="type" value="reimburse">
		  				<button style="position:absolute; right:13px;" type="submit" class="btn btn-success btn-sm float-right">
		  					<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;确认提交
		  				</button>
	  				</c:if>
	  			</div>
	  			<!-- Table -->
	  			<table class="table table-hover">
	  				<tr>
						<th style="text-align:center;">样本名称</th>
						<th style="text-align:center;">样本数量</th>
						<c:if test="${type != '4' && type != '5'}">
							<th style="text-align:center;">销毁状态</th>
						</c:if>
						<c:if test="${type == '1' || type == '4' || type == '5'}">
							<th style="text-align:center;">销毁流程序号</th>
							<th style="text-align:center;">销毁原因</th>
							<th style="text-align:center;">销毁时间</th>
						</c:if>
						<c:if test="${type == '3'}">
							<th style="text-align:center;">销毁流程序号</th>
							<th style="text-align:center;">销毁原因</th>
							<th style="text-align:center;">选择</th>
						</c:if>
					</tr>
					<c:forEach items="${contents}" var="node">
						<tr>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.name}"></c:out> </td>
							<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.number}"></c:out> </td>
							<c:if test="${type != '4' && type != '5'}">
								<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.state}"></c:out> </td>
							</c:if>
							<c:if test="${type == '1' || type == '4' || type == '5'}">
								<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.price}"></c:out> </td>
								<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.source}"></c:out> </td>
								<td style="vertical-align:middle; text-align:center;"> <c:out value="${node.time}"></c:out> </td>
							</c:if>
							<c:if test="${type == '3'}">
								<input type="hidden" name="id" value="${node.id}">
								<input type="hidden" name="state" value="${node.state}">
								<td style="vertical-align:middle; text-align:center; width:200px;">
									<c:if test="${node.state == '已完成'}" var="flag" scope="session">
										<input class="form-control" name="price" value="${node.price}" >
									</c:if>
									<c:if test="${not flag}">
										<input class="form-control" name="price" value="${node.price}">
									</c:if>
								</td>
								<td style="vertical-align:middle; text-align:center;">
									<c:if test="${node.state == '已完成'}" var="flag" scope="session">
										<input class="form-control" name="source" value="${node.source}" >
									</c:if>
									<c:if test="${not flag}">
										<input class="form-control" name="source" value="${node.source}">
									</c:if>
								</td>
								<td style="vertical-align:middle; text-align:center;">
									<c:if test="${node.state == '已完成'}" var="flag" scope="session">
										<input class="type-check" type="checkbox" disabled>
									</c:if>
									<c:if test="${not flag}">
										<input class="nf-input type-check" type="checkbox">
									</c:if>
									<input class="type-input" type="hidden" name="checked" value="off">
								</td>
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
	    	if($(this).text() == ' 待销毁 '){
	    		$(this).css("color", "red");
	    	}
	    	if($(this).text() == ' 销毁中 '){
	    		$(this).css("color", "green");
	    	}
	    });

		$(".type-check").click(function(){
	    	if($(this).prop("checked")){
	        	$(this).parent().children().eq(1).val('on');
	       	}
	    	else{
	    		$(this).parent().children().eq(1).val('off');
	    	}
	    }); 
		
		function selectall(){
			$(".nf-input").each(function(){
				$(this).prop("checked", true);
			});
		}
		
		function unselectall(){
			$(".nf-input").each(function(){
				$(this).prop("checked", false);
			});
		}
	</script>  
</body>
</html>