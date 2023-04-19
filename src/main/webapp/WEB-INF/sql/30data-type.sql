-- Character(String) 문자형
-- VARCHAR(길이)

create table MyTable02 (
	Col1 varchar(3),
    Col2 varchar(5)
);
select * from MyTable02;

insert into MyTable02(Col1, Col2) values ('abc', 'abcde'); -- ok
insert into MyTable02(Col1, Col2) values ('ab', 'abcd'); -- ok
insert into MyTable02(Col1, Col2) values ('abcd', 'abcdef'); -- xxx










-- Numeric (수)



-- 날짜시간