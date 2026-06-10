-- MySQL 내장 함수 실습 스크립트
-- 제어 흐름 / 문자열 / 수학 / 날짜시간 / 형 변환

DROP DATABASE IF EXISTS func_practice;
CREATE DATABASE func_practice;
USE func_practice;

-- height DECIMAL(5,1) : 소수 저장용 데이터 타입, DECIMAL(전체자리수, 소수자리수)
-- 숫자 총 5칸, 소수는 1칸 사용
-- 정수 자리수 + 소수 자리수 = 총 5자리
-- 1234.5, 99.9, 180 가능, 12345.6 불가능
-- 최대 저장 가능 값 = 9999.9

CREATE TABLE memberTBL (
    memberID INT PRIMARY KEY AUTO_INCREMENT,
    memberName VARCHAR(30),
    age INT,
    height DECIMAL(5,1),
    phone VARCHAR(20),
    address VARCHAR(100),
    joinDate DATE,
    point INT,
    grade VARCHAR(10)
);

INSERT INTO memberTBL
(memberName, age, height, phone, address, joinDate, point, grade)
VALUES
('김철수', 25, 175.5, '010-1111-2222', '서울 강남구', '2024-01-15', 1200, 'SILVER'),
('이영희', 31, 162.3, '010-3333-4444', '부산 해운대구', '2023-11-02', 3500, 'GOLD'),
('박민수', 19, 181.0, NULL, '대전 중구', '2025-03-10', 500, 'BRONZE'),
('최지은', 42, 158.8, '010-5555-6666', '인천 남동구', '2022-07-20', 7200, 'VIP'),
('정하늘', 28, 169.4, NULL, '서울 마포구', '2024-09-01', 2100, 'SILVER');

-- 1. 제어 흐름 함수
SELECT
    memberName,
    point,
    IF(point >= 3000, '우수회원', '일반회원') AS 회원구분
FROM memberTBL;

SELECT
    memberName,
    phone,
    IFNULL(phone, '전화번호 없음') AS phone_result
FROM memberTBL;

SELECT
    memberName,
    age,
    CASE
        WHEN age < 20 THEN '10대'
        WHEN age < 30 THEN '20대'
        WHEN age < 40 THEN '30대'
        ELSE '40대 이상'
    END AS age_group
FROM memberTBL;

-- 2. 문자열 함수
SELECT
    memberName,
    CONCAT(memberName, '님') AS name_text,
    CONCAT_WS(' / ', memberName, address, grade) AS member_info
FROM memberTBL;

SELECT
    memberName,
    LENGTH(memberName) AS byte_length,
    CHAR_LENGTH(memberName) AS char_length
FROM memberTBL;

SELECT
    memberName,
    LEFT(phone, 3) AS phone_start,
    RIGHT(phone, 4) AS phone_end
FROM memberTBL
WHERE phone IS NOT NULL;

SELECT
    memberName,
    address,
    REPLACE(address, '서울', 'SEOUL') AS changed_address
FROM memberTBL;

SELECT
    memberName,
    SUBSTRING(address, 1, 2) AS region
FROM memberTBL;

SELECT
    TRIM('   MySQL 함수 실습   ') AS trim_result;

-- 3. 수학 함수
SELECT
    memberName,
    height,
    ROUND(height, 0) AS rounded_height,
    CEIL(height) AS ceil_height,
    FLOOR(height) AS floor_height
FROM memberTBL;

SELECT
    memberName,
    point,
    MOD(point, 1000) AS point_remainder,
    SQRT(point) AS sqrt_point
FROM memberTBL;

SELECT
    ABS(-100) AS abs_result,
    POW(2, 3) AS pow_result,
    RAND() AS random_value,
    SIGN(-30) AS sign_result;

-- 4. 날짜 및 시간 함수
SELECT
    CURDATE() AS today,
    CURTIME() AS current_time,
    NOW() AS now_time,
    SYSDATE() AS sys_time;

SELECT
    memberName,
    joinDate,
    DATEDIFF(CURDATE(), joinDate) AS 가입후_지난일수
FROM memberTBL;

SELECT
    memberName,
    joinDate,
    DATE_ADD(joinDate, INTERVAL 100 DAY) AS 가입_100일후,
    DATE_SUB(joinDate, INTERVAL 30 DAY) AS 가입_30일전
FROM memberTBL;

SELECT
    memberName,
    joinDate,
    YEAR(joinDate) AS 가입연도,
    MONTH(joinDate) AS 가입월,
    DAY(joinDate) AS 가입일
FROM memberTBL;

SELECT
    LAST_DAY(CURDATE()) AS 이번달_마지막날;

-- 5. 형 변환 함수
SELECT
    CAST('2025-05-20' AS DATE) AS cast_date,
    CAST('12345' AS UNSIGNED) AS cast_number,
    CAST(12345 AS CHAR) AS cast_char;

SELECT
    CONVERT('2025-05-20', DATE) AS convert_date,
    CONVERT(12345, CHAR) AS convert_char;

-- 6. 실무형 조회 예제
SELECT
    memberName,
    grade,
    point,
    CASE
        WHEN point >= 7000 THEN '최우수 고객'
        WHEN point >= 3000 THEN '우수 고객'
        WHEN point >= 1000 THEN '일반 고객'
        ELSE '신규 고객'
    END AS customer_level
FROM memberTBL
ORDER BY point DESC;

SELECT
    memberName,
    IFNULL(phone, '미등록') AS phone,
    CONCAT(SUBSTRING(address, 1, 2), ' 지역 회원') AS region_label,
    DATEDIFF(CURDATE(), joinDate) AS active_days
FROM memberTBL
ORDER BY active_days DESC;