package app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import helpers.RescueAnimalHelper;
import models.Dog;
import models.Monkey;
import utils.Utils.Gender;
import utils.Utils.TrainingStatus;

public class Driver {
	private static ArrayList<Dog> dogList = new ArrayList<Dog>();
	private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
	private static String input;

	public static void main(String[] args) {
		initializeDogList();
		initializeMonkeyList();
		Scanner scnr = new Scanner(System.in);

		while (true) {
			displayMenu();
			input = scnr.nextLine().trim().toLowerCase();

			// Exits the programme when the user quits
			if (input.equals("q")) {
				System.out.println("Exiting Rescue Animal System. Bye now!");
				break;
			}

			System.out.println("[DEBUG] Raw user input: " + input);
			switch (input) {
				case "1":
					intakeNewDog(scnr);
					break;
				case "2":
					intakeNewMonkey(scnr);
					break;
				case "3":
					reserveAnimal(scnr);
					break;
				case "4":
				case "5":
				case "6":
					printAnimals(input);
					break;
				case "7":
					for (Dog dog : dogList) {
						System.out.println(dog);
					}
					break;
				case "8":
					for (Monkey monkey: monkeyList) {
						System.out.println(monkey);
					}
					break;
				default:
					System.out.println("Invalid option. Please try again.");
					break;
			}
		}

		// Add a loop that displays the menu, accepts the users input
		// and takes the appropriate action.
		// For the project submission you must also include input validation
		// and appropriate feedback to the user.
		// Hint: create a Scanner and pass it to the necessary
		// methods
		// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.
	}

	// This method prints the menu options
	private static void displayMenu() {
		System.out.println("\n\n");
		System.out.println("\t\t\t\tRescue Animal System Menu");
		System.out.println("[1] Intake a new dog");
		System.out.println("[2] Intake a new monkey");
		System.out.println("[3] Reserve an animal");
		System.out.println("[4] Print a list of all dogs");
		System.out.println("[5] Print a list of all monkeys");
		System.out.println("[6] Print a list of all animals that are not reserved");
		System.out.println("[q] Quit application");
		System.out.println();
		System.out.println("Enter a menu selection");
	}


	// Adds dogs to a list for testing
	private static void initializeDogList() {
		Dog dog1 = new Dog("Spot", "German Shepherd", Gender.M, "1", "25.6", false, TrainingStatus.IN_SERVICE, "05-12-2019", "United States", "United States");
		Dog dog2 = new Dog("Rex", "Great Dane", Gender.M, "3", "35.2", false, TrainingStatus.PHASE_III, "02-03-2020", "United States", "United States");
		Dog dog3 = new Dog("Bella", "Chihuahua", Gender.F, "4", "25.6", true, TrainingStatus.IN_SERVICE, "12-12-2019", "Canada", "Canada");

		dogList.add(dog1);
		dogList.add(dog2);
		dogList.add(dog3);
	}


	// Adds monkeys to a list for testing
	private static void initializeMonkeyList() {
		Monkey monkey1 = new Monkey("Bojangles", Gender.F, "10", "46.7", "macaque", "2.3", "3.2", "100", false, TrainingStatus.IN_SERVICE, "12-12-2019", "Canada", "Canada");
		Monkey monkey2 = new Monkey("Alabaster Jones", Gender.M, "35", "56.2", "guenon", "4.3", "5.6", "234", false, TrainingStatus.PHASE_I, "02-03-2020", "United States", "United States");
		Monkey monkey3 = new Monkey("Steve", Gender.F, "200", "77.3", "capuchin", "2.6", "4.5", "201", true, TrainingStatus.INTAKE, "12-12-2019", "Canada", "Canada");

		monkeyList.add(monkey1);
		monkeyList.add(monkey2);
		monkeyList.add(monkey3);
	}

	private static void intakeNewDog(Scanner scanner) {
		System.out.println("What is the dog's name?");
		String name = scanner.nextLine();

		// Returns the user to the main menu if the dog name is found in the system
		for (Dog dog: dogList) {
			if (dog.getName().equalsIgnoreCase(name)) {
					System.out.println("This dog is already in our system.");
					return;
			}
		}

		System.out.println("What is the dog's breed?");
		String breed = scanner.nextLine().trim();

		// Uses existing scanner to prompt for gender
		Gender gender = RescueAnimalHelper.promptForGender(scanner, "dog");

		System.out.println("What is the dog's age?");
		String age = scanner.nextLine();

		System.out.println("What is the dog's weight?");
		String weight = scanner.nextLine();

		// Instantiates new Dog object with all input data (metadata is set in the Dog class)
		Dog newDog = new Dog(
			name,
			breed,
			gender,
			age,
			weight,
			false,
			TrainingStatus.INTAKE,
			null,
			null,
			null
		);

		dogList.add(newDog);
		System.out.println("Dog successfully added to the system.");
	}


	// Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
	// For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
	private static void intakeNewMonkey(Scanner scanner) {
		System.out.println("What is the monkey's name?");
		String name = scanner.nextLine();

		// Returns the user to the main menu if the monkey name is found in the system
		for (Monkey monkey: monkeyList) {
			if (monkey.getName().equalsIgnoreCase(name)) {
					System.out.println("This monkey is already in our system.");
					return;
			}
		}

		System.out.println("What is the monkey's species?");
    String species = scanner.nextLine().trim().toLowerCase();

    // Returns the user to the main menu if the species entered is invalid
    if (!RescueAnimalHelper.VALID_SPECIES.contains(species)) {
        System.out.println("Invalid species. Allowed species are: " + RescueAnimalHelper.VALID_SPECIES);
        return;
    }

		// Uses existing scanner to prompt for gender
    Gender gender = RescueAnimalHelper.promptForGender(scanner, "monkey");

    System.out.println("What is the monkey's age?");
    String age = scanner.nextLine().trim();

    System.out.println("What is the monkey's weight?");
    String weight = scanner.nextLine().trim();

    System.out.println("What is the monkey's tail length?");
    String tailLength = scanner.nextLine().trim();

    System.out.println("What is the monkey's height?");
    String height = scanner.nextLine().trim();

    System.out.println("What is the monkey's body length?");
    String bodyLength = scanner.nextLine().trim();

    // Instantiates new Monkey object with all input data (metadata is set in the Monkey class)
    Monkey newMonkey = new Monkey(
			name,
			gender,
			age,
			weight,
			species,
			tailLength,
			height,
			bodyLength,
			false,
			TrainingStatus.INTAKE,
			null,
			null,
			null
    );

    monkeyList.add(newMonkey);
    System.out.println("Monkey successfully added to the system.");
	}

	private static void reserveAnimal(Scanner scanner) {
    System.out.print("Enter animal type (dog/monkey):");
    String animalType = scanner.nextLine().trim().toLowerCase();

    System.out.print("Enter in-service country:");
    String country = scanner.nextLine().trim();

    boolean found = false;

		switch (animalType) {
			case "dog":
				found = reserveAvailableAnimal(animalType, country, dogList);
				break;
			case "monkey":
				found = reserveAvailableAnimal(animalType, country, monkeyList);
				break;
			default:
				System.out.println("Invalid animal type entered. Please enter 'dog' or 'monkey'.");
				return;
		}

    if (!found) {
        System.out.println("No available " + animalType + " found in " + country + " to reserve.");
    }
	}

	// Checks if animal is both not reserved and in the requested country
	// Only reserves the first matching animal
	private static boolean reserveAvailableAnimal(String animalType, String country, List<? extends RescueAnimal> animalList) {
    for (RescueAnimal animal : animalList) {
			if (!animal.getReserved() && animal.getInServiceCountry().equalsIgnoreCase(country)) {
				animal.setReserved(true);
				String animalTypeFormatted = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
				System.out.println(animalTypeFormatted + " " + animal.getName() + " has been reserved.");
				return true;
			}
    }
    return false;
	}

	private static void printAnimals(String input) {
		switch (input) {
			case "4":
				System.out.println("List of all dogs:");
				printAnimalTable(dogList);
				break;
			case "5":
				System.out.println("List of all monkeys:");
				printAnimalTable(monkeyList);
				break;
			case "6":
				System.out.println("List of all available (in service and not reserved) animals:\n");
				printAvailableAnimalsByType("dog");
				printAvailableAnimalsByType("monkey");
				break;
			default:
				System.out.println("Invalid animal print selection.");
				break;
		}
	}

	// Prints a formatted table for a list of RescueAnimals
	private static void printAnimalTable(List<? extends RescueAnimal> animals) {
		// Handles the empty list case
		if (animals.isEmpty()) {
			System.out.println("No animals to display.\n");
			return;
		}

		System.out.printf("%-15s %-14s %-22s %-10s%n", "Name", "Status", "Acquisition Country", "Reserved");
		System.out.println("---------------------------------------------------------------");
		for (RescueAnimal animal : animals) {
			System.out.printf("%-15s %-14s %-22s %-10s%n",
				animal.getName(),
				animal.getTrainingStatus(),
				animal.getAcquisitionLocation(),
				animal.getReserved());
		}
		System.out.println();
	}

	private static void printAvailableAnimalsByType(String animalType) {
		System.out.printf("Available %ss:%n", animalType.substring(0, 1).toUpperCase() + animalType.substring(1).toLowerCase());

		// Reads from a list of RescueAnimal subclasses before knowing which is passed as an arg
		List<? extends RescueAnimal> animalsToCheck;

		if (animalType.equalsIgnoreCase("dog")) {
			animalsToCheck = dogList;
		} else if (animalType.equalsIgnoreCase("monkey")) {
			animalsToCheck = monkeyList;
		} else {
			System.out.println("Invalid animal type.");
			return;
		}

		// Instantiates list of available animals to print later
		List<RescueAnimal> availableAnimals = new ArrayList<>();
		for (RescueAnimal animal : animalsToCheck) {
			// Only adds the animal if it is IN_SERVICE and not reserved
			if (!animal.getReserved() && animal.getTrainingStatus() == TrainingStatus.IN_SERVICE) {
				availableAnimals.add(animal);
			}
		}

		printAnimalTable(availableAnimals);
	}
}

