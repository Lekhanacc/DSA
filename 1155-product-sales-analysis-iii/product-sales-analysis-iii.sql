# Write your MySQL query statement below
WITH FirstYearSales AS (
    SELECT 
        product_id,
        year AS first_year,
        quantity,
        price,
        DENSE_RANK() OVER (
            PARTITION BY product_id 
            ORDER BY year ASC
        ) AS year_rnk
    FROM Sales
)
SELECT 
    product_id, 
    first_year, 
    quantity, 
    price
FROM FirstYearSales
WHERE year_rnk = 1;
