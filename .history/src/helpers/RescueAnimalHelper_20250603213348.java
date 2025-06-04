package helpers;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import app.TrainingStatus;

public class RescueAnimalHelper {

	// Eligible monkey species for training (lowercase for validation)
	public static final Set<String> VALID_SPECIES = new HashSet<>(Set.of(
			"capuchin", "guenon", "macaque", "marmoset", "squirrel monkey", "tamarin"
	));

	// Returns current date in ISO format (e.g., 2025-06-02)
	public static String generateAcquisitionDate() {
		return LocalDate.now().toString();
	}

	// TODO: Make dynamic with real-time locational data
	public static String generateAcquisitionLocation() {
		return "The South Pole";
	}

	// Sets all incoming animals to INTAKE
	public static TrainingStatus generateTrainingStatus() {
		return TrainingStatus.INTAKE;
	}

	// TODO: Make dynamic with real-time locational data
	public static String generateInServiceCountry() {
		return "The North Pole";
	}
}