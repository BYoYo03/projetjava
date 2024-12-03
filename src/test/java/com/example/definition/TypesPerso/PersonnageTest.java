package com.example.definition.TypesPerso;
import static org.junit.jupiter.api.Assertions.*;

import com.example.definition.DefEnnemies.Brigand;
import com.example.definition.DefEnnemies.Gangster;
import com.example.definition.DefHeros.Capacitespeciale;
import com.example.definition.DefHeros.Chevalier;
import com.example.definition.DefHeros.Hero;
import com.example.definition.Jeu;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicTabbedPaneUI;


public class PersonnageTest {
    @Test
    // Ce test permet de vérifier qu'un ennemi meurt si un héros attaque
    void testAttaque () {
        Personnage testHero = new Chevalier();
        testHero.setVie(5);
        Personnage testEnnemi = new Brigand();
        testEnnemi.setVie(5);
        testHero.attaque(testEnnemi);
        assertEquals(0,testEnnemi.getVie());
    }
    @Test
    // Ce test simule qu'un héros meurt avant la ligne d'arrivée
    void testMortHeros () {
        Jeu jeu = new Jeu();
        Personnage testHero = new Chevalier();
        testHero.setVie(5);
        Personnage testEnnemi = new Gangster();
        testEnnemi.setVie(5);
        testEnnemi.attaque(testHero);
        assertEquals(0,testHero.getVie());
        //A la fin du jeu, le héros est mort, (system.exit(0))
    }

    @Test
    // Ce test vérifie que le gangster attaque bien avant le chevalier (car sa chance est supérieure)
    void testAttaquePremier () {
        Personnage testHero = new Chevalier();
        Personnage testEnnemi = new Gangster();
        assertNotEquals(testHero.getChance(),testEnnemi.getChance());
    }

    @Test
    // Ce test vérifie que le héros utilise bien sa capacité spéciale et tue le brigand (one shot)
    void utiliserCap () {
        Personnage testHero = new Hero();
        Personnage testEnnemi = new Brigand();
        ((Capacitespeciale) testHero).utiliserCapacite(testEnnemi);
        assertEquals(0,testEnnemi.getVie());
    }

    @Test
    // Ce test vérifie que le chevalier utilise bien sa capacité spéciale et attaque le brigand en esquivant son attaque
    void utiliserCap2 () {
        Personnage testHero = new Chevalier();
        Personnage testEnnemi = new Brigand();
        testEnnemi.setVie(50);
        ((Capacitespeciale) testHero).utiliserCapacite(testEnnemi);
        assertNotEquals(50,testEnnemi.getVie());
    }

}
