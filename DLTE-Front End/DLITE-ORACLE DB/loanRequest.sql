-- loan table
create table loan(loan_number int not null,borrower_name varchar(255) not null, loan_type varchar(255) not null , loan_amount int not null, issue_date date not null);
alter table loan add constraint loan_seq primary key(loan_number);
create sequence loan_seq start with 1001 increment by 1;
insert into loan values(loan_seq.NEXTVAL, 'Karthik', 'Education',300000, '11-01-2022');
insert into loan values(loan_seq.NEXTVAL, 'Razak', 'home',6543100, '12-02-2022');
insert into loan values(loan_seq.NEXTVAL, 'Karthik', 'veichle',2350000, '08-17-2022');
insert into loan values(loan_seq.NEXTVAL, 'Razak', 'business',8765000, '02-12-2022');
insert into loan values(loan_seq.NEXTVAL, 'Amrutha', 'Education',435600, '09-22-2022');

-- customer table 
create table customer(customer_id int not null, customer_name varchar(255) not null,email varchar(255) not null, pan varchar(255) not null,contact int not null, pin int  not null );
alter table customer add primary key(customer_id);
insert into customer(2001,'Karthik','karthik@gmail.com', 'SDFG435DF',3245643324,2023);
insert into customer(2002,'Razak','Razak@gmail.com', 'DST234AES',4356754423,2024);
insert into customer(2003,'Amrutha','amrutha@gmail.com', 'ZDT345S32',876543245,2025);
insert into customer(2004,'Manvith','manvith@gmail.com', 'KJ3R34554',876543452,2026);
insert into customer(2005,'Pooja','pooja@gmail.com', 'DSDF43SDR4',1598433742,2027);

-- mapper table
create table loan_mapper(loan_id int not null,cust_id int not null);
alter table loan_mapper add foreign key(loan_id) references loan(loan_number);
alter table loan_mapper add foreign key(cust_id) references customer(customer_id);
insert into loan_mapper(1001,2001);
insert into loan_mapper values(1002,2002);
insert into loan_mapper values(1003,2001);
insert into loan_mapper values(1004,2002);
insert into loan_mapper values(1005,2003);




select * from loan_mapper,loan where cust_id= customer_id and loan_id= loan_number;