use adlister_db;


insert into users(username, email, password, phone_number, city, state)
values('admin', 'admin@ad', 'ad', '000-232-3646', 'San Antonio', 'Texas'),
('Generic Username', 'generic@username', 'generic password', '012-345-6789', 'San Antonio', 'Texas'),
('Yolarr', 'Yolarr@yolarr', 'yolarr', '028-935-5753', 'San Antonio', 'Texas'),
('gs42', 'gs@ps', '24sg', '546-378-9495', 'San Antonio', 'Texas'),
('Mauruo', 'mmm@mmm', 'MTG', '428-369-0502', 'San Antonio', 'Texas');

insert into categories (title)
values ('games'),
       ('automotives'),
       ('furniture'),
       ('electronics'),
       ('jobs'),
       ('tools'),
       ('sports'),
       ('arts+crafts'),
       ('animals'),
       ('other');



