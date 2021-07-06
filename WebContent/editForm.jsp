<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
</head>  
<body>  
<%@page import="next.xadmin.login.database.LoginDao,next.xadmin.login.bean.LoginBean"%>  
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%  
String id=request.getParameter("id");  

LoginBean u=LoginDao.getRecordById(Integer.parseInt(id));  
%>  
   
<h1>Edit Form</h1>  
<form action="editEmployee.jsp" method="post">  
<input type="hidden" name="id" value="<%=u.getid() %>"/>  
<table>  
<tr><td>FullName:</td><td>  
<input type="text" name="fullName" value="<%= u.getFullName()%>"/></td></tr>
<tr><td>Username:</td><td>  
<input type="text" name="username" value="<%= u.getUsername()%>"/></td></tr>    
<tr><td>Password:</td><td>  
<input type="password" name="password" value="<%= u.getPassword()%>"/></td></tr>  
<tr><td>Role:</td><td>  
<input type="text" name="role" value="<%= u.getRole()%>"/></td></tr>  
<tr><td>Gender:</td><td>  
<c:set var="gender" value="<%= u.getGender()%>"/>
<input type="radio" name="gender" value="male" <c:if test="${gender =='male'}">checked</c:if>>Male   
<input type="radio" name="gender" value="female"<c:if test="${gender =='female'}">checked</c:if>>Female </td></tr>  

<tr><td>ProjectName:</td><td>  
<input type="text" name="projectName" value="<%= u.getProjectName()%>"/></td></tr> 

<tr><td colspan="2"><input type="submit" value="EditEmployee"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  