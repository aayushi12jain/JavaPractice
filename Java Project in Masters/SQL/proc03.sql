--3.	Create an anonymous block that will display the names of female students.

declare 
name varchar2(50);
cursor std_cur is select std_fname || ' ' || std_lname from student where std_gend='F';
begin
  open std_cur;
  fetch std_cur into name;
  while std_cur%found loop
    dbms_output.put_line(name);
    fetch std_cur into name;
  end loop;
  close std_cur;
end;
/