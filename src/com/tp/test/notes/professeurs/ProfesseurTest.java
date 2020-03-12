package com.tp.test.notes.professeurs;

import com.tp.main.notes.eleves.Eleve;
import com.tp.main.notes.eleves.Evaluation;
import com.tp.main.notes.eleves.Promotion;
import com.tp.main.notes.professeurs.Professeur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class ProfesseurTest {

    private Professeur professeur;

    @BeforeEach
    void setup() {
        this.professeur = new Professeur("Grand", "Pierre");
    }

    @Test
    void should_null_professor_does_not_found_student_on_promo() {

        //Given
        final Set<Eleve> eleves = Set.of(new Eleve(1, "Raissa", "Wahoue"), new Eleve(2, "Yannick", "Norbert"));
        Promotion promotion = new Promotion(eleves);

        //When
        final Eleve eleveRecherche = professeur.recherher(promotion, 3);

        //Then
        Assertions.assertNull(eleveRecherche);
    }

    @Test
    void should_get_student_professor_find_student_exist_on_promo() {

        //Given
        final Set<Eleve> eleves = Set.of(new Eleve(1, "Raissa", "Wahoue"), new Eleve(2, "Yannick", "Norbert"));
        Promotion promotion = new Promotion(eleves);

        //When
        final Eleve eleveRecherche = professeur.recherher(promotion, 2);

        //Then
        Assertions.assertEquals("Yannick", eleveRecherche.getPrenom());
        Assertions.assertEquals("Norbert", eleveRecherche.getNom());
    }

    @Test
    void should_throw_professor_try_set_note_tudent_does_exist_on_promo() {

        //Given
        final Eleve firstStudent = new Eleve(1, "Raissa", "Wahoue");
        final Evaluation mathematicsEvaluationOfFirstStudent = new Evaluation("Mathematics", 12.0, firstStudent, professeur);
        final Evaluation algorithmEvaluationOfFirstStudent = new Evaluation("Chimie", 10.0, firstStudent, new Professeur("James", "Scott"));
        final Evaluation englishEvaluationOfFirstStudent = new Evaluation("English", 10.0, firstStudent, new Professeur("Damien", "Kono"));
        firstStudent.setEvaluations(List.of(mathematicsEvaluationOfFirstStudent, algorithmEvaluationOfFirstStudent, englishEvaluationOfFirstStudent));
        final Eleve secondStudent = new Eleve(2, "Yannick", "Norbert");
        final Evaluation mathematicsEvaluationOfSecondStudent = new Evaluation("Mathematics", 04.5, secondStudent, professeur);
        final Evaluation englishEvaluationOfSecondStudent = new Evaluation("English", 14.0, firstStudent, new Professeur("Damien", "Kono"));
        final Evaluation algorithmEvaluationOfSecondStudent = new Evaluation("Algorithm", 10.0, firstStudent, new Professeur("Ghil", "Peter"));
        secondStudent.setEvaluations(List.of(mathematicsEvaluationOfSecondStudent, englishEvaluationOfSecondStudent, algorithmEvaluationOfSecondStudent));

        final Set<Eleve> eleves = Set.of(firstStudent, secondStudent);
        Promotion promotion = new Promotion(eleves);

        //When and Then
        Assertions.assertThrows(IllegalStateException.class, () -> professeur.setNote(promotion, 4, 13.0, 4));
    }

    @Test
    void should_modify_note_student_exist_and_has_note() {

        //Given
        final Eleve firstStudent = new Eleve(1, "Raissa", "Wahoue");
        final Evaluation mathematicsEvaluationOfFirstStudent = new Evaluation("Mathematics", 12.0, firstStudent, professeur);
        final Evaluation algorithmEvaluationOfFirstStudent = new Evaluation("Chimie", 10.0, firstStudent, new Professeur("James", "Scott"));
        final Evaluation englishEvaluationOfFirstStudent = new Evaluation("English", 10.0, firstStudent, new Professeur("Damien", "Kono"));
        firstStudent.setEvaluations(List.of(mathematicsEvaluationOfFirstStudent, algorithmEvaluationOfFirstStudent, englishEvaluationOfFirstStudent));
        final Eleve secondStudent = new Eleve(2, "Yannick", "Norbert");
        final Evaluation mathematicsEvaluationOfSecondStudent = new Evaluation("Mathematics", 04.5, secondStudent, professeur);
        final Evaluation englishEvaluationOfSecondStudent = new Evaluation("English", 14.0, firstStudent, new Professeur("Damien", "Kono"));
        final Evaluation algorithmEvaluationOfSecondStudent = new Evaluation("Algorithm", 10.0, firstStudent, new Professeur("Ghil", "Peter"));
        secondStudent.setEvaluations(List.of(mathematicsEvaluationOfSecondStudent, englishEvaluationOfSecondStudent, algorithmEvaluationOfSecondStudent));

        final Set<Eleve> eleves = Set.of(firstStudent, secondStudent);
        Promotion promotion = new Promotion(eleves);

        //When
        professeur.setNote(promotion, 2, 17.0, 2);

        //Then
        Assertions.assertEquals(17.0f, secondStudent.getEvaluations().get(2).getNote().get());
    }
}
