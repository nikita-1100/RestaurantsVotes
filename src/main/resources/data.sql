INSERT INTO users(name, password)
VALUES ('admin', '$2a$10$4Z8t3oFmIBxtM8A3weStpu.yQvFhf58elywRsg1eEzVzpUza0mXDC'),
       ('user','$2a$10$4Z8t3oFmIBxtM8A3weStpu.yQvFhf58elywRsg1eEzVzpUza0mXDC'),
        ('noop','{noop}12345');

INSERT INTO user_role(user_id, role) VALUES (1,'ADMIN'),(2,'USER');

INSERT INTO restaurant(name)
VALUES ('Tokio city'),
       ('Eurasia'),
       ('Kebab-24'),
       ('Mamaroma');

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
       ('Mamaroma', 'homemade vine', 165, '2022-08-01');







