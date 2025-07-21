--1.	Create a function named sf_gr_t2_hs_std "that will return the name of the student who scored the highest on gr_t2.  Concatenate the first and last name of the student before returning it for output.  Assume there is only one such student.  Test the function.

create or replace procedure sf_gr_t2_hs_std as
fname student.std_fname%type;
lname student.std_lname%type;
begin
  select s.std_fname , s.std_lname into fname,lname
  from student s, grade g
  where s.std_code=g.std_code
  and g.gr_t2 >= all(select gr_t2 from grade);

  dbms_output.put_line(fname || '-' || lname) ;
end;
/