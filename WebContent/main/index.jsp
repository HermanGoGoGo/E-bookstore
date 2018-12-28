﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ page contentType="text/html;charset=utf-8"%>
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

    <title>Ekan Admin - Dashboard</title>
    
	<!-- Bootstrap 4.0-->
	<link rel="stylesheet" href="<%=path%>/assets/vendor_components/bootstrap/dist/css/bootstrap.css">
	
	<!-- daterange picker -->	
	<link rel="stylesheet" href="<%=path%>/assets/vendor_components/bootstrap-daterangepicker/daterangepicker.css">
	
    <!-- c3 CSS -->
    <link rel="stylesheet" type="text/css" href="<%=path%>/assets/vendor_components/c3/c3.min.css">
	
	<!-- Bootstrap extend-->
	<link rel="stylesheet" href="<%=path%>/main/css/bootstrap-extend.css">
	
	<!-- theme style -->
	<link rel="stylesheet" href="<%=path%>/main/css/master_style.css">
	
	<!-- Ekan Admin skins -->
	<link rel="stylesheet" href="<%=path%>/main/css/skins/_all-skins.css">
	

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

     
  </head>

<body class="hold-transition skin-info dark-sidebar light sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="index.html" class="logo">
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
					<input type="text" name="exampleInput1Group2" class="form-control" placeholder="Search">
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
					  <div class="pull-left">
						<img src="<%=path%>/images/user2-160x160.jpg" class="rounded-circle" alt="User Image">
					  </div>
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
		  <!-- Notifications -->
		  <li class="dropdown notifications-menu">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">
			  <i class="mdi mdi-bell"></i>
			</a>
			<ul class="dropdown-menu animated bounceIn">

			  <li class="header">
				<div class="bg-light p-20">
					<div class="flexbox">
						<div>
							<h4 class="mb-0 mt-0">Notifications</h4>
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
				  <li>
					<a href="#">
					  <i class="fa fa-users text-info"></i> Curabitur id eros quis nunc suscipit blandit.
					</a>
				  </li>
				  <li>
					<a href="#">
					  <i class="fa fa-warning text-warning"></i> Duis malesuada justo eu sapien elementum, in semper diam posuere.
					</a>
				  </li>
				  <li>
					<a href="#">
					  <i class="fa fa-users text-danger"></i> Donec at nisi sit amet tortor commodo porttitor pretium a erat.
					</a>
				  </li>
				  <li>
					<a href="#">
					  <i class="fa fa-shopping-cart text-success"></i> In gravida mauris et nisi
					</a>
				  </li>
				  <li>
					<a href="#">
					  <i class="fa fa-user text-danger"></i> Praesent eu lacus in libero dictum fermentum.
					</a>
				  </li>
				  <li>
					<a href="#">
					  <i class="fa fa-user text-primary"></i> Nunc fringilla lorem 
					</a>
				  </li>
				  <li>
					<a href="#">
					  <i class="fa fa-user text-success"></i> Nullam euismod dolor ut quam interdum, at scelerisque ipsum imperdiet.
					</a>
				  </li>
				</ul>
			  </li>
			  <li class="footer">
				  <a href="#" class="bg-light">View all</a>
			  </li>
			</ul>
		  </li>
		  <!-- Tasks-->
		  <li class="dropdown tasks-menu">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">
			  <i class="mdi mdi-bulletin-board"></i>
			</a>
			<ul class="dropdown-menu animated bounceIn">

			  <li class="header">
				<div class="p-20 bg-light">
					<div class="flexbox">
						<div>
							<h4 class="mb-0 mt-0">Tasks</h4>
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
				  <li><!-- Task item -->
					<a href="#">
					  <h3>
						Lorem ipsum dolor sit amet
						<small class="pull-right">30%</small>
					  </h3>
					  <div class="progress xs">
						<div class="progress-bar progress-bar-danger" style="width: 30%" role="progressbar"
							 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
						  <span class="sr-only">30% Complete</span>
						</div>
					  </div>
					</a>
				  </li>
				  <!-- end task item -->
				  <li><!-- Task item -->
					<a href="#">
					  <h3>
						Vestibulum nec ligula
						<small class="pull-right">20%</small>
					  </h3>
					  <div class="progress xs">
						<div class="progress-bar progress-bar-info" style="width: 20%" role="progressbar"
							 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
						  <span class="sr-only">20% Complete</span>
						</div>
					  </div>
					</a>
				  </li>
				  <!-- end task item -->
				  <li><!-- Task item -->
					<a href="#">
					  <h3>
						Donec id leo ut ipsum
						<small class="pull-right">70%</small>
					  </h3>
					  <div class="progress xs">
						<div class="progress-bar progress-bar-success" style="width: 70%" role="progressbar"
							 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
						  <span class="sr-only">70% Complete</span>
						</div>
					  </div>
					</a>
				  </li>
				  <!-- end task item -->
				  <li><!-- Task item -->
					<a href="#">
					  <h3>
						Praesent vitae tellus
						<small class="pull-right">40%</small>
					  </h3>
					  <div class="progress xs">
						<div class="progress-bar progress-bar-warning" style="width: 40%" role="progressbar"
							 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
						  <span class="sr-only">40% Complete</span>
						</div>
					  </div>
					</a>
				  </li>
				  <!-- end task item -->
				  <li><!-- Task item -->
					<a href="#">
					  <h3>
						Nam varius sapien
						<small class="pull-right">80%</small>
					  </h3>
					  <div class="progress xs">
						<div class="progress-bar progress-bar-primary" style="width: 80%" role="progressbar"
							 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
						  <span class="sr-only">80% Complete</span>
						</div>
					  </div>
					</a>
				  </li>
				  <!-- end task item -->
				  <li><!-- Task item -->
					<a href="#">
					  <h3>
						Nunc fringilla
						<small class="pull-right">90%</small>
					  </h3>
					  <div class="progress xs">
						<div class="progress-bar progress-bar-info" style="width: 90%" role="progressbar"
							 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
						  <span class="sr-only">90% Complete</span>
						</div>
					  </div>
					</a>
				  </li>
				  <!-- end task item -->
				</ul>
			  </li>
			  <li class="footer">
				  <a href="#" class="bg-light">View all tasks</a>
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
              <li class="user-header bg-img" style="background-image: url(<%=path%>/images/user-info.jpg)" data-overlay="3">
				  <div class="flexbox align-self-center">					  
				  	<img src="<%=path%>/images/avatar/7.jpg" class="float-left rounded-circle" alt="User Image">					  
					<h4 class="user-name align-self-center">
					  <span>Samuel Brus</span>
					  <small>samuel@gmail.com</small>
					</h4>
				  </div>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
				    <a class="dropdown-item" href="javascript:void(0)"><i class="ion ion-person"></i> My Profile</a>
					<a class="dropdown-item" href="javascript:void(0)"><i class="ion ion-bag"></i> My Balance</a>
					<a class="dropdown-item" href="javascript:void(0)"><i class="ion ion-email-unread"></i> Inbox</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="javascript:void(0)"><i class="ion ion-settings"></i> Account Setting</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="javascript:void(0)"><i class="ion-log-out"></i> Logout</a>
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
			<a href="" class="link" data-toggle="tooltip" title="" data-original-title="Settings"><i class="ion ion-gear-b"></i></a>
            <a href="" class="link" data-toggle="tooltip" title="" data-original-title="Email"><i class="ion ion-android-mail"></i></a>
            <a href="" class="link" data-toggle="tooltip" title="" data-original-title="Logout"><i class="ion ion-power"></i></a>
        </div>
      </div>
      
      <!-- sidebar menu-->
      <ul class="sidebar-menu" data-widget="tree">
		  
        <li class="header nav-small-cap">PERSONAL</li>
		
		<li class="treeview active">
          <a href="#">
            <i class="ti-dashboard"></i>
            <span>Dashboard</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class="active"><a href="index.html"><i class="ti-more"></i>Main Dashboard</a></li>
            <li><a href="index-2.html"><i class="ti-more"></i>Dashboard 2</a></li>
            <li><a href="index-3.html"><i class="ti-more"></i>Dashboard 3</a></li>
            <li><a href="index-4.html"><i class="ti-more"></i>Dashboard 4</a></li>
            <li><a href="index-5.html"><i class="ti-more"></i>Dashboard 5</a></li>
          </ul>
        </li> 
		  
		<li class="header nav-small-cap">CHARTS</li>  
		  
        <li class="treeview">
          <a href="#">
            <i class="ti-stats-up"></i>
			<span>C3 Charts</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/charts_c3_axis.html"><i class="ti-more"></i>Axis Chart</a></li>
            <li><a href="pages/charts_c3_bar.html"><i class="ti-more"></i>Bar Chart</a></li>
            <li><a href="pages/charts_c3_data.html"><i class="ti-more"></i>Data Chart</a></li>
            <li><a href="pages/charts_c3_line.html"><i class="ti-more"></i>Line Chart</a></li>
          </ul>
        </li>
		  
        <li class="treeview">
          <a href="#">
            <i class="ti-pie-chart"></i>
			<span>Echarts</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/charts_echarts_basic.html"><i class="ti-more"></i>Basic Charts</a></li>
            <li><a href="pages/charts_echarts_bar.html"><i class="ti-more"></i>Bar Chart</a></li>
            <li><a href="pages/charts_echarts_pie_doughnut.html"><i class="ti-more"></i>Pie & Doughnut Chart</a></li>
          </ul>
        </li>
		  
        <li class="treeview">
          <a href="#">
            <i class="ti-pie-chart"></i>
			<span>AM Chart</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/charts_amCharts.html"><i class="ti-more"></i>amCharts Charts</a></li>
            <li><a href="pages/charts_amCharts_stock.html"><i class="ti-more"></i>amCharts Stock Charts</a></li>
            <li><a href="pages/charts_amCharts_maps.html"><i class="ti-more"></i>amCharts Maps</a></li>
          </ul>
        </li>
		  
        <li class="treeview">
          <a href="#">
            <i class="ti-pie-chart"></i>
			<span>Extra Chart</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/charts_chartjs.html"><i class="ti-more"></i>ChartJS</a></li>
            <li><a href="pages/charts_flot.html"><i class="ti-more"></i>Flot</a></li>
            <li><a href="pages/charts_inline.html"><i class="ti-more"></i>Inline charts</a></li>
            <li><a href="pages/charts_morris.html"><i class="ti-more"></i>Morris</a></li>
            <li><a href="pages/charts_peity.html"><i class="ti-more"></i>Peity</a></li>
            <li><a href="pages/charts_chartist.html"><i class="ti-more"></i>Chartist</a></li>
            <li><a href="pages/charts_rickshaw.html"><i class="ti-more"></i>Rickshaw Charts</a></li>
            <li><a href="pages/charts_nvd3.html"><i class="ti-more"></i>NVD3 Charts</a></li>
          </ul>
        </li>	  
		  
		<li class="treeview">
          <a href="#">
            <i class="ti-receipt"></i>
			<span>Invoice</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
			<li><a href="pages/invoice.html"><i class="ti-more"></i>Invoice</a></li>
			<li><a href="pages/invoicelist.html"><i class="ti-more"></i>Invoice List</a></li>	
          </ul>
        </li>			  
		  
        <li class="header nav-small-cap">APPS</li>
		  
        <li class="treeview">
          <a href="#">
            <i class="ti-layout-grid2"></i>
            <span>Extra</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
			<li><a href="pages/extra_calendar.html"><i class="ti-more"></i>Calendar</a></li>
            <li><a href="pages/extra_taskboard.html"><i class="ti-more"></i>Project DashBoard</a></li>
          </ul>
        </li>
		  
        <li class="treeview">
          <a href="#">
            <i class="ti-email"></i> <span>Mailbox</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/mailbox_inbox.html"><i class="ti-more"></i>Inbox</a></li>
            <li><a href="pages/mailbox_compose.html"><i class="ti-more"></i>Compose</a></li>
            <li><a href="pages/mailbox_read_mail.html"><i class="ti-more"></i>Read</a></li>
          </ul>
        </li>
		  
		<li class="treeview">
          <a href="#">
            <i class="ti-user"></i>
            <span>Members</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/members.html"><i class="ti-more"></i>Members Grid</a></li>
            <li><a href="pages/members_list.html"><i class="ti-more"></i>Members List</a></li>
            <li><a href="pages/member_profile.html"><i class="ti-more"></i>Member Profile</a></li>			  
          </ul>
        </li>	  
		
        <li class="header nav-small-cap">UI ELEMENTS</li>		  
		  
        <li class="treeview">
          <a href="#">
            <i class="ti-pencil-alt"></i>
            <span>Elements</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/ui_badges.html"><i class="ti-more"></i>Badges</a></li>
            <li><a href="pages/ui_border_utilities.html"><i class="ti-more"></i>Border</a></li>
            <li><a href="pages/ui_buttons.html"><i class="ti-more"></i>Buttons</a></li>	
            <li><a href="pages/ui_color_utilities.html"><i class="ti-more"></i>Color</a></li>
            <li><a href="pages/ui_dropdown.html"><i class="ti-more"></i>Dropdown</a></li>
            <li><a href="pages/ui_dropdown_grid.html"><i class="ti-more"></i>Dropdown Grid</a></li>
            <li><a href="pages/ui_typography.html"><i class="ti-more"></i>Typography</a></li>
            <li><a href="pages/ui_progress_bars.html"><i class="ti-more"></i>Progress Bars</a></li>
            <li><a href="pages/ui_grid.html"><i class="ti-more"></i>Grid</a></li>
            <li><a href="pages/ui_ribbons.html"><i class="ti-more"></i>Ribbons</a></li>
            <li><a href="pages/ui_sliders.html"><i class="ti-more"></i>Sliders</a></li>
            <li><a href="pages/ui_tab.html"><i class="ti-more"></i>Tabs</a></li>
            <li><a href="pages/ui_timeline.html"><i class="ti-more"></i>Timeline</a></li>
            <li><a href="pages/ui_timeline_horizontal.html"><i class="ti-more"></i>Timeline Horizontal</a></li>
            <li><a href="pages/component_bootstrap_switch.html"><i class="ti-more"></i>Bootstrap Switch</a></li>
            <li><a href="pages/component_media_advanced.html"><i class="ti-more"></i>Advanced Medias</a></li>
			<li><a href="pages/component_modals.html"><i class="ti-more"></i>Modals</a></li>
            <li><a href="pages/component_notification.html"><i class="ti-more"></i>Notification</a></li>
            <li><a href="pages/component_portlet_draggable.html"><i class="ti-more"></i>Draggable Portlets</a></li>
            <li><a href="pages/component_sweatalert.html"><i class="ti-more"></i>Sweet Alert</a></li>
            <li><a href="pages/component_rangeslider.html"><i class="ti-more"></i>Range Slider</a></li>
            <li><a href="pages/component_rating.html"><i class="ti-more"></i>Ratings</a></li>
            <li><a href="pages/component_animations.html"><i class="ti-more"></i>Animations</a></li>
			<li><a href="pages/box_advanced.html"><i class="ti-more"></i>Advanced Card</a></li>
            <li><a href="pages/box_basic.html"><i class="ti-more"></i>Basic Card</a></li>
            <li><a href="pages/box_color.html"><i class="ti-more"></i>Card Color</a></li>
          </ul>
        </li>  
		
		<li class="treeview">
          <a href="#">
            <i class="ti-smallcap"></i>
            <span>Icons</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/icons_fontawesome.html"><i class="ti-more"></i>Font Awesome</a></li>
            <li><a href="pages/icons_glyphicons.html"><i class="ti-more"></i>Glyphicons</a></li>
            <li><a href="pages/icons_material.html"><i class="ti-more"></i>Material Icons</a></li>	
            <li><a href="pages/icons_themify.html"><i class="ti-more"></i>Themify Icons</a></li>
            <li><a href="pages/icons_simpleline.html"><i class="ti-more"></i>Simple Line Icons</a></li>
            <li><a href="pages/icons_cryptocoins.html"><i class="ti-more"></i>Cryptocoins Icons</a></li>
            <li><a href="pages/icons_flag.html"><i class="ti-more"></i>Flag Icons</a></li>
            <li><a href="pages/icons_weather.html"><i class="ti-more"></i>Weather Icons</a></li>
          </ul>
        </li> 		  
		  
		<li class="treeview">
          <a href="#">
            <i class="ti-palette"></i>
            <span>Widgets</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/widgets_blog.html"><i class="ti-more"></i>Blog</a></li>
            <li><a href="pages/widgets_chart.html"><i class="ti-more"></i>Chart</a></li>
            <li><a href="pages/widgets.html"><i class="ti-more"></i>Widgets</a></li>
          </ul>
        </li>
		  
		
        <li class="header nav-small-cap">FORMS And TABLES</li> 
		
		
        <li class="treeview">
          <a href="#">
            <i class="ti-write"></i>
			<span>Forms</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/forms_advanced.html"><i class="ti-more"></i>Advanced Elements</a></li>
            <li><a href="pages/forms_editors.html"><i class="ti-more"></i>Editors</a></li>
            <li><a href="pages/forms_validation.html"><i class="ti-more"></i>Form Validation</a></li>
            <li><a href="pages/forms_wizard.html"><i class="ti-more"></i>Form Wizard</a></li>
            <li><a href="pages/forms_general.html"><i class="ti-more"></i>General Elements</a></li>
            <li><a href="pages/forms_mask.html"><i class="ti-more"></i>Formatter</a></li>
            <li><a href="pages/forms_dropzone.html"><i class="ti-more"></i>Dropzone</a></li>
          </ul>
        </li>
		  
        <li class="treeview">
          <a href="#">
            <i class="ti-layout-grid4"></i>
			<span>Tables</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/tables_simple.html"><i class="ti-more"></i>Simple tables</a></li>
            <li><a href="pages/tables_data.html"><i class="ti-more"></i>Data tables</a></li>
          </ul>
        </li> 		  
		  
		<li class="header nav-small-cap">SAMPLE PAGES</li>			  
		  
		<li class="treeview">
          <a href="#">
            <i class="ti-shield"></i>
			<span>Authentication</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/auth_login.html"><i class="ti-more"></i>Login</a></li>
            <li><a href="pages/auth_login2.html"><i class="ti-more"></i>Login 2</a></li>
			<li><a href="pages/auth_register.html"><i class="ti-more"></i>Register</a></li>
			<li><a href="pages/auth_register2.html"><i class="ti-more"></i>Register 2</a></li>
			<li><a href="pages/auth_lockscreen.html"><i class="ti-more"></i>Lockscreen</a></li>
			<li><a href="pages/auth_user_pass.html"><i class="ti-more"></i>Recover password</a></li>	
          </ul>
        </li> 		  
		  
		<li class="treeview">
          <a href="#">
            <i class="ti-alert"></i>
			<span>Error Pages</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
			<li><a href="pages/error_400.html"><i class="ti-more"></i>Error 400</a></li>
			<li><a href="pages/error_403.html"><i class="ti-more"></i>Error 403</a></li>
			<li><a href="pages/error_404.html"><i class="ti-more"></i>Error 404</a></li>
			<li><a href="pages/error_500.html"><i class="ti-more"></i>Error 500</a></li>
			<li><a href="pages/error_503.html"><i class="ti-more"></i>Error 503</a></li>
			<li><a href="pages/error_maintenance.html"><i class="ti-more"></i>Maintenance</a></li>	
          </ul>
        </li>   
		  
		<li class="treeview">
          <a href="#">
            <i class="ti-files"></i>
			<span>Sample Pages</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/sample_blank.html"><i class="ti-more"></i>Blank</a></li>
            <li><a href="pages/sample_coming_soon.html"><i class="ti-more"></i>Coming Soon</a></li>
			<li><a href="pages/sample_pricing.html"><i class="ti-more"></i>Pricing</a></li>
			<li><a href="pages/sample_faq.html"><i class="ti-more"></i>FAQ</a></li>
            <li><a href="pages/email_index.html"><i class="ti-more"></i>Emails</a></li>
          </ul>
        </li>
		  
		  
		<li class="header nav-small-cap">EXTRA</li>		  
		  
        <li class="treeview">
          <a href="#">
            <i class="ti-view-list"></i>
			<span>Multilevel</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#">Level One</a></li>
            <li class="treeview">
              <a href="#">Level One
                <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
              </a>
              <ul class="treeview-menu">
                <li><a href="#">Level Two</a></li>
                <li class="treeview">
                  <a href="#">Level Two
                    <span class="pull-right-container">
              <i class="fa fa-angle-right pull-right"></i>
            </span>
                  </a>
                  <ul class="treeview-menu">
                    <li><a href="#">Level Three</a></li>
                    <li><a href="#">Level Three</a></li>
                  </ul>
                </li>
              </ul>
            </li>
            <li><a href="#">Level One</a></li>
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
		<a href="pages/auth_login.html" class="link" data-toggle="tooltip" title="" data-original-title="Logout"><i class="fa fa-power-off"></i></a>
	</div>
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
	  <div class="container-full">
		<!-- Content Header (Page header) -->	  
		<div class="content-header">
			<div class="d-flex align-items-center">
				<div class="mr-auto">
					<h3 class="page-title">Dashboard</h3>
					<div class="d-inline-block align-items-center">
						<nav>
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#"><i class="mdi mdi-home-outline"></i></a></li>
								<li class="breadcrumb-item active" aria-current="page">Control</li>
							</ol>
						</nav>
					</div>
				</div>
				<div class="right-title w-170">
					<span class="subheader_daterange font-weight-600" id="dashboard_daterangepicker">
						<span class="subheader_daterange-label">
							<span class="subheader_daterange-title"></span>
							<span class="subheader_daterange-date text-info"></span>
						</span>
						<a href="#" class="btn btn-sm btn-info">
							<i class="fa fa-angle-down"></i>
						</a>
					</span>
				</div>
			</div>
		</div>

		<!-- Main content -->
		<section class="content">
			
			<div class="row">
				<div class="col-xl-4 col-12">
					<div class="box box-body">
					  <h6 class="text-uppercase">EMPLOYEES</h6>
					  <div class="flexbox mt-2">
						<span class=" font-size-30">85,987</span>
						<span class="ion ion-person text-danger font-size-40"></span>
					  </div>
					</div>
				</div>
				<!-- /.col -->

				<div class="col-xl-4 col-12">
					<div class="box box-body">
					  <h6 class="text-uppercase">MESSAGES</h6>
					  <div class="flexbox mt-2">
						<span class=" font-size-30">2,951</span>
						<span class="ion ion-email text-info font-size-40"></span>
					  </div>
					</div>
				</div>
				<!-- /.col -->
				<div class="col-xl-4 col-12">
					<div class="box box-body">
					  <h6 class="text-uppercase">VISITORS</h6>
					  <div class="flexbox mt-2">
						<span class=" font-size-30">15,845</span>
						<span class="ion ion-document text-primary font-size-40"></span>
					  </div>
					</div>
				</div>
				<!-- /.col -->
		    </div>					
			
			<div class="row">
				<div class="col-xl-7 col-12">
					<div class="box">
					  <div class="box-header with-border">
						<h4 class="box-title">Data Overview</h4>
					  </div>

					  <div class="box-body">
						  <div id="e_chart_1" class="chart" style="height:400px;"></div>
					  </div>
					</div>
				</div>

				<div class="col-xl-5 col-12">			
				  <!-- Chart -->
				  <div class="box">
					<div class="box-header with-border">
					  <h4 class="box-title">Social Ads Campaigns</h4>
					</div>
					<div class="box-body">
						<div id="e_chart_2" class="chart" style="height:400px;"></div>
					</div>
					<!-- /.box-body -->
				  </div>
				  <!-- /.box -->
				</div>
				
				<div class="col-xl-8 col-12">
					<div class="box">
					  <div class="box-header">
						<h4 class="box-title">Recent Orders</h4>
					  </div>
					  <div class="box-body">
						<div class="table-responsive">
						  <table class="table table-hover mb-5">
							<thead>
							  <tr>
								<th>SKU</th>
								<th>Invoice#</th>
								<th>Customer Name</th>
								<th>Status</th>
								<th>Amount</th>
							  </tr>
							</thead>
							<tbody>
							  <tr>
								<td>PO-10521</td>
								<td><a href="#">INV-001001</a></td>
								<td>Elizabeth W.</td>
								<td>
								  <span class="badge badge-success">Paid</span>
								</td>
								<td>$ 1200.00</td>
							  </tr>
							  <tr>
								<td>PO-532521</td>
								<td><a href="#">INV-01112</a></td>
								<td>Doris R.</td>
								<td>
								  <span class="badge badge-warning">Overdue</span>
								</td>
								<td>$ 5685.00</td>
							  </tr>
							  <tr>
								<td>PO-05521</td>
								<td><a href="#">INV-001012</a></td>
								<td>Andrew D.</td>
								<td>
								  <span class="badge badge-success">Paid</span>
								</td>
								<td>$ 152.00</td>
							  </tr>
							  <tr>
								<td>PO-15521</td>
								<td><a href="#">INV-001401</a></td>
								<td>Megan S.</td>
								<td>
								  <span class="badge badge-success">Paid</span>
								</td>
								<td>$ 1450.00</td>
							  </tr>
							  <tr>
								<td>PO-32521</td>
								<td><a href="#">INV-008101</a></td>
								<td>Walter R.</td>
								<td>
								  <span class="badge badge-warning">Overdue</span>
								</td>
								<td>$ 685.00</td>
							  </tr>
							  <tr>
								<td>PO-532521</td>
								<td><a href="#">INV-01112</a></td>
								<td>Doris R.</td>
								<td>
								  <span class="badge badge-warning">Overdue</span>
								</td>
								<td>$ 5685.00</td>
							  </tr>
							</tbody>
						  </table>
						</div>
					  </div>
					</div>
				  </div>
				<div class="col-xl-4 col-12">
					<div class="box">
					  <div class="box-header">
						<h4 class="box-title">Recent Buyers</h4>
					  </div>
					  <div class="box-body px-1">
						<div id="recent-buyers" class="media-list">
						  <a href="#" class="media xs-media p-5">
							<div class="media-left pr-1">
							  <span class="avatar avatar-lg">
								<img class="media-object" src="<%=path%>/images/avatar/1.jpg" alt="Generic placeholder image">
								<i></i>
							  </span>
							</div>
							<div class="media-body w-100">
							  <h6 class="list-group-item-heading">Kristopher Candy
								<span class="float-right pt-1">$1,021</span>
							  </h6>
							  <p class="list-group-item-text mt-5 mb-0">
								<span class="badge badge-primary">Electronics</span>
								<span class="badge badge-warning ml-1">Decor</span>
							  </p>
							</div>
						  </a>
						  <a href="#" class="media xs-media p-5">
							<div class="media-left pr-1">
							  <span class="avatar avatar-lg">
								<img class="media-object" src="<%=path%>/images/avatar/2.jpg" alt="Generic placeholder image">
								<i></i>
							  </span>
							</div>
							<div class="media-body w-100">
							  <h6 class="list-group-item-heading">Lawrence Fowler
								<span class="float-right pt-1">$2,021</span>
							  </h6>
							  <p class="list-group-item-text mt-5 mb-0">
								<span class="badge badge-danger">Appliances</span>
							  </p>
							</div>
						  </a>
						  <a href="#" class="media xs-media p-5">
							<div class="media-left pr-1">
							  <span class="avatar avatar-lg">
								<img class="media-object" src="<%=path%>/images/avatar/3.jpg" alt="Generic placeholder image">
								<i></i>
							  </span>
							</div>
							<div class="media-body w-100">
							  <h6 class="list-group-item-heading">Linda Olson
								<span class="float-right pt-1">$1,112</span>
							  </h6>
							  <p class="list-group-item-text mt-5 mb-0">
								<span class="badge badge-primary">Electronics</span>
								<span class="badge badge-success ml-1">Office</span>
							  </p>
							</div>
						  </a>
						  <a href="#" class="media xs-media p-5">
							<div class="media-left pr-1">
							  <span class="avatar avatar-lg">
								<img class="media-object" src="<%=path%>/images/avatar/4.jpg" alt="Generic placeholder image">
								<i></i>
							  </span>
							</div>
							<div class="media-body w-100">
							  <h6 class="list-group-item-heading">Roy Clark
								<span class="float-right pt-1">$2,815</span>
							  </h6>
							  <p class="list-group-item-text mt-5 mb-0">
								<span class="badge badge-warning">Decor</span>
								<span class="badge badge-danger ml-1">Appliances</span>
							  </p>
							</div>
						  </a>
						  <a href="#" class="media xs-media p-5">
							<div class="media-left pr-1">
							  <span class="avatar avatar-lg">
								<img class="media-object" src="<%=path%>/images/avatar/5.jpg" alt="Generic placeholder image">
								<i></i>
							  </span>
							</div>
							<div class="media-body w-100">
							  <h6 class="list-group-item-heading">Kristopher Candy
								<span class="float-right pt-1">$2,021</span>
							  </h6>
							  <p class="list-group-item-text mt-5 mb-0">
								<span class="badge badge-primary">Electronics</span>
								<span class="badge badge-warning ml-1">Decor</span>
							  </p>
							</div>
						  </a>
						  <a href="#" class="media xs-media p-5">
							<div class="media-left pr-1">
							  <span class="avatar avatar-lg">
								<img class="media-object" src="<%=path%>/images/avatar/6.jpg" alt="Generic placeholder image">
								<i></i>
							  </span>
							</div>
							<div class="media-body w-100">
							  <h6 class="list-group-item-heading">Lawrence Fowler
								<span class="float-right pt-1">$1,321</span>
							  </h6>
							  <p class="list-group-item-text mt-5 mb-0">
								<span class="badge badge-danger">Appliances</span>
							  </p>
							</div>
						  </a>
						  </div>
					  </div>
					</div>
				</div>
				<div class="col-12">
					<div class="box">
					  <div class="box-header with-border">
						<h4 class="box-title">Weekly Status</h4>
					  </div>

					  <div class="box-body">

						  <div class="row">
							<div class="col-12 col-lg-9">
								<div id="stacked-column" style="height:400px;"></div>
							</div>
							<div class="col-12 col-lg-3">
							  <h3 class="text-center mb-15">Goal Completion</h3>

							  <div class="progress-group mb-40">
								<span class="progress-text">Add Products to Bag</span>
								<span class="progress-number"><b>140</b>/200</span>

								<div class="progress h-30">
								  <div class="progress-bar progress-bar-info progress-bar-striped progress-bar-animated" style="width: 70%;"></div>
								</div>
							  </div>
							  <!-- /.progress-group -->
							  <div class="progress-group mb-40">
								<span class="progress-text">Complete Purchase</span>
								<span class="progress-number"><b>300</b>/400</span>

								<div class="progress h-30">
								  <div class="progress-bar progress-bar-danger progress-bar-striped progress-bar-animated" style="width: 75%"></div>
								</div>
							  </div>
							  <!-- /.progress-group -->
							  <div class="progress-group mb-40">
								<span class="progress-text">Visit Page</span>
								<span class="progress-number"><b>400</b>/800</span>

								<div class="progress h-30">
								  <div class="progress-bar progress-bar-success progress-bar-striped progress-bar-animated" style="width: 50%"></div>
								</div>
							  </div>
							  <!-- /.progress-group -->
							  <div class="progress-group mb-40">
								<span class="progress-text">Send Inquiries</span>
								<span class="progress-number"><b>425</b>/500</span>

								<div class="progress h-30">
								  <div class="progress-bar progress-bar-warning progress-bar-striped progress-bar-animated" style="width: 85%"></div>
								</div>
							  </div>
							  <!-- /.progress-group -->
							</div>
						  </div>

						  <div class="row mt-30">
							<div class="col-6 col-md-3">
							  <div class="description-block">
								<span class="text-success"><i class="fa fa-caret-up"></i> <span class="countnm per">17</span></span>
								<h5 class="description-header">$3,249.43</h5>
								<span class="description-text">TOTAL REVENUE</span>
							  </div>
							  <!-- /.description-block -->
							</div>
							<!-- /.col -->
							<div class="col-6 col-md-3">
							  <div class="description-block">
								<span class="text-warning"><i class="fa fa-caret-left"></i> <span class="countnm per">70</span></span>
								<h5 class="description-header">$2,376.90</h5>
								<span class="description-text">TOTAL COST</span>
							  </div>
							  <!-- /.description-block -->
							</div>
							<!-- /.col -->
							<div class="col-6 col-md-3">
							  <div class="description-block">
								<span class="text-primary"><i class="fa fa-caret-up"></i> <span class="countnm per">80</span></span>
								<h5 class="description-header">$1,795.53</h5>
								<span class="description-text">TOTAL PROFIT</span>
							  </div>
							  <!-- /.description-block -->
							</div>
							<!-- /.col -->
							<div class="col-6 col-md-3">
							  <div class="description-block">
								<span class="text-danger"><i class="fa fa-caret-down"></i> <span class="countnm per">28</span></span>
								<h5 class="description-header">1800</h5>
								<span class="description-text">GOAL COMPLETIONS</span>
							  </div>
							  <!-- /.description-block -->
							</div>
						  </div>
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
			<a class="nav-link" href="javascript:void(0)">FAQ</a>
		  </li>
		  <li class="nav-item">
			<a class="nav-link" href="#">Purchase Now</a>
		  </li>
		</ul>
    </div>
	  &copy; 2018 <a href="http://www.bootstrapmb.com/">Multi-Purpose Themes</a>. All Rights Reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
	  
	<div class="rpanel-title"><span class="btn pull-right"><i class="ion ion-close" data-toggle="control-sidebar"></i></span> </div>  
    <!-- Create the tabs -->
    <ul class="nav nav-tabs control-sidebar-tabs">
      <li class="nav-item"><a href="#control-sidebar-home-tab" data-toggle="tab">Chat</a></li>
      <li class="nav-item"><a href="#control-sidebar-settings-tab" data-toggle="tab">Todo</a></li>
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
			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-success" href="#">
				<img src="<%=path%>/images/avatar/1.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Tyler</strong></a>
				</p>
				<p>Praesent tristique diam...</p>
				  <span>Just now</span>
			  </div>
			</div>

			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-danger" href="#">
				<img src="<%=path%>/images/avatar/2.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Luke</strong></a>
				</p>
				<p>Cras tempor diam ...</p>
				  <span>33 min ago</span>
			  </div>
			</div>

			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-warning" href="#">
				<img src="<%=path%>/images/avatar/3.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Evan</strong></a>
				</p>
				<p>In posuere tortor vel...</p>
				  <span>42 min ago</span>
			  </div>
			</div>

			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-primary" href="#">
				<img src="<%=path%>/images/avatar/4.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Evan</strong></a>
				</p>
				<p>In posuere tortor vel...</p>
				  <span>42 min ago</span>
			  </div>
			</div>			
			
			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-success" href="#">
				<img src="<%=path%>/images/avatar/1.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Tyler</strong></a>
				</p>
				<p>Praesent tristique diam...</p>
				  <span>Just now</span>
			  </div>
			</div>

			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-danger" href="#">
				<img src="<%=path%>/images/avatar/2.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Luke</strong></a>
				</p>
				<p>Cras tempor diam ...</p>
				  <span>33 min ago</span>
			  </div>
			</div>

			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-warning" href="#">
				<img src="<%=path%>/images/avatar/3.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Evan</strong></a>
				</p>
				<p>In posuere tortor vel...</p>
				  <span>42 min ago</span>
			  </div>
			</div>

			<div class="media py-10 px-0">
			  <a class="avatar avatar-lg status-primary" href="#">
				<img src="<%=path%>/images/avatar/4.jpg" alt="...">
			  </a>
			  <div class="media-body">
				<p class="font-size-16">
				  <a class="hover-primary" href="#"><strong>Evan</strong></a>
				</p>
				<p>In posuere tortor vel...</p>
				  <span>42 min ago</span>
			  </div>
			</div>
			  
		  </div>

      </div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
          <div class="flexbox">
			<a href="javascript:void(0)" class="text-grey">
				<i class="ti-more"></i>
			</a>	
			<p>Todo List</p>
			<a href="javascript:void(0)" class="text-right text-grey"><i class="ti-plus"></i></a>
		  </div>
        <ul class="todo-list mt-20">
			<li class="py-15 px-5 by-1">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_1" class="filled-in">
			  <label for="basic_checkbox_1" class="mb-0 h-15"></label>
			  <!-- todo text -->
			  <span class="text-line">Nulla vitae purus</span>
			  <!-- Emphasis label -->
			  <small class="badge bg-danger"><i class="fa fa-clock-o"></i> 2 mins</small>
			  <!-- General tools such as edit or delete-->
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_2" class="filled-in">
			  <label for="basic_checkbox_2" class="mb-0 h-15"></label>
			  <span class="text-line">Phasellus interdum</span>
			  <small class="badge bg-info"><i class="fa fa-clock-o"></i> 4 hours</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5 by-1">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_3" class="filled-in">
			  <label for="basic_checkbox_3" class="mb-0 h-15"></label>
			  <span class="text-line">Quisque sodales</span>
			  <small class="badge bg-warning"><i class="fa fa-clock-o"></i> 1 day</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_4" class="filled-in">
			  <label for="basic_checkbox_4" class="mb-0 h-15"></label>
			  <span class="text-line">Proin nec mi porta</span>
			  <small class="badge bg-success"><i class="fa fa-clock-o"></i> 3 days</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5 by-1">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_5" class="filled-in">
			  <label for="basic_checkbox_5" class="mb-0 h-15"></label>
			  <span class="text-line">Maecenas scelerisque</span>
			  <small class="badge bg-primary"><i class="fa fa-clock-o"></i> 1 week</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_6" class="filled-in">
			  <label for="basic_checkbox_6" class="mb-0 h-15"></label>
			  <span class="text-line">Vivamus nec orci</span>
			  <small class="badge bg-info"><i class="fa fa-clock-o"></i> 1 month</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5 by-1">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_7" class="filled-in">
			  <label for="basic_checkbox_7" class="mb-0 h-15"></label>
			  <!-- todo text -->
			  <span class="text-line">Nulla vitae purus</span>
			  <!-- Emphasis label -->
			  <small class="badge bg-danger"><i class="fa fa-clock-o"></i> 2 mins</small>
			  <!-- General tools such as edit or delete-->
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_8" class="filled-in">
			  <label for="basic_checkbox_8" class="mb-0 h-15"></label>
			  <span class="text-line">Phasellus interdum</span>
			  <small class="badge bg-info"><i class="fa fa-clock-o"></i> 4 hours</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5 by-1">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_9" class="filled-in">
			  <label for="basic_checkbox_9" class="mb-0 h-15"></label>
			  <span class="text-line">Quisque sodales</span>
			  <small class="badge bg-warning"><i class="fa fa-clock-o"></i> 1 day</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
			<li class="py-15 px-5">
			  <!-- checkbox -->
			  <input type="checkbox" id="basic_checkbox_10" class="filled-in">
			  <label for="basic_checkbox_10" class="mb-0 h-15"></label>
			  <span class="text-line">Proin nec mi porta</span>
			  <small class="badge bg-success"><i class="fa fa-clock-o"></i> 3 days</small>
			  <div class="tools">
				<i class="fa fa-edit"></i>
				<i class="fa fa-trash-o"></i>
			  </div>
			</li>
		  </ul>
      </div>
      <!-- /.tab-pane -->
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
	<script src="<%=path%>/assets/vendor_components/moment/min/moment.min.js"></script>
	<script src="<%=path%>/assets/vendor_components/bootstrap-daterangepicker/daterangepicker.js"></script>
	
	<!-- Slimscroll -->
	<script src="<%=path%>/assets/vendor_components/jquery-slimscroll/jquery.slimscroll.js"></script>
	
	<!-- FastClick -->
	<script src="<%=path%>/assets/vendor_components/fastclick/lib/fastclick.js"></script>
	
    <!-- eChart Plugins -->
    <script src="<%=path%>/assets/vendor_components/echarts/dist/echarts-en.min.js"></script>
	
    <!-- C3 Plugins -->
    <script src="<%=path%>/assets/vendor_components/c3/d3.min.js"></script>
    <script src="<%=path%>/assets/vendor_components/c3/c3.min.js"></script>
	
	<!-- Ekan Admin App -->
	<script src="<%=path%>/main/js/template.js"></script>
	
	<!-- Ekan Admin dashboard demo (This is only for demo purposes) -->
	<script src="<%=path%>/main/js/pages/dashboard.js"></script>
	<script src="<%=path%>/main/js/pages/dashboard-chart.js"></script>
	
	<!-- Ekan Admin for demo purposes -->
	<script src="<%=path%>/main/js/demo.js"></script>	
	
	
</body>
</html>
