create database chapter06;

use chapter06;


CREATE TABLE employees (
	oid varchar(100) NOT NULL  , 
	first_name varchar(255)   , 
	last_name varchar(255)   , 
	employed bit   , 
	date_of_birth datetime   , 
	num_dependants tinyint    ,
	PRIMARY KEY (oid)	
);



