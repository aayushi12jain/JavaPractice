--Create a procedure named sp_pay_raise that will give a pay raise to employees if the average employee salary is less than $12000; otherwise, the system will display the message that “The average salary is already too high.” Only employees earning less than $12000 will be eligible for the pay raise. The pay raise will be based on the current salary. For an employee earning more than $10000, the pay raise is 3 percent of the current salary, but for employees earning less than $10000, the raise is 5% of the current salary. Test this procedure.

create or replace procedure sp_pay_raise as
avg_sal employee.emp_sal%type;
ex_hi_avg exception;
cursor emp_cur is select emp_sal from employee for update;
salary employee.emp_sal%type;
pay_raise employee.emp_sal%type;
begin
  select avg(emp_sal) into avg_sal from employee;
  dbms_output.put_line('Average :' || avg_sal);
  if avg_sal>12000 then
    raise ex_hi_avg;
  end if;
  open emp_cur;
  fetch emp_cur into salary;
  while emp_cur%found loop
    if salary<12000 then
      if salary>10000 then
        pay_raise:=salary*1.05;
      else 
        pay_raise:=salary*1.03;
      end if;
      update employee
         set emp_sal=pay_raise
       where current of emp_cur;
    end if;
    fetch emp_cur into salary;
  end loop;
  close emp_cur;
  exception
    when ex_hi_avg then
      dbms_output.put_line('The average salary is already too high.');
end;