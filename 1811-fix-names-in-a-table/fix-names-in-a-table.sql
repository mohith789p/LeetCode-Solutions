# Write your MySQL query statement below
Select user_id, concat(Upper(substring(name,1, 1)), Lower(substring(name, 2))) as name
from Users
order by user_id;