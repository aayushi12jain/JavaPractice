--Create a procedure named sp_above_avg_stds_count that will display the count of students whose gr_t1 score is higher than the average on gr_t1.  Test the procedure.

create or replace procedure sp_above_avg_stds_count 
as
count_std number(3);
begin
  select count(0) into count_std from grade where gr_t1 >=all (select avg(gr_t1) from grade);
  dbms_output.put_line(count_std);
end;
/
