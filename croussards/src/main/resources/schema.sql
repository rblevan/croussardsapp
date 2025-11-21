DROP TABLE IF EXISTS students;

CREATE TABLE students (
    numStudents INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    firstName VARCHAR(100) NOT NULL,
    mail VARCHAR(99) NOT NULL UNIQUE,
    pwdHash VARCHAR(45) NOT NULL,
    dateBirth DATE NULL,
    pseudo VARCHAR(45) UNIQUE
);

DROP TABLE IF EXISTS restaurants;

CREATE TABLE restaurants (
    idResto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    adress VARCHAR(255) NULL,
    typeResto VARCHAR(45) NULL
);

DROP TABLE IF EXISTS reviews;

CREATE TABLE reviews (
    idReviews INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numStudents INT NOT NULL,
    idResto INT NOT NULL,
    nbStars INT NOT NULL DEFAULT 5,
    comments VARCHAR(500),
    datePubli DATE NOT NULL,

    CONSTRAINT fk_numEtu
     FOREIGN KEY (numStudents)
     REFERENCES students(numStudents)
     ON DELETE CASCADE
     ON UPDATE NO ACTION,

    CONSTRAINT fk_idResto
     FOREIGN KEY (idResto)
     REFERENCES restaurants(idResto)
     ON DELETE CASCADE
     ON UPDATE NO ACTION,

    CONSTRAINT check_stars
     CHECK (nbStars BETWEEN 1 AND 5)
);
