--Create an anonymous block that will use a cursor with a parameter.  The program will use a variable, assigned a maj_code in SQLPlus, and display the number of advisors advising for that major and also display the names of the advisors.  Test the block.

declare
cursor maj_cur(major varchar2) is select adv_fname, adv_lname from advisor a , maj_adv m 
where a.adv_code = m.adv_code and m.maj_code=major;
lv_row maj_cur%rowtype;
adv_count number(3):=0;

begin
  open maj_cur('ISAM');
  fetch maj_cur into lv_row;
  while maj_cur%found loop
    dbms_output.put_line(lv_row.adv_fname || ' ' || lv_row.adv_lname);
    adv_count:= adv_count +1;
    fetch maj_cur into lv_row;
  end loop;
  dbms_output.put_line(adv_count);
  close maj_cur;
end;
