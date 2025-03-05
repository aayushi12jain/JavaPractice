--pkgf_hi_avg_num returns the number of students whose gr_t1 grade is higher than the average of gr_t1. 
--pkgf_hi_avg_num (var1 in varchar2) receives a maj_code, and returns the number of students with that major whose gr_t1 is higher than the average on gr_t1.  
--In the body of the package, we have a private function named pkgf_avg, that returns the average on gr_t1.  This function is listed at the end of the package body, even though it is called by both pkgf_hi_avg_num and pkgf_hi_avg_num (var1 in varchar2).  This is made possible by forward declaration: The header of the function pkgf_avg by itself is listed before the other two functions in the body of the package. Let us create the package specifications.

create or replace package pkg_test_avg is 
function pkgf_hi_avg_num return number;
function pkgf_hi_avg_num(var1 in varchar2) return number;
end pkg_test_avg;
/

create or replace package body pkg_test_avg is 

function pkgf_hi_avg_num return number
is 
cnt_std number(3);
avg_t1 number(5,2);
begin
    avg_t1:=pkgf_avg();
  select count(1) into cnt_std from grade where gr_t1<avg_t1;
  return cnt_std;
end pkgf_hi_avg_num;

function pkgf_hi_avg_num(var1 in varchar2) return number
is 
cnt_std number(3);
avg_t1 number(5,2);
begin
  avg_t1:=pkgf_avg();
  select count(1) into cnt_std from student s, grade g where s.std_code=g.std_code and  gr_t1<avg_t1 and maj_code=var1;
  return cnt_std;

end pkgf_hi_avg_num;


function pkgf_avg return number
is
avg_t1 number(5,2);
begin
  select avg(gr_t1) into avg_t1 from grade;
  return avg_t1;
end pkgf_avg;

end pkg_test_avg;
/