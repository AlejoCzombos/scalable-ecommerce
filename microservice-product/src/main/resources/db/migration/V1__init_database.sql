create table if not exists product_category (
    category_id bigint not null primary key,
    name varchar(255) not null unique,
    description varchar(255)
);

create table if not exists product (
    product_id bigint not null primary key,
    name varchar(255) not null unique,
    description varchar(255),
    unit_price decimal(10, 2) not null,
    stock int not null,
    image_url varchar(255),
    category_id bigint not null constraint fk_category_id references product_category(category_id)
);