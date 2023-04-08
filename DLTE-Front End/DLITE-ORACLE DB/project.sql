-- bank table
create table bank(bank_id int not null, bank_name varchar(255) not null,bank_address varchar(255) not null);
alter table bank add constraint bank_seq primary key(bank_id);
create sequence bank_seq start with 101 increment by 1;
-- branch table 
create table branch(bank_id int not null, branch_id int not null, branch_name varchar(255) not null, branch_location varchar(255), branch_address varchar(255) not null, branch_ifsc varchar(255) not null unique);
alter table branch add constraint branch_seq primary key(bank_id);
create sequence branch_seq start with 101 increment by 1;
-- role table 
create table role(role_id int not null, role_name varchar(255) not null, role_description varchar(255) not null, role_status varchar(255), branch_id int not null);
alter table role add constraint role_seq primary key(role_id);
create sequence role_seq start with 101 increment by 1;
alter table role add add foreign key(branch_id) references branch(branch_id);
-- loan table
create table loan(  loan_id int not null, loan_type varchar(255), loan_name varchar(255), loan_description varchar(255), loan_roi int not null, loan_duration int not null);
alter table loan add constraint loan_seq primary key(loan_id);

-- customer table
create table customer(customer_id int not null,customer_name varchar(255) not null, customer_address varchar(255) not null, customer_status varchar(255) not null, customer_contact int not null, branch_ifsc varchar(255) not null);
alter table customer add constraint customer_seq primary key(customer_id);
create sequence customer_seq start with 101 increment by 1;
alter table customer add add foreign key(branch_ifsc) references branch(branch_ifsc);

-- profile table
create table profile(profile_id int not null, profile_pan varchar(255) not null, profile_aadhaar int  not  null, Profile_status varchar(255) not null, customer_id int null);
alter table profile add constraint profile_seq primary key(profile_id);
create sequence profile_seq start with 101 increment by 1;
alter table profile add foreign key(customer_id) references customer(customer_id);
-- account table
create table account(account_id int not null, account_type varchar(255) not null, avilable_balance int not null, account_status varchar(255) not null, customer_id int not null );
alter table account add constraint account_seq primary key(account_id);
create sequence account_seq start with 2457686453 increment by 1;
alter table account add foreign key(customer_id) references customer(customer_id);
-- customer_loan
create table customer_loan(loan_appliction_id int not null, loan_type varchar(255) not null, loan_name varchar(255) not null, loan_description varchar(255) not null, loan_amount int not null, loan_emi int not null,customer_id);
alter table customer_loan add constraint customer_loan_seq primary key(loan_appliction_id);
create sequence customer_loan_seq start with 87645 increment by 1;
alter table customer_loan add foreign key(customer_id) references customer(customer_id);
-- transaction table
create table transaction(transaction_id int not null, transaction_type varchar(255) not null, transaction_amount int not null, transaction_status varchar(255) not null, account_id int not null, transaction_date date not null );
alter table transaction add constraint transaction_seq primary key(transaction_id);
create sequence transaction_seq start with 245768645343 increment by 1;
alter table transaction add foreign key(account_id) references account(account_id);