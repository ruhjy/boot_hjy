-- ALTER TABLE MODIFY COLUMN : 제약사항 추가 (가능)
create table MyTable28 (
	col1 int,
	col2 int,
	col3 int,
	col4 int
);
desc MyTable28;

alter table MyTable28 modify column col1 int unique;
alter table MyTable28 modify column col2 int not null;
-- col3에 default 0 제약사항 추가
alter table MyTable28 modify column col3 int default 0;
-- col4에 not null unique default 100 제약사항 추가
alter table MyTable28 modify column col4 int not null unique default 100;

-- ADD PRIMARY KEY : PRIMARY KEY 추가
create table MyTable29 (
	Col1 int,
    Col2 int,
    Col3 int
);
desc MyTable29;

alter table MyTable29 add primary key (Col1, Col2);
