-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: giker
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request` (
  `code` varchar(200) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `giver_code` varchar(100) NOT NULL,
  `request_status` enum('P','A','D') NOT NULL DEFAULT 'P',
  `review_status_taker` enum('Y','N') NOT NULL DEFAULT 'N',
  `date` date NOT NULL,
  `message1` varchar(200) DEFAULT NULL,
  `message2` varchar(200) DEFAULT NULL,
  `review_status_giver` enum('Y','N') NOT NULL DEFAULT 'N',
  `accept_date` date DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `request_fk1_idx` (`user_name`),
  KEY `request_fk2_idx` (`giver_code`),
  CONSTRAINT `request_fk1` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`),
  CONSTRAINT `request_fk2` FOREIGN KEY (`giver_code`) REFERENCES `user_sub_service` (`giver_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES ('nikhil@_Dr. Strange_CALISTHENIC_COACH','nikhil@','Dr. Strange_CALISTHENIC_COACH','A','Y','2020-05-03','czzf  dgetg','instagram_email_phone','N','2020-05-03'),('nikhil@_sagarmachine_BIO_EDUCATION','nikhil@','sagarmachine_BIO_EDUCATION','A','Y','2020-05-05','hjb;kzv;k as/kfv','instagram_phone','Y','2020-05-05'),('nikhil@_sagarmachine_COOKING_TUTOR','nikhil@','sagarmachine_COOKING_TUTOR','A','Y','2020-05-02','sdcSCvf','instagram_email_phone','Y','2020-05-02'),('nikhil@_sagarmachine_DANCE_TUTOR','nikhil@','sagarmachine_DANCE_TUTOR','P','N','2020-05-03','wal wala','instagram_email_phone','N',NULL),('sagarmachine_nikhil@_COOKING_TUTOR','sagarmachine','nikhil@_COOKING_TUTOR','A','Y','2020-05-02','sdafasff','instagram_email','Y','2020-05-02'),('sagarmachine_nikhil@_DANCE_TUTOR','sagarmachine','nikhil@_DANCE_TUTOR','A','Y','2020-05-02','errferfqrf','instagram_email_phone','Y','2020-05-02'),('sagarmachine_sagarmachine_COOKING_TUTOR','sagarmachine','sagarmachine_COOKING_TUTOR','D','N','2020-04-30','Heyoo wasap','instagram_email_phone','N','2020-05-01'),('user_Dr. Strange_CALISTHENIC_COACH','user','Dr. Strange_CALISTHENIC_COACH','P','N','2020-05-01','i want to be strong','instagram_email_phone','N',NULL),('user_Dr. Strange_GYM_COACH','user','Dr. Strange_GYM_COACH','P','N','2020-05-01','damn wont to strong,want to strong','instagram_email','N',NULL),('user_nikhil@_COOKING_TUTOR','user','nikhil@_COOKING_TUTOR','A','Y','2020-04-30','Heya i want to cook ','instagram_email_phone','Y','2020-05-02'),('user_sagarmachine_BIO_EDUCATION','user','sagarmachine_BIO_EDUCATION','D','N','2020-04-30','heya bio','instagram','N','2020-05-01'),('user_sagarmachine_COOKING_TUTOR','user','sagarmachine_COOKING_TUTOR','A','Y','2020-05-02','again 222','instagram_email_phone','Y','2020-05-02'),('xxx_Dr. Strange_CALISTHENIC_COACH','xxx','Dr. Strange_CALISTHENIC_COACH','P','N','2020-05-01','xxx','instagram_email_phone','N',NULL),('xxx_Dr. Strange_GYM_COACH','xxx','Dr. Strange_GYM_COACH','P','N','2020-05-01','xxxo','instagram_email','N',NULL),('xxx_nikhil@_COOKING_TUTOR','xxx','nikhil@_COOKING_TUTOR','A','Y','2020-05-01','xoxioxio','instagram_phone','Y','2020-05-02'),('xxx_sagarmachine_CALISTHENIC_COACH','xxx','sagarmachine_CALISTHENIC_COACH','A','N','2020-05-02','dbvdgvg','instagram_email_phone','Y','2020-05-02'),('xxx_sagarmachine_COOKING_TUTOR','xxx','sagarmachine_COOKING_TUTOR','P','N','2020-05-02','dsfvsa refr efef ','instagram_email_phone','N',NULL),('xxx_sagarmachine_DANCE_TUTOR','xxx','sagarmachine_DANCE_TUTOR','A','Y','2020-05-02','remember','instagram_email','Y','2020-05-02');
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-04 19:07:10
