desc MyTable11;

-- 테이블 복사?
CREATE TABLE `MyTable12` (
   `Title` varchar(100) DEFAULT NULL,
   `Writer` varchar(20) DEFAULT NULL,
   `Publisher` varchar(50) DEFAULT NULL,
   `Published` date DEFAULT NULL,
   `Price` int(11) DEFAULT NULL,
   `Extra` varchar(1000) DEFAULT NULL
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- show create table tablename; : 테이블 생성 명령 보기
show create table MyTable11; -- 나온 결과 복사해서 사용

desc MyTable11;
desc MyTable12;

-- 같은 컬럼명 타입으로 새로운 테이블 만들기, 데이터까지 복사
create table MyTable13 as select * from MyTable11;
desc MyTable13;
select * from MyTable13;