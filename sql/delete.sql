USE `testproject`;

ALTER TABLE `books_genres`
  DROP FOREIGN KEY fk_books_genres_books;

ALTER TABLE `books_genres`
  DROP FOREIGN KEY fk_books_genres_genres;

ALTER TABLE `books_authors`
  DROP FOREIGN KEY fk_books_authors_books;

ALTER TABLE `books_authors`
  DROP FOREIGN KEY fk_books_authors_author;

ALTER TABLE `books_orders`
  DROP FOREIGN KEY fk_books_orders_books;

ALTER TABLE `books_orders`
  DROP FOREIGN KEY fk_books_orders_order;


DROP TABLE `book` CASCADE;
DROP TABLE `genre` CASCADE;
DROP TABLE `books_genres` CASCADE;
DROP TABLE `author` CASCADE;
DROP TABLE `books_authors` CASCADE;
DROP TABLE `buyer_order` CASCADE;
DROP TABLE `books_orders` CASCADE;