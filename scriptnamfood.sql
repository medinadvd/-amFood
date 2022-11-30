


CREATE TABLE `restaurante` (
  `idrestaurante` INT NOT NULL AUTO_INCREMENT,
  `TierRestaurante` INT NULL,
  `Nombre` VARCHAR(100) NULL,
  `Localizacion` VARCHAR(200) NULL,
  `Categoria` VARCHAR(45) NULL,
  `Puntuacion` INT NULL,
  PRIMARY KEY (`idrestaurante`));


CREATE TABLE `Preferencias` (
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
  `vegetariano` TINYINT NULL,
  `vegano` TINYINT NULL,
  `halal` TINYINT NULL,
  `gluten_free` TINYINT NULL,
  PRIMARY KEY (`correo`));


CREATE TABLE `historial` (
  `idrestaurante` INT NOT NULL,
  `correo` VARCHAR(100) NULL,
  `favoritos` TINYINT NULL,

    FOREIGN KEY (`idrestaurante`)
    REFERENCES `restaurante` (`idrestaurante`),
    FOREIGN KEY (`correo`)
    REFERENCES `user` (`correo`));







