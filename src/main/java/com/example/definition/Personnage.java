package com.example.definition;


public class Personnage {
    int vie;
    int attaque;
    int defense;
    int chance;
    int nbrattaque;
    String arme;

    public Personnage(int vie, int attaque, int defense, int chance, int nbrattaque, String arme) {
        this.vie = vie;
        this.attaque = attaque;
        this.defense = defense;
        this.chance = chance;
        this.nbrattaque = nbrattaque;
        this.arme = arme;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getAttaque() {
        return attaque;
    }

    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public int getNbrattaque() {
        return nbrattaque;
    }

    public void setNbrattaque(int nbrattaque) {
        this.nbrattaque = nbrattaque;
    }

    public String getArme() {
        return arme;
    }

    public void setArme(String arme) {
        this.arme = arme;
    }

    private void attaque(Personnage a) {
        int degat = this.attaque - a.defense;
        if (degat < 0) {
            degat = 0;
        }
        a.vie = a.vie - degat;
        System.out.println(this.getClass().getSimpleName() + " attaque " + a.getClass().getSimpleName() + " avec " + this.arme + " et inflige " + degat + " dégats");
    }
    
    public void attaquepremier(Personnage a) {
        if (this.chance > a.chance) {
            if (this.getClass().getSimpleName() == "Hero" ) {
                System.out.println("test1");
                int compteur = 0;
                while (compteur < this.nbrattaque) {
                    this.attaque(a);
                    System.out.println(a.getClass().getSimpleName() + " a " + a.vie + " points de vie restant");
                    compteur++;
                }
                System.out.println("C'est au tour de " + a.getClass().getSimpleName());
                a.attaque(this);
                System.out.println(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
            }
            else {
                System.out.println(this.getClass().getSimpleName() + " ici");
                this.attaque(a);
                System.out.println("test");
                System.out.println(a.getClass().getSimpleName() + " a " + a.vie + " points de vie restant");
                System.out.println("C'est au tour de " + a.getClass().getSimpleName());
                a.attaque(this);
                System.out.println(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
            }

            } 
            
            else {
            a.attaque(this);
            System.out.println(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
            System.out.println("C'est au tour de " + this.getClass().getSimpleName());
            
            if (this.getClass().getSimpleName() == "Hero") {
                int compteur = 0;
                while (compteur < this.nbrattaque) {
                    this.attaque(a);
                    System.out.println(a.getClass().getSimpleName() + " a " + a.vie + " points de vie restant");
                    compteur++;
                }
            }
            else {
                this.attaque(a);
                System.out.println(a.getClass().getSimpleName() + " a " + a.vie + " points de vie restant");
            }

        }
    }




    
}
