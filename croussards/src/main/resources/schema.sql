DROP TABLE IF EXISTS Etudiants ;

CREATE TABLE Etudiants (
  numEtu INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  firstName VARCHAR(100) NOT NULL,
  mail VARCHAR(99) NOT NULL UNIQUE,
  pwd_hash VARCHAR(45) NOT NULL,
  dateBirth DATE NULL,
  pseudo VARCHAR(45) UNIQUE,
);

DROP TABLE IF EXISTS Restaurants ;

CREATE TABLE Restaurants (
  idResto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  adress VARCHAR(255) NULL,
  typeResto VARCHAR(45) NULL,
);

DROP TABLE IF EXISTS Reviews;

CREATE TABLE Reviews (
  idReviews INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  numStudents INT NOT NULL,
  idResto INT NOT NULL,
  nbStars INT NOT NULL DEFAULT 5,
  comments VARCHAR(500),
  datePubli DATE NOT NULL,

  CONSTRAINT NumStudents_fk
    FOREIGN KEY (numStudents)
    REFERENCES mydb.Etudiant (numStudents)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,

  CONSTRAINT idResto_fk
      FOREIGN KEY (idResto)
      REFERENCES mydb.restaurants (idResto)
      ON DELETE CASCADE
      ON UPDATE NO ACTION,

  CONSTRAINT check_stars
      CHECK (nbStars BETWEEN 1 AND 5)
);

DROP TABLE IF EXISTS Pictures;

CREATE TABLE Pictures (
  idPicture INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  idReviews INT NOT NULL,
  numUrl VARCHAR(255) NOT NULL,

  CONSTRAINT `idReviews_fk`
    FOREIGN KEY (`idReviews`)
    REFERENCES mydb.Reviews (`idReviews`)
    ON DELETE CASCADE                    
    ON UPDATE NO ACTION
);