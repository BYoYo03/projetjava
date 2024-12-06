package com.example.definition.DefHeros;

// importation de l'outil Logger pour les logs
import java.util.logging.Logger;
// importation des classes 
import com.example.definition.Jeu;
import com.example.definition.TypesPerso.Heros;
import com.example.definition.TypesPerso.Personnage;

// Classe Chevalier qui hérite de la classe Heros et implémente l'interface Capacitespeciale
public class Chevalier extends Heros implements Capacitespeciale {
    // Déclaration des attributs de la classe Chevalier
    String capacite = "Matrix";
    int nbrcapacite = 1;

    // Constructeur de la classe Chevalier
    public Chevalier() {
        super();
        this.setAttaque(10);
        this.setArme("Lance");
    }

    // Méthode toString qui permet d'afficher les informations de l'objet Chevalier
    public String toString() {
        return "Chevalier [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance
                + ", arme=" + arme + "]";
    }

    // Getters et Setters
    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    public int getNbrcapacite() {
        return nbrcapacite;
    }

    public void setNbrcapacite(int nbrcapacite) {
        this.nbrcapacite = nbrcapacite;
    }

    // variable de classe pour les logs
    private static final Logger logger = Logger.getLogger(Jeu.class.getName());

    // Méthode utiliserCapacite qui permet d'utiliser la capacité spéciale du
    // Chevalier
    @Override
    public void utiliserCapacite(Personnage cible) {
        // Logique de la capacité spéciale "Matrix", il equive l'attaque de la cible et
        // attaque en retour 2x
        if (nbrcapacite > 0) {
            nbrcapacite--; // Réduit le nombre d'utilisations de la capacité
            // Attaque de la cible en infligeant 2x les dégâts
            int vie2 = cible.getVie() - ((attaque - cible.getDefense()) * 2);
            cible.setVie(vie2);
            logger.info("Vous avez utilisé 'Matrix', vous avez attaqué l'ennemi en esquivant son attaque 2x!");
            System.out.println("Vous avez utilisé 'Matrix', vous avez attaqué l'ennemi en esquivant son attaque 2x!");
            logger.info("Dégâts infligés : " + ((attaque - cible.getDefense()) * 2));
            System.out.println("Dégâts infligés : " + ((attaque - cible.getDefense()) * 2));
            logger.info(cible.getClass().getSimpleName() + " a maintenant " + cible.getVie() + " points de vie.");
            System.out
                    .println(cible.getClass().getSimpleName() + " a maintenant " + cible.getVie() + " points de vie.");
        } else {
            System.out.println("Vous n'avez plus de capacité spéciale !");
        }
    }

    // Méthode rechargerCapacite qui permet de recharger la capacité spéciale du
    // Chevalier
    public void rechargerCapacite() {
        nbrcapacite = 1;
        logger.info("Vous avez rechargé votre capacité spéciale !");
        System.out.println("Vous avez rechargé votre capacité spéciale !");
    }

}
