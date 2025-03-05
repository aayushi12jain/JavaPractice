--Create a row trigger named bt_emp_sal_upd1 that will execute when an employee salary is updated. However, the trigger should be executed only if the employee salary is increased by more than $1000. The trigger will display a message that “The raise is too high.” and it will disallow the change. Test the trigger

create or replace trigger bt_emp_sal_upd1
before update of emp_sal on employee
for each row 
when (new.emp_sal>old.emp_sal+1000) 
begin
   raise_application_error(-20011,'The increase is too high');
end;  
/