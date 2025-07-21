--block employs a cursor to populate a varray and then retrieves the elements of the varray to display them. 

declare
type stdArray is varray(10) of varchar2(30);
std_names stdArray:=stdArray();
cursor std_cur is select std_fname from student;
std_name varchar2(30);
I number:=1;
begin
    open std_cur;
    fetch std_cur into std_name;
    while std_cur%found loop
      std_names.extend();
      std_names(I):=std_name;
      I:=I+1;
      fetch std_cur into std_name;
    end loop;

for i in 1..std_names.count loop
    dbms_output.put_line(std_names(i));
end loop;
end;
/

--Create a procedure sp_varr_emp that will declare a varray (20) of varchar2(50).  The procedure will access the emp_num, emp_fname, emp_lname, and emp_sal, and store it in this varray by extending it.  Then, the procedure will display all the records stored in this varray.  Test this procedure.  

create or replace procedure sp_varr_emp as 
type empArray is varray(20) of varchar2(50);
emp_arr empArray:=empArray();
cursor emp_cur is select emp_num, emp_fname, emp_lname, emp_sal from employee;
I number:=1;
lv_row emp_cur%rowtype;

begin
  open emp_cur;
  fetch emp_cur into lv_row;
  while emp_cur%found loop
    emp_arr.extend();
    emp_arr(I):=(lv_row.emp_num || ' ' ||lv_row.emp_fname || ' ' || lv_row.emp_lname || ' ' || lv_row.emp_sal );
    I:=I+1;
    fetch emp_cur into lv_row;
  end loop;
  close emp_cur;

  for j in 1..emp_arr.count loop
    dbms_output.put_line(emp_arr(j));
  end loop;
end;
/