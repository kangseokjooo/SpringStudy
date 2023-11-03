CREATE TABLE person
(
    id bigint not null AUTO_INCREMENT,
    user_id varchar(255) not null,
    password varchar(255) not null,
    name varchar(255) not null,
    primary key(id)

);