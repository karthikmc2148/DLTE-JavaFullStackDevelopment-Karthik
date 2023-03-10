--To create the  bill table
create table bills(bill_id int not null, card_number int not null, bill_amount int not null, due_date date not null, minimum_bill int not null);
alter table bills add constraint bill_id_seq primary key(bill_id);
create sequence bill_id_seq  start with 1964722 increment by 1;
--set the card_number(feild) as the forign key
 alter table bills add FOREIGN key(card_number) REFERENCES credit_card(card_number);
--insert the records to the bills table

insert into bills values(bill_id_seq.NEXTVAL, 23432122863, 4999, '05/10/2023' ,234);
insert into bills values(bill_id_seq.NEXTVAL, 23432122864, 7336,'04/23/2023', 424);
insert into bills values(bill_id_seq.NEXTVAL, 23432122866, 6499,'09/182023',345);
insert into bills values(bill_id_seq.NEXTVAL, 23432122867, 9432,'07/17/2023', 4362 );
insert into bills values(bill_id_seq.NEXTVAL, 23432122868, 452,'10/11/2023' ,624);
insert into bills values(bill_id_seq.NEXTVAL, 23432122869, 0425,'09/10/2023' ,753);
insert into bills values(bill_id_seq.NEXTVAL, 23432122870, 1319,'01/20/2023' ,624);
insert into bills values(bill_id_seq.NEXTVAL, 23432122871, 4522,'09/27/2023' ,634);
insert into bills values(bill_id_seq.NEXTVAL, 23432122872, 4539,'04/05/2023' ,975);
insert into bills values(bill_id_seq.NEXTVAL, 23432122873, 9634,'02/08/2023' ,134);

--update the bill using bill_amount

update bills set due_date= '01/01/2024' where bill_amount>=5000;
update bills set due_date= '08/12/2023' where bill_amount<5000;

-- fetch the card_holder, card_number, bill_amount, due_date using outer right join

 select card_holder, bills.card_number, bill_amount, due_date from bills left join credit_card on bills.card_number=credit_card.card_number;