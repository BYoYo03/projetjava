package com.example.definition;

import java.util.Scanner;



public class Jeu {
    
    public void commencer() {
        System.out.println("Le jeu commence");
    }

    char[][] map = {
        {'H', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.'},
        {'.', 'E', '.', '.', '.'},
        {'.', '.', '.', '.', 'E'},
        {'.', '.', '.', '.', '.'}
    };

    public void choixperso() {
        System.out.println("Choisissez votre personnage");
        Scanner sc = new Scanner(System.in);
        System.out.println("H. Hero");
        System.out.println("C. Chevalier");
        System.out.println("M. Magicien");
        String choix = sc.next();
        if (choix.equals("H")) {
            Hero hero = new Hero();
            System.out.println(hero);
            debuterpartie(new Hero());
        } else if (choix.equals("C")) {
            Chevalier chevalier = new Chevalier();
            System.out.println(chevalier);
            debuterpartie(new Chevalier());
        } else if (choix.equals("M")) {
            Magicien magicien = new Magicien();
            System.out.println(magicien);
            debuterpartie(new Magicien());
        } else {
            System.out.println("Choix invalide");
            choixperso();
        }

    }

    public void findepartie() {
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
            System.out.println("Il n'y a plus d'ennemis");
            System.out.println("Vous avez gagné");
            findepartie();
        }
    }

    public void combattre(Personnage a, Personnage b, Carte cartee, int x, int y) {
        
        System.out.println("");

        System.out.println("Specs de l'ennemi : " + b);
                            
        while (a.vie > 0 && b.vie > 0) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("");
            System.out.println("A. Attaquer");
            System.out.println("B. Capacité spéciale");
            System.out.println("C. Fuir");
            System.out.println("");
            String choix1 = sc1.next();
            
            if (choix1.equals("A")) {
                a.attaquepremier(b);
            } else if (choix1.equals("B")) {
                if (a instanceof Capacitespeciale) {
                    ((Capacitespeciale) a).utiliserCapacite(b);  // Utilisation de la capacité spéciale
                } else {
                    System.out.println("Ce personnage n'a pas de capacité spéciale.");
                }
            } else if (choix1.equals("C")) {
                System.out.println("Tu ne peux pas fuir");
            } else {
                System.out.println("Choix invalide");
            }
        }
        
        if (b.vie <= 0) {
            System.out.println("Vous avez gagné");
            System.out.println("");
            cartee.map[cartee.x][cartee.y] = 'H';
        } else if (a.vie <= 0) {
            System.out.println("Vous avez perdu");
            findepartie();
        } else {
            cartee.map[cartee.x][cartee.y] = 'X';
        }
    }
    
    
    public void debuterpartie(Personnage a) {
        System.out.println("La partie commence");
        

        Carte cartee = new Carte(map, 0, 0);
        cartee.afficherCarte();
        Scanner sc = new Scanner(System.in);
        while (true) {

            // Vérification de la présence d'un ennemi sur la carte et fin de partie si aucun ennemi n'est trouvé
             verifennemie(cartee);

            // Choix du joueur pour se déplacer
                    System.out.println("");
                    System.out.println("Votre "+ a.getClass().getSimpleName() + " a " + a.vie + " points de vie");
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
                    newX -= 1;
                } else {
                    System.out.println("Vous ne pouvez pas monter plus haut.");
                    continue;
                }
            } else if (choix.equals("s")) {
                if (cartee.x < cartee.map.length - 1) {
                    newX += 1;
                } else {
                    System.out.println("Vous ne pouvez pas descendre plus bas.");
                    continue;
                }
            } else if (choix.equals("q")) {
                if (cartee.y > 0) {
                    newY -= 1;
                } else {
                    System.out.println("Vous ne pouvez pas aller plus à gauche.");
                    continue;
                }
            } else if (choix.equals("d")) {
                if (cartee.y < cartee.map[0].length - 1) {
                    newY += 1;
                } else {
                    System.out.println("Vous ne pouvez pas aller plus à droite.");
                    continue;
                }
            } else if (choix.equals("2")) {
                System.out.println("Vous avez quitté la partie");
                break;
            } else {
                System.out.println("Choix invalide");
                continue;
            }
    
            boolean combat = false;
            if (cartee.map[newX][newY] == 'E') {
                combat = true;
            }
            
            cartee.deplacerHero(newX, newY);
            System.out.println("");
    
            if (combat) {
                int random = (int) (Math.random() * 3);
                if (random == 0) {
                    random = 1;
                }
                System.out.println("Vous avez rencontré " + random +" ennemi(s)");
                for (int i = 0; i < random; i++) {
                    int random2 = (int) (Math.random() * 4);
                    if (random2 == 0) {
                        Gangster b = new Gangster();
                        System.out.println("L'ennemi n" + (i+1) + " est un " + b.getClass().getSimpleName());
                        combattre(a, b, cartee, newX, newY);
                    } else if (random2 == 1) {
                        Brigand b = new Brigand();
                        System.out.println("L'ennemi n" + (i+1) + " est un " + b.getClass().getSimpleName());
                        combattre(a, b, cartee, newX, newY);
                    } else if (random2 == 2) {
                        Catcheur b = new Catcheur();
                        System.out.println("L'ennemi n" + (i+1) + " est un " + b.getClass().getSimpleName());
                        combattre(a, b, cartee, newX, newY);
                    } else {
                        Monstre b = new Monstre();
                        System.out.println("L'ennemi n" + (i+1) + " est un " + b.getClass().getSimpleName());
                        combattre(a, b, cartee, newX, newY);
                    }
                    
                }
               
            }
    
            cartee.afficherCarte();
        }
    }
}