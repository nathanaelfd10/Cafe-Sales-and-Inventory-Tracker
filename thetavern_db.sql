CREATE DATABASE  IF NOT EXISTS `the_tavern_directory`;
USE `the_tavern_directory`;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) DEFAULT NULL,
    `date_of_birth` DATE DEFAULT NULL,
	`sex` CHAR(1) DEFAULT NULL,
    `email` VARCHAR(100) DEFAULT NULL,
    `home_address` VARCHAR(50) DEFAULT NULL,
    `pay_hour` INT(20) DEFAULT NULL,
    `role` VARCHAR(50) DEFAULT NULL,
    `permanent_officer` BOOLEAN DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`(
	`username` varchar(50) NOT NULL,
    `password` char(68) NOT NULL,
    `enabled` tinyint(1) NOT NULL,
    PRIMARY KEY (`username`)
);

INSERT INTO `users`
VALUES 
('thetavern','{bcrypt}$2a$10$h35W41KLLqTbT/3Ve7KrE.gz/iaFBKrAeOEGV0sUjtOutmrAdxEAK', 1),
('noxfl','{bcrypt}$2a$10$h35W41KLLqTbT/3Ve7KrE.gz/iaFBKrAeOEGV0sUjtOutmrAdxEAK',1),
('patricia','{bcrypt}$2a$10$h35W41KLLqTbT/3Ve7KrE.gz/iaFBKrAeOEGV0sUjtOutmrAdxEAK',1);

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `authorities` (
	`username` varchar(50) NOT NULL,
    `authority` varchar(50) NOT NULL,
    UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
    CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
);

INSERT INTO `authorities`
VALUES
('thetavern','ROLE_ADMIN'),
('noxfl','ROLE_EMPLOYEE'),
('patricia','ROLE_EMPLOYEE'),
('patricia','ROLE_ADMIN');

DROP TABLE IF EXISTS `transaction_detail`;
DROP TABLE IF EXISTS `transaction`;
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(500) DEFAULT NULL,
    `description` VARCHAR(500) DEFAULT NULL,
    `image` VARCHAR(500) DEFAULT NULL,
    `price` INT(5) DEFAULT NULL,
    `available` BOOLEAN DEFAULT NULL,
	PRIMARY KEY (`id`)
);

INSERT INTO `menu`
VALUES
('1', 'Caffe Latte', 'The finest caffe latte in town', 'caffelatte.jpg', '37000', 1),
('2', 'Flat White', 'The finest flat white in town', 'flatwhite.jpg', '35000', 1),
('3', 'Espresso', 'For your quick dose of caffeine', 'espresso.jpg', '35000', 1);

DROP TABLE IF EXISTS `supply`;
CREATE TABLE `supply` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) DEFAULT NULL,
    `description` VARCHAR(500) DEFAULT NULL,
    `price` INT(20) DEFAULT NULL,
    `stock` INT(10) DEFAULT NULL,
    `unit` VARCHAR(50) DEFAULT NULL,
	PRIMARY KEY (`id`)
);

INSERT INTO `supply`
VALUES
('1', 'Full Arabica Coffee Bean', 'Roast Profile: Medium Dark for Espresso', '14500', 3, 'kg'),
('2', 'Greenfield Milk Full Cream', 'Fresh Greenfield milk', '35000', '5', 'L');

DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
	`password` VARCHAR(500) NOT NULL,
    `date_of_birth` DATETIME NOT NULL,
    `is_member` BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (`id`)
);

INSERT INTO `customer`
VALUES
('1', 'pat', 'pass', '2001/12/18', 1);

CREATE TABLE `transaction` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`customer_id` INT DEFAULT NULL,
	`date` DATE DEFAULT NULL,
    `total` decimal(15,2) NULL,
    `tax` decimal(15,2) NULL,
    `customer_type` VARCHAR(50) DEFAULT NULL,
    
    PRIMARY KEY (`id`),
	FOREIGN KEY (`customer_id`) REFERENCES customer(`id`)
);

CREATE TABLE `transaction_detail` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`transaction_id` INT NOT NULL,
    `menu_id` INT DEFAULT NULL,
    `customer_id` INT DEFAULT NULL,
    `date` DATE NOT NULL,
    `price` INT (50) DEFAULT NULL,
    PRIMARY KEY (`id`),
	FOREIGN KEY (`transaction_id`) REFERENCES transaction(`id`)
)

ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=LATIN1;