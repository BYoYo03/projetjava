package com.example.definition.DefEnnemies;

// importation de la classe Ennemies
import com.example.definition.TypesPerso.Ennemies;

// Classe Gangster qui hérite de la classe Ennemies
public class Gangster extends Ennemies {
    // Constructeur de la classe Gangster
    public Gangster() {
        super();
        this.setChance(2); // Utilise le setter pour définir chance à 2
        this.setArme("Pistolet");
    }

    // Méthode toString qui permet d'afficher les informations de l'objet Gangster
    public String toString() {
        return "Gangster [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance
                + ", arme="
                + arme + "]";
    }

}
