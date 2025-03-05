--2.	Create an anonymous block that will display the count of the ACCT students and the count of the FINC students separately.

declare 
acc_count number(3);
fin_count number(3);

begin
  select count(1) into acc_count from student where maj_code='ACCT';
  select count(1) into fin_count from student where maj_code='FINC';

  dbms_output.put_line('account count : ' || acc_count);
  dbms_output.put_line('finance count : ' || fin_count);
end;
/