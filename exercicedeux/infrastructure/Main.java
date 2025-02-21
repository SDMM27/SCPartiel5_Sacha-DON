package exercicedeux.infrastructure;

import exercicedeux.application.PrescriptionValidator;
import exercicedeux.domain.*;
import exercicedeux.domain.prescriptionrules.Rule327;
import exercicedeux.domain.prescriptionrules.Rule666;
import exercicedeux.domain.prescriptionrules.Rule801;
import exercicedeux.domain.prescriptionrules.ValidationRule;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // ✅ Création des patients avec différents états
        Patient patient1 = new Patient(1600, true, false, Arrays.asList("BRCA1")); // Protocole Gamma
        Patient patient2 = new Patient(1800, false, true, Arrays.asList("BRCA1")); // En rechute après 2019
        Patient patient3 = new Patient(2500, false, false, Arrays.asList("")); // Aucun marqueur génétique

        // ✅ Création d'un stock initial
        Inventory inventory = new Inventory();
        inventory.addStock("X", 10);
        inventory.addStock("Y", 5);
        inventory.addStock("Z", 5);
        inventory.addStock("W", 10);

        // ✅ Création des règles de validation
        List<ValidationRule> rules = Arrays.asList(new Rule801(), new Rule327(), new Rule666());
        PrescriptionValidator validator = new PrescriptionValidator(rules);

        // ✅ Liste de prescriptions à tester
        List<Prescription> prescriptions = Arrays.asList(
                new Prescription("X", LocalDate.of(2025, 3, 10)), // Test normal pour X
                new Prescription("X", LocalDate.of(2025, 6, 15)), // Autre test pour X
                new Prescription("Y", LocalDate.of(2025, 3, 12)), // Test combinaison Y/Z
                new Prescription("Z", LocalDate.of(2025, 3, 12)), // Test combinaison Y/Z
                new Prescription("X", LocalDate.of(2025, 6, 15)), // Vérification sur un autre patient
                new Prescription("W", LocalDate.of(2025, 6, 15)), // Vérification du stock de W
                new Prescription("W", LocalDate.of(2025, 6, 22))  // Vérification d'une prescription un weekend
        );

        // ✅ Tester chaque prescription pour chaque patient
        for (Patient patient : Arrays.asList(patient1, patient2, patient3)) {
            System.out.println("\n📌 Validation pour un patient avec globules blancs : " + patient.getWhiteBloodCellCount());
            for (Prescription prescription : prescriptions) {
                boolean isValid = validator.validate(patient, prescription, inventory);
                System.out.println("💊 Prescription " + prescription.getMedication() + " pour " + prescription.getDate() +
                        " → " + (isValid ? "✅ Valide" : "❌ Invalide"));
            }
        }
    }
}
