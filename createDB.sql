CREATE DATABASE  IF NOT EXISTS `carparts` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `carparts`;

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `image` varchar(50) NOT NULL DEFAULT 'no_image.jpg',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Courroies','courroie.jpg'),(2,'Rotules','rotule.jpg'),(3,'Filtres','no_image.jpg'),(4,'Suspensions','suspension.jpg'),(5,'Transmissions','no_image.jpg'),(6,'Disques de frein','no_image.jpg'),(7,'Plaquettes de frein','no_image.jpg'),(8,'Batteries','no_image.jpg'),(9,'Ampoules','no_image.jpg');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `price` float(10,2) NOT NULL,
  `quantity_left` int NOT NULL,
  `is_salable` tinyint(1) DEFAULT NULL,
  `description` varchar(500) NOT NULL,
  `category_id` int NOT NULL,
  `image` varchar(50) NOT NULL DEFAULT 'no_image.png',
  PRIMARY KEY (`id`),
  KEY `FK_ProductCategory` (`category_id`),
  CONSTRAINT `FK_ProductCategory` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Jeu de 2 disques de frein ','Valeo',44.39,78,1,'Côté d\'assemblage : Essieu avant<br/>Type de disque de frein : ventilé<br/>Diamètre [mm] : 286<br/>Épaisseur du disque de frein [mm] : 22<br/>Nombre de trous : 5<br/>Hauteur [mm] : 52<br/>à partir d\'année de construction : 01/2003<br/>jusque année de construction : 03/2004<br/>Diamètre du centrage [mm] : 79<br/>Montage Essieu : avant',6,'frein.jpg'),(2,'Jeu de 2 disques de frein  (Réf : 562103JC )','Jurid',87.89,17,1,'Côté d\'assemblage Essieu : avant<br/>Type de disque de frein : ventilé<br/>Diamètre [mm] : 280<br/>Épaisseur du disque de frein [mm] : 24<br/>Nombre de trous : 4<br/>Hauteur [mm] : 44<br/>Diamètre du centrage [mm] : 61<br/>Protection anticorrosion : revêtu<br/>Accessoires avec : vis/boulons<br/>Montage Essieu : avant',6,'frein.jpg'),(3,'Jeu de 2 disques de frein  (Réf : 562430JC )','Jurid',139.90,0,1,'Côté d\'assemblage Essieu : avant<br/>Type de disque de frein : ventilé<br/>Diamètre [mm] : 295<br/>Épaisseur du disque de frein [mm] : 26<br/>Nombre de trous : 5<br/>Hauteur [mm] : 50<br/>Diamètre du centrage [mm] : 62<br/>Protection anticorrosion : revêtu<br/>Accessoires : sans vis/boulons<br/>Montage Essieu : avant',6,'frein.jpg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `email` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone_number` varchar(200) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `AUTHORITIES` varchar(500) DEFAULT NULL,
  `NON_EXPIRED` tinyint(1) DEFAULT NULL,
  `NON_LOCKED` tinyint(1) DEFAULT NULL,
  `CREDENTIALS_NON_EXPIRED` tinyint(1) DEFAULT NULL,
  `ENABLED` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('a.b@c.com','phil','dfds','$2a$10$3MvNHZMaCAq08ZDYmv0x/uL2yvAWrqb1A8Z1mUYsGICJ32WOyBdnK','+336458963',0,'1998-05-27','ROLE_USER',1,1,1,1),('lockman.arnaud@hotmail.com','Lockman','Arnaud','$2a$10$12dpmossS5JuDt4.1oQfROtOgV5Xs/5KdO75rwO/NwEcp7r.xM/Oy','0474025605',0,'2001-02-06','ROLE_USER',1,1,1,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


