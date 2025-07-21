--triggers 

--1.If a record is deleted from the grade table, the following trigger will pick up specific data from a deleted record and place it in the del_recs table.  

create or replace trigger bt_del_gr is 
before delete on grade
for each row
begin
  insert into del_records values(select * from grade where std_code=:old.std_code);
end;

--2.view called view1 which has some values from the student table and some from the grade table.

create view v_std_grd as (select s.std_code, s.std_fname, s.std_lname, s.maj_code, g.gr_t1, g.gr_t2 from student s, grade g where s.std_code =g.std_code);

create or replace trigger tg_std_grd 
instead of insert on v_std_grd
for each row 
begin
  --insert into student..
  --insert into grade..
end;
/

--In the following trigger, we give a curve of 5% of the current gr_t2 grade.  However, if after the curve, the average of gr_t2 is higher than 85, then we want to cancel the update.  We will cancel the update by raising an exception in the trigger, but not handling it.


create or replace trigger at_fail_upd 
after update of gr_t2 on grade

declare
t2_avg number(4);
updt_ex exception;
begin
  select avg(gr_t2) into t2_avg from grade;
  if t2_avg>85 then
    raise updt_ex;
  end if;
end;
/