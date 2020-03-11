package com.tp.main.notes.eleves;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EleveDate {

    public static String createDateOf(int annee, int mois, int jour) {
        LocalDate localDate = LocalDate.of(annee, mois, jour);
        DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return simpleDateFormat.format(localDate);
    }
}
