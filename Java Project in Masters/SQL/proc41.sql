--The following example illustrates application of sql cursor.  The function receives an emp_num and then shows whether that employee is a technician or a non-technician.  

create or replace function fn_employee(emp_id in varchar2)
return varchar2
as 
lv_row varchar2(30);
begin
  select distinct emp_num into lv_row  from inst_soft where emp_num = emp_id;
  if sql%found then 
    return 'tech';
  end if;

  exception
    when no_data_found then
      return 'non tech';
end; 
/


begin
  dbms_output.put_line(fn_employee('E01'));
end;