-- Create the 'Order' table
CREATE TABLE `Order` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    books_display VARCHAR(255) NOT NULL,
    totalPrice DECIMAL(10, 2) NOT NULL
);