--1.	Create a procedure named sp_gr_t1_curve that will curve the gr_t1 grades if the average of gr_t1 is less than 80. If the average is higher than 80, the system will simply display that “The gr_t1 average is already high.” The grade curve will depend upon whether the gr_t1 grade is higher or lower than the average on gr_t1. If the grade is higher than the average, the curve will be 5 points; however, if the grade is less than the average, then the curve will be 7 points. Nevertheless, the highest curved will be 100.

create or replace procedure sp_gr_t1_curve as 
avg_t1 number(4);
ex_hi_avg exception;
cursor gr_cur is select gr_t1 from grade for update;
curve number(3);
test1 number(3);
begin
  select avg(gr_t1) into avg_t1 from grade;
  if avg_t1>80 then
    raise ex_hi_avg;
  end if;
  open gr_cur;
  fetch gr_cur into test1;
  while gr_cur%found loop
    if test1>avg_t1 then 
      curve:=5;
    else
      curve:=7;
    end if;
    if test1+curve>100 then
      update grade set gr_t1 =100 where current of gr_cur;
    else
      --dbms_output.put_line(gr_t1+curve);
      update grade set gr_t1=(gr_t1+curve) where current of gr_cur;
    end if;
    fetch gr_cur into test1;
  end loop;
  close gr_cur;
  exception
    when ex_hi_avg then
      dbms_output.put_line('The gr_t1 average is already high.');
end;