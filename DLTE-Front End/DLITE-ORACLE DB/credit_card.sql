--A table that includes the deails of the card 
create table credit_card(card_number int not null, card_holder varchar(255) not null, card_pin int not null,card_expiry date not null, card_limit int not null);

--make card_number as the primary key
alter table credit_card add constraint card_number_seq PRIMARY key(card_number);

create sequence card_number_seq start with 23432122863 increment by 1;

--10 records are inserted in the table card_number
insert into credit_card(card_number, card_holder, card_pin, card_expiry, card_limit ) values(card_number_seq.NEXTVAL, 'Guru Venkat', 7522, '2-06-2023', 30000 );
insert into credit_card(card_number, card_holder, card_pin, card_expiry, card_limit ) values(card_number_seq.NEXTVAL, 'Karthik M C', 8325, '09-06-2023', 53000 );
insert into credit_card(card_number, card_holder, card_pin, card_expiry, card_limit ) values(card_number_seq.NEXTVAL, 'Aporva V C ', 6463, '21-04-2023', 20000 );
insert into credit_card(card_number, card_holder, card_pin, card_expiry, card_limit ) values(card_number_seq.NEXTVAL, 'sai Kethan Babu', 8432, '14-08-2023', 20000 );
insert into credit_card(card_number, card_holder, card_pin, card_expiry, card_limit ) values(card_number_seq.NEXTVAL, 'Kumar Swamy', 4216, '11-02-2023', 70000 );
insert into credit_card(card_number, card_holder, card_pin, card_expiry, card_limit ) values(card_number_seq.NEXTVAL, 'Aishwarya', 4252, '29-09-2023', 45000 );
insert into credit_card(card_number, card_holder, card_pin, card_expiry, card_limit ) values(card_number_seq.NEXTVAL, 'Rutvij', 6332, '12-06-2023', 30000 );
insert into credit_card(card_number, card_holder, card_pin, card_expiry, card_limit ) values(card_number_seq.NEXTVAL, 'Amogha Shekar', 1341, '30-08-2023', 30200 );
insert into credit_card(card_number, card_holder, card_pin, card_expiry, card_limit ) values(card_number_seq.NEXTVAL, 'revanshi', 7862, '19-06-2023', 60000 );
insert into credit_card(card_number, card_holder, card_pin, card_expiry, card_limit ) values(card_number_seq.NEXTVAL, 'Razzak', 2365, '07-07-2023', 50000 );

--update card_expiry

update credit_card set card_expiry = '23-08-2024' where card_holder = 'Amogha';
update credit_card set card_expiry = '23-08-2024' where card_holder = 'Guru Venkat';
update credit_card set card_expiry = '23-08-2024' where card_holder = 'Karthik M C';
update credit_card set card_expiry = '23-08-2024' where card_holder = 'Aporva V C';
update credit_card set card_expiry = '23-08-2024' where card_holder = 'Razzak';

