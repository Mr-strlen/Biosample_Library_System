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

    <title>生物样本库管理系统-出库审核</title>

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
	  	<br/>
		<form action="<%=basePath%>dispatch/app_checksubmit" method="get" class="form-inline">
		<div class="panel panel-default">
  			<!-- Default panel contents -->
  			<div class="panel-heading">出库审核</div>
  			<!-- Table -->
  			<table class="table">
  				<tr>
					<th>申请单号</th>
					<th>样本名称</th>
					<th>样本数量</th>
					<th>样本状态</th>
					<th>审核结果</th>
					<th><span id="posorreason">样本位置</span></th>
					<th>查询样本库</th>
				</tr>
				<c:forEach items="${app_checkdetail}" var="node">
					<tr>
						<td> 
							<c:out value="${node.order}"></c:out> 
							<input type="hidden" name="order" value="${node.order}">
						</td>
						<td>
						 <c:out value="${node.type}"></c:out> 
						 <input type="hidden" name="type" value="${node.type}">						     
						 </td>
						<td> <c:out value="${node.num}"></c:out> </td>
						<td> <c:out value="${node.condition}"></c:out> </td>
						<td> 							
							<select id="resultse" name="result" class="form-control" onchange="change()">
                               <option value ="已通过">通过</option>
                               <option value ="未通过">不通过</option> 
                            </select>
						</td>
						<td> 
							<input style="width: 300px;" type="text" name="reason_pos" class="form-control" placeholder = "通过请填写样本位置，未通过请填写原因">
						</td>
						<td>
						<button type="button" class="btn btn-default btn-sm" onclick="javascript:window.location.href='<%=basePath%>sampleinfo/query'">
  							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;查询
						</button>
					</tr>
	   			</c:forEach>
  			</table>
		</div> 
		
		<input type="hidden" name="order" value="${appdetail[0].order}">
		
  		<label>审核员：	<input style="width: 200px;" type="text" name="auditor" class="form-control" placeholder = "审核员名称"></label>
		<br/>
		<br></br>
		<button style = "vertical-align:middle" type="submit" class="btn btn-success btn-sm float-right">
 				<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;提交
		</button>
		
        </form>
		
	</div>
	<script type="text/javascript">
	function change()
	{
		if(document.getElementById("resultse").value=="已通过")
		{
			$("#posorreason").text("样本位置");
		}
		if(document.getElementById("resultse").value=="未通过")
		{
			$("#posorreason").text("未通过原因");
		}
	}
	</script>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath%>static/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePath%>static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html> 