package com.example.definition.DefHeros;

// importation de l'outil Logger
import java.util.logging.Logger;

// importation des classes Jeu, Heros et Personnage
import com.example.definition.Jeu;
import com.example.definition.TypesPerso.Heros;
import com.example.definition.TypesPerso.Personnage;

// Classe Hero qui hérite de la classe Heros et implémente l'interface Capacitespeciale
public class Hero extends Heros implements Capacitespeciale {
    // Déclaration des attributs de la classe Hero
    public String capacite = "one shot";
    public int nbrcapacite = 1;
    public boolean changement = false;

    // Constructeur de la classe Hero
    public Hero() {
        super();
        this.setArme("Epee");

    }

    // Méthode toString qui permet d'afficher les informations de l'objet Hero
    public String toString() {
        return "Hero [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance + ", arme="
                + arme + "," + " capacite=" + capacite + " nbrcapacite=" + nbrcapacite + "]";
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

    // Méthode utiliserCapacite qui permet d'utiliser la capacité spéciale du Hero
    @Override
    public void utiliserCapacite(Personnage cible) {
        // Logique de la capacité spéciale "One Shot", si le nombre d'utilisation est
        // supérieur à 0, alors on tue l'ennemi
        if (nbrcapacite > 0) {
            nbrcapacite--; // Réduit le nombre d'utilisations de la capacité
            cible.setVie(0); // Tue l'ennemi
            logger.info("Vous avez utilisé 'One Shot' et tué l'ennemi !");
            System.out.println("Vous avez utilisé 'One Shot' et tué l'ennemi !");
        } else {
            logger.info("Vous n'avez plus de capacité spéciale !");
            System.out.println("Vous n'avez plus de capacité spéciale !");
        }
    }

    // Méthode rechargerCapacite qui permet de recharger la capacité spéciale du
    // Hero
    public void rechargerCapacite() {
        if (nbrcapacite == 1) {
            logger.info("Je voulais rehcarcger ta capacité spéciale mais tu l'as déjà !");
            System.out.println("Je voulais rehcarcger ta capacité spéciale mais tu l'as déjà !");
            return;
        }
        nbrcapacite = 1;
        logger.info("Vous avez rechargé votre capacité spéciale !");
        System.out.println("Vous avez rechargé votre capacité spéciale !");
    }

}