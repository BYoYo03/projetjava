package com.example;
import com.example.definition.Personnage;
import com.example.definition.Hero;
import com.example.definition.Gangster;
import com.example.definition.Chevalier;
import com.example.definition.Brigand;
import com.example.definition.Jeu;



/**
 * Hello world!
 *
 */

public class App 
{
public static void main( String[] args )
    {

        System.out.println("");
        System.out.println("Bienvenue dans le jeu de combat de bahir et merwane");
        System.out.println("");
        Jeu jeu = new Jeu();
        jeu.commencer();
        jeu.choixperso();
    }

}
