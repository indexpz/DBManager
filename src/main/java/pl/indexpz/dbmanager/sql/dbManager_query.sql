#Tworzenie bazy danych
BEGIN ;
CREATE DATABASE IF NOT EXISTS db_manager
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;
ROLLBACK ;
COMMIT ;

BEGIN;
CREATE TABLE users
(id INT AUTO_INCREMENT,
name VARCHAR(255) NOT NULL ,
password VARCHAR(255),
email VARCHAR(255) UNIQUE ,
PRIMARY KEY (id));
COMMIT ;