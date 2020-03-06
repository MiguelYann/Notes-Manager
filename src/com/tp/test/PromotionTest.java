package com.tp.test;

import com.tp.main.Eleve;
import com.tp.main.Promotion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNull;

class PromotionTest {


    @Test
    void should_have_classement_students_on_promotion_have_notes() {
        final Eleve firstStudent = new Eleve("Raissa", "Wahoue", 1);
        final Eleve secondStudent = new Eleve("Thierry", "Damien", 2);
        final Eleve thirdStudent = new Eleve("Vincent", "David", 3);
        final Eleve fourthStudent = new Eleve("Stephane", "Scott", 4);
        final Eleve fifthStudent = new Eleve("Julien", "Pierre", 5);
        final Eleve sixthStudent = new Eleve("Julie", "Marie", 6);
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
        final Eleve firstStudent = new Eleve("Raissa", "Wahoue", 1);
        final Eleve secondStudent = new Eleve("Thierry", "Damien", 2);
        final Eleve thirdStudent = new Eleve("Vincent", "David", 3);
        final Eleve fourthStudent = new Eleve("Stephane", "Scott", 4);
        final Eleve fifthStudent = new Eleve("Julien", "Pierre", 5);
        final Eleve sixthStudent = new Eleve("Julie", "Marie", 6);
        final Set<Eleve> eleves = Set.of(firstStudent, secondStudent, thirdStudent, fourthStudent, fifthStudent, sixthStudent);
        Promotion promotion = new Promotion(eleves);
        final Eleve eleveRecherche = new Eleve("Miguel", "yann", 7);


        //Then

        assertNull(promotion.recherche(eleveRecherche));



    }

}
