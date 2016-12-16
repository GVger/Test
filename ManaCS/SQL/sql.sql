CREATE DATABASE ManaCS;

USE ManaCS;

CREATE TABLE tab_user(
user_id AUTOINCREMENT(1,1) PRIMARY KEY,
user_name VARCHAR(50),
user_psw VARCHAR(50)
);

CREATE TABLE tab_in(
in_id AUTOINCREMENT(1,1) PRIMARY KEY,
user_id INT,
money_in INT,
date_in DATETIME,
CONSTRAINT user_id_in_fk FOREIGN KEY (user_id) REFERENCES tab_user (user_id)
);

CREATE TABLE tab_out(
out_id AUTOINCREMENT(1,1) PRIMARY KEY,
user_id INT,
money_out INT,
date_out DATETIME,
 CONSTRAINT user_id_out_fk FOREIGN KEY (user_id) REFERENCES tab_user (user_id)
);

DROP DATABASE ManaCS;