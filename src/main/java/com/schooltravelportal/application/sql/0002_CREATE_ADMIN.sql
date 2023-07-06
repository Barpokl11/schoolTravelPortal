create table admin (
    id bigint auto_increment primary key,
    email varchar(320) unique,
    login varchar(40) unique,
    password varchar(40)
);