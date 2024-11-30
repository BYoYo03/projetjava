package com.example.definition;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.text.Utilities;

import com.example.definition.DefEnnemies.Brigand;
import com.example.definition.DefEnnemies.Catcheur;
import com.example.definition.DefEnnemies.Gangster;
import com.example.definition.DefEnnemies.Monstre;
import com.example.definition.DefHeros.Capacitespeciale;
import com.example.definition.DefHeros.Chevalier;
import com.example.definition.DefHeros.Hero;
import com.example.definition.DefHeros.Magicien;
import com.example.definition.TypesPerso.Personnage;

public class Jeu {

    private static final Logger logger = Logger.getLogger(Jeu.class.getName());

    public Jeu() {

        try {
            // Supprimer tous les handlers existants (comme le ConsoleHandler par défaut)
            Logger rootLogger = Logger.getLogger("");
            Handler[] handlers = rootLogger.getHandlers();
            for (Handler handler : handlers) {
                rootLogger.removeHandler(handler);
            }

            // Créer un FileHandler pour écrire dans un fichier de log nommé "game.log"
            FileHandler fileHandler = new FileHandler("game.log", true);

            // Utiliser le CustomFormatter au lieu du SimpleFormatter par défaut
            CustomFormat formatter = new CustomFormat();
            fileHandler.setFormatter(formatter);

            // Ajouter uniquement le FileHandler au logger
            logger.addHandler(fileHandler);

            // Définir le niveau de logging
            logger.setLevel(Level.INFO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void commencer() {
        logger.info("Le jeu commence");
        System.out.println("Le jeu commence");
    }

    char[][] foret = {
            { 'H', '.', 'C', '.', 'O' },
            { '.', '.', '.', '.', '.' },
            { '.', 'E', '.', '.', '.' },
            { '.', '.', '.', '.', 'E' },
            { '.', '.', '.', '.', '.' }
    };

    char[][] ville = {
            { 'H', '.', '.', '.', '.' },
            { '.', '.', '.', '.', 'E' },
            { '.', '.', 'E', '.', '.' },
            { '.', 'E', '.', 'O', '.' },
            { '.', '.', '.', 'E', '.' }
    };
    char[][] chateau = {
            { 'H', '.', '.', 'E', '.' },
            { '.', '.', '.', '.', '.' },
            { '.', 'E', '.', '.', '.' },
            { '.', '.', '.', '.', 'E' },
            { '.', '.', 'O', '.', '.' }
    };

    public void choixperso(Carte cartee) {
        logger.info("Choix du personnage");
        System.out.println("");
        System.out.println("Choisissez votre personnage");
        Scanner sc = new Scanner(System.in);
        System.out.println("H. Hero");
        System.out.println("C. Chevalier");
        System.out.println("M. Magicien");
        String choix = sc.next();
        if (choix.equals("H")) {
            logger.info("Hero choisi");
            Hero hero = new Hero();
            System.out.println(hero);
            debuterpartie(new Hero(), cartee);
        } else if (choix.equals("C")) {
            logger.info("Chevalier choisi");
            Chevalier chevalier = new Chevalier();
            System.out.println(chevalier);
            debuterpartie(new Chevalier(), cartee);
        } else if (choix.equals("M")) {
            logger.info("Magicien choisi");
            Magicien magicien = new Magicien();
            System.out.println(magicien);
            debuterpartie(new Magicien(), cartee);
        } else {
            logger.info("L'utilisateur a choisi un personnage invalide");
            System.out.println("Choix invalide");
            choixperso(cartee);
        }
        System.out.println("");

    }

    public void findepartie() {
        logger.info("La partie est terminée");
        System.out.println("La partie est terminée");
        System.exit(0);
    }

    public void verifennemie(Carte cartee) {
        // verifier s'il reste des ennemis sinon fin de partie
        boolean ennemiRestant = false;
        // parcourir la carte
        for (int i = 0; i < cartee.map.length; i++) {
            // parcourir la ligne
            for (int j = 0; j < cartee.map[i].length; j++) {
                // si un ennemi est trouvé, sortir de la boucle et continuer le jeu
                if (cartee.map[i][j] == 'E') {
                    ennemiRestant = true;
                    return;
                }
            }
        }
        // si aucun ennemi n'est trouvé, fin de partie
        if (ennemiRestant == false) {
            logger.info("Il n'y a plus d'ennemis");
            System.out.println("Il n'y a plus d'ennemis");
            logger.info("Vous avez gagné");
            System.out.println("Vous avez gagné");
            findepartie();
        }
    }

    public void combatmulti(Personnage a, Personnage temp1, Personnage temp2, Carte cartee, int x, int y) {
        System.out.println("");
        System.out.println("Specs de l'ennemi : " + temp1);
        logger.info("Specs de l'ennemi 1 : " + temp1);
        System.out.println("Specs de l'ennemi : " + temp2);
        logger.info("Specs de l'ennemi 1 : " + temp2);
        while (a.getVie() > 0 && (temp1.getVie() > 0 || temp2.getVie() > 0)) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("");
            System.out.println("===================================");
            System.out.println("          ⚔️  COMBAT  ⚔️           ");
            System.out.println("===================================");
            System.out.println("");
            System.out.println("👤 Héros : " + a.getClass().getSimpleName() + "  VS  🐉 Ennemis : "
                    + temp1.getClass().getSimpleName() + " et " + temp2.getClass().getSimpleName());
            System.out.println("❤️ Vie Héros : " + a.getVie() + "  |  🩸 Vie Ennemie 1 : " + temp1.getVie()
                    + "  |  🩸 Vie Ennemie 2 : " + temp2.getVie());
            System.out.println("");
            System.out.println("===================================");
            System.out.println(" Que voulez-vous faire ?");
            System.out.println("===================================");
            System.out.println("A. 🗡️ Attaquer ennemie 1 : " + temp1.getClass().getSimpleName());
            System.out.println("B. 🗡️ Attaquer ennemie 2 : " + temp2.getClass().getSimpleName());
            System.out.println("C. ✨ Capacité spéciale sur ennemie 1 : " + temp1.getClass().getSimpleName());
            System.out.println("D. ✨ Capacité spéciale sur ennemie 2 : " + temp2.getClass().getSimpleName());
            System.out.println("");
            System.out.println("===================================");

            String choix1 = sc1.next();

            if (choix1.equals("A")) {
                logger.info("Vérification de qui attaque en premier entre le joueur et l'ennemi 1 et attaque");
                if (temp1.getVie() > 0) {
                    a.attaquepremier(temp1);
                } else {
                    System.out.println(
                            "L'ennemi 1 est mort, vous pouvez attaquer l'ennemi 2 " + temp2.getClass().getSimpleName());
                }
            } else if (choix1.equals("B")) {
                logger.info("Vérification de qui attaque en premier entre le joueur et l'ennemi 2 et attaque");
                if (temp2.getVie() > 0) {
                    a.attaquepremier(temp2);
                } else {
                    System.out.println(
                            "L'ennemi 2 est mort, vous pouvez attaquer l'ennemi 1 " + temp1.getClass().getSimpleName());
                }
            } else if (choix1.equals("C")) {
                logger.info("Utilisation de la capacité spéciale de l'ennemi 1 par le joueur");
                if (temp1.getVie() > 0) {
                    ((Capacitespeciale) a).utiliserCapacite(temp1);
                } else {
                    logger.info("L'ennemi 1 est mort");
                    System.out.println(
                            "L'ennemi 1 est mort, vous pouvez attaquer l'ennemi 2 " + temp2.getClass().getSimpleName());
                }
            } else if (choix1.equals("D")) {

                if (temp2.getVie() > 0) {
                    logger.info("Utilisation de la capacité spéciale de l'ennemi 2 par le joueur");
                    ((Capacitespeciale) a).utiliserCapacite(temp2);
                } else {
                    System.out.println(
                            "L'ennemi 2 est mort, vous pouvez attaquer l'ennemi 1 " + temp1.getClass().getSimpleName());
                }
            } else {
                logger.info("Choix invalide");
                System.out.println("Choix invalide");
            }
        }

        if (temp1.getVie() <= 0 && temp2.getVie() <= 0) {
            logger.info("Vous avez gagné");
            System.out.println("Vous avez gagné");
            System.out.println("");
            cartee.map[cartee.x][cartee.y] = 'H';
        } else if (a.getVie() <= 0) {
            logger.info("Vous avez perdu");
            System.out.println("Vous avez perdu");
            findepartie();
        } else {
            cartee.map[cartee.x][cartee.y] = 'X';
        }
    }

    public void combattre(Personnage a, Personnage b, Carte cartee, int x, int y) {
        System.out.println("");
        System.out.println("Specs de l'ennemi : " + b);
        logger.info("Specs de l'ennemi : " + b);
        while (a.getVie() > 0 && b.getVie() > 0) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("");
            System.out.println("===================================");
            System.out.println("           🌟 MENU ACTIONS          ");
            System.out.println("===================================");
            System.out.println("");
            System.out.println("A. 🗡️  Attaquer");
            System.out.println("B. ✨  Utiliser une capacité spéciale");
            System.out.println("C. 🏃  Fuir");
            System.out.println("");
            System.out.println("===================================");
            String choix1 = sc1.next();

            if (choix1.equals("A")) {
                logger.info("Vérification de qui attaque en premier entre le joueur et l'ennemi et attaque");
                a.attaquepremier(b);
            } else if (choix1.equals("B")) {
                if (a instanceof Capacitespeciale) {
                    if (a.getNbrchangement() == true) {
                        logger.info("Le" + a.getClass().getSimpleName() + " a déjà utilisé sa capacité spéciale");
                        System.out.println("Le" + a.getClass().getSimpleName() + " a déjà utilisé sa capacité spéciale");
                    } else {
                        if (a.getChangement() == true) {
                            Scanner sc2 = new Scanner(System.in);
                            System.out.println(
                                    "Voulez-vous utiliser l'attaque spéciale avec Chevalier (C) ou Mage (M) ou Hero (H) ?");
                            String choix2 = sc2.next();
                            Personnage temp = null;
                            if (choix2.equals("C")) {
                                temp = new Chevalier();
                            } else if (choix2.equals("M")) {
                                temp = new Magicien();
                            } else if (choix2.equals("H")) {
                                temp = new Hero();
                            } else {
                                logger.info("Choix invalide");
                                System.out.println("Choix invalide");
                            }
                            a.changementattaquecapacite(temp, b);
                            a.setNbrchangement(true);
                        } else if (a.getChangement() == false) {
                            logger.info("Utilisation de la capacité spéciale de " + a + " sur " + b);
                            ((Capacitespeciale) a).utiliserCapacite(b); // Utilisation de la capacité spéciale
                        }
                    }
                } else {
                    logger.info("Ce personnage n'a pas de capacité spéciale");
                    System.out.println("Ce personnage n'a pas de capacité spéciale.");
                }
            } else if (choix1.equals("C")) {
                logger.info("Fuite");
                System.out.println("Tu ne peux pas fuir");
            } else {
                logger.info("Choix invalide");
                System.out.println("Choix invalide");
            }
        }

        if (b.getVie() <= 0) {
            logger.info("Vous avez gagné");
            System.out.println("Vous avez gagné");
            System.out.println("");
            cartee.map[cartee.x][cartee.y] = 'H';
        } else if (a.getVie() <= 0) {
            logger.info("Vous avez perdu");
            System.out.println("Vous avez perdu");
            findepartie();
        } else {
            cartee.map[cartee.x][cartee.y] = 'X';
        }
    }

    public void choixcarte() {
        logger.info("Choix de la carte");
        System.out.println("Choissisez la carte");
        System.out.println("Votre personnage est représenté par la lettre H");
        System.out.println("Les ennemis sont représentés par la lettre E");
        logger.info("Affichage des cartes disponibles");
        System.out.println("Voici les cartes disponibles");
        System.out.println("");
        Carte foret = new Carte(this.foret, 0, 0);
        Carte ville = new Carte(this.ville, 0, 0);
        Carte chateau = new Carte(this.chateau, 0, 0);
        System.out.println("Foret");
        foret.afficherCarte();
        System.out.println("");
        System.out.println("Ville");
        ville.afficherCarte();
        System.out.println("");
        System.out.println("Chateau");
        chateau.afficherCarte();
        System.out.println("");

        Carte cartee = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("F. Foret");
        System.out.println("V. Ville");
        System.out.println("C. Chateau");
        String choixCarte = scan.next();
        if (choixCarte.equals("F")) {
            logger.info("Carte choisie : Foret");
            cartee = new Carte(this.foret, 0, 0);
            choixperso(cartee);
        } else if (choixCarte.equals("V")) {
            logger.info("Carte choisie : Ville");
            cartee = new Carte(this.ville, 0, 0);
            choixperso(cartee);
        } else if (choixCarte.equals("C")) {
            logger.info("Carte choisie : Chateau");
            cartee = new Carte(this.chateau, 0, 0);
            choixperso(cartee);
        } else {
            System.out.println("Choix invalide");
            logger.info("Choix invalide");
            choixcarte();
        }
    }

    public void objet(Personnage a, Carte cartee, int newX, int newY) {
        int random = (int) (Math.random() * 4);
        random = 3;
        if (random == 0) {
            logger.info("Vous avez trouvé un objet : Potion de vie");
            System.out.println("Vous avez trouvé un objet : Potion de vie");
            a.setVie(100);
            System.out.println("Votre vie est maintenant à 100");
        } else if (random == 1) {
            logger.info("Vous avez trouvé un objet : Potion de force");
            System.out.println("Vous avez trouvé un objet : Potion de force");
            a.setAttaque(25);
            System.out.println("Votre attaque est maintenant à 25");
        } else if (random == 2) {
            if (a instanceof Capacitespeciale) {
                logger.info("Vous avez trouvé un objet : Recharger sa capacité spéciale");
                System.out.println("Recharger sa capacité spéciale");
                ((Capacitespeciale) a).rechargerCapacite();
                a.setNbrchangement(false);
            }
        } else if (random == 3) {
            if (a instanceof Capacitespeciale) {
                logger.info(
                        "Vous avez trouvé un objet : Changement de capacité spéciale 1 fois quand vous utiliserez cette capacité");
                System.out.println("Vous avez trouvé un objet : Changement de capacité spéciale 1 fois quand vous utiliserez cette capacité");
                a.setChangement(true);
            }
        }
        cartee.map[newX][newY] = 'H';
    }

    public void debuterpartie(Personnage a, Carte cartee) {
        System.out.println("");
        logger.info("La partie commence");
        System.out.println("La partie commence");
        cartee.afficherCarte();
        Scanner sc = new Scanner(System.in);
        while (true) {

            // Vérification de la présence d'un ennemi sur la carte et fin de partie si
            // aucun ennemi n'est trouvé
            verifennemie(cartee);

            // Choix du joueur pour se déplacer
            System.out.println("");
            System.out.println("Votre " + a.getClass().getSimpleName() + " a " + a.getVie() + " points de vie");
            System.out.println("Tour du joueur");
            System.out.println("z. Monter ");
            System.out.println("q. Gauche ");
            System.out.println("s. Descendre ");
            System.out.println("d. Droite ");
            System.out.println("2. Quitter");
            String choix = sc.next();

            // Déplacement du joueur
            int newX = cartee.x;
            int newY = cartee.y;

            if (choix.equals("z")) {
                if (cartee.x > 0) {
                    logger.info("Déplacement du joueur vers le haut");
                    newX -= 1;
                } else {
                    logger.info("Vous ne pouvez pas monter plus haut");
                    System.out.println("Vous ne pouvez pas monter plus haut.");
                    continue;
                }
            } else if (choix.equals("s")) {
                if (cartee.x < cartee.map.length - 1) {
                    logger.info("Déplacement du joueur vers le bas");
                    newX += 1;
                } else {
                    logger.info("Vous ne pouvez pas descendre plus bas");
                    System.out.println("Vous ne pouvez pas descendre plus bas.");
                    continue;
                }
            } else if (choix.equals("q")) {
                if (cartee.y > 0) {
                    logger.info("Déplacement du joueur vers la gauche");
                    newY -= 1;
                } else {
                    logger.info("Vous ne pouvez pas aller plus à gauche");
                    System.out.println("Vous ne pouvez pas aller plus à gauche.");
                    continue;
                }
            } else if (choix.equals("d")) {
                if (cartee.y < cartee.map[0].length - 1) {
                    logger.info("Déplacement du joueur vers la droite");
                    newY += 1;
                } else {
                    logger.info("Vous ne pouvez pas aller plus à droite");
                    System.out.println("Vous ne pouvez pas aller plus à droite.");
                    continue;
                }
            } else if (choix.equals("2")) {
                logger.info("Vous avez quitté la partie");
                System.out.println("Vous avez quitté la partie");
                break;
            } else {
                logger.info("Choix invalide");
                System.out.println("Choix invalide");
                continue;
            }

            boolean combat = false;
            if (cartee.map[newX][newY] == 'E') {
                combat = true;
            }

            boolean objet = false;
            if (cartee.map[newX][newY] == 'O') {
                objet = true;
            }

            boolean combatmulti = false;
            if (cartee.map[newX][newY] == 'C') {
                combatmulti = true;
            }

            // Déplacement du joueur
            cartee.deplacerHero(newX, newY);
            System.out.println("");

            if (objet) {
                objet(a, cartee, newX, newY);
            }

            if (combat) {
                int random = (int) (Math.random() * 3);
                if (random == 0) {
                    random = 1;
                }
                logger.info("Vous avez rencontré " + random + " ennemi(s)");
                System.out.println("Vous avez rencontré " + random + " ennemi(s)");
                for (int i = 0; i < random; i++) {
                    int random2 = (int) (Math.random() * 4);
                    if (random2 == 0) {
                        Gangster b = new Gangster();
                        logger.info("L'ennemi n" + (i + 1) + " est un " + b.getClass().getSimpleName());
                        System.out.println("L'ennemi n" + (i + 1) + " est un " + b.getClass().getSimpleName());
                        combattre(a, b, cartee, newX, newY);
                    } else if (random2 == 1) {
                        Brigand b = new Brigand();
                        logger.info("L'ennemi n" + (i + 1) + " est un " + b.getClass().getSimpleName());
                        System.out.println("L'ennemi n" + (i + 1) + " est un " + b.getClass().getSimpleName());
                        combattre(a, b, cartee, newX, newY);
                    } else if (random2 == 2) {
                        Catcheur b = new Catcheur();
                        logger.info("L'ennemi n" + (i + 1) + " est un " + b.getClass().getSimpleName());
                        System.out.println("L'ennemi n" + (i + 1) + " est un " + b.getClass().getSimpleName());
                        combattre(a, b, cartee, newX, newY);
                    } else {
                        Monstre b = new Monstre();
                        logger.info("L'ennemi n" + (i + 1) + " est un " + b.getClass().getSimpleName());
                        System.out.println("L'ennemi n" + (i + 1) + " est un " + b.getClass().getSimpleName());
                        combattre(a, b, cartee, newX, newY);
                    }
                }

            }

            if (combatmulti) {
                int random1 = 2;
                logger.info("Vous avez rencontré " + random1 + " ennemi(s)");
                System.out.println("Vous avez rencontré " + random1 + " ennemi(s)");
                Personnage temp1 = new Brigand();
                Personnage temp2 = new Monstre();
                combatmulti(a, temp1, temp2, cartee, newX, newY);
            }

            cartee.afficherCarte();
        }
    }
}