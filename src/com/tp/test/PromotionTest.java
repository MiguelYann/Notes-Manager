package com.tp.test;

import com.tp.main.Eleve;
import com.tp.main.Promotion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class PromotionTest {


    @Test
    void should_have_classement_students_on_promotion_have_notes() {
        final Eleve firstStudent = new Eleve("Raissa", "Wahoue");
        final Eleve secondStudent = new Eleve("Thierry", "Damien");
        final Eleve thirdStudent = new Eleve("Vincent", "David");
        final Eleve fourthStudent = new Eleve("Stephane", "Scott");
        final Eleve fifthStudent = new Eleve("Julien", "Pierre");
        final Eleve sixthStudent = new Eleve("Julie", "Marie");
        final Set<Eleve> eleves = Set.of(firstStudent, secondStudent, thirdStudent, fourthStudent, fifthStudent, sixthStudent);

        Double averageFirstStudent = 12.0;
        Double averageSecondStudent = 10.0;
        Double averageThirstStudent = 14.5;
        Double averageFourthStudent = 8.0;
        Double averageFifthStudent = 11.5;
        Double averageSixthStudent = 6.0;

        Promotion promotion = new Promotion(1, eleves);
        //when

        String[] expectedClassement = {"Julie", "Stephane", "Thierry", "Julien", "Raissa", "Vincent"};

        //Then

//        Assertions.assertArrayEquals(expectedClassement, classementPromotion);



    }

}
