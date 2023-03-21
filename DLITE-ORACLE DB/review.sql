--student table
create table student(register_number int not null, student_name varchar(255) not null, student_age int not null, student_email varchar(255) not null, address_id int not null unique);
create sequence address_seq start with 101 increment by 1;
insert into student values (11,'Karthik',21,'karthik@gmail.com',address_id.NEXTVAL);
insert into student values (12,'Srikanth',32,'srikanth@gmail.com',address_id.NEXTVAL);

--address table 
 create table address(add_id int not null, locality varchar(255) not null, area varchar(255) not null, city varchar(255) not null, pincode int not null);

 alter table  add primary key(add_id);
 
 alter table address add foreign key(add_id) references student(address_id) on delete cascade;

 




