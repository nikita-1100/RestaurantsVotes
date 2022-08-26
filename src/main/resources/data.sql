INSERT INTO users(name, password)
VALUES ('user', '$2a$10$4Z8t3oFmIBxtM8A3weStpu.yQvFhf58elywRsg1eEzVzpUza0mXDC'),
       ('user2', '$2a$10$4Z8t3oFmIBxtM8A3weStpu.yQvFhf58elywRsg1eEzVzpUza0mXDC'),
       ('user3', '$2a$10$4Z8t3oFmIBxtM8A3weStpu.yQvFhf58elywRsg1eEzVzpUza0mXDC'),
       ('user4', '$2a$10$4Z8t3oFmIBxtM8A3weStpu.yQvFhf58elywRsg1eEzVzpUza0mXDC'),
       ('user5', '$2a$10$4Z8t3oFmIBxtM8A3weStpu.yQvFhf58elywRsg1eEzVzpUza0mXDC'),
       ('user6', '$2a$10$4Z8t3oFmIBxtM8A3weStpu.yQvFhf58elywRsg1eEzVzpUza0mXDC'),
       ('user7', '$2a$10$4Z8t3oFmIBxtM8A3weStpu.yQvFhf58elywRsg1eEzVzpUza0mXDC'),
       ('user8', '$2a$10$4Z8t3oFmIBxtM8A3weStpu.yQvFhf58elywRsg1eEzVzpUza0mXDC'),
       ('user9', '$2a$10$4Z8t3oFmIBxtM8A3weStpu.yQvFhf58elywRsg1eEzVzpUza0mXDC'),
       ('user10', '$2a$10$4Z8t3oFmIBxtM8A3weStpu.yQvFhf58elywRsg1eEzVzpUza0mXDC'),
       ('admin', '$2a$10$4Z8t3oFmIBxtM8A3weStpu.yQvFhf58elywRsg1eEzVzpUza0mXDC');

INSERT INTO user_role(user_id, role)
VALUES (1, 'USER'),
       (2, 'USER'),
       (3, 'USER'),
       (4, 'USER'),
       (5, 'USER'),
       (6, 'USER'),
       (7, 'USER'),
       (8, 'USER'),
       (9, 'USER'),
       (10, 'USER'),
       (11,'ADMIN');

INSERT INTO restaurant(name)
VALUES ('Tokio city'),
       ('Eurasia'),
       ('Kebab-24'),
       ('Mamaroma');

INSERT INTO vote (date, restaurant_name,user_id)
VALUES ('2022-08-01','Eurasia',1),
--
       ('2022-08-02','Eurasia',1),
       ('2022-08-02','Eurasia',2),
       ('2022-08-02','Eurasia',3),
       ('2022-08-02','Kebab-24',5),
       ('2022-08-02','Tokio city',6),
       ('2022-08-02','Eurasia',7),
       ('2022-08-02','Kebab-24',9),
       ('2022-08-02','Tokio city',10),
--
       ('2022-08-03','Tokio city',1),
       ('2022-08-03','Tokio city',2),
       ('2022-08-03','Tokio city',3),
       ('2022-08-03','Tokio city',4),
       ('2022-08-03','Tokio city',5),
       ('2022-08-03','Mamaroma',6),
       ('2022-08-03','Mamaroma',7),
       ('2022-08-03','Mamaroma',8),
       ('2022-08-03','Mamaroma',9),
       ('2022-08-03','Mamaroma',10),
--
--
('2022-08-05','Kebab-24',1),
('2022-08-05','Kebab-24',5),
('2022-08-05','Kebab-24',8),
('2022-08-05','Kebab-24',10);

INSERT INTO menu(restaurant_name, dish_name, price, date)
VALUES ('Tokio city', 'chicken poke', 289, '2022-08-01'),
       ('Tokio city', 'fried mushrooms', 349, '2022-08-01'),
       ('Tokio city', 'fruit tea', 149, '2022-08-01'),
       ('Tokio city', 'pancakes with cream', 279, '2022-08-01'),
       ('Eurasia', 'Philadelphia roll', 399, '2022-08-01'),
       ('Eurasia', 'California roll', 369, '2022-08-01'),
       ('Eurasia', 'green tea', 129, '2022-08-01'),
       ('Eurasia', 'sashimi', 559, '2022-08-01'),
       ('Kebab-24', 'kebab', 120, '2022-08-01'),
       ('Kebab-24', 'double kebab', 170, '2022-08-01'),
       ('Kebab-24', 'mexico kebab', 160, '2022-08-01'),
       ('Kebab-24', 'fried potatoes', 80, '2022-08-01'),
       ('Mamaroma', 'pasta carbonara', 290, '2022-08-01'),
       ('Mamaroma', 'peperoni pizza', 240, '2022-08-01'),
       ('Mamaroma', 'salmon with vegetables', 460, '2022-08-01'),
       ('Mamaroma', 'homemade vine', 165, '2022-08-01'),

       ('Tokio city', 'chicken poke', 289, '2022-08-02'),
       ('Tokio city', 'fried mushrooms', 349, '2022-08-02'),
       ('Tokio city', 'fruit tea', 149, '2022-08-02'),
       ('Tokio city', 'pancakes with cream', 279, '2022-08-02'),
       ('Eurasia', 'Philadelphia roll', 399, '2022-08-02'),
       ('Eurasia', 'California roll', 369, '2022-08-02'),
       ('Eurasia', 'green tea', 129, '2022-08-02'),
       ('Eurasia', 'sashimi', 559, '2022-08-02'),
       ('Kebab-24', 'kebab', 120, '2022-08-02'),
       ('Kebab-24', 'double kebab', 170, '2022-08-02'),
       ('Kebab-24', 'mexico kebab', 160, '2022-08-02'),
       ('Kebab-24', 'fried potatoes', 80, '2022-08-02'),
       ('Mamaroma', 'pasta carbonara', 290, '2022-08-02'),
       ('Mamaroma', 'peperoni pizza', 240, '2022-08-02'),
       ('Mamaroma', 'salmon with vegetables', 460, '2022-08-02'),
       ('Mamaroma', 'homemade vine', 165, '2022-08-02'),

       ('Tokio city', 'chicken poke', 289, '2022-08-03'),
       ('Tokio city', 'fried mushrooms', 349, '2022-08-03'),
       ('Tokio city', 'fruit tea', 149, '2022-08-03'),
       ('Tokio city', 'pancakes with cream', 279, '2022-08-03'),
       ('Eurasia', 'Philadelphia roll', 399, '2022-08-03'),
       ('Eurasia', 'California roll', 369, '2022-08-03'),
       ('Eurasia', 'green tea', 129, '2022-08-03'),
       ('Eurasia', 'sashimi', 559, '2022-08-03'),
       ('Kebab-24', 'kebab', 120, '2022-08-03'),
       ('Kebab-24', 'double kebab', 170, '2022-08-03'),
       ('Kebab-24', 'mexico kebab', 160, '2022-08-03'),
       ('Kebab-24', 'fried potatoes', 80, '2022-08-03'),
       ('Mamaroma', 'pasta carbonara', 290, '2022-08-03'),
       ('Mamaroma', 'peperoni pizza', 240, '2022-08-03'),
       ('Mamaroma', 'salmon with vegetables', 460, '2022-08-03'),
       ('Mamaroma', 'homemade vine', 165, '2022-08-03'),

       ('Tokio city', 'chicken poke', 289, '2022-08-04'),
       ('Tokio city', 'fried mushrooms', 349, '2022-08-04'),
       ('Tokio city', 'fruit tea', 149, '2022-08-04'),
       ('Tokio city', 'pancakes with cream', 279, '2022-08-04'),
       ('Eurasia', 'Philadelphia roll', 399, '2022-08-04'),
       ('Eurasia', 'California roll', 369, '2022-08-04'),
       ('Eurasia', 'green tea', 129, '2022-08-04'),
       ('Eurasia', 'sashimi', 559, '2022-08-04'),
       ('Kebab-24', 'kebab', 120, '2022-08-04'),
       ('Kebab-24', 'double kebab', 170, '2022-08-04'),
       ('Kebab-24', 'mexico kebab', 160, '2022-08-04'),
       ('Kebab-24', 'fried potatoes', 80, '2022-08-04'),
       ('Mamaroma', 'pasta carbonara', 290, '2022-08-04'),
       ('Mamaroma', 'peperoni pizza', 240, '2022-08-04'),
       ('Mamaroma', 'salmon with vegetables', 460, '2022-08-04'),
       ('Mamaroma', 'homemade vine', 165, '2022-08-04'),

       ('Tokio city', 'chicken poke', 289, '2022-08-05'),
       ('Tokio city', 'fried mushrooms', 349, '2022-08-05'),
       ('Tokio city', 'fruit tea', 149, '2022-08-05'),
       ('Tokio city', 'pancakes with cream', 279, '2022-08-05'),
       ('Eurasia', 'Philadelphia roll', 399, '2022-08-05'),
       ('Eurasia', 'California roll', 369, '2022-08-05'),
       ('Eurasia', 'green tea', 129, '2022-08-05'),
       ('Eurasia', 'sashimi', 559, '2022-08-05'),
       ('Kebab-24', 'kebab', 120, '2022-08-05'),
       ('Kebab-24', 'double kebab', 170, '2022-08-05'),
       ('Kebab-24', 'mexico kebab', 160, '2022-08-05'),
       ('Kebab-24', 'fried potatoes', 80, '2022-08-05'),
       ('Mamaroma', 'pasta carbonara', 290, '2022-08-05'),
       ('Mamaroma', 'peperoni pizza', 240, '2022-08-05'),
       ('Mamaroma', 'salmon with vegetables', 460, '2022-08-05'),
       ('Mamaroma', 'homemade vine', 165, '2022-08-05');








