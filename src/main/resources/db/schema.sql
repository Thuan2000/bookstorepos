
-- TODO: Below is a script to generate the schema for a MySQL database (dialect "MySQL").
-- Need to create another script to seed some fake data into the newly created schema.
-- Create the 'Book' table
CREATE TABLE Book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    price DECIMAL(10, 2) NOT NULL,
    author VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL
);

-- Create the 'Order' table
-- CREATE TABLE 'Order' (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     totalPrice DECIMAL(10, 2) NOT NULL
-- );

-- Create a junction table 'OrderDetails' to handle the many-to-many relationship
-- CREATE TABLE OrderDetails (
--     order_id INT NOT NULL,
--     book_id INT NOT NULL,
--     quantity INT NOT NULL,
--     current_book_price DECIMAL(10, 2) NOT NULL,
--     FOREIGN KEY (order_id) REFERENCES `Order`(id),
--     FOREIGN KEY (book_id) REFERENCES Book(id),
--     PRIMARY KEY (order_id, book_id)
-- );
