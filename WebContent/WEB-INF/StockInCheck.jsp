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

    <title>生物样本库管理系统-入库审核</title>

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
	<%-- <form action="<%=basePath%>stockin/stockin_check" method="get"> --%>
  		<div class="panel panel-default">
  		<!-- Default panel contents -->
  		<div class="panel-heading">库位状态表</div>
  		<!-- Table -->
  		<table class="table">
  			<tr>
				<th>存储区域</th>
				<th>库存余量</th>
				<th>库存状态</th>
				<th>最近修改日期</th>
			</tr>
			<c:forEach items="${areastate}" var="node">
				<tr>
					<td> <c:out value="${node.warehouse_area}"></c:out> </td>
					<td> <c:out value="${node.warehouse_balance}"></c:out> </td>
					<td> <c:out value="${node.warehouse_state}"></c:out> </td>
					<td> <c:out value="${fn:substring(node.state_duration,0,19)}"></c:out> </td>
				</tr>
	   		</c:forEach>
  		</table>
	    </div> 
	    <!-- </form> -->
	</div>
		
	<div class="container theme-showcase" role="main">
		<form action="<%=basePath%>stockin/stockin_checksubmit" method="get">
		<div class="panel panel-default">
  			<!-- Default panel contents -->
  			<div class="panel-heading">入库审核</div>
  			<!-- Table -->
  			<table class="table">
  				<tr>
					<th>申请单编号</th>
					<th>样本名称</th>
					<th>样本规格</th>
					<th>入库建议/备注</th>
					<th>审核结果</th>
					<th>驳回原因</th>
					
				</tr>
				<c:forEach items="${stockin_appdetail}" var="node">
					<tr>
						<td> <c:out value="${node.id}"></c:out> </td>
						<td>
						 <c:out value="${node.name}"></c:out> 
						 <input type="hidden" name="name" value="${node.name}">						     
						 </td>
						<td> <c:out value="${node.size}"></c:out> </td>
						<td> <c:out value="${node.request}"></c:out> </td>
						<td> 							
							<select name="result" class="form-control">
                               <option value ="通过">通过</option>
                               <option value ="驳回">驳回</option> 
                            </select>
						</td>
						<td> 
							<input type="text" name="reason" class="form-control" placeholder="填写驳回原因..." value="无" onfocus="if(value=='无'){value=''}"   
                onblur="if(value==''){value='无'}">
						</td>
					</tr>
	   			</c:forEach>
  			</table>
		</div> 
		
		<!-- attention to fix -->
		<input type="hidden" name="id" value="${stockin_appdetail[0].id}">		
		<label>审核员：	<input style="width: 200px;" type="text" name="auditor" class="form-control" placeholder = "审核员姓名"></label>
		<br></br>
        <button style="display:block;margin:0 auto" class="btn btn-default" type="submit">提交</button>
        </form>
	</div>
	
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=basePath%>static/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePath%>static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>