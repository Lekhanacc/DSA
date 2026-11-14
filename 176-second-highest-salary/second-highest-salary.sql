#  this does not work when there is only one row so wrap it inside another query so it forces to print NULL when there is no answer from inner query 

-- SELECT DISTINCT SALARY AS SecondHighestSalary
-- FROM Employee
-- ORDER BY salary DESC
-- LIMIT 1 OFFSET 1  

SELECT (
    SELECT DISTINCT salary
    FROM Employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1
) AS SecondHighestSalary;
