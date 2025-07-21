--Create a function named sf_pc_cost that will allow a user to display the total cost of a pc (pc_cost) in a select statement. For this question, you will need to join the pc, computer, and monitor tables to get the cost of a pc. So, your cursor will be based on three tables and your row variable will need to be based on the cursor. Test this function by displaying pc_num and pc_cost for all pcs.


    
create or replace function sf_pc_cost return number is
cursor pc_cur is select m.mon_cost, c.comp_cost, p.pc_num from pc p, computer c, monitor m where p.comp_id=c.comp_id and p.mon_id=m.mon_id;
lv_row pc_cur%rowtype; 
cost number(7,2);
total_cost number(7,2):=0;
begin
  open pc_cur;
  fetch pc_cur into lv_row;
  while pc_cur%found loop
    cost:=lv_row.mon_cost+lv_row.comp_cost;
    dbms_output.put_line(lv_row.pc_num || '-' || cost);
    total_cost:= total_cost+cost;
    fetch pc_cur into lv_row;
  end loop;
  close pc_cur;
  return total_cost;
end;
/

--
begin
    dbms_output.put_line(sf_pc_cost);
end;
/