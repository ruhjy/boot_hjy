-- CREATE TABLE : 새 테이블 만들기
-- TABLE 이름 : 작성 규칙 (회사마다 다름) - 대소문자 구분함
-- 수업에서는 UpperCamelCase로 작성함.

-- create table 테이블이름 ...
create table MyTable01 (
	-- 컬럼 정의
    -- 컬럼명 값의 type, ...
    -- 컬럼명 작성규칙 (회사 규칙 따르기)
    -- 우리 과정에서는 UpperCamelCase(대소문자 구분 안함)
    Col1 INT,
    Col2 VARCHAR(255)
); 

select * from MyTable01;
-- desc : 테이블 구조 보기
desc MyTable01;
insert into MyTable01(Col1, Col2) values (30, '가나다');
insert into MyTable01(Col1, Col2) values ('삼십', '가나다'); -- xxx