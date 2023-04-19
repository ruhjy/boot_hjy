use w3schools;

-- transaction : 하나의 업무 단위
-- 하나의 transaction 여러 insert, update, delete
-- 명령문으로 구성될 수 있다.

-- 예) 이체 (A -> B) 5000원
-- A의 돈은 -5000원 update
-- B의 돈은 +5000원 update
drop table Bank;
create table Bank(
	customerName varchar(255),
    money int default 0
);

select * from Bank;
insert into Bank(customerName, money) values ('A', 100000), ('B', 100000);

-- 이체 5000원 (A -> B)
update Bank set
money = money - 5000 where CustomerName = 'A';

update Bank set
money = money + 5000 where CustomerName = 'B';

-- COMMIT : 트랜잭션 완료
-- ROLLBACK : 트랜잭션 실패 (트랜잭션 시작 이전으로 되돌리기)

-- 자동 커밋 (autocommit)
set autocommit = 0; -- 자동커밋 비활성화(disable)
set autocommit = 1; -- 자동커밋 활성화(enable)

update Bank set
money = money - 5000 where CustomerName = 'A';
update Bank set
money = money + 5000 where CustomerName = 'B';
rollback; -- 마지막 커밋으로 되돌리기
commit; -- 트랜잭션 완료
select * from Bank;


-- 이체시 오류 5000원 (A -> B)
update Bank set
money = money - 5000
where customerName = 'A'; -- 실행됨
-- 오류 생겼다고 가정
rollback; -- 마지막 커밋으로 되돌리기