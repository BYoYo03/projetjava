package com.example.definition.DefHeros;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.definition.DefHeros.Hero;
import com.example.definition.DefEnnemies.Monstre;
import com.example.definition.TypesPerso.Personnage;
import org.junit.jupiter.api.Test;

class HeroTest {

    private Hero hero;
    private Personnage cible;

    @Test
    void testUtiliserCapaciteSansCapacite() {
        // Initialisation du héros et de la cible
        hero = new Hero();
        cible = new Monstre();
        hero.setNbrcapacite(1); // On s'assure que le héros a la possibilité d'utiliser une capacité spéciale

        // Utilise la capacité pour épuiser les utilisations
        hero.utiliserCapacite(cible);
        // Réinitialise la vie de la cible pour un deuxième test
        cible.setVie(100);

        // Tente d'utiliser la capacité spéciale une seconde fois
        hero.utiliserCapacite(cible);

        // La vie de la cible ne devrait pas changer car il n'y a plus de capacité
        // spéciale
        assertEquals(100, cible.getVie(), "La capacité ne devrait pas être utilisable sans charges restantes.");
        // Le nombre de capacités restantes doit toujours être 0
        assertEquals(0, hero.getNbrcapacite(), "Le nombre de capacités restantes devrait être 0 après épuisement.");
    }

    @Test
    void testrechargecapacite() {
        // Initialisation du héros et de la cible
        cible = new Monstre();
        hero.setNbrcapacite(1); // On s'assure que le héros a la possibilité d'utiliser une capacité spéciale

        // Utilise la capacité pour épuiser les utilisations
        hero.utiliserCapacite(cible);
        // Réinitialise la vie de la cible pour un deuxième test
        cible.setVie(100);

        // Recharge la capacité spéciale
        hero.rechargerCapacite();

        // Le nombre de capacités restantes doit toujours être 0
        assertEquals(1, hero.getNbrcapacite(), "Le nombre de capacités restantes devrait être 1 après rechargement.");
    }
}
