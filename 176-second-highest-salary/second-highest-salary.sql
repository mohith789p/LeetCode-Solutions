# Write your MySQL query statement below
Select Max(salary) as SecondHighestSalary
from employee
where salary not in (select max(salary) from Employee);