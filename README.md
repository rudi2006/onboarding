#  Onboarding Express API - Banking Sector PoC

##  Contexte du Projet
Cette API REST a été développée comme un démonstrateur technique (Proof of Concept) visant à illustrer les bonnes pratiques de conception logicielle et d'architecture backend appliquées au secteur bancaire.

L'objectif de ce projet est de répondre techniquement à une exigence métier forte : **permettre l'ouverture d'un compte bancaire mobile 100 % fonctionnel en un temps record (moins de 10 minutes)**, de manière sécurisée, déterministe et supervisée.

##  Stack Technique
* **Langage :** Java 21 (Utilisation des `records`, API `java.time`)
* **Framework :** Spring Boot 4.0.5
* **Persistance :** Spring Data JPA / Hibernate
* **Base de données :** H2 Database (In-memory pour faciliter le test)
* **Validation :** Spring Boot Starter Validation
* **Supervision :** Spring Boot Actuator

##  Fonctionnalités Principales
* **Création de Compte (Fail-Fast) :** L'API réceptionne les données via un DTO immuable (`record`) et valide instantanément les formats (Email, champs vides, date dans le passé) dès l'entrée du contrôleur pour protéger la logique métier.
* **Règles Métier Strictes :** * Vérification de l'unicité de l'adresse email.
  * Vérification de la majorité légale du client (18 ans minimum) calculée dynamiquement.
* **Supervision Automatisée :** Intégration d'Actuator pour monitorer l'état de santé de l'API et de la base de données (`/actuator/health`), prêt à être interfacé avec un écosystème d'observabilité (type Prometheus/Grafana).

##  Démarrage Rapide

### Prérequis
* Java 21 installé
* Gradle
