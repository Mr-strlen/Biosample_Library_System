<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
      	<p class="navbar-text navbar-right">欢迎您！<a href="<%=basePath%>" class="navbar-link">测试用户</a></p>
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=basePath%>index">生物样本库管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="<%=basePath%>index">首页</a></li>
            <li id="dd1" class="dropdown">
              <a href="<%=basePath%>warehouse" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">样本出入库 <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li class="dropdown-header">样本入库</li>
                <li><a href="<%=basePath%>warehouse/warehouse_app">入库申请</a></li>
                <li><a href="<%=basePath%>warehouse/warehouse_checking">待审核申请</a></li>
                <li><a href="<%=basePath%>warehouse/warehouse_checked">已审核申请</a></li>
                <li><a href="<%=basePath%>warehouse/warehouse_record">入库登记</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">样本出库</li>
                <li><a href="<%=basePath%>dispatch/apply">出库申请</a></li>
                <li><a href="<%=basePath%>dispatch/app_checksum">出库审核</a></li>
                <li><a href="<%=basePath%>dispatch/record_opsum">出库记录</a></li>
              </ul>
            </li>
            <li id="dd2" class="dropdown">
              <a href="<%=basePath%>purchase" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">样本采购 <span class="caret"></span></a>
              <ul class="dropdown-menu">
              	<li class="dropdown-header">采购申请审核</li>
                <li><a href="<%=basePath%>purchase/request#table-1">全部申请</a></li>
                <li><a href="<%=basePath%>purchase/request#table-2">待审核申请</a></li>
                <li><a href="<%=basePath%>purchase/request#table-3">已通过申请</a></li>
                <li><a href="<%=basePath%>purchase/request#table-4">未通过申请</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">采购订单管理</li>
                <li><a href="<%=basePath%>purchase/orders">订单记录</a></li>
                <li><a href="<%=basePath%>purchase/orderbuy">订单采购</a></li>
                <li><a href="<%=basePath%>purchase/orderreimburse">订单报销</a></li>
              </ul>
            </li>
            <li id="dd3" class="dropdown">
              <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">样本管理 <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li class="dropdown-header">样本信息管理</li>
                <li><a href="<%=basePath%>sampleinfo/query">信息查询</a></li>
                <li><a href="<%=basePath%>sampleinfo/statistics">信息统计</a></li>
                <li role="separator" class="divider"></li>
                <li class="dropdown-header">仓库信息盘点</li>
                <li><a href="<%=basePath%>check/index">历次盘点总览</a></li>
                <li><a href="<%=basePath%>check/findbyid?id=">盘点详情查询</a></li>
                <li><a href="<%=basePath%>check/creat">开始盘点</a></li>
              </ul>
            </li>
            <li id="dd4" class="dropdown">
              <a href="<%=basePath%>tech" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">技术信息 <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="<%=basePath%>tech/check" id="appid">审核入库样本</a></li>
                <li><a href="<%=basePath%>tech/all">查询处理方法</a></li>
                <li><a href="<%=basePath%>tech/change">修改处理方法</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <script src="<%=basePath%>static/js/jquery-3.4.1.min.js"></script>
    <script>
    var urlstr = location.href;
    $(".nav li").each(function () {
    	var hrefstr = $(this).children('a').attr('href');
        if (hrefstr!='' && (urlstr + '/').indexOf(hrefstr) > -1) {
            $(this).addClass('active'); urlstatus = true;
            if($(this).parent('ul').parent('li').attr('id') != null){
        		$(this).parent('ul').parent('li').addClass('active');;
        	}
        } else {
            $(this).removeClass('active');
        }
    });  
    </script>