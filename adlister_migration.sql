use adlister_db;

CREATE TABLE categories (
        id INT UNSIGNED NOT NULL AUTO_INCREMENT,
        cat_id int(10),
        ad_id int(10),
        PRIMARY KEY (id)
);