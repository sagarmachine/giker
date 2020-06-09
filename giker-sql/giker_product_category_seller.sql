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
-- Table structure for table `product_category_seller`
--

DROP TABLE IF EXISTS `product_category_seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category_seller` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sub_service` varchar(100) NOT NULL,
  `product_category` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_1_idx` (`product_category`),
  CONSTRAINT `fk_1` FOREIGN KEY (`product_category`) REFERENCES `product_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category_seller`
--

LOCK TABLES `product_category_seller` WRITE;
/*!40000 ALTER TABLE `product_category_seller` DISABLE KEYS */;
INSERT INTO `product_category_seller` VALUES (1,'GROCERY_SHOP',1),(2,'GROCERY_SHOP',2),(3,'GROCERY_SHOP',4),(4,'GROCERY_SHOP',9),(5,'BAKERY_SHOP',2),(6,'BAKERY_SHOP',5),(7,'BAKERY_SHOP',7),(8,'BAKERY_SHOP',9),(9,'GROCERY_SHOP',10),(10,'GROCERY_SHOP',11),(11,'GROCERY_SHOP',12),(12,'GROCERY_SHOP',13),(13,'GROCERY_SHOP',14),(14,'GROCERY_SHOP',15),(15,'GROCERY_SHOP',16),(16,'GROCERY_SHOP',17),(17,'GROCERY_SHOP',18),(18,'GROCERY_SHOP',19),(19,'GROCERY_SHOP',20),(20,'GROCERY_SHOP',21),(21,'GROCERY_SHOP',22),(22,'GROCERY_SHOP',23),(23,'GROCERY_SHOP',24),(24,'GROCERY_SHOP',25),(25,'GROCERY_SHOP',26),(26,'GROCERY_SHOP',27),(27,'GROCERY_SHOP',28),(28,'GROCERY_SHOP',30),(29,'GROCERY_SHOP',31);
/*!40000 ALTER TABLE `product_category_seller` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-04 19:07:12
