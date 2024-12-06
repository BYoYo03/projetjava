package com.example;

import com.example.definition.Jeu;

public class App {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Bienvenue dans le jeu de combat de bahir et merwane");
        System.out.println("");
        // Création d'un objet jeu
        Jeu jeu = new Jeu();
        // Appel des méthodes du jeu
        jeu.commencer();
        jeu.choixcarte();
    }

}
