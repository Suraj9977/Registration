<!DOCTYPE html>  
  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>View Employee</title>  
</head>  
<body>  
  
<%@page import="next.xadmin.login.database.LoginDao,next.xadmin.login.bean.LoginBean,java.util.*"%>  

<h1>Employee List</h1>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<%  
List<LoginBean> list=LoginDao.getAllRecords();  
request.setAttribute("list",list);  
%>  
  
<table border="1" width="90%">  
<tr><th>Id</th><th>EmployeeFullName</th><th>username</th><th>password</th><th>Role_name</th>  
<th>Gender</th><th>ProjectName</th><th>Edit</th><th>Delete</th></tr>  
<c:forEach items="${list}" var="u">  
<tr><td>${u.getid()}</td><td>${u.getFullName()}</td><td>${u.getUsername()}</td><td>${u.getPassword()}</td>  
<td>${u.getRole()}</td><td>${u.getGender()}</td><td>${u.getProjectName()}</td>  
<td><a href="editForm.jsp?id=${u.getid()}">Edit</a></td>  
<td><a href="deleteEmployee.jsp?id=${u.getid()}">Delete</a></td></tr>  
</c:forEach>  
</table>  
<br/><a href="addEmployeeForm.jsp">Add New User</a>  
  
</body>  
</html>  