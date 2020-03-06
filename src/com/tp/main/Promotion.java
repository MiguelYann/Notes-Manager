package com.tp.main;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Promotion implements Comparable {


    private String nomPromotion;

    /**
     * @return une listes d'eleves en estimant que nous avons pas de doublons
     */
    public Set<Eleve> getEleves() {
        return eleves;
    }

    private Set<Eleve> eleves;

    public Promotion(Set<Eleve> eleves) {
        this.eleves = eleves;
    }

    public Promotion(String nomPromotion) {
        this.nomPromotion = nomPromotion;
    }

//    public Eleve rechercher(Eleve eleve) {
//       if(eleve.)
//        }
//    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public String[] getClassement() {
        return new String[9];
    }

    public Double[] getClassement(List<Double> averages) {
        List<Double> ordered = averages.stream()
                .sorted()
                .collect(Collectors.toList());

        return (Double[]) ordered.toArray();
    }

    public String getNomPromotion() {
        return nomPromotion;
    }

    public void setNomPromotion(String nomPromotion) {
        this.nomPromotion = nomPromotion;
    }

    Promotion() {

    }

    public Eleve recherche(Eleve eleveRecherche) {
        for (Eleve eleve : eleves) {
            if (eleveRecherche.getiD() == eleve.getiD()) {
                return eleveRecherche;
            }
        }
        return null;
    }
}
