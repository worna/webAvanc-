DROP TABLE IF EXISTS [product_order];
DROP TABLE IF EXISTS [product_for];
DROP TABLE IF EXISTS [product];
DROP TABLE IF EXISTS [model];
DROP TABLE IF EXISTS [brand];
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

    FOREIGN KEY (user_email) REFERENCES [user](email),
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

CREATE TABLE [brand] (
    [name] varchar(50),

    PRIMARY KEY ([name])
);

CREATE TABLE [model] (
    [name] varchar(50),
    year_start int NOT NULL,
    year_end int NOT NULL,
    model_brand varchar(50),

    FOREIGN KEY (model_brand) REFERENCES [brand]([name]),
    PRIMARY KEY ([name], model_brand)
);

CREATE TABLE [product] (
    reference int,
    [name] varchar(50) NOT NULL,
    brand varchar(50) NOT NULL,
    price decimal NOT NULL,
    quantity_left int NOT NULL,
    is_salable bit NOT NULL,
    [description] varchar(500) NOT NULL,
    [image] varchar(100),
    product_category int NOT NULL,

    FOREIGN KEY (product_category) REFERENCES [category](id),
    PRIMARY KEY (reference)
);

CREATE TABLE [product_for] (
    product_reference int NOT NULL,
    model_name varchar(50) NOT NULL,
    model_brand varchar(50) NOT NULL,

    FOREIGN KEY (product_reference) REFERENCES [product](reference),
    FOREIGN KEY (model_name, model_brand) REFERENCES [model]([name], model_brand),

    PRIMARY KEY (product_reference, model_name, model_brand)
);

CREATE TABLE [product_order] (
    id int IDENTITY(1, 1),
    quantity int NOT NULL,
    unit_price decimal NOT NULL,
    product_reference int NOT NULL,
    order_id int NOT NULL,

    FOREIGN KEY (product_reference) REFERENCES [product](reference),
    FOREIGN KEY (order_id) REFERENCES [order](id),

    PRIMARY KEY (id)
);

INSERT INTO category (image) VALUES ('courroie.jpg'), ('rotule.jpg'),('no_image.jpg'),('suspension.jpg'),('no_image.jpg'),('no_image.jpg'),('no_image.jpg'),('no_image.jpg'),('no_image.jpg');

INSERT INTO category_translation (category_name, language_name, category_id) VALUES ('Belt','en',1),('Steering knuckle ','en',2),('Filter','en',3),('Suspension','en',4),('5','en',5),('Brake discs','en',6),('7','en',7),('8','en',8),('9','en',9),('Courroie','fr',1),('Rotule','fr',2),('Filtre','fr',3),('Suspension','fr',4),('5','fr',5),('Disques de frein','fr',6),('7','fr',7),('8','fr',8),('9','fr',9);

INSERT INTO product (reference, name, brand, price, quantity_left, is_salable, description, image, product_category) VALUES 
(1,'Jeu de 2 disques de frein ','Valeo', 44.39,78,1,'Côté d''assemblage : Essieu avant<br/>Type de disque de frein : ventilé<br/>Diamètre [mm] : 286<br/>Épaisseur du disque de frein [mm] : 22<br/>Nombre de trous : 5<br/>Hauteur [mm] : 52<br/>à partir d''année de construction : 01/2003<br/>jusque année de construction : 03/2004<br/>Diamètre du centrage [mm] : 79<br/>Montage Essieu : avant', 'frein.jpg', 6),(2,'Jeu de 2 disques de frein  (Réf : 562103JC )','Jurid',87.89,17,1,'Côté d''assemblage Essieu : avant<br/>Type de disque de frein : ventilé<br/>Diamètre [mm] : 280<br/>Épaisseur du disque de frein [mm] : 24<br/>Nombre de trous : 4<br/>Hauteur [mm] : 44<br/>Diamètre du centrage [mm] : 61<br/>Protection anticorrosion : revêtu<br/>Accessoires avec : vis/boulons<br/>Montage Essieu : avant','frein.jpg', 6),(3,'Jeu de 2 disques de frein  (Réf : 562430JC )','Jurid',139.90,0,1,'Côté d''assemblage Essieu : avant<br/>Type de disque de frein : ventilé<br/>Diamètre [mm] : 295<br/>Épaisseur du disque de frein [mm] : 26<br/>Nombre de trous : 5<br/>Hauteur [mm] : 50<br/>Diamètre du centrage [mm] : 62<br/>Protection anticorrosion : revêtu<br/>Accessoires : sans vis/boulons<br/>Montage Essieu : avant', 'frein.jpg',6);