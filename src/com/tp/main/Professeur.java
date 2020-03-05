package com.tp.main;

/**
 * REPONSE A LA QUESTION 1
 * Le concept de la programmation orientée objet auquel nous avons pensé, est l'heritage.Nous avons donc
 * cree une classe Personne qui aura des proprietes nom et prenom et nous n'avons besoin de definir ces proprietes
 * dans la classe com.tp.java.Professeur, vu qu'elle est herité, nous allons juste utiliser les getters et setters de la superclasse
 */
public class Professeur extends Person {
    private int iD;

    public Professeur(String nom, String prenom) {
        super(nom, prenom);
    }

    public Eleve recherher(Promotion promotion, int eleveId) {
        return null;
    }

    public void modifier(Eleve eleve) {

    }
}
