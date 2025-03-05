--Create an anonymous block that will insert into the dept_size (columns: dept_id, comments) dept_id and the text 'largest department' if it has the largest number of employees, and dept_id and the text 'smallest department' if it has the smallest number of employees. You will need to first create the dept_size with appropriate specifications before creating this anonymous block.

create table dept_size(
    dept_id varchar2(10),
    comments varchar2(150)
);

declare
dept varchar2(10);
comm varchar2(150);
begin
  select dept_id into dept from employee group by dept_id having count(1)>=all(select count(1) from employee group by dept_id);
  insert into dept_size values(dept,'largest department');
  select dept_id into dept from employee group by dept_id having count(1)<=all(select count(1) from employee group by dept_id);
  insert into dept_size values(dept,'smallest department');
end;
/

select * from dept_size;