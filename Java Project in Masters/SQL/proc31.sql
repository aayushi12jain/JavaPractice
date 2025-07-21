--Create a procedure called sp_major that will declare an appropriate record and table type.  The table should be able to accommodate different majors and number of students in those majors.  The procedure will retrieve the majors and number of students from the students table and populate this table.  After populate the table, the procedure will print all records.  

create or replace procedure sp_major as 
type maj_rec_type is record(major_cd major.maj_code%type, count_std number(3));
type maj_tab_type is table of maj_rec_type index by binary_integer;
maj_table maj_tab_type;
cursor std_cur is select maj_code , count(1) as cnt from student group by maj_code;
I number :=1;

begin
  open std_cur;
  loop
    fetch std_cur into maj_table(I).major_cd,maj_table(I).count_std;
    I:=I+1;
    exit when std_cur%notfound;
  end loop;
  close std_cur;

  for i in 1..maj_table.count loop
    dbms_output.put_line(maj_table(i).major_cd || ' ' || maj_table(i).count_std);
  end loop;

end;
/