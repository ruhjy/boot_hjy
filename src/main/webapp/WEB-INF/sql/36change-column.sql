desc MyTable14;

alter table MyTable14
change column col5 col15 varchar(20); -- 위험!!

insert into MyTable14(col14) values ('가나다라마바사');
select * from MyTable14;

alter table MyTable14
change column col14 col24 varchar(3); -- 위험!! 실행도 안해준다.

-- 연습) col1 을 col20 varchar(20)으로 변경
alter table MyTable14
change column col1 col20 varchar(20);
desc MyTable14;