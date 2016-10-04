--drop database chapter12;

create database chapter12;

use chapter12;

-- MySQL dump 8.22
--
-- Host: localhost    Database: chapter12
---------------------------------------------------------
-- Server version	3.23.53-max-nt

--
-- Table structure for table 'addresses'
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
-- Dumping data for table 'addresses'
--


INSERT INTO addresses VALUES (112,'456 S. East St.','Suite 246','Milwaukee','WI');
INSERT INTO addresses VALUES (111,'123 N. West St.','Suite 134','Chicago','IL');
INSERT INTO addresses VALUES (121,'789 E. North St.','Suite 789','Milwaukee','WI');

--
-- Table structure for table 'cb_clauses'
--

CREATE TABLE cb_clauses (
  objectName varchar(64) default NULL,
  clauseType varchar(8) default NULL,
  clauselevel int(11) default NULL,
  clauseOrder int(11) default NULL,
  phrase_conjunctive char(3) default NULL,
  phrase_lhs_field varchar(64) default NULL,
  phrase_lhs_value varchar(64) default NULL,
  phrase_operand varchar(8) default NULL,
  phrase_rhs_field varchar(64) default NULL,
  phrase_rhs_value varchar(64) default NULL,
  phrase_not int(11) default NULL,
  KEY cb_clause_name (objectName),
  KEY cb_clause_type (clauseType),
  KEY cb_clause_Order (clauseOrder)
) TYPE=MyISAM;

--
-- Dumping data for table 'cb_clauses'
--


INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','update',1,2,'AND','EMPLOYEES.LAST_NAME',NULL,'=',NULL,':LAST_NAME',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','update',1,1,'AND','EMPLOYEES.FIRST_NAME',NULL,'=',NULL,':FIRST_NAME',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','delete',1,3,'AND','EMPLOYEES.EMAIL',NULL,'=',NULL,':EMAIL',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','update',1,0,NULL,'EMPLOYEES.EMPLOYEE_ID',NULL,'=',NULL,':ID',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','delete',1,2,'AND','EMPLOYEES.LAST_NAME',NULL,'=',NULL,':LAST_NAME',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','delete',1,1,'AND','EMPLOYEES.FIRST_NAME',NULL,'=',NULL,':FIRST_NAME',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','delete',1,0,NULL,'EMPLOYEES.EMPLOYEE_ID',NULL,'=',NULL,':ID',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','insert',1,3,'AND','EMPLOYEES.EMAIL',NULL,'=',NULL,':EMAIL',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','insert',1,2,'AND','EMPLOYEES.LAST_NAME',NULL,'=',NULL,':LAST_NAME',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','insert',1,1,'AND','EMPLOYEES.FIRST_NAME',NULL,'=',NULL,':FIRST_NAME',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','insert',1,0,NULL,'EMPLOYEES.EMPLOYEE_ID',NULL,'=',NULL,':ID',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','select',1,3,'AND','EMPLOYEES.EMAIL',NULL,'=',NULL,':EMAIL',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','select',1,2,'AND','EMPLOYEES.LAST_NAME',NULL,'=',NULL,':LAST_NAME',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','update',1,4,'AND','ADDRESSES.STREET_LINE2',NULL,'=',NULL,':STREET_LINE_2',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','update',1,2,'AND','ADDRESSES.CITY',NULL,'=',NULL,':CITY',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','update',1,3,'AND','ADDRESSES.STREET_LINE1',NULL,'=',NULL,':STREET_LINE_1',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','update',1,1,'AND','ADDRESSES.STATE',NULL,'=',NULL,':STATE',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','update',1,0,NULL,'ADDRESSES.ADDRESS_ID',NULL,'=',NULL,':ID',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','delete',1,4,'AND','ADDRESSES.STREET_LINE2',NULL,'=',NULL,':STREET_LINE_2',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','delete',1,3,'AND','ADDRESSES.STREET_LINE1',NULL,'=',NULL,':STREET_LINE_1',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','delete',1,1,'AND','ADDRESSES.STATE',NULL,'=',NULL,':STATE',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','delete',1,2,'AND','ADDRESSES.CITY',NULL,'=',NULL,':CITY',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','insert',1,4,'AND','ADDRESSES.STREET_LINE2',NULL,'=',NULL,':STREET_LINE_2',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','delete',1,0,NULL,'ADDRESSES.ADDRESS_ID',NULL,'=',NULL,':ID',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','insert',1,3,'AND','ADDRESSES.STREET_LINE1',NULL,'=',NULL,':STREET_LINE_1',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','insert',1,0,NULL,'ADDRESSES.ADDRESS_ID',NULL,'=',NULL,':ID',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','insert',1,1,'AND','ADDRESSES.STATE',NULL,'=',NULL,':STATE',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','insert',1,2,'AND','ADDRESSES.CITY',NULL,'=',NULL,':CITY',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','select',1,4,'AND','ADDRESSES.STREET_LINE2',NULL,'=',NULL,':STREET_LINE_2',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','select',1,1,'AND','EMPLOYEES.FIRST_NAME',NULL,'=',NULL,':FIRST_NAME',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','select',1,0,NULL,'EMPLOYEES.EMPLOYEE_ID',NULL,'=',NULL,':ID',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','select',1,3,'AND','ADDRESSES.STREET_LINE1',NULL,'=',NULL,':STREET_LINE_1',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','select',1,1,'AND','ADDRESSES.STATE',NULL,'=',NULL,':STATE',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','select',1,2,'AND','ADDRESSES.CITY',NULL,'=',NULL,':CITY',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','select',1,0,NULL,'ADDRESSES.ADDRESS_ID',NULL,'=',NULL,':ID',0);
INSERT INTO cb_clauses VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','update',1,3,'AND','EMPLOYEES.EMAIL',NULL,'=',NULL,':EMAIL',0);

--
-- Table structure for table 'cb_fields'
--

CREATE TABLE cb_fields (
  objectName varchar(64) default NULL,
  clauseType varchar(8) default NULL,
  dbTableName varchar(64) default NULL,
  dbCatalogName varchar(64) default NULL,
  dbSchemaName varchar(64) default NULL,
  dbFieldName varchar(64) default NULL,
  dbFieldValue varchar(64) default NULL,
  objectOrder int(11) default NULL,
  direction int(11) default NULL,
  dbType int(11) default NULL,
  dispType varchar(64) default NULL,
  KEY cb_fields_name (objectName),
  KEY cb_fields_type (clauseType),
  KEY cb_fields_object_Order (objectOrder)
) TYPE=MyISAM;

--
-- Dumping data for table 'cb_fields'
--


INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','update','EMPLOYEES',NULL,'','FIRST_NAME',':FIRST_NAME',1,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','delete','EMPLOYEES',NULL,'','EMAIL',':EMAIL',3,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','update','EMPLOYEES',NULL,'','EMPLOYEE_ID',':ID',0,0,-5,'BIGINT');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','delete','EMPLOYEES',NULL,'','LAST_NAME',':LAST_NAME',2,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','delete','EMPLOYEES',NULL,'','FIRST_NAME',':FIRST_NAME',1,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','insert','EMPLOYEES',NULL,'','EMAIL',':EMAIL',3,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','delete','EMPLOYEES',NULL,'','EMPLOYEE_ID',':ID',0,0,-5,'BIGINT');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','insert','EMPLOYEES',NULL,'','LAST_NAME',':LAST_NAME',2,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','insert','EMPLOYEES',NULL,'','FIRST_NAME',':FIRST_NAME',1,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','insert','EMPLOYEES',NULL,'','EMPLOYEE_ID',':ID',0,0,-5,'BIGINT');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','select','EMPLOYEES',NULL,'','EMAIL',':EMAIL',3,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','select','EMPLOYEES',NULL,'','ADDRESS_ID',':ADDRESS_ID',4,0,-5,NULL);
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','select','EMPLOYEES',NULL,'','LAST_NAME',':LAST_NAME',2,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','update','ADDRESSES',NULL,'','STREET_LINE2',':STREET_LINE_2',4,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','update','ADDRESSES',NULL,'','CITY',':CITY',2,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','update','ADDRESSES',NULL,'','STREET_LINE1',':STREET_LINE_1',3,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','update','ADDRESSES',NULL,'','STATE',':STATE',1,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','update','ADDRESSES',NULL,'','ADDRESS_ID',':ID',0,0,-5,'BIGINT');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','delete','ADDRESSES',NULL,'','STREET_LINE1',':STREET_LINE_1',3,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','delete','ADDRESSES',NULL,'','STREET_LINE2',':STREET_LINE_2',4,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','delete','ADDRESSES',NULL,'','STATE',':STATE',1,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','delete','ADDRESSES',NULL,'','CITY',':CITY',2,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','insert','ADDRESSES',NULL,'','STREET_LINE2',':STREET_LINE_2',4,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','delete','ADDRESSES',NULL,'','ADDRESS_ID',':ID',0,0,-5,'BIGINT');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','insert','ADDRESSES',NULL,'','STREET_LINE1',':STREET_LINE_1',3,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','insert','ADDRESSES',NULL,'','ADDRESS_ID',':ID',0,0,-5,'BIGINT');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','insert','ADDRESSES',NULL,'','STATE',':STATE',1,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','insert','ADDRESSES',NULL,'','CITY',':CITY',2,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','select','ADDRESSES',NULL,'','STREET_LINE2',':STREET_LINE_2',4,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','update','EMPLOYEES',NULL,'','LAST_NAME',':LAST_NAME',2,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','select','EMPLOYEES',NULL,'','FIRST_NAME',':FIRST_NAME',1,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','select','EMPLOYEES',NULL,'','EMPLOYEE_ID',':ID',0,0,-5,'BIGINT');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','select','ADDRESSES',NULL,'','STREET_LINE1',':STREET_LINE_1',3,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','select','ADDRESSES',NULL,'','STATE',':STATE',1,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','select','ADDRESSES',NULL,'','CITY',':CITY',2,0,12,'VARCHAR');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','select','ADDRESSES',NULL,'','ADDRESS_ID',':ID',0,0,-5,'BIGINT');
INSERT INTO cb_fields VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','update','EMPLOYEES',NULL,'','EMAIL',':EMAIL',3,0,12,'VARCHAR');

--
-- Table structure for table 'cb_objects'
--

CREATE TABLE cb_objects (
  objectName varchar(64) default NULL,
  className varchar(64) default NULL,
  DefaultReadSize int(11) default NULL,
  AppVersion varchar(32) default NULL,
  ClassVersion int(11) default NULL,
  dateTimeStamp datetime default NULL,
  KEY cb_objects_name (objectName)
) TYPE=MyISAM;

--
-- Dumping data for table 'cb_objects'
--


INSERT INTO cb_objects VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee','com.apress.javapersist.chapter12.cocobase.bo.Employee',100,'3.02',3,'2003-04-06 16:09:21');
INSERT INTO cb_objects VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address','com.apress.javapersist.chapter12.cocobase.bo.Address',100,'3.02',4,'2003-04-06 16:08:09');

--
-- Table structure for table 'cb_tables'
--

CREATE TABLE cb_tables (
  objectName varchar(64) default NULL,
  dbCatalogName varchar(64) default NULL,
  dbSchemaName varchar(64) default NULL,
  dbTableName varchar(250) default NULL,
  clauseType varchar(8) default NULL,
  KEY cb_tables_name (objectName)
) TYPE=MyISAM;

--
-- Dumping data for table 'cb_tables'
--


INSERT INTO cb_tables VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee',NULL,'','EMPLOYEES','update');
INSERT INTO cb_tables VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee',NULL,'','EMPLOYEES','delete');
INSERT INTO cb_tables VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee',NULL,'','EMPLOYEES','insert');
INSERT INTO cb_tables VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Employee',NULL,'','EMPLOYEES','select');
INSERT INTO cb_tables VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address',NULL,'','ADDRESSES','update');
INSERT INTO cb_tables VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address',NULL,'','ADDRESSES','insert');
INSERT INTO cb_tables VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address',NULL,'','ADDRESSES','delete');
INSERT INTO cb_tables VALUES ('com.apress.javapersist.chapter12.cocobase.bo.Address',NULL,'','ADDRESSES','select');

--
-- Table structure for table 'employees'
--

CREATE TABLE employees (
  employee_id int(11) NOT NULL default '0',
  first_name varchar(100) default '',
  last_name varchar(100) default '',
  email varchar(100) default '',
  address_id int(11) default '0',
  PRIMARY KEY  (employee_id)
) TYPE=MyISAM;

--
-- Dumping data for table 'employees'
--


INSERT INTO employees VALUES (271,'Dave','Glyzewski','dave.glyzewski@centare.com',112);
INSERT INTO employees VALUES (281,'Ed','Chaltry','ed.chaltry@centare.com',112);
INSERT INTO employees VALUES (291,'Dale','Busse','dale.busse@centare.com',111);
INSERT INTO employees VALUES (100,'Rick','Sperko','rick.sperko@centare.com',NULL);
INSERT INTO employees VALUES (10,'Rick','Sperko','rick.sperko@centare.com',112);

