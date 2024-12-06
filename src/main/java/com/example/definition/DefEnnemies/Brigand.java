package com.example.definition.DefEnnemies;

// importation de la classe Ennemies 
import com.example.definition.TypesPerso.Ennemies;

// Classe Brigand qui hérite de la classe Ennemies
public class Brigand extends Ennemies {
    // Constructeur de la classe Brigand
    public Brigand() {
        super();
        this.setArme("Poings");
    }

    // Méthode toString qui permet d'afficher les informations de l'objet Brigand
    public String toString() {
        return "Brigand [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance
                + ", arme="
                + arme + "]";
    }

}
