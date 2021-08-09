<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
<%
	if(request.getParameter("error") != null)
		out.println("<b>Your session has expired  or is invalid.</b><br>");
%>


<center>
<form action="handler" name="frmName" method="post">
<table width="50%" border="10">
<tr valign="top">
<td width="40%">Name</td>
<td><input name="name" id="name" maxlength="50"></td>
</tr>
<tr valign="top">
<td width="40%">Password</td>
<td><input type="password" name="password" id="password" maxlength="50"></td>
</tr>
<tr valign="top">
<td colspan=2 width="100%"><button>Submit</button>
</td>
</tr>
</table>
</form>
</center>
<br><br>
<a href="index.html">Click here to go to Main menu</a>
</body>
</html>