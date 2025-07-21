--Create a procedure called sp_curve_t2 that will increase the gr_t2  grades of the students by 10% of the student's gr_t2 grade, or by 8 points, whichever is lower, for the students whose gr_t2 grade is lower than the average on gr_t2.  However, a student's curved grade can't be higher than 100.

create or replace procedure sp_curve_t2 as
curve grade.gr_t2%type:=8;
tenpercent number(5,2);
cursor std_cur is select gr_t2 from grade where gr_t2<(select avg(gr_t2) from grade) for update;
avg_gr number(5,2);
test2 grade.gr_t2%type;

begin
  
  open std_cur;
  fetch std_cur into test2;
  while std_cur%found loop
    tenpercent := test2*0.10;
    if tenpercent<8
    then
      curve:=tenpercent;
    end if;
    if test2+curve>100
    then
      update grade set gr_t2=100 where current of std_cur;
    else
      update grade set gr_t2=gr_t2+curve where current of std_cur;
    end if;
    fetch std_cur into test2;
  end loop;
  close std_cur;
end;