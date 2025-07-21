--Create a row trigger named bt_emp_sal_upd2 that will execute when an employee salary is updated. However, the trigger should execute only if the employee salary is increased by more than $1000. The trigger will reduce the pay raise to $500 and allow the change. Test the trigger.


create or replace trigger bt_emp_sal_upd2 
before update of emp_sal on employee
for each row
when (new.emp_sal > (old.emp_sal+1000))
begin
  :new.emp_sal := (:old.emp_sal +500);
end;
/