-- 1. Table Etudiant 
CREATE TABLE IF NOT EXISTS `mydb`.`Etudiant` (
  `NumEtu` INT NOT NULL AUTO_INCREMENT, 
  `nom` VARCHAR(100) NOT NULL,          
  `prenom` VARCHAR(100) NOT NULL,
  `email` VARCHAR(99) NOT NULL UNIQUE,  
  `MDP_hash` VARCHAR(45) NOT NULL,      
  `DateNaissance` DATE NULL,
  `pseudo` VARCHAR(45) UNIQUE,         
  PRIMARY KEY (`NumEtu`))
ENGINE = InnoDB;


-- 2. Table restaurants 
CREATE TABLE IF NOT EXISTS `mydb`.`restaurants` (
  `idresto` INT NOT NULL AUTO_INCREMENT, 
  `nom` VARCHAR(100) NOT NULL,
  `adresse` VARCHAR(255) NULL,           
  `typeRestau` VARCHAR(45) NULL,
  PRIMARY KEY (`idresto`))
ENGINE = InnoDB;


-- 3. Table Avis
CREATE TABLE IF NOT EXISTS `mydb`.`Avis` (
  `idAvis` INT NOT NULL AUTO_INCREMENT,  
  `NumEtu` INT NOT NULL,                 
  `idresto` INT NOT NULL,                
  -- `IdPhoto` VARCHAR(45) NULL,          
  `NbEtoiles` INT NOT NULL DEFAULT 5,    
  `Commentaire` VARCHAR(500) NULL,       
  `DatePubli` DATE NOT NULL,             
  PRIMARY KEY (`idAvis`),
  INDEX `NumEtu_idx` (`NumEtu` ASC),     
  INDEX `idresto_idx` (`idresto` ASC),   
  CONSTRAINT `NumEtu_fk`                 
    FOREIGN KEY (`NumEtu`)
    REFERENCES `mydb`.`Etudiant` (`NumEtu`)
    ON DELETE CASCADE                    
    ON UPDATE NO ACTION,
  CONSTRAINT `idresto_fk`                
    FOREIGN KEY (`idresto`)
    REFERENCES `mydb`.`restaurants` (`idresto`)
    ON DELETE CASCADE                    
    ON UPDATE NO ACTION,
  CONSTRAINT `check_etoiles` CHECK (`NbEtoiles` BETWEEN 1 AND 5) 
ENGINE = InnoDB;


-- 4. Table Photos 
CREATE TABLE IF NOT EXISTS `mydb`.`Photos` (
  `idPhoto` INT NOT NULL AUTO_INCREMENT, 
  `idAvis` INT NOT NULL,
  `URL` VARCHAR(255) NOT NULL,           
  PRIMARY KEY (`idPhoto`),               
  INDEX `idAvis_idx` (`idAvis` ASC),     
  CONSTRAINT `IdAvis_fk`                 
    FOREIGN KEY (`idAvis`)
    REFERENCES `mydb`.`Avis` (`idAvis`)
    ON DELETE CASCADE                    
    ON UPDATE NO ACTION
)
ENGINE = InnoDB;