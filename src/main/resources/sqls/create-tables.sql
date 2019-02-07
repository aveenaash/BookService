create database book_service_db;

use book_service_db;

create table books(
id bigint(10) not null auto_increment,
`name` varchar(50) not null,
description varchar(100) not null,
`year` int(4),
author_id bigint(10) not null,
primary key (id),
foreign key (author_id) references author(id)
);

create table author(
id bigint(10) not null auto_increment,
full_name varchar(50) not null,
email varchar(100) not null,
primary key (id)
); 

ALTER TABLE author ADD UNIQUE (email);