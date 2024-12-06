package com.example.definition.TypesPerso;

// Classe Heros qui hérite de la classe Personnage
public class Heros extends Personnage {
    // Constructeur de la classe Heros
    public Heros() {
        super(50, 10, 5, 1, "Baton");
    }

    // Méthode toString qui permet d'afficher les informations de l'objet Heros
    public String toString() {
        return "Gentil [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance + ", arme="
                + arme + "]";
    }

}
