package com.example.definition.DefHeros;
import java.util.logging.Logger;

import com.example.definition.Jeu;
import com.example.definition.TypesPerso.Heros;
import com.example.definition.TypesPerso.Personnage;

public class Magicien extends Heros implements Capacitespeciale {
    public String capacite = "soin";
    public int nbrcapacite = 1;

    public Magicien() {
        super();
        this.attaque = 9;
        this.setArme("Baton");
    }

    public String toString() {
        return "Magicien [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance
                + ", arme=" + arme + "," + " capacite=" + capacite + " nbrcapacite=" + nbrcapacite + "]";
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
        // Logique de la capacité spéciale "Soin"
        if (nbrcapacite > 0) {
            nbrcapacite--; // Réduit le nombre d'utilisations de la capacité
            if (this.vie == 50) {
                logger.info("Vous avez gaché votre capacité spéciale, vous avez déjà tous vos points de vie !");
                System.out.println("Vous avez gaché votre capacité spéciale, vous avez déjà tous vos points de vie !");
                return;
            }
            this.vie = 50; // Soigne le magicien
            logger.info("Vous avez utilisé 'Soin' et vous avez récupéré tous vos points de vie !");
            System.out.println("Vous avez utilisé 'Soin' et vous avez récupéré tous vos points de vie !");
            logger.info("Vous avez maintenant " + this.vie + " points de vie.");
            System.out.println("Vous avez maintenant " + this.vie + " points de vie.");
        } else {
            logger.info("Vous n'avez plus de capacité spéciale !");
            System.out.println("Vous n'avez plus de capacité spéciale !");
        }
    }

    public void rechargerCapacite() {
        nbrcapacite = 1;
        logger.info("Vous avez rechargé votre capacité spéciale !");
        System.out.println("Vous avez rechargé votre capacité spéciale !");
    }

    public void changerCapacite(){
        //
    }

}
