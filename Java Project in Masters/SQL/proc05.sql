--Create a function named sf_gr_avg that will display the count of students whose gr_t1 grade is higher than the average on gr_t1.  Test the function.

create or replace function sf_gr_avg 
return number
as
count_std number(3);
begin
  select count(0) into count_std from grade where gr_t1 >=all (select avg(gr_t1) from grade);
  return count_std;
end;
/

-- execution in sql lite
declare
    v05 number(3);
begin
    v05 := sf_gr_avg();
    dbms_output.put_line(v05);
end;
/