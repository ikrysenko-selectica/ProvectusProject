USE `testproject`;

INSERT INTO `author` VALUES (NULL, 'Schwarzenegger Arnold');
INSERT INTO `author` VALUES (NULL, 'Lewis Carroll');
INSERT INTO `author` VALUES (NULL, 'Koji Suzuki');
INSERT INTO `author` VALUES (NULL, 'Mark Twain');
INSERT INTO `author` VALUES (NULL, 'George R. R. Martin');

INSERT INTO `genre` VALUES (NULL, 'Sports');
INSERT INTO `genre` VALUES (NULL, 'Horror');
INSERT INTO `genre` VALUES (NULL, 'Fantasy');
INSERT INTO `genre` VALUES (NULL, 'Comedy');
INSERT INTO `genre` VALUES (NULL, 'Fiction ');

INSERT INTO `book` VALUES (NULL, 'The Gilded Age: A Tale of Today', 'It satirizes greed and political corruption in
    post–Civil War America in the era now referred to as the Gilded Age. Although not one of Twains best-known works, it
    has appeared in more than one hundred editions since its original publication. Twain and Warner originally had planned
    to issue the novel with illustrations by Thomas Nast. The book is remarkable for two reasons–-it is the only novel
    Twain wrote with a collaborator, and its title very quickly became synonymous with graft, materialism, and corruption
    in public life.', 33.20);
INSERT INTO `book` VALUES (NULL, 'The New Encyclopedia of Modern Bodybuilding', 'From elite bodybuilding competitors to
    gymnasts, from golfers to fitness gurus, anyone who works out with weights must own this book—a book that only
    Arnold Schwarzenegger could write, a book that has earned its reputation as “the bible of bodybuilding.”', 130.50);
INSERT INTO `book` VALUES (NULL, 'Loop ', 'The story revolves around a simulated reality, exactly the same as our own,
    known as the Loop: created to simulate the emergence and evolution of life. It is in this alternate universe that
    the events of the previous novels, Ring and Spiral took place.', 90.00);
INSERT INTO `book` VALUES (NULL, 'A Song of Ice and Fire', 'A Song of Ice and Fire is a series of epic fantasy novels
    written by American novelist and screenwriter George R.R. Martin. He began writing the series in 1991 and
    the first volume was published in 1996. Originally envisaged as a trilogy, there are now five published novels
    in the series with two more planned. There are also three novellas which act as prequels to the novels, with several
    more planned, and three other novellas consisting of excepts from the main novels.', 260.30);
INSERT INTO `book` VALUES (NULL, 'Alices Adventures in Wonderland', 'It tells of a girl named Alice falling through
    a rabbit hole into a fantasy world populated by peculiar, anthropomorphic creatures. The tale plays with logic, giving
    the story lasting popularity with adults as well as with children. It is considered to be one of the best examples
    of the literary nonsense genre.', 40.40);

INSERT INTO books_authors VALUES (1, 4);
INSERT INTO books_authors VALUES (2, 1);
INSERT INTO books_authors VALUES (3, 3);
INSERT INTO books_authors VALUES (4, 5);
INSERT INTO books_authors VALUES (5, 2);

INSERT INTO books_genres VALUES (1, 4);
INSERT INTO books_genres VALUES (2, 1);
INSERT INTO books_genres VALUES (3, 2);
INSERT INTO books_genres VALUES (4, 3);
INSERT INTO books_genres VALUES (5, 5);