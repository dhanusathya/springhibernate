<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Table Updated successfully</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script type="text/javascript"> 
   function doAjaxPost() {  
	      
    var student_name = $('#student_name').val();  
    var father_name = $('#father_name').val();  
    var section = $('#section').val();
    var type_of_student = $('#type_of_student').val();
     $.ajax({  
     type : "Post",   
     url : "/student/update_student.htm",   
     data :"student_name=" + student_name + "&father_name=" + father_name +"&section=" + section + "&type_of_student=" + type_of_student,
     success : function(response) {  
    	 alert(JSON.stringify(response));
    	 
     },   
     error : function(e) {  
      alert('Error: ' + e);   
     }  
    });  
   }  
</script>
</head>
<body>
<form action="" method="post">
			<table id="user" class="center" >
			  <tr>
			    <th>STUDENT</th>
			    <th>DETAILS</th>
			  </tr>
				<tr>
					<td>Student Name</td>
					<td><input type="text" id="student_name" name="student_name" /></td>
				</tr>
				<tr>
					<td>Father's Name</td>
					<td><input type="text" id="father_name" name="father_name" /></td>
				</tr >
				<tr>
					<td>Section</td>
					<td><input type="text" id="section" name="section" /></td>
				</tr>
				<tr>
					<td>Type Of Student</td>
					<td><input type="text" id="type_of_student" name="type_of_student" /></td>
				</tr>
				<tr>
				 <td> <input type="button" id="saveBtn" value="Save" onclick="doAjaxPost();" /><td></tr>
				</table>
			   
			</form>
</body>
</html>