package exercicedeux.domain.prescriptionrules;

import exercicedeux.domain.Inventory;
import exercicedeux.domain.Patient;
import exercicedeux.domain.Prescription;

import java.time.DayOfWeek;

public class Rule327 implements ValidationRule {
    @Override
    public boolean isValid(Patient patient, Prescription prescription, Inventory inventory) {
        if (!(prescription.getMedication().equals("Y") || prescription.getMedication().equals("Z"))) return true;

        boolean hasBRCA1 = patient.getGeneticMarkers().contains("BRCA1");
        boolean isWednesday = prescription.getDate().getDayOfWeek() == DayOfWeek.WEDNESDAY;

        return hasBRCA1 || isWednesday;
    }
}
