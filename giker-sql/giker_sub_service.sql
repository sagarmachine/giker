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
-- Table structure for table `sub_service`
--

DROP TABLE IF EXISTS `sub_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_service` (
  `code` varchar(30) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `service_code` varchar(45) NOT NULL,
  `image_src` varchar(45) DEFAULT NULL,
  `keyword` varchar(500) DEFAULT NULL,
  `givers` int NOT NULL,
  PRIMARY KEY (`code`),
  KEY `catgory_fk1_idx` (`service_code`),
  CONSTRAINT `catgory_fk1` FOREIGN KEY (`service_code`) REFERENCES `service` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_service`
--

LOCK TABLES `sub_service` WRITE;
/*!40000 ALTER TABLE `sub_service` DISABLE KEYS */;
INSERT INTO `sub_service` VALUES ('BAKERY_SHOP','bakery shop','cakes , pastries you know ','SHOP','/slider/bakery.jpg',NULL,0),('BIO_EDUCATION','biology tutor','all levels of biology','EDUCATION','/slider/bio.jpg','biology,bio,science',1),('CALISTHENIC_COACH','calisthanic coach','calisthanic coachs','COACH','/slider/calisthenics.jpg','calisthenics , bodybuilding',2),('CHEM_EDUCATION','chemistry tutor','all levels of chemistry','EDUCATION','/slider/chem.jpg','chem,chemistry,science',0),('COOKING_TUTOR','cooking tutor','cooking tutors','TUTOR','/slider/cook.jpg','food,recepie,cook,cooking tutor',2),('DANCE_TUTOR','dance tutor','all category of dance styles','TUTOR','/slider/dance.jpg','dance tutor,hip hop,move,music,dancing tutor',2),('FOOTBALL_COACH','football coach','football coaches only','COACH','/slider/football.jpg','football coach,foot ball coach, soccer coach,sports',0),('GROCERY_SHOP','grocery shop','Daily household items ','SHOP','/slider/grocery.jpg',NULL,2),('GYM_COACH','gymcoach coach','gym coaches only','COACH','/slider/gym.jpg','workout,exercise,training,gym coach,sports',1),('MATHS_EDUCATION','maths tutor','all level of mathematics','EDUCATION','/slider/math.jpg','mathematics,maths,math,',0),('MMA_COACH','mma coach','mma coachs','COACH','/slider/mma.jpg','mma coach, strong exercise boxing fighting  , bodybuilding',0),('PAINTING_TUTOR','painting tutor','painting tutors','TUTOR','/slider/paint.jpg','art,drawing tutor,paint tutor,painting,sketch tutor,colouring,coloring tutor',0),('RUGBY_COACH','rugby coach','rugby coaches only','COACH','/slider/rugby.jpg','rugby coach,american football,sports',0),('SINGING_TUTOR','singing tutor','all style of music','TUTOR','/slider/sing.jpg','music tutor,sing,singing,sound,vocal',0),('SPORTS_SHOP','sports shop','All kinda sport\'s equipments','SHOP','/slider/sports.jpg',NULL,0);
/*!40000 ALTER TABLE `sub_service` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-04 19:07:06
