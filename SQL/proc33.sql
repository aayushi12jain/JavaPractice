--Create a procedure sp_tab_emp that will declare an indexed table of varchar2(50).  The procedure will access the emp_num, emp_fname, emp_lname, and emp_sal, and store it in this table.  Then, the procedure will display all the records stored in this table.  Test this procedure.  

create or replace procedure sp_tab_emp as 

type tab is table of varchar2(50) index by binary_integer;
emp_tab tab;
cursor emp_cur is select emp_num, emp_fname, emp_lname, emp_sal from employee;
I number:=1;
lv_row emp_cur%rowtype;

begin
  open emp_cur;
  fetch emp_cur into lv_row;
  while emp_cur%found loop
    emp_tab(I):=(lv_row.emp_num || ' ' ||lv_row.emp_fname || ' ' || lv_row.emp_lname || ' ' || lv_row.emp_sal );
    I:=I+1;
    fetch emp_cur into lv_row;
  end loop;
  close emp_cur;

  for j in 1..emp_tab.count loop
    dbms_output.put_line(emp_tab(j));
  end loop;
end;
/