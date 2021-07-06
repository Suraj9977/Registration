<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
</head>  
<body>  
<%@page import="next.xadmin.login.database.LoginDao,next.xadmin.login.bean.LoginBean"%>  
  
<%  
String projectName=request.getParameter("projectName");  

LoginBean u=LoginDao.getRecordByProjectName(projectName);  
%>  
   
<h1>Edit Form1</h1>  
<form action="editEmployee.jsp" method="post">  
<input type="hidden" name="projectName" value="<%=u.getProjectName() %>"/>  
<table>  

<tr><td>project_status:</td><td>  
<input type="text" name="project_status" value="<%= u.getUsername()%>"/></td></tr>    
<tr><td>DOP:</td><td>  
<input type="text" name="dop" value="<%= u.getDop()%>"/></td></tr>  

<tr><td colspan="2"><input type="submit" value="EditProject"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  