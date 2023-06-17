DELETE FROM NOTES;
DELETE FROM CATEGORIES;
DELETE FROM USERS;
INSERT INTO CATEGORIES(category_id,category_name)
VALUES (0,'gotowanie'),(1,'ważne'),(2,'przypominajki');
INSERT INTO USERS(name,surname,login,password,age,role_id)
values ('admin','admin','admin','admin',30,1),
       ('user1','user1','user1','user1',40,3),
       ('user2','user2','user2','user2',40,2);
INSERT INTO NOTES(title,content,link,add_date,reminder_date,category_id,user_id)
VALUES('przepis','Żabie udka w sosie','www.wp.pl','2023-06-05','2023-06-07',(select CATEGORY_ID FROM CATEGORIES WHERE CATEGORIES.CATEGORY_NAME='gotowanie'),(select user_id from USERS where users.login='user1')),
('abrakdabra','czarna magia','www.onet.pl','2023-06-04','2023-06-06',(select CATEGORY_ID FROM CATEGORIES WHERE CATEGORIES.CATEGORY_NAME='ważne'),(select user_id from USERS where users.login='user1'));
