DROP DATABASE if exists `MarksheetGen`;
CREATE DATABASE  `MarksheetGen`;
USE `MarksheetGen`;


CREATE TABLE IF NOT EXISTS studentinfo (
  roll int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) ,
  DateOfBirth DATE NOT NULL,
  Physics int,
  Chemistry int,
  Maths int,
  Java int
  
) engine=InnoDB;


