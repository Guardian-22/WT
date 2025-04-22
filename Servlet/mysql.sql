CREATE DATABASE wt;

USE wt;

CREATE TABLE ebookshop (
    book_id INT PRIMARY KEY,
    book_title VARCHAR(100),
    book_author VARCHAR(100),
    book_price INT,
    quantity INT
);

INSERT INTO ebookshop VALUES
(1, 'Java Basics', 'John Doe', 500, 10),
(2, 'Servlets & JSP', 'Jane Roe', 650, 5),
(3, 'Web Tech', 'Sam Smith', 800, 3);
