
CREATE TABLE `restaurante` (
  `idrestaurante` INT NOT NULL AUTO_INCREMENT,
  `TierRestaurante` INT NULL,
  `Nombre` VARCHAR(100) NULL,
  `Localizacion` VARCHAR(200) NULL,
  `Tipo_comida` VARCHAR(45) NULL,
  `Puntuacion` INT NULL,
  `Telefono` int null,
  PRIMARY KEY (`idrestaurante`));


CREATE TABLE `preferencias_restaurante` (
  `idrestaurante` INT NOT NULL,
  `vegetariano` TINYINT NULL,
  `vegano` TINYINT NULL,
  `halal` TINYINT NULL,
  `gluten_free` TINYINT NULL,

    FOREIGN KEY (`idrestaurante`)
    REFERENCES `restaurante` (`idrestaurante`)
);

CREATE TABLE `user` (
  `correo` VARCHAR(100) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `contraseña` VARCHAR(50) NULL,
  PRIMARY KEY (`correo`));


CREATE TABLE `historial` (
  `idrestaurante` INT NOT NULL,
  `correo` VARCHAR(100) NULL,
  `favoritos` TINYINT NULL,

    FOREIGN KEY (`idrestaurante`)
    REFERENCES `restaurante` (`idrestaurante`),
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








