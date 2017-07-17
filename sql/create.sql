CREATE DATABASE IF NOT EXISTS `testproject`
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

USE `testproject`;

CREATE TABLE IF NOT EXISTS `testproject`.`book` (
  `id`         INT(20)       NOT NULL AUTO_INCREMENT,
  `title`      VARCHAR(50)   NOT NULL,
  `decription` VARCHAR(500)  NOT NULL,
  `price`      DECIMAL(8, 2) NOT NULL,

  CONSTRAINT pk_book PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `testproject`.`genre` (
  `id`   INT(15)     NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,

  CONSTRAINT pk_genre PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `testproject`.`books_genres` (
  `book_id`  INT(10) NOT NULL,
  `genre_id` INT(10) NOT NULL,

  CONSTRAINT pk_books_genres PRIMARY KEY (`book_id`, `genre_id`)
)
  ENGINE = InnoDB;

ALTER TABLE `books_genres`
  ADD CONSTRAINT fk_books_genres_books
FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `books_genres`
  ADD CONSTRAINT fk_books_genres_genres
FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

CREATE TABLE IF NOT EXISTS `testproject`.`author` (
  `id`   INT(10)     NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,

  CONSTRAINT pk_author PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `testproject`.`books_authors` (
  `book_id`   INT(10) NOT NULL,
  `author_id` INT(10) NOT NULL,

  CONSTRAINT pk_books_authors PRIMARY KEY (`book_id`, `author_id`)
)
  ENGINE = InnoDB;

ALTER TABLE `books_authors`
  ADD CONSTRAINT fk_books_authors_books
FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `books_authors`
  ADD CONSTRAINT fk_books_authors_author
FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

CREATE TABLE IF NOT EXISTS `testproject`.`buyer_order` (
  `id`             INT(10)      NOT NULL AUTO_INCREMENT,
  `first_name`     VARCHAR(100) NOT NULL,
  `last_name`      VARCHAR(100) NOT NULL,
  `address`        VARCHAR(100) NOT NULL,
  `books_quantity` INT(10)      NOT NULL,


  CONSTRAINT pk_order PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `testproject`.`books_orders` (
  `book_id`  INT(10) NOT NULL,
  `order_id` INT(10) NOT NULL,

  CONSTRAINT pk_books_orders PRIMARY KEY (`book_id`, `order_id`)
)
  ENGINE = InnoDB;

ALTER TABLE `books_orders`
  ADD CONSTRAINT fk_books_orders_books
FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `books_orders`
  ADD CONSTRAINT fk_books_orders_order
FOREIGN KEY (`order_id`) REFERENCES `buyer_order` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;