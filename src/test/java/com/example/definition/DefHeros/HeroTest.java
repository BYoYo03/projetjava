package com.example.definition.DefHeros;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.definition.DefEnnemies.Monstre;
import com.example.definition.TypesPerso.Personnage;


class HeroTest {
    
    private Hero hero;
    private Personnage cible;

    @BeforeEach
    void setUp() {
        // Initialisation d'un héros avant chaque test
        hero = new Hero();
        cible = new Monstre(); // Assurez-vous que Personnage a un constructeur par défaut
    }

    @Test
    void testUtiliserCapacite() {
        // Vérifie que la capacité spéciale "One Shot" fonctionne correctement
        hero.utiliserCapacite(cible);
        
        // La vie de la cible devrait être 0 après l'utilisation de la capacité spéciale
        assertEquals(0, cible.getVie(), "La capacité spéciale 'One Shot' n'a pas fonctionné correctement.");
        // Vérifie que le nombre de capacités restantes est maintenant 0
        assertEquals(0, hero.getNbrcapacite(), "Le nombre de capacités restantes devrait être 0 après utilisation.");
    }

    @Test
    void testUtiliserCapaciteSansCapacite() {
        // Utilise la capacité pour épuiser les utilisations
        hero.utiliserCapacite(cible);
        
        // Réinitialise la vie de la cible pour un deuxième test
        cible.setVie(100);
        
        // Tente d'utiliser la capacité spéciale une seconde fois
        hero.utiliserCapacite(cible);

        // La vie de la cible ne devrait pas changer car il n'y a plus de capacités spéciales
        assertEquals(100, cible.getVie(), "La capacité ne devrait pas être utilisable sans charges restantes.");
        // Le nombre de capacités restantes doit toujours être 0
        assertEquals(0, hero.getNbrcapacite(), "Le nombre de capacités restantes devrait être 0 après épuisement.");
    }

    @Test
    void testInitialisationHero() {
        // Vérifie que l'initialisation du héros est correcte
        assertEquals("Epee", hero.getArme(), "L'arme initiale devrait être 'Epee'.");
        assertEquals("one shot", hero.getCapacite(), "La capacité initiale devrait être 'one shot'.");
        assertEquals(1, hero.getNbrcapacite(), "Le nombre initial de capacités devrait être 1.");
    }
}
