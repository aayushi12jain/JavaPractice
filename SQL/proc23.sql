--Create a table called "unassigned_pcs" that will have all the columns of the pc table. 
--Then, create a trigger for the employee table. If an employee leaves, the trigger picks up the information on the computers that were assigned to this employee, inserts that information into the “unassigned_pcs” table and then deletes those computers from the pc table. Test this trigger by temporarily adding an employee, assigning a pc to the employee, and then deleting the employee.


create table unassigned_pcs as select * from pc where 1=3;

create or replace trigger bt_emp 
before delete on employee
for each row
begin 
    
    insert into unassigned_pcs value(select * from pc where emp_num=:old.emp_num);
    delete from pc where emp_num=:old.emp_num;

end;
/

--testing 

insert into employee 
values ('E11', 'Aaysuhi', 'Jain', null, 8000, 'IT Engineer', 'M', to_date('10-Feb-1964', 'dd-mon-yyyy'), to_date('12-Sep-1982', 'dd-mon-yyyy'),'COM', '281-283-3498', 'B1');


 insert into pc values ('PC15', 'C04', 'C046', 'M04', 'M047', 'E11');

delete from employee where emp_num='E11';
select * from unassigned_pcs;