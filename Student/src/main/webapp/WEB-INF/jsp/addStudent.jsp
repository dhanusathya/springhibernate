<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Student</title>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
.students {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 60%;
}

.students td, .students th {
    border: 1px solid #ddd;
    padding: 8px;
}

.students tr:nth-child(even){background-color: #f2f2f2;}

.students tr:hover {background-color: #ddd;}

.students th {
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=button] {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=button]:hover {
    background-color: #45a049;
}

div.divStyle {
	width: 40%;
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
  <script type="text/javascript">
  var contextPath="/Student";
   function doAjaxPost() {  
	      
    var student_name = $('#student_name').val();  
    var father_name = $('#father_name').val();  
    var section = $('#section').val();
    var type_of_student = $('#type_of_student').val();
    var studentId=$("#studentId").val();
    var urlVal="/ctrl/new_student.htm";
    if(studentId != "" && studentId != undefined){
    	urlVal="/ctrl/update_student.htm";
    }	
     $.ajax({
     type : "Post",   
     url : contextPath+urlVal,   
     data :"studentId="+studentId+"&student_name=" + student_name + "&father_name=" + father_name +"&section=" + section + "&type_of_student=" + type_of_student,
     success : function(response) {  
    	 clearInput();
    	 alert(response);
    	 doAjaxPostview();
     },   
     error : function(e) {  
    	 clearInput();
      alert('Error: ' + e);   
     }  
    });  
   }  
   function doAjaxPostview() {  
	    var student_name = $('#student_name').val();  
	    var father_name = $('#father_name').val();  
	    var section = $('#section').val();  
	    var type_of_student = $('#type_of_student').val(); 
	    
	    $.ajax({  
	     type : "Get", 
	     dataType: 'JSON',
	     url : contextPath+"/ctrl/view_student.htm",   
	     data : "student_name=" + student_name + "&father_name=" + father_name + "&section=" + section + "&type_of_student=" + type_of_student ,  
	     contentType: "application/json",
	     success : function(response) {  
	      var content="";
			$.each(response, function(k,v){
				content+="<tr><td>"+v.student_name+"</td><td>"+v.father_name+"</td><td>"+v.section+"</td><td>"+v.type_of_student+"</td><td style='text-align:center;'><a href='#' onclick='editStudent(\""+v.id+"\",\""+v.student_name+"\", \""+v.father_name+"\", \""+v.section+"\", \""+v.type_of_student+"\");'><img src='../images/edit.png' style='height:20px;width:20px;' title='Modify "+v.student_name+"' /></a></td><td style='text-align:center;'><a href='#' onclick='deleteStudent(\""+v.id+"\");'><img src='../images/delt.png' style='height:20px;width:20px;' title='Delete "+v.student_name+"' /></a></td></tr>"
			});
			if(content == ""){
				content="<tr><td colspan='5'>No Records found.</td></tr>";
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
   doAjaxPostview();
   
   function editStudent(studentid, name, fatherName, section, type){
	   $("#studentId").val(studentid);     
	   $("#student_name").val(name);
	   $("#father_name").val(fatherName);
	   $("#section").val(section);
	   $("#type_of_student").val(type);
   }
   function deleteStudent(studentID){
	   $.ajax({  
		     type : "Get", 
		     url : contextPath+"/ctrl/delete_student.htm",   
		     data : "studentId=" + studentID ,  
		     contentType: "application/json",
		     success : function(response) {  
		    	 clearInput();
		    	 alert(response);
		    	 doAjaxPostview();
		     },  
		     error : function(e) {  
		      alert('Error: ' + e);   
		     }  
		    });  
   }
   
   function clearInput(){
	   $("#studentForm")[0].reset();
   }
  </script> 
</head>
<body> 
<div align="center">
<h2>Add New Student</h2>
<div class="divStyle">
<form action="" method="post" id="studentForm">
<div align="left">Student Name</div>
<input type="text" id="student_name" name="student_name" /><input type="hidden" id="studentId" name="studentId" />
<div align="left">Father's Name</div>
<input type="text" id="father_name" name="father_name" />
<div align="left">Section</div>
<input type="text" id="section" name="section" />
<div align="left">Type Of Student</div>
<select id="type_of_student" name="type_of_student">
<option value="corresspondance" selected>Corresspondance</option>
<option value="Regular">Regular</option>
</select>
<div align="center"><input type="button" id="saveBtn" value="Save" onclick="doAjaxPost();" /> <input type="button" id="clearBtn" value="Clear" onclick="clearInput();" /></div>
			
			</form>
			</div>
			<h2>Student List Details</h2>
				<table id="studentsListTBL" class="students">
				<tr id="studentsListTR">
				<th>Student Name</th>
				<th>Father's Name</th>
				<th>Section</th>
				<th>Type Of Student</th>
				<th style='text-align:center;'>Edit</th>
				<th style='text-align:center;'>Delete</th>
				</tr>
				</table>
				</div>
		</body>
</html>