# Write your MySQL query statement below

-- using count and group by 

-- SELECT email AS Email
-- FROM Person
-- GROUP BY email
-- HAVING COUNT(email) > 1;      

-- using window function 

SELECT DISTINCT email AS Email
FROM (
    SELECT 
        email,
        ROW_NUMBER() OVER (PARTITION BY email ORDER BY id) AS rn
    FROM Person
) t
WHERE rn > 1;


