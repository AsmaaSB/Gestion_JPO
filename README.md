# Projet de gestion des Journées Portes Ouvertes :

  ## Contexte :
L'organisation régulière de journées portes ouvertes est une pratique courante pour les établissements d'enseignement, les entreprises et diverses institutions souhaitant présenter leurs activités au public. Ces événements permettent aux visiteurs de découvrir les locaux, les services et de rencontrer les membres de l'organisation. Face au nombre croissant de participants et à la diversité des événements organisés, il devient nécessaire de mettre en place un système informatique efficace pour gérer les inscriptions et le suivi des participants.

## Problématique :
 **Le processus manuel de gestion des journées portes ouvertes présente plusieurs défis :**

- Difficulté de suivi des inscriptions pour différents événements.
- Risque d'erreurs dans l'enregistrement des participants.
- Complications pour retrouver les informations d'un participant spécifique.
- Complexité dans l'analyse des taux de participation par événement.
- Absence de centralisation des données relatives aux événements et participants.
- Difficulté à communiquer efficacement avec les participants inscrits.

  ## Objectif :
 **L'objectif principal est de développer une application Java permettant de :**

- Centraliser la gestion des événements de type "portes ouvertes"
- Simplifier le processus d'inscription des participants
- Faciliter le suivi et l'organisation des événements
- Permettre une recherche et un filtrage efficaces des participants
- Offrir une interface intuitive pour les gestionnaires d'événements
- Sécuriser les données personnelles des participants
- Optimiser la communication avec les participants

## Diagramme de Cas d'Utilisation :
<img width="555" alt="image" src="https://github.com/user-attachments/assets/260bdf16-bec3-401d-986f-975a11cb2bc0" />

## Diagramme de Classe :
<img width="345" alt="image" src="https://github.com/user-attachments/assets/a9147595-5553-4a2f-8237-f1389be72271" />


## Script Base de données :
```bash
CREATE DATABASE gestion_jpo; USE gestion_jpo;

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
UNIQUE (evenement_id, participant_id) );

CREATE TABLE user (
    login VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
);

```


## Architecture :

 ### Couche Présentation (GUI)
EvenementForm.java : Interface pour la gestion des événements
ParticipantForm.java : Interface pour la gestion des participants
InscriptionForm.java : Interface pour les inscriptions


### Couche Métier (Services)
EvenementService.java : Logique métier pour les événements
ParticipantService.java : Logique métier pour les participants
InscriptionService.java : Logique métier pour les inscriptions

### Couche Entités (Modèles)
Evenement.java : Entité représentant un événement
Participant.java : Entité représentant un participant
InscriptionEvenement.java : Entité associative

### Couche Accès aux Données
Connexion.java : Gestion des connexions à la base de données
Services implémentant les opérations CRUD

### Base de Données
MySQL pour le stockage persistant des données

<img width="554" alt="image" src="https://github.com/user-attachments/assets/b239e8a0-d1f8-43a5-acea-d69b2e119267" />


## Technologies :
### Langage de Programmation
Java SE (Standard Edition)

### Interface Graphique
Java Swing pour les composants d'interface utilisateur
JFrame, JPanel, JTable pour la construction des formulaires
JDialog pour les boîtes de dialogue

### Accès aux Données
JDBC (Java Database Connectivity) pour la connexion à la base de données
Requêtes SQL préparées pour la sécurité et l'efficacité

### Base de Données
MySQL pour le stockage relationnel des données

### Outils de Développement
NetBeans IDE pour le développement
Git pour le contrôle de version 


# Demo Video :

https://github.com/user-attachments/assets/8ff3a45e-d818-43a8-b8a1-c8def5bb011e


