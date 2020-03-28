-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: stock_managerdb
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articulo` (
  `codigo_articulo` int(11) NOT NULL,
  `nombre_articulo` varchar(45) NOT NULL,
  `fecha_caducidad` datetime NOT NULL,
  `precio` float NOT NULL,
  `stock` int(11) DEFAULT NULL,
  `opinion_articulo` int(11) NOT NULL,
  PRIMARY KEY (`codigo_articulo`),
  UNIQUE KEY `codigo_articulo_UNIQUE` (`codigo_articulo`),
  UNIQUE KEY `nombre_articulo_UNIQUE` (`nombre_articulo`),
  KEY `fk_valoracion_cliente_idx` (`opinion_articulo`),
  CONSTRAINT `fk_opinion_articulo` FOREIGN KEY (`opinion_articulo`) REFERENCES `opinion` (`codigo_opinion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo`
--

LOCK TABLES `articulo` WRITE;
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cafeteria`
--

DROP TABLE IF EXISTS `cafeteria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cafeteria` (
  `ID_cafeteria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_cafeteria` varchar(45) NOT NULL,
  `articulo_cafeteria` int(11) NOT NULL,
  PRIMARY KEY (`ID_cafeteria`),
  UNIQUE KEY `ID_cafeteria_UNIQUE` (`ID_cafeteria`),
  UNIQUE KEY `nombre_cafeteria_UNIQUE` (`nombre_cafeteria`),
  KEY `fk_articulo_cafeteria_idx` (`articulo_cafeteria`),
  CONSTRAINT `fk_articulo_cafeteria` FOREIGN KEY (`articulo_cafeteria`) REFERENCES `articulo` (`codigo_articulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cafeteria`
--

LOCK TABLES `cafeteria` WRITE;
/*!40000 ALTER TABLE `cafeteria` DISABLE KEYS */;
/*!40000 ALTER TABLE `cafeteria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cesta`
--

DROP TABLE IF EXISTS `cesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cesta` (
  `codigo_cesta` int(11) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `articulo_cesta` int(11) NOT NULL,
  PRIMARY KEY (`codigo_cesta`),
  UNIQUE KEY `codigo_cesta_UNIQUE` (`codigo_cesta`),
  KEY `fk_articulo_cesta_idx` (`articulo_cesta`),
  CONSTRAINT `fk_articulo_cesta` FOREIGN KEY (`articulo_cesta`) REFERENCES `articulo` (`codigo_articulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cesta`
--

LOCK TABLES `cesta` WRITE;
/*!40000 ALTER TABLE `cesta` DISABLE KEYS */;
/*!40000 ALTER TABLE `cesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `ID_cliente` int(11) NOT NULL,
  `nombre_cliente` varchar(45) NOT NULL,
  `email_cliente` varchar(45) NOT NULL,
  `recibo_cliente` int(11) DEFAULT NULL,
  `cesta_cliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_cliente`),
  UNIQUE KEY `ID_cliente_UNIQUE` (`ID_cliente`),
  UNIQUE KEY `email_cliente_UNIQUE` (`email_cliente`),
  UNIQUE KEY `recibo_cliente_UNIQUE` (`recibo_cliente`),
  UNIQUE KEY `cesta_cliente_UNIQUE` (`cesta_cliente`),
  CONSTRAINT `fk_cesta_cliente` FOREIGN KEY (`cesta_cliente`) REFERENCES `cesta` (`codigo_cesta`),
  CONSTRAINT `fk_recibo_cliente` FOREIGN KEY (`recibo_cliente`) REFERENCES `recibo` (`codigo_recibo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensaje`
--

DROP TABLE IF EXISTS `mensaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensaje` (
  `destinatario` varchar(20) NOT NULL,
  `texto` varchar(45) DEFAULT NULL,
  `cliente_mensaje` int(11) NOT NULL,
  PRIMARY KEY (`cliente_mensaje`),
  UNIQUE KEY `ID_cliente_UNIQUE` (`cliente_mensaje`),
  CONSTRAINT `fk_cliente_mensaje` FOREIGN KEY (`cliente_mensaje`) REFERENCES `cliente` (`ID_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensaje`
--

LOCK TABLES `mensaje` WRITE;
/*!40000 ALTER TABLE `mensaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `mensaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oferta`
--

DROP TABLE IF EXISTS `oferta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oferta` (
  `codigo_ofertas` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_oferta` varchar(45) NOT NULL,
  `articulo_oferta` int(11) NOT NULL,
  PRIMARY KEY (`codigo_ofertas`),
  UNIQUE KEY `codigo_ofertas_UNIQUE` (`codigo_ofertas`),
  UNIQUE KEY `nombre_oferta_UNIQUE` (`nombre_oferta`),
  KEY `fk_articulo_pedido_idx` (`articulo_oferta`),
  CONSTRAINT `fk_articulo_oferta` FOREIGN KEY (`articulo_oferta`) REFERENCES `articulo` (`codigo_articulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oferta`
--

LOCK TABLES `oferta` WRITE;
/*!40000 ALTER TABLE `oferta` DISABLE KEYS */;
/*!40000 ALTER TABLE `oferta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opinion`
--

DROP TABLE IF EXISTS `opinion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opinion` (
  `texto` varchar(45) NOT NULL,
  `valoracion` int(11) NOT NULL,
  `opinion_cliente` int(11) NOT NULL,
  `codigo_opinion` int(11) NOT NULL,
  PRIMARY KEY (`codigo_opinion`),
  UNIQUE KEY `ID_cliente_UNIQUE` (`opinion_cliente`),
  UNIQUE KEY `codigo_opinion_UNIQUE` (`codigo_opinion`),
  CONSTRAINT `fk_opinion_cliente` FOREIGN KEY (`opinion_cliente`) REFERENCES `cliente` (`ID_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opinion`
--

LOCK TABLES `opinion` WRITE;
/*!40000 ALTER TABLE `opinion` DISABLE KEYS */;
/*!40000 ALTER TABLE `opinion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `codigo_pedido` int(11) NOT NULL,
  `proveedor_pedido` int(11) NOT NULL,
  `articulo_pedido` int(11) NOT NULL,
  PRIMARY KEY (`codigo_pedido`),
  UNIQUE KEY `codigo_pedido_UNIQUE` (`codigo_pedido`) /*!80000 INVISIBLE */,
  KEY `fk_proveedor_pedido_idx` (`proveedor_pedido`),
  KEY `fk_articulo_pedido_idx` (`articulo_pedido`),
  CONSTRAINT `fk_articulo_pedido` FOREIGN KEY (`articulo_pedido`) REFERENCES `articulo` (`codigo_articulo`),
  CONSTRAINT `fk_proveedor_pedido` FOREIGN KEY (`proveedor_pedido`) REFERENCES `vendedor` (`ID_vendedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibo`
--

DROP TABLE IF EXISTS `recibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recibo` (
  `codigo_recibo` int(11) NOT NULL,
  `articulo_recibo` int(11) NOT NULL,
  PRIMARY KEY (`codigo_recibo`),
  UNIQUE KEY `codigo_recibo_UNIQUE` (`codigo_recibo`),
  KEY `fk_articulo_recibo_idx` (`articulo_recibo`),
  CONSTRAINT `fk_articulo_recibo` FOREIGN KEY (`articulo_recibo`) REFERENCES `articulo` (`codigo_articulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo`
--

LOCK TABLES `recibo` WRITE;
/*!40000 ALTER TABLE `recibo` DISABLE KEYS */;
/*!40000 ALTER TABLE `recibo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedor` (
  `ID_vendedor` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_vendedor` varchar(45) NOT NULL,
  `Email_vendedor` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_vendedor`),
  UNIQUE KEY `ID_UNIQUE` (`ID_vendedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-28 14:04:38
