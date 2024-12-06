package com.example.definition.DefEnnemies;

// importation de la classe Ennemies
import com.example.definition.TypesPerso.Ennemies;

// Classe Monstre qui hérite de la classe Ennemies
public class Monstre extends Ennemies {
    // Constructeur de la classe Monstre
    public Monstre() {
        super();
    }

    // Méthode toString qui permet d'afficher les informations de l'objet Monstre
    public String toString() {
        return "Monstre [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance
                + ", arme="
                + arme + "]";
    }

}
