DROP database chapter09;

CREATE database chapter09;

use chapter09;


--
-- Table structure for table 'zip_code'
--

CREATE TABLE zip_codes (
  zip_code_id int(11) NOT NULL default '0',
  first_five char(5) NOT NULL,
  last_four char(4),
  PRIMARY KEY  (zip_code_id)
) TYPE=MyISAM;

INSERT INTO zip_codes VALUES (0, '12345', '6789');
INSERT INTO zip_codes VALUES (1, '23456', '78901');

--
-- Table structure for table 'address'
--

CREATE TABLE addresses (
  address_id int(11) NOT NULL default '0',
  street_line1 varchar(100) default '',
  street_line2 varchar(100) default '',
  city varchar(100) default '',
  state char(2) default '',
  zip_code_id int(11),
  PRIMARY KEY  (address_id)
) TYPE=MyISAM;

--
-- Dumping data for table 'address'
--


INSERT INTO addresses VALUES (112,'456 S. East St.','Suite 246','Milwaukee','WI', 0);
INSERT INTO addresses VALUES (111,'123 N. West St.','Suite 134','Chicago','IL', 1);
INSERT INTO addresses VALUES (121,'789 E. North St.','Suite 789','Milwaukee','WI', 0);

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


--- These are OJB specific tables for this example
CREATE TABLE ojb_nrm (
  NAME varchar(250) NOT NULL default '',
  OID_ longblob,
  PRIMARY KEY  (NAME)
) TYPE=MyISAM;

CREATE TABLE ojb_hl_seq (
  TABLENAME varchar(175) NOT NULL default '',
  FIELDNAME varchar(70) NOT NULL default '',
  MAX_KEY int(11) default NULL,
  GRAB_SIZE int(11) default NULL,
  PRIMARY KEY  (TABLENAME,FIELDNAME)
) TYPE=MyISAM;

CREATE TABLE ojb_dlist (
  ID int(11) NOT NULL default '0',
  SIZE_ int(11) default NULL,
  PRIMARY KEY  (ID)
) TYPE=MyISAM;

CREATE TABLE ojb_dlist_entries (
  ID int(11) NOT NULL default '0',
  DLIST_ID int(11) NOT NULL default '0',
  POSITION_ int(11) default NULL,
  OID_ longblob,
  PRIMARY KEY  (ID)
) TYPE=MyISAM;
