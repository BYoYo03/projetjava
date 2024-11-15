package com.example.definition;

public class Gangster extends Personnage{
    int chance = 2;
    String arme = "Pistolet";

    public Gangster() {
        super(50, 7, 3, 2, "Pistolet");
        this.chance = 2;
        this.arme = "Pistolet";
    }


    public String toString() {
        return "Gangster [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance + ", arme=" + arme + "]";
    }


    
}
