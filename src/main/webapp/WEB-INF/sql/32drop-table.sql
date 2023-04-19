use w3schools;

-- DROP TABLE tablename; -> 테이블 삭제 
-- 주의*9999999999999999999999

desc MyTable01;
select * from MyTable01;
drop table MyTable01;

-- 연습 : MyTable02, MyTable03 테이블 삭제(drop) 롤백 안되는는건가..
drop table MyTable02; -- 주의*9999999
drop table MyTable03; -- 주의*9999999

-- TRUNCATE : 테이블 유지, 데이터만 삭제, 복구 불가
select * from MyTable04;
truncate MyTable04; -- 주의!!!!!!!