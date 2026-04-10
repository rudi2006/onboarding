#                                                        Onboarding Express API - LCL (Squad ERI)

##  Contexte du Projet
Cette API REST a été conçue sur-mesure dans le cadre de ma candidature pour le poste de **Développeur Back-End Java en alternance (24 mois)** au sein de la Squad ERI chez LCL. 

L'objectif de ce projet est de démontrer techniquement comment répondre à la promesse client de la Squad : **l'ouverture d'un compte bancaire mobile fonctionnel en moins de 10 minutes**, de manière sécurisée et supervisée.

##  Stack Technique
* **Langage :** Java 21 (Utilisation des `records`, API `java.time`)
* **Framework :** Spring Boot 4.0.5
* **Persistance :** Spring Data JPA / Hibernate
* **Base de données :** H2 Database (In-memory pour faciliter le test)
* **Validation :** Spring Boot Starter Validation
* **Supervision :** Spring Boot Actuator

## Fonctionnalités Principales
1. **Création de Compte (Fail-Fast) :** L'API réceptionne les données via un DTO immuable (`record`) et valide instantanément les formats (Email, champs vides, date dans le passé) avant traitement.
2. **Règles Métier Strictes :** * Vérification de l'unicité de l'adresse email.
   * Vérification de la majorité légale du client (18 ans minimum) calculée dynamiquement.
3. **Supervision Automatisée :** Intégration d'Actuator pour monitorer l'état de santé de l'API et de la base de données (`/actuator/health`), prêt à être branché sur un outil type Prometheus/Grafana.

##  Démarrage Rapide

### Prérequis
* Java 21 installé
* gradle
