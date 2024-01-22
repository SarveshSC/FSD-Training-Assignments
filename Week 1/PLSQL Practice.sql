use hexaware_db;

show tables;

Delimiter $$
create procedure getAllEmployees()
begin
select emp_id, emp_name from employees;
end
$$

call getAllEmployees();

Delimiter $$
create procedure updateEmployeeCommission(IN id integer)
begin
declare data double default 0;

select comm into data from employees where emp_id = id;
if data is null then
   update Employees set comm = 2000 where emp_id = id;
   select 'record update';
end if;
end
$$

call updateEmployeeCommission(104);

-- ------------------------------------------------------
delimiter $$
create function getSalary(id int) 
returns int deterministic
begin
declare data int;
select salary into data from employees where emp_id = id;  
return data;
end
$$


-- --------------------------------- 
CREATE TABLE account (acct_num INT, amount DECIMAL(10,2));

set @sum = 0;
create trigger insert_sum before insert on account
for each row set @sum = @sum + new.amount;

set @data = '';
create trigger add_dept before insert on dept
for each row set @data = 'New Dept added';

insert into dept values (70, 'Service','Delhi');
select @data;
select * from dept;
-- ---------------------------------------------------------
create view emp_details as select emp_id, emp_name, designation, salary from employees;
select sum(salary) from emp_details;

create view dept_details as select dname, location from dept;
select * from dept_details;
select * from dept_details order by dname;


