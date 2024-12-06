package com.example.definition.DefHeros;

// importation de l'outil Logger
import java.util.logging.Logger;

// importation des classes 
import com.example.definition.Jeu;
import com.example.definition.TypesPerso.Heros;
import com.example.definition.TypesPerso.Personnage;

// Classe Magicien qui hérite de la classe Heros et implémente l'interface Capacitespeciale
public class Magicien extends Heros implements Capacitespeciale {
    // Déclaration des attributs de la classe Magicien
    public String capacite = "soin";
    public int nbrcapacite = 1;

    // Constructeur de la classe Magicien
    public Magicien() {
        super();
        this.attaque = 9;
        this.setArme("Baton");
    }

    // Méthode toString qui permet d'afficher les informations de l'objet Magicien
    public String toString() {
        return "Magicien [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance
                + ", arme=" + arme + "," + " capacite=" + capacite + " nbrcapacite=" + nbrcapacite + "]";
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
    // Magicien
    @Override
    public void utiliserCapacite(Personnage cible) {
        // Logique de la capacité spéciale "Soin", si le nombre d'utilisation est
        // supérieur à 0, alors on soigne le magicien
        if (nbrcapacite > 0) {
            nbrcapacite--; // Réduit le nombre d'utilisations de la capacité
            if (this.vie == 50) {
                logger.info("Vous avez gaché votre capacité spéciale, vous avez déjà tous vos points de vie !");
                System.out.println("Vous avez gaché votre capacité spéciale, vous avez déjà tous vos points de vie !");
                return;
            }
            this.vie = 50; // remet les points de vie du magicien à 50, soit la valeur maximale
            logger.info("Vous avez utilisé 'Soin' et vous avez récupéré tous vos points de vie !");
            System.out.println("Vous avez utilisé 'Soin' et vous avez récupéré tous vos points de vie !");
            logger.info("Vous avez maintenant " + this.vie + " points de vie.");
            System.out.println("Vous avez maintenant " + this.vie + " points de vie.");
        } else {
            logger.info("Vous n'avez plus de capacité spéciale !");
            System.out.println("Vous n'avez plus de capacité spéciale !");
        }
    }

    // Méthode rechargerCapacite qui permet de recharger la capacité spéciale du
    // Magicien
    public void rechargerCapacite() {
        nbrcapacite = 1;
        logger.info("Vous avez rechargé votre capacité spéciale !");
        System.out.println("Vous avez rechargé votre capacité spéciale !");
    }

}
