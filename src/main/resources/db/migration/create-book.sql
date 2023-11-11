-- Create the 'Book' table
CREATE TABLE Book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    price DECIMAL(10, 2) NOT NULL,
    author VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL
);