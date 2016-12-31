drop database if exists mvcexample;
create database if not exists mvcexample;

use mvcexample;

create table users (
    id int not null primary key auto_increment,
    email varchar(60) not null,
    password char(18) not null
)engine=innodb;

insert into users values(null, "developerdiego0@gmail.com", "mypassword"), (null, "guestuser@gmail.com", "123456");
