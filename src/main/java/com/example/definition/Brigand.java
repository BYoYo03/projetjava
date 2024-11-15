package com.example.definition;

public class Brigand extends Ennemies {
    
    public Brigand() {
        super();
        this.setChance(1); // Utilise le setter pour définir chance à 1
        this.setArme("Poings");
    }

    public String toString() {
        return "Brigand [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance  + ", arme=" + arme + "]";
    }
    
}
