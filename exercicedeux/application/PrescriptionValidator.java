package exercicedeux.application;

import exercicedeux.domain.Inventory;
import exercicedeux.domain.Patient;
import exercicedeux.domain.Prescription;
import exercicedeux.domain.prescriptionrules.ValidationRule;

import java.util.List;

public class PrescriptionValidator {
    private final List<ValidationRule> rules;

    public PrescriptionValidator(List<ValidationRule> rules) {
        this.rules = rules;
    }

    public boolean validate(Patient patient, Prescription prescription, Inventory inventory) {
        for (ValidationRule rule : rules) {
            if (!rule.isValid(patient, prescription, inventory)) {
                return false; // Une règle échoue = prescription invalide
            }
        }
        return true;
    }
}

