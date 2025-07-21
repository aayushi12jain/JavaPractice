--Create a procedure named sp_grade_curve that will give a 10% curve to a student's gr_hw or gr_pr grade, whichever is lower, if that grade is less than the average for that item.  Also, give a count of students whose grades were raised.  

create or replace procedure sp_grade_curve as 

curve number(3);
cursor std_cur is select gr_hw,gr_pr from grade for update;
avg_gr_hw number(5,2);
avg_gr_pr number(5,2);
test_hw grade.gr_hw%type;
test_pr grade.gr_pr%type;

begin
  select avg(gr_hw) into avg_gr_hw from grade;
  select avg(gr_pr) into avg_gr_pr from grade;
  open std_cur;
  fetch std_cur into test_hw,test_pr;
  while std_cur%found loop
    if test_hw<test_pr and test_hw<avg_gr_hw
    then
        curve:=test_hw*1.10;
        if curve>100
        then
            update grade set gr_hw=100 where current of std_cur;
        else
            update grade set gr_hw=curve where current of std_cur;
        end if;
    elsif test_pr<avg_gr_pr
    then
        curve:=test_pr*1.10;
        if curve>100
        then
            update grade set gr_pr=100 where current of std_cur;
        else
            update grade set gr_pr=curve where current of std_cur;
        end if;
    end if;
    fetch std_cur into test_hw,test_pr;
  end loop;
  close std_cur;
end;