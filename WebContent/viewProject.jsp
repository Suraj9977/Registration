<!DOCTYPE html>  
  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>View Employee</title>  
</head>  
<body>  
  
<%@page import="next.xadmin.login.database.LoginDao,next.xadmin.login.bean.LoginBean,java.util.*"%>  

<h1>Project List</h1>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<%  
List<LoginBean> list=LoginDao.getAllRecords1();  
request.setAttribute("list",list);  
%>  
  
<table border="1" width="90%">  
<tr><th>Project_Name</th><th>project_status</th><th>dop</th>
 
<c:forEach items="${list}" var="u">  
<tr><td>${u.getProjectName()}</td><td>${u.getProjectStatus()}</td><td>${u.getDop()}</td>
  

</c:forEach>  
</table>  
<br/><a href="manageProject.html">Manage Project</a>  
  
</body>  
</html>  