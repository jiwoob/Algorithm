-- 코드를 입력하세요
SELECT cart_id 
    FROM cart_products
    WHERE name IN ('Milk', 'Yogurt')
    GROUP BY cart_id 
    HAVING COUNT(DISTINCT NAME)=2