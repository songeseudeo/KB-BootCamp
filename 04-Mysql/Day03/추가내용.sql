SELECT userID AS '사용자 아이디', SUM(amount * price) AS '총 구매액'
FROM buytbl
GROUP BY userID;

SELECT groupName AS '분류',
       SUM(price * amount) AS '비용'
FROM buytbl
GROUP BY groupName
WITH ROLLUP;  -- 분류별 합계 + 전체 총합

SELECT num, groupName, SUM(price * amount) AS '비용'
FROM buytbl
GROUP BY groupName, num -- GROUP BY의 오른쪽 컬럼부터 제거하면서 합계(소계)를 생성
WITH ROLLUP; -- 구매번호별 금액 + 분류별 소계 + 전체 총합

SELECT
    num,
    groupName,
    SUM(price * amount) AS '비용',
    CASE
        WHEN groupName IS NULL AND num IS NULL THEN '총 합계'
        WHEN num IS NULL                       THEN '분류별 소계'
        ELSE '구매번호별 금액'
    END AS 구분
FROM buytbl
GROUP BY groupName, num
WITH ROLLUP;

SELECT
  productName,
  company,
  cost,
  ROW_NUMBER() OVER (ORDER BY cost DESC) AS price_rank
FROM productTBL;

SELECT
  productName,
  company,
  cost,
  ROW_NUMBER() OVER (PARTITION BY company ORDER BY cost DESC) AS company_price_rank
FROM productTBL
WHERE company IS NOT NULL;

DROP TABLE IF EXISTS memberNameOnly;

-- 기존 테이블 삭제
DROP TABLE IF EXISTS productTBL;

-- 상품 테이블 생성
CREATE TABLE productTBL (
  productID   INT AUTO_INCREMENT PRIMARY KEY,
  productName CHAR(20) NOT NULL,
  cost        INT      NOT NULL,
  makeDate    DATE,
  company     CHAR(10),
  amount      INT      NOT NULL
);

-- 데이터 추가
INSERT INTO productTBL(productName, cost, makeDate, company, amount)
VALUES
('컴퓨터', 100, '2025-01-01', '삼성', 5),
('세탁기', 80, '2025-01-03', 'LG', 3),
('냉장고', 120, '2025-01-05', 'LG', 8),
('모니터', 20, '2025-01-07', '삼성', 15),
('키보드', 5, '2025-01-10', '한성', 30),
('마우스', 3, '2025-01-11', '로지텍', 50),
('노트북', 150, '2025-01-15', '삼성', 7),
('태블릿', 70, '2025-01-18', '애플', 4);

-- 실습 : WITH(CTE)를 사용하여 가격이 10 이상이고 수량이 10 이상인 상품의 총 금액 조회하기

WITH
  highCostProduct AS (
    SELECT productName, cost
    FROM productTBL
    WHERE cost >= 10
  ),
  manyStockProduct AS (
    SELECT productName, amount
    FROM productTBL
    WHERE amount >= 10
  )
SELECT *
FROM highCostProduct;

-- 실습 : 여러 개의 WITH(CTE)를 동시에 정의하고 그중 가격이 10 이상인 상품 조회하기

WITH productSummary AS (
  SELECT 
         productName,
         cost,
         amount,
         cost * amount AS totalPrice
  FROM productTBL
  WHERE cost >= 10
    AND amount >= 10
)

SELECT *
FROM productSummary;