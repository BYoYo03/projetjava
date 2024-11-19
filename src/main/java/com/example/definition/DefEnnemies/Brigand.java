package com.example.definition.DefEnnemies;

import com.example.definition.TypesPerso.Ennemies;



public class Brigand extends Ennemies {

    public Brigand() {
        super();
        this.setArme("Poings");
    }

    public String toString() {
        return "Brigand [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance + ", arme="
                + arme + "]";
    }

}
