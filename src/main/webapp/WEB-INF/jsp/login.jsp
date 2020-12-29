<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
<head>

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  
  <link rel="Shortcut Icon" href="hinh/iconhome.ico" type="image/x-icon" />  
  
      <link rel="stylesheet" href="css/style.css">

  
</head>

<body style="background-color: #292b2c;">
  <div class="wrapper">
	<div class="container">
		<h1 id="widthtext"><span id="text" style="text-transform: uppercase;white-space:nowrap;">${tenToChuc }</span></h1>
		<span id="error" class="texterror"><b><c:if test="${not empty message }">${message }</c:if></b></span>
		<form class="form" action="actionlogin">
			<input name="username" type="text" placeholder="Username" required="required" maxlength="50" autocomplete="off">
			<input name="password"type="password" placeholder="Password" required="required" maxlength="100" autocomplete="off">
			<button type="submit" id="login-button">Login</button>
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		
	</ul>
</div>
 
<script src="/vendor/jquery/jquery.min.js"></script>
    <script src="/js/index.js"></script>
</body>
</html>
