-- LIMIT : 조회 레코드 수 제한

select * from Customers limit 5; -- 5개 레코드만

select * from Products limit 3;

-- 가격이 높은 상품 3개 조회
select * from Products order by Price desc limit 3;
-- 2번 카테고리 상품 중 비싼 거 3개
select * from Products 
where CategoryID = 2 
order by Price desc limit 3;

-- 나이 많은 직원 3명 조회
select * from Employees order by BirthDate limit 3;

-- 브라질 고객 중 아무나 3명 조회
select * from Customers where Country = 'Brazil' limit 3;

-- 3번 카테고리 상품 중 가격이 싼 상품 2개 조회
select * from Products where CategoryID = 3 order by Price limit 2;