-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        8.0.23 - MySQL Community Server - GPL
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- idus 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `idus` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `idus`;

-- 테이블 idus.customer 구조 내보내기
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_idx` int NOT NULL AUTO_INCREMENT COMMENT '회원 idx',
  `customer_name` varchar(20) NOT NULL COMMENT '회원 이름',
  `customer_nick_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '회원 별명',
  `customer_phone_number` varchar(20) NOT NULL COMMENT '회원 전화번호',
  `customer_pwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '회원 비밀번호',
  `customer_email` varchar(100) NOT NULL COMMENT '회원 이메일',
  `customer_gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '회원 성별',
  `customer_role` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '회원 권한',
  PRIMARY KEY (`customer_idx`),
  UNIQUE KEY `customer_email` (`customer_email`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='회원 속성 테이블';

-- 내보낼 데이터가 선택되어 있지 않습니다.

-- 테이블 idus.customer_orders 구조 내보내기
CREATE TABLE IF NOT EXISTS `customer_orders` (
  `order_idx` int NOT NULL AUTO_INCREMENT COMMENT '주문번호',
  `order_product_name` varchar(100) NOT NULL COMMENT '제품명',
  `order_date` datetime NOT NULL COMMENT '결제일시',
  `order_customer_idx` int NOT NULL COMMENT '주문 고객번호',
  PRIMARY KEY (`order_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='주문 속성';

-- 내보낼 데이터가 선택되어 있지 않습니다.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
