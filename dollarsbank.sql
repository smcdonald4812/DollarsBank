CREATE DATABASE  IF NOT EXISTS `dollarsbank` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dollarsbank`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dollarsbank
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customerId` int NOT NULL,
  `amount` float NOT NULL DEFAULT '0',
  `dateCreated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `type` enum('CHECKING','SAVINGS','OTHER') NOT NULL DEFAULT 'OTHER',
  `visible` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `customerId_idx` (`customerId`),
  CONSTRAINT `customerId` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,1,5000,'2020-07-29 12:24:05','CHECKING',1),(2,1,97107.7,'2020-07-29 12:24:05','SAVINGS',1),(3,2,801.22,'2020-07-29 12:24:05','CHECKING',1),(4,2,726.37,'2020-07-29 12:24:05','SAVINGS',1),(5,3,1833.47,'2020-07-29 12:24:05','CHECKING',1),(6,3,41767.5,'2020-07-29 12:24:05','SAVINGS',1),(7,4,11632.2,'2020-07-29 12:24:05','CHECKING',1),(8,4,7634.43,'2020-07-29 12:24:05','SAVINGS',1),(9,5,56067,'2020-07-29 12:24:05','CHECKING',1),(10,5,79682.1,'2020-07-29 12:24:05','SAVINGS',1),(11,6,45732,'2020-07-30 13:53:10','CHECKING',1),(12,7,1000.32,'2020-07-30 13:55:07','CHECKING',1),(13,8,3200.76,'2020-07-30 14:00:09','CHECKING',1),(14,9,103453000,'2020-07-30 14:37:37','CHECKING',1),(15,6,0,'2020-07-30 14:41:27','SAVINGS',1),(16,7,0,'2020-07-30 14:41:27','SAVINGS',1),(17,8,0,'2020-07-30 14:41:27','SAVINGS',1),(18,9,0,'2020-07-30 14:41:27','SAVINGS',1);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `dateCreated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `visible` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'U000001','********','Issac','Newton','United States','9876556789','2020-07-29 12:20:50',1),(2,'randoguy','R4ndoGuy!','George','McGuy','USA','9995554326','2020-07-29 12:20:50',1),(3,'someUser','50M3U53R?','Billy','Bob','Canada','0115552934','2020-07-29 12:20:50',1),(4,'bryans123','Bryan!23','Brittany','Ryans','USA','9995558765','2020-07-29 12:20:50',1),(5,'rakishesh','R4k!shesh','Amar','Rakishesh','India','1114447863','2020-07-29 12:20:50',1),(6,'jSanchez','J$4nchez','Joseph','Sanchez','Mexico','2229073456','2020-07-30 13:53:10',1),(7,'hahahaha','H4h4hah@','blah','blahblah','hahahaha','5555668368','2020-07-30 13:55:07',1),(8,'mollyBank','H4h4hah@','Molly','Hatchet','USA','5559997777','2020-07-30 14:00:09',1),(9,'fakeSteve','F4ke$teve','Steven','McDonald','USA','8885557777','2020-07-30 14:37:37',1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customerTransactionId` int NOT NULL,
  `accountTransactionId` int NOT NULL,
  `amount` float NOT NULL DEFAULT '0',
  `startAmount` float NOT NULL DEFAULT '0',
  `endAmount` float NOT NULL DEFAULT '0',
  `type` enum('CHECKING','SAVINGS','OTHER') NOT NULL DEFAULT 'OTHER',
  `dateCreated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `customerTransactionId_idx` (`customerTransactionId`),
  KEY `accountTransactionId_idx` (`accountTransactionId`),
  CONSTRAINT `accountTransactionId` FOREIGN KEY (`accountTransactionId`) REFERENCES `accounts` (`id`),
  CONSTRAINT `customerTransactionId` FOREIGN KEY (`customerTransactionId`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,1,1,5000,0,5000,'CHECKING','2020-07-29 12:36:33'),(2,1,2,1000,0,1000,'SAVINGS','2020-07-29 12:36:33'),(3,1,2,-1000,1000,0,'SAVINGS','2020-07-29 12:36:33'),(4,1,1,1000,5000,6000,'CHECKING','2020-07-29 12:36:33'),(5,1,1,-1000,6000,5000,'CHECKING','2020-07-29 12:36:33'),(6,2,3,-4,305.22,301.22,'CHECKING','2020-07-29 12:36:33'),(7,3,5,-10,823.47,833.47,'CHECKING','2020-07-29 12:36:33'),(8,4,8,400,7234.34,7634.43,'SAVINGS','2020-07-29 12:36:33'),(9,5,9,1200,31677,32877,'CHECKING','2020-07-29 12:36:33'),(10,5,10,0,87632.1,87632.1,'SAVINGS','2020-07-29 12:36:33'),(11,3,5,200,833.47,1033.47,'CHECKING','2020-07-29 12:36:33'),(12,2,4,200,226.37,26.37,'SAVINGS','2020-07-29 12:36:33'),(13,4,7,9999,1633.2,11632.2,'CHECKING','2020-07-29 12:36:33'),(14,3,6,1000,42762.5,43762.5,'SAVINGS','2020-07-29 12:36:33'),(15,3,5,-200,1033.47,833.47,'CHECKING','2020-07-29 12:36:33'),(17,2,3,1000,301.22,1301.22,'CHECKING','2020-07-30 10:45:48'),(18,2,3,-500,1301.22,801.22,'CHECKING','2020-07-30 10:51:45'),(19,2,4,1200,26.37,1226.37,'SAVINGS','2020-07-30 10:51:57'),(20,2,4,-500,1226.37,726.37,'SAVINGS','2020-07-30 10:52:07'),(21,3,6,-1000,43762.5,42762.5,'SAVINGS','2020-07-30 11:01:56'),(22,3,6,5,42762.5,42767.5,'SAVINGS','2020-07-30 11:02:18'),(23,1,1,-5,5000,4995,'CHECKING','2020-07-30 12:18:10'),(24,1,1,10,4995,5005,'CHECKING','2020-07-30 12:18:28'),(25,1,1,-5,5005,5000,'CHECKING','2020-07-30 12:18:34'),(26,3,6,-1000,42767.5,41767.5,'SAVINGS','2020-07-30 12:40:44'),(27,3,5,1000,833.47,1833.47,'CHECKING','2020-07-30 12:40:44'),(28,5,10,-1000,87632.1,86632.1,'SAVINGS','2020-07-30 12:45:19'),(29,5,10,50,86632.1,86682.1,'SAVINGS','2020-07-30 12:45:24'),(30,5,10,-10000,86682.1,76682.1,'SAVINGS','2020-07-30 12:45:40'),(31,5,10,-5000,76682.1,71682.1,'SAVINGS','2020-07-30 12:45:49'),(32,5,9,5000,32877,37877,'CHECKING','2020-07-30 12:45:49'),(33,5,9,1200,37877,39077,'CHECKING','2020-07-30 12:45:58'),(34,5,9,-10,39077,39067,'CHECKING','2020-07-30 12:46:02'),(35,5,9,25000,39067,64067,'CHECKING','2020-07-30 12:46:07'),(36,5,9,-8000,64067,56067,'CHECKING','2020-07-30 12:46:13'),(37,5,10,8000,71682.1,79682.1,'SAVINGS','2020-07-30 12:46:13'),(38,6,11,45732,0,45732,'CHECKING','2020-07-30 13:53:10'),(39,7,12,1000.32,0,1000.32,'CHECKING','2020-07-30 13:55:08'),(40,8,13,3200.76,0,3200.76,'CHECKING','2020-07-30 14:00:09'),(41,1,2,98432,0,98432,'SAVINGS','2020-07-30 14:06:57'),(42,1,2,-1324.33,98432,97107.7,'SAVINGS','2020-07-30 14:09:43'),(43,9,14,103453000,0,103453000,'CHECKING','2020-07-30 14:37:37');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dollarsbank'
--

--
-- Dumping routines for database 'dollarsbank'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-30 14:53:55
