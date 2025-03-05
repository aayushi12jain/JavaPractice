-- pragma exception

create or replace procedure sp_pragma(var1 varchar2, var2 varchar2) is
exception_not_null exception;
exception_duplicate exception;
pragma exception_init(exception_not_null,-1400);
pragma exception_init(exception_duplicate,-1110);
begin
  insert into test1 value(var1,var2);
  exception
    when exception_not_null then
      dbms_output.put_line('Both Id and name are null and need a non-null value.') ;
    when exception_duplicate then
      dbms_output.put_line('duplicate value not allowed.') ;
    when no_data_found then
      dbms_output.put_line('no data found ex');
end;