-- MySQL Script generated by MySQL Workbench
-- Thu Jun 16 18:00:49 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema projeto
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema projeto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projeto` DEFAULT CHARACTER SET utf8 ;
USE `projeto` ;

-- -----------------------------------------------------
-- Table `projeto`.`local`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`local` (
  `idlocal` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idlocal`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`pokemon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`pokemon` (
  `idpokemon` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `local_idlocal` INT NOT NULL,
  PRIMARY KEY (`idpokemon`, `local_idlocal`),
  UNIQUE INDEX `id_UNIQUE` (`idpokemon` ASC) VISIBLE,
  INDEX `fk_pokemon_local_idx` (`local_idlocal` ASC) VISIBLE,
  CONSTRAINT `fk_pokemon_local`
    FOREIGN KEY (`local_idlocal`)
    REFERENCES `projeto`.`local` (`idlocal`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`pokedex`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`pokedex` (
  `idpokedex` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idpokedex`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto`.`pokemon_da_pokedex`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto`.`pokemon_da_pokedex` (
  `pokedex_idpokedex` INT NOT NULL,
  `pokemon_idpokemon` INT NOT NULL,
  `pokemon_local_idlocal` INT NOT NULL,
  `pokemon_lvl` INT NOT NULL,
  `pokemon_shiny` TINYINT NOT NULL,
  PRIMARY KEY (`pokedex_idpokedex`, `pokemon_idpokemon`, `pokemon_local_idlocal`),
  INDEX `fk_pokedex_has_pokemon_pokemon1_idx` (`pokemon_idpokemon` ASC, `pokemon_local_idlocal` ASC) VISIBLE,
  INDEX `fk_pokedex_has_pokemon_pokedex1_idx` (`pokedex_idpokedex` ASC) VISIBLE,
  CONSTRAINT `fk_pokedex_has_pokemon_pokedex1`
    FOREIGN KEY (`pokedex_idpokedex`)
    REFERENCES `projeto`.`pokedex` (`idpokedex`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_pokedex_has_pokemon_pokemon1`
    FOREIGN KEY (`pokemon_idpokemon` , `pokemon_local_idlocal`)
    REFERENCES `projeto`.`pokemon` (`idpokemon` , `local_idlocal`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
