# Techniques de test

- Nom : Genouiz
- Prénom : Mustapha
- Groupe : M1 IA Classique

## Statut des Builds et Couverture des Tests et Checkstyles (Badges)

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/Mustapha-Kdb/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/Mustapha-Kdb/ceri-m1-techniques-de-test/tree/master)
[![codecov](https://codecov.io/gh/Mustapha-Kdb/ceri-m1-techniques-de-test/graph/badge.svg?token=6JNCQ0TG5R)](https://codecov.io/gh/Mustapha-Kdb/ceri-m1-techniques-de-test)
![Checkstyle Badge](src/main/resources/badges/checkstyle-result.svg)


## À Propos du Projet

Ce projet s'inscrit dans le cadre d'un exercice pratique visant à mettre en application des méthodologies modernes de développement logiciel telles que le Test-Driven Development (TDD) et l'Intégration Continue (CI), en se basant sur le thème ludique d'un jeu de Pokémon. L'objectif principal de ce travail est de développer une application robuste et maintenable, en appliquant ces principes fondamentaux à chaque étape du développement.

### Intégration Continue avec CircleCI

Nous avons commencé par mettre en place un pipeline d'Intégration Continue (CI) utilisant CircleCI, un outil puissant qui automatise le processus de test et de déploiement de notre application. À chaque modification et push du code sur notre dépôt GitHub, le pipeline CI est invoqué grâce à une configuration détaillée dans le fichier `circle.yml`. Cette approche garantit que chaque version du projet reste stable et fonctionnelle, minimisant ainsi les régressions et les bugs.

### Test-Driven Development avec JUnit et Mockito

Le Test-Driven Development (TDD) est au cœur de notre méthodologie de développement. Nous avons écrit des tests unitaires pour chaque interface et classe avant même d'implémenter leur logique. Cela nous a permis de concevoir notre code de manière réfléchie, en s'assurant qu'il répond à des critères précis de fonctionnalité. Pour la rédaction des tests, nous avons utilisé JUnit, un framework de test unitaire pour Java, combiné à Mockito pour la création de mocks, simulant les comportements des dépendances. Ce processus rigoureux assure non seulement la fiabilité de notre code mais encourage également une conception modulaire et une meilleure compréhension des fonctionnalités développées.

### Suivi de la Couverture de Code avec Codecov et JaCoCo

Ensuite, l'intégration de Codecov à notre pipeline CI nous a permis de suivre le pourcentage de couverture de code de notre projet. Grâce aux rapports générés par JaCoCo, un outil de couverture de code pour Java, nous pouvons visualiser quels segments de notre code sont effectivement testés par nos tests unitaires. Cela nous offre une perspective précieuse sur la qualité et la robustesse de notre base de code, nous permettant d'identifier les zones nécessitant une attention supplémentaire ou des tests plus approfondis.

### ... To be continued 

