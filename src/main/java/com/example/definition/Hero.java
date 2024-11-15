package com.example.definition;


public class Hero extends Personnage {
    int chance = 1;
    /*private int Random(int i, int j) {
        return (int) (Math.random() * (j - i + 1) + i);
    }
     */
    String arme = "Epée";

    public Hero() {
        super(100, 10, 5, 1, "Epée");
        this.chance = 1;                     // Valeur par défaut pour chance
        this.arme = "Epée";                  // Valeur par défaut pour arme
    }

    public String toString() {
        return "Hero [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance  + ", arme=" + arme + "]";

    



    }

    
}
