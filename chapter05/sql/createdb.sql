CREATE DATABASE chapter05_dao;

USE chapter05_dao;

CREATE TABLE employees (
  employee_id varchar(50) NOT NULL,
  first_name varchar(100) default NULL,
  last_name varchar(100) default NULL,
  email varchar(100) default NULL,
  PRIMARY KEY  (employee_id)
) TYPE=MyISAM;


INSERT INTO employees VALUES 
(1,'Dave','Glyzewski','dave.glyzewski@centare.com');
INSERT INTO employees VALUES (2,'Ed','Chaltry','ed.chaltry@centare.com');
INSERT INTO employees VALUES (3,'Dustin','Smith','dustin.smith@centare.com');
INSERT INTO employees VALUES (4,'Phil','Jones','phil.jones@centare.com');
INSERT INTO employees VALUES 
(5,'Kevin','Williams','kevin.williams@centare.com');
INSERT INTO employees VALUES (6,'Dale','Busse','dale.busse@centare.com');
INSERT INTO employees VALUES (7,'Joe','Bookman','joe.bookman@centare.com');
INSERT INTO employees VALUES 
(8,'Sharon','Stillman','sharon.stillman@centare.com');
INSERT INTO employees VALUES (9,'Scott','Knaffla','scott.knaffla@centare.com');
INSERT INTO employees VALUES 
(10,'Becky','Glyzewski','becky.glyzewski@centare.com');
INSERT INTO employees VALUES 
(11,'Matt','Bumgardner','matt.bumgardner@centare.com');
INSERT INTO employees VALUES (12,'Aimee','Ukasick','aimee.ukasick@centare.com');
INSERT INTO employees VALUES (13,'Rick','Sperko','rick.sperko@centare.com');
INSERT INTO employees VALUES 
(14,'John','Henderson','john.henderson@centare.com');
INSERT INTO employees VALUES (15,'Susan','Tomczak','susan.tomczak@centare.com');
INSERT INTO employees VALUES (16,'John','Carnell','john.carnell@centare.com');
INSERT INTO employees VALUES (17,'Andrew','Patzer','andrew.patzer@centare.com');
INSERT INTO employees VALUES (18,'Jay','Marshall','jay.marshall@centare.com');
INSERT INTO employees VALUES 
(19,'George','Kowalski','george.kowalski@centare.com');
INSERT INTO employees VALUES (20,'Damon','Payne','damon.payne@centare.com');

