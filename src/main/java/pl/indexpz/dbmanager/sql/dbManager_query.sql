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


SELECT name, password, email FROM users WHERE id = 2;

UPDATE users SET name = 'Beata', password = 'sniezka', email='beata@gmial.com' WHERE id = '4';

DELETE FROM users WHERE id = '4';

SELECT * FROM users where email LIKE 'jan@wp.pl';


SELECT email FROM users HAVING email = 'jan@wp.pl';

SELECT id FROM users where  name LIKE  + 'Barbara';