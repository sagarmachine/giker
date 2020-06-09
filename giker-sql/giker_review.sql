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
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `giver_code` varchar(100) NOT NULL,
  `rating_taker` int NOT NULL,
  `feedback_taker` varchar(100) DEFAULT NULL,
  `rating_giver` int NOT NULL,
  `feedback_giver` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `review_fk2_idx` (`giver_code`),
  KEY `review_fk1` (`user_name`),
  CONSTRAINT `review_fk1` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`),
  CONSTRAINT `review_fk2` FOREIGN KEY (`giver_code`) REFERENCES `user_sub_service` (`giver_code`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (3,'user','sagarmachine_COOKING_TUTOR',4,'alrighty  !! ',4,'i remember you '),(4,'xxx','sagarmachine_CALISTHENIC_COACH',4,'lralalra',3,'aedef'),(5,'xxx','sagarmachine_DANCE_TUTOR',4,'fvvrgv',4,'asdasd'),(6,'user','nikhil@_COOKING_TUTOR',2,'YeavWTF ??',4,'wtf !?'),(7,'sagarmachine','nikhil@_COOKING_TUTOR',5,'dfvadvadf',4,'Vsfvf'),(8,'xxx','nikhil@_COOKING_TUTOR',4,'shal lal slala',2,'dWWEF'),(9,'nikhil@','sagarmachine_COOKING_TUTOR',3,'',2,'jhjn'),(10,'sagarmachine','nikhil@_DANCE_TUTOR',4,'sfvaav',4,''),(11,'nikhil@','sagarmachine_BIO_EDUCATION',5,'oidckjs sdvns',3,'kjdniu sdjci sdjci '),(12,'nikhil@','Dr. Strange_CALISTHENIC_COACH',4,'sdcsV',0,NULL);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
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
