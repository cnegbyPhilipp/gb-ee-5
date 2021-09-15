drop schema if exists gb_ee_5;

create schema gb_ee_5;

use gb_ee_5;

drop table if exists products;

create table products
(
    id    bigint not null
        primary key AUTO_INCREMENT,
    title varchar(255),
    price int
);

insert into products (title, price)
VALUES ('product1', '100'),
       ('product2', '200');
