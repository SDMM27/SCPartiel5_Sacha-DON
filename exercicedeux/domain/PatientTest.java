package exercicedeux.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class PatientTest {

    @Test
    void shouldStoreCorrectWhiteBloodCellCount() {
        Patient patient = new Patient(1600, true, false, Arrays.asList("BRCA1"));

        assertEquals(1600, patient.getWhiteBloodCellCount());
    }

    @Test
    void shouldStoreCorrectProtocolInformation() {
        Patient patient = new Patient(1800, false, true, Arrays.asList("BRCA1"));

        assertFalse(patient.isInGammaProtocol());
        assertTrue(patient.isRelapsingAfter2019());
    }

    @Test
    void shouldStoreGeneticMarkersCorrectly() {
        List<String> markers = Arrays.asList("BRCA1", "TP53");
        Patient patient = new Patient(2500, false, false, markers);

        assertTrue(patient.getGeneticMarkers().contains("BRCA1"));
        assertTrue(patient.getGeneticMarkers().contains("TP53"));
        assertFalse(patient.getGeneticMarkers().contains("XYZ"));
    }
}
