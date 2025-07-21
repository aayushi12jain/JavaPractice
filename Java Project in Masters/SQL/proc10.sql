--Create a function called sf_max_t1_std that will receive the std_code of a student and will return the name of the student whose gr_t1 grade is the highest for the major of the student whose code was provided to the function.  

create or replace function sf_max_t1_std(code in student.std_code%type)
return varchar2
as
sname varchar2(50);
highest_gr number(4);
major student.maj_code%type;
begin 
    select maj_code into major from student where std_code=code;
    select gr_t1 into highest_gr from (
        select distinct(gr_t1) from grade g1, student s1 
        where g1.std_code = s1.std_code and maj_code=major  
        order by gr_t1 desc) where rownum=1;

    select s.std_fname || ' ' || s.std_lname into sname
    from student s, grade g
    where s.std_code = g.std_code
    and maj_code = major
    and gr_t1=highest_gr;
    return sname;
end;
/

--execute
begin
    dbms_output.put_line(sf_max_t1_std('S04'));
end;
/