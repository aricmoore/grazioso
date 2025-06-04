package helpers;
import java.time.LocalDate;
import rescueanimals.RescueAnimal.TrainingStatus;

public class RescueAnimalHelper {

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