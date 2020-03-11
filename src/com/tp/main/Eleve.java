package com.tp.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * REPONSE A LA QUESTION 1
 * Le concept de la programmation orientée objet auquel nous avons pensé, est l'heritage.Nous avons donc
 * cree une classe Personne qui aura des proprietes nom et prenom et nous n'avons besoin de definir ces proprietes
 * dans la classe com.tp.java.Eleve, vu qu'elle est herité, nous allons juste utiliser les getters et setters de la superclasse
 */
public class Eleve extends Person {
    public static final int NB_EVALUATIONS = 10;
    private int iD;
    private String nom;
    private String prenom;
    private int jour;
    private int mois;
    private int annee;
    private Double moyenne;
    private float mediane;
    private List<Evaluation> evaluations;
    private Promotion promotion;

    public Eleve(int id, String prenom, String nom) {
        super(nom, prenom);
        this.iD = id;
    }

    public Eleve(String nom, String prenom, int jour, int mois, int annee) {
        super(nom, prenom);
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    @Override
    public String toString() {
        return "(" + this.getNom() + ", " + this.getPrenom() + ") id:"
                + this.iD + "\nnotes:\n"
                + this.getEvaluations() + "\n"
                + "Moyenne = " + this.average() + "\n" +
                "Mediane = " + this.mediane + "\n" +
                "Correcteur(s): " + this.getCorrecteurs() + "\n" +
                "Nom de la promotion: " + this.promotion;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public List<Float> getNotes() {
        List<Float> notes = new ArrayList<>();
        for (Evaluation evaluation : evaluations) {
            if (evaluation.getNote().isEmpty()) {
                throw new IllegalStateException();
            }
            notes.add(evaluation.getNote().get());
        }
        return notes;
    }

    public Double average() {
        if (this.evaluations.isEmpty()) {
            return null;
        }

        List<Float> notes = getNotes();
        moyenne = notes.stream()
                .mapToDouble(note -> note)
                .average().getAsDouble();
        return moyenne;
    }

    //TODO Calcul de la mediane
    public Double median() {
        return null;
    }

    public Set<Professeur> getCorrecteurs() {
        return evaluations.stream()
                .map(Evaluation::getCorrecteur)
                .collect(Collectors.toSet());
    }

    public int getiD() {
        return iD;
    }

    /**
     * @return first name of student
     */
    @Override
    public String getNom() {
        return super.getNom();
    }

    /**
     * @return last Name of student
     */
    @Override
    public String getPrenom() {
        return super.getPrenom();
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
