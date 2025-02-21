package exercicedeux.domain.prescriptionrules;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import exercicedeux.domain.Inventory;
import exercicedeux.domain.Patient;
import exercicedeux.domain.Prescription;

import java.time.LocalDate;
import java.util.Arrays;

public class Rule327Test {
    private final Rule327 rule = new Rule327();

    @Test
    void shouldAllowYAndZCombinationForPatientsWithBRCA1() {
        Patient patient = new Patient(2000, false, false, Arrays.asList("BRCA1"));
        Prescription prescription = new Prescription("Y", LocalDate.of(2025, 3, 10));
        Inventory inventory = new Inventory();

        assertTrue(rule.isValid(patient, prescription, inventory));
    }

    @Test
    void shouldNotAllowYAndZCombinationWithoutBRCA1OnNonWednesday() {
        Patient patient = new Patient(2000, false, false, Arrays.asList());
        Prescription prescription = new Prescription("Y", LocalDate.of(2025, 3, 10)); // Non-mercredi
        Inventory inventory = new Inventory();

        assertFalse(rule.isValid(patient, prescription, inventory));
    }

    @Test
    void shouldAllowYAndZCombinationOnWednesdayEvenWithoutBRCA1() {
        Patient patient = new Patient(2000, false, false, Arrays.asList());
        Prescription prescription = new Prescription("Z", LocalDate.of(2025, 3, 12)); // Un mercredi
        Inventory inventory = new Inventory();

        assertTrue(rule.isValid(patient, prescription, inventory));
    }
}

