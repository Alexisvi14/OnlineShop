-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: online_shop
-- ------------------------------------------------------
-- Server version	8.0.27

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
  `idAccounts` int NOT NULL AUTO_INCREMENT,
  `balance` double NOT NULL,
  PRIMARY KEY (`idAccounts`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,2000),(2,3000),(3,3000),(4,5000),(5,2000);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointments` (
  `idAppointments` int NOT NULL,
  `date` date NOT NULL,
  `time` datetime NOT NULL,
  `idClients` int NOT NULL,
  PRIMARY KEY (`idAppointments`),
  KEY `fk_Appointments_Clients1_idx` (`idClients`),
  CONSTRAINT `fk_Appointments_Clients1` FOREIGN KEY (`idClients`) REFERENCES `clients` (`idClients`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES (1,'2022-11-01','2022-11-01 10:00:00',1),(2,'2022-11-02','2022-11-02 10:00:00',2),(3,'2022-11-03','2022-11-03 10:00:00',3),(4,'2022-11-04','2022-11-04 10:00:00',4),(5,'2022-11-05','2022-11-05 10:00:00',5);
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assistants`
--

DROP TABLE IF EXISTS `assistants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assistants` (
  `idAssistants` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  PRIMARY KEY (`idAssistants`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assistants`
--

LOCK TABLES `assistants` WRITE;
/*!40000 ALTER TABLE `assistants` DISABLE KEYS */;
INSERT INTO `assistants` VALUES (1,'Ricardo','Supp'),(2,'Estela','Supi'),(3,'Jose','Villaruel'),(4,'Francisco','Rost');
/*!40000 ALTER TABLE `assistants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cards`
--

DROP TABLE IF EXISTS `cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cards` (
  `idCards` int NOT NULL AUTO_INCREMENT,
  `number` double NOT NULL,
  `idAccounts` int NOT NULL,
  PRIMARY KEY (`idCards`),
  KEY `fk_Cards_Accounts1_idx` (`idAccounts`),
  CONSTRAINT `fk_Cards_Accounts1` FOREIGN KEY (`idAccounts`) REFERENCES `accounts` (`idAccounts`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cards`
--

LOCK TABLES `cards` WRITE;
/*!40000 ALTER TABLE `cards` DISABLE KEYS */;
INSERT INTO `cards` VALUES (1,1111,1),(2,2222,2),(3,3333,3),(4,4444,4),(5,5555,5);
/*!40000 ALTER TABLE `cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `idClients` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `npi` double NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idClients`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Micaela','Feldmann',39318541,'micaF@gmail.com'),(2,'Juan','Orellana',36318542,'juanO@gmail.com'),(3,'Brian','Villamayor',44518542,'brianV@gmail.com'),(4,'Hugo','Villamayor',14518542,'hugoV@gmail.com'),(5,'Liliana','Santa Cruz',21518542,'lilianaSC@gmail.com');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concurrence`
--

DROP TABLE IF EXISTS `concurrence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concurrence` (
  `idClients` int NOT NULL,
  `idDiscounts` int NOT NULL,
  KEY `fk_Benefits_has_Clients_Clients1_idx` (`idClients`),
  KEY `fk_Benefits_has_Clients_Benefits1_idx` (`idDiscounts`),
  CONSTRAINT `fk_Benefits_has_Clients_Benefits1` FOREIGN KEY (`idDiscounts`) REFERENCES `discounts` (`idDiscounts`),
  CONSTRAINT `fk_Benefits_has_Clients_Clients1` FOREIGN KEY (`idClients`) REFERENCES `clients` (`idClients`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concurrence`
--

LOCK TABLES `concurrence` WRITE;
/*!40000 ALTER TABLE `concurrence` DISABLE KEYS */;
INSERT INTO `concurrence` VALUES (1,1),(2,2),(3,3),(4,4),(5,5);
/*!40000 ALTER TABLE `concurrence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credits`
--

DROP TABLE IF EXISTS `credits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credits` (
  `idCredits` int NOT NULL AUTO_INCREMENT,
  `money` double NOT NULL,
  `idAccounts` int NOT NULL,
  PRIMARY KEY (`idCredits`),
  KEY `fk_Credits_Accounts1_idx` (`idAccounts`),
  CONSTRAINT `fk_Credits_Accounts1` FOREIGN KEY (`idAccounts`) REFERENCES `accounts` (`idAccounts`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credits`
--

LOCK TABLES `credits` WRITE;
/*!40000 ALTER TABLE `credits` DISABLE KEYS */;
INSERT INTO `credits` VALUES (1,2000,1),(2,2500,2),(3,3000,3),(4,400,4),(5,2200,5);
/*!40000 ALTER TABLE `credits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_support`
--

DROP TABLE IF EXISTS `customer_support`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_support` (
  `idClients` int NOT NULL,
  `idAssistants` int NOT NULL,
  PRIMARY KEY (`idClients`,`idAssistants`),
  KEY `fk_Clients_has_Assistants_Assistants1_idx` (`idAssistants`),
  KEY `fk_Clients_has_Assistants_Clients1_idx` (`idClients`),
  CONSTRAINT `fk_Clients_has_Assistants_Assistants1` FOREIGN KEY (`idAssistants`) REFERENCES `assistants` (`idAssistants`),
  CONSTRAINT `fk_Clients_has_Assistants_Clients1` FOREIGN KEY (`idClients`) REFERENCES `clients` (`idClients`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_support`
--

LOCK TABLES `customer_support` WRITE;
/*!40000 ALTER TABLE `customer_support` DISABLE KEYS */;
INSERT INTO `customer_support` VALUES (1,1),(2,2),(3,3),(4,4);
/*!40000 ALTER TABLE `customer_support` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `debts`
--

DROP TABLE IF EXISTS `debts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `debts` (
  `idDebts` int NOT NULL AUTO_INCREMENT,
  `money` double NOT NULL,
  `idAccounts` int NOT NULL,
  PRIMARY KEY (`idDebts`),
  KEY `fk_Debts_Accounts1_idx` (`idAccounts`),
  CONSTRAINT `fk_Debts_Accounts1` FOREIGN KEY (`idAccounts`) REFERENCES `accounts` (`idAccounts`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `debts`
--

LOCK TABLES `debts` WRITE;
/*!40000 ALTER TABLE `debts` DISABLE KEYS */;
INSERT INTO `debts` VALUES (1,500,1),(2,400,2),(3,300,3),(4,300,4),(5,1000,5);
/*!40000 ALTER TABLE `debts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deposits`
--

DROP TABLE IF EXISTS `deposits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deposits` (
  `idDeposits` int NOT NULL AUTO_INCREMENT,
  `money` double NOT NULL,
  `idAccounts` int NOT NULL,
  PRIMARY KEY (`idDeposits`),
  KEY `fk_Deposits_Accounts1_idx` (`idAccounts`),
  CONSTRAINT `fk_Deposits_Accounts1` FOREIGN KEY (`idAccounts`) REFERENCES `accounts` (`idAccounts`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deposits`
--

LOCK TABLES `deposits` WRITE;
/*!40000 ALTER TABLE `deposits` DISABLE KEYS */;
INSERT INTO `deposits` VALUES (1,500,1),(2,500,2),(3,500,3),(4,1000,4),(5,700,5);
/*!40000 ALTER TABLE `deposits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discounts`
--

DROP TABLE IF EXISTS `discounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discounts` (
  `idDiscounts` int NOT NULL AUTO_INCREMENT,
  `discounts` varchar(45) NOT NULL,
  PRIMARY KEY (`idDiscounts`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discounts`
--

LOCK TABLES `discounts` WRITE;
/*!40000 ALTER TABLE `discounts` DISABLE KEYS */;
INSERT INTO `discounts` VALUES (1,'20%'),(2,'20%'),(3,'20%'),(4,'20%'),(5,'20%');
/*!40000 ALTER TABLE `discounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `idEmployees` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `salary` varchar(45) NOT NULL,
  `idShops` int NOT NULL,
  PRIMARY KEY (`idEmployees`),
  KEY `fk_employees_Shop1_idx` (`idShops`),
  CONSTRAINT `fk_employees_Shop1` FOREIGN KEY (`idShops`) REFERENCES `shops` (`idShop`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Agustin','Cabeza','2000',1),(2,'Cristian','Gomez','2500',1),(3,'Gaston','Florenciano','2500',2),(4,'Walter','White','5000',2),(5,'Yanil','Paez','1500',2);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `idClients` int NOT NULL,
  `idAccounts` int NOT NULL,
  PRIMARY KEY (`idClients`,`idAccounts`),
  KEY `fk_Clients_has_Accounts_Accounts1_idx` (`idAccounts`),
  KEY `fk_Clients_has_Accounts_Clients1_idx` (`idClients`),
  CONSTRAINT `fk_Clients_has_Accounts_Accounts1` FOREIGN KEY (`idAccounts`) REFERENCES `accounts` (`idAccounts`),
  CONSTRAINT `fk_Clients_has_Accounts_Clients1` FOREIGN KEY (`idClients`) REFERENCES `clients` (`idClients`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1),(2,2),(3,3),(4,4),(5,5);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owner` (
  `idowner` int NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  PRIMARY KEY (`idowner`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (1,'Alexis','Villamayor');
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `idPayments` int NOT NULL AUTO_INCREMENT,
  `money` double NOT NULL,
  `place` varchar(45) NOT NULL,
  `idAccounts` int NOT NULL,
  PRIMARY KEY (`idPayments`),
  KEY `fk_Payments_Accounts1_idx` (`idAccounts`),
  CONSTRAINT `fk_Payments_Accounts1` FOREIGN KEY (`idAccounts`) REFERENCES `accounts` (`idAccounts`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES (1,500,'Office',1),(2,500,'Office',2),(3,1000,'Office',3),(4,1500,'Office',4),(5,450,'Office',5);
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phones`
--

DROP TABLE IF EXISTS `phones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phones` (
  `idPhones` int NOT NULL AUTO_INCREMENT,
  `number` double NOT NULL,
  `idClients` int NOT NULL,
  `idOwner` int NOT NULL,
  `idShops` int NOT NULL,
  PRIMARY KEY (`idPhones`,`idShops`),
  KEY `fk_Phones_Clients1_idx` (`idClients`),
  KEY `fk_Phones_owner1_idx` (`idOwner`),
  KEY `fk_Phones_Shops1_idx` (`idShops`),
  CONSTRAINT `fk_Phones_Clients1` FOREIGN KEY (`idClients`) REFERENCES `clients` (`idClients`),
  CONSTRAINT `fk_Phones_owner1` FOREIGN KEY (`idOwner`) REFERENCES `owner` (`idowner`),
  CONSTRAINT `fk_Phones_Shops1` FOREIGN KEY (`idShops`) REFERENCES `shops` (`idShop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phones`
--

LOCK TABLES `phones` WRITE;
/*!40000 ALTER TABLE `phones` DISABLE KEYS */;
/*!40000 ALTER TABLE `phones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `providers`
--

DROP TABLE IF EXISTS `providers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `providers` (
  `idProviders` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  PRIMARY KEY (`idProviders`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `providers`
--

LOCK TABLES `providers` WRITE;
/*!40000 ALTER TABLE `providers` DISABLE KEYS */;
INSERT INTO `providers` VALUES (1,'Roberto','Carlos'),(2,'Kyrie','Irving'),(3,'Kevin','Durant');
/*!40000 ALTER TABLE `providers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shops`
--

DROP TABLE IF EXISTS `shops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shops` (
  `idShop` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `web_page` varchar(45) NOT NULL,
  `phone_number` int NOT NULL,
  `idOwner` int NOT NULL,
  `idClients` int NOT NULL,
  PRIMARY KEY (`idShop`),
  UNIQUE KEY `idWeb_page_UNIQUE` (`idShop`),
  KEY `fk_Shop_owner1_idx` (`idOwner`),
  KEY `fk_Shops_Clients1_idx` (`idClients`),
  CONSTRAINT `fk_Shop_owner1` FOREIGN KEY (`idOwner`) REFERENCES `owner` (`idowner`),
  CONSTRAINT `fk_Shops_Clients1` FOREIGN KEY (`idClients`) REFERENCES `clients` (`idClients`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shops`
--

LOCK TABLES `shops` WRITE;
/*!40000 ALTER TABLE `shops` DISABLE KEYS */;
INSERT INTO `shops` VALUES (1,'Better dayz','www.betterdayz.com',411065,1,2),(2,'Great values','www.greatvalues.com',411070,1,2);
/*!40000 ALTER TABLE `shops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trucks`
--

DROP TABLE IF EXISTS `trucks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trucks` (
  `idShops` int NOT NULL,
  `idProviders` int NOT NULL,
  PRIMARY KEY (`idShops`,`idProviders`),
  KEY `fk_Shop_has_provider_provider1_idx` (`idProviders`),
  KEY `fk_Shop_has_provider_Shop1_idx` (`idShops`),
  CONSTRAINT `fk_Shop_has_provider_provider1` FOREIGN KEY (`idProviders`) REFERENCES `providers` (`idProviders`),
  CONSTRAINT `fk_Shop_has_provider_Shop1` FOREIGN KEY (`idShops`) REFERENCES `shops` (`idShop`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trucks`
--

LOCK TABLES `trucks` WRITE;
/*!40000 ALTER TABLE `trucks` DISABLE KEYS */;
INSERT INTO `trucks` VALUES (2,1),(1,2),(1,3),(2,3);
/*!40000 ALTER TABLE `trucks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-26  2:36:47
