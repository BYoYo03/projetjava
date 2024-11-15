package com.example.definition;

import java.util.Random;

public class Personnage {
    int vie;
    int attaque;
    int defense;
    int chance;
    String arme;

    public Personnage(int vie, int attaque, int defense, int chance, String arme) {
        this.vie = vie;
        this.attaque = attaque;
        this.defense = defense;
        this.chance = chance;
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


    public String getArme() {
        return arme;
    }

    public void setArme(String arme) {
        this.arme = arme;
    }

    private void attaque(Personnage a) {
        if (this.vie <= 0) {
            System.out.println(this.getClass().getSimpleName() + " est mort");
            return;
        }
        if (a.vie <= 0) {
            System.out.println(a.getClass().getSimpleName() + " est mort");
            return;
        }
        else { 
            int degat = this.attaque - a.defense;
            if (degat < 0) {
                degat = 0;
            }
            a.vie = a.vie - degat;
            System.out.println(this.getClass().getSimpleName() + " attaque " + a.getClass().getSimpleName() + " avec " + this.arme + " et inflige " + degat + " dégats");
        }

    }

    private int Random(int i, int j) {
        return (int) (Math.random() * (j - i + 1) + i);
    }

    
    public void attaquepremier(Personnage a) {
        if (this.vie <= 0) {
            System.out.println(this.getClass().getSimpleName() + " est mort");
            return;
        }
        if (a.vie <= 0) {
            System.out.println(a.getClass().getSimpleName() + " est mort");
            return;
        }
        else {
        int nbrattaque = Random(1, 5);
        if (this.chance > a.chance) {
            if (this.getClass().getSimpleName().equals("Hero")) {

                int compteur = 0;
                while (compteur < nbrattaque) {
                    
                    System.out.println("Le Hero attaque " + nbrattaque + " fois");
                    this.attaque(a);
                    if (a.vie <= 0) {
                        System.out.println(a.getClass().getSimpleName() + " est mort");
                        return;
                    }
                    else {
                        System.out.println(a.getClass().getSimpleName() + " a " + a.vie + " points de vie restant");
                        compteur++;
                    }
                    
                }
                if (a.vie <= 0) {
                    System.out.println(a.getClass().getSimpleName() + " est mort");
                    return;
                }
                else {
                    System.out.println("C'est au tour de " + a.getClass().getSimpleName());
                    a.attaque(this);
                    System.out.println(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                }
            }

            else {
                this.attaque(a);
                if (a.vie <= 0) {
                    System.out.println(a.getClass().getSimpleName() + " est mort");
                    return;
                }
                else {
                    System.out.println(a.getClass().getSimpleName() + " a " + a.vie + " points de vie restant");
                    System.out.println("C'est au tour de " + a.getClass().getSimpleName());
                    a.attaque(this);
                    System.out.println(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                }
        }
            
            
    }
}
}
}




    

