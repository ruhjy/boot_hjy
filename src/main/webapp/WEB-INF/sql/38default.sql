-- DEFAULT 기본값 정할 수 있음
create table MyTable15 (
	Col1 int,
    Col2 int default 99
);

insert into MyTable15(Col1, Col2) values (100, 200);
insert into MyTable15(Col1) values (100); -- Col2에 default 99 입력됨.
insert into MyTable15(Col2) values (200); -- Col1에 null 입력됨.

select * from MyTable15;

create table MyTable16 (
	Col1 varchar(30),
    Col2 varchar(30) default '기본'
);

-- 연습) 3개행 추가
-- 1) Col1과 Col2에 모두 값 넣기
insert into MyTable16(Col1, Col2) values ('추가', '삭제');
-- 2) Col2에만 값 넣기
insert into MyTable16(Col2) values ('강백호'); -- Col1에는 null 입력.
-- 3) Col1에만 값 넣기
insert into MyTable16(Col1) values ('채치수'); -- Col2에는 default '기본' 입력.

desc MyTable16;
select * from MyTable16;

create table MyTable17 (
	Col1 date default '2000-01-01',
    Col2 date default now(),
    Col3 datetime default '1900-01-01 00:00:00',
    Col4 datetime default now()
);
insert into MyTable17 (Col1) values ('3000-03-03');
insert into MyTable17 (Col2) values ('4000-04-04');
insert into MyTable17 (Col3) values ('5000-05-05 05:05:05');
insert into MyTable17 (Col4) values ('6000-06-06 06:06:06');

select * from MyTable17;