--Table BANK--

create table bank(bank_id int not null, bank_name varchar(255) not null, bank_address varchar(255) not null);

create sequence bank_id_seq start with 100 increment by 1;

alter table bank add constraint bank_id_seq primary key(bank_id);
-- insert the values--

insert into bank values(bank_id_seq.NEXTVAL, 'people bank', 'bangalore');

--Table BRANCH--

create table branch(branch_id int not null, branch_name varchar(255) not null, branch_address varchar(255) not null,branch_ifsc varchar(255) not null, bank_id int not null);

create sequence branch_id_seq start with 100 increment by 1;

alter table branch add constraint branch_seq primary key(branch_id);

alter table branch add foreign key(bank_id) references bank(bank_id);

-- insert the values--

insert into branch values(branch_id_seq.NEXTVAL, 'gandhi nagar branch', 'mysore','SDR3243435', bank_id_seq.CURRVAL );

insert into branch values(branch_id_seq.NEXTVAL, 'kumar swamy branch', 'ballari','RTJK435678', bank_id_seq.CURRVAL );

insert into branch values(branch_id_seq.NEXTVAL, 'dollers branch', 'bangakore','SRYUY34567', bank_id_seq.CURRVAL );

insert into branch values(branch_id_seq.NEXTVAL, 'shadinagar branch', 'shivamogga','RTY43567435', bank_id_seq.CURRVAL );



--Table ROLE--

create table role(role_id int not null, role_name varchar(255) not null,role_desc varchar(255) not null,role_status varchar(255) not null, branch_id int not null, username varchar(255) not null, password varchar(255) not null);

create sequence role_id_seq start with 100 increment by 1;

alter table role add constraint role_seq primary key(role_id);

alter table role add foreign key(branch_id) references branch(branch_id);

-- insert the values--

insert into role values(role_id_seq.NEXTVAL, 'admin', ' view all customers', 'active', 100, 'karthik', 'karthik123' );

insert into role values(role_id_seq.NEXTVAL, 'bank official', ' create new loan schemes,view and edit customers', 'inactive', 100, 'gourav', 'gourav123' );

insert into role values(role_id_seq.NEXTVAL, 'bank official', ' view all customers', 'active', 101, 'apoorva ', 'apoorva123' );


insert into role values(role_id_seq.NEXTVAL, 'admin', ' view all customers', 'active', 101, 'manvith', 'manvith123' );




--Table ADMIN loans--

create table loan_scheme(loan_scheme_id int not null , loan_scheme_type varchar(255) not null,loan_scheme_name varchar(255) not null,loan_scheme_desc varchar(255) not null, loan_scheme_roi float not null);

create sequence loan_scheme_seq start with 5000 increment by 1;

alter table loan_scheme add constraint loan_scheme_seq primary key(loan_scheme_id);

-- insert the values--

insert into loan_scheme values(loan_scheme_seq.NEXTVAL, 'education loan', 'vidhyasiri','students persuing degree', 9.5);

insert into loan_scheme values(loan_scheme_seq.NEXTVAL, 'vehicle loan', 'vahana raksa','customer having cibil>700 can apply', 6.5);

insert into loan_scheme values(loan_scheme_seq.NEXTVAL, 'gold loan', 'siri','accepts even 18 carot gold', 11.5);

insert into loan_scheme values(loan_scheme_seq.NEXTVAL, 'home  loan', 'ghura kshema','offers loan upto 40lakh', 5.5);


--Table CUSTOMER--

create table customer(customer_id int not null,customer_name varchar(255) not null,customer_address varchar(255) not null, customer_status varchar(255) not null, customer_contact int not null, username varchar(255) not null, password varchar(255) not null);

create sequence customer_id_seq start with 100 increment by 1;

alter table customer add constraint customer_id_seq primary key(customer_id);

-- insert the values--

insert into customer values(customer_id_seq.NEXTVAL,'karthik', '#47, gandhi nagar, ballari', 'active', '2345764532','karthik','karthik123');

insert into customer values(customer_id_seq.NEXTVAL,'razak', '34, subash nagar, salem', 'inactive', '98765344335','razak','razak123');

insert into customer values(customer_id_seq.NEXTVAL,'apoorva', '#48, kumar swamy temple, ballari', 'active', '753465725','apoorva','apoorva123');

insert into customer values(customer_id_seq.NEXTVAL,'kethan', '56, shivaji nagar, bangalore', 'inactive', '8794763763','kethan','kethan123');





--Table PROIFLES--

create table profile(profile_id int not null,profile_pan varchar(255) not null,profile_aadhaar int not null, profile_status varchar(255) not null, customer_id int not null);

alter table profile add constraint profile_id_seq primary key(profile_id);

create sequence profile_id_seq start with 100 increment by 1;

alter table profile add foreign key(customer_id) references customer(customer_id);

-- insert the values--

insert into profile values(profile_id_seq.NEXTVAL, 'S433SD435',23564532465, 'active',100 );

insert into profile values(profile_id_seq.NEXTVAL, 'SKR3476D7',98876553623, 'inactive',101 );

insert into profile values(profile_id_seq.NEXTVAL, 'SDR3456SD4',3768267654, 'active',102 );

insert into profile values(profile_id_seq.NEXTVAL, 'SYLDY3465D',98765415675, 'inactive',103 );






--Table Account--

create table account(account_id int not null,account_type varchar(255) not null,account_number int not null unique, account_avl_balance float not null,account_status varchar(255) not null, customer_id int not null,branch_id int not null);

alter table account add constraint account_id_seq primary key(account_id);

create sequence account_id_seq start with 100 increment by 1;

alter table account add foreign key(customer_id) references customer(customer_id);

alter table account add foreign key(branch_id) references branch(branch_id);

-- insert the values--

insert into account values(account_id_seq.NEXTVAL, 'current',34567543245, 344653.215, 'active',100, 100);

insert into account values(account_id_seq.NEXTVAL, 'saving', 43832453256, 85353.215, 'inactive',100, 100);

insert into account values(account_id_seq.NEXTVAL, 'current',32657543283,24343.436, 'active',101, 101);

insert into account values(account_id_seq.NEXTVAL, 'saving', 32476453245, 136342.53, 'inactive',101, 101);

insert into account values(account_id_seq.NEXTVAL, 'current', 8763484224, 67343.215, 'active',103, 102);

insert into account values(account_id_seq.NEXTVAL, 'saving', 87635323643, 4325.87943, 'inactive',103, 100);

insert into account values(account_id_seq.NEXTVAL, 'saving', 8765324354, 357324.46, 'active',102, 102);

insert into account values(account_id_seq.NEXTVAL, 'saving', 4564332456, 3245765.34, 'inactive',102, 100);


--Table TRANSACTION--

create table transaction(txn_id int not null,txn_from int not null,txn_to int not null,txn_amount float not null, txn_status varchar(255) not null, trans_date DATE not null);

alter table transaction add constraint txn_id_seq primary key(txn_id);

create sequence txn_id_seq start with 6754324565 increment by 1;

alter table transaction add foreign key(txn_from) references account(account_number);

alter table transaction add foreign key(txn_to) references account(account_number);

-- insert the values--

insert into transaction values(txn_id_seq.NEXTVAL, 34567543245,43832453256,35636.532, 'success', '02-03-23' );

insert into transaction values(txn_id_seq.NEXTVAL, 34567543245,32657543283,2523.42, 'pending', '11-08-23' );

insert into transaction values(txn_id_seq.NEXTVAL, 43832453256,34567543245,3235.353, 'failed', '09-12-22' );

insert into transaction values(txn_id_seq.NEXTVAL, 32657543283,8763484224,246.236, 'success', '21-06-19' );

insert into transaction values(txn_id_seq.NEXTVAL, 8763484224,32657543283,1245352.532, 'success', '29-03-23' );

insert into transaction values(txn_id_seq.NEXTVAL, 8763484224,43832453256,8676.532, 'pending', '12-01-2023' );

insert into transaction values(txn_id_seq.NEXTVAL, 87635323643,32657543283,254326.532, 'failed', '19-07-23' );

insert into transaction values(txn_id_seq.NEXTVAL, 87635323643,8763484224,632.463, 'success', '02-09-15' );

insert into transaction values(txn_id_seq.NEXTVAL, 8765324354,8763484224,34633.352, 'failed', '11-11-23' );

insert into transaction values(txn_id_seq.NEXTVAL, 8765324354,32657543283,56735.234, 'success', '12-05-20' );

insert into transaction values(txn_id_seq.NEXTVAL, 4564332456,32657543283,7645246.34, 'pending', '17-10-23' );

insert into transaction values(txn_id_seq.NEXTVAL, 4564332456,8765324354,2352.34, 'success', '12-04-18' );

--Table PAYEE--

create table payee(payee_id int not null,payee_name varchar(255) not null, account_number int not null,customer_id int not null);

create sequence payee_id_seq start with 100 increment by 1;

alter table payee add constraint payee_id_seq primary key(payee_id);

alter table payee add foreign key(customer_id) references customer(customer_id);

alter table payee add foreign key(account_number) references account(account_number);

-- insert the values--

insert into payee values(payee_id_seq.NEXTVAL, 'karthik', 34567543245, 100 );

insert into payee values(payee_id_seq.NEXTVAL, 'razak', 32476453245, 101 );

insert into payee values(payee_id_seq.NEXTVAL, 'apoorva', 34567543245, 102 );

insert into payee values(payee_id_seq.NEXTVAL, 'kethan', 8763484224, 103 );


--Table Loan-project--

create table loan(loan_App_id int not null, loan_amount float not null, loan_emi float not null,loan_scheme_id int not null,customer_id int not null);

create sequence loan_App_id_seq start with 5000 increment by 1;

alter table loan add constraint loan_App_id_seq primary key(loan_App_id);

alter table loan add foreign key(customer_id) references customer(customer_id);

alter table loan add foreign key(loan_scheme_id) references loan_scheme(loan_scheme_id);

-- insert the values--

insert into loan values(loan_App_id_seq.NEXTVAL, 500000.00, 7800.653, 5000, 100);

insert into loan values(loan_App_id_seq.NEXTVAL, 1000000.00, 7800.653, 5002, 100);

insert into loan values(loan_App_id_seq.NEXTVAL, 2500000.00, 7800.653, 5003, 102);

insert into loan values(loan_App_id_seq.NEXTVAL, 640000.00, 7800.653, 5001, 101);

insert into loan values(loan_App_id_seq.NEXTVAL, 70000.00, 7800.653, 5003, 103);


