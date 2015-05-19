/* DDL FOR MySQL DATABASE */

/*CREATE DATABASE IF NOT EXISTS HC;*/

CREATE TABLE USER (
 ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
 USERNAME VARCHAR(50) NOT NULL UNIQUE,
 REAL_NAME VARCHAR(50),
 ENGLISH_NAME VARCHAR(50),
 PASSWORD VARCHAR(50),
 SEX INT,
 ID_NUMBER VARCHAR(50),
 ID_NUMBER_TYPE INT,
 CURRENT_COUNTRY VARCHAR(50),
 CURRENT_CITY VARCHAR(50),
 PORTRAIT VARCHAR(50),
 CREATE_TIME TIMESTAMP,
 UPDATE_TIME TIMESTAMP
)
ENGINE=InnoDB;

CREATE TABLE CONTACT (
 ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
 INFO VARCHAR(50),
 TYPE INT,
 OTHER_DESCRIPTION VARCHAR(10),
 STATUS INT,
 USER_ID INT(10),
 CREATE_TIME TIMESTAMP,
 UPDATE_TIME TIMESTAMP
)
ENGINE=InnoDB;

CREATE TABLE PERSONAL_HISTORY (
 ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
 UNIVERSITY VARCHAR(50),
 UNIVERSITY_DEGREE INT,
 MAJOR VARCHAR(50),
 GRADUATION_YEAR YEAR(4),
 USER_ID INT(10),
 CREATE_TIME TIMESTAMP,
 UPDATE_TIME TIMESTAMP
)
ENGINE=InnoDB;


CREATE TABLE AWARD (
 ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
 TYPE INT,
 DESCRIPTION VARCHAR(50),
 REFERRER VARCHAR(50),
 OTHER VARCHAR(50),
 USER_ID INT(10),
 CREATE_TIME TIMESTAMP,
 UPDATE_TIME TIMESTAMP
)
ENGINE=InnoDB;

CREATE TABLE JOB_ASKED (
 ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
 PRO_FIELD VARCHAR(50) NOT NULL,
 TITLE VARCHAR(50) NOT NULL,
 OFFICE_AREA VARCHAR(50),
 WORK_TIME_TYPE INT,
 EXPECT_SALARY VARCHAR(10),
 REQUIREMENT VARCHAR(200),
 USER_ID INT(10),
 CREATE_TIME TIMESTAMP,
 UPDATE_TIME TIMESTAMP
)
ENGINE=INNODB;

CREATE TABLE ENTERPRISE (
 ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
 NAME VARCHAR(50) NOT NULL,
 ADDRESS VARCHAR(50) NOT NULL,
 TYPE INT,
 AREA_CODE INT,
 CONTACT_NUMBER INT,
 FAX INT,
 TELEPHONE INT,
 EMAIL VARCHAR(50),
 CREATE_TIME TIMESTAMP,
 UPDATE_TIME TIMESTAMP
)
ENGINE=INNODB;

CREATE TABLE PROJECT (
 ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
 NAME VARCHAR(50) NOT NULL,
 SUMMARY VARCHAR(50) NOT NULL,
 ATTACHMENT VARCHAR(50),
 ENTERPRISE_ID INT(10),
 CREATE_TIME TIMESTAMP,
 UPDATE_TIME TIMESTAMP
)
ENGINE=INNODB;

CREATE TABLE ENTERPRISE_DETAIL (
 ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
 ORATION VARCHAR(50),
 INTRODUCTION VARCHAR(50),
 ADVANTAGE VARCHAR(50),
 PROVIDE VARCHAR(50),
 OTHER VARCHAR(50),
 ENTERPRISE_ID INT(10),
 CREATE_TIME TIMESTAMP,
 UPDATE_TIME TIMESTAMP
)
ENGINE=INNODB;

CREATE TABLE MEDIA (
 ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
 VIDEO VARCHAR(50),
 VIDEO_DESC VARCHAR(50),
 PICTURE VARCHAR(50),
 PICTURE_DESC VARCHAR(50),
 ENTERPRISE_DETAIL_ID INT(10),
 CREATE_TIME TIMESTAMP,
 UPDATE_TIME TIMESTAMP
)
ENGINE=INNODB;

CREATE TABLE JOB_POSTED (
 ID INT(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
 TITLE VARCHAR(50) NOT NULL,
 OFFICE_AREA VARCHAR(50),
 SALARY VARCHAR(10),
 AREA_CODE INT,
 CONTACT_NUMBER INT,
 EMAIL VARCHAR(50),
 CONTACT_PERSON VARCHAR(50),
 CONTACT_ADDRESS VARCHAR(50),
 JOB_DESC VARCHAR(50),
 JOB_REQUIREMENT VARCHAR(200),
 COMPANY_INTRODUCTION VARCHAR(200),
 ENTERPRISE_ID INT(10),
 CREATE_TIME TIMESTAMP,
 UPDATE_TIME TIMESTAMP
)
ENGINE=INNODB;

/* CONSTRAINT */
ALTER TABLE CONTACT ADD CONSTRAINT USER_ID_CONTACT_FK FOREIGN KEY (USER_ID) REFERENCES USER(ID);
ALTER TABLE PERSONAL_HISTORY ADD CONSTRAINT USER_ID_PERSONAL_HISTORY_FK FOREIGN KEY (USER_ID) REFERENCES USER(ID);
ALTER TABLE AWARD ADD CONSTRAINT USER_ID_AWARD_FK FOREIGN KEY (USER_ID) REFERENCES USER(ID);
ALTER TABLE JOB_ASKED ADD CONSTRAINT USER_ID_JOB_ASKED_FK FOREIGN KEY (USER_ID) REFERENCES USER(ID);
ALTER TABLE PROJECT ADD CONSTRAINT ENTERPRISE_ID_PROJECT_FK FOREIGN KEY (ENTERPRISE_ID) REFERENCES ENTERPRISE(ID);
ALTER TABLE ENTERPRISE_DETAIL ADD CONSTRAINT ENTERPRISE_ID_ENTERPRISE_DETAIL_FK FOREIGN KEY (ENTERPRISE_ID) REFERENCES ENTERPRISE(ID);
ALTER TABLE MEDIA ADD CONSTRAINT ENTERPRISE_DETAIL_ID_MEDIA_FK FOREIGN KEY (ENTERPRISE_DETAIL_ID) REFERENCES ENTERPRISE_DETAIL(ID);
ALTER TABLE JOB_POSTED ADD CONSTRAINT ENTERPRISE_ID_JOB_POSTED_FK FOREIGN KEY (ENTERPRISE_ID) REFERENCES ENTERPRISE(ID);
/* CONSTRAINT */

/* END */