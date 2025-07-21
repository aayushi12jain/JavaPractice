--The following package has two public functions (pkgf_above_avg and pkgf_compute_avg ) and two public procedures (pkgp_assign_lg and pkgp_grade_update)

--The function pkgf_above_avg determines the number of students whose average grade (gr_t1+gr_t2+gr_hw+gr_pr)/4 is higher than the average of average grades of the students.

--The function pkgf_compute_avg receives four input values and returns a weighted average based on those numbers.  

--The procedure pkgp_assign_lg receives a number and returns the letter grade that will be assigned based on that number.  

--The procedure pkgp_grade_update accesses the records from the grade table, computes the weighted average of each record, determines the letter grade based on that weighted average and then updates the row for that record.


create or replace package pkg_fin_grade is
function pkgf_above_avg
    return number;
function pkgf_compute_avg(inp1 in number, inp2 in number, inp3 in number, inp4 in number)
    return number;
procedure pkgp_assign_lg(inp1 in number, out1 out varchar2);
procedure pkgp_grade_update;
end pkg_fin_grade;
/


create or replace package body pkg_fin_grade is 

function pkgf_above_avg
    return number
    is 
    avg_gr number(5,2);
    cnt_std number(3);
    begin
      select avg((gr_t1 + gr_t2 + gr_hw + gr_pr)/4) into avg_gr from grade;
      select count(1) into cnt_std from grade where (gr_t1 + gr_t2 + gr_hw + gr_pr)/4 >avg_gr;
      return cnt_std;
    end pkgf_above_avg;


function pkgf_compute_avg(inp1 in number, inp2 in number, inp3 in number, inp4 in number)
    return number
    is
    avg_gr number(5,2);
    begin
      avg_gr := (inp1 + inp2 + inp3 + inp4)/4;
      return avg_gr;
    end pkgf_compute_avg;

procedure pkgp_assign_lg(inp1 in number, out1 out varchar2)
is
begin
  if inp1 is null then
    out1:=null;
  elsif inp1>=90 then
    out1:='A';
  elsif inp1>=80 then
    out1:='B';
  elsif inp1>=70 then
    out1:='C';  
  elsif inp1>=50 then
    out1:='D';
  else
    out1:='F';
  end if;
end pkgp_assign_lg;

procedure pkgp_grade_update
is 
cursor gr_cur is select gr_t1, gr_t2, gr_hw, gr_pr from grade for update;
t1 grade.gr_t1%type;
t2 grade.gr_t2%type;
hw grade.gr_hw%type;
pr grade.gr_pr%type;
avg_gr number(5,2);
letter_gr varchar2(10);
begin
    open gr_cur;
    fetch gr_cur into t1, t2,hw, pr;
    while gr_cur%found loop
        avg_gr:=pkgf_compute_avg(t1,t2,hw,pr);
        dbms_output.put_line('Average : ' || avg_gr);
        pkgp_assign_lg(avg_gr, letter_gr);
        dbms_output.put_line('letter grade : ' || letter_gr);

        update grade
        set gr_lg = letter_gr, gr_avg=avg_gr
        where current of gr_cur;

    fetch gr_cur into t1, t2,hw, pr;
    end loop;
    close gr_cur;

end pkgp_grade_update;
end pkg_fin_grade;
/