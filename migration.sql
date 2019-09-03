USE adlister_db;
DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS categs_ads;

CREATE TABLE users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       username VARCHAR(240) NOT NULL UNIQUE,
                       email VARCHAR(240) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       phone_number VARCHAR(20) NOT NULL,
                       city VARCHAR(100) NOT NULL,
                       state VARCHAR(100) NOT NULL,
                       PRIMARY KEY (id)
);

CREATE TABLE categories (
                            id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            title VARCHAR(100) NOT NULL
);
CREATE TABLE ads (
                     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                     user_id INT UNSIGNED NOT NULL,
                     title VARCHAR(240) NOT NULL,
                     description TEXT NOT NULL,
                     price DECIMAL(6,2) NOT NULL,
                     listed_on DATETIME DEFAULT NOW(),
                     picture TEXT,
#                      category_id INT UNSIGNED NOT NULL,
#                      FOREIGN KEY (category_id) references categories(id),
                     PRIMARY KEY (id),
                     FOREIGN KEY (user_id) REFERENCES users(id)
                         ON DELETE CASCADE
);




CREATE TABLE categs_ads (
                            categ_id INT UNSIGNED NOT NULL,
                            ad_id INT UNSIGNED NOT NULL,
                            FOREIGN KEY (categ_id) REFERENCES categories(id),
                            FOREIGN KEY (ad_id) REFERENCES ads(id)
);







# CREATE TABLE categories (
#                             id INT UNSIGNED NOT NULL AUTO_INCREMENT,
#                             category VARCHAR(30) NOT NULL,
#                             PRIMARY KEY (id)
# );
#
# CREATE TABLE cats_ads (
#                           cat_id INT UNSIGNED NOT NULL,
#                           ad_id INT UNSIGNED NOT NULL,
#                           FOREIGN KEY (cat_id) REFERENCES categories(id)
#                               ON DELETE CASCADE,
#                           FOREIGN KEY (ad_id) REFERENCES ads(id)
#                               ON DELETE CASCADE
# );


