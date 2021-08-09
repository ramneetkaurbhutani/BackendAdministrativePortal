<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="teacher" method="post">
Subject: <select name="subjectname">
 <option value="select">Select Subject</option>
   <option value="English">English</option>
   <option value="Hindi">Hindi</option>
   <option value="Maths">Maths</option>
   <option value="Science">Science</option>
   <option value="Computer Science">Computer Science</option>
   <option value="Music">Music</option>
   <option value="Physics">Physics</option>
   <option value="Chemistry">Chemistry</option>
   </select><br/><br/>

Class: <select name="classId">
  		<option value="select">Select Class</option>
  			<option value="1">1</option>
  			<option value="2">2</option>
  			<option value="3">3</option>
  			<option value="4">4</option>
  			<option value="5">5</option>
  			<option value="6">6</option>
  			<option value="7">7</option>
  			<option value="8">8</option>
  			<option value="9">9</option>
  			<option value="10">10</option>
  			<option value="11">11</option> 
   			<option value="12">12</option> 
   		</select><br><br>
   		
Teacher: <select name="teachername">
		<option value="select">Select Teacher</option>
  			<option value="Priya Singh">Priya Singh</option>
  			<option value="Jitentra Srivastava">Jitentra Srivastava</option>
  			<option value="Nirmala Rathore">Nirmala Rathore</option>
  			<option value="Poonam Singh">Poonam Singh</option>
  			<option value="Sanjay Pandey">Sanjay Pandey</option>
  			<option value="Promila chatrat">Promila chatrat</option>
  			<option value="Reena Malik">Reena Malik</option>
		</select><br><br>
   		<input type="submit" value="submit" name="submit"/>
</form>
<br><br><br><br>
<a href="dashboard">Back to previous page</a>
</body>
</html>