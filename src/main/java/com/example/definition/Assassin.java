package com.example.definition;

public class Assassin extends Gentils {
    
    public Assassin() {
        super();
        this.setArme("Poignard");
    }

    public String toString() {
        return "Assassin [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance + ", arme=" + arme + "]";
    }
    
}
