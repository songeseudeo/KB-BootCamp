-- 확실하게 shopdb2 데이터베이스를 선택하고 진행합니다.
-- (만약 shopdb2가 없다면 새로 생성합니다)
CREATE DATABASE IF NOT EXISTS shopdb2;
USE shopdb2;

-- 혹시 기존에 잘못 만들어진 테이블이 있다면 삭제하고 초기화합니다.
DROP TABLE IF EXISTS `buyTBL`;
DROP TABLE IF EXISTS `userTBL`;
DROP TABLE IF EXISTS `memberTBL`;
DROP TABLE IF EXISTS `productTBL`;

-- 1. userTBL 생성
CREATE TABLE `userTBL` (
	`userName`	varchar(3)	NOT NULL	COMMENT '고객이름, 실제로는 256글자로 설정',
	`birthYear`	int	NULL,
	`addr`	varchar(2)	NULL,
	`mobile`	varchar(12)	NOT NULL
);

-- 2. buyTBL 생성
CREATE TABLE `buyTBL` (
	`userName`	varchar(3)	NOT NULL	COMMENT '고객이름, 실제로는 256글자로 설정',
	`prodName`	varchar(3)	NULL,
	`price`	int	NULL,
	`amount`	int	NULL
);

-- 기본키(PK) 및 외래키(FK) 제약조건 설정
ALTER TABLE `userTBL` ADD CONSTRAINT `PK_USERTBL` PRIMARY KEY (
	`userName`
);

ALTER TABLE `buyTBL` ADD CONSTRAINT `PK_BUYTBL` PRIMARY KEY (
	`userName`
);

ALTER TABLE `buyTBL` ADD CONSTRAINT `FK_userTBL_TO_buyTBL_1` FOREIGN KEY (
	`userName`
)
REFERENCES `userTBL` (
	`userName`
);

-- 3. memberTBL 생성
CREATE TABLE `memberTBL` (
	`memberID`	varchar(256)	NOT NULL,
	`memberName`	varchar(500)	NULL,
	`memberAddress`	varchar(500)	NULL
);

-- 4. productTBL 생성
CREATE TABLE `productTBL` (
	`productName`	varchar(500)	NOT NULL,
	`cost`	int	NULL,
	`makeDate`	varchar(500)	NULL,
	`company`	varchar(500)	NULL,
	`amount`	int	NULL
);

ALTER TABLE `memberTBL` ADD CONSTRAINT `PK_MEMBERTBL` PRIMARY KEY (
	`memberID`
);

ALTER TABLE `productTBL` ADD CONSTRAINT `PK_PRODUCTTBL` PRIMARY KEY (
	`productName`
);buytbl