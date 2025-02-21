package exercicedeux.application;

import exercicedeux.domain.prescriptionrules.Rule327;
import exercicedeux.domain.prescriptionrules.Rule666;
import exercicedeux.domain.prescriptionrules.Rule801;
import exercicedeux.domain.prescriptionrules.ValidationRule;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import exercicedeux.domain.Inventory;
import exercicedeux.domain.Patient;
import exercicedeux.domain.Prescription;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class PrescriptionValidatorTest {
    private final List<ValidationRule> rules = Arrays.asList(new Rule801(), new Rule327(), new Rule666());
    private final PrescriptionValidator validator = new PrescriptionValidator(rules);

    @Test
    void shouldValidateCorrectPrescription() {
        Patient patient = new Patient(2500, false, false, Arrays.asList("BRCA1"));
        Prescription prescription = new Prescription("X", LocalDate.of(2025, 3, 10));
        Inventory inventory = new Inventory();
        inventory.addStock("X", 10);

        assertTrue(validator.validate(patient, prescription, inventory));
    }

    @Test
    void shouldRejectIncorrectPrescription() {
        Patient patient = new Patient(1800, false, false, Arrays.asList());
        Prescription prescription = new Prescription("X", LocalDate.of(2025, 3, 10));
        Inventory inventory = new Inventory();
        inventory.addStock("X", 10);

        assertFalse(validator.validate(patient, prescription, inventory));
    }
}

