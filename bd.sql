CREATE DATABASE  IF NOT EXISTS `certification_bd` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `certification_bd`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: certification_bd
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_96phhxl71wpa4bjnsonecwpsr` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'Gonzalo','$2a$2a$12$EOFbmCwxt7/LefXJjYOaM.4pYsW1OPTI8q9RzTQA0MqdbmnKz3IEe','admin');
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contenidos` varchar(255) NOT NULL,
  `cupos_disponibles` int DEFAULT NULL,
  `cupos_iniciales` int NOT NULL,
  `detalle` varchar(345) NOT NULL,
  `fechafinal` datetime(6) NOT NULL,
  `fechainicio` datetime(6) NOT NULL,
  `imagen_portada` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent eu ultricies nisi. Donec maximus nibh eget dui vestibulum, non egestas dolor tempor.',9,10,'PRUEBA1','2022-07-31 00:00:00.000000','2022-06-11 00:00:00.000000','https://images.unsplash.com/photo-1564865878688-9a244444042a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80'),(2,'HOLA',9,10,'PRUEBA','2022-08-06 00:00:00.000000','2022-06-18 00:00:00.000000','https://images.unsplash.com/photo-1576836165612-8bc9b07e7778?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postulante`
--

DROP TABLE IF EXISTS `postulante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postulante` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apellido_1` varchar(75) NOT NULL,
  `apellido_2` varchar(75) NOT NULL,
  `direccion` varchar(75) NOT NULL,
  `edad` int NOT NULL,
  `email` varchar(75) NOT NULL,
  `nombre` varchar(75) NOT NULL,
  `password` varchar(75) NOT NULL,
  `rut` varchar(10) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `curso_id` int DEFAULT NULL,
  `regiones_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_d3wvpx0kr3xxcmprjmii9ytkd` (`rut`),
  KEY `FKbscx3qi2tknlpnu8lqwu0oij4` (`curso_id`),
  KEY `FKhg5ud8j7ud0wojrv577994uyc` (`regiones_id`),
  CONSTRAINT `FKbscx3qi2tknlpnu8lqwu0oij4` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`id`),
  CONSTRAINT `FKhg5ud8j7ud0wojrv577994uyc` FOREIGN KEY (`regiones_id`) REFERENCES `regiones` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postulante`
--

LOCK TABLES `postulante` WRITE;
/*!40000 ALTER TABLE `postulante` DISABLE KEYS */;
INSERT INTO `postulante` VALUES (1,'Ortiz','Suarez','Pasaje Rio Grande 01715',25,'j.alejandra@123.cl','Javiera Alejandra','$2a$10$KbxgZ.vkxuTWeSzap7Jjwe2KUWf5caVLY0jn0ynlUIfpqt.3t/BOC','19519880-2','965738844',1,12),(2,'Rebaque','Suarez','Cornelio Saavedra 238',55,'jRe@123.cl','Julian','$2a$10$hbzQV9O7IFr9AN4cX1PN0.iVLw6b3d0sZb/QEGlPFc/u8bRiKLcJS','11909191-8','955418745',2,11),(3,'Kardashian','Gonzalez','Blanco Encalada 992',21,'kkd@123.cl','Kim','$2a$10$2Jsru/8TUCTUASm9E/MqfOAHXYX3UHeW3GKgRUHeLLlPCEF4CIE.2','10499737-6','984752215',2,15),(4,'Miller','Laurie','Cornelio Saavedra 238',25,'ray@123.cl','Ray ','$2a$10$8Zwid1.5mH/nrqW7fEQOV.63THmoVa7hvinNMSe0PWQ2hJ3AsPxAS','18729139-9','965778415',1,4),(5,'White','Ralo','Manuel Montt 7663',25,'derek@123.cl','Derek','$2a$10$uvEB7I0gn2ga//QhC2YdWew/3ytcSLE6VR9pGMlhN/c4ZTG4jcXCS','4077809-9','987452655',NULL,15),(6,'Martinez','Rar','Manuel Montt 7663',26,'mma@123.cl','Mauro','$2a$10$Fwm2.Uog7u6Vru0MwKD6BOjxSon8Z0KZfUeFeA9BA8BX9HJt0CRpu','15772610-5','984621577',2,11);
/*!40000 ALTER TABLE `postulante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regiones`
--

DROP TABLE IF EXISTS `regiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regiones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(70) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_o4mjnomcp30h4n4xkca9jxpd6` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regiones`
--

LOCK TABLES `regiones` WRITE;
/*!40000 ALTER TABLE `regiones` DISABLE KEYS */;
INSERT INTO `regiones` VALUES (3,'Antofagasta'),(1,'Arica y Parinacota'),(4,'Atacama'),(15,'Aysén del General Carlos Ibáñez del Campo'),(11,'Biobío'),(5,'Coquimbo'),(12,'La Araucanía'),(8,'Libertador General Bernardo O\'Higgins'),(14,'Los Lagos'),(13,'Los Ríos'),(16,'Magallanes y de la Antártica Chilena'),(9,'Maule'),(7,'Metropolitana de Santiago'),(10,'Ñuble'),(2,'Tarapacá'),(6,'Valparaiso');
/*!40000 ALTER TABLE `regiones` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-10 23:40:27
