<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
<script src="jquery.min.js"></script>

<title>grocery registration</title>
<style type="text/css">
h1{
		background-color: gray;
	}
</style>
<script>
var val1=$("#sel1").val();
if(val1=='' || val1==0)
	{
 	$(document).ready(function(){
  		$('#sel1').val("---select---");
  		$('#sel2').val("---select---");
  	});
	}
else{
  	$(document).ready(function(){
  		$('#sel1').val('${details.metrixType}');
  		$('#sel2').val('${details.itemType}');
  	});
}
  </script>
  <script>
  /* function validate()	
  {
	  var name=$("#name").val();
	  var team=$("#sel1").val();
	  var place=$("#sel2").val();
	  var salary=$("#salary").val();
	  
	   if(name==null || name=='')
		  {
		   	$("#sname").html("Name Requried");
		  	$("#errname").show();
		  	$("#errteam").hide();
		  	$("#errplace").hide();
		  	$("#errsalary").hide();
			return false;
		  	
		  }
	  else if (team==null || team=='') {
		  $("#steam").html("Team Requried");
		  	$("#errname").hide();
		  	$("#errteam").show();
		  	$("#errplace").hide();
		  	$("#errsalary").hide();
		  	return false;
	}
	  else if(place==null || place==''){
		  $("#splace").html("place Requried");
		  $("#errname").hide();
		  	$("#errteam").hide();
		  	$("#errplace").show();
		  	$("#errsalary").hide();
		  	return false;
	  }
	  else if(salary==null || salary==''){
		  $("#ssalary").html("salary Requried");
		  $("#errname").hide();
		  	$("#errteam").hide();
		  	$("#errplace").hide();
		  	$("#errsalary").show();
		  	return false;
	  }
	   return true;
  } */
  </script>
  </head>

<body>
<form action="GroceryController" method="post" name="rform" >
<center><h1>Grocery Shop Management System</h1></center>
<div class="container">
<input  type="hidden" name="id" value="${details.idgroocery}">
	<h2>Grocery Registration</h2>
	
	<div class="col-xs-4">
	<div>
	<label>Name<span style="color: red">*</span></label><br><span style="color: red">${msg}</span>
	<div id="errname">
		<span style="color: red" id="sname"></span>
	</div>
	<input id="name" class="form-control" type="text" name="name" value="${details.name }"  placeholder="Enter item name">
	
	
	<br><br><label>Metrix Type<span style="color: red">*</span></label>
	<div class="form-group">
	<div id="errteam">
		<span style="color: red" id="steam"></span>
	</div>
    <select  class="form-control" name="metrixType" id="sel1"  value="${details.metrixType}"> 
        <option value="" hidden>---select---</option>
        <option value="Count">Count</option>
        <option value="KG">KG</option>
        <option value="Litter">Litter</option>
       </select>
      </div>
	<br><label>Item Type<span style="color: red">*</span></label>
	<div class="form-group">
	<div id="errplace">
		<span style="color: red" id="splace"></span>
	</div> 
        <select  class="form-control" name="itemType" id="sel2"  value="${details.itemType}">
        	<option value="" hidden>---select---</option>																																																																																																																																																																																																																																																																																																											>---select---</option>
        	<option value="Snacks">Snacks</option>
        	<option value="House Use">House Use</option>
        	<option value="Entertainment">Entertainment</option>
        	<option value="Nuts / Grains">Nuts / Grains</option>
        	<option value="Others">Others</option>
        </select>
      </div>
	<br><label>Quantity</label><span style="color: red">*</span>
	<div class="form-group">
	<div id="errsalary">
		<span style="color: red" id="ssalary"></span>
	</div>
	<input id="quantity" class="form-control" type="number" name="quantity"  placeholder="enter quantity" value="${details.quantity}">
	
	<br><br>
	
	<label>Expiry Date<span style="color: red">*</span></label><br><span style="color: red">${msg}</span>
	<div id="errname">
		<span style="color: red" id="sname"></span>
	</div>
	<input id="expiryDate" class="form-control" type="date" path="expiryDate" class= "date" name = "expiryDate" pattern="dd-MM-yyyy" />
	
	<br><br>
	
	<label>Price ₹<span style="color: red">*</span></label><br><span style="color: red">${msg}</span>
	<input id="price" class="form-control" type="number" name="price"  placeholder="enter price" value="${details.price}">
		<br>
		<div class="col-xs-2">
		<input  class="btn btn-info" type="submit" name="submit"  value="${name}" onclick="return validate()"></input>
		</div>
      <button  class="btn btn-info" type="reset" style="position: relative;left: 40px">Reset</button>
      <button  class="btn btn-info" style="position: relative;left: 50px" type="submit" value="Cancel" name="submit">Cancel</button>
	</div>
	</div>
	</div>
</form>
</body>
</html>