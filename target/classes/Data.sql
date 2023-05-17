-- User :

INSERT INTO ACCOUNT(USERNAME,EMAIL,NAME,LASTNAME,PASSWORD,FULLNAME,COUNTRY,GENDER,DESCRIPTION)
VALUES ( 'Vanlı','vanli@van.com','Rakip','Vali','1234','Rakip Vali','Turkey','Erkek','bir garip vanli');

INSERT INTO ACCOUNT(USERNAME,EMAIL,NAME,LASTNAME,PASSWORD,FULLNAME,COUNTRY,GENDER,DESCRIPTION)
VALUES ( 'YOZGALI','yoz@gat.com','Veli','Art','1234','Veli Art','Turkey','Erkek','bir garip yozgatli');

INSERT INTO ACCOUNT(USERNAME,EMAIL,NAME,LASTNAME,PASSWORD,FULLNAME,COUNTRY,GENDER,DESCRIPTION)
VALUES ( 'KONYALI','kon@ya.com','Rifki','Isim','1234','Rifki Isim','Turkey','Erkek','bir garip konyali');

INSERT INTO ACCOUNT (USERNAME,EMAIL,NAME,LASTNAME,PASSWORD,FULLNAME,COUNTRY,GENDER,DESCRIPTION)
VALUES ( 'ISTANBULLU','ist@bul.com','Berksu','Sucu','1234','Berksu Sucu','Turkey','Erkek','istanbullu');

INSERT INTO ACCOUNT(USERNAME,EMAIL,NAME,LASTNAME,PASSWORD,FULLNAME,COUNTRY,GENDER,DESCRIPTION)
VALUES ( 'DIYAR','deli@diyar.com','Ahmet','Er','1234','Ahmet Er','Turkey','Erkek','Bir deli');

INSERT INTO ACCOUNT(USERNAME,EMAIL,NAME,LASTNAME,PASSWORD,FULLNAME,COUNTRY,GENDER,DESCRIPTION)
VALUES ( 'GEZGIN','gez@gin.com','Gezici','Gezer','1234','Gezici Gezer','Turkey','Erkek','Gezer Okur');

INSERT INTO ACCOUNT(USERNAME,EMAIL,NAME,LASTNAME,PASSWORD,FULLNAME,COUNTRY,GENDER,DESCRIPTION)
VALUES ( 'ERMIS','er@mis.com','Eren','El','1234','Eren El','Turkey','Erkek','Ermeden Erilmez');

-- Admin :

INSERT INTO `ADMIN`(EMAIL, NAME, LASTNAME, USERNAME)
VALUES ( 'fatih@fg.com','Fatih','Gonkayali','fthgnk');


-- PostComment :

INSERT INTO COMMENT (TEXT, USER_ID, POST_ID)
VALUES ('Naber', '1', 2);
INSERT INTO COMMENT (TEXT, USER_ID, POST_ID)
VALUES ('IYI', '2', 1);
INSERT INTO COMMENT (TEXT, USER_ID, POST_ID)
VALUES ('SEN', '3', 2);
INSERT INTO COMMENT (TEXT, USER_ID, POST_ID)
VALUES ('BEN', '2', 2);
INSERT INTO COMMENT (TEXT, USER_ID, POST_ID)
VALUES ('O', '1', 3);

-- POST  :

INSERT INTO POST (TEXT, MEDIA, USER_ID)
VALUES ('Bugun ne yaptim', 'asdasdada', 1);

INSERT INTO POST (TEXT, MEDIA, USER_ID)
VALUES ('Bugun ne yaptim', 'asdasdada',2);

INSERT INTO POST (TEXT, MEDIA, USER_ID)
VALUES ('Dun ne yaptim', 'asdasdada', 3);

INSERT INTO POST (TEXT, MEDIA, USER_ID)
VALUES ('Yarin ne yaptim', 'asdasdada', 4);

INSERT INTO POST (TEXT, MEDIA, USER_ID)
VALUES ('Simdi ne yaptim', 'asdasdada', 1);

INSERT INTO POST (TEXT, MEDIA, USER_ID)
VALUES ('O zaman ne yaptim', 'asdasdada', 2);

INSERT INTO POST (TEXT, MEDIA, USER_ID)
VALUES ('Genel ne yaptim', 'asdasdada', 3);


-- PostLike  :

INSERT INTO LIKES (USER_ID, POST_ID)
VALUES(1, 2);
INSERT INTO LIKES (USER_ID, POST_ID)
VALUES(2, 2);
INSERT INTO LIKES (USER_ID, POST_ID)
VALUES(3, 2);
INSERT INTO LIKES (USER_ID, POST_ID)
VALUES(4, 2);
INSERT INTO LIKES (USER_ID, POST_ID)
VALUES(1, 3);
INSERT INTO LIKES (USER_ID, POST_ID)
VALUES(1, 4);
INSERT INTO LIKES (USER_ID, POST_ID)
VALUES(1, 5);
INSERT INTO LIKES (USER_ID, POST_ID)
VALUES(1, 1);

--friendship

INSERT INTO FRIENDSHIP (QUE_USER_ID,ACC_USER_ID)
VALUES ()
