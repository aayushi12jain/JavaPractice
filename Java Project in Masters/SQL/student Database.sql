create table school
(sch_code 	varchar2(8) 	constraint school_sch_code_pk primary key,
sch_name 	varchar2(50),
sch_phone 	varchar2(12),
sch_dean_name 	varchar2(35));


--The commands to insert the records in the SCHOOL table are listed below.  In the insert commands, the character and date values are enclosed in single quotes, but numeric values are not.  

insert into school values ('BUS', 'School of Business', '281-283-3100', 'Ed Waller');
insert into school values ('EDU', 'School of Education', '281-283-3600', 'Mark Shermis');
insert into school values ('HSH', 'School of Humanities and Human Sciences', '281-283-3333', 'Rick Short');
insert into school values ('SCE', 'School of Science and Computer Engineering', '281-283-3700', 'Zbigniew Czajkiewicz');


--The command to create the ADVISOR table follows.  This command demonstrates declaring a foreign key.

create table advisor
(adv_code            varchar2(8)	constraint advisor_adv_code_pk primary key,
adv_fname           varchar2(15),
adv_lname           varchar2(15),
adv_phone           varchar2(12),
sch_code              varchar2(8) 	constraint advisor_sch_code_fk references school (sch_code));

--The commands to insert records in the ADVISOR table:

insert into advisor values  ('A01', 'Toni', 'Rico', '281-283-3163', 'BUS');
insert into advisor values  ('A02', 'Gayla' , 'Brashears', '281-283-3400', 'BUS');
insert into advisor values  ('A03', 'Lee Ann', 'Wheelbarger', '281-283-3203', 'BUS');  
insert into advisor values  ('A04', 'Nancy', 'Newton', '281-283-3202', 'SCE');
insert into advisor values  ('A05', 'Dorothy', 'King', '281-283-3864', 'SCE');
insert into advisor values  ('A06', 'Kim', 'Davis', '281-283-3551', 'EDU');
insert into advisor values  ('A07', 'Judith', 'Allen', '281-283-3445', 'HSH');

--The command to create the FACULTY table:

create table faculty
(fac_code             varchar2(8)	constraint faculty_fac_code_pk primary key,
fac_fname            varchar2(15),
fac_lname            varchar2(15),
fac_gend              varchar2(8),
fac_phone            varchar2(12),
sch_code              varchar2(8) 	constraint faculty_sch_code_fk references school (sch_code));

--The commands to insert records in the FACULTY table:

insert into faculty values  ('F01', 'Gokhan', 'Gercek', 'M', '281-283-3163', 'BUS');
insert into faculty values  ('F02', 'Vance', 'Etnyre', 'M', '281-283-3400', 'BUS');
insert into faculty values  ('F03', 'Naveed', 'Saleem', 'M', '281-283-3203', 'BUS'); 
insert into faculty values  ('F04', 'Melissa', 'Williams', 'F', '281-283-3243', 'BUS'); 
insert into faculty values  ('F05', 'Susan', 'Sorensen', 'F', '281-283-3213', 'BUS');
insert into faculty values  ('F06', 'Kevin', 'Wooten', 'M', '281-283-3207', 'BUS');  
insert into faculty values  ('F07', 'Bun',  'Yue', 'M', '281-283-3202', 'SCE');
insert into faculty values  ('F08', 'Sharon', 'Perkins', 'F', '281-283-3864', 'SCE');
insert into faculty values  ('F09', 'Lisa', 'Jones', 'F', '281-283-3551', 'EDU');
insert into faculty values  ('F10', 'Robert', 'Pace', 'M', '281-283-3445', 'HSH');





--The command to create the DEPARTMENT table follows.  Note that it has two foreign keys.

create table department
(dept_code           varchar2(8) 	constraint department_dept_code_pk primary key,
dept_name           varchar2(50),
dept_phone          varchar2(12),
fac_code               varchar2(8) 	constraint department_fac_code_fk references faculty (fac_code),
sch_code              varchar2(8) 	constraint department_sch_code_fk references school (sch_code));


--The commands to insert records in the DEPARTMENT table:

insert into department values ('D01', 'Management Information Systems', '281-283-3186', 'F03', 'BUS');
insert into department values ('D02', 'Economics_Finance_Marketing', '281-283-3240','F04', 'BUS');
insert into department values ('D03', 'Management', '281-283-3373', 'F06', 'BUS');
insert into department values ('D04', 'Accounting', '281-283-3740','F05','BUS');
insert into department values ('D05', 'Software Engineering','282-283-3756','F08', 'SCE');
insert into department values ('D06', 'Psychology','281-283-3478','F10', 'HSH');
insert into department values ('D07', 'Curriculum Development','281-283-3215','F09','EDU');


--The command to create the MAJOR table:

create table major
(maj_code            varchar2(10)	constraint major_maj_code_pk primary key,
maj_desc              varchar2(30),
sch_code              varchar2(8) 	constraint major_sch_code_fk references school(sch_code));
 
--The commands to insert records in the MAJOR table:

insert into major values ('ACCT',  'Accounting', 'BUS');    
insert into major values ('FINC',  'Finance', 'BUS');      
insert into major values ('ISAM',  'Management Information Systems', 'BUS');
insert into major values ('CSCI',  'Computer Science', 'SCE');
insert into major values ('HIST', 'History', 'HSH');
insert into major values ('INST', 'Instructional Technology', 'EDU');


--The commands to create the MAJ_ADV table follows.  This command demonstrates declaring a composite primary key as a table constraint. 

create table maj_adv 
(maj_code            varchar2(10)	constraint  maj_adv_maj_code_fk references major (maj_code),
adv_code             varchar2(08)	constraint  maj_adv_adv_code_fk references advisor (adv_code),
maj_adv_level      varchar2(12),
constraint maj_adv_maj_code_adv_code_cpk primary key (maj_code, adv_code));

--The commands to insert records in the MAJ_ADV table:

insert into maj_adv values ('ACCT', 'A01', 'Lead');	
insert into maj_adv values ('ACCT', 'A02', 'Associate');
insert into maj_adv values ('FINC', 'A02', 'Lead');
insert into maj_adv values ('ISAM', 'A03', 'Associate');
insert into maj_adv values ('ISAM', 'A04', 'Lead');
insert into maj_adv values ('CSCI', 'A05', 'Lead');
insert into maj_adv values ('INST', 'A06', 'Lead');
insert into maj_adv values ('HIST', 'A07', 'Lead');
 

--The commands to create the STUDENT table follows.  This command demonstrates that a single-attribute primary key can also be declared as s column constraint.  

create table student
(std_code             varchar2(8),
std_fname            varchar2(15)	constraint student_std_lname_nn not null,
std_lname            varchar2(15)	constraint student_std_fname_nn not null,
std_gend              varchar2(8),	
maj_code              varchar2(10)	constraint student_maj_code_fk references major (maj_code),
std_dob	               date, 
constraint student_std_code_pk primary key (std_code));

--The commands to insert the records in the STUDENT table.  These commands use the to_date function to clarify the format in which a date value is being provided.

--If we don't have all the values for a record, then we can use the following method to insert that record.  We list the names of the columns, for which we have the values, next to the table name, to specify the columns for which we are supplying the values.  We can also use the reserve word NULL to specify that no value is to be stored in the column in that position in the table. 

--REMARK insert into student (std_code, std_lname, std_fname, std_dob) 
--REMARK values ('S02', 'Barkley', 'Charles', to_date('12-Sep-1964','DD-Mon-YYYY'));

insert into student values ('S01', 'Michael', 'Jordan', 'M', 'FINC', to_date('10-Mar-1962', 'dd-mon-yyyy'));
insert into student values ('S02', 'Charles', 'Barkley', 'M', null, to_date('12-Sep-1964', 'dd-mon-yyyy'));
insert into student values ('S03','Magic', 'Johnson', 'M', 'ACCT',  to_date('13-Sep-1960', 'dd-mon-yyyy'));
insert into student values ('S04', 'Serena', 'Williams', 'F','ISAM', to_date('23-Oct-1980', 'dd-mon-yyyy'));
insert into student values ('S05', 'Tim', 'Duncan', 'M', 'ISAM', to_date('07-Aug-1972', 'dd-mon-yyyy'));
insert into student values ('S06','Steffi', 'Graff', 'F', 'CSCI', to_date('30-Apr-1962', 'dd-mon-yyyy'));
insert into student values ('S07','Martina', 'Navratilova', 'F', 'ACCT', to_date('18-Dec-1972', 'dd-mon-yyyy'));
insert into student values ('S08','Roger', 'Federer', 'M', 'ISAM', to_date('18-Aug-1982', 'dd-mon-yyyy'));
insert into student values ('S09','Venus', 'Williams', 'F', 'HIST', to_date('11-Jun-1980', 'dd-mon-yyyy'));
insert into student values ('S10','Rod', 'Laver', 'M', 'CSCI', to_date('18-Dec-1942', 'dd-mon-yyyy'));


--The command to create the table GRADE is listed below.  This table has two constraints on the std_code column: PK as well as FK constraints.  The gr_t1 column has a check constraint.  

create table grade
(std_code             varchar2(8)	constraint grade_std_code_pk primary key
				constraint grade_std_code_fk references student (std_code),
std_fname            varchar2(15)	constraint grade_std_lname_nn not null,
std_lname            varchar2(15)	constraint grade_std_fname_nn not null,
gr_t1	               number(5)	constraint grade_gr_t1_cc check (gr_t1 between 0 and 100),
gr_t2	               number(5),	
gr_hw	               number(5),	
gr_pr	               number(5),
gr_avg	               number(5,2),
gr_lg	               varchar2(5));

--The commands to insert records in the GRADE table.  The following commands show another way in which we insert a record for which we don't have all the values.  In this case, we simply list 'null', for the column for which we don't have the values.

insert into grade values ('S01', 'Michael', 'Jordan' , 90, 80, 98, 90, null, null);
insert into grade values ('S02', 'Charles', 'Barkley', 60, 100, 100, 60, null, null);
insert into grade values ('S03', 'Magic', 'Johnson',  88, 98, 96, 98, null, null);
insert into grade values ('S04', 'Serena', 'Williams',92, 92, 92, 92,null,null);
insert into grade values ('S05', 'Tim', 'Duncan', 94, 90, 94, 96, null, null);
insert into grade values ('S06', 'Steffi', 'Graff', 90, 84, 89, 92, null, null);
insert into grade values ('S07','Martina', 'Navratilova', 91, 88, 94, 95, null, null);
insert into grade values ('S08','Roger', 'Federer', 96,89,84,91,null,null);
insert into grade values ('S09','Venus', 'Williams', 83,89,96,89,null,null);
insert into grade values ('S10','Rod', 'Laver', 100,100,100,100,null,null);






--The command to create the ACTIVITY table:

create table activity
(act_code  varchar2(8) constraint activity_act_code_pk primary key,
act_name  varchar2(15),
act_fee  number(6,2));


--The commands to insert the records into the ACTIVITY table:

insert into activity values ('Act01', 'Tennis', 50);
insert into activity values ('Act02', 'Football', 30);
insert into activity values ('Act03', 'Basketball', 25);
insert into activity values ('Act04', 'Swimming', 30);

--The command to create the STD_ACT table follows.  This command declares a composite primary key, and also declares the two components of the primary keys as individual foreign keys. 

create table std_act
(std_code  varchar2(8) constraint std_act_std_code_fk references student(std_code),
act_code varchar2(8) constraint std_act_act_code_fk references activity (act_code),
std_act_num number(12),
std_act_joined date,
constraint std_act_std_code_act_code_cpk primary key(std_code, act_code));


--The commands to insert records into the STD_ACT table.  It also uses the to_date funct :

insert into std_act values ('S01','Act01',1,to_date('18-Jan-2023', 'dd-mon-yyyy'));
insert into std_act values ('S01','Act02',2,to_date('12-Feb-2023', 'dd-mon-yyyy'));
insert into std_act values ('S02','Act04',1,to_date('26-Feb-2023', 'dd-mon-yyyy'));
insert into std_act values ('S03','Act01',1,to_date('12-Mar-2023', 'dd-mon-yyyy'));
insert into std_act values ('S04','Act02',1,to_date('17-Apr-2023', 'dd-mon-yyyy'));
insert into std_act values ('S05','Act01',1,to_date('20-Jun-2023', 'dd-mon-yyyy'));
insert into std_act values ('S05','Act02',1,to_date('22-Jul-2023', 'dd-mon-yyyy'));
insert into std_act values ('S05','Act03',1,to_date('20-Aug-2023', 'dd-mon-yyyy'));
insert into std_act values ('S08','Act03',1,to_date('21-Aug-2023', 'dd-mon-yyyy'));
insert into std_act values ('S01','Act04',1,to_date('22-Aug-2023', 'dd-mon-yyyy'));


	



