DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS book_author;
DROP TABLE IF EXISTS author;


-- tables
-- Table: author
CREATE TABLE author (
    id integer NOT NULL CONSTRAINT author_pk PRIMARY KEY,
    full_name varchar(255) NOT NULL
);

-- Table: book
CREATE TABLE book (
    isbn varchar(14) NOT NULL CONSTRAINT book_pk PRIMARY KEY,
    tittle varchar(255) NOT NULL,
    subtittle varchar(255) NOT NULL,
    published date NOT NULL,
    publisher varchar(255) NOT NULL,
    pages integer NOT NULL,
    description varchar(1000) NOT NULL,
    instock boolean NOT NULL
);

-- Table: book_author
CREATE TABLE book_author (
    book_isbn varchar(14) NOT NULL,
    author_id integer NOT NULL,
    CONSTRAINT book_author PRIMARY KEY (book_isbn,author_id),
    CONSTRAINT book_author_book FOREIGN KEY (book_isbn)
    REFERENCES book (isbn),
    CONSTRAINT book_author_author FOREIGN KEY (author_id)
    REFERENCES author (id)
);

-- Book 1
INSERT INTO book(isbn, tittle, subtittle, published, publisher, pages, description, instock)
  VALUES(
    '978-1617291999',
    'Java 8 in Action',
    'Lambdas, Streams, and functional-style programming',
    '2014-08-28T00:00:00.000Z',
    'Manning Publications',
    424,
    'Java 8 in Action is a clearly written guide to the new features of Java 8. The book covers lambdas, streams, and functional-style programming. With Java 8s functional features you can now write more concise code in less time, and also automatically benefit from multicore architectures. Its time to dig in!',
    'true'
  );

INSERT INTO author (id,full_name) VALUES (1,'Raoul-Gabriel Urma');
INSERT INTO author (id,full_name) VALUES (2,'Mario Fusco');
INSERT INTO author (id,full_name) VALUES (3,'Alan Mycroft');

INSERT INTO book_author(book_isbn, author_id) VALUES ('978-1617291999',1);
INSERT INTO book_author(book_isbn, author_id) VALUES ('978-1617291999',2);
INSERT INTO book_author(book_isbn, author_id) VALUES ('978-1617291999',3);

-- Book 2
INSERT INTO book(isbn, tittle, subtittle, published, publisher, pages, description, instock)
  VALUES(
    '978-0134494166',
    'Clean Architecture',
    'A Craftsman''s Guide to Software Structure and Design',
    '2017-09-20T00:00:00.000Z',
    'Prentice Hall',
    432,
    'By applying universal rules of software architecture, you can dramatically improve developer productivity throughout the life of any software system. Now, building upon the success of his best-selling books Clean Code and The Clean Coder, legendary software craftsman Robert C. Martin ("Uncle Bob") reveals those rules and helps you apply them.',
    'true'
  );

INSERT INTO author (id,full_name) VALUES (4,'Robert C. Martin');

INSERT INTO book_author(book_isbn, author_id) VALUES ('978-0134494166',4);