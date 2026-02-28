# 🍽️ Croussards App

> **Plateforme d'avis et de gestion pour les Restaurants Universitaires (RU).**

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Frontend-blue)
![Architecture](https://img.shields.io/badge/Architecture-Client%2FServer-purple)

## 🎓 Contexte du projet
Ce projet a été réalisé dans le cadre de ma **3ème année de Licence Informatique (L3)** à l'Université de Poitiers.
L'objectif était de concevoir une architecture logicielle complète séparant la logique métier (API REST) de l'interface utilisateur, tout en respectant les principes de conception MVC.

Je l'ai réalisé avec deux de mes camarades :
 - Stéphane CASTAN (@stephcstn) [https://github.com/stephcstn]
 - Basile DUFRENE (@Basile) [https://github.com/Basile-Dufrene]

---

## 🏗️ Architecture Technique

Le projet est structuré en deux modules Maven distincts, simulant une architecture micro-services légère :

### 1. 🧱 Croussards API (`croussardsapi`)
C'est le cœur du système. Une API RESTful qui gère la logique métier et la persistance des données.
* **Technologies :** Spring Boot, Spring Data JPA, H2 Database / MySQL.
* **Rôle :** Expose des endpoints pour gérer les étudiants, les restaurants et les avis.
* **Conception :** Utilisation du pattern *Controller - Service - Repository*.

### 2. 🖥️ Croussards Web (`croussardsweb`)
L'interface utilisateur destinée aux étudiants.
* **Technologies :** Spring Boot, Thymeleaf, HTML5/CSS3, Bootstrap.
* **Rôle :** Consomme l'API via des **Proxies** (Design Pattern Proxy) pour afficher les données.
* **Fonctionnalités :**
    * Authentification des étudiants.
    * Consultation de la liste des Restaurants Universitaires.
    * Dépôt et lecture d'avis sur les repas.

---

## 🚀 Fonctionnalités Clés

* **Système d'authentification :** Connexion et inscription sécurisées pour les étudiants.
* **Catalogue des RU :** Affichage dynamique des restaurants disponibles.
* **Gestion des avis :** Les étudiants peuvent noter les restaurants et laisser des commentaires.
* **Persistance :** Base de données relationnelle initialisée avec des données de test (`data.sql`).

---

## 🛠️ Installation et Démarrage

Pour lancer le projet localement, vous devez démarrer les deux modules (API puis Web).

### Prérequis
* Java JDK 17 ou supérieur
* Maven

### 1. Démarrer l'API (Backend)
```bash

### Note

Un fichier gitlab pour le CI/CD s'y trouve car le projet a été réalisé dans le cadre université sous un serveur GitLab d'enseignement.
cd croussardsapi
./mvnw spring-boot:run
