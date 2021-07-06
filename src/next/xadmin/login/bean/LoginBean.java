package next.xadmin.login.bean;

public class LoginBean {
private String fullName;
private String username;
private int id;
private String gender;
private String role;
private String projectName;
String project_status;
private String dop;


private String Password;



public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username; 
}

public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public int getid() {
	return id;
}
public void setid(int id) {
	this.id = id;
}

public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}



public String getDop() {
	return dop;
}
public void setDop(String dop) {
	this.dop = dop;
}
public String getProjectStatus() {
	
	return project_status;
}
public void  setProjectStatus(String project_status) {
	
	this.project_status=project_status;
}







}
