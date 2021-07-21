create table products (
                          id                      bigserial primary key,
                          title                   varchar(255),
                          price                   int,
                          created_at              timestamp default current_timestamp,
                          updated_at              timestamp default current_timestamp
);

insert into products (title, price)
values
('Bread', 24),
('Milk', 65),
('Cheese', 320),
('Cheese2', 322),
('Cheese3', 323),
('Cheese4', 324),
('Cheese5', 325),
('Cheese6', 326),
('Cheese7', 327),
('Cheese8', 328),
('Cheese9', 400),
('Cheese10', 528),
('Cheese11', 628),
('Cheese12', 728),
('Cheese13', 828),
('Cheese14', 928),
('Cheese15', 1025),
('Cheese16', 106),
('Cheese17', 1027),
('Cheese18', 10328),
('Cheese19', 3028),
('Cheese20', 1328),
('Cheese21', 2328),
('Cheese22', 3328),
('Cheese23', 3728),
('Cheese24', 3628),
('Cheese25', 4328);