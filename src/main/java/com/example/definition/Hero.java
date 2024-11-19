package com.example.definition;
import java.util.logging.Logger;

public class Hero extends Heros implements Capacitespeciale {
    public String capacite = "one shot";
    public int nbrcapacite = 1;

    public Hero() {
        super();
        this.setArme("Epee");
    }

    public String toString() {
        return "Hero [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance + ", arme="
                + arme + "," + " capacite=" + capacite + " nbrcapacite=" + nbrcapacite + "]";
    }

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

    private static final Logger logger = Logger.getLogger(Jeu.class.getName());

    @Override
    public void utiliserCapacite(Personnage cible) {
        // Logique de la capacité spéciale "One Shot"
        if (nbrcapacite > 0) {
            nbrcapacite--; // Réduit le nombre d'utilisations de la capacité
            cible.vie = 0; // Tué instantanément
            logger.info("Vous avez utilisé 'One Shot' et tué l'ennemi !");
            System.out.println("Vous avez utilisé 'One Shot' et tué l'ennemi !");
        } else {
            logger.info("Vous n'avez plus de capacité spéciale !");
            System.out.println("Vous n'avez plus de capacité spéciale !");
        }
    }

}
