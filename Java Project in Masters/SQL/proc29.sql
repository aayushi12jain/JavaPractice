--The following example defines a cursor that can be opened to fetch records from the table specified by the user.  Depending upon the specified table (computer or monitor), the procedure will check if that table has any monitor batch (in case the user specified the monitor table) or any computer batch (in case the user specified the computer table) that has not been used in any workstation.  If it finds any such batch, it deletes it from the monitor or computer table. 

create or replace procedure sp_refc_batch(tableName in varchar2)
is 
type refc is ref cursor;
cur_var refc;
lv_mon_id monitor.mon_id%type;
lv_comp_id computer.comp_id.type;
e_wrong_table exception;

begin
  if lower(tableName)='monitor' then
    open cur_var for select mon_id from monitor where mon_id not in (select distinct(mon_id) from pc);
    fetch cur_var into lv_mon_id;
    while cur_var%found loop
      delete from monitor where mon_id=lv_mon_id;
      fetch cur_var into lv_mon_id;
    end loop;
    close cur_var;
  elsif lower(tableName)='computer'
    open cur_var for select comp_id from computer where comp_id not in (select distinct(comp_id) from pc);
    fetch cur_var into lv_comp_id;
    while cur_var%found loop
      delete from computer where comp_id=lv_comp_id;
      fetch cur_var into lv_comp_id;
    end loop;
    close cur_var;
  else
    raise e_wrong_table;
  end if;

exception
  when e_wrong_table then
    dbms_output.put_line('Wrong table name');
end;