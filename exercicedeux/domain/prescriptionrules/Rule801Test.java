package exercicedeux.domain.prescriptionrules;

import exercicedeux.domain.Inventory;
import exercicedeux.domain.Patient;
import exercicedeux.domain.Prescription;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;

public class Rule801Test {
    private final Rule801 rule = new Rule801();

    @Test
    void shouldAllowMedicationXForPatientsAbove2000() {
        Patient patient = new Patient(2100, false, false, Arrays.asList());
        Prescription prescription = new Prescription("X", LocalDate.of(2025, 3, 10));
        Inventory inventory = new Inventory();

        assertTrue(rule.isValid(patient, prescription, inventory));
    }

    @Test
    void shouldNotAllowMedicationXForPatientsBelowThreshold() {
        Patient patient = new Patient(1800, false, false, Arrays.asList());
        Prescription prescription = new Prescription("X", LocalDate.of(2025, 3, 10));
        Inventory inventory = new Inventory();

        assertFalse(rule.isValid(patient, prescription, inventory));
    }

    @Test
    void shouldAllowGammaProtocolPatientsAbove1500() {
        Patient patient = new Patient(1600, true, false, Arrays.asList());
        Prescription prescription = new Prescription("X", LocalDate.of(2025, 3, 10));
        Inventory inventory = new Inventory();

        assertTrue(rule.isValid(patient, prescription, inventory));
    }

    @Test
    void shouldNotAllowGammaProtocolPatientsBelow1500() {
        Patient patient = new Patient(1400, true, false, Arrays.asList());
        Prescription prescription = new Prescription("X", LocalDate.of(2025, 3, 10));
        Inventory inventory = new Inventory();

        assertFalse(rule.isValid(patient, prescription, inventory));
    }
}

