SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `roastbier` DEFAULT CHARACTER SET utf8 ;
USE `roastbier` ;

-- -----------------------------------------------------
-- Table `roastbier`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roastbier`.`Usuarios` (
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `data_nascimento` DATE NULL,
  `email` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(13) NULL,
  `whats` TINYINT NULL,
  `Username` VARCHAR(15) NOT NULL,
  `Senha` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roastbier`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roastbier`.`Clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `data_nascimento` DATE NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `rg` VARCHAR(15) NULL,
  `orgao_emissor` VARCHAR(20) NULL,
  `email` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(13) NOT NULL,
  `whats` TINYINT NULL,
  `logradouro` VARCHAR(200) NULL,
  `numero` VARCHAR(20) NULL,
  `bairro` VARCHAR(100) NULL,
  `cidade` VARCHAR(100) NULL,
  `estado` VARCHAR(2) NULL,
  `cep` VARCHAR(8) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roastbier`.`Produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roastbier`.`Produtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `descricao` TEXT NULL,
  `unidade` ENUM('UNI', 'PEC', 'LT', 'KG', 'CX', 'FR', 'GAR') NOT NULL,
  `preco_unitario` FLOAT(5,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roastbier`.`Pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roastbier`.`Pedidos` (
  `numero` INT NOT NULL AUTO_INCREMENT,
  `data_emissao` DATE NOT NULL,
  `valor_frete` FLOAT(5,2) NOT NULL,
  `data_entrega` DATE NULL,
  `Clientes_id` INT NOT NULL,
  PRIMARY KEY (`numero`),
  INDEX `fk_Pedidos_Clientes_idx` (`Clientes_id` ASC) VISIBLE,
  CONSTRAINT `fk_Pedidos_Clientes`
    FOREIGN KEY (`Clientes_id`)
    REFERENCES `roastbier`.`Clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `roastbier`.`Produtos_has_Pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `roastbier`.`Produtos_has_Pedidos` (
  `Produtos_id` INT NOT NULL,
  `Pedidos_numero` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `preco_unitario` FLOAT(5,2) NOT NULL,
  `unidade` ENUM('UNI', 'PEC', 'LT', 'KG', 'CX', 'FR', 'GAR') NULL,
  PRIMARY KEY (`Produtos_id`, `Pedidos_numero`),
  INDEX `fk_Produtos_has_Pedidos_Pedidos1_idx` (`Pedidos_numero` ASC) VISIBLE,
  INDEX `fk_Produtos_has_Pedidos_Produtos1_idx` (`Produtos_id` ASC) VISIBLE,
  CONSTRAINT `fk_Produtos_has_Pedidos_Produtos1`
    FOREIGN KEY (`Produtos_id`)
    REFERENCES `roastbier`.`Produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produtos_has_Pedidos_Pedidos1`
    FOREIGN KEY (`Pedidos_numero`)
    REFERENCES `roastbier`.`Pedidos` (`numero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
