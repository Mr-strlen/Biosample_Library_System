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
      <button type="button" onclick="history.back(-1)" class="btn btn-default btn-sm float-right">
	  		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>&nbsp;返回
	  </button>
	  <br></br>
	  <br/>
      <form action="<%=basePath%>warehouse/areastate" method="get">
		<div class="panel panel-default">
  			<!-- Default panel contents -->
  			<div class="panel-heading">更改仓库大小</div>
  			<!-- Table -->
  			<table class="table">
  				<tr>
					<th>仓库</th>
					<th>常温区数量</th>
					<th>冷藏区数量</th>
					<th>冷冻区数量</th>					
				</tr>
					<tr>
						<td>
						    <select name="warehouse" class="form-control">
                               <option value ="动物组织库">动物组织库</option>
                               <option value ="动物器官库">动物器官库</option>
                               <option value ="植物组织库">植物组织库</option>
                               <option value ="植物果实库">植物果实库</option>
                               <option value ="精细样本库">精细样本库</option>
                               <option value ="信息样本库">信息样本库</option> 
                            </select>					     
						 </td>
						<td> <input type="text" name="normal" class="form-control"> </td>
						<td> <input type="text" name="refrigerate" class="form-control"> </td>
						<td> <input type="text" name="freeze" class="form-control"> </td>
					</tr>
  			</table>
		</div> 
				
        <button style="display:block;margin:0 auto" class="btn btn-default" type="submit">提交</button>
        </form>
    </div>
</body>
</html>