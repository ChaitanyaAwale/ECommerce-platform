INSERT INTO category (name)
VALUES
    ('Electronics'),
    ('Fashion'),
    ('Books');

INSERT INTO users (username, email, password, role)
VALUES
    ('chaitanya', '[chaitanya@gmail.com](mailto:chaitanya@gmail.com)', 'password123', 'CUSTOMER'),
    ('rahul', '[rahul@gmail.com](mailto:rahul@gmail.com)', 'password123', 'CUSTOMER'),
    ('priya', '[priya@gmail.com](mailto:priya@gmail.com)', 'password123', 'CUSTOMER');

INSERT INTO product
(name, description, price, stock_quantity, image_url, category_id)
VALUES
    ('iPhone 15',
     'Apple flagship smartphone',
     79999.00,
     15,
     'iphone15.jpg',
     1),

    ('Samsung Galaxy S24',
     'Samsung premium smartphone',
     74999.00,
     20,
     's24.jpg',
     1),

    ('MacBook Air M3',
     'Apple lightweight laptop',
     119999.00,
     10,
     'macbook.jpg',
     1),

    ('Nike Air Max',
     'Running shoes',
     5999.00,
     25,
     'nike.jpg',
     2),

    ('Atomic Habits',
     'Self improvement book',
     499.00,
     100,
     'atomichabits.jpg',
     3);

INSERT INTO carts (user_id)
VALUES
    (1),
    (2),
    (3);

INSERT INTO cart_item (quantity, cart_id, product_id)
VALUES
    (2, 1, 1),
    (1, 1, 5),

    (1, 2, 2),
    (3, 2, 4),

    (1, 3, 3);

INSERT INTO address
(street, city, state, country, pincode, user_id)
VALUES
    ('Civil Lines',
     'Nagpur',
     'Maharashtra',
     'India',
     '440001',
     1),

    ('Dharampeth',
     'Nagpur',
     'Maharashtra',
     'India',
     '440010',
     2),

    ('Sitabuldi',
     'Nagpur',
     'Maharashtra',
     'India',
     '440012',
     3);
