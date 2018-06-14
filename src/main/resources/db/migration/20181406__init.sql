CREATE TABLE ex.book (
    id integer NOT NULL CONSTRAINT book_pk PRIMARY KEY,
    tittle varchar(255) NOT NULL,
    description varchar(1000) NOT NULL,
    author varchar(255) NOT NULL,
    content varchar(2000) NOT NULL
);