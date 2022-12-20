CREATE TABLE `restaurante` (
  `idrestaurante` INT NOT NULL AUTO_INCREMENT,
  `TierRestaurante` INT NULL,
  `Nombre` VARCHAR(100) NULL,
  `Localizacion` VARCHAR(200) NULL,
  `Tipo_comida` VARCHAR(45) NULL,
  `Puntuacion` INT NULL,
  `Telefono` int null,
  `imagen` varchar(2000),
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
  `idrestaurante` int,
  PRIMARY KEY (`correo`),
    FOREIGN KEY (`idrestaurante`)
    REFERENCES `restaurante` (`idrestaurante`));


CREATE TABLE `historial` (
  `correo` VARCHAR(100) NULL,
  `idrestaurante` INT NOT NULL,
  `favorito` TINYINT NULL,

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

-- Creacion de usuario
insert into user values ('correo','nombre',sha2('contraseña'),null);

-- Inicio sesion usuario
select * from user where 'correo' = correo and 'contraseña' = contraseña;

-- Update datos usuario
update preferencias_user
set vegetariano = 'vegetariano', vegano = 'vegano', halal = 'halal', gluten_free = 'gluten_free'
where correo = 'getcorreo';

-- Update user idrestaurante
update user
set idrestaurante = 'idrestaurante'
where correo = 'getcorreo';

-- Mostrar el nombre del usuario en la pagina web
select nombre from user where 'correo' = correo and 'contraseña' = contraseña;

-- Mostrar el Restaurante aleatorio

select r.TierRestaurante, r.Nombre, r.Localizacion, r.Tipo_comida, r.Puntuacion, r.Telefono
from restaurante r, preferencias_restaurante pr, preferencias_user pu
where pu.vegetariano = pr.vegetariano and pu.vegano = pr.vegano and pu.halal = pr.halal and pu.gluten_free = pr.gluten_free;


-- Perfil de usuario sin el Favorito (Para mostrar el historial)
select u.nombre, u.correo, u.contraseña, u.vegetariano, u.vegano, u.halal, u.gluten_free, h.idrestaurante
from user u, historial h
where u.correo = h.correo;

-- Perfil usuario para mostrar los favoritos 
select h.favoritos
from user u, historial h
where u.correo = h.correo;

use namfood;








