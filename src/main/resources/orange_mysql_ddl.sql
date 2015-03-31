/* DDL FOR MySQL DATABASE */

/*CREATE DATABASE IF NOT EXISTS ORANGE;*/

CREATE TABLE IF NOT EXISTS USER_ACCOUNT (
 ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
 USERNAME VARCHAR(50) NOT NULL UNIQUE,
 PASSWORD VARCHAR(50)
)
ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS CONTACT_INFO(
ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
TEL_PHONE VARCHAR(50),
FIXED_LINE_TELEPHONE VARCHAR(50),
FAX VARCHAR(50),
EMAIL VARCHAR(50),
USER_ACCOUNT_ID INT(10)
)
ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS ADDRESS (
ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
COUNTRY_ID INT(10),
CITY_ID INT(10),
DISTRICT_ID INT(10),
ZIP_CODE VARCHAR(50),
DETAILED_ADDRESS VARCHAR(100),
USER_ACCOUNT_ID INT(10)
)
ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS COUNTRY(
ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
NAME VARCHAR(100)
)
ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS CITY(
ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
COUNTRY_ID INT(10),
NAME VARCHAR(100)
)
ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS DISTRICT(
ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
CITY_ID INT(10),
NAME VARCHAR(100)
)
ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS PRODUCT(
ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
NAME VARCHAR(100) NOT NULL UNIQUE,
PRODUCT_TYPE VARCHAR(50),
INFO VARCHAR(50),
PRICE INT(20),
STOCK_ID INT(10)
)
ENGINE=InnoDB;
/* INFO: property key*/

CREATE TABLE IF NOT EXISTS STOCK(
ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
QUANTITY INT(10)
)
ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS ORDERED_ITEM(
ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
ORDERED_QUANTITY INT(10),
STATUS INT(1),
SHOPPING_CART_DATE TIMESTAMP,
ORDERED_DATE TIMESTAMP,
RECEIPT_DATE TIMESTAMP,
PRODUCT_ID INT(10),
USER_ACCOUNT_ID INT(10)
)
ENGINE=InnoDB;
/*Note: '0' indicates that the products in the shopping cart.
		'1' indicates that the products have been bought but the trade is in progress.
		'2' indicates that the products have been bought and trade has completed.
		'3' indicates that the products have been deleted by user after put into the shopping cart.	*/

CREATE TABLE IF NOT EXISTS PAY(
ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
BANK_NAME VARCHAR(50),
USER_ACCOUNT_ID INT(10),
ORDERED_ITEM_ID INT(10),
TOTAL_PRICE INT(10)
)
ENGINE=InnoDB;	

/* CONSTRAINT */
ALTER TABLE CONTACT_INFO ADD CONSTRAINT USER_ACCOUNT_ID_CONTACT_INFO_FK FOREIGN KEY (USER_ACCOUNT_ID) REFERENCES USER_ACCOUNT(ID);
ALTER TABLE ADDRESS ADD CONSTRAINT COUNTRY_ID_ADDRESS_FK FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRY(ID);
ALTER TABLE ADDRESS ADD CONSTRAINT CITY_ID_ADDRESS_FK FOREIGN KEY (CITY_ID) REFERENCES CITY(ID);
ALTER TABLE ADDRESS ADD CONSTRAINT DISTRICT_ID_ADDRESS_FK FOREIGN KEY (DISTRICT_ID) REFERENCES DISTRICT(ID);
ALTER TABLE ADDRESS  ADD CONSTRAINT USER_ACCOUNT_ID_ADDRESS_KEY FOREIGN KEY (USER_ACCOUNT_ID) REFERENCES USER_ACCOUNT(ID);
ALTER TABLE CITY ADD CONSTRAINT COUNTRY_ID_CITY_FK FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRY(ID);
ALTER TABLE DISTRICT ADD CONSTRAINT CITY_ID_DISTRICT_FK FOREIGN KEY (CITY_ID) REFERENCES CITY(ID);
ALTER TABLE PRODUCT ADD CONSTRAINT STOCK_ID_PRODUCT_FK FOREIGN KEY (STOCK_ID) REFERENCES STOCK(ID);
ALTER TABLE ORDERED_ITEM ADD CONSTRAINT PRODUCT_ID_ORDERED_ITEM_FK FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(ID);
ALTER TABLE ORDERED_ITEM ADD CONSTRAINT USER_ACCOUNT_ID_ORDERED_ITEM_FK FOREIGN KEY (USER_ACCOUNT_ID) REFERENCES USER_ACCOUNT(ID);
ALTER TABLE PAY ADD CONSTRAINT USER_ACCOUNT_ID_PAY_FK FOREIGN KEY (USER_ACCOUNT_ID) REFERENCES USER_ACCOUNT(ID);
ALTER TABLE PAY ADD CONSTRAINT ORDERED_ITEM_ID_PAY_FK FOREIGN KEY (ORDERED_ITEM_ID) REFERENCES ORDERED_ITEM(ID);
/* CONSTRAINT */

/* END */




















