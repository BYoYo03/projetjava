package com.example.definition;

public class Chevalier extends Heros {
    
    public Chevalier() {
        super();
        this.setAttaque(attaque + 10);
        this.setArme("Poignard");
    }

    public String toString() {
        return "Assassin [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance + ", arme=" + arme + "]";
    }
    
}
