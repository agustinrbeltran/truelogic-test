DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS book_author;

-- tables
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
    id integer NOT NULL CONSTRAINT book_author_pk PRIMARY KEY,
    book_isbn varchar(14) NOT NULL,
    author varchar(255) NOT NULL,
    CONSTRAINT book_author_book FOREIGN KEY (book_isbn)
    REFERENCES book (isbn)
);

