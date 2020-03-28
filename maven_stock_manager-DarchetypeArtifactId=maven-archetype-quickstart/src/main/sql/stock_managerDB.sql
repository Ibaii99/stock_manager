-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema stock_managerdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema stock_managerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `stock_managerdb` DEFAULT CHARACTER SET utf8 ;
USE `stock_managerdb` ;

-- -----------------------------------------------------
-- Table `stock_managerdb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`cliente` (
  `ID_cliente` INT(11) NOT NULL,
  `nombre_cliente` VARCHAR(45) NOT NULL,
  `email_cliente` VARCHAR(45) NOT NULL,
  `valoracion_cliente` INT(11) NULL,
  PRIMARY KEY (`ID_cliente`),
  UNIQUE INDEX `ID_cliente_UNIQUE` (`ID_cliente` ASC) ,
  UNIQUE INDEX `email_cliente_UNIQUE` (`email_cliente` ASC) ,
  UNIQUE INDEX `valoracion_cliente_UNIQUE` (`valoracion_cliente` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock_managerdb`.`articulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`articulo` (
  `codigo_articulo` INT(11) NOT NULL,
  `nombre_articulo` VARCHAR(45) NOT NULL,
  `fecha_caducidad` DATETIME NOT NULL,
  `precio` FLOAT NOT NULL,
  `stock` INT(11) NULL DEFAULT NULL,
  `descripción` VARCHAR(45) NOT NULL,
  `precio_normal` FLOAT NOT NULL,
  `precio_oferta` FLOAT NOT NULL,
  `foto` LONGBLOB NULL DEFAULT NULL,
  `cliente_valoracion` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_articulo`),
  UNIQUE INDEX `codigo_articulo_UNIQUE` (`codigo_articulo` ASC) ,
  UNIQUE INDEX `nombre_articulo_UNIQUE` (`nombre_articulo` ASC) ,
  UNIQUE INDEX `descripción_UNIQUE` (`descripción` ASC) ,
  INDEX `fk_articulo_cliente1_idx` (`cliente_valoracion` ASC) ,
  CONSTRAINT `fk_articulo_cliente1`
    FOREIGN KEY (`cliente_valoracion`)
    REFERENCES `stock_managerdb`.`cliente` (`ID_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


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
  INDEX `fk_cafeteria_articulo1_idx` (`articulo_cafeteria` ASC) ,
  CONSTRAINT `fk_cafeteria_articulo1`
    FOREIGN KEY (`articulo_cafeteria`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock_managerdb`.`cesta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`cesta` (
  `codigo_cesta` INT(11) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `articulo_cesta` INT(11) NOT NULL,
  `cliente_cesta` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_cesta`),
  UNIQUE INDEX `codigo_cesta_UNIQUE` (`codigo_cesta` ASC) ,
  INDEX `fk_cesta_articulo1_idx` (`articulo_cesta` ASC) ,
  INDEX `fk_cesta_cliente1_idx` (`cliente_cesta` ASC) ,
  CONSTRAINT `fk_cesta_articulo1`
    FOREIGN KEY (`articulo_cesta`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cesta_cliente1`
    FOREIGN KEY (`cliente_cesta`)
    REFERENCES `stock_managerdb`.`cliente` (`ID_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock_managerdb`.`mensaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`mensaje` (
  `destinatario` VARCHAR(20) NOT NULL,
  `texto` VARCHAR(45) NULL DEFAULT NULL,
  `mensaje_cliente` INT(11) NOT NULL,
  INDEX `fk_mensaje_cliente1_idx` (`mensaje_cliente` ASC) ,
  CONSTRAINT `fk_mensaje_cliente1`
    FOREIGN KEY (`mensaje_cliente`)
    REFERENCES `stock_managerdb`.`cliente` (`ID_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


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
  INDEX `fk_oferta_articulo1_idx` (`articulo_oferta` ASC) ,
  CONSTRAINT `fk_oferta_articulo1`
    FOREIGN KEY (`articulo_oferta`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock_managerdb`.`opinion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`opinion` (
  `texto` VARCHAR(45) NOT NULL,
  `codigo_opinion` INT(11) NOT NULL,
  `cliente_opinion` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_opinion`),
  UNIQUE INDEX `codigo_opinion_UNIQUE` (`codigo_opinion` ASC) ,
  INDEX `fk_opinion_cliente1_idx` (`cliente_opinion` ASC) ,
  CONSTRAINT `fk_opinion_cliente1`
    FOREIGN KEY (`cliente_opinion`)
    REFERENCES `stock_managerdb`.`cliente` (`ID_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


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


-- -----------------------------------------------------
-- Table `stock_managerdb`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`pedido` (
  `codigo_pedido` INT(11) NOT NULL,
  `proveedor` INT(11) NOT NULL,
  `articulo_pedido` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_pedido`),
  UNIQUE INDEX `codigo_pedido_UNIQUE` (`codigo_pedido` ASC) ,
  INDEX `fk_pedido_vendedor_idx` (`proveedor` ASC) ,
  INDEX `fk_pedido_articulo1_idx` (`articulo_pedido` ASC) ,
  CONSTRAINT `fk_pedido_vendedor`
    FOREIGN KEY (`proveedor`)
    REFERENCES `stock_managerdb`.`vendedor` (`ID_vendedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_articulo1`
    FOREIGN KEY (`articulo_pedido`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock_managerdb`.`recibo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`recibo` (
  `codigo_recibo` INT(11) NOT NULL,
  `articulo_recibo` INT(11) NOT NULL,
  `cliente_recibo` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_recibo`),
  UNIQUE INDEX `codigo_recibo_UNIQUE` (`codigo_recibo` ASC) ,
  INDEX `fk_recibo_articulo1_idx` (`articulo_recibo` ASC) ,
  INDEX `fk_recibo_cliente1_idx` (`cliente_recibo` ASC) ,
  CONSTRAINT `fk_recibo_articulo1`
    FOREIGN KEY (`articulo_recibo`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_recibo_cliente1`
    FOREIGN KEY (`cliente_recibo`)
    REFERENCES `stock_managerdb`.`cliente` (`ID_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock_managerdb`.`Opiniones por articulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`Opiniones por articulo` (
  `codigo_articulo` INT(11) NOT NULL,
  `codigo_opinion` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_articulo`, `codigo_opinion`),
  INDEX `fk_articulo_has_opinion_opinion1_idx` (`codigo_opinion` ASC) ,
  INDEX `fk_articulo_has_opinion_articulo1_idx` (`codigo_articulo` ASC) ,
  CONSTRAINT `fk_articulo_has_opinion_articulo1`
    FOREIGN KEY (`codigo_articulo`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_articulo_has_opinion_opinion1`
    FOREIGN KEY (`codigo_opinion`)
    REFERENCES `stock_managerdb`.`opinion` (`codigo_opinion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
