CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(10),
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    birth_day INT,
    birth_month INT,
    birth_year INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    company VARCHAR(100),
    address VARCHAR(200),
    country VARCHAR(50),
    state VARCHAR(50),
    city VARCHAR(50),
    zipcode VARCHAR(20),
    mobile_number VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL,
    usertype VARCHAR(20) NOT NULL
);

CREATE TABLE brands (
    brand_id INT AUTO_INCREMENT PRIMARY KEY,
    brand_name VARCHAR(50) NOT NULL
);

CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    brand_id INT NOT NULL,
    category_id INT NOT NULL,
    FOREIGN KEY (brand_id) REFERENCES brands(brand_id),
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

CREATE TABLE shopping_cart (
    cart_item_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL DEFAULT 1 CHECK (quantity > 0),
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE,
    UNIQUE KEY unique_customer_product (customer_id, product_id)
);
INSERT INTO customers (title, name, email, password, birth_day, birth_month, birth_year, first_name, last_name, company, address, country, state, city, zipcode, mobile_number)
VALUES 
('Mr.', 'John Doe', 'customer1@example.com', 'Password1', 6, 12, 1981, 'John', 'Doe', 'Company1', '123 Street 1', 'Singapore', 'State1', 'City1', '71064', '1180054671'),
('Mrs.', 'Jane Smith', 'customer2@example.com', 'Password2', 18, 3, 1989, 'Jane', 'Smith', 'Company2', '123 Street 2', 'Singapore', 'State2', 'City2', '45203', '1076102414'),
('Mrs.', 'Alice Johnson', 'customer3@example.com', 'Password3', 19, 5, 2007, 'Alice', 'Johnson', 
     'Company3', '123 Street 3', 'Australia', 'State3', 'City3', '45942', '1390459947'),
     
    ('Mr.', 'Bob Brown', 'customer4@example.com', 'Password4', 23, 4, 1998, 'Bob', 'Brown', 
     'Company4', '123 Street 4', 'Australia', 'State4', 'City4', '20879', '1601776644'),
     
    ('Mr.', 'Charlie Davis', 'customer5@example.com', 'Password5', 24, 4, 1996, 'Charlie', 'Davis', 
     'Company5', '123 Street 5', 'New Zealand', 'State5', 'City5', '57838', '1844684260');

INSERT INTO categories (category_name, usertype) VALUES
('Tops', 'Women'), ('Tshirts', 'Men'), ('Dress', 'Women'),
('Tops & Shirts', 'Kids'), ('Jeans', 'Men'), ('Saree', 'Women');

INSERT INTO brands (brand_name) VALUES
('Polo'), ('H&M'), ('Madame'), ('Mast & Harbour'), ('Babyhug'),
('Allen Solly Junior'), ('Kookie Kids'), ('Biba');

INSERT INTO products (product_id, product_name, price, brand_id, category_id) VALUES
(1, 'Blue Top', 500.00, 1, 1),
(2, 'Men Tshirt', 400.00, 2, 2),
(3, 'Sleeveless Dress', 1000.00, 3, 3),
(4, 'Stylish Dress', 1500.00, 3, 3),
(5, 'Winter Top', 600.00, 4, 1),
(6, 'Summer White Top', 400.00, 2, 1),
(7, 'Madame Top For Women', 1000.00, 3, 1),
(8, 'Fancy Green Top', 700.00, 1, 1),
(11, 'Sleeves Printed Top - White', 499.00, 5, 4),
(12, 'Half Sleeves Top Schiffli Detailing - Pink', 359.00, 5, 4),
(13, 'Frozen Tops For Kids', 278.00, 6, 4),
(14, 'Full Sleeves Top Cherry - Pink', 679.00, 7, 4),
(15, 'Printed Off Shoulder Top - White', 315.00, 5, 4),
(16, 'Sleeves Top and Short - Blue & Pink', 478.00, 5, 3),
(18, 'Little Girls Mr. Panda Shirt', 1200.00, 7, 4),
(19, 'Sleeveless Unicorn Patch Gown - Pink', 1050.00, 6, 3),
(20, 'Cotton Mull Embroidered Dress', 1190.00, 7, 3),
(21, 'Blue Cotton Indie Mickey Dress', 1530.00, 8, 3),
(22, 'Long Maxi Tulle Fancy Dress Up Outfits -Pink', 1600.00, 8, 3),
(23, 'Sleeveless Unicorn Print Fit & Flare Net Dress - Multi', 1100.00, 8, 3),
(24, 'Colour Blocked Shirt – Sky Blue', 849.00, 6, 4),
(28, 'Pure Cotton V-Neck T-Shirt', 1299.00, 2, 2),
(29, 'Green Side Placket Detail T-Shirt', 1000.00, 1, 2),
(30, 'Premium Polo T-Shirts', 1500.00, 1, 2),
(31, 'Pure Cotton Neon Green Tshirt', 850.00, 2, 2),
(33, 'Soft Stretch Jeans', 799.00, 1, 5),
(35, 'Regular Fit Straight Jeans', 1200.00, 2, 5),
(37, 'Grunt Blue Slim Fit Jeans', 1400.00, 1, 5),
(38, 'Rose Pink Embroidered Maxi Dress', 2300.00, 3, 3),
(39, 'Cotton Silk Hand Block Print Saree', 3000.00, 8, 6),
(40, 'Rust Red Linen Saree', 3500.00, 8, 6),
(41, 'Beautiful Peacock Blue Cotton Linen Saree', 5000.00, 3, 6),
(42, 'Lace Top For Women', 1400.00, 4, 1),
(43, 'GRAPHIC DESIGN MEN T SHIRT - BLUE', 1389.00, 4, 2);

INSERT INTO shopping_cart (customer_id, product_id, quantity)
VALUES 
(1, 1, 2),  -- Customer 1 adds 2 Blue Tops
(1, 3, 1),  -- Customer 1 adds 1 Sleeveless Dress
(2, 2, 3)   -- Customer 2 adds 3 Men Tshirts
ON DUPLICATE KEY UPDATE quantity = quantity + VALUES(quantity);

SELECT 
    c.name AS customer_name,
    p.product_name,
    p.price AS unit_price,
    sc.quantity,
    (p.price * sc.quantity) AS total_price,
    sc.added_at
FROM 
    shopping_cart sc
JOIN 
    customers c ON sc.customer_id = c.customer_id
JOIN 
    products p ON sc.product_id = p.product_id
WHERE 
    sc.customer_id = 1;

SELECT 
    c.name AS customer_name,
    SUM(p.price * sc.quantity) AS cart_total
FROM 
    shopping_cart sc
JOIN 
    customers c ON sc.customer_id = c.customer_id
JOIN 
    products p ON sc.product_id = p.product_id
WHERE 
    sc.customer_id = 1;


UPDATE shopping_cart 
SET quantity = 5 
WHERE customer_id = 1 AND product_id = 1;

DELETE FROM shopping_cart 
WHERE customer_id = 1 AND product_id = 3;

DELETE FROM shopping_cart 
WHERE customer_id = 1;
