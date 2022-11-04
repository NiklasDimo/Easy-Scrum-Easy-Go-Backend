Create table product(
                        id int auto_increment,
                        name varchar(255) NOT NULL,
                        currency varchar(10) NOT NULL,
                        price double NOT NULL,
                        description varchar(255) NOT NULL,
                        category varchar(255) NOT NULL
);

Insert into product(name, currency, price, description, category) values ('Nintendo Switch', '€', 5.99, 'Ein sehr gutes Gerät', 'Konsole');