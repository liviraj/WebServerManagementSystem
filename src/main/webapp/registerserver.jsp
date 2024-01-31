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

<title>server registration</title>
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
  		$('#sel3').val("---select---");
  		$('#sel4').val("---select---");
  	});
	}
else{
  	$(document).ready(function(){
  		$('#sel1').val('${details.operatingSystem}');
  		$('#sel2').val('${details.ram}');
  		$('#sel3').val('${details.hardDiskSize}');
  		$('#sel4').val('${details.availability}');
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
<form action="ServerController" method="post" name="rform" >
<center><h1>Web Server Management System</h1></center>
<div class="container">
<input  type="hidden" name="id" value="${details.serverId}">
	<h2>Server Registration</h2>
	
	<div class="col-xs-4">
	<div>
	<label>Server Name<span style="color: red">*</span></label><br><span style="color: red">${msg}</span>
	<div id="errname">
		<span style="color: red" id="sname"></span>
	</div>
	<input id="serverName" class="form-control" type="text" name="serverName" value="${details.serverName }"  placeholder="Enter server name">
	
	
	<br><label>Operating System<span style="color: red">*</span></label>
	<div class="form-group">
	<div id="errteam">
		<span style="color: red" id="steam"></span>
	</div>
    <select  class="form-control" name="operatingSystem" id="sel1"  value="${details.operatingSystem}"> 
        <option value="" hidden>---select---</option>
        <option value="Windows">Windows</option>
        <option value="Linux">Linux</option>
        <option value="RedHat">RedHat</option>
       </select>
      </div>
	<br><label>RAM<span style="color: red">*</span></label>
	<div class="form-group">
	<div id="errplace">
		<span style="color: red" id="splace"></span>
	</div> 
        <select  class="form-control" name="ram" id="sel2"  value="${details.ram}">
        	<option value="" hidden>---select---</option>																																																																																																																																																																																																																																																																																																											>---select---</option>
        	<option value="2 GB">2 GB</option>
        	<option value="4 GB">4 GB</option>
        	<option value="8 GB">8 GB</option>
        	<option value="16 GB">16 GB</option>
        	<option value="32 GB">32 GB</option>
        </select>
      </div>
	<br>
	<label>Hard Disk Size<span style="color: red">*</span></label>
	<div class="form-group">
	<div id="errplace">
		<span style="color: red" id="splace"></span>
	</div> 
        <select  class="form-control" name="hardDiskSize" id="sel3"  value="${details.hardDiskSize}">
        	<option value="" hidden>---select---</option>																																																																																																																																																																																																																																																																																																											>---select---</option>
        	<option value="128 GB">128 GB</option>
        	<option value="256 GB">256 GB</option>
        	<option value="512 GB">512 GB</option>
        	<option value="1024 GB">1024 GB</option>
        	<option value="2048 GB">2048 GB</option>
        </select>
      </div>
	
	<br>
	
	<label>Expiry Date<span style="color: red">*</span></label><br><span style="color: red">${msg}</span>
	<div id="errname">
		<span style="color: red" id="sname"></span>
	</div>
	<input id="expiryDate" class="form-control" type="date" path="expiryDate" class= "date" name="expiryDate" pattern="dd-MM-yyyy"  value="${details.expiryDate}"/>
	
	<br>
	<label>Availability<span style="color: red">*</span></label>
	<div class="form-group">
	<div id="errplace">
		<span style="color: red" id="splace"></span>
	</div> 
        <select  class="form-control" name="availability" id="sel4"  value="${details.availability}">
        	<option value="" hidden>---select---</option>																																																																																																																																																																																																																																																																																																											>---select---</option>
        	<option value="Low">Low</option>
        	<option value="Medium">Medium</option>
        	<option value="High">High</option>
        </select>
      </div>
      
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