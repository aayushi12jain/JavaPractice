--In the following anonymous block, the outer loop cursor (cur_maj) retrieves majors from the major table and the inner loop cursor (cur_stds) accesses students from the student table.  

declare
cursor std_cur(major varchar2) is select std_code,std_fname, std_lname from student where maj_code = major;
lv_row std_cur%rowtype;
cursor maj_cur is select maj_code from major;
p_maj varchar2(30);
begin
  open maj_cur;
  fetch maj_cur into p_maj;
  while maj_cur%found loop
    dbms_output.put_line('Major: ' || p_maj);
    open std_cur(p_maj);
    fetch std_cur into lv_row;
    while std_cur%found loop
        dbms_output.put_line(lv_row.std_code || ' ' || lv_row.std_fname || ' ' || lv_row.std_lname);
        fetch std_cur into lv_row;
    end loop;
    close std_cur;
    fetch maj_cur into p_maj;
  end loop;
end;