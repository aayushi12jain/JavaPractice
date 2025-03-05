--Create a trigger called "at_std_act” that will be attached to the std_act table. If a student enrolls in a new activity, the trigger will check if the student’s overall average grade is higher than 70.  If not, the system will not  let the student enroll in the additional activity.  Test the trigger.

create or replace trigger at_std_act
before insert on std_act
for each row
declare
avg_grade grade.gr_t1%type;

begin
 select (gr_t1+gr_t2+gr_hw+gr_pr)/4 into avg_grade from grade where std_code =:new.std_code;
 if avg_grade<70 then
    raise_application_error(-20089,'Low grades');
end if;
end;
/