package com.example.definition;

public class Gangster extends Ennemies {

    public Gangster() {
        super();
        this.setChance(2); // Utilise le setter pour définir chance à 2
        this.setArme("Pistolet");
    }

    public String toString() {
        return "Gangster [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance
                + ", arme=" + arme + "]";
    }

}
