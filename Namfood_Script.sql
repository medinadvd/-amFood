CREATE DATABASE namfood;

USE namfood;

CREATE TABLE `restaurante` (
  `id_restaurante` INT NOT NULL AUTO_INCREMENT,
  `tier_restaurante` INT NULL,
  `nombre` VARCHAR(100) NULL,
  `localizacion` VARCHAR(200) NULL,
  `tipo_comida` VARCHAR(45) NULL,
  `puntuacion` INT NULL,
  `telefono` int null,
  `imagen` varchar(2000),
  PRIMARY KEY (`id_restaurante`));


CREATE TABLE `preferencias_restaurante` (
  `id_restaurante` INT NOT NULL,
  `vegetariano` TINYINT NULL,
  `vegano` TINYINT NULL,
  `halal` TINYINT NULL,
  `gluten_free` TINYINT NULL,

    FOREIGN KEY (`id_restaurante`)
    REFERENCES `restaurante` (`id_restaurante`)
);

CREATE TABLE `user` (
  `correo` VARCHAR(100) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `password` VARCHAR(50) NULL,
  PRIMARY KEY (`correo`)
);


CREATE TABLE `historial` (
  `correo` VARCHAR(100) NULL,
  `id_restaurante` INT NOT NULL,
  `favorito` TINYINT NULL,

    FOREIGN KEY (`id_restaurante`)
    REFERENCES `restaurante` (`id_restaurante`),
    FOREIGN KEY (`correo`)
    REFERENCES `user` (`correo`));

create table `preferencias_user`(
  `correo` VARCHAR(100) NOT NULL,
  `vegetariano` TINYINT NULL,
  `vegano` TINYINT NULL,
  `halal` TINYINT NULL,
  `gluten_free` TINYINT NULL,
  FOREIGN KEY (`correo`)
  REFERENCES `user` (`correo`));
