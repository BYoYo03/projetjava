package com.example.definition;

public class Gangster extends Personnage{
    int chance = 2;
    int nbrattaque = 1;
    String arme = "Pistolet";

    public Gangster() {
        super(50, 7, 3, 2, 1, "Pistolet");
        this.chance = 2;
        this.arme = "Pistolet";
        this.nbrattaque = 1;
    }


    public String toString() {
        return "Gangster [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance + ", nbrattaque=" + nbrattaque + ", arme=" + arme + "]";
    }


    
}
