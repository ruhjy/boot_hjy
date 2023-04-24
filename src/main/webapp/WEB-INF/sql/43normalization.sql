-- normalization (정규화)
-- 1NF (first normal form) 첫번째 정규화 (215쪽)
-- 규칙1) 열은 원자적 값만을 포함한다.
-- 규칙2) 같은 데이터가 여러 열에 반복되지 말아야 한다.
-- 규칙3) 각 행은 유일무이한 식별자인 기본키를 가지고 있어야 한다.

-- (216~217쪽)
-- *기본키* : 각 레코드(row)를 다른 레코드와 구분하는 열(column)
-- 1) 기본키는 null이 될 수 없습니다.
-- 2) 기본키는 레코드가 삽입될 때 값이 있어야 합니다.
-- 3) 기본키는 간결해야 합니다.
-- 4) 기본키의 값은 변경 불가입니다.
-- > 가장 좋은 기본키는 기본키를 위한 열을 새로 만드는 것입니다. (기본키를 위한 열을 새로 만들기)

-- 예제) 학생이름, 전화번호
create table Student (
	Id int primary key auto_increment, -- 인위적 키 컬럼
	Name varchar(50)
);

create table StudentPhone (
	Id int primary key auto_increment,
	StudentId int,
	Phone varchar(50)
);

-- 예제) 교재 정보를 저장할 테이블 작성
-- 제목, 저자, 출판사, 가격
create table Book (
	Id int primary key auto_increment,
	Title varchar(100),
    Writer varchar(100),
    Publisher varchar(200),
    Price int
);


-- 2NF (second normal form) 두번째 정규화 (369쪽)
-- 규칙1) 1NF여야 한다.
-- 규칙2) 부분적 함수 의존이 없다.



-- 3NF (third normal form) 세번째 정규화 (374쪽)
-- 규칙1) 2NF여야 한다.
-- 규칙2) 이행적 종속이 없습니다.
