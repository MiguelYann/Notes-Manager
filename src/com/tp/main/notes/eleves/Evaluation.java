package com.tp.main.notes.eleves;

import com.tp.main.notes.professeurs.Professeur;

import java.util.Optional;

public class Evaluation {
    private String matiere;
    private Double note;
    private Eleve eleveCorrige;
    private Professeur correcteur;

    public Evaluation() {
    }

    public Evaluation(String matiere, Double note, Eleve eleveCorrige, Professeur correcteur) {
        this.matiere = matiere;
        this.note = note;
        this.eleveCorrige = eleveCorrige;
        this.correcteur = correcteur;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public Optional<Double> getNote() {
        return Optional.ofNullable(note);
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public Eleve getEleveCorrige() {
        return eleveCorrige;
    }

    public void setEleveCorrige(Eleve eleveCorrige) {
        this.eleveCorrige = eleveCorrige;
    }

    public Professeur getCorrecteur() {
        return correcteur;
    }

    public void setCorrecteur(Professeur correcteur) {
        this.correcteur = correcteur;
    }

    @Override
    public String toString() {
        return "((" + this.eleveCorrige.getPrenom() + ", " + this.eleveCorrige.getNom() + ")" +
                " (" + this.correcteur.getPrenom() + ", " + this.correcteur.getNom() + ") " +
                this.matiere + " " + this.note + ")";
    }
}
