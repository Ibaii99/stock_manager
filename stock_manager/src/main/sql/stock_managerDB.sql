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
  `precio` FLOAT NOT NULL,
  `stock` INT(11) NULL DEFAULT NULL,
  `descripción` VARCHAR(45) NOT NULL,
  `precio_normal` FLOAT NOT NULL,
  `precio_oferta` FLOAT NOT NULL,
  `foto` LONGBLOB NULL DEFAULT NULL,
  PRIMARY KEY (`codigo_articulo`),
  UNIQUE INDEX `codigo_articulo_UNIQUE` (`codigo_articulo` ASC) VISIBLE,
  UNIQUE INDEX `nombre_articulo_UNIQUE` (`nombre_articulo` ASC) VISIBLE,
  UNIQUE INDEX `descripción_UNIQUE` (`descripción` ASC) VISIBLE)
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
  UNIQUE INDEX `ID_cafeteria_UNIQUE` (`ID_cafeteria` ASC) VISIBLE,
  UNIQUE INDEX `nombre_cafeteria_UNIQUE` (`nombre_cafeteria` ASC) VISIBLE,
  INDEX `fk_articulo_cafeteria_idx` (`articulo_cafeteria` ASC) VISIBLE,
  CONSTRAINT `fk_articulo_cafeteria`
    FOREIGN KEY (`articulo_cafeteria`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock_managerdb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`cliente` (
  `ID_cliente` INT(11) NOT NULL,
  `nombre_cliente` VARCHAR(45) NOT NULL,
  `email_cliente` VARCHAR(45) NOT NULL,
  `cesta_cliente` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_cliente`),
  UNIQUE INDEX `ID_cliente_UNIQUE` (`ID_cliente` ASC) VISIBLE,
  UNIQUE INDEX `email_cliente_UNIQUE` (`email_cliente` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock_managerdb`.`mensaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`mensaje` (
  `destinatario` VARCHAR(20) NOT NULL,
  `texto` VARCHAR(45) NULL DEFAULT NULL,
  `cliente_mensaje` INT(11) NOT NULL,
  PRIMARY KEY (`cliente_mensaje`),
  UNIQUE INDEX `ID_cliente_UNIQUE` (`cliente_mensaje` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_mensaje`
    FOREIGN KEY (`cliente_mensaje`)
    REFERENCES `stock_managerdb`.`cliente` (`ID_cliente`))
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
  UNIQUE INDEX `codigo_ofertas_UNIQUE` (`codigo_ofertas` ASC) VISIBLE,
  UNIQUE INDEX `nombre_oferta_UNIQUE` (`nombre_oferta` ASC) VISIBLE,
  INDEX `fk_articulo_pedido_idx` (`articulo_oferta` ASC) VISIBLE,
  CONSTRAINT `fk_articulo_oferta`
    FOREIGN KEY (`articulo_oferta`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock_managerdb`.`opinion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`opinion` (
  `texto` VARCHAR(45) NOT NULL,
  `valoracion` INT(11) NOT NULL,
  `opinion_cliente` INT(11) NOT NULL,
  `codigo_opinion` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_opinion`),
  UNIQUE INDEX `ID_cliente_UNIQUE` (`opinion_cliente` ASC) VISIBLE,
  UNIQUE INDEX `codigo_opinion_UNIQUE` (`codigo_opinion` ASC) INVISIBLE,
  CONSTRAINT `fk_opinion_cliente`
    FOREIGN KEY (`opinion_cliente`)
    REFERENCES `stock_managerdb`.`cliente` (`ID_cliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock_managerdb`.`opiniones por articulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`opiniones por articulo` (
  `codigo_articulo` INT(11) NOT NULL,
  `codigo_opinion` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_articulo`, `codigo_opinion`),
  INDEX `fk_articulo_has_opinion_opinion1_idx` (`codigo_opinion` ASC) VISIBLE,
  INDEX `fk_articulo_has_opinion_articulo1_idx` (`codigo_articulo` ASC) VISIBLE,
  CONSTRAINT `fk_articulo_has_opinion_articulo1`
    FOREIGN KEY (`codigo_articulo`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`),
  CONSTRAINT `fk_articulo_has_opinion_opinion1`
    FOREIGN KEY (`codigo_opinion`)
    REFERENCES `stock_managerdb`.`opinion` (`codigo_opinion`))
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
  UNIQUE INDEX `ID_UNIQUE` (`ID_vendedor` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock_managerdb`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`pedido` (
  `codigo_pedido` INT(11) NOT NULL,
  `proveedor_pedido` INT(11) NOT NULL,
  `articulo_pedido` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_pedido`),
  UNIQUE INDEX `codigo_pedido_UNIQUE` (`codigo_pedido` ASC) INVISIBLE,
  INDEX `fk_proveedor_pedido_idx` (`proveedor_pedido` ASC) VISIBLE,
  INDEX `fk_articulo_pedido_idx` (`articulo_pedido` ASC) VISIBLE,
  CONSTRAINT `fk_articulo_pedido`
    FOREIGN KEY (`articulo_pedido`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`),
  CONSTRAINT `fk_proveedor_pedido`
    FOREIGN KEY (`proveedor_pedido`)
    REFERENCES `stock_managerdb`.`vendedor` (`ID_vendedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock_managerdb`.`recibo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`recibo` (
  `codigo_recibo` INT(11) NOT NULL,
  `articulo_recibo` INT(11) NOT NULL,
  `ID_cliente` INT(11) NOT NULL,
  PRIMARY KEY (`codigo_recibo`, `ID_cliente`),
  UNIQUE INDEX `codigo_recibo_UNIQUE` (`codigo_recibo` ASC) VISIBLE,
  INDEX `fk_articulo_recibo_idx` (`articulo_recibo` ASC) VISIBLE,
  INDEX `fk_recibo_cliente1_idx` (`ID_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_articulo_recibo`
    FOREIGN KEY (`articulo_recibo`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`),
  CONSTRAINT `fk_recibo_cliente1`
    FOREIGN KEY (`ID_cliente`)
    REFERENCES `stock_managerdb`.`cliente` (`ID_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock_managerdb`.`cesta_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`cesta_compra` (
  `ID_cliente` INT(11) NOT NULL,
  `codigo_articulo` INT(11) NOT NULL,
  `cantidad` INT(50) NULL,
  PRIMARY KEY (`ID_cliente`, `codigo_articulo`),
  INDEX `fk_cliente_has_articulo_articulo1_idx` (`codigo_articulo` ASC) VISIBLE,
  INDEX `fk_cliente_has_articulo_cliente1_idx` (`ID_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_has_articulo_cliente1`
    FOREIGN KEY (`ID_cliente`)
    REFERENCES `stock_managerdb`.`cliente` (`ID_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_has_articulo_articulo1`
    FOREIGN KEY (`codigo_articulo`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `stock_managerdb`.`cesta_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stock_managerdb`.`cesta_pedido` (
  `cliente_ID_cliente` INT(11) NOT NULL,
  `articulo_codigo_articulo` INT(11) NOT NULL,
  `id_cesta_pedido` INT(11) NOT NULL,
  `cantidad` VARCHAR(45) NULL,
  PRIMARY KEY (`cliente_ID_cliente`, `articulo_codigo_articulo`, `id_cesta_pedido`),
  INDEX `fk_cliente_has_articulo_articulo2_idx` (`articulo_codigo_articulo` ASC) VISIBLE,
  INDEX `fk_cliente_has_articulo_cliente2_idx` (`cliente_ID_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_has_articulo_cliente2`
    FOREIGN KEY (`cliente_ID_cliente`)
    REFERENCES `stock_managerdb`.`cliente` (`ID_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_has_articulo_articulo2`
    FOREIGN KEY (`articulo_codigo_articulo`)
    REFERENCES `stock_managerdb`.`articulo` (`codigo_articulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
