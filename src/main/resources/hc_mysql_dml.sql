/* SEX ENUM('FEMALE','MALE') */
INSERT INTO USER(USERNAME,REAL_NAME,ENGLISH_NAME,PASSWORD,SEX,ID_NUMBER,ID_NUMBER_TYPE,CURRENT_COUNTRY,CURRENT_CITY) VALUES('email@email.com','Real Name','Cain','password','MALE','310229123456789','IDENTITY CARD','USA','San Diego');

/*  TYPE ENUM('EMAIL','TELEPHONE','OTHER') */
INSERT INTO CONTACT(INFO,TYPE,OTHER_DESCRIPTION,USER_ID) VALUES("email@email.com","EMAIL","",1);
INSERT INTO CONTACT(INFO,TYPE,OTHER_DESCRIPTION,USER_ID) VALUES("911","TELEPHONE","",1);
INSERT INTO CONTACT(INFO,TYPE,OTHER_DESCRIPTION,USER_ID) VALUES("123456","OTHER","WebChat",1);

/*  UNIVERSITY_DEGREE ENUM('BACHELOR','MASTER','DOCTOR','POST-DOCTOR','OTHER') */
INSERT INTO PERSONAL_HISTORY(UNIVERSITY,UNIVERSITY_DEGREE,GRADUATION_YEAR,USER_ID) VALUES("San Diego State University",'DOCTOR','2013',1);

/* TYPE ENUM('HONORARY TITLE', 'THESIS', 'INTELLECTUAL PROPERTY','OTHER') */
INSERT INTO AWARDS(TYPE,DESCRIPTION,REFERRER,OTHER,USER_ID) VALUES('HONORARY TITLE','Captain','Bill','',1);


































