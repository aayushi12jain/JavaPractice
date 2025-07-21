--Create an anonymous block that will display the number of ACCT students and display the names of these students also.

declare 
name varchar2(50);
count_acc number(3);
cursor std_cur is select std_fname || ' ' || std_lname from student where maj_code='ACCT';
begin
select count(1) into count_acc from student where maj_code='ACCT';
  open std_cur;
  fetch std_cur into name;
  while std_cur%found loop
    dbms_output.put_line(name);
    fetch std_cur into name;
  end loop;
  close std_cur;
  dbms_output.put_line('count : ' || count_acc);
end;
/