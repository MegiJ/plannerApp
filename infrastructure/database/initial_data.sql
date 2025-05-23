CREATE TABLE ACCOUNT_DETAILS (
ID SERIAL NOT NULL PRIMARY KEY,
ROLE VARCHAR (10),
IS_EXPIRED BOOLEAN DEFAULT FALSE,
IS_LOCKED BOOLEAN DEFAULT FALSE,
IS_CREDENTIALS_EXPIRED BOOLEAN DEFAULT FALSE,
IS_DISABLED BOOLEAN DEFAULT FALSE
);

CREATE TABLE LOGGING_DATA (
ID SERIAL NOT NULL PRIMARY KEY,
LOGIN VARCHAR(20) NOT NULL UNIQUE,
PASSWORD VARCHAR(150) NOT NULL,
ACCOUNT_DETAILS_ID INT NOT NULL,
FOREIGN KEY (ACCOUNT_DETAILS_ID) REFERENCES ACCOUNT_DETAILS
);

CREATE TABLE PERSONAL_DATA (
ID SERIAL NOT NULL PRIMARY KEY,
FIRSTNAME VARCHAR(30) NOT NULL,
SURNAME VARCHAR(30) NOT NULL,
PHONE INT,
EMAIL VARCHAR(30) UNIQUE,
LOGGING_DATA_ID INT NOT NULL,
FOREIGN KEY (LOGGING_DATA_ID) REFERENCES LOGGING_DATA(ID)
);

CREATE TABLE DIET (
ID SERIAL NOT NULL PRIMARY KEY,
DATE_OF_DIET TIMESTAMP NOT NULL,
MEAL VARCHAR(100) NOT NULL,
LOGGING_DATA_ID INT NOT NULL,
 FOREIGN KEY (LOGGING_DATA_ID) REFERENCES LOGGING_DATA(ID)
);

CREATE TABLE TODO (
ID SERIAL NOT NULL PRIMARY KEY,
DATE_TODO DATE NOT NULL,
NOTE VARCHAR(200) NOT NULL,
IS_COMPLETED BOOLEAN DEFAULT FALSE,
LOGGING_DATA_ID INT NOT NULL,
 FOREIGN KEY (LOGGING_DATA_ID) REFERENCES LOGGING_DATA(ID)
);

CREATE TABLE TRAINING (
ID SERIAL NOT NULL PRIMARY KEY,
DATE_TRAINING DATE NOT NULL,
EXERCISE VARCHAR(200) NOT NULL,
LOGGING_DATA_ID INT NOT NULL,
 FOREIGN KEY (LOGGING_DATA_ID) REFERENCES LOGGING_DATA(ID)
);

INSERT INTO ACCOUNT_DETAILS VALUES (1, 'ADMIN', FALSE, FALSE, FALSE, FALSE);
INSERT INTO LOGGING_DATA VALUES (1, 'magdaj', 'password123', 1);
INSERT INTO PERSONAL_DATA VALUES (1, 'Magda', 'Jot', 501111111, 'magdajot@gmail.com', 1);
INSERT INTO DIET VALUES (1, '2024-04-15T19:10:25+02', 'salatka', 1);
INSERT INTO TODO VALUES (1, '2024-04-15', 'zrob obiad', FALSE, 1);
INSERT INTO TRAINING VALUES (1, '2024-04-15', 'bieganie', 1);

SELECT setval('DIET_ID_SEQ', (SELECT MAX(ID) FROM DIET));
SELECT setval('PERSONAL_DATA_ID_SEQ', (SELECT MAX(ID) FROM PERSONAL_DATA));
SELECT setval('TODO_ID_SEQ', (SELECT MAX(ID) FROM TODO));
SELECT setval('TRAINING_ID_SEQ', (SELECT MAX(ID) FROM TRAINING));
SELECT setval('LOGGING_DATA_ID_SEQ', (SELECT MAX(ID) FROM LOGGING_DATA));
SELECT setval('ACCOUNT_DETAILS_ID_SEQ', (SELECT MAX(ID) FROM ACCOUNT_DETAILS));