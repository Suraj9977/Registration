create table project(
id int,
project_Name varchar(15) ,
project_status varchar(10) ,
dop varchar(10),
PRIMARY KEY (project_Name));  

create table employee_role(
id int,
role_name varchar(15),
PRIMARY KEY(role_name)
);

create table employee(
id int, 
employee_full_name varchar(15),
employee_username varchar(50),
employee_password varchar(50), 
role_name varchar(15), 
gender varchar(15) ,
project_Name varchar(15),
PRIMARY KEY (employee_username),
FOREIGN KEY(project_Name) REFERENCES project(project_Name),
FOREIGN KEY(role_name) REFERENCES employee_role(role_name)
);  