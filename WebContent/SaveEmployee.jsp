<%@page import="next.xadmin.login.database.LoginDao"%>  
<jsp:useBean id="u" class="next.xadmin.login.bean.LoginBean"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
  
<%  
int i=LoginDao.save(u);  
if(i>0){  
response.sendRedirect("addEmployeesucess.jsp");  
}else{  
response.sendRedirect("addEmployee-error.jsp");  
}  
%>  