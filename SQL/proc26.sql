--Create a trigger named bt_std_maj_update that will be linked to the student table.  The trigger will only be executed if a student’s maj_code is updated.  The trigger will allow the change only if the student currently does not have any major listed, i.e., the maj_code is null.  Test the trigger.

create or replace trigger bt_std_maj_update
before update of maj_code on student 
for each row
begin
  if :old.maj_code is not null then 
    raise_application_error(-20011,'student already enrolled');
  end if;
end;
/