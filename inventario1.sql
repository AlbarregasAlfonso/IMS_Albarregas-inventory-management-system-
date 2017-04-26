-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: inventario
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


--
-- Current Database: `inventario`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `inventario` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;

USE `inventario`;
--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `IdAlumno` int(11) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `posicion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdAlumno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caracteristicas`
--

DROP TABLE IF EXISTS `caracteristicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caracteristicas` (
  `IdCaracteristicas` int(11) NOT NULL AUTO_INCREMENT,
  `hd` varchar(255) DEFAULT NULL,
  `procesador` varchar(255) DEFAULT NULL,
  `ram` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdCaracteristicas`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracteristicas`
--

LOCK TABLES `caracteristicas` WRITE;
/*!40000 ALTER TABLE `caracteristicas` DISABLE KEYS */;
INSERT INTO `caracteristicas` VALUES (1,'1000','Intel i-7','4gb DDR-3'),(2,'700','Intel i-7','8gb DDR-3'),(3,'500','Intel i-7','16gb DDR-3'),(4,'1000','Intel i-5','4gb DDR-3'),(5,'700','Intel i-5','8gb DDR-3'),(6,'500','Intel i-5','16gb DDR-3'),(7,'500','Intel i-3','4gb DDR-3'),(8,'500','Intel i-3','8gb DDR-3');
/*!40000 ALTER TABLE `caracteristicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `IdCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'ordenador'),(2,'teclado'),(3,'pantalla'),(4,'ratón');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado` (
  `IdEstado` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'En uso'),(2,'Sin usar'),(3,'Averiado'),(4,'Tirado');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estancia`
--

DROP TABLE IF EXISTS `estancia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estancia` (
  `IdEstancia` int(11) NOT NULL AUTO_INCREMENT,
  `M2` int(11) NOT NULL,
  `acondicionado` bit(1) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `IdLocalizacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdEstancia`),
  KEY `FKg9gx7vu533fa4bnflcm6gvuo5` (`IdLocalizacion`),
  CONSTRAINT `FKg9gx7vu533fa4bnflcm6gvuo5` FOREIGN KEY (`IdLocalizacion`) REFERENCES `localizacion` (`IdLocalizacion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estancia`
--

LOCK TABLES `estancia` WRITE;
/*!40000 ALTER TABLE `estancia` DISABLE KEYS */;
INSERT INTO `estancia` VALUES (1,20,'',15,'ASIR2',1),(2,25,'',15,'DAW1',1),(3,30,'',20,'DAW2',2);
/*!40000 ALTER TABLE `estancia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localizacion`
--

DROP TABLE IF EXISTS `localizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localizacion` (
  `IdLocalizacion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `num_planta` varchar(255) DEFAULT NULL,
  `IdEstancia` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdLocalizacion`),
  KEY `FK8a1s7jjsv54ojqaf9m5im2og6` (`IdEstancia`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localizacion`
--

LOCK TABLES `localizacion` WRITE;
/*!40000 ALTER TABLE `localizacion` DISABLE KEYS */;
INSERT INTO `localizacion` VALUES (1,'Edificio1','2',1),(2,'Edificio2','1',2),(3,'Edificio3','1',3),(4,'Edificio1','2',1),(5,'Edificio2','1',2),(6,'Edificio3','1',3),(7,'Edificio1','2',1),(8,'Edificio1','1',2),(9,'Edificio1','1',3),(10,'Edificio1','1',4),(11,'Edificio1','1',5),(12,'Edificio2','1',6);
/*!40000 ALTER TABLE `localizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `IdMarca` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'Asus'),(2,'Mac'),(3,'Lenovo'),(4,'Hp'),(5,'Lenovo'),(6,'packard bell'),(7,'MSI'),(8,'Samsung');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelo`
--

DROP TABLE IF EXISTS `modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modelo` (
  `IdModelo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `IdLCaracteristicas` int(11) DEFAULT NULL,
  `IdMarca` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdModelo`),
  KEY `FKk11gexpfndt5tmpkotvneoe17` (`IdLCaracteristicas`),
  KEY `FKrmilq38b6e6hkspt1tbsdyosl` (`IdMarca`),
  CONSTRAINT `FKk11gexpfndt5tmpkotvneoe17` FOREIGN KEY (`IdLCaracteristicas`) REFERENCES `caracteristicas` (`IdCaracteristicas`),
  CONSTRAINT `FKrmilq38b6e6hkspt1tbsdyosl` FOREIGN KEY (`IdMarca`) REFERENCES `caracteristicas` (`IdCaracteristicas`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo`
--

LOCK TABLES `modelo` WRITE;
/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
INSERT INTO `modelo` VALUES (1,'Z-45',4,1),(2,'R500',4,3),(3,'Air de 13 pulgadas',3,2),(4,'342',3,4),(5,'R-56',2,6),(6,'T-800',2,7),(7,'L-cgh400',1,5),(8,'T-90',5,5),(9,'Z322',6,8),(10,'F400',7,8);
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `IdProducto` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_baja` varchar(255) DEFAULT NULL,
  `fecha_compra` varchar(255) DEFAULT NULL,
  `precio` float NOT NULL,
  `ubicacion` varchar(255) DEFAULT NULL,
  `IdLCaracteristicas` int(11) DEFAULT NULL,
  `IdCategoria` int(11) DEFAULT NULL,
  `IdEstado` int(11) DEFAULT NULL,
  `IdEstancia` int(11) DEFAULT NULL,
  `IdMarca` int(11) DEFAULT NULL,
  `IdModelo` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdProducto`),
  KEY `FKscnbfhnnel0dyg106tndwmla5` (`IdLCaracteristicas`),
  KEY `FKe01e782nth6bfuiidji1ccb6q` (`IdCategoria`),
  KEY `FK9kujyub4ba61n9qcdvxja78o1` (`IdEstado`),
  KEY `FKrx53n4hoqp74ylpetm3f0i2r3` (`IdEstancia`),
  KEY `FKct2icxbg2y7xv7slur0no0x75` (`IdMarca`),
  KEY `FK7e495jx04oqgo1b11b8r8tnqq` (`IdModelo`),
  CONSTRAINT `FK7e495jx04oqgo1b11b8r8tnqq` FOREIGN KEY (`IdModelo`) REFERENCES `modelo` (`IdModelo`),
  CONSTRAINT `FK9kujyub4ba61n9qcdvxja78o1` FOREIGN KEY (`IdEstado`) REFERENCES `estado` (`IdEstado`),
  CONSTRAINT `FKct2icxbg2y7xv7slur0no0x75` FOREIGN KEY (`IdMarca`) REFERENCES `marca` (`IdMarca`),
  CONSTRAINT `FKe01e782nth6bfuiidji1ccb6q` FOREIGN KEY (`IdCategoria`) REFERENCES `categoria` (`IdCategoria`),
  CONSTRAINT `FKrx53n4hoqp74ylpetm3f0i2r3` FOREIGN KEY (`IdEstancia`) REFERENCES `estancia` (`IdEstancia`),
  CONSTRAINT `FKscnbfhnnel0dyg106tndwmla5` FOREIGN KEY (`IdLCaracteristicas`) REFERENCES `caracteristicas` (`IdCaracteristicas`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (6,'--','12-12-1991',200,'Tercera fila',1,2,3,2,1,2),(7,'--','12-12-1997',300,'Cuarta fila',1,2,3,1,1,2),(8,'--','12-09-1999',340,'Segunda fila',2,4,2,1,1,2),(9,'--','12-11-1996',170,'Tercera fila',3,2,1,2,1,2),(10,'--','12-10-1995',30,'Tercera fila',1,2,3,2,1,2);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `IdStock` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `IdModelo` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdStock`),
  KEY `FKc57oxs9t85gwcrs2g1yxe2791` (`IdModelo`),
  CONSTRAINT `FKc57oxs9t85gwcrs2g1yxe2791` FOREIGN KEY (`IdModelo`) REFERENCES `modelo` (`IdModelo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,40,1),(2,20,1),(3,30,1),(4,9,1),(5,12,1),(6,14,1),(7,20,1);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-27  0:08:04
