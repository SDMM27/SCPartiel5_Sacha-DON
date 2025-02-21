package exercicedeux.domain.prescriptionrules;

import exercicedeux.domain.Inventory;
import exercicedeux.domain.Patient;
import exercicedeux.domain.Prescription;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Rule666 implements ValidationRule {
    @Override
    public boolean isValid(Patient patient, Prescription prescription, Inventory inventory) {
        if (!inventory.hasStockFor(prescription.getMedication())) return false;

        int requiredStock = 3;
        if (isWeekend(prescription.getDate())) {
            requiredStock += requiredStock * 0.2; // +20% pour le weekend
        }

        return inventory.getStockLevel(prescription.getMedication()) > requiredStock;
    }

    private boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
}
