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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `category_id` int NOT NULL,
  `product_img` blob,
  `unit` varchar(45) NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `unique` (`product_name`,`category_id`) /*!80000 INVISIBLE */,
  KEY `products_fk2_idx` (`category_id`),
  CONSTRAINT `product_fk1` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Mogra Rice',100,'mogra rice',1,NULL,'1 kg'),(2,'Basmati Rice',120,'basmati rice',1,NULL,'1 kg'),(3,'Mini Mogra Rice',80,'mini mogra rice',1,NULL,'1 kg'),(4,'Fanta',85,'fanta',2,NULL,'2.5 litre'),(5,'Frooti',100,'frooti',2,NULL,'2.5 litre'),(6,'Coca Cola',85,'coca cola',2,NULL,'2.5 litre'),(7,'Masoor Daal',90,'masoor daal',4,NULL,'1 kg'),(8,'Toor Daal',75,'toor daal',4,NULL,'1 kg'),(9,'Chana Daal',95,'chana daal',4,NULL,'1 kg'),(10,'Red Velvet Cake',395,'red velvet cake',5,NULL,'1/2 kg'),(11,'Pineapple Cake',295,'pineapple cake',5,NULL,'1/2 kg'),(12,'Black Forest Cake',345,'black forest cake',5,NULL,'1/2 kg'),(14,' Rich Chocolate Pastry',40,'rich chocolate pastry',7,NULL,'1 piece'),(15,' Choco Truffle Pastry',45,'choco truffle pastry',7,NULL,'1 piece'),(16,' Butterscotch Pastry',40,'butterscotch pastry',7,NULL,'1 piece'),(17,'Kit-Kat Chocolate',40,'kit kat chocolate',9,NULL,'60gm'),(18,'Munch Chocolate',15,'munch chocolate',9,NULL,'45gm'),(19,'DairyMilk-Silk Chocolate',120,'dairymilk-silk chocolate',9,NULL,'145gm'),(20,'Ghadi Detergent Powder',53,'ghadi detergent powder',10,NULL,'1kg'),(21,'Tide Plus Jasmine & rose',786,'Tide Plus Jasmine & rose Detergent Powder -Brand Offer',10,NULL,'7+3=10kg'),(22,'Surf Excel Matic Top Load',650,'Surf Excel Matic Top Load Detergent Powder(Carton) Free 1 kg-Brand Offer',10,NULL,'3+1=4kg'),(23,'Ariel Detergent Powder',562,'Ariel Complete Detergent Powder',10,NULL,'4kg'),(24,'Tide Ultra 3 in 1 Detergent Powder',266,'Tide Ultra 3 in 1 Detergent Powder',10,NULL,'2kg'),(25,'Henko Detergent',402,'Henko Matic Lintelligent Top Load detergent Powder- Buy @kg Get',10,NULL,'2kg+1kg'),(26,'Chakki Atta',290,'Chakki Atta',11,NULL,'10kg'),(27,'Aasharivada  Atta',335,'Aasharivada Shudh Chakki Whole Wheat Atta',11,NULL,'10kg'),(28,'Nature Fresh Sampoorna Atta',345,'Nature Fresh Sampoorna Atta',11,NULL,'10kg'),(29,'Fortune Chakki Atta',333,'Fortune Chakki Fresh Atta',11,NULL,'10kg'),(30,'Organic Tatva Wheat Atta',253,'Organic Tatva Wheat Atta',11,NULL,'5kg'),(31,'Real Fruit Juice Mixed Fruit Juice',168,'Real Fruit Power Mixed Fruit Juice- pack of 2',12,NULL,'2*1=2 litres'),(32,'Tropicana Mixed Fruit Juice',149,'Tropicana Mixed Fruit Delight Juice- pack of 2',12,NULL,'2*1=2 litres'),(33,'Real Fruit Power Masala juice',82,'Real Fruit Power Masala Juice',12,NULL,'1 litre'),(34,'Real Fruit Power Pink Guava Juice',87,'Real Fruit Power Pink Guava Juice',12,NULL,'1 litre'),(35,'Glucon-D Original Energy Drink',101,'Glucon-D Original Energy Drink(Jar)',12,NULL,'500gm'),(36,'Glucon-D Tangy Orange Energy Drink',59,'Glucon-D Tangy Orange Energy Drink(Carton)',12,NULL,'200gm'),(37,'Fortune Soya Health Refined SoyaBean Oil',110,'Fortune Soya Health Refined SoyaBean Oil(Pouch)',13,NULL,'1 litre'),(38,'Fortune Premium kachi Ghani Pure Mustard Oil',124,'Fortune Premium kachi Ghani Pure Mustard Oil(Bottle)',13,NULL,'1 litre'),(39,'Nature Fresh Acti Lite Refined SoyaBean Oil',103,'Nature Fresh Acti Lite Refined SoyaBean Oil(Pouch)',13,NULL,'1 litre'),(40,'Safola Gold Cooking Oil',147,'Safola Gold Pro Healthy Lifestyle Blended Cooking Oil(Pouch)',13,NULL,'1 litre'),(41,'Nature Fresh Acti Lite SunFlower Oil',115,'Nature Fresh Acti Lite SunFlower Oil(Pouch)',13,NULL,'1 litre'),(42,'Pansari Kachi Ghani Mustard Oil',113,'Pansari Kachi Ghani Mustard Oil(Bottle)',13,NULL,'1 litre'),(43,'Pepsodent Toothpaste',100,'Pepsodent Germicheck Cavity Protection ToothPaste',14,NULL,'300 gm'),(44,'Patanjali ToothPaste',127,'Patanjali Dant Kanti Combo Brand Offer ToothPaste',14,NULL,'200gm+100gm+1 unit Toothbrush'),(45,'Closeup Toothpaste',279,'Closeup ever fresh red hot gel Toothpaste-pack of 2',14,NULL,'2*300gm'),(46,'Colgate  Maxfresh ToothPaste',89,'Colgate MaxFresh Peppermint ice Toothpaste',14,NULL,'150 gm'),(47,'Oral-B ToothBrush',96,'Oral-B Cavity defense 123 ToothBrush(Soft)',14,NULL,'6 units'),(48,'Colgate Charcoal Toothpaste',235,'Colgate Total Charcoal Deep clean Toothpaste-pack of 2',14,NULL,'2*185gm'),(49,'Fogg Marco men\'s Deodorant',216,'Fogg Marco men\'s Deodorant',15,NULL,'150ml'),(50,'Engage Ticke Men\'s Deodorant',290,'Engage Ticke Men\'s Deodorant',15,NULL,'220ml'),(51,'Engage Nudge Men\'s Deodorant',290,'Engage Nudge Men\'s Deodorant',15,NULL,'220ml'),(52,'Set Wet Spunky Avatar Men\'s Deodorant',127,'Set Wet Spunky Avatar Men\'s Deodorant',15,NULL,'120ml'),(53,'Set Wet Icy Perfume Spray',47,'Set Wet Icy Perfume Spray Men\'s Deodorant)',15,NULL,'20ml'),(54,'Britannia NutriChoice Digestive Biscuit',106,'Britannia NutriChoice Digestive Hi-Fibre Biscuit-Pack of 2',16,NULL,'2*250gm'),(55,'McVitie\'s Digestive Biscuit',154,'McVitie\'s Digestive Biscuit',16,NULL,'4 unit(150gm/unit)'),(56,'Parle-G Original Gluco Biscuit',67,'Parle-G Original Gluco Biscuit-pack of 14',16,NULL,'800gm'),(57,'Oreo Original Vanilla Creme Biscuit',87,'Oreo Original Vanilla Creme Biscuit-pack of 3',16,NULL,'3*120gm'),(58,'Sunfeast Dark Fantasy Choco Fills Cookie',51,'Sunfeast Dark Fantasy Choco Fills Cookie-Pack of 2)',16,NULL,'2*75gm'),(59,'Catch Compounded Hing Powder',68,'Catch Compounded Hing Powder-50gm pouch',17,NULL,'50gm'),(60,'Everest Red Chilli Powder',36,'Everest Tikhalal Red Chilli Powder',17,NULL,'100gm'),(61,'Catch Sabzi Masala',46,'Catch Sabzi Masala',17,NULL,'100gm'),(62,'Catch Garam Masala',66,'Catch Garam Masala-100 gm pouch',17,NULL,'100gm'),(63,'MDH Butter Chicken Masala',90,'MDH Butter Chicken Masala)',17,NULL,'100gm'),(64,'Uncle Chipps',40,'Uncle Chipps Spicy Treat Chips- pack of 2',27,NULL,'2*55gm'),(65,'Lay\'s Cream And Onion Chips',40,'Lay\'s Potato Cream And Onion Flavr Chips- pack of 2',27,NULL,'2*52gm'),(66,'Lay\'s India\'s Magic Masala Chips',40,'Lay\'s India\'s Magic Masala Chips',27,NULL,'2*45gm'),(67,'Lay\'s Potato Flirty Tomato Tango Chips',70,'Lay\'s Potato Flirty Tomato Tango Chips-pack of 2',27,NULL,'2*90gm'),(68,'Kurkure masala Munch Crisps',40,'Kurkure masala Munch Crisps-pack of 2',27,NULL,'2*95gm'),(69,'Tata Premium Tea',300,'Tata Premium Tea(pouch)-pack of 10',28,NULL,'10*100gm'),(70,'Nescafe Classic Coffee',505,'Nescafe Classic Coffee(Jar)- pack of 2',28,NULL,'2*100gm'),(71,'Broke Bond Taj Mahal Tea',436,'Broke Bond Taj Mahal Tea(Carton)',28,NULL,'1 kg'),(72,'Wagh Bakri Premium Tea(Pouch)',110,'Wagh Bakri Premium Tea(Pouch)-pack of 1',28,NULL,'250gm'),(73,'Tata Gold Tea',120,'Tata Gold Tea (Pouch)',28,NULL,'250gm'),(74,'Mother Dairy Sweet Lassi',60,'Mother Dairy Refreshing Sweet Lassi(Tetra Pack)-pack of 3',20,NULL,'3*200ml'),(75,'Mother Dairy Refreshing Chocolate Milk Shake',60,'Mother Dairy Refreshing Chocolate Milk Shake(Tetra Pack)-pack of 2',20,NULL,'2*200ml'),(76,'Mother Dairy Refreshing Mango Milk Shake',60,'Mother Dairy Refreshing Mango Milk Shake(Tetra Pack)-pack of 2',20,NULL,'2 *200ml'),(77,'Mother Dairy Spiced ButterMilk',12,'Mother Dairy Spiced ButterMilk(Tetra Pack)',20,NULL,'1*200ml'),(78,'Amul kool Cafe Milk \'n\' Coffee Flavoured Milk',30,'Amul kool Cafe Milk \'n\' Coffee Flavoured Milk(Can)',20,NULL,'200ml'),(79,'Amul kool Badam Flavoured Milk',20,'Amul kool Badam Flavoured Milk(Pet Bottle)',20,NULL,'180ml');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-04 19:07:05
