--Create a procedure sp_raise_sal_emp that will give a pay raise of 10% of emp_sal or $1000, whichever is smaller, to employees belonging to the department that has the largest number of female employees or has the lowest average salary.   However, a qualifying employee will get only one pay raise.  The procedure will also display the (1) Both: Number of employees who qualified under both conditions, (2) Female Employees: Number of employees who qualified under the largest number of female employees' condition only, and (3) Lowest Average Salary: Number of employees who qualified for belonging to the department with the lowest average salary only.

create view v_fem_emp_dep as (select dept_id from (select dept_id,count(1) from employee where emp_gend='F' group by dept_id order by 2 desc) where rownum=1);

create view v_low_avg_sal as (select dept_id from (select dept_id from employee group by dept_id order by avg(emp_sal) desc) where rownum=1);

create or replace procedure sp_raise_sal_emp as

cursor emp_cur is select emp_sal, emp_gend, dept_id from employee where dept_id=(select dept_id from v_fem_emp_dep) or dept_id=(select dept_id from v_low_avg_sal)for update ;
salary employee.emp_sal%type;
gender employee.emp_gend%type;
dept_cd employee.dept_id%type;
count1 number(2):=0;
count2 number(2):=0;
count3 number(2):=0;
raise_sal number(6,2);

begin
  open emp_cur;
  
  fetch emp_cur into salary,gender,dept_cd;
  while emp_cur%found loop
    raise_sal:=salary*0.10;
    if raise_sal >1000 then
      raise_sal:=1000;
    end if;
    update employee set emp_sal=emp_sal+raise_sal where current of emp_cur;
    fetch emp_cur into salary,gender,dept_cd;
  end loop;
  dbms_output.put_line('Count of Both:' || emp_cur%rowcount);
  close emp_cur;
  select count(1) into count2 from employee where dept_id = (select dept_id from v_fem_emp_dep);
  select count(1) into count3 from employee where dept_id = (select dept_id from v_low_avg_sal);
  dbms_output.put_line('Count of high female dept:' || count2);
  dbms_output.put_line('Count of low avg sal dept:' || count3);
end;
/