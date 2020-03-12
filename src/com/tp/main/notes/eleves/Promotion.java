package com.tp.main.notes.eleves;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Promotion {

    private String nom;
    private Set<Eleve> eleves = new HashSet<>();

    public Promotion() {
    }

    public Promotion(Set<Eleve> eleves) {
        this.eleves = eleves;
    }

    public Promotion(String nom) {
        this.nom = nom;
    }

    /**
     * @return une listes d'eleves en estimant que nous avons pas de doublons
     */
    public Set<Eleve> getEleves() {
        return eleves;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Eleve recherche(int iD) {
        return eleves.stream()
                .filter(eleve -> eleve.getiD() == iD)
                .findFirst()
                .orElse(null);
    }

    public List<Eleve> getClassementByAverage() {
        return getEleves(comparing(Eleve::average));
    }

    public List<Eleve> getClassementByMedian() {
        return getEleves(comparing(Eleve::median));
    }

    private List<Eleve> getEleves(Comparator<Eleve> comparing) {
        return eleves.stream()
                .sorted(comparing)
                .collect(toList());
    }

    @Override
    public String toString() {
        return nom;
    }
}
