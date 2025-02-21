package exercicedeux.domain;

import java.time.LocalDate;

public class Prescription {
    private final String medication;
    private final LocalDate date;

    public Prescription(String medication, LocalDate date) {
        this.medication = medication;
        this.date = date;
    }

    public String getMedication() { return medication; }
    public LocalDate getDate() { return date; }
}
