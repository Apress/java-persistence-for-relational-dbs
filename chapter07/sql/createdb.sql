CREATE DATABASE chapter07_testing;

USE chapter07_testing;

CREATE TABLE shopping_carts (
  uid bigint NOT NULL,
  started date NOT NULL,
  PRIMARY KEY  (uid)
) TYPE=MyISAM;

CREATE TABLE items (
  uid bigint NOT NULL,
  description varchar(50) NOT NULL,
  dollars int NOT NULL,
  cents int NOT NULL,
  PRIMARY KEY (uid)
) TYPE=MyISAM;

CREATE TABLE shopping_cart_items_assoc (
  cart_uid bigint NOT NULL,
  item_uid bigint NOT NULL
) TYPE=MyISAM;

INSERT INTO items VALUES (1,'Ping Pong Table',100,50);
INSERT INTO items VALUES (2,'Roller Blades',99,95);
INSERT INTO items VALUES (3,'Running Shoes',89,75);
INSERT INTO items VALUES (4,'Tent',150,99);

INSERT INTO shopping_carts VALUES ( 1, '2002-10-02 22:12:05' );
INSERT INTO shopping_carts VALUES ( 2, '2002-10-02 22:14:05' );

INSERT INTO shopping_cart_items_assoc VALUES ( 1, 1 );
INSERT INTO shopping_cart_items_assoc VALUES ( 1, 3 );
INSERT INTO shopping_cart_items_assoc VALUES ( 2, 1 );
INSERT INTO shopping_cart_items_assoc VALUES ( 2, 2 );
INSERT INTO shopping_cart_items_assoc VALUES ( 2, 4 );