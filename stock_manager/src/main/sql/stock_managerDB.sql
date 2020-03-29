-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema stock_managerdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema stock_managerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `stock_managerdb` DEFAULT CHARACTER SET utf8 ;
USE `stock_managerdb` ;

-- -----------------------------------------------------
-- Table `stock_managerdb`.`articulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`articulo` (
  `codigo_articulo` INT(11) NOT NULL,
  `nombre_articulo` VARCHAR(45) NOT NULL,
  `fecha_caducidad` DATETIME NOT NULL,
  `stock` INT(11) NULL DEFAULT NULL,
  `descripción` VARCHAR(200) NOT NULL,
  `precio_normal` FLOAT NOT NULL,
  `precio_oferta` FLOAT NOT NULL,
  `foto` LONGBLOB NULL DEFAULT NULL,
  PRIMARY KEY (`codigo_articulo`),
  UNIQUE INDEX `codigo_articulo_UNIQUE` (`codigo_articulo` ASC) ,
  UNIQUE INDEX `nombre_articulo_UNIQUE` (`nombre_articulo` ASC) ,
  UNIQUE INDEX `descripción_UNIQUE` (`descripción` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `stock_managerdb`.`articulo` (`codigo_articulo`, `nombre_articulo`, `fecha_caducidad`, `stock`, `descripción`, `precio_normal`, `precio_oferta`, `foto`) VALUES (1, 'Leche', '12/27/2021', 200, 'Leche Kaiku semidesnatada, de km 0. Tiene un tetrabrik de 1 litro de capacidad', 1.04, 0.95, NULL);
INSERT INTO `stock_managerdb`.`articulo` (`codigo_articulo`, `nombre_articulo`, `fecha_caducidad`, `stock`, `descripción`, `precio_normal`, `precio_oferta`, `foto`) VALUES (2, 'Manzana', '04/07/2020', 50, '1 kg de manzanas verdes y con mucho sabor, además contiene mucho valor nutricional', 3.50, 2.79, NULL);
INSERT INTO `stock_managerdb`.`articulo` (`codigo_articulo`, `nombre_articulo`, `fecha_caducidad`, `stock`, `descripción`, `precio_normal`, `precio_oferta`, `foto`) VALUES (3, 'Merluza', '04/11/2020', 10, '750gramos de merluza pescada el mismo día, en el mar atlántico a tan solo 50 km de la costa. Además viene ya limpia.', 7.88, 6.80, NULL);
INSERT INTO `stock_managerdb`.`articulo` (`codigo_articulo`, `nombre_articulo`, `fecha_caducidad`, `stock`, `descripción`, `precio_normal`, `precio_oferta`, `foto`) VALUES (4, 'Platano', '04/01/2020', 30, '1/2 docena de latanos de canarias, a punto de madurar y con un sabor extremadamente delicioso.', 4.53, 3.70, NULL);
INSERT INTO `stock_managerdb`.`articulo` (`codigo_articulo`, `nombre_articulo`, `fecha_caducidad`, `stock`, `descripción`, `precio_normal`, `precio_oferta`, `foto`) VALUES (5, 'Cerveza', '06/16/2021', 300, '6 latas de 33cl de Cerveza Heineken, ¿que más se puede pedir? Disfruta de la nueva colección de latas', 3.69, 2.99, NULL);
INSERT INTO `stock_managerdb`.`articulo` (`codigo_articulo`, `nombre_articulo`, `fecha_caducidad`, `stock`, `descripción`, `precio_normal`, `precio_oferta`, `foto`) VALUES (6, 'Cacao', '09/27/2022', 100, '1 kg. Cacao Nesquik, lo mejor para tus pequeños ratos de ocio, o perfecto para cualquier momento también.', 5.40, 4.40, NULL);
INSERT INTO `stock_managerdb`.`articulo` (`codigo_articulo`, `nombre_articulo`, `fecha_caducidad`, `stock`, `descripción`, `precio_normal`, `precio_oferta`, `foto`) VALUES (7, 'Chocolate', '01/09/2021', 400, '1 paquete. Chocolate lindt %70. Sin aditivos ni colorantes y sin aceite de palma', 3.58, 2.15, NULL);
INSERT INTO `stock_managerdb`.`articulo` (`codigo_articulo`, `nombre_articulo`, `fecha_caducidad`, `stock`, `descripción`, `precio_normal`, `precio_oferta`, `foto`) VALUES (8, 'Ron', '11/20/2022', 150, '1 botella. Ron Barceló, con que se puede celebrar mejor una buena racha o olvidar las más grandes penas.', 12.50, 11.00, NULL);
INSERT INTO `stock_managerdb`.`articulo` (`codigo_articulo`, `nombre_articulo`, `fecha_caducidad`, `stock`, `descripción`, `precio_normal`, `precio_oferta`, `foto`) VALUES (9, 'Café', '01/19/2021', 350, '2 recipientes. Café baqué. Aquí lluvia se dice zirimiri,aqui café se dice baqué', 3.25, 2.00, NULL);
INSERT INTO `stock_managerdb`.`articulo` (`codigo_articulo`, `nombre_articulo`, `fecha_caducidad`, `stock`, `descripción`, `precio_normal`, `precio_oferta`, `foto`) VALUES (10, 'Solomillo', '04/07/2020', 10, '1kg. Garantía eusko label de un baserri de Erandio de alta calidad.', 9.45, 8.50, NULL);

-- -----------------------------------------------------
-- Table `stock_managerdb`.`cafeteria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`cafeteria` (
  `ID_cafeteria` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_cafeteria` VARCHAR(45) NOT NULL,
  `articulo_cafeteria` INT(11) NOT NULL,
  PRIMARY KEY (`ID_cafeteria`),
  UNIQUE INDEX `ID_cafeteria_UNIQUE` (`ID_cafeteria` ASC) ,
  UNIQUE INDEX `nombre_cafeteria_UNIQUE` (`nombre_cafeteria` ASC) ,
  INDEX `fk_articulo_cafeteria_idx` (`articulo_cafeteria` ASC) ,
  CONSTRAINT `fk_articulo_cafeteria`
    FOREIGN KEY (`articulo_cafeteria`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `stock_managerdb`.`cafeteria` (`ID_cafeteria`, `nombre_cafeteria`, `articulo_cafeteria`) VALUES (1, 'Bar Toni', 2,3,5,6,7,8,9,10);
INSERT INTO `stock_managerdb`.`cafeteria` (`ID_cafeteria`, `nombre_cafeteria`, `articulo_cafeteria`) VALUES (2, 'Cafetería La Cola', 1,4,5,6,8,9);
INSERT INTO `stock_managerdb`.`cafeteria` (`ID_cafeteria`, `nombre_cafeteria`, `articulo_cafeteria`) VALUES (3, 'Bar Reverso', 2,3,4,5,6,8,9,10);


-- -----------------------------------------------------
-- Table `stock_managerdb`.`cesta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`cesta` (
  `codigo_cesta` INT(11) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `articulo_cesta` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_cesta`),
  UNIQUE INDEX `codigo_cesta_UNIQUE` (`codigo_cesta` ASC) ,
  INDEX `fk_articulo_cesta_idx` (`articulo_cesta` ASC) ,
  CONSTRAINT `fk_articulo_cesta`
    FOREIGN KEY (`articulo_cesta`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `stock_managerdb`.`cesta` (`codigo_cesta`, `estado`, `articulo_cesta`) VALUES (1, 'llena', 1,7,8,2,3,4,5,6,9,10);
INSERT INTO `stock_managerdb`.`cesta` (`codigo_cesta`, `estado`, `articulo_cesta`) VALUES (2, 'es posible introducir más artículos', 4,8,9,6);
INSERT INTO `stock_managerdb`.`cesta` (`codigo_cesta`, `estado`, `articulo_cesta`) VALUES (3, 'vacía', DEFAULT);
INSERT INTO `stock_managerdb`.`cesta` (`codigo_cesta`, `estado`, `articulo_cesta`) VALUES (4, 'es posible introducir más artículos', 2,5,8,3,4);
INSERT INTO `stock_managerdb`.`cesta` (`codigo_cesta`, `estado`, `articulo_cesta`) VALUES (5, 'es posible introducir más artículos', 2,7);

-- -----------------------------------------------------
-- Table `stock_managerdb`.`recibo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`recibo` (
  `codigo_recibo` INT(11) NOT NULL,
  `articulo_recibo` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_recibo`),
  UNIQUE INDEX `codigo_recibo_UNIQUE` (`codigo_recibo` ASC) ,
  INDEX `fk_articulo_recibo_idx` (`articulo_recibo` ASC) ,
  CONSTRAINT `fk_articulo_recibo`
    FOREIGN KEY (`articulo_recibo`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `stock_managerdb`.`recibo` (`codigo_recibo`, `articulo_recibo`) VALUES (1, 1,2,3,4,5,6,7,8,9,10);
INSERT INTO `stock_managerdb`.`recibo` (`codigo_recibo`, `articulo_recibo`) VALUES (2, 7,8,2,4);
INSERT INTO `stock_managerdb`.`recibo` (`codigo_recibo`, `articulo_recibo`) VALUES (3,4);
INSERT INTO `stock_managerdb`.`recibo` (`codigo_recibo`, `articulo_recibo`) VALUES (4, 1,7,4,5,8);
INSERT INTO `stock_managerdb`.`recibo` (`codigo_recibo`, `articulo_recibo`) VALUES (5, 9,10,7,6,3);

-- -----------------------------------------------------
-- Table `stock_managerdb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`cliente` (
  `ID_cliente` INT(11) NOT NULL,
  `nombre_cliente` VARCHAR(45) NOT NULL,
  `email_cliente` VARCHAR(45) NOT NULL,
  `recibo_cliente` INT(11) NULL DEFAULT NULL,
  `cesta_cliente` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_cliente`),
  UNIQUE INDEX `ID_cliente_UNIQUE` (`ID_cliente` ASC) ,
  UNIQUE INDEX `email_cliente_UNIQUE` (`email_cliente` ASC) ,
  UNIQUE INDEX `recibo_cliente_UNIQUE` (`recibo_cliente` ASC) ,
  UNIQUE INDEX `cesta_cliente_UNIQUE` (`cesta_cliente` ASC) ,
  CONSTRAINT `fk_cesta_cliente`
    FOREIGN KEY (`cesta_cliente`)
    REFERENCES `stock_managerdb`.`cesta` (`codigo_cesta`),
  CONSTRAINT `fk_recibo_cliente`
    FOREIGN KEY (`recibo_cliente`)
    REFERENCES `stock_managerdb`.`recibo` (`codigo_recibo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `stock_managerdb`.`cliente` (`ID_cliente`, `nombre_cliente`, `email_cliente`, `recibo_cliente`, `cesta_cliente`) VALUES (1, 'Jon Soler', 'soler99@gmail.com', 1, 2);
INSERT INTO `stock_managerdb`.`cliente` (`ID_cliente`, `nombre_cliente`, `email_cliente`, `recibo_cliente`, `cesta_cliente`) VALUES (2, 'Aitor Ocio', 'aitorOcio1@gmail.com', 4, 5);
INSERT INTO `stock_managerdb`.`cliente` (`ID_cliente`, `nombre_cliente`, `email_cliente`, `recibo_cliente`, `cesta_cliente`) VALUES (3, 'Iker Vicente', 'iker1234@gmail.com', 3, 4);
INSERT INTO `stock_managerdb`.`cliente` (`ID_cliente`, `nombre_cliente`, `email_cliente`, `recibo_cliente`, `cesta_cliente`) VALUES (4, 'Asier Fernández', 'asierferrarrii@gamil.com', 2, 1);
INSERT INTO `stock_managerdb`.`cliente` (`ID_cliente`, `nombre_cliente`, `email_cliente`, `recibo_cliente`, `cesta_cliente`) VALUES (5, 'Mikel López', 'mike.lop@gmail.com', 5, 3);


-- -----------------------------------------------------
-- Table `stock_managerdb`.`mensaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`mensaje` (
  `destinatario` VARCHAR(20) NOT NULL,
  `texto` VARCHAR(45) NULL DEFAULT NULL,
  `cliente_mensaje` INT(11) NOT NULL,
  PRIMARY KEY (`cliente_mensaje`),
  UNIQUE INDEX `ID_cliente_UNIQUE` (`cliente_mensaje` ASC) ,
  CONSTRAINT `fk_cliente_mensaje`
    FOREIGN KEY (`cliente_mensaje`)
    REFERENCES `stock_managerdb`.`cliente` (`ID_cliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `stock_managerdb`.`mensaje` (`destinatario`, `texto`, `cliente_mensaje`) VALUES ('Servicio técnico', 'Hola, se me ha olvidado la contraseña y no de que hacer. ¿Me puede ayudar? Gracias', 1);
INSERT INTO `stock_managerdb`.`mensaje` (`destinatario`, `texto`, `cliente_mensaje`) VALUES ('Vendedor ', 'Me gustaría contactar con usted para charlar más acerca de la compra de sus productos', 2);
INSERT INTO `stock_managerdb`.`mensaje` (`destinatario`, `texto`, `cliente_mensaje`) VALUES ('Vendedor', '¿Podría visitar su baserri? Estoy haciendo una encuesta acerca de los ganadores locales', 3);
INSERT INTO `stock_managerdb`.`mensaje` (`destinatario`, `texto`, `cliente_mensaje`) VALUES ('Servicio técnico', 'Buenos días, llevo varias semanas con problemas en mi carro. No se que hacer. Me podría dar la solución!!??', 4);
INSERT INTO `stock_managerdb`.`mensaje` (`destinatario`, `texto`, `cliente_mensaje`) VALUES ('Servicio técnico', 'Hola, me gustaría dejar una opinión acerca de un producto y no se hacerlo', 5);

-- -----------------------------------------------------
-- Table `stock_managerdb`.`oferta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`oferta` (
  `codigo_ofertas` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_oferta` VARCHAR(45) NOT NULL,
  `articulo_oferta` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_ofertas`),
  UNIQUE INDEX `codigo_ofertas_UNIQUE` (`codigo_ofertas` ASC) ,
  UNIQUE INDEX `nombre_oferta_UNIQUE` (`nombre_oferta` ASC) ,
  INDEX `fk_articulo_pedido_idx` (`articulo_oferta` ASC) ,
  CONSTRAINT `fk_articulo_oferta`
    FOREIGN KEY (`articulo_oferta`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `stock_managerdb`.`oferta` (`codigo_ofertas`, `nombre_oferta`, `articulo_oferta`) VALUES (1, 'Oferta en leche', 1);
INSERT INTO `stock_managerdb`.`oferta` (`codigo_ofertas`, `nombre_oferta`, `articulo_oferta`) VALUES (2, 'Oferta en manzana', 2);
INSERT INTO `stock_managerdb`.`oferta` (`codigo_ofertas`, `nombre_oferta`, `articulo_oferta`) VALUES (3, 'Oferta en merluza', 3);
INSERT INTO `stock_managerdb`.`oferta` (`codigo_ofertas`, `nombre_oferta`, `articulo_oferta`) VALUES (4, 'Oferta en platano', 4);
INSERT INTO `stock_managerdb`.`oferta` (`codigo_ofertas`, `nombre_oferta`, `articulo_oferta`) VALUES (5, 'Oferta en cerveza', 5);
INSERT INTO `stock_managerdb`.`oferta` (`codigo_ofertas`, `nombre_oferta`, `articulo_oferta`) VALUES (6, 'Oferta en cacao', 6);
INSERT INTO `stock_managerdb`.`oferta` (`codigo_ofertas`, `nombre_oferta`, `articulo_oferta`) VALUES (7, 'Oferta en chocolate', 7);
INSERT INTO `stock_managerdb`.`oferta` (`codigo_ofertas`, `nombre_oferta`, `articulo_oferta`) VALUES (8, 'Oferta en ron', 8);
INSERT INTO `stock_managerdb`.`oferta` (`codigo_ofertas`, `nombre_oferta`, `articulo_oferta`) VALUES (9, 'Oferta en café', 9);
INSERT INTO `stock_managerdb`.`oferta` (`codigo_ofertas`, `nombre_oferta`, `articulo_oferta`) VALUES (10, 'Oferta en solomillo', 10);

-- -----------------------------------------------------
-- Table `stock_managerdb`.`opinion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`opinion` (
  `texto` VARCHAR(45) NOT NULL,
  `valoracion` INT(11) NOT NULL,
  `opinion_cliente` INT(11) NOT NULL,
  `codigo_opinion` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_opinion`),
  UNIQUE INDEX `ID_cliente_UNIQUE` (`opinion_cliente` ASC) ,
  UNIQUE INDEX `codigo_opinion_UNIQUE` (`codigo_opinion` ASC) ,
  CONSTRAINT `fk_opinion_cliente`
    FOREIGN KEY (`opinion_cliente`)
    REFERENCES `stock_managerdb`.`cliente` (`ID_cliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `stock_managerdb`.`opinion` (`texto`, `valoracion`, `opinion_cliente`, `codigo_opinion`) VALUES ('Producto de gran calidad y a buen precio', 7, 2, 1);
INSERT INTO `stock_managerdb`.`opinion` (`texto`, `valoracion`, `opinion_cliente`, `codigo_opinion`) VALUES ('Me ha gustado mucho, así que lo volveré a comprar', 8, 5, 2);
INSERT INTO `stock_managerdb`.`opinion` (`texto`, `valoracion`, `opinion_cliente`, `codigo_opinion`) VALUES ('La oferta no me ha parecido lo suficiente como para comprarlo', 5, 1, 3);
INSERT INTO `stock_managerdb`.`opinion` (`texto`, `valoracion`, `opinion_cliente`, `codigo_opinion`) VALUES ('Increible oferta, así que la he aprovechado', 9, 3, 4);
INSERT INTO `stock_managerdb`.`opinion` (`texto`, `valoracion`, `opinion_cliente`, `codigo_opinion`) VALUES ('Me ha encantado este producto. De seguro que repito!', 8, 4, 5);
INSERT INTO `stock_managerdb`.`opinion` (`texto`, `valoracion`, `opinion_cliente`, `codigo_opinion`) VALUES ('No se si me ha convencido este árticulo', 6, 4, 6);
INSERT INTO `stock_managerdb`.`opinion` (`texto`, `valoracion`, `opinion_cliente`, `codigo_opinion`) VALUES ('Aunque lo he comprado, creo que debería ser más barato', 7, 1, 7);
INSERT INTO `stock_managerdb`.`opinion` (`texto`, `valoracion`, `opinion_cliente`, `codigo_opinion`) VALUES ('Muy bueno y barato', 8, 3, 8);
INSERT INTO `stock_managerdb`.`opinion` (`texto`, `valoracion`, `opinion_cliente`, `codigo_opinion`) VALUES ('Espectacular producto. Lo recomiendo totalmente', 9, 2, 9);
INSERT INTO `stock_managerdb`.`opinion` (`texto`, `valoracion`, `opinion_cliente`, `codigo_opinion`) VALUES ('Creo que no recomiendo comprar este producto.', 6, 5, 10);

-- -----------------------------------------------------
-- Table `stock_managerdb`.`opiniones por articulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`opiniones por articulo` (
  `codigo_articulo` INT(11) NOT NULL,
  `codigo_opinion` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_articulo`, `codigo_opinion`),
  INDEX `fk_articulo_has_opinion_opinion1_idx` (`codigo_opinion` ASC) ,
  INDEX `fk_articulo_has_opinion_articulo1_idx` (`codigo_articulo` ASC) ,
  CONSTRAINT `fk_articulo_has_opinion_articulo1`
    FOREIGN KEY (`codigo_articulo`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`),
  CONSTRAINT `fk_articulo_has_opinion_opinion1`
    FOREIGN KEY (`codigo_opinion`)
    REFERENCES `stock_managerdb`.`opinion` (`codigo_opinion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `stock_managerdb`.`opiniones por articulo` (`codigo_articulo`, `codigo_opinion`) VALUES (1, 10);
INSERT INTO `stock_managerdb`.`opiniones por articulo` (`codigo_articulo`, `codigo_opinion`) VALUES (2, 9);
INSERT INTO `stock_managerdb`.`opiniones por articulo` (`codigo_articulo`, `codigo_opinion`) VALUES (3, 8);
INSERT INTO `stock_managerdb`.`opiniones por articulo` (`codigo_articulo`, `codigo_opinion`) VALUES (4, 7);
INSERT INTO `stock_managerdb`.`opiniones por articulo` (`codigo_articulo`, `codigo_opinion`) VALUES (5, 6);
INSERT INTO `stock_managerdb`.`opiniones por articulo` (`codigo_articulo`, `codigo_opinion`) VALUES (6, 5);
INSERT INTO `stock_managerdb`.`opiniones por articulo` (`codigo_articulo`, `codigo_opinion`) VALUES (7, 4);
INSERT INTO `stock_managerdb`.`opiniones por articulo` (`codigo_articulo`, `codigo_opinion`) VALUES (8, 3);
INSERT INTO `stock_managerdb`.`opiniones por articulo` (`codigo_articulo`, `codigo_opinion`) VALUES (9, 2);
INSERT INTO `stock_managerdb`.`opiniones por articulo` (`codigo_articulo`, `codigo_opinion`) VALUES (10, 1);

-- -----------------------------------------------------
-- Table `stock_managerdb`.`vendedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`vendedor` (
  `ID_vendedor` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre_vendedor` VARCHAR(45) NOT NULL,
  `Email_vendedor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_vendedor`),
  UNIQUE INDEX `ID_UNIQUE` (`ID_vendedor` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `stock_managerdb`.`vendedor` (`ID_vendedor`, `Nombre_vendedor`, `Email_vendedor`) VALUES (1, 'Recoba proveedores', 'recobaProv@gmail.com');
INSERT INTO `stock_managerdb`.`vendedor` (`ID_vendedor`, `Nombre_vendedor`, `Email_vendedor`) VALUES (2, 'Erandio Food', 'erandioFood@gmail.com');
INSERT INTO `stock_managerdb`.`vendedor` (`ID_vendedor`, `Nombre_vendedor`, `Email_vendedor`) VALUES (3, 'Gasca', 'gascaSantander@gmail.com');
INSERT INTO `stock_managerdb`.`vendedor` (`ID_vendedor`, `Nombre_vendedor`, `Email_vendedor`) VALUES (4, 'Eusko Janaria', 'euskoJanaria@gmail.com');


-- -----------------------------------------------------
-- Table `stock_managerdb`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`pedido` (
  `codigo_pedido` INT(11) NOT NULL,
  `proveedor_pedido` INT(11) NOT NULL,
  `articulo_pedido` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_pedido`),
  UNIQUE INDEX `codigo_pedido_UNIQUE` (`codigo_pedido` ASC) ,
  INDEX `fk_proveedor_pedido_idx` (`proveedor_pedido` ASC) ,
  INDEX `fk_articulo_pedido_idx` (`articulo_pedido` ASC) ,
  CONSTRAINT `fk_articulo_pedido`
    FOREIGN KEY (`articulo_pedido`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`),
  CONSTRAINT `fk_proveedor_pedido`
    FOREIGN KEY (`proveedor_pedido`)
    REFERENCES `stock_managerdb`.`vendedor` (`ID_vendedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `stock_managerdb`.`pedido` (`codigo_pedido`, `proveedor_pedido`, `articulo_pedido`) VALUES (1, 2, 7,5,4,3);
INSERT INTO `stock_managerdb`.`pedido` (`codigo_pedido`, `proveedor_pedido`, `articulo_pedido`) VALUES (2, 3, 10,5,1);
INSERT INTO `stock_managerdb`.`pedido` (`codigo_pedido`, `proveedor_pedido`, `articulo_pedido`) VALUES (3, 4, 9,3);
INSERT INTO `stock_managerdb`.`pedido` (`codigo_pedido`, `proveedor_pedido`, `articulo_pedido`) VALUES (4, 2, 3,2);
INSERT INTO `stock_managerdb`.`pedido` (`codigo_pedido`, `proveedor_pedido`, `articulo_pedido`) VALUES (5, 1, 1,7,9,10);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
