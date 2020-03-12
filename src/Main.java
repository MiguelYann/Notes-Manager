import com.tp.main.notes.eleves.Eleve;
import com.tp.main.notes.eleves.Evaluation;
import com.tp.main.notes.eleves.Promotion;
import com.tp.main.notes.professeurs.Professeur;

import java.util.List;
import java.util.Set;

//TODO Recuperer deux chiffres apres la virgule
public class Main {

    public static void main(String[] args) {

        Promotion promotion = new Promotion("PROMO 2020");
        Eleve premierEleve = new Eleve(1, "Jean", "Duval");
        Professeur professeurDeFrancais = new Professeur("Tournesol", "Soleil");
        Evaluation evaluationDeFrancaisPremierEleve = new Evaluation("Francais", 18.0, premierEleve, professeurDeFrancais);
        Professeur professeurMathematiques = new Professeur("Einstain", "Fred");
        Evaluation evaluationMathematiquesPremierEleve = new Evaluation("Mathematiques", 12.0, premierEleve, professeurMathematiques);
        Evaluation evaluationBiologiePremierEleve = new Evaluation("Biologie", 6.0, premierEleve, professeurMathematiques);
        Evaluation evaluationAlgorithmePremierEleve = new Evaluation("Algorithme", 15.0, premierEleve, professeurMathematiques);

        premierEleve.setEvaluations(List.of(
                evaluationMathematiquesPremierEleve,
                evaluationDeFrancaisPremierEleve,
                evaluationAlgorithmePremierEleve,
                evaluationBiologiePremierEleve));
        premierEleve.setPromotion(promotion);

        Eleve deuxiemeEleve = new Eleve(2, "Thierry", "Garnier");
        Evaluation evaluationDeFrancaisDeuxiemeEleve = new Evaluation("Francais", 18.0, premierEleve, professeurDeFrancais);
        Evaluation evaluationDeMathematiquesDeuxiemeEleve = new Evaluation("Mathematiques", 19.0, premierEleve, professeurMathematiques);
        Evaluation evaluationBiologieDeuxiemeEleve = new Evaluation("Biologie", 6.0, premierEleve, professeurMathematiques);
        Evaluation evaluationAlgorithmeDeuxiemeEleve = new Evaluation("Algorithme", 15.0, premierEleve, professeurMathematiques);

        deuxiemeEleve.setEvaluations(List.of(
                evaluationDeFrancaisDeuxiemeEleve,
                evaluationDeMathematiquesDeuxiemeEleve,
                evaluationBiologieDeuxiemeEleve,
                evaluationAlgorithmeDeuxiemeEleve));
        deuxiemeEleve.setPromotion(promotion);

        Eleve troisiemeEleve = new Eleve(3, "Xavier", "Larbre");
        Evaluation evaluationDeFrancaisTroisiemeEleve = new Evaluation("Francais", 20.0, troisiemeEleve, professeurDeFrancais);
        Evaluation evaluationDeMathematiquesTroisiemeEleve = new Evaluation("Mathemetiques", 20.0, troisiemeEleve, professeurMathematiques);
        Evaluation evaluationBiologieTroisiemeEleve = new Evaluation("Biologie", 6.0, premierEleve, professeurMathematiques);
        Evaluation evaluationAlgorithmeTroisiemeEleve = new Evaluation("Algorithme", 15.0, premierEleve, professeurMathematiques);

        troisiemeEleve.setEvaluations(List.of(
                evaluationDeFrancaisTroisiemeEleve,
                evaluationDeMathematiquesTroisiemeEleve,
                evaluationAlgorithmeTroisiemeEleve,
                evaluationBiologieTroisiemeEleve));
        troisiemeEleve.setPromotion(promotion);

        promotion = new Promotion(Set.of(deuxiemeEleve, troisiemeEleve, premierEleve));

        System.out.println("AFFICHAGE D'UN ELEVE");
        System.out.println("***************************\n");
        System.out.println(premierEleve);
        System.out.println("***************************\n");

        System.out.println("ELEVES DE LA PROMOTION");
        System.out.println("***************************\n");
        System.out.println(promotion.getEleves());

        final Eleve eleveRecherche = promotion.recherche(3);
        System.out.println("***************************\n");

        System.out.println("ELEVE RECHERCHE AVEC iD 3");
        System.out.println("***************************");
        System.out.println(eleveRecherche);
    }
}
