Projet de gestion des Journées Portes Ouvertes :

CREATE DATABASE gestion_jpo;
USE gestion_jpo;

CREATE TABLE Evenement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    lieu VARCHAR(255) NOT NULL
);

CREATE TABLE Participant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE InscriptionEvenement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    evenement_id INT NOT NULL,
    participant_id INT NOT NULL,
    FOREIGN KEY (evenement_id) REFERENCES Evenement(id) ON DELETE CASCADE,
    FOREIGN KEY (participant_id) REFERENCES Participant(id) ON DELETE CASCADE,
    UNIQUE (evenement_id, participant_id)
);
