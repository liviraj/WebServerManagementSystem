<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view</title>
<style type="text/css">
h1{
		background-color: gray;
	}
</style>
 <link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
<script src="jquery.min.js"></script>
<script>
	function msg1(id){
		var idValue = id;
		var c=confirm("Are You Sure");
		if(c==true)
			{
				location.href="ServerController?action=delete&id="+idValue; 
			}/* else{
				location.reload();
			} */
		
	}
</script>
</head>
<body>
<div class="container">
<center><h1>Web Server Management System</h1></center>
	
	<center><p><font size="5">View of Server Information</font></p></center>
	<center><span style="color: red">${msg} </span></center>
	<form action="LogoutController">
				<input type="submit" name="submit" value="logout" style="position:relative; left: 1000px" class="btn btn-danger">
	</form>
	<input type="hidden" name="confirm" id="confirm" value=""></input>
	<center><table border="3" class="table">
		<tr class="danger">
		<th>Id</th>
		<th>Server Name</th>
		<th>Operating System</th>
		<th>RAM</th>
		<th>Hard Disk Size</th>
		<th>Availability</th>
		<th>Expiry Date</th>
		<th colspan="1"><a href="ServerController?action=add">Add New</a></th>
		</tr>
			<c:forEach items="${details}" var="detail">
			<tr>
				<td><c:out value="${detail.serverId}"></c:out></td>
				<td><c:out value="${detail.serverName}"></c:out></td>
				<td><c:out value="${detail.operatingSystem}"></c:out></td>
				<td><c:out value="${detail.ram}"></c:out></td>
				<td><c:out value="${detail.hardDiskSize}"></c:out></td>
				<td><c:out value="${detail.availability}"></c:out></td>
				<td><c:out value="${detail.expiryDate}"></c:out></td>
				<td><a href="ServerController?action=update&id=<c:out value="${detail.serverId}"/>"><button>Update</button></a>
               <%-- <a href="ServerController?action=delete&id=<c:out value="${detail.id}" />"><button onclick="msg1()">Delete</button></a></td> --%>
			 <a><button onclick="msg1(${detail.serverId})">Delete</button></a></td> 
			</tr>
			</c:forEach>
			</table></center></div>
</body>
</body>
</html>
