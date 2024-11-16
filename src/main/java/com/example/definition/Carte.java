package com.example.definition;

public class Carte {
    int x = 0;
    int y = 0;
    char[][] map;

    Carte(char[][] map, int x, int y) {
        this.map = map;
        this.x = x;
        this.y = y;
    }

    public void afficherCarte() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

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
