insert into TRANSACTION values(1,'TUESDAY','10:12:45 PM','some description here.',12.50,'REVENUE');
insert into TRANSACTION values(2,'WEDNESDAY','10:12:45 PM','some description here.',15.50,'EXPENSE');
insert into TRANSACTION values(3,'MONDAY','10:12:45 PM','some description here.',18.50,'REVENUE');
insert into TRANSACTION values(4,'SUNDAY','10:12:45 PM','some description here.',10.50,'EXPENSE');

INSERT INTO users(id,username,Encrypted_Password)
VALUES (1,'bill','$2a$10$bRyIb0GbafP2rviKvkTDXukswVczuw.qG6bq8vEFCRFBbK6tkQVnq');

INSERT INTO roles (id, user_id, role) VALUES (1, 1, 'ROLE_ADMIN');
INSERT INTO roles (id, user_id, role) VALUES (2, 1, 'ROLE_USER');