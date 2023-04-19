desc MyTable14;

-- MODIFY COLUMN : 컬럼 타입 변경
alter table MyTable14
modify column col20 varchar(40);

select * from MyTable14;
alter table MyTable14
modify column col14 varchar(3); -- 주의해서 사용할 것.

-- 연습) MyTable14에서 아무 컬럼의 타입 변경
alter table MyTable14
modify column col9 date;
alter table MyTable14
modify column col8 varchar(88);
desc MyTable14;

--
alter table MyTable14
modify column col15 int first;
alter table MyTable14
modify column col8 varchar(88) after col20;

-- 연습) MyTable14의 아무컬럼의 위치 변경
desc MyTable14;
alter table MyTable14
modify column col4 dec(13, 2) after col15;
alter table MyTable14
modify column col14 varchar(10) after col9;
alter table MyTable14 change column col9 col100 datetime;
alter table MyTable14 modify column col100 datetime first;