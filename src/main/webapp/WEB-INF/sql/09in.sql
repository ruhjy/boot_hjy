-- IN 특정 값 중에 있으면...
select * from Customers where Country = 'Germany' or Country = 'France';
select * from Customers where Country in ('Germany', 'France');

-- 상품 전체 조회
select * from Products;
-- 3, 5번 카테고리에 속한 상품들 조회
select * from Products where CategoryID in (3, 5);
select * from Products where CategoryID = 3 or CategoryID = 5;

-- 1, 3, 5, 7 번 카테고리에 속한 상품들 조회
select * from Products 
where CategoryID = 1 or CategoryID = 3 or CategoryID = 5 or CategoryID = 7;
select * from Products where CategoryID in (1, 3, 5, 7);

-- 고객 전체 조회
select * from Customers;
-- Berlin, London, Madrid, Paris 에 있는 고객들 조회
select * from Customers where City in ('Berlin', 'London', 'Madrid', 'Paris');

-- Berlin, London, Madrid, Paris 에 있지 않는 고객들 조회
select * from Customers where not city in ('Berlin', 'London', 'Madrid', 'Paris');
select * from Customers where city not in ('Berlin', 'London', 'Madrid', 'Paris'); -- 읽기 편함

-- 1, 3, 5, 7 카테고리가 아닌 상품들 조회
select * from Products where CategoryID not in (1, 3, 5, 7);