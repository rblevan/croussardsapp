
INSERT INTO students (numStudent,name,firstName,mail,pwdHash,dateBirth,pseudo) VALUES
    (1, 'Jean', 'Dupont', 'jean.dupont@mail.com', 'hash123', '2000-05-15', 'jdupont17'),
    (2, 'Lucas', 'Martin', 'lucas.martin@mail.com', 'hash124', '2002-02-07', 'lmartin23'),
    (3, 'Louise', 'Cartier', 'louise.cartier@mail.com', 'hash125', '2004-03-19', 'lcartier1'),
    (4, 'Maria', 'Dior', 'maria.dior@mail.com', 'hash126', '2006-09-24', 'mdior12');

INSERT INTO restaurants (idResto, name, adress, typeResto) VALUES
    (1, 'Le Gourmet', '12 Rue de Paris', 'Français'),
    (2, 'Sushi Zen', '45 Avenue Tokyo', 'Japonais'),
    (3, 'Pizza Roma', '78 Rue de Rome', 'Italien'),
    (4, 'Curry Palace', '10 Boulevard Delhi', 'Indien');

INSERT INTO reviews (idReview, numStudent, idResto, nbStars, comments, datePubli) VALUES
    (1, 1, 1, 5, 'Très bon restaurant, je recommande !', '2025-11-20'),
    (2, 2, 2, 4, 'Sushis corrects mais un peu chers.', '2025-11-18'),
    (3, 3, 3, 3, 'Pizza moyenne, pâte trop fine.', '2025-11-19'),
    (4, 4, 4, 5, 'Excellent curry, service impeccable.', '2025-11-20');
