create table if not exists db_user (
    user_id bigint not null primary key,
    email varchar(255) not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    password varchar(255) not null,
    phone varchar(255),
    role varchar(255) not null check (role in ('ADMIN','EMPLOYEE','CUSTOMER')),
    primary key (user_id),
    constraint UK6mh6gc6k1iu7htpabhhn6rcvr unique (email)
)