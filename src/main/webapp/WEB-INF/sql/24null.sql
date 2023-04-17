-- null 과의 연산은 모두 false
select * from Products where CategoryID = 2 order by 1 desc; -- 14 rows
select * from Products where CategoryID = 2 and Price >= 25.00; -- 4 rows
select * from Products where CategoryID = 2 and Price < 25.00; -- 8 rows // price가 null인 record는 제외
select * from Products where categoryID = 2 and IFNULL(Price, 0) < 25.00; -- 10 rows // price가 null인 값을 0으로 변환 후 조회
select * from Products where CategoryID = 2 and Price is null; -- null 인 값을 조회할 때는 is null 사용
select * from Products where CategoryID = 2 and Price = null; -- = 연산자를 사용하면 조회 안됨. xxx

select ProductName, Price * 1300 from Products where CategoryID = 2; -- 산술 연산결과도 null
select ProductName, IFNULL(Price, 0) * 1300 from Products where CategoryID = 2; -- IFNULL 사용
