--Create a procedure named sp_hi_maj_stds that will display the name, maj_code, and gr_t1 grade of the student whose major has the highest average on gr_t1. The procedure will also display the number of students displayed.  For this procedure, first create a view that will display the maj_code of the major that has the highest average on gr_t1 and then use this view in declaring the cursor to retrieve the students who belong to this major.

create view vtest1 as (select maj_code from(
    select maj_code from student s,grade g 
    where s.std_code=g.std_code 
    group by maj_code 
    order by avg(gr_t1) desc)
where rownum=1);


create or replace procedure sp_hi_maj_stds as 

std_cnt number(3);
cursor std_cur is select s.std_fname, s.std_lname, maj_code, gr_t1 from student s, grade g
  where s.std_code=g.std_code 
  and maj_code in (select maj_code from vtest1);
lv_row std_cur%rowtype;

begin
  open std_cur;
  std_cnt := 0;
  loop
    fetch std_cur into lv_row;
    exit when std_cur%notfound;
    std_cnt := std_cnt + 1;
    dbms_output.put_line('Name: ' || lv_row.std_fname || ' ' || lv_row.std_lname);
    dbms_output.put_line('Major: ' || lv_row.maj_code);
    dbms_output.put_line('Test1 Grade: ' || lv_row.gr_t1);
  end loop;
  dbms_output.put_line('Count of students: ' || std_cnt);
  close std_cur;
end;