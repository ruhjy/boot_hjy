-- HAVING : 집계함수의 조건 설정 (group by로 필터링한 테이블의 조건문)
select Country, COUNT(CustomerID) from Customers group by Country;

-- 5명 이상의 고객이 있는 나라 조회
select Country, COUNT(CustomerID) as numOfCustomer 
from Customers 
group by Country having numOfCustomer >= 5;

select Country, COUNT(CustomerID) as numOfCustomer 
from Customers 
group by Country having COUNT(CustomerID) >= 5;

-- 문제1) 상품의 평균 가격이 30 달러 이상인 카테고리 조회
select * from Products;
select CategoryID, AVG(Price) from Products group by CategoryID having AVG(Price) >= 30;
-- 문제2) 카테고리별 상품의 최고 가격이 100달러 이상인 카테고리 조회
select CategoryID, MAX(Price) from Products group by CategoryID having MAX(Price) >= 100;