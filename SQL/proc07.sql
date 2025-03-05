--7.	Create a procedure named sp_above_avg_stds that will display the first name, last name, and gr_t1 grade of a student if the student's gr_t1 grade is higher than the average of gr_t1.  Test the procedure.   

create or replace procedure sp_above_avg_stds as

cursor std_cur is select std_fname, std_lname,gr_t1 from grade where gr_t1>(select avg(gr_t1) from grade);
lv_row std_cur%rowtype;
begin

  open std_cur;
  fetch std_cur into lv_row;
  while std_cur%found loop
    dbms_output.put_line(lv_row.std_fname || ' '|| lv_row.std_lname || ' ' || lv_row.gr_t1);
    fetch std_cur into lv_row;
  end loop;
  close std_cur;
end;
/