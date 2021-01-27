#Tworzenie bazy danych
BEGIN ;
CREATE DATABASE IF NOT EXISTS db_manager
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;
ROLLBACK ;
COMMIT ;

#Backup bazy danych db_manager
# mysqldump -u [user_name] -p [database_name] > [file].sql
# mysqldump -u root -p db_manager > db_manager_backup.sql


BEGIN;
CREATE TABLE users
(id INT AUTO_INCREMENT,
name VARCHAR(255) NOT NULL ,
password VARCHAR(255),
email VARCHAR(255) UNIQUE ,
PRIMARY KEY (id));
COMMIT ;

DESCRIBE users;

BEGIN ;
ALTER TABLE users MODIFY password VARCHAR(255) NOT NULL;
ALTER TABLE users MODIFY email  VARCHAR(255) NOT NULL UNIQUE ;
COMMIT ;

# CREATE_USER_QUERY
INSERT  INTO  users ( name, password, email) VALUES (?,?,?);

SELECT  * FROM users;