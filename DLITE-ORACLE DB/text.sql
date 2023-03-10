--to create the payee table
create table payee_details(customer_id int not null, customer_name varchar(255) not null, payee_name varchar(255) not null, payee_account_number varchar(255), payee_ifsc varchar(255) not null);
--set the customer_id as primary key
alter table payee_details add constraint id_seq primary key(customer_id);
create sequence id_seq start with 875758792 increment by 1;
insert into payee_details values(id_seq.NEXTVAL, 'karthik','Razak', '988658790', 'ICIC37842');
insert into payee_details values(id_seq.NEXTVAL, 'Razak','Razak', '13658790', 'CBN37842');
insert into payee_details values(id_seq.NEXTVAL, 'Apoorava','amogha', '24324690', 'LSBI37842');
insert into payee_details values(id_seq.NEXTVAL, 'Surya','aishwarya', '988658790', 'AKE37842');
insert into payee_details values(id_seq.NEXTVAL, 'Manvith','Adarsh', '946387732', 'LSF37842');

--Trigger
create table available_payee(payee_name varchar(255) not null);
create or replace trigger payee_details
after update on available_payee
for each row
when(new.payee_name > 0)
declare 
 newPAyee varchar(255);
begin
     insert into available_payee values(newPAyee);
 end;
