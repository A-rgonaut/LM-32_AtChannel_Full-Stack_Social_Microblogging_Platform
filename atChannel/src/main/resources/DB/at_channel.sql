DROP DATABASE IF EXISTS `at_channel`;
CREATE DATABASE `at_channel`;

-- CREATE DATABASE IF NOT EXISTS at_channel;

USE `at_channel`;

CREATE TABLE IF NOT EXISTS `Credential` (
	`user_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`username` VARCHAR(45) NOT NULL UNIQUE,
	`password` VARCHAR(128) NOT NULL,
	`role` VARCHAR(32) NOT NULL,
	`enabled` TINYINT(4) NOT NULL
);

CREATE TABLE IF NOT EXISTS `User` (
	`user_id` INT NOT NULL PRIMARY KEY,
	`firstname` VARCHAR(45) NOT NULL,
	`lastname` VARCHAR(45) NOT NULL,
	`email` VARCHAR(45) NOT NULL UNIQUE,
	`username` VARCHAR(45) NOT NULL UNIQUE,
	`nametag` VARCHAR(45) NOT NULL UNIQUE,
	`pic_path` VARCHAR(100) NOT NULL DEFAULT 'assets/img/pics/user_pic.png',
	`cover_path` VARCHAR(100) NOT NULL DEFAULT 'assets/img/covers/user_cover.png',
	`follower` INT DEFAULT 0,
	`following` INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS `Post` (
	`post_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`date` DATE NOT NULL,
	`content` VARCHAR(280) NOT NULL,
	`image_path` VARCHAR(100),
	`likes` INT DEFAULT 0,
	`comments` INT DEFAULT 0,
	`saves` INT DEFAULT 0,
	`user_id` INT NOT NULL,
	FOREIGN KEY(`user_id`) REFERENCES `User`(`user_id`)
);

CREATE TABLE IF NOT EXISTS `Comment` (
	`comment_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`date` DATE NOT NULL,
	`content` VARCHAR(120) NOT NULL,
	`image_path` VARCHAR(100),
	`likes` INT DEFAULT 0,
	`comments` INT DEFAULT 0,
	`saves` INT DEFAULT 0,
	`user_id` INT NOT NULL,
	`post_id` INT NOT NULL,
	FOREIGN KEY(`user_id`) REFERENCES `User`(`user_id`),
	FOREIGN KEY(`post_id`) REFERENCES `post`(`post_id`)
);

CREATE TABLE IF NOT EXISTS `Follow` (
	`follows_id` INT NOT NULL,
	`followed_id` INT NOT NULL,
	PRIMARY KEY(`follows_id`,`followed_id`),
	FOREIGN KEY(`follows_id`) REFERENCES `User`(`user_id`),
	FOREIGN KEY(`followed_id`) REFERENCES `User`(`user_id`)
);