DROP TABLE IF EXISTS [product_order];
DROP TABLE IF EXISTS [product];
DROP TABLE IF EXISTS [category_translation];
DROP TABLE IF EXISTS [category];
DROP TABLE IF EXISTS [order];
DROP TABLE IF EXISTS [users];
DROP TABLE IF EXISTS [promotion];

CREATE TABLE [promotion] (
    id int IDENTITY(1, 1),
    [name] varchar(50) NOT NULL,
    [percent] int NOT NULL,
    [start_date] date NOT NULL,
    end_date date NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE [users] (
    email varchar(50),
    password varchar(100) DEFAULT NULL,
    last_name varchar(50) NOT NULL,
    first_name varchar(50) NOT NULL,
    phone_number varchar(25),
    gender int,
    birth_date date NOT NULL,
    street varchar(100) NOT NULL,
    city varchar(50) NOT NULL,
    postal_code varchar(10) NOT NULL,
    country varchar(50) NOT NULL,

    AUTHORITIES varchar(500) NOT NULL,
    NON_EXPIRED bit NOT NULL,
    NON_LOCKED bit NOT NULL,
    CREDENTIALS_NON_EXPIRED bit NOT NULL,
    ENABLED bit NOT NULL,

    PRIMARY KEY (email) 
);

CREATE TABLE [order] (
    id int IDENTITY(1, 1),
    [date] date NOT NULL,
    payment_date date,
    reception_date date,
    user_email varchar(50) NOT NULL,
    promotion_id int,

    FOREIGN KEY (user_email) REFERENCES [users](email),
    FOREIGN KEY (promotion_id) REFERENCES [promotion](id),

    PRIMARY KEY (id)
);

CREATE TABLE [category] (
    id int IDENTITY(1, 1),
    [image] varchar(100) DEFAULT 'no_image.jpg',

    PRIMARY KEY (id)
);

CREATE TABLE [category_translation] (
    category_name varchar(100) NOT NULL,
    category_id int,
    language_name varchar(5),

    FOREIGN KEY (category_id) REFERENCES [category](id),
    PRIMARY KEY (category_id, language_name)
);


CREATE TABLE [product] (
    reference int,
    [name] varchar(50) NOT NULL,
    brand varchar(50) NOT NULL,
    price decimal(5, 2) NOT NULL,
    quantity_left int NOT NULL,
    is_salable bit NOT NULL,
    [description] varchar(500) NOT NULL,
    [image] varchar(100),
    product_category int NOT NULL,

    FOREIGN KEY (product_category) REFERENCES [category](id),
    PRIMARY KEY (reference)
);


CREATE TABLE [product_order] (
    id int IDENTITY(1, 1),
    quantity int NOT NULL,
    unit_price decimal(5, 2) NOT NULL,
    product_reference int NOT NULL,
    order_id int NOT NULL,

    FOREIGN KEY (product_reference) REFERENCES [product](reference),
    FOREIGN KEY (order_id) REFERENCES [order](id),

    PRIMARY KEY (id)
);



INSERT INTO category (image) VALUES 
('entretien_exterieur.jpg'),
('security.jpg');

INSERT INTO category_translation (category_name, language_name, category_id) VALUES 
('Exterior maintenance', 'en', 1),
('Entretien extérieur', 'fr', 1),
('Security','en',2),
('Sécurité et panne', 'fr', 2);


INSERT INTO product (reference, name, brand, price, quantity_left, is_salable, description, image, product_category) VALUES 
(7316, 'Lave-glace hiver', 'Auto M&M', 4.60, 10, 1, 'Lave-glace résistant aux températures hivernales</br> - Jusqu''à -30 dégrés !', '7316.jpg', 1);








