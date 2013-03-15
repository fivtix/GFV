SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `n20404039` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `n20404039` ;

-- -----------------------------------------------------
-- Table `n20404039`.`Document`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Document` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Document` (
  `id_documents` INT NOT NULL AUTO_INCREMENT ,
  `nom` VARCHAR(70) NULL ,
  `emplacement` VARCHAR(250) NULL ,
  `donnee` LONGBLOB NULL ,
  PRIMARY KEY (`id_documents`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Adresses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Adresses` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Adresses` (
  `id_adresse` INT NOT NULL AUTO_INCREMENT ,
  `numero_rue` INT NULL ,
  `nom_rue` VARCHAR(45) NOT NULL ,
  `ville` VARCHAR(45) NOT NULL ,
  `code_postal` VARCHAR(15) NOT NULL ,
  `pays` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_adresse`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Entreprise`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Entreprise` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Entreprise` (
  `id_entreprise` INT NOT NULL AUTO_INCREMENT ,
  `id_Adresse` INT NOT NULL ,
  `nom` VARCHAR(70) NOT NULL ,
  PRIMARY KEY (`id_entreprise`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Infos_Personnelles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Infos_Personnelles` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Infos_Personnelles` (
  `id_personnel` INT NOT NULL AUTO_INCREMENT ,
  `id_entreprise` INT NULL ,
  `id_adresse` INT NOT NULL ,
  `nom` VARCHAR(45) NOT NULL ,
  `prenom` VARCHAR(45) NOT NULL ,
  `date_naissance` DATE NOT NULL ,
  `travail` VARCHAR(45) NOT NULL ,
  `tel` VARCHAR(25) NULL ,
  `email` VARCHAR(45) NULL ,
  `siteweb` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_personnel`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Type_vehicule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Type_vehicule` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Type_vehicule` (
  `type_vehicule` VARCHAR(40) NOT NULL ,
  PRIMARY KEY (`type_vehicule`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Vehicule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Vehicule` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Vehicule` (
  `id_vehicule` INT NOT NULL AUTO_INCREMENT ,
  `type_vehicule` VARCHAR(40) NOT NULL ,
  PRIMARY KEY (`id_vehicule`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Moyen_Transport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Moyen_Transport` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Moyen_Transport` (
  `id_moyen_transport` INT NOT NULL AUTO_INCREMENT ,
  `id_personnel` INT NOT NULL ,
  `id_vehicule` INT NOT NULL ,
  PRIMARY KEY (`id_moyen_transport`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Trajet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Trajet` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Trajet` (
  `id_trajet` INT NOT NULL AUTO_INCREMENT ,
  `nom` VARCHAR(70) NULL ,
  PRIMARY KEY (`id_trajet`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Gestion_Transports`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Gestion_Transports` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Gestion_Transports` (
  `id_gestion_des_transports` INT NOT NULL AUTO_INCREMENT ,
  `id_personnel` INT NOT NULL ,
  `id_moyen_transport` INT NOT NULL ,
  `id_trajet` INT NOT NULL ,
  `nom` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id_gestion_des_transports`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Lieux`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Lieux` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Lieux` (
  `id_lieu` INT NOT NULL AUTO_INCREMENT ,
  `id_Adresse` INT NOT NULL ,
  `nom` VARCHAR(70) NULL ,
  `coordonnées` VARCHAR(70) NOT NULL ,
  PRIMARY KEY (`id_lieu`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Marchandises`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Marchandises` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Marchandises` (
  `id_Marchandises` VARCHAR(40) NOT NULL ,
  PRIMARY KEY (`id_Marchandises`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`NatureMarchandises`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`NatureMarchandises` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`NatureMarchandises` (
  `id_NatureMarchandises` VARCHAR(25) NOT NULL ,
  PRIMARY KEY (`id_NatureMarchandises`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Transport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Transport` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Transport` (
  `id_transport` INT NOT NULL AUTO_INCREMENT ,
  `estimation_cout` INT NULL ,
  `date_depart` DATETIME NOT NULL ,
  `date_arrivee` DATETIME NOT NULL ,
  `depart` INT NOT NULL ,
  `arrive` INT NOT NULL ,
  `id_entreprise` INT NOT NULL ,
  `type_vehicule` VARCHAR(40) NOT NULL ,
  `id_Marchandises` VARCHAR(40) NOT NULL ,
  `id_NatureMarchandises` INT NOT NULL ,
  PRIMARY KEY (`id_transport`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Arretes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Arretes` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Arretes` (
  `id_arrete` INT NOT NULL AUTO_INCREMENT ,
  `id_trajet` INT NOT NULL ,
  `depart` INT NOT NULL ,
  `arrive` INT NOT NULL ,
  `nom` VARCHAR(45) NOT NULL ,
  `distance` INT NULL ,
  `carte` LONGBLOB NULL ,
  PRIMARY KEY (`id_arrete`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Itineraires`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Itineraires` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Itineraires` (
  `id_arrete` INT NOT NULL ,
  `id_lieu` INT NOT NULL ,
  `distance` INT NOT NULL ,
  `intro` VARCHAR(60) NULL )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Roles` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Roles` (
  `id_roles` VARCHAR(40) NOT NULL ,
  PRIMARY KEY (`id_roles`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Users` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Users` (
  `id_users` VARCHAR(25) NOT NULL ,
  `id_Personnel` INT NOT NULL ,
  PRIMARY KEY (`id_users`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Roles_Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Roles_Users` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Roles_Users` (
  `id_roles` TEXT NOT NULL ,
  `id_users` INT NOT NULL )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Documents_Personne`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Documents_Personne` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Documents_Personne` (
  `id_personnel` INT NOT NULL ,
  `id_documents` INT NOT NULL )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Document_Vehicule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Document_Vehicule` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Document_Vehicule` (
  `id_vehicule` INT NOT NULL ,
  `id_documents` INT NOT NULL )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Ligne_Transport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Ligne_Transport` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Ligne_Transport` (
  `id_transport` INT NOT NULL ,
  `id_gestion_transports` INT NOT NULL ,
  `id_arrete` INT NOT NULL )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Gestion_Accidents`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Gestion_Accidents` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Gestion_Accidents` (
  `id_accident` INT NOT NULL AUTO_INCREMENT ,
  `gestion_des_transports_idgestion_des_transports` INT NOT NULL ,
  `type_accident` VARCHAR(45) NULL ,
  `description` VARCHAR(250) NULL ,
  PRIMARY KEY (`id_accident`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Document_Gestion_Transports`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Document_Gestion_Transports` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Document_Gestion_Transports` (
  `id_gestion_transports` INT NOT NULL ,
  `id_documents` INT NOT NULL )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Document_Transport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Document_Transport` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Document_Transport` (
  `id_documents` INT NOT NULL ,
  `id_transport` INT NOT NULL )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `n20404039`.`Horaires`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `n20404039`.`Horaires` ;

CREATE  TABLE IF NOT EXISTS `n20404039`.`Horaires` (
  `id_arrete` INT NOT NULL ,
  `id_trajet` INT NOT NULL ,
  `id_gestion_des_transports` INT NOT NULL ,
  `date_heure_depart` DATETIME NOT NULL ,
  `date_heure_arrive` DATETIME NOT NULL ,
  `date_heure_depart_reelle` DATETIME NULL ,
  `date_heure_arrivee_reelle` DATETIME NULL )
ENGINE = InnoDB;

USE `n20404039` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;