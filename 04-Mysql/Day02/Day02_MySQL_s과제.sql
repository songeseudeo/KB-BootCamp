-- ============================================================
-- [개념 14] AUTO_INCREMENT
-- ============================================================
--
-- AUTO_INCREMENT 는 숫자 값을 자동으로 1씩 증가시킨다.
-- 보통 PRIMARY KEY 에 사용한다.
--
-- 조건 :
--   1. 숫자 타입이어야 한다.
--   2. PRIMARY KEY 또는 UNIQUE KEY 에 사용한다.
--   3. INSERT 시 해당 열에 NULL 을 입력하면 자동 값이 들어간다.
--   4. 중간 번호를 DELETE 해도 자동으로 재사용되지는 않는다.
--   5. ALTER TABLE 테이블명 AUTO_INCREMENT = n 으로 다음 시작 값을 변경할 수 있다.
--      단, 현재 컬럼에 존재하는 최대값 이하로는 낮출 수 없다.
--   6. TRUNCATE TABLE 로 모든 행을 삭제하면 AUTO_INCREMENT 값도 초기화된다.
--


-- ============================================================
-- [실습 17] AUTO_INCREMENT
-- ============================================================
--
--  AUTO_INCREMENT 컬럼을 가진 테이블에 데이터를 입력한다.
--  INSERT INTO 테이블명 VALUES (NULL, '이름', 나이);

-- 문제: shopdb2 데이터베이스 선택하기
USE shopdb2;


-- 문제: testTbl1 테이블 삭제하기
DROP TABLE IF EXISTS testTbl1;


-- 문제: testTbl1 테이블 생성하기
CREATE TABLE testTbl1 (
  id       INT AUTO_INCREMENT PRIMARY KEY,
  username CHAR(5),
  age      INT
);


INSERT INTO testTbl1 VALUES (NULL, '홍길동', 25);
INSERT INTO testTbl1 VALUES (NULL, '설현',   22);
INSERT INTO testTbl1 (username, age) VALUES ('하나', 26);


-- 실습 : testTbl1 테이블의 모든 컬럼 조회하기
SELECT * FROM testTbl1;


-- AUTO_INCREMENT 번호 재사용 여부 확인
-- id=2 행을 삭제해도 다음 INSERT는 2를 재사용하지 않는다.


-- 실습 : testTbl1 테이블에서 id 값이 2 인 조건의 데이터 삭제하기
DELETE FROM testTbl1 WHERE id = 2;


-- 실습 : testTbl1 테이블에 다음 데이터 추가하기 -> ('민수', 30)
-- [수정 완료] name -> username 으로 컬럼명 수정
INSERT INTO testTbl1(username, age) VALUES ('민수', 30);


-- 실습 : testTbl1 테이블의 모든 컬럼 조회하기
SELECT * FROM testTbl1;


-- 다음 AUTO_INCREMENT 시작 값 변경
-- 현재 존재하는 최대 id보다 큰 값으로만 의미 있게 변경된다.


-- 실습 : testTbl1 테이블 구조 변경하기
ALTER TABLE testTbl1 AUTO_INCREMENT = 100;


-- 실습 : testTbl1 테이블에 다음 데이터 추가하기 -> ('영희', 28)
-- [수정 완료] name -> username 으로 컬럼명 수정
INSERT INTO testTbl1 (username, age) VALUES ('영희', 28);


-- 실습 : testTbl1 테이블의 모든 컬럼 조회하기
SELECT * FROM testTbl1;


-- 모든 행 삭제 후 AUTO_INCREMENT 처음부터 다시 시작
-- TRUNCATE는 테이블 구조는 유지하고 데이터만 전체 삭제하며, AUTO_INCREMENT도 초기화한다.

-- 실습 : testTbl1 테이블의 전체 데이터 삭제하기(TRUNCATE)
TRUNCATE TABLE testTbl1;


-- 실습 : testTbl1 테이블에 다음 데이터 추가하기 -> ('재시작', 20)
-- [수정 완료] name -> username 으로 컬럼명 수정
INSERT INTO testTbl1 (username, age) VALUES ('재시작', 20);


-- 실습 : testTbl1 테이블의 모든 컬럼 조회하기
SELECT * FROM testTbl1;


-- ============================================================
-- [실습 13] 심화 - 게시글 테이블(tbl_board) 생성
-- ============================================================
--
--  게시판 서비스를 위한 tbl_board 테이블을 생성한다.
--
-- 컬럼 설계:
--   no          : 게시글 ID, INT, AUTO_INCREMENT, PK
--   title       : 제목,     VARCHAR(256), NULL 불가
--   content     : 본문,     TEXT, NULL 허용
--   writer      : 작성자,   VARCHAR(50), NULL 불가
--   reg_date    : 등록일,   DATETIME, NULL 허용
--   update_date : 수정일,   DATETIME, NULL 허용
--
-- 포인트:
--   - AUTO_INCREMENT : 데이터가 추가될 때마다 no 값이 자동으로 1씩 증가
--   - VARCHAR        : 제목, 작성자처럼 길이가 다양한 값에 사용
--   - DATETIME       : 날짜 + 시각 모두 저장 (DATE는 날짜만 저장)
--   - NOW()          : 현재 날짜와 시각을 자동으로 입력하는 함수
--

-- 실습 : tbl_board 테이블 생성하기
CREATE TABLE tbl_board (
    no INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(256) NOT NULL,
    content TEXT,
    writer VARCHAR(50) NOT NULL,
    reg_date DATETIME,
    update_date DATETIME
);


-- 테이블 구조 확인
-- 실습 : tbl_board 테이블 구조 확인하기
DESC tbl_board;


-- 실제 생성된 CREATE TABLE 문 확인
-- PK, AUTO_INCREMENT, NOT NULL, ENGINE 등의 정보를 한 번에 확인할 수 있다.
-- 실습 : tbl_board 테이블의 생성 SQL 확인하기
SHOW CREATE TABLE tbl_board;


-- 샘플 데이터 10건 삽입
-- 실습 : tbl_board 테이블에 다음 데이터 추가하기 
INSERT INTO tbl_board (title, content, writer, reg_date, update_date) VALUES
('테스트 제목1',  '테스트 내용1',   'user00', NOW(), NOW()),
('테스트 제목2',  '테스트 내용2',   'user00', NOW(), NOW()),
('테스트 제목3',  '테스트 내용3',   'user00', NOW(), NOW()),
('테스트 제목4',  '테스트 내용4',   'user00', NOW(), NOW()),
('테스트 제목5',  '테스트 내용5',   'user01', NOW(), NOW()),
('테스트 제목6',  '테스트 내용6',   'user01', NOW(), NOW()),
('테스트 제목7',  '테스트 내용7',   'user02', NOW(), NOW()),
('테스트 제목8',  '테스트 내용8',   'user02', NOW(), NOW()),
('테스트 제목9',  '테스트 내용9',   'user03', NOW(), NOW()),
('테스트 제목10', '테스트 내용10',  'user03', NOW(), NOW());


-- ============================================================
-- [실습 14] tbl_board SELECT 실습
-- ============================================================

-- tbl_board의 모든 데이터 조회
-- 실습 : tbl_board 테이블의 모든 컬럼 조회하기
SELECT * FROM tbl_board;


-- no, title, writer 컬럼만 조회
-- 실습 : tbl_board 테이블에서 no, title, writer 컬럼 조회하기
SELECT no, title, writer FROM tbl_board;


-- 특정 작성자(user00)의 글만 조회
-- 실습 : tbl_board 테이블의 작성자가 'user00'인 모든 컬럼 조회하기 
-- [수정 완료] whiter -> writer 오타 수정
SELECT * FROM tbl_board WHERE writer = 'user00';

-- 3개 SQL 한 번에 실행 (블록 선택 후 번개 클릭)  (또는 Ctrl+Shift+Enter)