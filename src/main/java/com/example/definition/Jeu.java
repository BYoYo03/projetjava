package com.example.definition;

import java.nio.file.AtomicMoveNotSupportedException;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;
import javax.swing.BoundedRangeModel;


public class Jeu {
    public void commencer() {
        System.out.println("Le jeu commence");
    }
    char[][] map = {
        {'H', '.', '.', '.', 'E'},
        {'.', '.', '.', 'E', '.'},
        {'.', 'E', '.', '.', '.'},
        {'.', '.', '.', '.', 'E'},
        {'E', '.', '.', '.', '.'}
    };

    public void choixperso() {
        System.out.println("Choisissez votre personnage");
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Hero");
        System.out.println("3. Assassin");
        int choix = sc.nextInt();
        if (choix == 1) {
            Hero hero = new Hero();
            System.out.println(hero);
            debuterpartie(new Hero());
        } else if (choix == 2) {
            Assassin assassin = new Assassin();
            System.out.println(assassin);
        } else {
            System.out.println("Choix invalide");
        }
        



    }

    public void debuterpartie(Personnage a) {
        System.out.println("La partie commence");
        Brigand b = new Brigand();

        Carte cartee = new Carte(map, 0, 0);
        cartee.afficherCarte();
        Scanner sc = new Scanner(System.in);
        while (true) {
                    System.out.println("Tour du joueur");
                    System.out.println("z. Monter ");
                    System.out.println("q. Gauche ");
                    System.out.println("s. Descendre ");
                    System.out.println("d. Droite ");
                    System.out.println("2. Quitter");
                    String choix = sc.next();
    
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
    
            if (combat) {
                System.out.println("Vous avez rencontré un " + b.getClass().getSimpleName());
                System.out.println("Vous attaquez car vous êtes plus rapide");
                
                a.attaquepremier(b);
                while (a.vie > 0 && b.vie > 0) {
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("A. Attaquer");
                    System.out.println("B. Attaque spéciale");
                    System.out.println("C. Fuir");
                    String choix1 = sc1.next();
                    if (choix1.equals("A")) {
                        a.attaquepremier(b);
                    } else if (choix1.equals("B")) {
                        System.out.println("Vous avez utilisé votre attaque spéciale");
                    } else if (choix1.equals("C")) {
                        System.out.println("Vous avez fui");
                        break;
                    } else {
                        System.out.println("Choix invalide");
                    }
                }
                if (b.vie <= 0) {
                    System.out.println("Vous avez gagné");
                    cartee.map[cartee.x][cartee.y] = 'H';
                } else if (a.vie <= 0) {
                    System.out.println("Vous avez perdu");
                    break;
                } else {
                    cartee.map[cartee.x][cartee.y] = 'X';
                }
            }
    
            cartee.afficherCarte();
        }
    }
}