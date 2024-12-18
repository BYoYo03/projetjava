# Jeu d'Aventure en Java

## Description

Ce projet est un jeu d'aventure textuel développé en Java. Le joueur incarne un personnage qui explore différentes cartes, combat des ennemis, collecte des objets et utilise des capacités spéciales pour atteindre la victoire.

## Fonctionnalités

- **Exploration** : Parcourez différentes cartes, comme une forêt, une ville ou un château.
- **Combat** : Luttez contre divers ennemis, en utilisant des attaques classiques ou des capacités spéciales.
- **Gestion des objets** : Ramassez des objets pour améliorer votre personnage (ex. potions de vie, bonus d'attaque).
- **Changement de capacités** : Utilisez des objets spéciaux pour changer temporairement vos capacités. (Le changement se fait que si vous ramassé un objet et que vous tombez sur le bon objet, ensuite quand vous serez en combat quand vous voudrez utiliser votre capcité spéciale, la possibilité de changer la capacité se proposera à vous.
- **Système de logging** : Les événements de jeu sont enregistrés dans un fichier `game.log`, n'hésitez pas à le vider si celui-ci est remplis.

**Le cahier des charges est entièrement respecté. La gestion des objets, le changement de capacités entre les personnages (héros(hero), chevalier, magicien) ainsi que les combats à plusieurs ennemies sont des fonctionnalités supplémentaires demandées par le professeur.**

C'est aussi pour cela qu'il y a un seul combat à plusieurs (dans la carte fôret) pour montrer que la fonctionnalité est bien implémentée mais pas totalement optimisée.


## Fichiers principaux

### 1. `Jeu.java`
Gère le flux principal du jeu :
- Début et fin de la partie.
- Gestion des cartes, des déplacements et des interactions avec les ennemis et les objets.
- Implémentation des combats simples (et multiples).

### 2. `Carte.java`
Représente une carte :
- Affiche la carte et gère les déplacements du héros.

### 3. `Personnage.java`
Classe de base pour tous les personnages :
- Définit les attributs (vie, attaque, défense, etc.).
- Contient des méthodes pour les attaques et l'utilisation des capacités spéciales.

### 4. `CustomFormat.java`
Personnalise le format des logs :
- Formatage des messages de log pour afficher les informations de jeu de manière claire.
- Les logs sont écrits dans un fichier `game.log` pour suivre les actions du joueur.


### 4. `Capacitespeciale.java`
Interface qui implémente la capacité spéciale.
Chaques personnages a sa propre capacité spéciale (héros(hero), chevalier, magicien), implémentée dans les classes correspondantes.

## Comment jouer ?

1. Clonez ce dépôt ou téléchargez les fichiers sources.
2. Compilez le projet avec un compilateur Java.
3. Exécutez la classe principale `App.java`.
4. Suivez les instructions affichées dans la console pour explorer les cartes, choisir votre personnage et interagir avec le monde du jeu.

## Exemple de gameplay

- **Déplacement** : Choisissez une direction (z = haut, q = gauche, s = bas, d = droite).
- **Combat** : Engagez-vous contre des ennemis (cases E ou C pour un combat contre plusieurs ennemies)
- **Collecte d'objets** : Ramassez des potions pour restaurer votre santé ou augmenter vos capacités.
- **Niveau** : La partie se finit une fois que vous avez tué tous les ennemeis ou si vous êtes mort


## Dépendances

Ce projet utilise JUnit 4 pour les tests unitaires. Pour exécuter les tests, assurez-vous d'avoir ajouté les dépendances suivantes dans votre fichier `pom.xml` :

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

## Auteur

Développé par Bahir et Merwane.

Maven : 

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>
