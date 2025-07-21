--Create an anonymous block that includes a nested block.  The block will declare a global cursor with a parameter. The outer block will open the cursor with a dept_id and first display the dept_id and then display the names of the employees in that department.  The inner block will open the same cursor with a different dept_id, first display the dept_id and then display the employees in that department.  Test the program, by first declaring two variables and assigning different dept_ids to them. 

declare 
cursor emp_cur(dept varchar2) is select emp_fname || ' ' || emp_lname from employee where dept_id=dept;
emp_name varchar2(50);

begin
  open emp_cur('PRO');
  fetch emp_cur into emp_name;
  while emp_cur%found loop
    dbms_output.put_line('department : ' || 'PRO');
    dbms_output.put_line(emp_name);
    fetch emp_cur into emp_name;
  end loop;
  close emp_cur;
  begin
    open emp_cur('MKT');
  fetch emp_cur into emp_name;
  while emp_cur%found loop
    dbms_output.put_line('department : ' || 'MKT');
    dbms_output.put_line(emp_name);
    fetch emp_cur into emp_name;
  end loop;
  close emp_cur;
  end;
end;
/
