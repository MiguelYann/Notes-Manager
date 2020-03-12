package com.tp.test.notes.eleves;

import com.tp.main.notes.eleves.Eleve;
import com.tp.main.notes.eleves.Promotion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNull;

class PromotionTest {

    private Promotion promotion;

    @Test
    void should_have_classement_students_on_promotion_have_notes() {
        final Eleve firstStudent = new Eleve(1, "Wahoue", "Raissa");
        final Eleve secondStudent = new Eleve(2, "Damien", "Thierry");
        final Eleve thirdStudent = new Eleve(3, "David", "Vincent");
        final Eleve fourthStudent = new Eleve(4, "Scott", "Stephane");
        final Eleve fifthStudent = new Eleve(5, "Pierre", "Julien");
        final Eleve sixthStudent = new Eleve(6, "Marie", "Julie");
        final Set<Eleve> eleves = Set.of(firstStudent, secondStudent, thirdStudent, fourthStudent, fifthStudent, sixthStudent);

        Double averageFirstStudent = 12.0;
        Double averageSecondStudent = 10.0;
        Double averageThirstStudent = 14.5;
        Double averageFourthStudent = 8.0;
        Double averageFifthStudent = 11.5;
        Double averageSixthStudent = 6.0;

        Promotion promotion = new Promotion(eleves);
        //when

        String[] expectedClassement = {"Julie", "Stephane", "Thierry", "Julien", "Raissa", "Vincent"};

        //Then

//        Assertions.assertArrayEquals(expectedClassement, classementPromotion);

    }

    @Test
    void should_null_student_search_not_in_promotion() {
        final Eleve firstStudent = new Eleve(1, "Wahoue", "Raissa");
        final Eleve secondStudent = new Eleve(2, "Damien", "Thierry");
        final Eleve thirdStudent = new Eleve(3, "David", "Vincent");
        final Eleve fourthStudent = new Eleve(4, "Scott", "Stephane");
        final Eleve fifthStudent = new Eleve(5, "Pierre", "Julien");
        final Eleve sixthStudent = new Eleve(6, "Marie", "Julie");
        final Set<Eleve> eleves = Set.of(firstStudent, secondStudent, thirdStudent, fourthStudent, fifthStudent, sixthStudent);
        Promotion promotion = new Promotion(eleves);
        final Eleve eleveRecherche = new Eleve(7, "yann", "Miguel");


        //Then

        assertNull(promotion.recherche(7));
    }

    @Test
    void should_student_promotion_has_student() {

        final Eleve firstStudent = new Eleve(1, "Wahoue", "Raissa");
        final Eleve secondStudent = new Eleve(2, "Damien", "Thierry");
        final Eleve thirdStudent = new Eleve(3, "David", "Vincent");
        final Eleve fourthStudent = new Eleve(4, "Scott", "Stephane");
        final Eleve fifthStudent = new Eleve(5, "Pierre", "Julien");
        final Eleve sixthStudent = new Eleve(6, "Marie", "Julie");

        final Set<Eleve> eleves = Set.of(firstStudent, secondStudent, thirdStudent, fourthStudent, fifthStudent, sixthStudent);
        Promotion promotion = new Promotion(eleves);

        Assertions.assertEquals("Thierry", promotion.recherche(2).getNom());

    }
}
