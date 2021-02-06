DROP TABLE IF EXISTS SL_INV;
DROP TABLE IF EXISTS SL_PRODUCT;
CREATE TABLE SL_INV(id int, date Date, file varchar(250));

CREATE TABLE SL_PRODUCT(id int AUTO_INCREMENT  PRIMARY KEY, name varchar(250) NOT NULL, 
	price int,  quantity int);
