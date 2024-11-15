package com.example.definition;

public class Brigand extends Personnage {
    int chance = 0;
    String arme = "Dague";

    public Brigand() {
        super(100, 10, 5, 0, "Dague");
        this.chance = 0;                     // Valeur par défaut pour chance
        this.arme = "Dague";                  // Valeur par défaut pour armes 
    }

    public String toString() {
        return "Brigand [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance  + ", arme=" + arme + "]";
    }
    
}
