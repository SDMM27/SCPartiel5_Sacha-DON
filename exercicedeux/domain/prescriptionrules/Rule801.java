package exercicedeux.domain.prescriptionrules;

import exercicedeux.domain.Inventory;
import exercicedeux.domain.Patient;
import exercicedeux.domain.Prescription;

public class Rule801 implements ValidationRule {
    @Override
    public boolean isValid(Patient patient, Prescription prescription, Inventory inventory) {
        if (!prescription.getMedication().equals("X")) return true;

        int threshold = patient.isInGammaProtocol() ? 1500 : 2000;
        if (patient.isRelapsingAfter2019()) threshold = 2000;

        return patient.getWhiteBloodCellCount() > threshold;
    }
}
