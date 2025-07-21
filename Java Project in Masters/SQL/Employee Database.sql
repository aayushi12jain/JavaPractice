create table employee
(emp_num 	varchar2(7) constraint employee_emp_num_pk primary key,
emp_fname 	varchar2(15) constraint employee_emp_lname_nn not null,
emp_lname     varchar2(15) constraint employee_emp_fname_nn not null,
emp_ini       	varchar2(7),
emp_sal    	number(5) 
                        constraint employee_emp_sal_cc check (emp_sal between 5000 and 20000),
emp_title       	varchar2(15),
emp_gend  	varchar2(7),
emp_dob       	date,
emp_doe       	date,
dept_id          	varchar2(8),
emp_phone    	varchar2(12),
emp_off         	varchar2(7));


insert into employee 
values ('E01', 'Michael', 'Jordan', null, 10000, 'IT Engineer', 'M', to_date('10-Feb-1964', 'dd-mon-yyyy'), to_date('12-Sep-1982', 'dd-mon-yyyy'),'COM', '281-283-3498', 'B1');

insert into employee 
values ('E02', 'Federer', 'Roger', 'null', 9000, 'IT Engineer', 'M', to_date('15-May-1955', 'dd-mon-yyyy'), to_date('12-Jan-1998', 'dd-mon-yyyy'), 'COM', '281-283-3447', 'B2');

insert into employee 
values ('E03', 'Michelle', 'Obama', null, 15000, 'VP', 'F', to_date('10-Sep-1945', 'dd-mon-yyyy'), to_date('24-Aug-1978', 'dd-mon-yyyy'), 'PRO', '281-283-4464', 'A1');

insert into employee 
values ('E04', 'George', 'Bush', 'W', 14000, 'VP', 'M', to_date('13-Aug-1954', 'dd-mon-yyyy'), to_date('17-Apr-1984', 'dd-mon-yyyy'), 'ACC', '281-284-7642', 'A2');

insert into employee 
values ('E05', 'Steffi', 'Graff', null, 13000, 'Accountant', 'F', to_date('11-July-1940', 'dd-mon-yyyy'), to_date('21-Mar-1985', 'dd-mon-yyyy'), 'MKT', '281-743-2341', 'A3');

insert into employee 
values ('E06', 'Serena', 'Williams', null, 10000, 'Manager', 'F', to_date('27-Mar-1962', 'dd-mon-yyyy'), to_date('11-Oct-1991', 'dd-mon-yyyy'), 'MKT', '281-334-2198', 'C1');

insert into employee 
values ('E07', 'Johnny', 'Carson', null, 9000, 'Manager', 'M', to_date('9-Dec-1936', 'dd-mon-yyyy'), to_date('27-May-1993', 'dd-mon-yyyy'), 'MKT', '281-876-2187', 'C2');

insert into employee 
values ('E08', 'Christ', 'Evert', null, 9000, 'Engineer', 'F', to_date('15-Sep-1954', 'dd-mon-yyyy'), to_date('31-Mar-1991', 'dd-mon-yyyy'), 'PRO', '281-283-4464', 'C3');

insert into employee 
values ('E09', 'Hillary', 'Clinton', 'R', 13000, 'Manager', 'F', to_date('19-Jan-1949', 'dd-mon-yyyy'), to_date('11-Oct-1986', 'dd-mon-yyyy'), 'PRO', '281-334-1298', 'A4');

insert into employee 
values ('E10', 'Jack', 'Nicholson', null, 10000, 'Managerr', 'M', to_date('10-Apr-1954', 'dd-mon-yyyy'), to_date('10-Apr-1954', 'dd-mon-yyyy'), 'PRO', '281-334-3421', 'A5');


create table departments
(dept_id 	varchar2(8) constraint departments_dept_id_pk primary key,
dept_name 	varchar2(20),
emp_num 	varchar2(7) constraint departments_emp_num_fk references employee(emp_num));
	
insert into departments values('ACC', 'Accounting', 'E06'); 
insert into departments values('COM', 'Computing', 'E07'); 
insert into departments values('MKT', 'Marketing', 'E09'); 
insert into departments values('PRO', 'Production', 'E10'); 


create table computer
(comp_id          varchar2(7)  constraint computer_comp_id_pk primary key,
comp_manuf    varchar2(15),
comp_mod       varchar2(15),
comp_proc       varchar2(10),
comp_ram        number(8),
comp_hd          number(8),
comp_cost        number(7,2) constraint computer_comp_cost_nn not null,
comp_qty          number(8));


insert into computer values ('C01', 'HP', 'HP5', '3G', 512, 120, 2000, 4);
insert into computer values ('C02', 'APPLE', 'AP12', '3.4G', 512, 60, 1800, 3); 
insert into computer values ('C03', 'IBM', 'IBM6', '3.6G', 1000, 100, 2200, 3);
insert into computer values ('C04', 'DELL', 'D7', '3.0G', 512, 150, 2000, 3);
insert into computer values ('C05', 'EMACHINE', 'EM13', '3.4G', 512, 120, 1500, 2);
insert into computer values ('C06', 'EMACHINE', 'EM14', '3.4G', 1000, 120, 2000, 2);



create table monitor
(mon_id           varchar2(7) constraint monitor_mon_id_pk primary key,
mon_manuf     varchar2(15),
mon_mod        varchar2(15),
mon_cost         number(7,2)  constraint monitor_mon_cost_nn not null,
mon_qty           number(8));


insert into monitor values ('M01', 'HP', 'HP90', 500, 4);
insert into monitor values ('M02', 'HP', 'HP70', 200, 3);
insert into monitor values ('M03', 'APPLE', 'A22', 300, 3);
insert into monitor values ('M04', 'IBM', 'IBM70', 400, 3);
insert into monitor values ('M05', 'DELL', 'DELL15', 600, 3);
insert into monitor values ('M06', 'EMACHINE', 'EM05', 600, 3);

 
 
create table pc 
(pc_num         varchar2(7) constraint pc_pc_num_pk primary key,
comp_id         varchar2(7) constraint pc_comp_id_fk references computer(comp_id),
comp_num     varchar2(8) constraint pc_comp_num_uk unique,
mon_id           varchar2(7) constraint pc_mon_id_fk references monitor(mon_id),
mon_num       varchar2(8) constraint pc_mon_num_uk unique,
emp_num       varchar2(7) constraint pc_emp_num_fk references employee(emp_num));
 
insert into pc values ('PC01', 'C01', 'C011', 'M01', 'M011', 'E01');
insert into pc values ('PC02', 'C02', 'C021', 'M02', 'M021', 'E02');
insert into pc values ('PC03', 'C03', 'C031', 'M03', 'M031', 'E03');
insert into pc values ('PC04', 'C04', 'C041', 'M04', 'M041', 'E04');
insert into pc values ('PC05', 'C04', 'C042', 'M04', 'M042', 'E05');
insert into pc values ('PC06', 'C02', 'C022', 'M02', 'M022', 'E06');
insert into pc values ('PC07', 'C03', 'C032', 'M03', 'M032', 'E07');
insert into pc values ('PC08', 'C04', 'C043', 'M02', 'M023', 'E08');
insert into pc values ('PC09', 'C02', 'C023', 'M02', 'M024', 'E09');
insert into pc values ('PC10', 'C03', 'C033', 'M03', 'M033', 'E10');
insert into pc values ('PC11', 'C04', 'C044', 'M04', 'M043', 'E03');
insert into pc values ('PC12', 'C03', 'C034', 'M04', 'M044', 'E04');
insert into pc values ('PC13', 'C02', 'C024', 'M04', 'M045', 'E05');
insert into pc values ('PC14', 'C04', 'C045', 'M04', 'M046', 'E09');

 
create table software 
(soft_id 	varchar2(7) constraint software_soft_id_pk  primary key,
soft_name 	varchar2(15),
soft_vers 	varchar2(9),
soft_type 	varchar2(15),
soft_cost 	number (6,2) constraint software_soft_cost_nn not null);

insert into software values ('S01', 'OFFICE 2016', '1.1', 'OFF', 250);
insert into software values ('S02', 'ORACLE', '19c', 'DB', 1800);
insert into software values ('S03', 'ORACLE', '12C', 'DB', 800);
insert into software values ('S04', 'DEVELOPER', '16.0', 'APPS', 1000);
insert into software values ('S05', 'SAS', '12.9', 'STAT', 4000);
insert into software values ('S06', 'PEOPLESOFT', '16.11', 'APPS', 5000);
insert into software values ('S07', 'WINDOWS 10', '2.1', 'OS', 250);
insert into software values ('S08', 'SAP', 'R 9', 'APPS', 4000);


 
 

create table inst_soft 
(soft_id         varchar2(7) 
                     constraint inst_soft_soft_id_fk references software(soft_id),
pc_num        varchar2(7) constraint inst_soft_pc_num_fk  references pc(pc_num),
inst_date      date,
emp_num     varchar2(7)  
constraint inst_soft_emp_num_fk references employee(emp_num),
constraint inst_soft_soft_id_pc_num_cpk primary key (soft_id, pc_num));

insert into inst_soft values ('S04', 'PC14', to_date('10-Feb-2024', 'dd-mon-yyyy'), 'E02');
insert into inst_soft values ('S05', 'PC14', to_date('09-Feb-2024', 'dd-mon-yyyy'), 'E01');
insert into inst_soft values ('S07', 'PC14', to_date('25-Jan-2024', 'dd-mon-yyyy'), 'E01');
insert into inst_soft values ('S08', 'PC14', to_date('23-Jan-2024', 'dd-mon-yyyy'), 'E01'); 
insert into inst_soft values ('S05', 'PC05', to_date('11-Jan-2024', 'dd-mon-yyyy'), 'E01');
insert into inst_soft values ('S07', 'PC05', to_date('07-Jan-2024', 'dd-mon-yyyy'), 'E02');
insert into inst_soft values ('S06', 'PC01', to_date('18-Dec-2023', 'dd-mon-yyyy'), 'E01');
insert into inst_soft values ('S01', 'PC01', to_date('16-Dec-2023', 'dd-mon-yyyy'), 'E01');
insert into inst_soft values ('S01', 'PC02', to_date('12-Dec-2023', 'dd-mon-yyyy'), 'E01');
insert into inst_soft values ('S01', 'PC03', to_date('23-Nov-2023', 'dd-mon-yyyy'), 'E01');
insert into inst_soft values ('S01', 'PC04', to_date('20-Nov-2023', 'dd-mon-yyyy'), 'E01');
insert into inst_soft values ('S01', 'PC05', to_date('30-Oct-2023', 'dd-mon-yyyy'), 'E02');
insert into inst_soft values ('S01', 'PC06', to_date('26-Oct-2023', 'dd-mon-yyyy'), 'E02');
insert into inst_soft values ('S01', 'PC07', to_date('28-Sep-2023', 'dd-mon-yyyy'), 'E02');
insert into inst_soft values ('S01', 'PC08', to_date('26-Sep-2023', 'dd-mon-yyyy'), 'E01');
insert into inst_soft values ('S01', 'PC09', to_date('20-Sep-2023', 'dd-mon-yyyy'), 'E01');
insert into inst_soft values ('S01', 'PC10', to_date('20-Sep-2023', 'dd-mon-yyyy'), 'E02');
insert into inst_soft values ('S01', 'PC11', to_date('19-Sep-2023', 'dd-mon-yyyy'), 'E02');
insert into inst_soft values ('S01', 'PC12', to_date('19-Sep-2023', 'dd-mon-yyyy'), 'E01');
insert into inst_soft values ('S01', 'PC13', to_date('11-Sep-2023', 'dd-mon-yyyy'), 'E02');
insert into inst_soft values ('S03', 'PC11', to_date('29-Aug-2023', 'dd-mon-yyyy'), 'E01');
insert into inst_soft values ('S03', 'PC13', to_date('24-Aug-2023', 'dd-mon-yyyy'), 'E01');
insert into inst_soft values ('S08', 'PC12', to_date('22-Aug-2023', 'dd-mon-yyyy'), 'E02');
insert into inst_soft values ('S05', 'PC11', to_date('21-Aug-2023', 'dd-mon-yyyy'), 'E02');
insert into inst_soft values ('S08', 'PC13', to_date('20-Aug-2023', 'dd-mon-yyyy'), 'E01');
insert into inst_soft values ('S03', 'PC14', to_date('19-Aug-2023', 'dd-mon-yyyy'), 'E01');


 

 
create table comp_exp
(cexp_tnum     number(9) constraint compexp_cexp_tnum_pk primary key,
cexp_date       date,
cexp_type    	varchar2(9),
cexp_amount  number(10,2),
pc_num         	varchar2(8) constraint compexp_pc_num_fk  references pc(pc_num),
emp_num        varchar2(7) constraint compexp_emp_num_fk references employee(emp_num));

insert into comp_exp values (1, to_date('10-Feb-2024', 'dd-mon-yyyy'), 'HW', 200, 'PC01', 'E02');
insert into comp_exp values (2, to_date('22-Feb-2024', 'dd-mon-yyyy'), 'MA', 400, 'PC01', 'E02');
insert into comp_exp values (3, to_date('22-Jan-2024', 'dd-mon-yyyy'), 'SW',100, 'PC11', 'E02');
insert into comp_exp values (4, to_date('11-Jan-2024', 'dd-mon-yyyy'), 'HW',150, 'PC11', 'E02');
insert into comp_exp values (5, to_date('28-Dec-2023', 'dd-mon-yyyy'), 'MA', 200, 'PC12', 'E01');
insert into comp_exp values (6, to_date('20-Dec-2023', 'dd-mon-yyyy'), 'HW', 200, 'PC05', 'E02');
insert into comp_exp values (7, to_date('12-Dec-2023', 'dd-mon-yyyy'), 'MA', 400, 'PC07', 'E02');
insert into comp_exp values (8, to_date('22-Nov-2023', 'dd-mon-yyyy'), 'SW',100, 'PC04', 'E02');
insert into comp_exp values (9, to_date('21-Oct-2023', 'dd-mon-yyyy'), 'HW',150, 'PC08', 'E02');
insert into comp_exp values (10, to_date('16-Oct-2023', 'dd-mon-yyyy'), 'MA', 200, 'PC06', 'E01');


create table ytd_comp_exp
(dept_id     	varchar2(8) constraint ytd_compexp_dept_id_pk primary key
                        constraint ytd_compexp_dept_id_fk references departments(dept_id),
dept_name      varchar2(20),
ytd_total       	number(10,2),
ytd_date         	date);
