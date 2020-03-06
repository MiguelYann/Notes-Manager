package com.tp.main;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Promotion implements Comparable {
    private int id;

    // ceci parce que nous estimons que dans une promotion nous aurons pas de doublons d'eleves
    private Set<Eleve> eleves;

    public Promotion(int id, Set<Eleve> eleves) {
        this.id = id;
        this.eleves = eleves;
    }

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
}
