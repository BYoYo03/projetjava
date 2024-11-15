package com.example.definition;

public class Assassin extends Personnage{
    int chance = 1;
    String arme = "Poignard";

    public Assassin() {
        super(75, 8, 4, 1, "Poignard");
        this.chance = 1;
        this.arme = "Poignard";
    }

    public String toString() {
        return "Assassin [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance + ", arme=" + arme + "]";
    }
    
}
