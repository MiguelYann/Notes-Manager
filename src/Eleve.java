import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

/**
 * REPONSE A LA QUESTION 1
 * Le concept de la programmation orientée objet auquel nous avons pensé, est l'heritage.Nous avons donc
 * cree une classe Personne qui aura des proprietes nom et prenom et nous n'avons besoin de definir ces proprietes
 * dans la classe Eleve, vu qu'elle est herité, nous allons juste utiliser les getters et setters de la superclasse
 */
public class Eleve extends Person {
    public static final int NB_EVALUATIONS = 10;
    private int iD;
    private String nom;
    private String prenom;
    private int jour;

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    private int mois;
    private int annee;
    private float moyenne;
    private float mediane;
    private List<Evaluation> evaluations;
    private Promotion promotion;

    public Eleve(String nom, String prenom) {
        super(nom, prenom);
    }

//    public Eleve(String nom, String prenom, int jour, int mois, int annee) {
//        super(nom, prenom); // fait appel au constructeur de la classe parent
//        this.jour = jour;
//        this.mois = mois;
//        this.annee = annee;
//    }

    public int getiD() {
        return iD;
    }

    public Double mediane() throws IllegalStateException {
        final List<Float> notes = getNotes();
        System.out.println(notes);

        if (notes.isEmpty()) {
            throw new IllegalStateException();
        }

        return notes.stream()
                .mapToDouble((n) -> n)
                .average().getAsDouble();
    }

    private List<Float> getNotes() {
        for (Evaluation evaluation : evaluations) {
            if (evaluation.getNote().isPresent()) {
                return evaluations.stream()
                        .map(eval -> eval.getNote().orElse(0.0f))
                        .collect(Collectors.toList());
            }
        }
        return emptyList();
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public List<Float> getNote() {
        List<Float> notes = new ArrayList<>();
        for (Evaluation evaluation : evaluations) {
            if (evaluation.getNote().isEmpty()) {
                throw new IllegalStateException();
            }
            notes.add(evaluation.getNote().get());
        }
        return notes;
    }

    public Double getAverage() {
        if (evaluations.isEmpty()) {
            return null;
        }

        List<Float> notes = getNote();
        return notes.stream()
                        .mapToDouble(note -> note)
                        .average().getAsDouble();
    }
}
