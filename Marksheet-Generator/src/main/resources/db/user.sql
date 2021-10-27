CREATE DATABASE MarksheetGen;
CREATE USER 'user' @ '%' IDENTIFIED BY 'admin123';
GRANT ALL ON MarksheetGen.* TO 'user'@'%';