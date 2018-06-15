DROP TABLE IF EXISTS book;

CREATE TABLE book (
    id integer NOT NULL CONSTRAINT book_pk PRIMARY KEY,
    tittle varchar(255) NOT NULL,
    description varchar(1000) NOT NULL,
    author varchar(255) NOT NULL,
    content varchar(2000) NOT NULL
);

INSERT INTO book(id,tittle,description,author,content)
  VALUES (1,
    'Brief History of Time',
    '	Stephen Hawking',
    'A Brief History of Time: From the Big Bang to Black Holes ' ||
    'is a popular-science book on cosmology (the study of the universe) ' ||
    'by British physicist Stephen Hawking.[1] It was first published ' ||
    'in 1988. Hawking wrote the book for nonspecialist readers with ' ||
    'no prior knowledge of scientific theories.',
    '................');
