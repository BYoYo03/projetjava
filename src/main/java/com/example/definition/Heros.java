package com.example.definition;

public class Heros extends Personnage{

    public Heros() {
        super(50, 10, 5, 1, "Baton"); 
    }

    public String toString() {
        return "Gentils [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance + ", arme=" + arme + "]";
    }

}
