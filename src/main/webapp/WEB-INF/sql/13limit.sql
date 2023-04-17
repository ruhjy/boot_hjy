-- LIMIT m 		-> 위에서부터 m개
-- LIMIT 0, m

-- LIMIT n, m	-> n번부터 m개

select * from Customers order by CustomerID;
select * from Customers order by CustomerID limit 3;
select * from Customers order by CustomerID limit 0, 3;

select * from Customers order by CustomerID limit 3, 3;
select * from Customers order by CustomerID limit 6, 3;

-- 두번째로 나이가 많은 직원 조회
select * from Employees order by BirthDate limit 1, 1;

-- 2번 카테고리 상품 중 두번째로 가격이 비싼 상품 조회
select * from Products where CategoryID = 2 order by price desc limit 1, 1;