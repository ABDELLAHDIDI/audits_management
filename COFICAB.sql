CREATE TABLE utilisateurs (
 id INT AUTO_INCREMENT PRIMARY KEY,
  role VARCHAR2(30),
  nom VARCHAR2(30),
  prenom VARCHAR2(30),
  email VARCHAR2(30) UNIQUE,
  mot_de_passe VARCHAR2(30) UNIQUE, 
  avatar BLOB,
  matricule VARCHAR2(30) UNIQUE,
  departement VARCHAR2(30),
  desactive BOOLEAN,
  duree_de_desactivation date 
);

CREATE TABLE question (
 id INT AUTO_INCREMENT PRIMARY KEY,
  description VARCHAR2(500),
  asterique VARCHAR2(30)
);

CREATE TABLE reponse (
 id INT AUTO_INCREMENT PRIMARY KEY,
  id_question INT,
  description VARCHAR2(500),
  FOREIGN KEY (id_question) REFERENCES question(id)
);

CREATE TABLE categorie (
 id INT AUTO_INCREMENT PRIMARY KEY,
  id_question INT,
  description VARCHAR2(30),
  number INT,
  FOREIGN KEY (id_question) REFERENCES question(id)
);

CREATE TABLE audit (
 id INT AUTO_INCREMENT PRIMARY KEY,
  id_utilisateur INT,
  id_categorie INT,
  date_de_creation DATE,
  date_de_realisation DATE,
  date_limite DATE,
  score FLOAT,
  niveau VARCHAR2(30),
  FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id),
  FOREIGN KEY (id_categorie) REFERENCES categorie(id)
);

CREATE TABLE type_audit (
 id INT AUTO_INCREMENT PRIMARY KEY,
  id_audit INT,
  nom VARCHAR2(30),
  type_de_reponse VARCHAR2(500),
  FOREIGN KEY (id_audit) REFERENCES audit(id)
);


CREATE TABLE colonne (
 id INT AUTO_INCREMENT PRIMARY KEY,
  id_type_audit INT,
  id_reponse INT,
  nom VARCHAR2(30),
  type_de_reponse VARCHAR2(500),
  FOREIGN KEY (id_type_audit) REFERENCES type_audit(id),
  FOREIGN KEY (id_reponse) REFERENCES reponse(id)
);