package com.example.definition.TypesPerso;

// importation des classes
import com.example.definition.DefHeros.Capacitespeciale;
import com.example.definition.Jeu;
// importation de la classe Logger
import java.util.logging.Logger;

// Classe Personnage
public class Personnage {
    // Déclaration du logger
    private static final Logger logger = Logger.getLogger(Jeu.class.getName());
    // Déclaration des attributs de la classe Personnage
    protected int vie;
    protected int attaque;
    protected int defense;
    protected int chance;
    protected String arme;
    protected boolean changement = false;
    protected boolean nbrchangement = false;

    // Constructeur de la classe Personnage
    public Personnage(int vie, int attaque, int defense, int chance, String arme) {
        this.vie = vie;
        this.attaque = attaque;
        this.defense = defense;
        this.chance = chance;
        this.arme = arme;
    }

    // Getters et Setters
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

    public boolean getChangement() {
        return changement;
    }

    public void setChangement(boolean changement) {
        this.changement = changement;
    }

    public boolean getNbrchangement() {
        return nbrchangement;
    }

    public void setNbrchangement(boolean nbrchangement) {
        this.nbrchangement = nbrchangement;
    }

    // Méthode qui permet d'utiliser la capacité spéciale d'un personnage
    // précedement choisi
    public void changementattaquecapacite(Personnage changement, Personnage cible) {
        if (nbrchangement == true) {
            System.out.println("Vous avez déjà utilisé sa capacité spéciale");
            return;
        }
        if (changement instanceof Capacitespeciale) {
            // verifier si le hero a l'attribut changement en true
            System.out.println("Le " + this.getClass().getSimpleName() + " utilise la capacité spéciale de "
                    + changement.getClass().getSimpleName());
            ((Capacitespeciale) changement).utiliserCapacite(cible);
        } else {
            System.out.println("Le " + changement.getClass().getSimpleName() + " n'a pas de capacité spéciale");
        }

    }

    // Méthode qui permet d'attaque un ennemie plusieurs fois, il n'y a que le perso
    // héros qui peut attaquer plusieurs fois
    public void attaquenbrhero(Personnage a) {
        // Génère un nombre aléatoire entre 1 et 5
        int nbrattaque = Random(1, 5);
        // Initialisation du compteur
        int compteur = 0;
        System.out.println("Le Hero attaque " + nbrattaque + " fois");
        logger.info("Le Hero attaque " + nbrattaque + " fois");

        // Boucle qui permet d'attaquer l'ennemie plusieurs fois, tant que le compteur
        // est inférieur au nombre d'attaque
        while (compteur < nbrattaque) {
            // attaque héro
            this.attaquehero(a);
            // Si l'ennemie est mort, on sort de la boucle
            if (a.vie <= 0) {
                logger.info(a.getClass().getSimpleName() + " est mort");
                return;
            } else {
                // Sinon on incrémente le compteur
                compteur++;
            }
        }

        // Calcul des dégats infligés à l'ennemie
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

    // Méthode qui permet d'attaquer un ennemie utilisé par le héro
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

    // Méthode qui permet d'attaquer un ennemie
    public void attaque(Personnage a) {
        // Vérification si le héro est mort ou si l'ennemie est mort
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

    // Méthode qui permet de générer un nombre aléatoire
    private int Random(int i, int j) {
        return (int) (Math.random() * (j - i + 1) + i);
    }

    // Vérification de qui attaque en premier dependant de l'attribut chance des
    // personnages
    // Il n'y a que le Gangster qui a un valeur supérieur aux héros ce qui lui
    // permet d'attaquer en premier
    public void attaquepremier(Personnage a) {
        // Vérification si le héro est mort ou si l'ennemie est mort
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
                // Si le héro a une chance supérieur à l'ennemie, il attaque en premier
                logger.info("Vous êtes le plus rapide donc vous attaquez en premier !");
                System.out.println("Vous êtes le plus rapide donc vous attaquez en premier !");
                if (this.getClass().getSimpleName().equals("Hero")) {
                    // Si c'est un héro, on utilise la méthode attaquehero qui lui est propre afin
                    // qu'il puisse attaquer plusieurs fois
                    this.attaquenbrhero(a);
                    // Si l'ennemie est mort, on arrête la méthode sinon c'est à son tour d'attaquer
                    if (a.vie <= 0) {
                        logger.info(a.getClass().getSimpleName() + " est mort");
                        System.out.println(a.getClass().getSimpleName() + " est mort");
                        return;
                    } else {
                        logger.info("C'est au tour de " + a.getClass().getSimpleName());
                        System.out.println("C'est au tour de " + a.getClass().getSimpleName());
                        a.attaque(this);
                        logger.info(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                        System.out
                                .println(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                    }
                } else {
                    // Si le personnage n'est pas un héro, on utilise la méthode attaque normal
                    this.attaque(a);
                    // Si l'ennemie est mort, on arrête la méthode sinon c'est à son tour d'attaquer
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
            } else {
                // Si l'ennemie a une chance supérieur au héro, il attaque en premier
                logger.info("L'ennemie attaque en premier !");
                System.out.println("L'ennemie attaque en premier !");
                System.out.println("");
                // Si le perso est un héro, on utilise la méthode attaquehero qui lui est propre
                // afin qu'il puisse attaquer plusieurs fois à son tour
                if (this.getClass().getSimpleName().equals("Hero")) {
                    // attaque de l'ennemie
                    a.attaque(this);
                    logger.info(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                    System.out.println(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                    // Si le héro est mort, on arrête la méthode sinon c'est à son tour d'attaquer
                    if (this.vie <= 0) {
                        logger.info(this.getClass().getSimpleName() + " est mort");
                        System.out.println(this.getClass().getSimpleName() + " est mort");
                        return;
                    } else {
                        this.attaquenbrhero(a);
                    }
                } else {
                    // si le perso n'est pas un héro, on utilise la méthode attaque normal
                    // attaque de l'ennemie
                    a.attaque(this);
                    logger.info(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                    System.out.println(this.getClass().getSimpleName() + " a " + this.vie + " points de vie restant");
                    // Si le personnage est mort, on arrête la méthode sinon c'est à son tour
                    // d'attaquer
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
