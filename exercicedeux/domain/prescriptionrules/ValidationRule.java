package exercicedeux.domain.prescriptionrules;

import exercicedeux.domain.Inventory;
import exercicedeux.domain.Patient;
import exercicedeux.domain.Prescription;

public interface ValidationRule {
    boolean isValid(Patient patient, Prescription prescription, Inventory inventory);
}

