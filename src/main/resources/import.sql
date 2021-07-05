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
INSERT INTO tb_local(name, dimension, created_At) VALUES ('unknown', 'unknown', null);


INSERT INTO tb_personagem (name, status, specie, gender, origin_id, location_id, created_At) VALUES ('Beth Smith', 'Alive', 'Human', 'Female', 1, 1, NOW());
INSERT INTO tb_personagem (name, status, specie, gender, origin_id, location_id, created_At) VALUES ('Bill', 'Alive', 'Human', 'Male', 1, 1, NOW());
INSERT INTO tb_personagem (name, status, specie, gender, origin_id, location_id, created_At) VALUES ('Abadango Cluster Princess', 'Alive', 'Alien', 'Female', 2, 2, NOW());
INSERT INTO tb_personagem (name, status, specie, gender, origin_id, location_id, created_At) VALUES ('Adjudicator Rick', 'Dead', 'Human', 'Male', 11, 3, NOW());
INSERT INTO tb_personagem (name, status, specie, gender, origin_id, location_id, created_At) VALUES ('Alan Rails', 'Dead', 'Human', 'Male', 11, 4, NOW());
INSERT INTO tb_personagem (name, status, specie, gender, origin_id, location_id, created_At) VALUES ('Alexander', 'Dead', 'Human', 'Male', 1, 5, NOW());
INSERT INTO tb_personagem (name, status, specie, gender, origin_id, location_id, created_At) VALUES ('Baby Legs', 'Alive', 'Human', 'Male', 11, 6, NOW());
INSERT INTO tb_personagem (name, status, specie, gender, origin_id, location_id, created_At) VALUES ('Lisa', 'Dead', 'Alien', 'Female', 11, 7, NOW());
INSERT INTO tb_personagem (name, status, specie, gender, origin_id, location_id, created_At) VALUES ('Blue Footprint Guy', 'Dead', 'Human', 'Male', 8, 8, NOW());
INSERT INTO tb_personagem (name, status, specie, gender, origin_id, location_id, created_At) VALUES ('Lighthouse Keeper', 'Dead', 'Alien', 'Male', 9, 9, NOW());
INSERT INTO tb_personagem (name, status, specie, gender, origin_id, location_id, created_At) VALUES ('Beebo', 'Dead', 'Human', 'Male', 10, 10, NOW());


