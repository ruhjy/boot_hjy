-- 학생명, 전화번호(여러개 가능)
create table Student (
	Id int primary key auto_increment,
    Name varchar(50)
);

drop table StudentPhone;
create table StudentPhone (
	Id int primary key auto_increment,
	StudentId int,
    Phone varchar(50),
    -- foreign key (외래키, 참조키)
    foreign key (StudentId) references Student(Id)
);

desc Student;
desc StudentPhone;

-- 데이터 입력
insert into Student (Name)
values
	('손흥민'),
    ('박지성');

select * from Student;
select * from StudentPhone;

insert into StudentPhone (StudentId, Phone)
values
	(1, '010-9999-8888'),
	(2, '010-8888-9999');
insert into StudentPhone (StudentId, Phone)
values (3, '010-7777-7777'); -- fail xxx

insert into StudentPhone (StudentId, Phone)
values 
	(null, '010-5555-5555'), -- ok
	(null, '010-3333-3333'); -- ok
    
-- StudentPhone.StudentId column not null 제약사항 추가
delete from StudentPhone where StudentId is null;
alter table StudentPhone modify column StudentId int not null;

insert into StudentPhone (StudentId, Phone)
values (1, '010-7777-7777');

select * from Student;
select * from StudentPhone;

delete from Student where id = 2; -- fail
-- > 외래키 제약사항이 있는 테이블의 데이터를 먼저 지워야 함.
delete from StudentPhone where StudentId = 2;
delete from Student where id = 2; -- ok