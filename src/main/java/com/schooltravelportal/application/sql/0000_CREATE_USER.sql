create table user (
    id bigint auto_increment primary key,
    email varchar(320) unique,
    login varchar(40) unique,
    password varchar(40),
    first_name varchar(40),
    last_name varchar(40),
    school varchar(200) unique
);