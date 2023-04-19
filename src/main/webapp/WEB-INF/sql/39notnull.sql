-- NOT NULL : NULL 허용 안함
create table MyTable18 (
	Col1 int,
    Col2 int not null
);

insert into MyTable18 (Col1, Col2) values (100, 200); -- ok
insert into MyTable18 (Col2) values (300); -- ok
insert into MyTable18 (Col1) values (400); -- xxx
desc MyTable18;
select * from MyTable18;

-- 연습) MyTable19, 두개 컬럼, varchar(20)
-- 두번째 컬럼만 not null 제약사항 적용
create table MyTable19 (
	Name varchar(20),
	Age varchar(20) not null
);
insert into MyTable19 (Name, Age) values ('강백호', '20');
insert into MyTable19 (Name) values ('정대만'); -- xxx 
insert into MyTable19 (Age) values ('50');
desc MyTable19;
select * from MyTable19;

--
create table MyTable20 (
	Col1 int default 0,
    Col2 int not null,
    Col3 int default 1 not null
);

desc MyTable20;
insert into MyTable20 (Col1, Col2, Col3) values (10, 20, 30);
insert into MyTable20 (Col1, Col2) values (40, 80);
insert into MyTable20 (Col2) values (50);
insert into MyTable20 (Col1, Col2, Col3) values (null, 30, 90);
select * from MyTable20;

-- not null default 조합 가능
create table MyTable21 (
	Col1 int, -- null 허용, default 없음
    Col2 int not null, -- null 허용 안함, default 없음
    Col3 int default 0, -- null 허용, default 0
    Col4 int default 0 not null -- null 허용 안함, default 0
);

desc MyTable21;