package helpers;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import utils.Utils.AnimalType;
import utils.Utils.Gender;
import utils.Utils.TrainingStatus;

public class RescueAnimalHelper {

	// Eligible monkey species for training (lowercase for validation)
	public static final Set<String> VALID_SPECIES = new HashSet<>(Set.of(
			"capuchin", "guenon", "macaque", "marmoset", "squirrel monkey", "tamarin"
	));

	// Returns current date in ISO format (e.g., 2025-06-02)
	public static String generateAcquisitionDate() {
		return LocalDate.now().toString();
	}

	// Sets all incoming animals to INTAKE
	public static TrainingStatus generateTrainingStatus() {
		return TrainingStatus.INTAKE;
	}

	// TODO: Make dynamic with real-time locational data
	public static String generateAcquisitionLocation() {
		return "The South Pole";
	}

	// TODO: Make dynamic with real-time locational data
	public static String generateInServiceCountry() {
		return "The North Pole";
	}

	// Loops until the user enters a valid value for gender, M or F (case insensitive)
	public static Gender promptForGender(Scanner scanner, String animalType) {
		Gender genderEnum = null;
		while (genderEnum == null) {
			System.out.printf("What is the %s's gender? M/F%n", animalType);
			String genderInput = scanner.nextLine().trim().toUpperCase();

			try {
				genderEnum = Gender.valueOf(genderInput);
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid input. Please enter 'M' or 'F'.");
			}
		}

		return genderEnum;
	}

	// Loops until the user enters a valid value for species from set (case insensitive)
	public static String promptForSpecies(Scanner scanner) {
    String species = null;
    while (species == null) {
			System.out.println("Enter the monkey's species (valid options: capuchin, guenon, macaque, marmoset, squirrel monkey, tamarin):");
			String input = scanner.nextLine().trim().toLowerCase();

			if (VALID_SPECIES.contains(input)) {
				species = input;
			} else {
				System.out.println("Invalid species. Please enter one of the valid species.");
			}
		}

		return species;
	}

	// Loops until the user enters a valid value for name
	public static String promptValidName(Scanner scanner, AnimalType animalType) {
		String name;

		while (true) {
			System.out.println("What is the " + animalType.name().toLowerCase() + "'s name?");
			name = scanner.nextLine();

			if (isValidName(name)) {
				return name;
			} else {
				System.out.println("Invalid name. Please use letters only, no numbers or special characters.");
			}
		}
	}

	// Validates animal name to ensure that no numbers or special chars are submitted
	public static boolean isValidName(String name) {
    return name != null && name.trim().matches("^[a-zA-Z]+$");
	}
}