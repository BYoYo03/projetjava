package com.example.definition.DefEnnemies;

import com.example.definition.TypesPerso.Ennemies;


public class Catcheur extends Ennemies {
    public Catcheur() {
        super();
        this.setVie(200);
        this.setAttaque(6);
        this.setArme("Chaise");
    }

    public String toString() {
        return "Catcheur [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance + ", arme="
                + arme + "]";
    }

}
