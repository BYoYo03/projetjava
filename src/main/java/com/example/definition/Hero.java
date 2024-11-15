package com.example.definition;


public class Hero extends Gentils {


    public Hero() {
        super();
        this.setArme("Epee");
    }

    public String toString() {
        return "Hero [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance  + ", arme=" + arme + "]";
    }

    
}
