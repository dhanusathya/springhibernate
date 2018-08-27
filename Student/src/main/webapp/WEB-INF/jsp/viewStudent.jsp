<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Player Statistics</title>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script type="text/javascript"> 
  var list="${list}";
  console.log("list : "+list);
   function doAjaxPost() {  
    var student_name = $('#student_name').val();  
    var father_name = $('#father_name').val();  
    var section = $('#section').val();  
    var type_of_student = $('#type_of_student').val();  

    $.ajax({  
     type : "Get", 
     dataType: 'JSON',
     url : "/student/view_student.htm",   
     data : "student_name=" + student_name + "&father_name=" + father_name + "&section=" + section + "&type_of_student=" + type_of_student ,  
     contentType: "application/json",
     success : function(response) {  
      //alert(JSON.stringify(response));
      var content="";
		$.each(response, function(k,v){
			content+="<tr><td>"+v.student_name+"</td><td>"+v.father_name+"</td><td>"+v.section+"</td></tr>"+v.type_of_student+"</td></tr>"
		});
		if(content == ""){
			content="<tr><td colspan='4'>No Records found.</td></tr>";
		}
		$("#studentsListTBL").find("tr:gt(0)").remove();
		$("#studentsListTR").after(content);
      var list1="${list}";
      console.log("list1 : "+list1);
     },  
     error : function(e) {  
      alert('Error: ' + e);   
     }  
    });  
   }  
   doAjaxPost();
  </script> 
</head>
<body>
<h2>Player Statistics</h2>
<form action="" method="get">
			<table id="cricket" class="center" >
			  <tr>
			    <th>PLAYER</th>
			    <th>DETAILS</th>
			  </tr>
				<tr>
					<td>Student Name</td>
					<td><input type="text" id="student_name" name="student_name" /></td>
				</tr>
				<tr>
					<td>Father's Name</td>
					<td><input type="text" id="father_name" name="father_name" /></td>
				</tr>
				<tr>
					<td>Section</td>
					<td><input type="text" id="section" name="section" /></td>
				</tr>
				<tr>
					<td>Type Of Student</td>
					<td><input type="text" id="type_of_student" name="type_of_student" /></td>
				</tr>
				<tr>
				 <td> <input type="button" id="searchBtn" value="Search" onclick="doAjaxPost();" /><td></tr>
				</table>
				
							</form>
				<table id="studentsListTBL">
				<tr id="studentsListTR">
				<td>Student Name</td>
				<td>Father's Name</td>
				<td>Section</td>
				<td>Type Of Student</td>
				</tr>
				</table>
</body>
</html>