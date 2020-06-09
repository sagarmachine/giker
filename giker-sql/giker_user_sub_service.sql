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
-- Table structure for table `user_sub_service`
--

DROP TABLE IF EXISTS `user_sub_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_sub_service` (
  `giver_code` varchar(100) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `sub_service_code` varchar(45) NOT NULL,
  `status` enum('A','I') NOT NULL DEFAULT 'A',
  `date` date NOT NULL,
  `city_id` int NOT NULL,
  `location` varchar(45) NOT NULL,
  `description` varchar(100) NOT NULL,
  `achievement` varchar(100) DEFAULT NULL,
  `experience` varchar(30) NOT NULL,
  `instagram` varchar(45) DEFAULT NULL,
  `pincode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`giver_code`),
  KEY `user_sub_service_fk1_idx` (`user_name`),
  KEY `user_sub_service_fk2_idx` (`sub_service_code`),
  KEY `user_sub_service_fk4_idx` (`city_id`),
  CONSTRAINT `user_sub_service_fk1` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`),
  CONSTRAINT `user_sub_service_fk2` FOREIGN KEY (`sub_service_code`) REFERENCES `sub_service` (`code`),
  CONSTRAINT `user_sub_service_fk4` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_sub_service`
--

LOCK TABLES `user_sub_service` WRITE;
/*!40000 ALTER TABLE `user_sub_service` DISABLE KEYS */;
INSERT INTO `user_sub_service` VALUES ('Dr. Strange_CALISTHENIC_COACH','Dr. Strange','CALISTHENIC_COACH','A','2020-04-29',6,'951','6 weeks + 2 ','','3-5 years','34cali','23401 201301'),('Dr. Strange_GYM_COACH','Dr. Strange','GYM_COACH','A','2020-04-30',5,'93B','dddddd','aaaaa','0-1 years','aditya madaan','201301'),('nikhil@_COOKING_TUTOR','nikhil@','COOKING_TUTOR','A','2020-04-29',5,'93B','you\'ll be awsome','','1-3 years','Cooker','201301'),('nikhil@_DANCE_TUTOR','nikhil@','DANCE_TUTOR','A','2020-04-30',6,'qweqwe','dsasd','ads','0-1 years','Sagar Panwar','248001'),('nikhil@_GROCERY_SHOP','nikhil@','GROCERY_SHOP','A','2020-05-11',5,'delta-1','jjjjjjjj',NULL,'0-1 years','wesdaf','201308'),('sagarmachine_BIO_EDUCATION','sagarmachine','BIO_EDUCATION','A','2020-04-29',6,'123','DESAS','','0-1 years','Sagar Panwar','248001'),('sagarmachine_CALISTHENIC_COACH','sagarmachine','CALISTHENIC_COACH','A','2020-04-29',6,'93B','4 week programe','23 AK ','5-10 years','calisworld23','248001'),('sagarmachine_COOKING_TUTOR','sagarmachine','COOKING_TUTOR','I','2020-04-29',6,'98W','pakak','','3-5 years','we@','133302'),('sagarmachine_DANCE_TUTOR','sagarmachine','DANCE_TUTOR','A','2020-05-01',6,'96MN','BOOM','NONE','5-10 years','Sagar Panwar','248001'),('test_GROCERY_SHOP','test','GROCERY_SHOP','A','2020-05-14',6,'Gheja','gheja ke raja ki dukaan',NULL,'0-1 years','kkj2','201301');
/*!40000 ALTER TABLE `user_sub_service` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-04 19:07:08
