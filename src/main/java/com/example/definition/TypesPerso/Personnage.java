package com.example.definition.TypesPerso;

import java.util.logging.Logger;

import com.example.definition.Jeu;
import com.example.definition.DefHeros.Capacitespeciale;



public class Personnage {
    protected int vie;
    protected int attaque;
    protected int defense;
    protected int chance;
    protected String arme;
    protected boolean changement = false;
    protected boolean nbrchangement = false;


    private static final Logger logger = Logger.getLogger(Jeu.class.getName());

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


    public void setChangement(boolean changement) {
        this.changement = changement;
    }

    public boolean getChangement() {
        return changement;
    }

    public void setNbrchangement(boolean nbrchangement) {
        this.nbrchangement = nbrchangement;
    }

    public boolean getNbrchangement() {
        return nbrchangement;
    }

    public void changementattaquecapacite(Personnage changement, Personnage cible) {
        if (nbrchangement == true) {
            System.out.println("Le hero a déjà utilisé sa capacité spéciale");
            return;
        }
        if (changement instanceof Capacitespeciale) {
            // verifier si le hero a l'attribut changement en true
            ((Capacitespeciale) changement).utiliserCapacite(cible);
        }

    }


    public void attaquenbrhero(Personnage a) {

        int nbrattaque = Random(1, 5);
        int compteur = 0;
        System.out.println("Le Hero attaque " + nbrattaque + " fois");
        logger.info("Le Hero attaque " + nbrattaque + " fois");

        while (compteur < nbrattaque) {
            this.attaquehero(a);
            if (a.vie <= 0) {
                logger.info(a.getClass().getSimpleName() + " est mort");
                System.out.println(a.getClass().getSimpleName() + " est mort");
                return;
            } else {
                compteur++;
            }
        }

        int degatsfinal = this.attaque - a.defense;
        int degatstotaux = degatsfinal * nbrattaque;
        int e = this.attaque - a.defense;

        System.out.println("Le Hero attaque " + a.getClass().getSimpleName() + " avec " + this.arme + " et lui inflige "
                + degatstotaux + " points de dégats car ses degats moins la défense de l'ennemie (" + e
                + ") sont multipliés par " + nbrattaque);
        logger.info("Le Hero attaque " + a.getClass().getSimpleName() + " avec " + this.arme + " et lui inflige "
                + degatstotaux + " points de dégats car ses degats moins la défense de l'ennemie (" + e
                + ") sont multipliés par " + nbrattaque);
        System.out.println(a.getClass().getSimpleName() + " a " + a.vie + " points de vie restant");
        logger.info(a.getClass().getSimpleName() + " a " + a.vie + " points de vie restant");

        if (a.vie <= 0) {
            logger.info(a.getClass().getSimpleName() + " est mort");
            System.out.println(a.getClass().getSimpleName() + " est mort");
            return;
        }
    }

    private void attaquehero(Personnage a) {
        if (this.vie <= 0) {
            logger.info(this.getClass().getSimpleName() + " est mort");
            System.out.println(this.getClass().getSimpleName() + " est mort");
            return;
        }
        if (a.vie <= 0) {
            logger.info(a.getClass().getSimpleName() + " est mort");
            System.out.println(a.getClass().getSimpleName() + " est mort");
            return;
        } else {
            int degat = this.attaque - a.defense;
            if (degat < 0) {
                degat = 0;
            }
            a.vie = a.vie - degat;
        }

    }

    private void attaque(Personnage a) {
        if (this.vie <= 0) {
            logger.info(this.getClass().getSimpleName() + " est mort");
            System.out.println(this.getClass().getSimpleName() + " est mort");
            return;
        }
        if (a.vie <= 0) {
            logger.info(a.getClass().getSimpleName() + " est mort");
            System.out.println(a.getClass().getSimpleName() + " est mort");
            return;
        } else {
            int degat = this.attaque - a.defense;
            if (degat < 0) {
                degat = 0;
            }
            a.vie = a.vie - degat;
            logger.info(this.getClass().getSimpleName() + " attaque " + a.getClass().getSimpleName() + " avec "
                    + this.arme + " et lui inflige " + degat + " points de dégats");
            System.out.println(this.getClass().getSimpleName() + " attaque " + a.getClass().getSimpleName() + " avec "
                    + this.arme + " et lui inflige " + degat + " points de dégats");

        }

    }

    private int Random(int i, int j) {
        return (int) (Math.random() * (j - i + 1) + i);
    }

    public void attaquepremier(Personnage a) {
        if (this.vie <= 0) {
            logger.info(this.getClass().getSimpleName() + " est mort");
            System.out.println(this.getClass().getSimpleName() + " est mort");
            return;
        }
        if (a.vie <= 0) {
            logger.info(a.getClass().getSimpleName() + " est mort");
            System.out.println(a.getClass().getSimpleName() + " est mort");
            return;
        } else {
            System.out.println("");
            if (this.chance > a.chance) {
                logger.info("Vous êtes le plus rapide donc vous attaquez en premier !");
                System.out.println("Vous êtes le plus rapide donc vous attaquez en premier !");
                if (this.getClass().getSimpleName().equals("Hero")) {
                    this.attaquenbrhero(a);
                    if (a.vie <= 0) {
                        logger.info(a.getClass().getSimpleName() + " est mort");
                        System.out.println(a.getClass().getSimpleName() + " est mort");
                        return;
                    }

                    else {
                        logger.info("C'est au tour de " + a.getClass().getSimpleName());
                        System.out.println("C'est au tour de " + a.getClass().getSimpleName());
                        a.attaque(this);
                        logger.info(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                        System.out.println(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                    }
                }

                else {
                    this.attaque(a);
                    if (a.vie <= 0) {
                        logger.info(a.getClass().getSimpleName() + " est mort");
                        System.out.println(a.getClass().getSimpleName() + " est mort");
                        return;
                    } else {
                        logger.info(a.getClass().getSimpleName() + " a " + a.vie + " points de vie restant");
                        System.out.println(a.getClass().getSimpleName() + " a " + a.vie + " points de vie restant");
                        logger.info("C'est au tour de " + a.getClass().getSimpleName());
                        System.out.println("C'est au tour de " + a.getClass().getSimpleName());
                        a.attaque(this);
                        logger.info(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                        System.out
                                .println(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                    }
                }
            }

            else {
                logger.info("L'ennemie attaque en premier !");
                System.out.println("L'ennemie attaque en premier !");
                System.out.println("");
                if (this.getClass().getSimpleName().equals("Hero")) {
                    a.attaque(this);
                    logger.info(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                    System.out.println(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                    if (this.vie <= 0) {
                        logger.info(this.getClass().getSimpleName() + " est mort");
                        System.out.println(this.getClass().getSimpleName() + " est mort");
                        return;
                    } else {
                        this.attaquenbrhero(a);
                    }
                }

                else {

                    a.attaque(this);
                    logger.info(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                    System.out.println(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                    if (this.vie <= 0) {
                        logger.info(this.getClass().getSimpleName() + " est mort");
                        System.out.println(this.getClass().getSimpleName() + " est mort");
                        return;
                    } else {
                        logger.info("C'est au tour de " + this.getClass().getSimpleName());
                        System.out.println("C'est au tour de " + this.getClass().getSimpleName());
                        this.attaque(a);
                        if (a.vie <= 0) {
                            logger.info(a.getClass().getSimpleName() + " est mort");
                            System.out.println(a.getClass().getSimpleName() + " est mort");
                            return;
                        } else {
                            logger.info(a.getClass().getSimpleName() + " a " + a.vie + " points de vie restant");
                            System.out.println(a.getClass().getSimpleName() + " a " + a.vie + " points de vie restant");
                        }
                    }
                }
            }
        }
    }
}
