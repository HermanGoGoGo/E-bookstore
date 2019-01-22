﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	
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

    <title>e书网 - 首页</title>
    
	<!-- Bootstrap 4.0-->
	<link rel="stylesheet" href="<%=path%>/assets/vendor_components/bootstrap/dist/css/bootstrap.css">
	
	<link rel="stylesheet"  type="text/css" href="<%=path%>/main/css/style-1.css">	
	
    <!-- c3 CSS -->
    <link rel="stylesheet" type="text/css" href="<%=path%>/assets/vendor_components/c3/c3.min.css">
	
	<!-- Bootstrap extend-->
	<link rel="stylesheet" href="<%=path%>/main/css/bootstrap-extend.css">
	
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
<!-- loading -->
		<div class="loader">
			<div class="text">Loading...</div>
			<div class="horizontal">
				<div class="circlesup">
					<div class="circle"></div>
					<div class="circle"></div>
					<div class="circle"></div>
					<div class="circle"></div>
					<div class="circle"></div>
				</div>
				<div class="circlesdwn">
					<div class="circle"></div>
					<div class="circle"></div>
					<div class="circle"></div>
					<div class="circle"></div>
					<div class="circle"></div>
				</div>
			</div>
			<div class="vertical">
				<div class="circlesup">
					<div class="circle"></div>
					<div class="circle"></div>
					<div class="circle"></div>
					<div class="circle"></div>
					<div class="circle"></div>
				</div>
				<div class="circlesdwn">
					<div class="circle"></div>
					<div class="circle"></div>
					<div class="circle"></div>
					<div class="circle"></div>
					<div class="circle"></div>
				</div>
			</div>
		</div>
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
		  <a id="toggle_res_search" data-toggle="collapse" data-target="#search_form" class="res-only-view" href="javascript:void(0);"><i class="mdi mdi-magnify"></i></a>
		  <form id="search_form" role="search" class="top-nav-search pull-left collapse ml-20">
				<div class="input-group">
					<input type="text" name="searchByBookName" class="form-control" placeholder="Search">
						<span class="input-group-btn">
							<button type="button" class="btn  btn-default" data-target="#search_form" data-toggle="collapse" aria-label="Close" aria-expanded="true" ><i class="mdi mdi-magnify"></i></button>
						</span>
				</div>
		  </form> 
		
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
							<h4 class="mb-0 mt-0">Messages</h4>
						</div>
						<div>
							<a href="#" class="text-danger">Clear All</a>
						</div>
					</div>
				</div>
			  </li>
			  <li>
				<!-- inner menu: contains the actual data -->
				<ul class="menu sm-scrol">
				  <li><!-- start message -->
					<a href="#">

					  <div class="mail-contnet">
						 <h4>
						  Lorem Ipsum
						  <small><i class="fa fa-clock-o"></i> 15 mins</small>
						 </h4>
						 <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</span>
					  </div>
					</a>
				  </li>
				  <!-- end message -->
				  <li>
					<a href="#">
					  <div class="pull-left">
						<img src="<%=path%>/images/user3-128x128.jpg" class="rounded-circle" alt="User Image">
					  </div>
					  <div class="mail-contnet">
						 <h4>
						  Nullam tempor
						  <small><i class="fa fa-clock-o"></i> 4 hours</small>
						 </h4>
						 <span>Curabitur facilisis erat quis metus congue viverra.</span>
					  </div>
					</a>
				  </li>
				  <li>
					<a href="#">
					  <div class="pull-left">
						<img src="<%=path%>/images/user4-128x128.jpg" class="rounded-circle" alt="User Image">
					  </div>
					  <div class="mail-contnet">
						 <h4>
						  Proin venenatis
						  <small><i class="fa fa-clock-o"></i> Today</small>
						 </h4>
						 <span>Vestibulum nec ligula nec quam sodales rutrum sed luctus.</span>
					  </div>
					</a>
				  </li>
				  <li>
					<a href="#">
					  <div class="pull-left">
						<img src="<%=path%>/images/user3-128x128.jpg" class="rounded-circle" alt="User Image">
					  </div>
					  <div class="mail-contnet">
						 <h4>
						  Praesent suscipit
						<small><i class="fa fa-clock-o"></i> Yesterday</small>
						 </h4>
						 <span>Curabitur quis risus aliquet, luctus arcu nec, venenatis neque.</span>
					  </div>
					</a>
				  </li>
				  <li>
					<a href="#">
					  <div class="pull-left">
						<img src="<%=path%>/images/user4-128x128.jpg" class="rounded-circle" alt="User Image">
					  </div>
					  <div class="mail-contnet">
						 <h4>
						  Donec tempor
						  <small><i class="fa fa-clock-o"></i> 2 days</small>
						 </h4>
						 <span>Praesent vitae tellus eget nibh lacinia pretium.</span>
					  </div>

					</a>
				  </li>
				</ul>
			  </li>
			  <li class="footer">				  
				  <a href="#" class="bg-light">See all e-Mails</a>
			  </li>
			</ul>
		  </li>
		  <!-- User Account-->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="<%=path%>/images/avatar/7.jpg" class="user-image rounded-circle" alt="User Image">
            </a>
            <ul class="dropdown-menu animated flipInX">
              <!-- User image -->
              <li class="user-header bg-img" style="background-image: url(<%=path%>/images/logo-big.png)" data-overlay="3">
				  <div class="flexbox align-self-center">					  
				  	<img src="<%=path%>/images/avatar/7.jpg" class="float-left rounded-circle" alt="User Image">					  
					<h5 class="user-name align-self-center ">
					  <span>${currentUser.username} </span> <br />
					  <small>${currentUser.usercode}</small>
					</h5>
				  </div>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
				    <a class="dropdown-item" href="javascript:void(0)"><i class="ion ion-person"></i> My Profile</a>
					<a class="dropdown-item" href="javascript:void(0)"><i class="ion ion-bag"></i> My Balance</a>
					<a class="dropdown-item" href="javascript:void(0)"><i class="ion ion-email-unread"></i> Inbox</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="javascript:void(0)" data-toggle="control-sidebar"><i class="ion ion-settings"></i> Account Setting</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="<%=path%>/toLoginPage.action"><i class="ion-log-out"></i> Logout</a>
					<div class="dropdown-divider"></div>
					<div class="p-10"><a href="javascript:void(0)" class="btn btn-sm btn-rounded btn-success">View Profile</a></div>
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
          <img src="<%=path%>/images/logo-big.png" class="rounded-circle" alt="User Image">
        </div>
        <div class="info">
       	    <a class="dropdown-item" ><i>${currentUser.username}</i></a>
			<a href="" class="link" data-toggle="tooltip" title="" data-original-title="Settings"><i class="ion ion-gear-b"></i></a>
            <a href="" class="link" data-toggle="tooltip" title="" data-original-title="Email"><i class="ion ion-android-mail"></i></a>
            <a href="<%=path%>/toLoginPage.action" class="link" data-toggle="tooltip" title="" data-original-title="Logout"><i class="ion ion-power"></i></a>
        </div>
      </div>
      
      <!-- sidebar menu-->
      <ul class="sidebar-menu" data-widget="tree">
		  
        <li class="header nav-small-cap">选项</li>
		
		<li class="treeview active">
          <a href="#">
            <i class="ti-dashboard"></i>
            <span></span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class="active"><a href="<%=path%>/home/toHomePage.action"><i class="ti-more"></i>购买书</a></li>
            <li><a href="#"><i class="ti-more"></i>出售书</a></li>
            <li><a href="#"><i class="ti-more"></i>出售书</a></li>
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
		<a href="<%=path%>/toLoginPage.action" class="link" data-toggle="tooltip" title="" data-original-title="Logout"><i class="fa fa-power-off"></i></a>
	</div>
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper"  style="display: none;">
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
								<li class="breadcrumb-item active" aria-current="page">书籍信息显示</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
		</div>

		<!-- Main content -->
		<section class="content">
			
			<div class="row">
				<div class="col-xl-4 col-12">
					<div class="box box-body">
					  <h6 class="text-uppercase">全部</h6>
					  <div class="flexbox mt-2">
						<span class=" font-size-30">85,987</span>
						<span class="ion ion-ios-bookmarks-outline text-danger font-size-40"></span>
					  </div>
					</div>
				</div>
				<!-- /.col -->

				<div class="col-xl-4 col-12">
					<div class="box box-body">
					  <h6 class="text-uppercase">全市</h6>
					  <div class="flexbox mt-2">
						<span class=" font-size-30">2,951</span>
						<span class="ion ion-ribbon-a text-info font-size-40"></span>
					  </div>
					</div>
				</div>
				<!-- /.col -->
				<div class="col-xl-4 col-12">
					<div class="box box-body">
					  <h6 class="text-uppercase">全校</h6>
					  <div class="flexbox mt-2">
						<span class=" font-size-30">15,845</span>
						<span class="ion ion-university text-primary font-size-40"></span>
					  </div>
					</div>
				</div>
				<!-- /.col -->
		    </div>					
			
			<div class="row">
				<div class="col-12">
	
				 <div class="box">
					<div class="box-header with-border">
					  <h3 class="box-title">书籍展示</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<div class="table-responsive">
						  <table id="example5" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>编号</th>
									<th>名称</th>
									<th>作者</th>
									<th>描述</th>
									<th>出售人</th>
									<th>价钱</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${bookVoList }" var="book" varStatus="status">
									  <tr>
										<td>${book.bookId}</td>
										<td><a href="<%=path%>/home/toHomePage.action?id=${book.bookId}">${book.bookname}</a></td>
										<td>${book.bookAuthor}</td>
										<td>
										  <span class="badge badge-success">${book.bookDescription}</span>
										</td>
										<td>${book.user.username}</td>
										<td>$ ${book.bookPrice}</td>
									  </tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<th>编号</th>
									<th>名称</th>
									<th>作者</th>
									<th>描述</th>
									<th>出售人</th>
									<th>价钱</th>
								</tr>
							</tfoot>
						  </table>
						</div>
					</div>
					<!-- /.box-body -->
				  </div>
				  <!-- /.box -->
					<!-- /.box-body -->
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
      <li class="nav-item"><a >Setting</a></li>
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
		<script type="text/javascript">
		window.onload=function(){
		    $(".loader").fadeOut();
		    $(".content-wrapper").show();
		}
	</script>
	  
	
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
    
    <script type="text/javascript">
			$.hulla = new hullabaloo();
			setTimeout(function() {
				$.hulla.send("Hi！这里是jQuery之家！", "success");
			}, 1000);
			function checkTime(){			
		        var nowtime=Date.parse(new Date());
		        $(".username").html("详细地址不能为空");
		        console.log(nowtime);	
		        <%-- $.ajax( {

		           // "dataType" : 'json',

		            "type" : "POST",

		            "url" : "<%=path%>/toHomepage.action",

		            "data" : { "searchByBookName" : "123" },

		            "success" : function(  ) {           

		            	$("#username").value== "详细地址不能为空";
		            	console.log("new");
		            }

		         } ); --%>
		    }
		
		    //setInterval("checkTime()","5000");

	</script>
</body>
</html>
