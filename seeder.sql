use adlister_db;
insert into users(username, email, password, phone_number, city, state) values('admin', 'admin@ad', 'ad', '000-232-3646', 'San Antonio', 'Texas');
insert into users(username, email, password, phone_number, city, state) values('Generic Username', 'generic@username', 'generic password', '012-345-6789', 'San Antonio', 'Texas');
insert into users(username, email, password, phone_number, city, state) values('Yolarr', 'Yolarr@yolarr', 'yolarr', '028-935-5753', 'San Antonio', 'Texas');
insert into users(username, email, password, phone_number, city, state) values('gs42', 'gs@ps', '24sg', '546-378-9495', 'San Antonio', 'Texas');
insert into users(username, email, password, phone_number, city, state) values('Mauruo', 'mmm@mmm', 'MTG', '428-369-0502', 'San Antonio', 'Texas');

insert into ads(user_id, title, description, price, picture) VALUES(1, 'h', 'h', '9.00', 'h.h');
insert into ads(user_id, title, description, price, picture) VALUES(2, 'Selling Poptart', 'Selling a limited time flavor Crisp Apple Poptart', '7.00', 'poptart.jpg');
insert into ads(user_id, title, description, price, picture) VALUES(3, 'looking for fish doctor', 'please help my fish drowned', '0.00', 'fish.jpg');
insert into ads(user_id, title, description, price, picture) VALUES(4, 'Selling some Yugioh cards', 'Selling some old Yugioh cards that I don\'t need anymore, email me for details.', '10.00', 'cards.h');
insert into ads(user_id, title, description, price, picture) VALUES(5, 'Ryobi Powerdrill', 'Ryobi Powerdrill in great condition!', '30.00', 'drill.jpg');
insert into ads(user_id, title, description, price, picture) VALUES(1, 'Make your own necklace kit', 'Selling a make your own necklace kit.', '10.00', 'necklace.jpg');
insert into ads(user_id, title, description, price, picture) VALUES(1, 'Autographed Basketball!', 'Basketball signed by Kevin Durant!', '1000.00', 'basketball.jpg');
insert into ads(user_id, title, description, price, picture) VALUES(1, 'Selling steering wheel', 'Selling a steering wheel.', '5.00', 'wheel.jpg');
insert into ads(user_id, title, description, price, picture) VALUES(1, 'Rocking chair', 'Found this rocking chair in my attic', '9.00', 'chair.jpg');

insert into categories (category) values ('games');
insert into categories (category) values ('automotives');
insert into categories (category) values ('furniture');
insert into categories (category) values ('electronics');
insert into categories (category) values ('jobs');
insert into categories (category) values ('tools');
insert into categories (category) values ('sports');
insert into categories (category) values ('arts+crafts');
insert into categories (category) values ('animals');
insert into categories (category) values ('other');
