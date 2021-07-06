<%@page import="next.xadmin.login.database.LoginDao"%>  
<jsp:useBean id="u" class="next.xadmin.login.bean.LoginBean"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
LoginDao.delete(u);  
response.sendRedirect("viewEmployee.jsp");  
%>  