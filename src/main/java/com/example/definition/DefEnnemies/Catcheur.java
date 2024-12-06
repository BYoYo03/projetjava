package com.example.definition.DefEnnemies;

// importation de la classe Ennemies
import com.example.definition.TypesPerso.Ennemies;

// Classe Catcheur qui hérite de la classe Ennemies
public class Catcheur extends Ennemies {
    // Constructeur de la classe Catcheur
    public Catcheur() {
        super();
        this.setVie(200);
        this.setAttaque(6);
        this.setArme("Chaise");
    }

    // Méthode toString qui permet d'afficher les informations de l'objet Catcheur
    public String toString() {
        return "Catcheur [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance
                + ", arme="
                + arme + "]";
    }

}
