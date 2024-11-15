package com.example.definition;

public class Brigand extends Personnage {
    int chance = 0;
    int nbrattaque = 1;
    String arme = "Dague";

    public Brigand() {
        super(100, 10, 5, 0, 1, "Dague");
        this.chance = 0;                     // Valeur par défaut pour chance
        this.arme = "Dague";                  // Valeur par défaut pour arme
        this.nbrattaque = 1;      // Calcul d'une valeur aléatoire pour nbrattaque
    }

    public String toString() {
        return "Brigand [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance + ", nbrattaque=" + nbrattaque + ", arme=" + arme + "]";
    }
    
}
