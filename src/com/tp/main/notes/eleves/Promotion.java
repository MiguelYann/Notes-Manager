package com.tp.main.notes.eleves;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Promotion {

    private String nomPromotion;
    private Set<Eleve> eleves = new HashSet<>();

    public Promotion() {
    }

    public Promotion(Set<Eleve> eleves) {
        this.eleves = eleves;
    }

    public Promotion(String nomPromotion) {
        this.nomPromotion = nomPromotion;
    }

    /**
     * @return une listes d'eleves en estimant que nous avons pas de doublons
     */
    public Set<Eleve> getEleves() {
        return eleves;
    }

    public String getNomPromotion() {
        return nomPromotion;
    }

    public void setNomPromotion(String nomPromotion) {
        this.nomPromotion = nomPromotion;
    }

    public Eleve recherche(int iD) {
        for (Eleve eleve : eleves) {
            if (iD == eleve.getiD()) {
                return eleve;
            }
        }
        return null;
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
        return nomPromotion;
    }
}
