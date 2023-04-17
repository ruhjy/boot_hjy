-- AVG(평균) , SUM(합계)
select SUM(Price) from Products;
select AVG(Price) from Products;

-- 5번 카테고리 상품값의 합
select SUM(Price) from Products where CategoryID = 5;
-- 1번 카테고리 상품값의 평균
select AVG(Price) from Products where CategoryID = 1;