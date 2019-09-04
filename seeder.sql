use adlister_db;


insert into users(username, email, password, phone_number, city, state) values
        ('admin', 'admin@ad', 'ad', '000-232-3646', 'San Antonio', 'Texas'),
        ('Generic Username', 'generic@username', 'generic password', '012-345-6789', 'San Antonio', 'Texas'),
        ('Yolarr', 'Yolarr@yolarr', 'yolarr', '028-935-5753', 'San Antonio', 'Texas'),
        ('gs42', 'gs@ps', '24sg', '546-378-9495', 'San Antonio', 'Texas'),
        ('Mauruo', 'mmm@mmm', 'MTG', '428-369-0502', 'San Antonio', 'Texas');

insert into ads(user_id, title, description, price, picture) VALUES
        (1, 'h', 'h', '8.00', 'h.h'),
        (2, 'Selling Poptart', 'Selling a limited time flavor Crisp Apple Poptart', '7.00', 'poptart.jpg'),
        (3, 'looking for fish doctor', 'please help my fish drowned', '0.00', 'fish.jpg'),
        (4, 'Selling some Yugioh cards', 'Selling some old Yugioh cards that I don\'t need anymore, email me for details.', '10.00', 'cards.jpg'),
        (5, 'Ryobi Powerdrill', 'Ryobi Powerdrill in great condition!', '30.00', 'drill.jpg'),
        (1, 'Make your own necklace kit', 'Selling a make your own necklace kit.', '10.00', 'necklace.jpg'),
        (2, 'Autographed Basketball!', 'Basketball signed by Kevin Durant!', '1000.00', 'basketball.jpg'),
        (5, 'Selling steering wheel', 'Selling a steering wheel.', '5.00', 'wheel.jpg'),
        (4, 'Rocking chair', 'Found this rocking chair in my attic', '9.00', 'chair.jpg');


insert into categories (title) values
        ('games'),
        ('automotives'),
        ('furniture'),
        ('electronics'),
        ('jobs'),
        ('tools'),
        ('sports'),
        ('arts+crafts'),
        ('animals'),
        ('other');
