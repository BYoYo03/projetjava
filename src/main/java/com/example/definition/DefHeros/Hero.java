package com.example.definition.DefHeros;
import java.util.logging.Logger;

import com.example.definition.Jeu;
import com.example.definition.TypesPerso.Heros;
import com.example.definition.TypesPerso.Personnage;

public class Hero extends Heros implements Capacitespeciale {
    public String capacite = "one shot";
    public int nbrcapacite = 1;
    public boolean changement = false;
    

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
            cible.setVie(0); // Tue l'ennemi
            logger.info("Vous avez utilisé 'One Shot' et tué l'ennemi !");
            System.out.println("Vous avez utilisé 'One Shot' et tué l'ennemi !");
        } else {
            logger.info("Vous n'avez plus de capacité spéciale !");
            System.out.println("Vous n'avez plus de capacité spéciale !");
        }
    }

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

    public void changerCapacite() {
        changement = true;
    }
}