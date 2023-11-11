-- Create a junction table 'OrderDetails' to handle the many-to-many relationship
CREATE TABLE OrderDetails (
    order_id INT NOT NULL,
    book_id INT NOT NULL,
    quantity INT NOT NULL,
    current_book_price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES `Order`(id),
    FOREIGN KEY (book_id) REFERENCES Book(id),
    PRIMARY KEY (order_id, book_id)
);