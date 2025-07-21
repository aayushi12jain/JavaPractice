--Create a function named sf_soft_install that will receive the soft_id of a software and then return whether the software is "Installed" (installed on at least one machine) or "Uninstalled" (not installed on any machine). 

create or replace function sf_soft_install(code software.soft_id%type)
return varchar2
as
status varchar2(15);
cnt number(2);
begin
    select count(1) into cnt from inst_soft where soft_id=code;
    if cnt>0 then
        status:='installed';
    else
        status:='uninstalled';
    end if;
    return status;  
end;
/

--execute
begin
    dbms_output.put_line(sf_soft_install('S10'));
end;
/