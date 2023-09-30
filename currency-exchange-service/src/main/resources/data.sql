create table if not exists currency_exchange (
    id int auto_increment primary key,
    currency_from varchar(255),
    currency_to varchar(255),
    conversion_multiple double ,
    environment int
);
insert into currency_exchange(id, currency_from, currency_to, conversion_multiple, environment) values (1000, 'VND', 'USD', 27, 0);
insert into currency_exchange(id, currency_from, currency_to, conversion_multiple, environment) values (1001, 'EUR', 'USD', 28, 0);
insert into currency_exchange(id, currency_from, currency_to, conversion_multiple, environment) values (1002, 'AUD', 'USD', 29, 0);