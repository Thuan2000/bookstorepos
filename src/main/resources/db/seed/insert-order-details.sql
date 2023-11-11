-- Assuming the IDs of the books are 1, 2, and 3, and the order IDs are 1 and 2,
-- we insert fake data into the 'OrderDetails' table.
-- This data must correlate with the IDs from the 'Book' and 'Order' tables.
INSERT INTO OrderDetails (order_id, book_id, quantity, current_book_price) VALUES
(1, 1, 1, 19.99), -- Order 1 contains 1 copy of Book 1
(1, 2, 1, 29.99), -- Order 1 also contains 1 copy of Book 2
(2, 3, 1, 15.99); -- Order 2 contains 1 copy of Book 3
