--Create a procedure named sp_gend_pay_raise that will give, a 5% or $1000, whichever is less, pay raise to employees whose gender has lower average salary than the other gender.  However, if the difference in the averages is less than $1000, then the procedure will display the message "The difference is insignificant" and make no changes.  Also, the procedure will give the raise only if the employee earns less than $14000.  The procedure will also display how many of the lower salary gender employees got the raise and how many did not.  Test this procedure.  

create view v_gend_sal as (
    select emp_gend, avg(emp_sal) as avg_sal from employee group by emp_gend order by 2 
) ;


create or replace procedure sp_gend_pay_raise as 
insignificant_avg_sal Exception;
avg_sal_m employee.emp_sal%type;
avg_sal_f employee.emp_sal%type;
cursor emp_cur(gend varchar2) is select emp_sal from employee where emp_gend = gend for update;
salary employee.emp_sal%type;
raise_sal number(6,2) ;
low_avg_gend varchar2(3);
 
begin
 	select avg_sal into avg_sal_m from v_gend_sal where emp_gend='M';
    select avg_sal into avg_sal_f from v_gend_sal where emp_gend='F';

  if abs(avg_sal_m-avg_sal_f)<1000 then
    raise insignificant_avg_sal;
  elsif avg_sal_f<avg_sal_m then
    low_avg_gend:='F';
    else
    low_avg_gend:='M';
    end if;

    open emp_cur(low_avg_gend);
    fetch emp_cur into salary;
    while emp_cur%found loop
        if salary<14000 then 
          raise_sal := salary *0.05;
          if raise_sal >1000 then
            raise_sal :=1000;
          end if;
          update employee set emp_sal=emp_sal + raise_sal  where current of emp_cur;
        end if;
       fetch emp_cur into salary;
    end loop;

exception
  when insignificant_avg_sal then
    dbms_output.put_line('The difference is insignificant');
end;
/

