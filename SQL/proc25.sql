--Create a trigger named bf_grade_update that will be attached to the grade table. The trigger will execute only if the gr_hw or gr_pr columns are updated and the update grade will be less than 70.  If so, the trigger will change the grade to 70 and do the update.  Test the trigger.

create or replace trigger bf_grade_update 
before update of gr_hw,gr_pr on grade
for each row

begin
if :new.gr_hw<70 then 
  :new.gr_hw:=70;
end if;
if :new.gr_pr<70 then 
  :new.gr_pr:=70;
end if;
end;

--testing 
update grade 
set gr_hw=67,gr_pr=45
where std_code in ('S01','S08','S04');

select * from grade;