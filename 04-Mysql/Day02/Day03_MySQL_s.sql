-- ============================================================
-- Day03. SQL 기본 : SELECT + 데이터 변경 SQL
-- ============================================================
-- 대상 DB  : shopdb2 (memberTBL, productTBL)
--            sqldb2  (usertbl, buytbl)
--            employees DB



-- ============================================================
-- [개념 1] SQL 명령어 분류 (DDL / DML / DCL / TCL)
-- ============================================================
--
-- DDL (Data Definition Language, 데이터 정의 언어)
-- - 데이터베이스 구조(테이블, 뷰, 인덱스 등)를 생성/변경/삭제한다.
-- - 명령어 : CREATE, ALTER, DROP, TRUNCATE
-- - 트랜잭션 없이 즉시 반영 (ROLLBACK 불가)
--
-- DML (Data Manipulation Language, 데이터 조작 언어)
-- - 테이블의 행 데이터를 조회/입력/수정/삭제한다.
-- - 명령어 : SELECT, INSERT, UPDATE, DELETE
-- - 트랜잭션과 연결 (ROLLBACK 가능)
--
-- DCL (Data Control Language, 데이터 제어 언어)
-- - 사용자 권한을 부여하거나 회수한다.
-- - 명령어 : GRANT, REVOKE
--
-- TCL (Transaction Control Language, 트랜잭션 제어 언어)
-- - 변경 작업을 확정하거나 되돌린다.
-- - 명령어 : COMMIT, ROLLBACK, SAVEPOINT
--


-- ============================================================
-- [개념 2] SELECT 문 기본 구조
-- ============================================================
--
-- 형식 :
--   SELECT 컬럼명
--   FROM   테이블명
--   WHERE  조건식
--   GROUP BY 컬럼명
--   HAVING 조건식
--   ORDER BY 컬럼명 [ASC|DESC]
--   LIMIT  행수;
--
-- SQL 논리 실행 순서 (작성 순서와 다름):
--   FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY -> LIMIT
--
-- SELECT * : 모든 컬럼 조회. 
--   불필요한 데이터까지 조회
--   컬럼 변경 시 영향 발생
-- -> 필요한 컬럼만 명시하는 것이 권장된다.
--



-- ============================================================
-- [실습 준비] shopdb2 선택 및 초기 데이터 입력
-- ============================================================

-- 실습 : shopdb22 데이터베이스 선택하기
use shopdb2;


-- ============================================================
-- [실습 1] SELECT 기본 - 전체 조회 / 컬럼 선택
-- ============================================================
--
-- SELECT 컬럼명 FROM 테이블명;

-- 전체 조회
-- 실습 : memberTBL 테이블의 모든 컬럼 조회하기
select * from memberTBL;


-- 실습 : productTBL 테이블의 모든 컬럼 조회하기
select * from productTBL;



-- 필요한 컬럼만 조회
-- 실습 : memberTBL 테이블에서 memberName 컬럼 조회하기
select memberName from memberTBL;


-- 실습 : memberTBL 테이블에서 memberName, memberAddress 컬럼 조회하기
SELECT memberName, memberAddress FROM memberTBL;


-- 실습 : productTBL 테이블에서 productName, cost 컬럼 조회하기
SELECT productName, cost FROM productTBL;


-- DB 이름을 붙여서 조회하는 방법 (USE 없이도 사용 가능)
-- 실습 : shopdb2에  memberTBL 테이블의 모든 컬럼 조회하기
SELECT * FROM shopdb2.memberTBL;

-- ============================================================
-- [개념 3] 컬럼 별칭 (Alias)
-- ============================================================
--
-- AS를 사용하면 출력 컬럼 이름을 보기 좋게 바꿀 수 있다.
-- AS는 생략 가능하지만, 수업에서는 명확하게 AS를 쓰는 것을 권장한다.
-- 공백이 포함된 별칭은 반드시 작은따옴표 또는 큰따옴표로 감싼다.
--
-- 형식 :
--   SELECT 컬럼명 AS '별칭'
--   FROM 테이블명;
--


-- ============================================================
-- [실습 2] 컬럼 별칭 (Alias)
-- ============================================================
--
--  AS를 사용해서 결과 컬럼 이름을 한글로 바꾼다.
--  SELECT 컬럼명 AS '별칭' FROM 테이블명;

-- 실습 : memberTBL 테이블에서 memberName AS '회원 이름', memberAddress AS '주소' 컬럼 조회하기
SELECT memberName AS '회원 이름', memberAddress AS '주소' FROM memberTBL;


-- 실습 : productTBL 테이블에서 productName AS '제품명', cost AS '가격', amount AS '수량' 컬럼 조회하기
SELECT productName AS '제품명', cost AS '가격', amount AS '수량' FROM productTBL;



-- ============================================================
-- [개념 4] WHERE 조건
-- ============================================================
--
-- WHERE는 조건에 맞는 행만 조회할 때 사용한다.
-- WHERE는 FROM 다음에 실행된다.  (FROM -> WHERE -> SELECT 순)
--
-- 비교 연산자 :
--   =    같다
--   !=   같지 않다
--   <>   같지 않다
--   >    크다
--   <    작다
--   >=   크거나 같다
--   <=   작거나 같다
--
-- 논리 연산자 :
--   AND  두 조건 모두 만족
--   OR   둘 중 하나라도 만족
--   NOT  조건 부정
--
-- NULL 비교 :
--   NULL은 '값이 없음 / 알 수 없음'을 의미한다.
--   NULL은 = NULL, <> NULL 같은 일반 비교 연산자로 비교하지 않는다.
--   일반 비교 연산에서 피연산자 중 하나가 NULL이면 결과도 NULL이 될 수 있다.
--   따라서 NULL 여부는 반드시 IS NULL 또는 IS NOT NULL 을 사용한다.
--   참고 : NULL까지 안전하게 같은지 비교해야 할 때는 <=> 연산자를 사용할 수 있다.
--
-- 우선순위 : AND 가 OR 보다 먼저 처리된다.
--   -> 의도가 섞일 경우 괄호 () 를 사용한다.
--
-- 문자열은 반드시 작은따옴표 사용.
-- 숫자는 따옴표 없이 사용.
--


-- ============================================================
-- [실습 3] WHERE - 단일 조건 / 비교 연산자
-- ============================================================
--
--  WHERE 절로 특정 조건의 행만 조회한다.
--  WHERE 컬럼명 = '값'

-- 실습 : memberTBL 테이블의 memberName 이 지운이 인 모든 컬럼 조회하기 
SELECT * FROM memberTBL WHERE memberName = '지운이';


-- 실습 : productTBL 테이블에서 cost 값이 10 이상인 조건의 모든 컬럼 조회하기
SELECT *FROM productTBL WHERE cost >= 10;


-- 실습 : memberTBL 테이블에서 memberName '지운이' 이(가) 아닌 조건의 모든 컬럼 조회하기
SELECT * FROM memberTBL WHERE memberName != '지운이';



-- ============================================================
-- [실습 4] WHERE - AND / OR / NOT
-- ============================================================
--
--  AND / OR / NOT 을 사용해서 복합 조건을 작성한다.
--  AND 가 OR 보다 먼저 처리되므로 괄호를 활용한다.




-- 실습 : cost 값이 10 이상인 AND amount 값이 10 이상인 조건의 모든 컬럼 조회하기
SELECT * FROM productTBL WHERE cost >= 10 AND amount >= 10;


-- 실습 :  memberName '지운이' 인 OR memberName '한주연' 인 조건의 모든 컬럼 조회하기
SELECT * FROM memberTBL WHERE memberName = '지운이' OR memberName = '한주연';


-- AND / OR 우선순위 확인
-- 실습 : (삼성 제품) 또는 (LG 제품 중 가격 20 이상)
--   company가 '삼성' 이거나 company가 'LG' 이고  cost가 20 이상인 조건의 모든 컬럼 조회하기
SELECT * FROM productTBL WHERE company = '삼성' OR (company = 'LG' AND cost >= 20);



-- 실습 : 삼성 또는 LG 제품 중 가격 20 이상 
SELECT * FROM productTBL WHERE company = '삼성' OR (company = 'LG' AND cost >= 20);

-- ============================================================
-- [실습 5] WHERE - IS NULL / IS NOT NULL
-- ============================================================
--
--  NULL 값을 IS NULL / IS NOT NULL 로 조회한다.
--  WHERE 컬럼명 IS NULL


-- 실습 :  company 값이 NULL 인 조건의 모든 컬럼 조회하기
INSERT INTO producttbl
(productName, cost, makeDate, company, amount)
VALUES
('냉장고', 2000, NULL, NULL, 3);

SELECT * FROM productTBL WHERE company IS NULL;

-- 실습 :  company 값이 NULL 이 아닌 조건의 모든 컬럼 조회하기
SELECT * FROM productTBL WHERE company IS NOT NULL;


-- ============================================================
-- [개념 5] BETWEEN / IN / LIKE
-- ============================================================
--
-- BETWEEN A AND B
--   -> A 이상 B 이하 범위 검색 (A, B 포함)
--
-- IN (값1, 값2, 값3)
--   -> 여러 값 중 하나라도 일치하면 조회
--
-- LIKE
--   -> 문자열 패턴 검색
--   % : 글자 수 상관없이 모든 문자열
--   _ : 정확히 한 글자
--
-- sqldb2 예제 :
--   키가 180~183인 사람   -> WHERE height BETWEEN 180 AND 183
--   경남/전남/경북 출신    -> WHERE addr IN ('경남','전남','경북')
--   이름이 '김'으로 시작   -> WHERE name LIKE '김%'
--


-- ============================================================
-- [실습 6] BETWEEN / IN / LIKE
-- ============================================================
--
--  BETWEEN, IN, LIKE 를 사용해서 조건 검색한다.
--  WHERE 컬럼명 BETWEEN 값1 AND 값2
--        WHERE 컬럼명 IN ('값1', '값2')
--        WHERE 컬럼명 LIKE '패턴%'

-- shopdb2 실습
-- 실습 : cost 값이 5 이상 20 이하인 조건의 모든 컬럼 조회하기
SELECT * FROM productTBL WHERE cost BETWEEN 5 AND 20;


-- 실습 : 주소가 '서울 은평구 증산동' 또는 '인천 남구 주안동' 인 회원의 모든 컬럼 조회하기
SELECT * FROM memberTBL WHERE memberAddress IN ('서울 은평구 증산동', '인천 남구 주안동');


-- 실습 : 이름이 '지'로 시작하는 회원의 모든 컬럼 조회하기
SELECT * FROM memberTBL WHERE memberName LIKE '지%';

-- 실습 : 주소가 '경기'로 시작하는 회원의 모든 컬럼 조회하기
SELECT * FROM memberTBL WHERE memberAddress LIKE '경기%';


-- 실습 : 이름의 첫 글자는 아무 문자이고 뒤가 '운이'인 회원의 모든 컬럼 조회하기
SELECT * FROM memberTBL WHERE memberName LIKE '_운이';


-- sqldb22 실습
-- 실습 : sqldb22 데이터베이스 선택하기

create database sqldb22;

-- 문제: usertbl 테이블 생성하기

CREATE TABLE usertbl (
  userID CHAR(8)  PRIMARY KEY,
  name VARCHAR(10) NOT NULL,
  birthYear INT NOT NULL,
  addr CHAR(2) NOT NULL,
  mobile1 CHAR(3),
  mobile2 CHAR(8),
  height SMALLINT,
  mDate DATE
);


-- 문제: buytbl 테이블 생성하기

CREATE TABLE buytbl (
  num INT AUTO_INCREMENT PRIMARY KEY,
  userID CHAR(8) NOT NULL,
  prodName CHAR(10) NOT NULL,
  groupName CHAR(4),
  price INT NOT NULL,
  amount SMALLINT NOT NULL,
  FOREIGN KEY (userID) REFERENCES usertbl(userID)
);


-- 문제: usertbl 테이블에 제시된 데이터 추가하기
-- 예상 결과: INSERT 성공 시 추가된 행 수가 반영된다.
INSERT INTO usertbl VALUES
('KBS', '김범수', 1979, '경남', '011', '22222222', 173, '2012-04-04'),
('JYP', '조용필', 1950, '경기', '011', '44444444', 166, '2009-04-04'),
('BBK', '바비킴', 1973, '서울', '010', '00000000', 176, '2013-05-05'),
('EJW', '은지원', 1972, '경북', '011', '88888888', 174, '2014-03-03'),
('SSK', '성시경', 1979, '서울', NULL, NULL, 186, '2013-12-12'),
('LJB', '임재범', 1963, '서울', '016', '66666666', 182, '2009-09-09');


-- 문제: buytbl 테이블의 userID, prodName, groupName, price, amount 컬럼에 제시된 데이터 추가하기

INSERT INTO buytbl(userID, prodName, groupName, price, amount) VALUES
('KBS', '운동화', '잡화', 30, 2),
('KBS', '노트북', '전자', 1000, 1),
('JYP', '모니터', '전자', 200, 1),
('BBK', '청바지', '의류', 50, 3),
('EJW', '책', '서적', 15, 5),
('EJW', '운동화', '잡화', 30, 2);

USE sqldb22;


-- 실습 : usertbl 테이블에서 키가 180 이상 183 이하인 회원의 name, height 컬럼 조회하기
SELECT name, height FROM usertbl WHERE height BETWEEN 180 AND 183;


-- 실습 : usertbl 테이블에서 주소가 '경남', '전남', '경북' 중 하나인 회원의 name, addr 컬럼 조회하기
SELECT name, addr FROM usertbl WHERE addr IN ('경남', '전남', '경북');


-- 실습 : usertbl 테이블에서 이름이 '김'으로 시작하는 회원의 name, height 컬럼 조회하기
SELECT name, height FROM usertbl WHERE name LIKE '김%';



-- ============================================================
-- [개념 6] ORDER BY
-- ============================================================
--
-- ORDER BY 는 조회 결과의 출력 순서를 정렬한다.
-- ASC  : 오름차순 (기본값, 생략 가능)
-- DESC : 내림차순
--
-- 실제 저장 순서를 바꾸는 것이 아니라 출력 순서만 바꾼다.
-- 논리 실행 순서에서 ORDER BY 는 가장 마지막에 처리된다.
--
-- 복수 정렬 : 첫 번째 기준이 동률인 경우 두 번째 기준 적용
--   SELECT name, height FROM usertbl ORDER BY height DESC, name ASC;
--


-- ============================================================
-- [실습 7] ORDER BY
-- ============================================================
--
--  ORDER BY 로 정렬 기준과 방향을 지정한다.
--  ORDER BY 컬럼명 ASC|DESC

-- 실습 : shopdb2 데이터베이스 선택하기
USE shopdb2;

-- 실습 : productTBL 테이블의 모든 컬럼을 가격기준 오름차순 으로 정렬하여 조회하기
SELECT * FROM productTBL ORDER BY cost ASC;

-- 실습 : productTBL 테이블의 모든 컬럼을 가격기준 내림차순 으로 정렬하여 조회하기
SELECT * FROM productTBL ORDER BY cost DESC;

-- 복수 정렬 : 모든 컬럼을 가격 내림차순, 동률이면 제품명 오름차순
SELECT * FROM productTBL ORDER BY cost DESC, productName ASC;


-- sqldb2 실습 
-- 실습 : sqldb2 데이터베이스 선택하기
USE sqldb2;

-- 실습 : usertbl 테이블에서 회원 이름과 가입일을 가입일기준 오름차순으로 조회하기
SELECT name, mDate FROM usertbl ORDER BY mDate ASC;


-- 실습 : usertbl 테이블에서 회원 이름과 가입일을 가입일 내림차순으로 조회하기
SELECT name, mDate FROM usertbl ORDER BY mDate DESC;

-- 실습 : usertbl 테이블에서 회원 이름과 키를 키 내림차순, 이름 오름차순으로 조회하기
SELECT name, height FROM usertbl ORDER BY height DESC, name ASC;


-- ============================================================
-- [개념 7] DISTINCT
-- ============================================================
--
-- DISTINCT 는 중복된 값을 제거하고 하나만 남겨 조회한다.
-- 어떤 값들이 존재하는지 확인할 때 자주 사용한다.
--
-- 여러 컬럼에 사용하면 컬럼 조합 기준으로 중복 제거된다.
--   SELECT DISTINCT company, cost FROM productTBL;
--


-- ============================================================
-- [실습 8] DISTINCT
-- ============================================================
--
--  DISTINCT 로 중복 없이 고유한 값만 조회한다.
--  SELECT DISTINCT 컬럼명 FROM 테이블명;

-- 실습 : shopdb2 데이터베이스 선택하기
USE shopdb2;

INSERT INTO producttbl
(productName, cost, makeDate, company, amount)
VALUES
('Tv1', 2000, NULL, 'LG' , 3);

-- 실습 : productTBL 테이블에서 company 컬럼 조회하기
SELECT company FROM productTBL;

-- 실습 : productTBL 테이블에서 company 컬럼의 중복을 제거하여 조회하기
SELECT DISTINCT company FROM productTBL;


-- sqldb2 실습 
-- 실습 : sqldb2 데이터베이스 선택하기
USE sqldb2;
-- 실습 : usertbl 테이블에서 addr 컬럼의 중복을 제거하여 조회하기 / 정렬 기준 -> addr
SELECT DISTINCT addr FROM usertbl ORDER BY addr ASC;

-- ============================================================
-- [개념 8] LIMIT
-- ============================================================
--
-- LIMIT 는 출력 행 개수를 제한한다.
-- MySQL의 부담을 줄이는 목적으로도 사용한다.
--
-- LIMIT 개수;
-- LIMIT 시작위치, 개수;
-- LIMIT 개수 OFFSET 시작위치;
--
-- 시작위치는 0부터 계산한다.
-- 페이지네이션 공식 : OFFSET = (페이지번호 - 1) * 페이지당 개수
-- 1페이지 : (1-1) * 20(개수) = 0 (0만큼 건너띄고)
-- 2페이지 : (2-1) * 20 = 20 (20만큼 건너띄고)
-- 3페이지 : (3-1) * 20 = 40 (40만큼 건너띄고)
-- 8페이지 : (8-1) * 20 = 140 (140만큼 건너띄고 - 7페이지까지 data 수)
-- 예 : 8번 페이지, 한 페이지 20명
--      OFFSET = (8-1) * 20 = 140
--      LIMIT 140, 20;
--


-- ============================================================
-- [실습 9] LIMIT / 페이지네이션
-- ============================================================
--
--  LIMIT 로 출력 개수를 제한하고 페이지네이션을 구현한다.
--  ORDER BY 후 LIMIT 사용



-- 실습 : shopdb2 데이터베이스 선택하기
USE shopdb2;

-- 실습 : memberTBL 테이블의 모든 컬럼을 처음 2개 조회하기
SELECT * FROM memberTBL LIMIT 2;


-- 실습 : memberTBL 테이블의 모든 컬럼을 memberName 오름차순으로 정렬 후 처음 2개 조회하기
SELECT * FROM memberTBL ORDER BY memberName ASC LIMIT 2;


-- 실습 : memberTBL 테이블의 모든 컬럼을 memberName 오름차순으로 정렬 후 처음 2개를 제외하고 다음 5개 조회하기
SELECT * FROM memberTBL ORDER BY memberName ASC LIMIT 2, 5;


-- 실습 : memberTBL 테이블의 모든 컬럼을 memberName 오름차순으로 정렬 후 처음 2개 조회하기(OFFSET)
SELECT * FROM memberTBL ORDER BY memberName ASC LIMIT 5 OFFSET 2;


-- employees 실습  8번 페이지, 1페이지 20건

-- 실습 : employees 데이터베이스 선택하기
USE employees;

-- 실습 : employees 테이블의 모든 컬럼을 입사일 내림차순으로 정렬 후
-- 8페이지 데이터 20건 조회하기

-- 페이지당 20건
-- OFFSET = (8 - 1) * 20
-- OFFSET = 140

SELECT * FROM employees ORDER BY hire_date DESC LIMIT 140, 20;



