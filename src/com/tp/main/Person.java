package com.tp.main;

public class Person {
    private String nom;
    private String prenom;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Person(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "(" + this.prenom + ", " + this.nom + ")";
    }
}
