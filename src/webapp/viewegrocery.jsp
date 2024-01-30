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
				location.href="GroceryController?action=delete&id="+idValue; 
			}/* else{
				location.reload();
			} */
		
	}
</script>
</head>
<body>
<div class="container">
<center><h1>Grocery Shop Management System</h1></center>
	
	<center><p><font size="5">View of Grocery Information</font></p></center>
	<center><span style="color: red">${msg} </span></center>
	<form action="LogoutController">
				<input type="submit" name="submit" value="logout" style="position:relative; left: 1000px" class="btn btn-danger">
	</form>
	<input type="hidden" name="confirm" id="confirm" value=""></input>
	<center><table border="3" class="table">
		<tr class="danger">
		<th>Id</th>
		<th>Grocery Name</th>
		<th>Metrix Type</th>
		<th>Quantity</th>
		<th>Expiry Date</th>
		<th>Item Type</th>
		<th>Price</th>
		<th colspan="1"><a href="GroceryController?action=add">Add New</a></th>
		</tr>
			<c:forEach items="${details}" var="detail">
			<tr>
				<td><c:out value="${detail.idgroocery}"></c:out></td>
				<td><c:out value="${detail.name}"></c:out></td>
				<td><c:out value="${detail.metrixType}"></c:out></td>
				<td><c:out value="${detail.quantity}"></c:out></td>
				<td><c:out value="${detail.expiryDate}"></c:out></td>
				<td><c:out value="${detail.itemType}"></c:out></td>
				<td><c:out value="${detail.price}"></c:out></td>
				<td><a href="GroceryController?action=update&id=<c:out value="${detail.idgroocery}"/>"><button>Update</button></a>
               <%-- <a href="GroceryController?action=delete&id=<c:out value="${detail.id}" />"><button onclick="msg1()">Delete</button></a></td> --%>
			 <a><button onclick="msg1(${detail.idgroocery})">Delete</button></a></td> 
			</tr>
			</c:forEach>
			</table></center></div>
</body>
</body>
</html>
