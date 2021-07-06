<%@page import="next.xadmin.login.database.LoginDao"%>  

<jsp:useBean id="u" class="next.xadmin.login.bean.LoginBean"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
int i=LoginDao.update(u);  
response.sendRedirect("viewEmployee.jsp");  
%>  