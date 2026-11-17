# Write your MySQL query statement below

-- this is using left join as it preserves every customers
-- SELECT c.name AS Customers
-- FROM Customers c
-- LEFT JOIN Orders o
-- ON c.id = o.customerId
-- WHERE o.customerId IS NULL;

-- using NOT EXISTS
SELECT c.name AS Customers
FROM Customers c
WHERE NOT EXISTS (
    SELECT 1 
    FROM Orders o 
    WHERE o.customerId = c.id
);
