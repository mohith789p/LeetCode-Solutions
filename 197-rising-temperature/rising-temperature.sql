# Write your MySQL query statement below
select w.id as Id
from weather w join weather w2
where datediff(w.recorddate, w2.recorddate) = 1 and w.temperature > w2.temperature;