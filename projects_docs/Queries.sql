
// Query to create a table under library schema

CREATE TABLE library.book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(100),
    available BOOLEAN
);



// Query to alter the table

ALTER TABLE library.book RENAME COLUMN available TO is_available;



// Query to insert data

INSERT INTO library.book (id, title, author, available) VALUES
(1, 'Effective Java', 'Joshua Bloch', true),
(2, 'Learning Python', 'Mark Lutz', true),
(3, 'Learning Java', 'Marc Loy', true),
(4, 'Clean Code', 'Robert C. Martin', true),
(5, 'The Pragmatic Programmer', 'Andrew Hunt and David Thomas', true),
(6, 'You Do not Know JS', 'Kyle Simpson', true),
(7, 'Head First Java', 'Kathy Sierra and Bert Bates', true);


