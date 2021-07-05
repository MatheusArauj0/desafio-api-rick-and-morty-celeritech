INSERT INTO tb_user (name, password) VALUES ('admin', '$2a$10$sU7.PkObMLyR4I8Q9ksldu4AjhgTLkyfkuPnMKTQGR9BtcHVd5Ule');

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);




INSERT INTO tb_local(name, dimension, created_At) VALUES ('Earth (C-137)', 'Dimension C-137', NOW());;
INSERT INTO tb_local(name, dimension, created_At) VALUES ('Abadango', 'unknown', NOW());
INSERT INTO tb_local(name, dimension, created_At) VALUES ('Citadel of Ricks', 'unknown', NOW());
INSERT INTO tb_local(name, dimension, created_At) VALUES ('Worldender''s lair', 'unknown', NOW());
INSERT INTO tb_local(name, dimension, created_At) VALUES ('Anatomy Park', 'Dimension C-137', NOW());
INSERT INTO tb_local(name, dimension, created_At) VALUES ('Interdimensional Cable', 'unknown', NOW());
INSERT INTO tb_local(name, dimension, created_At) VALUES ('Immortality Field Resort', 'unknown',NOW());
INSERT INTO tb_local(name, dimension, created_At) VALUES ('Post-Apocalyptic Earth', 'Post-Apocalyptic Dimension', NOW());
INSERT INTO tb_local(name, dimension, created_At) VALUES ('Purge Planet', 'Replacement Dimension', NOW());
INSERT INTO tb_local(name, dimension, created_At) VALUES ('Venzenulon 7', 'unknown', NOW());


INSERT INTO tb_personagem (name, status, specie, gender, location_id, origin_id, created_At) VALUES ('Rick Sanchez', 'Alive', 'Human', 'Male', 1, 1, NOW());
INSERT INTO tb_personagem (name, status, specie, gender, location_id, origin_id, created_At) VALUES ('Morty Smith', 'Alive', 'Human', 'Male', 2, 2, NOW());
INSERT INTO tb_personagem (name, status, specie, gender, location_id, origin_id, created_At) VALUES ('Matheus', 'Alive', 'Human', 'Male', 1, 1, NOW());
INSERT INTO tb_personagem (name, status, specie, gender, location_id, origin_id, created_At) VALUES ('Mack', 'Alive', 'Human', 'Male', 1, 2, NOW());

