package com.example.definition;

// Classe Carte
public class Carte {
    // Attributs de la classe Carte
    public int x = 0;
    public int y = 0;
    public char[][] map;

    // Constructeur de la classe Carte
    Carte(char[][] map, int x, int y) {
        this.map = map;
        this.x = x;
        this.y = y;
    }

    // Méthode afficherCarte qui permet d'afficher la carte
    public void afficherCarte() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Méthode deplacerHero qui permet de mettre à jour la carte après le
    // déplacement du héros
    public void deplacerHero(int newX, int newY) {
        map[x][y] = '.';
        x = newX;
        y = newY;
        if (map[x][y] == 'E') {
            map[x][y] = 'X';
        } else {
            map[x][y] = 'H';
        }
    }
}
