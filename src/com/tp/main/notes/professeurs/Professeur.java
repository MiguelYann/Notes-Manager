package com.tp.main.notes.professeurs;

import com.tp.main.Person;
import com.tp.main.notes.eleves.Eleve;
import com.tp.main.notes.eleves.Evaluation;
import com.tp.main.notes.eleves.Promotion;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.Objects.isNull;

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

    public void modifier(Eleve eleve) {

    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public String getPrenom() {
        return super.getPrenom();
    }

    public Eleve recherher(Promotion promotion, int eleveId) {
        final Set<Eleve> promotionEleves = promotion.getEleves();
        final Optional<Eleve> firstStudent = getSearchStudent(eleveId, promotionEleves);

        return firstStudent.orElse(null);
    }

    private Optional<Eleve> getSearchStudent(int eleveId, Set<Eleve> promotionEleves) {
        return promotionEleves.stream()
                .filter(eleve -> eleve.getiD() == eleveId)
                .findFirst();
    }

    public void setNote(Promotion promotion, int iD, Double note, int index) throws IllegalStateException {
        final Eleve eleveRecherche = recherher(promotion, iD);
        if (eleveRecherche == null) {
            throw new IllegalStateException();
        }

        Double noteToModify = eleveRecherche.getNotes().get(index);
        final List<Evaluation> evaluations = eleveRecherche.getEvaluations();
        if (eleveRecherche.getiD() == iD && !isNull(noteToModify)) {

            evaluations.stream()
                    .filter(notePredicate(noteToModify))
                    .forEach(evaluation -> evaluation.setNote(note));

        } else if (eleveRecherche.getiD() == iD && isNull(noteToModify)) {
            Evaluation evaluation = new Evaluation();
            evaluation.setNote(note);
            evaluations.add(evaluation);
        }
    }

    private Predicate<Evaluation> notePredicate(Double theNote) {
        return evaluation -> evaluation.getNote().isPresent() && evaluation.getNote().get().equals(theNote);
    }
}
