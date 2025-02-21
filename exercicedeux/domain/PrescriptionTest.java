package exercicedeux.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class PrescriptionTest {

    @Test
    void shouldStoreCorrectMedicationAndDate() {
        LocalDate date = LocalDate.of(2025, 3, 10);
        Prescription prescription = new Prescription("X", date);

        assertEquals("X", prescription.getMedication());
        assertEquals(date, prescription.getDate());
    }

    @Test
    void shouldNotModifyStoredValues() {
        LocalDate date = LocalDate.of(2025, 6, 15);
        Prescription prescription = new Prescription("Y", date);

        assertNotEquals("Z", prescription.getMedication());
        assertNotEquals(LocalDate.of(2025, 1, 1), prescription.getDate());
    }
}

