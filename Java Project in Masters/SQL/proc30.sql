--Create a procedure sp_recs_emp that will have a record type based on emp_num, emp_fname, emp_lname and emp_sal.  Then, create a table type based on this record type.  The procedure should access relevant employee data from the employee table and store it in a table of the above table type and later display all the records.  Test the procedure.

create or replace procedure sp_recs_emp
is 
type emp_rec_type is record(emp_num employee.emp_num%type,
                            emp_fname employee.emp_fname%type,
                            emp_lname employee.emp_lname%type,
                            emp_sal employee.emp_sal%type);
type emp_tab_type is table of emp_rec_type index by binary_integer;
emp_table emp_tab_type;
i number(3):=1;
cursor emp_cur is select emp_num, emp_fname, emp_lname, emp_sal from employee;

begin
    open emp_cur;
    loop
      fetch emp_cur into emp_table(i).emp_num, emp_table(i).emp_fname,emp_table(i).emp_lname, emp_table(i).emp_sal;
      i:=i+1;
      exit when emp_cur%notfound;
    end loop;
    close emp_cur;

    for i in 1..emp_table.count loop
      dbms_output.put_line(emp_table(i).emp_num);
      dbms_output.put_line(emp_table(i).emp_fname);
      dbms_output.put_line(emp_table(i).emp_lname);
      dbms_output.put_line(emp_table(i).emp_sal);
      dbms_output.put_line('......................');
    end loop;
end;