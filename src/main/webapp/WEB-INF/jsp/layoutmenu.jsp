<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<link rel="Shortcut Icon" href="hinh/iconhome.ico" type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
<!-- vô hiệu hóa btn back trên trình duyệt -->
<script>
	history.pushState(null, null, location.href);
	window.onpopstate = function() {
		history.go(1);
	};
</script>

<input id="changeURL" type="hidden" value="${changeURL}">
<script>
	function hideParamURL() {
		history.pushState(null, "", document.getElementById("changeURL").value);
	}
	hideParamURL();
</script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="format-detection" content="telephone=no">

<meta name="description" content="">
<meta name="author" content="">
<title>${tenToChuc }</title>

<!-- Bootstrap core CSS -->

<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<script src="/js/tether.min.js"></script>
<!-- Custom styles for this template -->
<link href="css/sb-admin.css" rel="stylesheet">

<link href="css/csscommon.css" rel="stylesheet">

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>

<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

</head>
<div id="getFullSize"
	style="height: 100%; width: 100%; position: fixed; top: 0; left: 0; pointer-events: none;"></div>

<body id="page-top" style="font-family: Arial">
	<div id="loading"
		style="width: 100%; height: 100%; position: fixed; top: 0; left: 0; z-index: 9999; display: none;">
		<div style="width: 100%; height: 100%; background: azure; opacity: 1;"></div>
		<img src="/hinh/loading.gif"
			style="position: absolute; margin: auto; top: 0; left: 0; right: 0; bottom: 0;">
	</div>

	<div class="check-device"
		style="display: none; text-align: center; overflow: hidden;">
		<div
			style="position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%);">
			<p class="csstextcanhbao">Please rotate the device horizontally.</p>
			<img src="/hinh/rotate-screen.gif">
		</div>
	</div>

	<!-- Navigation -->
	<nav id="mainNav"
		class="navbar static-top navbar-toggleable-md navbar-inverse bg-inverse">
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarExample"
			aria-controls="navbarExample" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand csstexttochuc" href="#"><span
			style="text-transform: uppercase; font-family: inherit;">${tenToChuc }</span></a>
		<div class="collapse navbar-collapse" id="navbarExample">
			<ul id="menuUl" class="sidebar-nav navbar-nav">

				<li class="nav-item ${activedptp }"><a class="nav-link"
                                                       href="dptp" style="text-shadow: 0px 0px 1px #888888;"><i
						class="fa fa-pencil-square-o"></i> Check-in / Check-out</a></li>
				<li class="nav-item ${activedv }"><a class="nav-link"
					href="pddv" style="text-shadow: 0px 0px 1px #888888;"><i
						class="fa fa-shopping-cart"></i> Service</a></li>
				<li class="nav-item ${activethuchi }"><a class="nav-link"
                                                         href="thuchi" style="text-shadow: 0px 0px 1px #888888;"><i
						class="fa fa-money"></i> Budget</a></li>
				<li class="nav-item"><a
					class="nav-link nav-link-collapse collapsed${chamshowtktt }"
					data-toggle="collapse" href="#collapseComponents"
					style="text-shadow: 0px 0px 1px #888888;"><i
						class="fa fa-search"></i> Look for information</a>
					<ul class="sidebar-second-level collapse${chamshowtktt }"
						id="collapseComponents">
						<li class="nav-item ${activettkh }"><a href="ttkh">Customer
								information</a></li>
						<li class="nav-item ${activettp }"><a href="ttp">Room
								information</a></li>

					</ul></li>
				<li class="nav-item"><a
					class="nav-link nav-link-collapse collapsed${chamshowtkvbc }"
					data-toggle="collapse" href="#collapseMulti1"
					style="text-shadow: 0px 0px 1px #888888;"><i
						class="fa fa-calendar-check-o"></i> Statistics & Reports</a>
					<ul class="sidebar-second-level collapse${chamshowtkvbc }"
						id="collapseMulti1">
						<li class="nav-item ${activelsdtp }"><a href="lsdtp">Check-in
								/ check-out history</a></li>
						<li class="nav-item ${activelsdv }"><a href="lsdv">Service
								history</a></li>
						<li class="nav-item ${activettdt }"><a href="tkdt">Revenue
								statistics</a></li>
						<c:if test="${not empty ancaidai }">
							<li class="nav-item ${activelsdn }"><a href="lsdn">Login
									history</a></li>
						</c:if>
					</ul></li>

				<c:if test="${not empty ancaidai }">
					<li class="nav-item"><a
						class="nav-link nav-link-collapse collapsed${chamshowcd }"
						data-toggle="collapse" href="#collapseMulti"
						style="text-shadow: 0px 0px 1px #888888;"><i
							class="fa fa-fw fa-wrench"></i> Settings</a>
						<ul class="sidebar-second-level collapse${chamshowcd }"
							id="collapseMulti">

							<li class="nav-item"><a
								class="nav-link nav-link-collapse collapsed${chamshowqltk }"
								data-toggle="collapse" href="#collapseMulti10"><i
									class="fa fa-fw fa-sitemap"></i> Account management</a>
								<ul class="sidebar-second-level collapse${chamshowqltk }"
									id="collapseMulti10">
									<li class="nav-item ${activedstk }"><a href="qltk">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;List
											of accounts</a></li>
									<li class="nav-item ${activettk }"><a href="addtk">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;More
											account</a></li>
								</ul></li>

							<li class="nav-item"><a
								class="nav-link nav-link-collapse collapsed${chamshowqllp }"
								data-toggle="collapse" href="#collapseMulti11"><i
									class="fa fa-fw fa-sitemap"></i> Manage room types</a>
								<ul class="sidebar-second-level collapse${chamshowqllp }"
									id="collapseMulti11">
									<li class="nav-item ${activedslp }"><a href="qllp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Room
											type list</a></li>
									<li class="nav-item ${activetlp }"><a href="addlp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Add
											room type</a></li>
								</ul></li>

							<li class="nav-item"><a
								class="nav-link nav-link-collapse collapsed${chamshowqlp }"
								data-toggle="collapse" href="#collapseMulti12"><i
									class="fa fa-fw fa-sitemap"></i> Room manager</a>
								<ul class="sidebar-second-level collapse${chamshowqlp }"
									id="collapseMulti12">
									<li class="nav-item ${activedsp }"><a href="quanlyphong">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Room
											list</a></li>
									<li class="nav-item ${activetp }"><a href="addqlp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Add
											room</a></li>
								</ul></li>

							<li class="nav-item"><a
								class="nav-link nav-link-collapse collapsed${chamshowdv }"
								data-toggle="collapse" href="#collapseMulti13"><i
									class="fa fa-fw fa-sitemap"></i> Service management </a>
								<ul class="sidebar-second-level collapse${chamshowdv }"
									id="collapseMulti13">
									<li class="nav-item ${activedsdv }"><a href="dsqldv">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Service
											list</a></li>
									<li class="nav-item ${activetdv }"><a href="themdsqldv">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Add
											service</a></li>
								</ul></li>

							<li class="nav-item ${activets }" style="cursor: pointer;"><a
								href="qlts"><i class="fa fa-fw fa-sitemap"></i> Advanced
									management</a>
						</ul></li>


				</c:if>
			</ul>

			<ul class="navbar-nav ml-auto">
				<li class="dropdown user user-menu" style="margin-right: 35px;">
					<a href="#" class="dropdown-toggle customUser"
					data-toggle="dropdown" aria-expanded="false"> <img
						src="hinh/iconuser.png" width="30px" height="30px" /> <span
						class="hidden-xs">Welcome ${nguoidung }</span>
				</a>

					<ul class="dropdown-menu">

						<li class="user-body">
							<div style="text-align: center;">

								<a class="hoverUser" href="doimatkhau">Change Password</a>
							</div>

							<div style="text-align: center;">
								<a class="hoverUser" href="dangxuat">Log-Out</a>
							</div>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<div class="content-wrapper py-3 content-custom">
		<div class="container">
			<div class="container">
				<div class="titleCommon1" align="center">
					<span class="titleCommon">${titlepage }</span>
				</div>
			</div>
		</div>
		<div class="container">
			<!-- Breadcrumbs -->
			<!-- Noi dung trong nay-->

			<jsp:include page="${param.layoutmenu }"></jsp:include>

		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /.content-wrapper -->
	<script type="text/javascript" src="/js/layout.js"></script>
	<script type="text/javascript" src="/js/common.js"></script>
</body>
</html>
