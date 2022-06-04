CREATE DATABASE  IF NOT EXISTS `janji_manis_directory`;
USE `janji_manis_directory`;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) DEFAULT NULL,
    `date_of_birth` DATETIME DEFAULT NULL,
	`sex` CHAR(1) DEFAULT NULL,
    `home_address` VARCHAR(50) DEFAULT NULL,
    `pay_hour` INT(20) DEFAULT NULL,
    `role` VARCHAR(50) DEFAULT NULL,
    `permanent_officer` BOOLEAN DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

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

DROP TABLE IF EXISTS `supply`;
CREATE TABLE `supply` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) DEFAULT NULL,
    `desc` VARCHAR(500) DEFAULT NULL,
    `price` INT(20) DEFAULT NULL,
    `stock` INT(10) DEFAULT NULL,
    `unit` VARCHAR(50) DEFAULT NULL,
	PRIMARY KEY (`id`)
);

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

CREATE TABLE `transaction` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`cust_id` INT NOT NULL,
	`date` INT NOT NULL,
    `total` INT NOT NULL,
    `tax` INT DEFAULT NULL,
    `customer_type` VARCHAR(50) NOT NULL,
    
    PRIMARY KEY (`id`),
	FOREIGN KEY (`cust_id`) REFERENCES customer(`id`)
);


CREATE TABLE `transaction_detail` (
	`transaction_id` INT NOT NULL,
    `menu_id` INT NOT NULL,
    
	FOREIGN KEY (`transaction_id`) REFERENCES transaction(`id`),
	FOREIGN KEY (`menu_id`) REFERENCES menu(`id`)
)

ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=LATIN1;