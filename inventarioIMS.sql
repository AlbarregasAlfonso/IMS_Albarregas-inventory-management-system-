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
-- Table structure for table `alumnos`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `inventario` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;

USE `inventario`;


DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnos` (
  `IdAlumno` int(11) NOT NULL AUTO_INCREMENT,
  `Apellidos` varchar(255) DEFAULT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `IdEstancia` int(11) DEFAULT NULL,
  `IdProducto` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdAlumno`),
  KEY `FK5isk5x51ulu0tug8tbno95pws` (`IdEstancia`),
  KEY `FKp133na3kgckaog9404qyhxra8` (`IdProducto`),
  CONSTRAINT `FK5isk5x51ulu0tug8tbno95pws` FOREIGN KEY (`IdEstancia`) REFERENCES `estancia` (`IdEstancia`),
  CONSTRAINT `FKp133na3kgckaog9404qyhxra8` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'Fernandez Moreno','Alfonso',1,1),(2,'Sonala Velazquez','Alejandro',2,2),(3,'Terrones Vacas','Carlos',3,3),(4,'Ruiz Mateos','Juan',4,4),(5,'Rodrigez Cortes','Alberto',5,4),(6,'Gimenez Gonzalez','Alberto',6,6),(7,'Mendoza Grao','Alberto',7,7),(8,'Carretero Terron','Alberto',8,8),(9,'Sanchez Moreno','Alberto',8,9),(10,'Carro Tome','Alberto',7,10),(11,'Lopez Ruiz','Alberto',6,11),(12,'Castaño Sero','Alberto',5,12),(13,'Garcia Mora','Alberto',4,13),(14,'Pilo Martinez','Alberto',3,14),(15,'Heredia Ruiz','Alberto',2,15),(16,'Lopez Iglesia','Alberto',1,16),(17,'Carretero Sanchez','Alberto',2,17),(18,'Rodriguez Fernandez','Alberto',3,18),(19,'Alvarez Gonazalez','Alberto',4,19),(20,'Moreno Alejandre','Alberto',5,20),(21,'Delgado Parrilla','Alberto',6,21),(22,'Hidalgo Dorrio','Alberto',7,22),(23,'Padilla Moreno','Alberto',8,23),(24,'Carmona Salido','Alberto',8,24),(25,'Vacas Gonzalez','Alberto',7,25),(26,'Ribera Moreno','Alberto',6,26),(27,'Cordovilla Fernandez','Alberto',5,27),(28,'Rubio Prado','Alberto',4,28),(29,'Garcia Ramos','Alberto',3,29),(30,'Sanche Rico','Alberto',2,30),(31,'Barrado Gil','Alberto',1,31),(32,'Tmas Gutierrez','Alberto',1,32),(33,'Morcillo Gonzalez','Alberto',2,33),(34,'Bejarano Diaz','Alberto',3,34),(35,'Larios Correa','Alberto',4,35),(36,'Correa Gonzalez','Alberto',5,36),(37,'Tunez Padilla','Alberto',6,5),(38,'Espejo Zapatero','Alberto',7,5),(39,'Cordero Garcia','Alberto',8,5),(40,'Sanchez Zapatero','Alberto',7,5),(41,'Urdargarín Fernandez','Benito',6,3);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'ordenador');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disco`
--

DROP TABLE IF EXISTS `disco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disco` (
  `IdDisco` int(11) NOT NULL AUTO_INCREMENT,
  `compatibilidad` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdDisco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disco`
--

LOCK TABLES `disco` WRITE;
/*!40000 ALTER TABLE `disco` DISABLE KEYS */;
/*!40000 ALTER TABLE `disco` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'En uso'),(2,'Sin usar'),(3,'Averiado');
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
  PRIMARY KEY (`IdEstancia`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estancia`
--

LOCK TABLES `estancia` WRITE;
/*!40000 ALTER TABLE `estancia` DISABLE KEYS */;
INSERT INTO `estancia` VALUES (1,20,'',15,'ASIR2'),(2,25,'',15,'DAW1'),(3,25,'',15,'ASIR1'),(4,25,'',15,'Bachiller1A'),(5,25,'',15,'Bachiller2A'),(6,25,'',15,'Bachiller1B'),(7,25,'',15,'Bachiller2B'),(8,30,'',20,'DAW2');
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
  KEY `FK8a1s7jjsv54ojqaf9m5im2og6` (`IdEstancia`),
  CONSTRAINT `FK8a1s7jjsv54ojqaf9m5im2og6` FOREIGN KEY (`IdEstancia`) REFERENCES `estancia` (`IdEstancia`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localizacion`
--

LOCK TABLES `localizacion` WRITE;
/*!40000 ALTER TABLE `localizacion` DISABLE KEYS */;
INSERT INTO `localizacion` VALUES (1,'Edificio1','2',1),(2,'Edificio1','1',2),(3,'Edificio1','2',3),(4,'Edificio1','1',4),(5,'Edificio1','2',5),(6,'Edificio1','2',6),(7,'Edificio2','1',7),(8,'Edificio2','1',8);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'Asus'),(2,'MacBook'),(3,'Lenovo'),(4,'Hp'),(5,'Toshiba'),(6,'MSI');
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
  `IdMarca` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdModelo`),
  KEY `FKpgjoqgfmu8ojlj9t6nyfjni01` (`IdMarca`),
  CONSTRAINT `FKpgjoqgfmu8ojlj9t6nyfjni01` FOREIGN KEY (`IdMarca`) REFERENCES `marca` (`IdMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo`
--

LOCK TABLES `modelo` WRITE;
/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
INSERT INTO `modelo` VALUES (1,'K501UQ',1),(2,'F541UA',1),(3,'R510VX',1),(4,'Pro Retina 15',2),(5,'Pro Retina 13',2),(6,'Air Retina 13',2),(7,'Z50',3),(8,'Z45',3),(9,'R500',3),(10,'15-BA004NS',4),(11,'255G5',4),(12,'15-AY117NS',4),(13,'Portege Z30',5),(14,'Tecra',5),(15,'Satellite Pro',5),(16,'GS63VR',6),(17,'WS60',6),(18,'GE62VR',6);
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `placa`
--

DROP TABLE IF EXISTS `placa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `placa` (
  `IdPlaca` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdPlaca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `placa`
--

LOCK TABLES `placa` WRITE;
/*!40000 ALTER TABLE `placa` DISABLE KEYS */;
/*!40000 ALTER TABLE `placa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procesador`
--

DROP TABLE IF EXISTS `procesador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `procesador` (
  `IdProcesador` int(11) NOT NULL AUTO_INCREMENT,
  `compatibilidad` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdProcesador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procesador`
--

LOCK TABLES `procesador` WRITE;
/*!40000 ALTER TABLE `procesador` DISABLE KEYS */;
/*!40000 ALTER TABLE `procesador` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'--','12-12-1991',200,'Tercera fila',1,1,1,1,1,1),(2,'--','12-12-1997',300,'Cuarta fila',1,1,1,2,2,4),(3,'--','12-09-1999',340,'Segunda fila',2,1,1,3,3,3),(4,'--','12-11-1996',170,'Tercera fila',3,1,1,4,4,10),(5,'--','12-11-1996',170,'Cuarta fila',3,1,1,5,5,15),(6,'--','12-11-1996',170,'Tercera fila',3,1,1,6,6,16),(7,'--','12-11-1996',170,'Tercera fila',3,1,1,7,6,16),(8,'--','12-11-1996',170,'Quinta fila',3,1,1,8,6,16),(9,'--','12-11-1996',170,'Tercera fila',3,1,1,8,5,15),(10,'--','12-11-1996',170,'Tercera fila',3,1,1,7,4,10),(11,'--','12-12-1997',300,'Cuarta fila',1,1,1,6,2,4),(12,'--','12-09-1999',340,'Segunda fila',2,1,1,5,3,3),(13,'--','12-11-1996',170,'Tercera fila',3,1,1,4,4,10),(14,'--','12-11-1996',170,'Cuarta fila',3,1,1,3,5,15),(15,'--','12-11-1996',170,'Tercera fila',3,1,1,2,6,16),(16,'--','12-11-1996',170,'Tercera fila',3,1,1,1,6,16),(17,'--','12-11-1996',170,'Quinta fila',3,1,1,1,6,16),(18,'--','12-11-1996',170,'Tercera fila',3,1,1,2,5,15),(19,'--','12-11-1996',170,'Tercera fila',3,1,1,3,4,10),(20,'--','12-12-1997',300,'Cuarta fila',1,1,1,4,2,4),(21,'--','12-09-1999',340,'Segunda fila',2,1,1,5,3,3),(22,'--','12-11-1996',170,'Tercera fila',3,1,1,6,4,10),(23,'--','12-11-1996',170,'Cuarta fila',3,1,1,7,5,15),(24,'--','12-11-1996',170,'Tercera fila',3,1,1,8,6,16),(25,'--','12-11-1996',170,'Tercera fila',3,1,1,7,6,16),(26,'--','12-11-1996',170,'Quinta fila',3,1,1,8,6,16),(27,'--','12-11-1996',170,'Tercera fila',3,1,1,8,5,15),(28,'--','12-11-1996',170,'Tercera fila',3,1,1,7,4,10),(29,'--','12-11-1996',170,'Tercera fila',3,1,1,6,4,10),(30,'--','12-11-1996',170,'Cuarta fila',3,1,1,7,5,15),(31,'--','12-11-1996',170,'Tercera fila',3,1,1,8,6,16),(32,'--','12-11-1996',170,'Tercera fila',3,1,1,7,6,16),(33,'--','12-11-1996',170,'Quinta fila',3,1,1,8,6,16),(34,'--','12-11-1996',170,'Tercera fila',3,1,1,8,5,15),(35,'--','12-11-1996',170,'Tercera fila',3,1,1,7,4,10),(36,'--','12-10-1995',30,'Tercera fila',1,1,1,6,3,3),(37,'--','20-06-2017',400,'Tercera Fila',1,1,1,4,1,2);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produpropiedad`
--

DROP TABLE IF EXISTS `produpropiedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produpropiedad` (
  `IdProduPropiedad` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `IdProducto` int(11) DEFAULT NULL,
  `IdPropiedad` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdProduPropiedad`),
  KEY `FKakutfenot5ygr8g9a33hhgpqc` (`IdProducto`),
  KEY `FK6sg99b9as4ufwun7nrk9r87nh` (`IdPropiedad`),
  CONSTRAINT `FK6sg99b9as4ufwun7nrk9r87nh` FOREIGN KEY (`IdPropiedad`) REFERENCES `propiedad` (`IdPropiedad`),
  CONSTRAINT `FKakutfenot5ygr8g9a33hhgpqc` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=341 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produpropiedad`
--

LOCK TABLES `produpropiedad` WRITE;
/*!40000 ALTER TABLE `produpropiedad` DISABLE KEYS */;
INSERT INTO `produpropiedad` VALUES (149,'2gb DDR3',1,1),(150,'200',1,4),(151,'Intel-i1',1,2),(152,'Asus 9000',1,3),(153,'4gb DDR3',2,1),(154,'500',2,4),(155,'Intel-i3',2,2),(156,'Asus 9000',2,3),(157,'8gb DDR3',3,1),(158,'100',3,4),(159,'Intel-i5',3,2),(160,'Asus 9000',3,3),(161,'16gb DDR3',4,1),(162,'1200',4,4),(163,'Intel-i7',4,2),(164,'Asus 9000',4,3),(165,'2gb DDR3',5,1),(166,'200',5,4),(167,'Intel-i1',5,2),(168,'Asus 9000',5,3),(169,'2gb DDR3',6,1),(170,'200',6,4),(171,'Intel-i1',6,2),(172,'Asus 9000',6,3),(173,'2gb DDR3',7,1),(174,'200',7,4),(175,'Intel-i1',7,2),(176,'Asus 9000',7,3),(217,'2gb DDR3',17,1),(218,'200',17,4),(219,'Intel-i1',17,2),(220,'Asus 9000',17,3),(221,'2gb DDR3',18,1),(222,'200',18,4),(223,'Intel-i1',18,2),(224,'Asus 9000',18,3),(225,'2gb DDR3',19,1),(226,'200',19,4),(227,'Intel-i1',19,2),(228,'Asus 9000',19,3),(229,'2gb DDR3',20,1),(230,'200',20,4),(231,'Intel-i1',20,2),(232,'Asus 9000',20,3),(233,'2gb DDR3',21,1),(234,'200',21,4),(235,'Intel-i1',21,2),(236,'Asus 9000',21,3),(237,'2gb DDR3',22,1),(238,'200',22,4),(239,'Intel-i1',22,2),(240,'Asus 9000',22,3),(241,'2gb DDR3',23,1),(242,'200',23,4),(243,'Intel-i1',23,2),(244,'Asus 9000',23,3),(245,'2gb DDR3',24,1),(246,'200',24,4),(247,'Intel-i1',24,2),(248,'Asus 9000',24,3),(249,'2gb DDR3',25,1),(250,'200',25,4),(251,'Intel-i1',25,2),(252,'Asus 9000',25,3),(253,'2gb DDR3',26,1),(254,'200',26,4),(255,'Intel-i1',26,2),(256,'Asus 9000',26,3),(257,'2gb DDR3',27,1),(258,'200',27,4),(259,'Intel-i1',27,2),(260,'Asus 9000',27,3),(261,'2gb DDR3',28,1),(262,'200',28,4),(263,'Intel-i1',28,2),(264,'Asus 9000',28,3),(265,'2gb DDR3',29,1),(266,'200',29,4),(267,'Intel-i1',29,2),(268,'Asus 9000',29,3),(269,'2gb DDR3',30,1),(270,'200',30,4),(271,'Intel-i1',30,2),(272,'Asus 9000',30,3),(273,'2gb DDR3',31,1),(274,'200',31,4),(275,'Intel-i1',31,2),(276,'Asus 9000',31,3),(277,'2gb DDR3',32,1),(278,'200',32,4),(279,'Intel-i1',32,2),(280,'Asus 9000',32,3),(281,'2gb DDR3',33,1),(282,'200',33,4),(283,'Intel-i1',33,2),(284,'Asus 9000',33,3),(285,'2gb DDR3',34,1),(286,'200',34,4),(287,'Intel-i1',34,2),(288,'Asus 9000',34,3),(289,'2gb DDR3',35,1),(290,'200',35,4),(291,'Intel-i1',35,2),(292,'Asus 9000',35,3),(293,'2gb DDR3',36,1),(294,'200',36,4),(295,'Intel-i1',36,2),(296,'Asus 9000',36,3),(297,'2gb DDR3',8,1),(298,'200',8,4),(299,'Intel-i1',8,2),(300,'Asus 9000',8,3),(301,'2gb DDR3',9,1),(302,'200',9,4),(303,'Intel-i1',9,2),(304,'Asus 9000',9,3),(305,'2gb DDR3',10,1),(306,'200',11,4),(307,'Intel-i1',11,2),(308,'Asus 9000',11,3),(309,'2gb DDR3',10,1),(310,'200',10,4),(311,'Intel-i1',10,2),(312,'Asus 9000',10,3),(313,'2gb DDR3',11,1),(314,'200',11,4),(315,'Intel-i1',11,2),(316,'Asus 9000',11,3),(317,'2gb DDR3',12,1),(318,'200',12,4),(319,'Intel-i1',12,2),(320,'Asus 9000',12,3),(321,'2gb DDR3',13,1),(322,'200',13,4),(323,'Intel-i1',13,2),(324,'Asus 9000',13,3),(325,'2gb DDR3',14,1),(326,'200',14,4),(327,'Intel-i1',14,2),(328,'Asus 9000',14,3),(329,'2gb DDR3',15,1),(330,'200',15,4),(331,'Intel-i1',15,2),(332,'Asus 9000',15,3),(333,'2gb DDR3',16,1),(334,'200',16,4),(335,'Intel-i1',16,2),(336,'Asus 9000',16,3),(337,'I-4',37,3),(338,'4Gb',37,1),(339,'300',37,2),(340,'Asus',37,4);
/*!40000 ALTER TABLE `produpropiedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propiedad`
--

DROP TABLE IF EXISTS `propiedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `propiedad` (
  `IdPropiedad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdPropiedad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propiedad`
--

LOCK TABLES `propiedad` WRITE;
/*!40000 ALTER TABLE `propiedad` DISABLE KEYS */;
INSERT INTO `propiedad` VALUES (1,'Ram'),(2,'Procesador'),(3,'Placa'),(4,'DiscoDuro');
/*!40000 ALTER TABLE `propiedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ram`
--

DROP TABLE IF EXISTS `ram`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ram` (
  `IdRam` int(11) NOT NULL AUTO_INCREMENT,
  `compatibilidad` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdRam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ram`
--

LOCK TABLES `ram` WRITE;
/*!40000 ALTER TABLE `ram` DISABLE KEYS */;
/*!40000 ALTER TABLE `ram` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `IdUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'21232f297a57a5a743894a0e4a801fc3','admin');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-20 23:44:25
