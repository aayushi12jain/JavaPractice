--Create a row trigger named “bt_advisor” that will be linked to the advisor table. If a record is inserted, deleted or updated in the adviser table, the system will insert the user name, table_name, date, and the dml command executed in the "log_adv_maj" table. To insert this information, create this table with appropriate definition first before creating the trigger. Test the trigger.

create table log_adv_maj (
    username varchar2(50),
    tableName varchar2(50),
    changeDate date,
    command varchar2(30)
);

create or replace trigger bt_advisor
before insert or delete or update on advisor
for each row
begin
  if inserting then
    insert into log_adv_maj values(user, 'advisor',sysdate,'insert');
  elsif deleting then
    insert into log_adv_maj values(user, 'advisor',sysdate,'delete');
  elsif updating then
    insert into log_adv_maj values(user, 'advisor',sysdate,'update');
  end if;

end;
/