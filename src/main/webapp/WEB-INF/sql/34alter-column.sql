-- ALTER TABLE : 테이블 변경
create table MyTable14 (
	Col1 int,
	Col2 int
);

-- 컬럼 추가 ADD COLUMN
alter table MyTable14
add column Col3 varchar(10);

desc MyTable14;

alter table MyTable14
add column Col4 dec(10, 2); 

-- 연습 5번째 컬럼 추가
alter table MyTable14
add column Col5 datetime;

-- 첫번째 컬럼으로 추가
alter table MyTable14
add column col6 int first;
alter table MyTable14
add column col7 int first;
desc MyTable14;

-- 중간에 컬럼 추가
alter table MyTable14
add column col8 varchar(8) after col7;

-- 연습) 첫번째 컬럼으로 하나 추가
alter table MyTable14
add column col9 int4 first;
-- 연습) 컬럼을 중간에 추가
alter table MyTable14
add column col10 dec(12, 2) after col2;
select * from MyTable14;