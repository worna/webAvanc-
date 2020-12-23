drop table IF EXISTS user;
drop table IF EXISTS product;
drop table IF EXISTS category;

CREATE TABLE `user` (
  `email` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone_number` varchar(200) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `AUTHORITIES` varchar(500) DEFAULT NULL,
  `NON_EXPIRED` tinyint(1) DEFAULT NULL,
  `NON_LOCKED` tinyint(1) DEFAULT NULL,
  `CREDENTIALS_NON_EXPIRED` tinyint(1) DEFAULT NULL,
  `ENABLED` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user(`email`,`username`,`first_name`,`password`,`phone_number`,`gender`,`birth_date`,`AUTHORITIES`,`NON_EXPIRED`,`NON_LOCKED`,`CREDENTIALS_NON_EXPIRED`,`ENABLED`) VALUES
("a.b@c.com","phil","dfds","$2a$10$f5xOsmxAJbvQm4YjhzTyPuCzxy/wHzqcepLnKI0YibXmPN1unQEeS","+336458963",0,'1998-05-27',"ROLE_USER",1,1,1,1);

CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `image` varchar(50) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `price` FLOAT(10, 2) NOT NULL,
  `quantity_left` int NOT NULL,
  `is_salable` tinyint(1) DEFAULT NULL,
  `description` varchar(500) NOT NULL,
  `category_id`int NOT NULL,
  `image` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT FK_ProductCategory FOREIGN KEY (category_id)
    REFERENCES category(category_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO product(`name`,`brand`,`price`,`quantity_left`,`is_salable`,`description`,`category_id`,`image`) VALUES
("","",,,,,"");