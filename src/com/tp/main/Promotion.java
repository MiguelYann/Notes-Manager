package com.tp.main;

import java.util.Set;

public class Promotion implements Comparable {
    private int id;

    // ceci parce que nous estimons que dans une promotion nous aurons pas de doublons d'eleves
    private Set<Eleve> eleves;

    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
