# Write your MySQL query statement below
Select Max(salary) as SecondHighestSalary
from employee
where salary < (Select Max(salary) as SecondHighestSalary
from employee)
