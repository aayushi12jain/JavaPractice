--Create a package named pkg_emp that will have two functions and one procedure.  Function pkgf_dept_hi_sal will receive the dept_id and return the highest salary of the department.  Function pkgf_gend_emps will receive a gender and return the number of employees belonging to that gender who earn less than the average salary for that gender.  The function will access the average salaries through a one-time-only procedure that will compute average salaries of the two genders.  The procedure pkgp_mon_num will return the number of monitors that have not been used at all.  Test all the package.

create or replace package pkg_emp as 
function pkgf_dept_hi_sal(dept in varchar2) return number;
function pkgf_gend_emps(gend in varchar2) return number;
procedure pkgp_mon_num(no_of_mon out number);
end pkg_emp;

create or replace package body pkg_emp as
procedure sp_one_time(gend in varchar2, avg_sal out number);
function pkgf_dept_hi_sal(dept in varchar2) return number
is
highest_sal number(5);
begin
  select max(emp_sal) into highest_sal from employee where dept_id=dept;
  return highest_sal;
end pkgf_dept_hi_sal;

function pkgf_gend_emps(gend in varchar2) return number
is 
no_of_emp number(3);
avg_sal number(5);
begin
  sp_one_time(gend,avg_sal);
  select count(1) into no_of_emp from employee where emp_gend=gend and emp_sal<avg_sal;
  return no_of_emp;
  exception
    when no_data_found then
      dbms_output.put_line('there is no such employee.');
end pkgf_gend_emps;

procedure pkgp_mon_num(no_of_mon out number)
is 

begin
    select count(1) into no_of_mon from monitor m where not exists(select 1 from pc p where p.mon_id=m.mon_id);
    exception
      when no_data_found then
        dbms_output.put_line('There is no such monitor');
end pkgp_mon_num;

 procedure sp_one_time(gend in varchar2, avg_sal out number) is
begin
  select avg(emp_sal) into avg_sal from employee where emp_gend = gend;
end; 
end;
/

