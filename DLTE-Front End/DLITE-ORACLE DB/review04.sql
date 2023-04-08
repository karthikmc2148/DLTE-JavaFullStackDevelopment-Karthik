create table student(register_number int not null, student_name varchar(255) not null, student_age int null, student_email varchar(255) not null);
alter table student add primary key(register_number);
create table address(address_id int not null, door_number int not null, street varchar(255) not null, city varchar(255) not null, pin_code int not null);
alter table address add primary key(address_id);
create sequence address_id start with 101 increment by 1;
create table address_mapper(reg_number int not null, add_id int not null);
alter table address_mapper add foreign key(reg_number) references student(register_number);
alter table address_mapper add foreign key(add_id) references student(address_id);
alter table address add address_type varchar(255) not null;