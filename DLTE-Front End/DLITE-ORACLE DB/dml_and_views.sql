create view allfeilds as select * from credit_card;
select * from allfeilds;
create view major_details as select card_holder, card_pin, card_limit from credit_card;
create view secure as select card_number, card_pin, card_expiry from credit_card;
create view major_customer as select card_holder, card_limit from credit_card where card_limit>=40000;

create type card_holder_names as table of varchar(255);
select cast(collect(card_holder) as card_holder_names)  from allfeilds;