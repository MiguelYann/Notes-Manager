package com.tp.test.notes.eleves;

import com.tp.main.notes.eleves.Eleve;
import com.tp.main.notes.eleves.Evaluation;
import com.tp.main.notes.professeurs.Professeur;
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

    private Eleve eleve;

    @BeforeEach
    void setup() {
        this.eleve = new Eleve(1, "Raissa", "Wahoue");
    }

    @Test
    void should_throw_student_does_not_have_notes() {

        //Given
        Evaluation anEvaluation = new Evaluation();
        anEvaluation.setNote(null);
        anEvaluation.setMatiere("Mathematics");

        eleve.setEvaluations(List.of(anEvaluation));

        //When and Then
        Assertions.assertThrows(Throwable.class, eleve::getNotes);
    }

    @Test
    void should_have_notes_student_does_have_note() {

        //Given
        eleve.setEvaluations(evaluationsWithNoteFactory());
        List<Float> notes = evaluationsWithNoteFactory().stream()
                .map((evaluation -> evaluation.getNote().get()))
                .collect(Collectors.toList());

        //When
        eleve.getNotes();

        //Then
        assertEquals(notes.size(), 2);
    }

    @Test
    void should_not_have_average_student_does_not_have_evaluation() {

        //Given
        eleve.setEvaluations(Collections.emptyList());

        //When
        Double averageNotes = eleve.average();

        //Then
        assertNull(averageNotes);
    }

    @Test
    void should_compute_average_student_have_evaluation_with_notes() {

        //Given
        eleve.setEvaluations(evaluationsWithNoteFactory());

        //When
        Double average = eleve.average();

        //Then
        Assertions.assertEquals(13.25F, average);
    }

    @Test
    void should_get_all_professeurs_that_evaluate_students() {

        //Given
        final Professeur professeurMaths = new Professeur("La Menace", "Max");
        final Professeur professeurPhysics = new Professeur("Tournesol", "Soleil");
        final Evaluation evaluationMaths = new Evaluation();
        final Evaluation evaluationPhysics = new Evaluation();

        evaluationMaths.setMatiere("Mathematics");
        evaluationMaths.setEleveCorrige(eleve);
        evaluationMaths.setCorrecteur(professeurMaths);
        evaluationPhysics.setMatiere("Physics");
        evaluationPhysics.setEleveCorrige(eleve);
        evaluationPhysics.setCorrecteur(professeurPhysics);
        eleve.setEvaluations(List.of(evaluationPhysics, evaluationMaths));

        //when
        Set<Professeur> professeurCorrecteurs = eleve.getCorrecteurs();

        //Then
        Assertions.assertEquals(professeurCorrecteurs.toString(), "[(Soleil, Tournesol), (Max, La Menace)]");
    }

    private static List<Evaluation> evaluationsWithNoteFactory() {
        Evaluation physics = new Evaluation();
        physics.setNote(12.0F);
        physics.setMatiere("Physics");
        Evaluation mathematics = new Evaluation();
        mathematics.setMatiere("Mathematics");
        mathematics.setNote(14.5F);
        return List.of(physics, mathematics);
    }
}

