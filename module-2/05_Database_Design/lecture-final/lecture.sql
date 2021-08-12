
DROP TABLE IF EXISTS customer_purchase;
DROP TABLE IF EXISTS art;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer
(
    customerId serial,
    firstName varchar(64) NOT NULL,
    lastName varchar(64) NOT NULL,
    address varchar(128) NOT NULL,
    email varchar(128),
    phone varchar(11),
    
    CONSTRAINT pk_customer PRIMARY KEY (customerId) 

);

CREATE TABLE artist 
(
    artistId serial,
    firstName varchar(64) NOT NULL,
    lastName varchar(64) NOT NULL,
    
     CONSTRAINT pk_artist PRIMARY KEY (artistId) 

);

CREATE TABLE art 
(
    artId serial,
    title varchar(500) NOT NULL,
    artistId int NOT NULL,
    
     CONSTRAINT pk_art PRIMARY KEY (artId),
     CONSTRAINT fk_art_artist FOREIGN KEY (artistId) REFERENCES artist (artistId)
);

CREATE TABLE customer_purchase
(
    customerId int NOT NULL,
    artId int NOT NULL,
    purchaseDate timestamp NOT NULL,
    price money NOT NULL,
    
     CONSTRAINT pk_customer_purchase PRIMARY KEY (customerId, artId, purchaseDate),
     CONSTRAINT fk_customer_purchase_art FOREIGN KEY (artId) REFERENCES art (artId),
     CONSTRAINT fk_customer_purchase_customer FOREIGN KEY (customerId) REFERENCES customer (customerId) 
)


-- ADD STARTER DATA
-- INSERTS INTO EACH

