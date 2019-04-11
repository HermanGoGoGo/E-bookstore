﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ page import="com.herman.ebookstore.util.RelativeDateFormat"%> 
<%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	
	
	RelativeDateFormat  format = new RelativeDateFormat();
%> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<%=path%>/images/favicon.ico">

    <title>e书网 - </title>
    
	<!-- Bootstrap 4.0-->
	<link rel="stylesheet" href="<%=path%>/assets/vendor_components/bootstrap/dist/css/bootstrap.css">
	
	<link rel="stylesheet"  type="text/css" href="<%=path%>/main/css/style-1.css">	
	
    <!-- c3 CSS -->
    <link rel="stylesheet" type="text/css" href="<%=path%>/assets/vendor_components/c3/c3.min.css">
	
	<!-- Bootstrap extend-->
	<link rel="stylesheet" href="<%=path%>/main/css/bootstrap-extend.css">
	
		<!-- owlcarousel-->
	<link rel="stylesheet" href="<%=path%>/assets/vendor_components/OwlCarousel2/dist/assets/owl.carousel.css">
	<link rel="stylesheet" href="<%=path%>/assets/vendor_components/OwlCarousel2/dist/assets/owl.theme.default.css">
	
	<!-- theme style -->
	<link rel="stylesheet" href="<%=path%>/main/css/master_style.css">
	
	<!-- Ekan Admin skins -->
	<link rel="stylesheet" href="<%=path%>/main/css/skins/_all-skins.css">
	

    <!-- Data Table-->
	<link rel="stylesheet" type="text/css" href="<%=path%>/assets/vendor_components/datatable/datatables.min.css"/>
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->


     
  </head>

<body class="hold-transition skin-info dark-sidebar light sidebar-mini">
<div class="wrapper" >
  <header class="main-header">
    <!-- Logo -->
    <a href="<%=path%>/home/toHomePage.action" class="logo">
      <!-- mini logo -->
	  <div class="logo-mini">
		  <span class="light-logo"><img src="<%=path%>/images/logo-light.png" alt="logo"></span>
		  <span class="dark-logo"><img src="<%=path%>/images/logo-dark.png" alt="logo"></span>
	  </div>
      <!-- logo-->
      <div class="logo-lg">
		  <span class="light-logo"><img src="<%=path%>/images/logo-light-text.png" alt="logo"></span>
	  	  <span class="dark-logo"><img src="<%=path%>/images/logo-dark-text.png" alt="logo"></span>
	  </div>
    </a>
    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
	  <div>
		  <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
			<i class="ti-align-left"></i>
		  </a>
<!-- 		  <a id="toggle_res_search" data-toggle="collapse" data-target="#search_form" class="res-only-view" href="javascript:void(0);"><i class="mdi mdi-magnify"></i></a>
		  <form id="search_form" role="search" class="top-nav-search pull-left collapse ml-20">
				<div class="input-group">
					<input type="text" name="searchByBookName" class="form-control" placeholder="请输入书名">
						<span class="input-group-btn">
							<button type="button" class="btn  btn-default" data-target="#search_form" data-toggle="collapse" aria-label="Close" aria-expanded="true" ><i class="mdi mdi-magnify"></i></button>
						</span>
				</div>
		  </form>  -->
		
	  </div>
		
      <div class="navbar-custom-menu r-side">
        <ul class="nav navbar-nav">
		  <!-- Messages -->
		  <li class="dropdown messages-menu">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">
			  <i class="mdi mdi-email"></i>
			</a>
			<ul class="dropdown-menu animated bounceIn">

			  <li class="header">
				<div class="p-20 bg-light">
					<div class="flexbox">
						<div>
							<h4 class="mb-0 mt-0">最新消息</h4>
						</div>
						<div>
							<a href="#" class="text-danger">清除</a>
						</div>
					</div>
				</div>
			  </li>
			  <li>
				<!-- inner menu: contains the actual data -->
				<ul class="menu sm-scrol" id="menuForAllMessages">
			      <c:forEach items="${messageDtos}" var="message" varStatus="status" >
			      <li>
					<a href="<%=path%>/message/showOneMessage.action?sendUserId=${message.sendUserId}">
					  <div class="pull-left">
						<img src="<%=path%>${message.sendUserImage}" class="rounded-circle" alt="User Image">
					  </div>
					  <div class="mail-contnet">
						 <h4>
						  ${message.sendUserName}
						  <small><i class="fa fa-clock-o"></i> ${message.showTime}</small>
						 </h4>
						 <span style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">${message.messInfo}</span>
					  </div>
					</a>
				  </li>
			      </c:forEach>
				</ul>
			  </li>
			  <li class="footer">				  
				  <a class="bg-light" href="<%=path%>/message/showOneMessage.action">查看所有的信息</a>
			  </li>
			</ul>
		  </li>
		  <!-- User Account-->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="<%=path%>${currentUser.image}" class="user-image rounded-circle" alt="User Image">
            </a>
            <ul class="dropdown-menu animated flipInX">
              <!-- User image -->
              <li class="user-header bg-img" style="background-image: url(<%=path%>${currentUser.image})" data-overlay="3">
				  <div class="flexbox align-self-center">					  
				  	<img src="<%=path%>${currentUser.image}" class="float-left rounded-circle" alt="User Image">					  
					<h5 class="user-name align-self-center ">
					  <span>${currentUser.username} </span> <br />
					  <small>${currentUser.usercode}</small>
					</h5>
				  </div>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
				    <a class="dropdown-item" href="javascript:void(0)"><i class="ion ion-person"></i> 修改个人信息</a>
					<a class="dropdown-item" href="javascript:void(0)"><i class="ion ion-bag"></i> 购买&出售信息</a>
					<a class="dropdown-item" href="javascript:void(0)"><i class="ion ion-email-unread"></i> 信息</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="javascript:void(0)" data-toggle="control-sidebar"><i class="ion ion-settings"></i> 基础界面设置</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="<%=path%>/page.action?type=login"><i class="ion-log-out"></i> 重新登录</a>
					<div class="dropdown-divider"></div>
					<div class="p-10"><a href="javascript:void(0)" class="btn btn-sm btn-rounded btn-success">返回</a></div>
              </li>
            </ul>
          </li>	
			
		  
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-cog fa-spin"></i></a>
          </li>
			
        </ul>
      </div>
    </nav>
  </header>
  
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar-->
    <section class="sidebar">
		  
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="image">
          <img src="<%=path%>${currentUser.image}" class="rounded-circle" alt="User Image">
        </div>
        <div class="info">
       	    <a class="dropdown-item" ><i>${currentUser.username}</i></a>
			<a href="" class="link" data-toggle="tooltip" title="" data-original-title="Settings"><i class="ion ion-gear-b"></i></a>
            <a href="" class="link" data-toggle="tooltip" title="" data-original-title="Email"><i class="ion ion-android-mail"></i></a>
            <a href="<%=path%>/page.action?type=login" class="link" data-toggle="tooltip" title="" data-original-title="Logout"><i class="ion ion-power"></i></a>
        </div>
      </div>
      
      <!-- sidebar menu-->
      <ul class="sidebar-menu" data-widget="tree">
		  
        <li class="header nav-small-cap">选项</li>
		
		<li class="treeview active">
          <a href="#">
            <i class="ti-dashboard"></i>
            <span>交易中心</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class="active"><a href="<%=path%>/home/toHomePage.action"><i class="ti-more"></i>购买书</a></li>
            <li><a href="#"><i class="ti-more"></i>出售书</a></li>
            <li><a href="#"><i class="ti-more"></i>出售书</a></li>
          </ul>
          <a href="#">
            <i class="ti-pencil-alt"></i>
            <span>个人中心</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="<%=path%>/message/showOneMessage.action"><i class="ti-more"></i>消息中心</a></li>
          </ul>
        </li>  
        
      </ul>
    </section>
    <div class="sidebar-footer">
		<!-- item-->
		<a href="#" class="link" data-toggle="tooltip" title="" data-original-title="Settings"><i class="fa fa-cog fa-spin"></i></a>
		<!-- item-->
		<a href="pages/mailbox_inbox.html" class="link" data-toggle="tooltip" title="" data-original-title="Email"><i class="fa fa-envelope"></i></a>
		<!-- item-->
		<a href="<%=path%>/page.action?type=login" class="link" data-toggle="tooltip" title="" data-original-title="Logout"><i class="fa fa-power-off"></i></a>
	</div>
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" >
	  <div class="container-full">
		<!-- Content Header (Page header) -->	  
		<div class="content-header">
			<div class="d-flex align-items-center">
				<div class="mr-auto">
					<h3 class="page-title">购买书</h3>
					<div class="d-inline-block align-items-center">
						<nav>
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#"><i class="mdi mdi-home-outline"></i></a></li>
								<li class="breadcrumb-item active" aria-current="page">书籍详情</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
		</div>

		<!-- Main content -->
		<section class="content">
		   		<div class="col-12 col-xl-8 m-auto">
				<div class="box">		
					<div class="box-header bg-warning">
						<h4 class="box-title">Packages</h4>
						<ul class="box-controls pull-right">
						  <li class="dropdown">
							<a data-toggle="dropdown" href="#" class="btn btn-rounded btn-outline btn-white px-10">Stats</a>
							<div class="dropdown-menu dropdown-menu-right">
							  <a class="dropdown-item" href="#"><i class="ti-import"></i> Import</a>
							  <a class="dropdown-item" href="#"><i class="ti-export"></i> Export</a>
							  <a class="dropdown-item" href="#"><i class="ti-printer"></i> Print</a>
							  <div class="dropdown-divider"></div>
							  <a class="dropdown-item" href="#"><i class="ti-settings"></i> Settings</a>
							</div>
						  </li>
						</ul>
					</div>
					<div class="box-body bg-warning">										
						<div class="px-10 py-30 bg-white text-dark">
							<h5 class="px-10 mb-15 font-weight-700">Partners Sale</h5>
						     <ul class="flexbox flex-justified">
							 <li class="px-30">
							    <p> 
							     <h6 class="px-30  mb-0 text-bold"><i class="fa fa-user"></i> 书名：							   
							      <small>
								  	合演
							      </small>
							      </h6> 
							    </p>
							    <p> 
							     <h6 class="mb-0 text-bold">书名：							   
							      <small>
								  	合演
							      </small>
							      </h6> 
							    </p>
							    <p> 
							     <h6 class="mb-0 text-bold">书名：							   
							      <small>
								  	合演
							      </small>
							      </h6> 
							    </p>
							    <p> 
							     <h6 class="mb-0 text-bold">书名：							   
							      <small>
								  	合演
							      </small>
							      </h6> 
							    </p>
							   <p class="my-10">
							     <small>
								  <i class="fa fa-user"></i> by <a href="#">dashu</a> 
							     </small>
							   </p>
							   <p class="box-text" style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">nihao</p>
							   <div class="flexbox align-items-center mt-3">
							   <input type="file" class="form-control">
							      <a href="<%=path%>/home/toHomePage.action?id=${hotBook.id}" class="btn btn-flat btn-primary btn-sm">查看详情</a>
							   </div>
							 </li>
							 <li class="px-10">
							   <form enctype="multipart/form-data" method="post" id="upload" action="<%=path%>/book/saveBook.action">
									  <input id="file" type="file" name="image" id="image" > 
									  <input type="button" value="上传" onclick="validate()"  />
							   </form>
							   <script type="text/javascript">
							   function validate() {

								   var a=document.getElementById("file");
									  var form=document.getElementById("upload");
									  if(a.value==""){		   
										   alert("请先选择图片");
								           return false;
										  }
									  else{
										  form.submit();
										  console.log("成功");
										  return false;
									  }
							     }
						            	
							   </script>
							 </li>
						   </ul>						
						</div>
					</div>
					
				</div>
			</div>  
			
		</section>
		<!-- /.content -->
	  </div>
  </div>
  <!-- /.content-wrapper -->
	
  <footer class="main-footer">
    <div class="pull-right d-none d-sm-inline-block">
        <ul class="nav nav-primary nav-dotted nav-dot-separated justify-content-center justify-content-md-end">
		  <li class="nav-item">
			<a class="nav-link" href="javascript:void(0)">常见问题</a>
		  </li>
		  <li class="nav-item">
			<a class="nav-link" href="#">谢谢支持</a>
		  </li>
		</ul>
    </div>
	  &copy; 2019 <a href="#">0154242黄金宝</a>. 毕业设计.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
	  
	<div class="rpanel-title"><span class="btn pull-right"><i class="ion ion-close" data-toggle="control-sidebar"></i></span> </div>  
    <!-- Create the tabs -->
    <ul class="nav nav-tabs control-sidebar-tabs">
      <li class="nav-item"><a >设置</a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane" id="control-sidebar-home-tab">
          <div class="flexbox">
			<a href="javascript:void(0)" class="text-grey">
				<i class="ti-more"></i>
			</a>	
			<p>Users</p>
			<a href="javascript:void(0)" class="text-right text-grey"><i class="ti-plus"></i></a>
		  </div>
		  <div class="lookup lookup-sm lookup-right d-none d-lg-block">
			<input type="text" name="s" placeholder="Search" class="w-p100">
		  </div>
          <div class="media-list media-list-hover mt-20">
			  
		  </div>

      </div>
    </div>
  </aside>
  <!-- /.control-sidebar -->
  
  <!-- Add the sidebar's background. This div must be placed immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
  
</div>
<!-- ./wrapper -->
  	
	<!-- jQuery 3 -->
	<script src="<%=path%>/assets/vendor_components/jquery-3.3.1/jquery-3.3.1.js"></script>
	  	
	<!-- jQuery UI 1.11.4 -->
	<script src="<%=path%>/assets/vendor_components/jquery-ui/jquery-ui.js"></script>
	
	<!-- popper -->
	<script src="<%=path%>/assets/vendor_components/popper/dist/popper.min.js"></script>
	
	<!-- Bootstrap 4.0-->
	<script src="<%=path%>/assets/vendor_components/bootstrap/dist/js/bootstrap.js"></script>	
	
	<!-- date-range-picker -->
<%-- 	<script src="<%=path%>/assets/vendor_components/moment/min/moment.min.js"></script>
	<script src="<%=path%>/assets/vendor_components/bootstrap-daterangepicker/daterangepicker.js"></script> --%>
	
	<!-- Slimscroll -->
	<script src="<%=path%>/assets/vendor_components/jquery-slimscroll/jquery.slimscroll.js"></script>
	
	<!-- FastClick -->
	<script src="<%=path%>/assets/vendor_components/fastclick/lib/fastclick.js"></script>
	
	<!-- Carousel -->
	<script src="<%=path%>/assets/vendor_components/OwlCarousel2/dist/owl.carousel.js"></script>
	
    <!-- C3 Plugins -->
    <script src="<%=path%>/assets/vendor_components/c3/d3.min.js"></script>
    <script src="<%=path%>/assets/vendor_components/c3/c3.min.js"></script>
	
	<!-- Ekan Admin App -->
	<script src="<%=path%>/main/js/template.js"></script>
	
	<!-- This is data table -->
    <script src="<%=path%>/assets/vendor_components/datatable/datatables.min.js"></script>
	<script src="<%=path%>/main/js/pages/data-table.js"></script>
	
	<!-- Ekan Admin dashboard demo (This is only for demo purposes) -->
	<%-- <script src="<%=path%>/main/js/pages/dashboard.js"></script>
	<script src="<%=path%>/main/js/pages/dashboard-chart.js"></script> --%>
	
	<!-- Ekan Admin for demo purposes -->
	<script src="<%=path%>/main/js/demo.js"></script>	
	
	<!-- Prompting -->
    <script src="<%=path%>/assets/vendor_components/hullabaloo/hullabaloo.js"></script>
    
    <script src="<%=path%>/main/js/pages/widget-blog.js"></script>
    
    <script type="text/javascript">
			$.hulla = new hullabaloo();
			//var usercode = '${currentUser.usercode}';

			function checkTime(){
		        $.ajax({
					type: "post",
					url: "<%=path%>/base/getUserMessage.action",
					data: {
					},
					dataType: 'json',
					success: function(data) {
						console.log(data);
		            	if(data.status == '200'){
		            		$("#menuForAllMessages li").remove();
		            		$.hulla.send("您有最新消息请查看收件箱", "success");
		            		var str = "";
		                    for(var i=0;i<data.obj.length;i++){
		                        str += "<li>" +
		                                "<a href='<%=path%>/message/showOneMessage.action?sendUserId=" + data.obj[i].sendUserId + " '>" +
		                                "<div class=\"pull-left\">" +
		                                "<img src=\"<%=path%>"+data.obj[i].sendUserImage +"\" class=\"rounded-circle\" alt=\"User Image\">" +
		                                "</div>" +
		                                "<div class=\"mail-contnet\">" +
		                                "<h4> " +data.obj[i].sendUserName +
		                                "<small><i class=\"fa fa-clock-o\"></i> "+data.obj[i].showTime +"</small>"+
		                                "</h4>" +
		                                " <span style=\"overflow: hidden;text-overflow: ellipsis;white-space: nowrap;\">"+data.obj[i].messInfo+"</span> " +
		                                "</div>" +
		                                "</a>" +
		                                "</li>";
		            	}
		                $("#menuForAllMessages").append(str);
		                console.log(str);
		            	}
					},
					error: function() {
						console.log("error");
					}
				}); 
		    }
		
		    setInterval("checkTime()","3000"); 

	</script>
</body>
</html>
