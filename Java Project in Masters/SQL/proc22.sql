--Create a statement trigger named ”bt_major" that is attached to the major table. If a record is inserted, deleted, or updated in the table, the system will insert the username, table name, date, and the dml command executed on the table in the "log_adv_maj" table above. Test the trigger.


create or replace trigger bt_major

before insert or delete or update on major

begin
  if inserting then
    insert into log_adv_maj values(user, 'major',sysdate,'insert');
  elsif deleting then
    insert into log_adv_maj values(user, 'major',sysdate,'delete');
  elsif updating then
    insert into log_adv_maj values(user, 'major',sysdate,'update');
  end if;

end;
/