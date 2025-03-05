--block inserts various student first name into a table of varchar2 by using a constructor and then retrieves these majors one by one. 


declare
type tab is table of varchar2(30) index by binary_integer;
std_names tab;
cursor std_cur is select std_fname from student;
std_name varchar2(30);
I number:=1;
begin
    open std_cur;
    fetch std_cur into std_name;
    while std_cur%found loop
      std_names(I):=std_name;
      I:=I+1;
      fetch std_cur into std_name;
    end loop;

for i in 1..std_names.count loop
    dbms_output.put_line(std_names(i));
end loop;
end;


--another block inserts various data into a table of varchar2 without a constructor and then retrieves these majors one by one. 

declare
type tab is table of varchar2(30) index by binary_integer;
vtab tab;
begin
  vtab(1):='Aayushi';
  vtab(2):='Rishabh';
  vtab(3):='Abhishek';
  vtab(4):='Arpit';
  vtab(5):='Rekha';

  dbms_output.put_line(vtab.count);
  dbms_output.put_line(vtab(3));

  vtab.delete(3);
   dbms_output.put_line(vtab(4));

for i in 1..vtab.count loop
    dbms_output.put_line(vtab(i));
end loop;
end;

----block inserts various major into a table of varchar2 by using a constructor and then retrieves these majors one by one. 

declare
type tab is table of varchar2(30) index by binary_integer;
maj_tab tab;
cursor m_cur is select maj_desc from major;
I number :=1;
descript varchar2(30);
begin
  open m_cur;
  fetch m_cur into descript;
  while m_cur%found loop
    maj_tab(I):=descript;
    I:=I+1;
    fetch m_cur into descript;
  end loop;
  close m_cur;

  for j in 1..maj_tab.count loop
    dbms_output.put_line(maj_tab(j));
  end loop;
end;
/