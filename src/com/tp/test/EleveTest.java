package com.tp.test;

import com.tp.main.Eleve;
import com.tp.main.Evaluation;
import com.tp.main.Professeur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class EleveTest {

    Eleve eleve;

    @BeforeEach
    void setup() {
        this.eleve = new Eleve("Raissa", "Wahoue");
    }

    @Test
    void should_throw_student_does_not_have_notes() {
        Evaluation anEvaluation = new Evaluation();
        anEvaluation.setNote(null);
        anEvaluation.setMatiere("Mathematics");

        eleve.setEvaluations(Set.of(anEvaluation));

        Assertions.assertThrows(Throwable.class, eleve::getNote);
    }

    @Test
    void should_have_notes_student_does_have_note() {
        //Given
        eleve.setEvaluations(evaluationsFactory());
        List<Float> notes = evaluationsFactory().stream()
                .map((evaluation -> evaluation.getNote().get()))
                .collect(Collectors.toList());


        //When
        eleve.getNote();

        //Then
        assertEquals(notes.size(), 2);
    }

    @Test
    void should_not_have_average_student_does_not_have_evaluation() {
        //Given
        eleve.setEvaluations(Collections.emptySet());

        //When
        Double averageNotes = eleve.getAverage();

        //Then
        assertNull(averageNotes);
    }

    @Test
    void should_compute_average_student_have_evaluation_with_notes() {
        //Given
        eleve.setEvaluations(evaluationsFactory());

        //When
        Double average = eleve.getAverage();

        //Then
        Assertions.assertEquals(13.25F, average);

    }

    @Test
    void should_get_all_professeurs_that_evaluate_students() {

        //Given
        Eleve anStudent = new Eleve("Raissa", "Wahoue");
        final Professeur professeurMaths = new Professeur("La Menace", "Max");
        final Professeur professeurPhysics = new Professeur("Tournesol", "Soleil");
        final Evaluation evaluationMaths = new Evaluation("Maths", anStudent, professeurMaths);
        final Evaluation evaluationPhysics = new Evaluation("Physique", anStudent, professeurPhysics);
        anStudent.setEvaluations(Set.of(evaluationPhysics,evaluationMaths ));

        //when
      Set<Professeur> professeurCorrecteurs = anStudent.getCorrecteurs();

      //Then
        Assertions.assertEquals(professeurCorrecteurs.toString(), "[(Soleil, Tournesol), (Max, La Menace)]");
    }

    private static Set<Evaluation> evaluationsFactory() {
        Evaluation physics = new Evaluation();
        physics.setNote(12.0F);
        physics.setMatiere("Physics");
        Evaluation mathematics = new Evaluation();
        mathematics.setMatiere("Mathematics");
        mathematics.setNote(14.5F);
        return Set.of(physics, mathematics);
    }
}


