package com.example.definition;

public class Chevalier extends Heros implements Capacitespeciale {
    String capacite = "Matrix";
    int nbrcapacite = 1;

    public Chevalier() {
        super();
        this.setAttaque(attaque + 10);
        this.setArme("Lance");
    }

    public String toString() {
        return "Chevalier [vie=" + vie + ", attaque=" + attaque + ", defense=" + defense + ", chance=" + chance
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
        // Logique de la capacité spéciale "Matrix", il equive l'attaque de la cible et
        // attaque en retour ou inverse il attaque et esquive
        if (nbrcapacite > 0) {
            nbrcapacite--; // Réduit le nombre d'utilisations de la capacité
            cible.vie = cible.vie - ((attaque - cible.defense) * 2); // Attaque l'ennemi
            System.out.println("Vous avez utilisé 'Matrix', vous avez attaqué l'ennemi en esquivant son attaque 2x!");
            System.out.println("Dégâts infligés : " + ((attaque - cible.defense) * 2));
            System.out.println(cible.getClass().getSimpleName() + " a maintenant " + cible.vie + " points de vie.");
        } else {
            System.out.println("Vous n'avez plus de capacité spéciale !");
        }
    }

}
