create table if not exists db_user
(
    id bigint not null primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    email varchar(255) not null unique,
    password varchar(255) not null,
    phone varchar(255),
    role varchar(255) not null
);