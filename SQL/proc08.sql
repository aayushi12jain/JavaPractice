--1.	Create a procedure called sp_find_maj_adv that will receive the std_code of a student and display the names of the advisors for that major.  Test the procedure.

create or replace procedure sp_find_maj_adv(code in varchar2)
as
cursor cur_std is select adv_fname || ' ' || adv_lname from advisor a, maj_adv m 
where a.adv_code=m.adv_code
and m.maj_code = (select maj_code from student where std_code=code);
a_name varchar2(50);

begin 
open cur_std;
fetch cur_std into a_name;
while cur_std%found loop
  dbms_output.put_line(a_name);
  fetch cur_std into a_name;
end loop;
close cur_std;
end;
/