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
-- Table structure for table `oorder`
--

DROP TABLE IF EXISTS `oorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oorder` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `giver_code` varchar(45) NOT NULL,
  `date` datetime NOT NULL,
  `datee` date NOT NULL,
  `status` enum('P','C','D') NOT NULL DEFAULT 'P',
  `mode` varchar(45) NOT NULL DEFAULT 'Pickup',
  `delivery_address_id` int DEFAULT NULL,
  `contact_no` int NOT NULL,
  `total_price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_fk1_idx` (`user_id`),
  KEY `orders_fk2_idx` (`giver_code`),
  KEY `orders_fk3_idx` (`delivery_address_id`),
  KEY `orders_fk4_idx` (`contact_no`),
  CONSTRAINT `order_fk1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_name`),
  CONSTRAINT `orders_fk2` FOREIGN KEY (`giver_code`) REFERENCES `seller` (`giver_code`),
  CONSTRAINT `orders_fk3` FOREIGN KEY (`delivery_address_id`) REFERENCES `user_address` (`id`),
  CONSTRAINT `orders_fk4` FOREIGN KEY (`contact_no`) REFERENCES `user_phone` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oorder`
--

LOCK TABLES `oorder` WRITE;
/*!40000 ALTER TABLE `oorder` DISABLE KEYS */;
INSERT INTO `oorder` VALUES (1,'nikhil@','test_GROCERY_SHOP','2020-05-16 13:43:26','2020-05-16','C','Pickup',1,1,250);
/*!40000 ALTER TABLE `oorder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-04 19:07:11
