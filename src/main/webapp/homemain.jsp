<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
  <link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
<script src="jquery.min.js"></script>
  
<style type="text/css">
h1{
		background-color: gray;
	}
</style>
</head>

<body background="server_image.avif">
<center><h1>Web Server Management System</h1></center>
<form>
<div class="container">
<nav class="navbar navbar-default">  
  <div class="container-fluid">  
    <div class="navbar-header">  

	<ul class="nav navbar-nav">
	<li><a>Home</a></li>
	<li><a href="SeController?action=register">Register Server Details</a></li>
	<li><a href="ServerController?action=view">View Server Details</a></li>
	</ul>
	</div>
	</div>
	</nav>
	</div>
</form>
</body>
</html>