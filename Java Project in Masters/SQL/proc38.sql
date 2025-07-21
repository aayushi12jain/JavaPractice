--object type and methods

create or replace type grade_ot as object(
    test1 number(4),
    test2 number(4),
    homework number(4),
    project number(4)
);
/

create table student_1 (
    std_code varchar2(30) constraint std_pk primary key,
    std_fname varchar2(30),
    std_lname varchar2(30),
    grades grade_ot)
    ;

insert into student_1 values('S11','Aaysuhi','Jain',grades(78,67,80,98));

alter type grade_ot
add member function func_name return number cascade;

create or replace type grade_ot as
member function func_name return number 
is 
avg_t1 number(5,2);
begin
  select avg(s.grades.test1) into avg_t1 from student_1 s;
  return avg_t1;

end func_name;
end;
/

select distinct(s.grades.func_name()) avg_test1 from student_1 s ;

--function will return the lowest value from four values.
alter type grade_ot
add member function least_val_func 
(test1 IN number, test2 IN number, homework IN number, project IN number) 
return number cascade;

--write method

create or replace type grade_ot as

create or replace type grade_ot as
member function func_name return number 
is 
avg_t1 number(5,2);
begin
  select avg(s.grades.test1) into avg_t1 from student_1 s;
  return avg_t1;

end func_name;

member function least_val_func 
(test1 IN number, test2 IN number, homework IN number, project IN number) 
return number 
is 
lowest number(4);
begin
  lowest:= least(test1,test2,homework,project);
  return lowest;
end least_val_func;
end;
/

