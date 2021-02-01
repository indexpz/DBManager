-- MySQL dump 10.13  Distrib 8.0.22, for osx10.15 (x86_64)
--
-- Host: localhost    Database: db_manager
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `email_2` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Paweł','krowaJeTrawe','pawel@gmail.com'),(2,'Jan','haslo','jan@wp.pl'),(5,'Krysia','yyyaaa','krysia@onet.pl'),(12,'Halina','aaaabbb','halina@wp.pl'),(13,'Bartek','ketrab','bartek@wp.pl'),(14,'Michał','tttyyyy',' michał@wp.pl'),(15,'Michał','tttyyyy','michał@wp.pl'),(16,'Barbara','$2a$10$CVE5NvZgjurZUM1/PQo.7O4PMoSLCAI3EqIoSxyqw/q0nOzbhHEUC','baska@onet.pl'),(17,'JerzY','$2a$10$B0EAivZOK5w7i46EnlO3o.McRECqS3OdIwrbk6CnhnTJTjZKWGT86','jerzy_@gmail.com'),(18,'Jurek','$2a$10$dAJDYAaO/JMa5qaBvJLUj.EDLt.8u65VyFzWrnuUcgz6uBv7tlaA2','jurek@wp.pl'),(19,'Zosia','$2a$10$vYkxpbHg4Kbv/9yVYkdxA.hYapLNVf1r72GBRapRzEhdlFCHEyXN2','zosia@gmail.com'),(21,'Stanisława','$2a$10$S/4Rhk1BNeqR5760c6Ajsu0ko26EiJUKs9gyA2odALLtX0.N2xKCq','stanislawa@gmail.com'),(24,'Stasia','$2a$10$VD.xAtwleLIXT8AxiDSU0uhWqanxeUe4s.QKaz940okjSnRGGHZvC','stasia@gmail.com'),(26,'marek','$2a$10$T36VXqr.OwP6eIjh8SsMaeboxF1VPopmEAF782wDWsZGEefz.Vgmi','marek@coderslab.pl');
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

-- Dump completed on 2021-01-29 21:42:58
