INSERT INTO student (id, name, email, dob) VALUES (DEFAULT, 'Dan', 'dan@gmail.com', '2000-01-01');
INSERT INTO student (id, name, email, dob) VALUES (DEFAULT, 'Joe', 'joe@gmail.com', '2005-06-12');
INSERT INTO student (id, name, email, dob) VALUES (DEFAULT, 'Don', 'don@gmail.com', '2009-10-11');
INSERT INTO student (id, name, email, dob) VALUES (DEFAULT, 'Dom', 'dom@gmail.com', '2010-02-21');
INSERT INTO student (id, name, email, dob) VALUES (DEFAULT, 'Sam', 'sam@gmail.com', '2012-07-18');
INSERT INTO student (id, name, email, dob) VALUES (DEFAULT, 'May', 'may@gmail.com', '1992-02-05');
INSERT INTO student (id, name, email, dob) VALUES (DEFAULT, 'BenGerman Thong', 'ben@gmail.com', '2002-04-20');

INSERT INTO users (id, fname, lname, email, password, locked, enabled) VALUES (DEFAULT, 'Bengo', '3022', 'bengo3022@gmail.com', '$2a$10$iH2k64N5T/OvKm0gfMaQnu.Hnnj/UrV7qa.UBXg4LsuzYc7FwHVya', 'false', 'true');

INSERT INTO event (id, name, startDate, endDate) VALUES (DEFAULT, 'Ben Bornday', '2002-05-20 13:00:00', '2002-05-20 14:00:00');

INSERT INTO chatroom (id, name, owner_id) VALUES (DEFAULT, 'Chat of Ben', 1);

INSERT INTO user_chatroom (id, user_id, chatroom_id) VALUES (DEFAULT, 1, 1);

INSERT INTO CHAT (id, sent_at, message, chatroom_id, sender_id) VALUES (DEFAULT, '2022-06-23 21:00:00', 'test message', 1, 1);
