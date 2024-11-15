package com.example.definition;

import java.util.Scanner;

import javax.swing.DefaultButtonModel;

import com.example.definition.Personnage;
import com.example.definition.Hero;
import com.example.definition.Assassin;


public class Jeu {
    public void commencer() {
        System.out.println("Le jeu commence");
    }

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

        while (true) {
            Brigand b = new Brigand();
            System.out.println("Tour du joueur");
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Avancer ");
            System.out.println("2. Quitter");
            int choix = sc.nextInt();
            if (choix == 1) {
                System.out.println("Vous avez rencontré un " + b.getClass().getSimpleName());
                System.out.println("Vous attaquez car vous êtes plus rapide");
                a.attaquepremier(b);

                if (b.vie <= 0) {
                    System.out.println("Vous avez gagné");
                    break;
                }
                
                if (a.vie <= 0) {
                    System.out.println("Vous avez perdu");
                    break;
                }
                
            } else if (choix == 2) {
                System.out.println("Vous avez quitté la partie");
                break;
            } else {
                System.out.println("Choix invalide");
            }
        }

    }

    
}
