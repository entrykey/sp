This is a read me file
How to setup Project 
Spring Boot Application:

Step 1 : clone repo in local machine

step 2 : create table name sp8 

step 3 : configure the db username password as below.



spring.datasource.url=jdbc:mysql://localhost:3306/sp8

spring.datasource.username=root

spring.datasource.password=


run the below query to insert seed query to active the admin user 


INSERT INTO sp9.user (id, enabled, gender, name, password, username) VALUES ('1', b'1', 'M', 'admin', 'admin', 'admin');

INSERT INTO sp9.role (id, name)VALUES (1,'ROLE_ADMIN');

INSERT INTO sp9.users_roles (user_id, role_id)VALUES (1,1);


Stp 4 : run the application
