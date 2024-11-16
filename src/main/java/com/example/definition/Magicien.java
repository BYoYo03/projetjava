package com.example.definition;

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

    @Override
    public void utiliserCapacite(Personnage cible) {
        // Logique de la capacité spéciale "Soin"
        if (nbrcapacite > 0) {
            nbrcapacite--; // Réduit le nombre d'utilisations de la capacité
            if (this.vie == 50) {
                System.out.println("Vous avez gaché votre capacité spéciale, vous avez déjà tous vos points de vie !");
                return;
            }
            this.vie = 50; // Soigne le magicien
            System.out.println("Vous avez utilisé 'Soin' et vous avez récupéré tous vos points de vie !");
            System.out.println("Vous avez maintenant " + this.vie + " points de vie.");
        } else {
            System.out.println("Vous n'avez plus de capacité spéciale !");
        }
    }

}
