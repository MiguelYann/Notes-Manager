import java.util.Optional;

public class Evaluation {
    private String matiere;
    private Float note;
    private Eleve eleveCorrige;
    private Professeur correcteur;



    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public Optional<Float> getNote() {
        return Optional.ofNullable(note);
    }

    public void setNote(Float note) {
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

//    ((Jean, Duval) (Soleil, Tournesol) mathématiques 12.0)
}
