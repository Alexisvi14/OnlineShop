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
  `cbu` double NOT NULL,
  PRIMARY KEY (`idAccounts`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-05 15:59:28
