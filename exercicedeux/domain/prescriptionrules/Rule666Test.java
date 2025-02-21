package exercicedeux.domain.prescriptionrules;

import exercicedeux.domain.Inventory;
import exercicedeux.domain.Patient;
import exercicedeux.domain.Prescription;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;

public class Rule666Test {
    private final Rule666 rule = new Rule666();

    @Test
    void shouldAllowPrescriptionIfEnoughStockExists() {
        Patient patient = new Patient(2000, false, false, Arrays.asList());
        Prescription prescription = new Prescription("W", LocalDate.of(2025, 3, 10));
        Inventory inventory = new Inventory();
        inventory.addStock("W", 5); // Stock > 3

        assertTrue(rule.isValid(patient, prescription, inventory));
    }

    @Test
    void shouldNotAllowPrescriptionIfStockBelowEmergencyLevel() {
        Patient patient = new Patient(2000, false, false, Arrays.asList());
        Prescription prescription = new Prescription("W", LocalDate.of(2025, 3, 10));
        Inventory inventory = new Inventory();
        inventory.addStock("W", 2); // Stock < 3

        assertFalse(rule.isValid(patient, prescription, inventory));
    }

    @Test
    void shouldNotAllowWeekendPrescriptionIfStockBelowThreshold() {
        Patient patient = new Patient(2000, false, false, Arrays.asList());
        Prescription prescription = new Prescription("W", LocalDate.of(2025, 3, 22)); // Un dimanche
        Inventory inventory = new Inventory();
        inventory.addStock("W", 3); // Stock minimum mais pas +20%

        assertFalse(rule.isValid(patient, prescription, inventory));
    }
}

