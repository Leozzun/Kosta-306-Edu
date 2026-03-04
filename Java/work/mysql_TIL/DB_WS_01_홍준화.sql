-- MySQL dump 10.13  Distrib 8.0.45, for macos15 (arm64)
--
-- Host: 127.0.0.1    Database: exam
-- ------------------------------------------------------
-- Server version	9.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ROOM`
--

DROP TABLE IF EXISTS `ROOM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ROOM` (
  `room_code` int NOT NULL,
  `room_max_count` int NOT NULL,
  PRIMARY KEY (`room_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROOM`
--

LOCK TABLES `ROOM` WRITE;
/*!40000 ALTER TABLE `ROOM` DISABLE KEYS */;
INSERT INTO `ROOM` VALUES (901,34),(902,35),(903,25),(904,32),(905,30),(906,35);
/*!40000 ALTER TABLE `ROOM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Student` (
  `student_code` int NOT NULL,
  `student_name` varchar(12) NOT NULL,
  `student_resident_number` varchar(14) NOT NULL,
  `student_phone` varchar(14) NOT NULL,
  `student_address` varchar(50) DEFAULT NULL,
  `student_email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`student_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES (1,'김현진','771212-2346111','017-888-8888','부산','aaa@hanmail.net'),(2,'김석주','720112-1234812','016-999-9999','경기','bbb@hanmail.net'),(3,'고훈기','730102-1555555','017-555-5555','서울','ccc@hanmail.net'),(4,'유민경','801111-2222222','017-222-2222','전남','ddd@hanmail.net'),(5,'김영수','811231-1777777','017-777-7777','충주','eee@hanmail.net'),(6,'박상원','790915-1333333','017-333-3333','강원','fff@hanmail.net');
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Subject`
--

DROP TABLE IF EXISTS `Subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Subject` (
  `subject_code` varchar(5) NOT NULL,
  `subject_name` varchar(20) NOT NULL,
  PRIMARY KEY (`subject_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Subject`
--

LOCK TABLES `Subject` WRITE;
/*!40000 ALTER TABLE `Subject` DISABLE KEYS */;
INSERT INTO `Subject` VALUES ('j1001','sql'),('j1002','Win2000'),('j1003','ASP'),('j1004','Php'),('j1005','java'),('j1006','javascript');
/*!40000 ALTER TABLE `Subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SuGang`
--

DROP TABLE IF EXISTS `SuGang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SuGang` (
  `student_code` int NOT NULL,
  `subject_code` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`student_code`),
  KEY `subject_code` (`subject_code`),
  CONSTRAINT `sugang_ibfk_1` FOREIGN KEY (`student_code`) REFERENCES `Student` (`student_code`),
  CONSTRAINT `sugang_ibfk_2` FOREIGN KEY (`subject_code`) REFERENCES `Subject` (`subject_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SuGang`
--

LOCK TABLES `SuGang` WRITE;
/*!40000 ALTER TABLE `SuGang` DISABLE KEYS */;
INSERT INTO `SuGang` VALUES (1,'j1001'),(2,'j1002'),(3,'j1003'),(4,'j1004'),(5,'j1005'),(6,'j1006');
/*!40000 ALTER TABLE `SuGang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SugangTB`
--

DROP TABLE IF EXISTS `SugangTB`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SugangTB` (
  `subject_code` varchar(5) NOT NULL,
  `room_code` int DEFAULT NULL,
  `time` int NOT NULL,
  `teacher_code` int DEFAULT NULL,
  PRIMARY KEY (`subject_code`),
  KEY `room_code` (`room_code`),
  KEY `teacher_code` (`teacher_code`),
  CONSTRAINT `sugangtb_ibfk_1` FOREIGN KEY (`subject_code`) REFERENCES `Subject` (`subject_code`),
  CONSTRAINT `sugangtb_ibfk_2` FOREIGN KEY (`room_code`) REFERENCES `ROOM` (`room_code`),
  CONSTRAINT `sugangtb_ibfk_3` FOREIGN KEY (`teacher_code`) REFERENCES `Teacher` (`teacher_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SugangTB`
--

LOCK TABLES `SugangTB` WRITE;
/*!40000 ALTER TABLE `SugangTB` DISABLE KEYS */;
INSERT INTO `SugangTB` VALUES ('j1001',901,2,1),('j1002',902,2,2),('j1003',903,2,3),('j1004',904,2,4),('j1005',905,2,5),('j1006',906,2,6);
/*!40000 ALTER TABLE `SugangTB` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teacher`
--

DROP TABLE IF EXISTS `Teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Teacher` (
  `teacher_code` int NOT NULL,
  `teacher_name` varchar(12) NOT NULL,
  `teacher_resident_number` varchar(14) NOT NULL,
  `teacher_phone` varchar(14) NOT NULL,
  `teacher_address` varchar(50) DEFAULT NULL,
  `teacher_email` varchar(20) DEFAULT NULL,
  `subject_code` varchar(5) NOT NULL,
  PRIMARY KEY (`teacher_code`),
  KEY `subject_code` (`subject_code`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`subject_code`) REFERENCES `Subject` (`subject_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teacher`
--

LOCK TABLES `Teacher` WRITE;
/*!40000 ALTER TABLE `Teacher` DISABLE KEYS */;
INSERT INTO `Teacher` VALUES (1,'홍길동','700918-1622011','031-295-1234','성남시 중원구 신흥동','kkk@jok.or.kr','j1001'),(2,'유관순','710419-2018916','02-345-2345','서울 강남구 개포동','kkk@jok.or.kr','j1002'),(3,'이승복','730112-1344911','031-1234-6789','서울시 강남구 논현동','sss@jok.or.kr','j1003'),(4,'모택동','730301-1167623','031-567-5678','서울시 서초구 서초동','mmm@jok.or.kr','j1004'),(5,'주롱지','730322-2037921','031-789-3456','서울시 강서구 가양동','xxx@jok.or.kr','j1005'),(6,'이순신','731122-1646213','031-234-8901','서울시 강북구 미아동','ppp@jok.or.kr','j1006');
/*!40000 ALTER TABLE `Teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-02 14:59:26
