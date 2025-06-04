package helpers;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import rescueanimals.RescueAnimal.TrainingStatus;

public class RescueAnimalHelper {

	// Eligible monkey species for training (lowercase for validation)
	private static final Set<String> VALID_SPECIES = new HashSet<>(Set.of(
			"capuchin", "guenon", "macaque", "marmoset", "squirrel monkey", "tamarin"
	));

	public static String generateAcquisitionDate() {
		// Returns current date in ISO format (e.g., 2025-06-02)
		return LocalDate.now().toString();
	}

	public static String generateAcquisitionLocation() {
		// TODO: Make dynamic with real-time locational data
		return "The South Pole";
	}

	public static TrainingStatus generateTrainingStatus() {
		return TrainingStatus.INTAKE;
	}

	public static String generateInServiceCountry() {
		// TODO: Make dynamic with real-time locational data
		return "The North Pole";
	}
}