DROP DATABASE IF EXISTS bookdb;
DROP USER IF EXISTS `bookadmin`@`localhost`;
DROP USER IF EXISTS `bookuser`@`localhost`;
CREATE DATABASE IF NOT EXISTS bookdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `bookadmin`@`localhost` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW, CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `bookdb`.* to `bookadmin`@`localhost`;
CREATE USER IF NOT EXISTS `bookuser`@`localhost` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `bookdb`.* TO `bookuser`@`localuser`;
FLUSH PRIVILEGES;