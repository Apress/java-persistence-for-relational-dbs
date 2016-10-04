--drop database chapter12;

create database chapter12;

use chapter12;

-- MySQL dump 8.22
--
-- Host: localhost    Database: chapter12
---------------------------------------------------------
-- Server version	3.23.53-max-nt

--
-- Table structure for table 'address'
--

CREATE TABLE addresses (
  address_id int(11) NOT NULL default '0',
  street_line1 varchar(100) default '',
  street_line2 varchar(100) default '',
  city varchar(100) default '',
  state char(2) default '',
  PRIMARY KEY  (address_id)
) TYPE=MyISAM;

--
-- Dumping data for table 'address'
--


INSERT INTO addresses VALUES (112,'456 S. East St.','Suite 246','Milwaukee','WI');
INSERT INTO addresses VALUES (111,'123 N. West St.','Suite 134','Chicago','IL');
INSERT INTO addresses VALUES (121,'789 E. North St.','Suite 789','Milwaukee','WI');

--
-- Table structure for table 'employees'
--

CREATE TABLE employees (
  employee_id int(11) NOT NULL default '0',
  first_name varchar(100) default '',
  last_name varchar(100) default '',
  email varchar(100) default '',
  address_id int(11) default '0' NULL,
  PRIMARY KEY  (employee_id)
) TYPE=MyISAM;

--
-- Dumping data for table 'employees'
--


INSERT INTO employees VALUES (271,'Dave','Glyzewski','dave.glyzewski@centare.com',111);
INSERT INTO employees VALUES (281,'Ed','Chaltry','ed.chaltry@centare.com',112);
INSERT INTO employees VALUES (291,'Dale','Busse','dale.busse@centare.com',121);
