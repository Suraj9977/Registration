package next.xadmin.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import next.xadmin.login.bean.LoginBean;

public class LoginDao {
  private static String dbUrl="jdbc:mysql://localhost:3306/employee_management";
  private static String dbUser="root";
  private static String dbPassword="password";
  private static String dbDriver="com.mysql.jdbc.Driver";
  
  public static void loadDriver(String dbDriver)
  { try
	  {
	  Class.forName(dbDriver);
	  }
  catch(ClassNotFoundException e){
	  e.printStackTrace();
	  
	  
  }
  }
  public static Connection getConnection()
  {
	  Connection con=null;
	  try {
	  con= (Connection) DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	  }catch(SQLException e){
		  e.printStackTrace();
	  }
	  return con;
  }
  
  
public boolean validate(LoginBean loginBean) {
	loadDriver(dbDriver);
	Connection con= getConnection();
	boolean status=false;
	String sql="Select * from employee where employee_username = ? and employee_password = ? ";
	
	 try {
		 PreparedStatement ps;
		 ps= ((java.sql.Connection) con).prepareStatement(sql);
		 ps.setString(1, loginBean.getUsername());
		 ps.setString(2, loginBean.getPassword());
		 
		 ResultSet rs =ps.executeQuery();
		 status=rs.next();
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
	return status;
	 
}

public static int save(LoginBean u){ 
	loadDriver(dbDriver);
	Connection con= getConnection();
    int status=0;  
    try{  
          
        PreparedStatement ps=con.prepareStatement(  
"insert into employee(employee_full_name,employee_username,employee_password,role_name,gender,project_Name,id) values(?,?,?,?,?,?,?)");  
        ps.setString(1,u.getFullName());  
        ps.setString(2,u.getUsername()); 
        ps.setString(3,u.getPassword());  
        ps.setString(4,u.getRole());  
        ps.setString(5,u.getGender());  
        ps.setString(6,u.getProjectName());
        ps.setInt(7,u.getid());
       
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int update(LoginBean u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"update employee set employee_full_name=?,employee_username=?,employee_password=?,role_name=?,gender=?,project_Name=? where id=?");  
        ps.setString(1,u.getFullName());  
        ps.setString(2,u.getUsername());  
        ps.setString(3,u.getPassword());  
        ps.setString(4,u.getRole());  
        ps.setString(5,u.getGender()); 
        ps.setString(6,u.getProjectName());
        ps.setInt(7,u.getid());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int delete(LoginBean u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from employee where id=?");  
        ps.setInt(1,u.getid());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}  
public static List<LoginBean> getAllRecords(){  
    List<LoginBean> list=new ArrayList<LoginBean>();  
      
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from employee");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
        	LoginBean u=new LoginBean();  
            u.setid(rs.getInt("id"));  
            u.setFullName(rs.getString("employee_full_name"));  
            u.setPassword(rs.getString("employee_password"));  
            u.setRole(rs.getString("role_name"));  
            u.setGender(rs.getString("gender"));  
            u.setProjectName(rs.getString("project_Name"));  
            u.setUsername(rs.getString("employee_username"));
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
}  
public static LoginBean getRecordById(int id){  
	LoginBean u=null;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from employee where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new LoginBean();  
            u.setid(rs.getInt("id"));  
            u.setFullName(rs.getString("employee_full_name"));  
            u.setPassword(rs.getString("employee_password"));  
            u.setRole(rs.getString("role_name"));  
            u.setGender(rs.getString("gender"));  
            u.setProjectName(rs.getString("project_Name"));  
            u.setUsername(rs.getString("employee_username"));  
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
}
public static int saveProject(LoginBean u){ 
	loadDriver(dbDriver);
	Connection con= getConnection();
    int status=0;  
    try{  
          
        PreparedStatement ps=con.prepareStatement(  
"insert into project(project_Name,project_status,dop) values(?,?,?)");  
       
        ps.setString(1,u.getProjectName());
        ps.setString( 2,u.getProjectStatus());
        ps.setString(3,u.getDop());
        
       
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int updateProject(LoginBean u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"update project set project_Name=?,project_status=?,dop=?");  
        ps.setString(1,u.getProjectName());  
        ps.setString(2,u.getProjectStatus());  
        ps.setString(3,u.getDop());  
       
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  

}
public static int deleteProject(LoginBean u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from project where project_Name=?");  
        ps.setString(1,u.getProjectName());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}
public static List<LoginBean> getAllRecords1(){  
    List<LoginBean> list=new ArrayList<LoginBean>();  
      
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from project");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
        	LoginBean u=new LoginBean();  
            u.setDop(rs.getString("dop"));  
            u.setProjectName(rs.getString("project_Name"));  
            u.setProjectStatus(rs.getString("project_status"));  
           
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
}


public static LoginBean getRecordByProjectName(String projectName){  
	
    LoginBean u = null;
	try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from project where project_Name=?");  
        ps.setString(1,projectName);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new LoginBean();  
            u.setid(rs.getInt("dop"));  
            u.setFullName(rs.getString("project_Name"));  
            u.setPassword(rs.getString("project_status"));  
            ;  
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
}
}
