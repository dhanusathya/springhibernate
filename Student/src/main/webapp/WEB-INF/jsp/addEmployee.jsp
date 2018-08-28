<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script type="text/javascript"> 
   function doAjaxPost() {  
	 
	var empName = $('#emp_name').val();  
    var empSalary = $('#emp_salary').val();  
    var deptId = $('#dept_id').val();
    var address = $('#address').val();
    
  alert("");
    $.ajax({  
     type : "Get",   
     url : "/Student/ctrl/new_employee.htm",   
     data :"emp_name=" + empName + "&emp_salary=" + empSalary + "&dept_id=" + deptId + "&address=" + address,
     success : function(response) {  
      alert(response);   
     },  
     error : function(e) {  
      alert('Error: ' + e);   
     }  
    });  
   }  
  </script> 
</head>
<body>
<h2>Welcome New Employee</h2>

<form action="" method="post">
			<table id="employee" class="center" >
			  <tr>
			    <th>Employee</th>
			    <th>Details</th>
			  </tr>
			 <tr>
					<td>Employee Name</td>
					<td><input type="text" id="empName" name="emp_name" /></td>
				</tr>
				<tr>
					<td>Employee Salary</td>
					<td><input type="text" id="empName" name="emp_salary" /></td>
				</tr>
				<tr>
					<td>Department Id</td>
					<td><input type="text" id="deptId" name="dept_id" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" id="address" name="address" /></td>
				</tr>
				<tr>
				 <td> <input type="button" id="saveBtn" value="Save" onclick="doAjaxPost();" /><td></tr>
				</table>
			   
			</form>
</body>
</html>