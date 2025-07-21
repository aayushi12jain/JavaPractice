--Create a procedure called sp_raise_emp_sal that will raise the employee salary by 5% of the current salary or $100 whichever is less, but for only those employees who have been employed for at least five years and their salary is less than the average emp_sal for their department.
 

create view v_dept_sal as (select dept_id, avg(emp_sal) as avg_sal from employee group by dept_id);

create or replace procedure sp_raise_emp_sal as

cursor emp_cur is select e.emp_sal from employee e 
        where e.emp_sal<(select v.avg_sal from v_dept_sal v where v.dept_id=e.dept_id)
        and e.emp_doe<=ADD_MONTHS(SYSDATE, -60)
        for update ;
salary employee.emp_sal%type;
raise_sal number(6,2);

begin
  open emp_cur;
  fetch emp_cur into salary;
  while emp_cur%found loop
    raise_sal:=salary*0.05;
    if raise_sal>100 then
      raise_sal:=100;
    end if;
    update employee set emp_sal=emp_sal+raise_sal where current of emp_cur;
    fetch emp_cur into salary;
  end loop;
  close emp_cur;
end;
/