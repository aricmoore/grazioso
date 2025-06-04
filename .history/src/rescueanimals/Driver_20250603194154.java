package rescueanimals;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import helpers.RescueAnimalHelper;

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

			if (input.equals("q")) {
				System.out.println("Exiting Rescue Animal System. Goodbye!");
				break;
			}

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
		Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", false, RescueAnimal.TrainingStatus.INTAKE, "05-12-2019", "United States", "United States");
		Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", false, RescueAnimal.TrainingStatus.PHASE_I, "02-03-2020", "United States", "United States");
		Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", true, RescueAnimal.TrainingStatus.IN_SERVICE, "12-12-2019", "Canada", "Canada");


		dogList.add(dog1);
		dogList.add(dog2);
		dogList.add(dog3);
	}


	// Adds monkeys to a list for testing
	private static void initializeMonkeyList() {
		Monkey monkey1 = new Monkey("Bojangles", "female", "10", "46.7", "macaque", "2.3", "3.2", "100", true, RescueAnimal.TrainingStatus.INTAKE, "12-12-2019", "Canada", "Canada");
		Monkey monkey2 = new Monkey("Alabaster Jones", "male", "35", "56.2", "guenon", "4.3", "5.6", "234", false, RescueAnimal.TrainingStatus.PHASE_I, "02-03-2020", "United States", "United States");
		Monkey monkey3 = new Monkey("Steve", "female", "200", "77.3", "capuchin", "2.6", "4.5", "201", true, RescueAnimal.TrainingStatus.INTAKE, "12-12-2019", "Canada", "Canada");


		monkeyList.add(monkey1);
		monkeyList.add(monkey2);
		monkeyList.add(monkey3);
	}

	private static void intakeNewDog(Scanner scanner) {
		System.out.println("What is the dog's name?");
		String name = scanner.nextLine();

		for (Dog dog: dogList) {
			if (dog.getName().equalsIgnoreCase(name)) {
					System.out.println("This dog is already in our system");
					return; //returns to menu
			}
		}

		// Add the code to instantiate a new dog and add it to the appropriate list
		Dog newDog = new Dog();
		newDog.setName(name);
		System.out.println("What is the dog's breed?");
		newDog.setBreed(scanner.nextLine().trim());
		System.out.println("What is the dog's gender? M/F");
		newDog.setGender(scanner.nextLine().trim());
		System.out.println("What is the dog's age?");
		newDog.setAge(scanner.nextLine());
		System.out.println("What is the dog's weight?");
		newDog.setWeight(scanner.nextLine());

		// Set metadata
		newDog.setAcquisitionDate(RescueAnimalHelper.generateAcquisitionDate());
		newDog.setAcquisitionLocation(RescueAnimalHelper.generateAcquisitionLocation());
		newDog.setTrainingStatus(RescueAnimalHelper.generateTrainingStatus());
		newDog.setReserved(false);
		newDog.setInServiceCountry(RescueAnimalHelper.generateInServiceCountry());

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

		for (Monkey monkey: monkeyList) {
			if (monkey.getName().equalsIgnoreCase(name)) {
					System.out.println("This monkey is already in our system");
					return; // Exit method, ask for menu input again
			}
		}

		System.out.println("What is the monkey's species?");
    String species = scanner.nextLine().trim().toLowerCase();

    // Validate eligible species
    if (!RescueAnimalHelper.VALID_SPECIES.contains(species)) {
        System.out.println("Invalid species. Allowed species are: " + RescueAnimalHelper.VALID_SPECIES);
        return; // Exit method, ask for menu input again
    }

    System.out.println("What is the monkey's gender? (M/F)");
    String gender = scanner.nextLine().trim();

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

    // Instantiate new Monkey object with all input data
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
			RescueAnimal.TrainingStatus.INTAKE,
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

		// Checks if animal is both not reserved and in the requested country
		// Only reserves the first matching animal
    if (animalType.equals("dog")) {
        for (Dog dog : dogList) {
            if (!dog.getReserved() && dog.getInServiceCountry().equalsIgnoreCase(country)) {
                dog.setReserved(true);
                System.out.println("Dog " + dog.getName() + " has been reserved.");
                found = true;
                break;
            }
        }
    } else if (animalType.equals("monkey")) {
        for (Monkey monkey : monkeyList) {
            if (!monkey.getReserved() && monkey.getInServiceCountry().equalsIgnoreCase(country)) {
                monkey.setReserved(true);
                System.out.println("Monkey " + monkey.getName() + " has been reserved.");
                found = true;
                break;
            }
        }
    } else {
        System.out.println("Invalid animal type entered. Please enter 'dog' or 'monkey'.");
        return;
    }

    if (!found) {
        System.out.println("No available " + animalType + " found in " + country + " to reserve.");
    }
	}


	// Complete printAnimals
	// Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
	// The printAnimals() method has three different outputs
	// based on the listType parameter
	// dog - prints the list of dogs
	// monkey - prints the list of monkeys
	// available - prints a combined list of all animals that are
	// fully trained ("in service") but not reserved
	// Remember that you only have to fully implement ONE of these lists.
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
	private static void printAnimals(String input) {
		switch (input) {
			case "4":
				System.out.println("List of all dogs:");
				for (Dog dog : dogList) {
					System.out.println(dog);
				}
				break;
			case "5":
				System.out.println("List of all monkeys:");
				for (Monkey monkey : monkeyList) {
					System.out.println(monkey);
				}
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
			if (!animal.getReserved() && animal.getTrainingStatus() == RescueAnimal.TrainingStatus.IN_SERVICE) {
				availableAnimals.add(animal);
			}
		}

		// Handles the empty list case
		if (availableAnimals.isEmpty()) {
			System.out.println("No available " + animalType + "s found.\n");
			return;
		}

		// Prints the available animal list in a formatted table displaying necessary data
		System.out.printf("%-15s %-14s %-22s %-10s%n", "Name", "Status", "Acquisition Country", "Reserved");
		System.out.println("---------------------------------------------------------------");
		for (RescueAnimal animal : availableAnimals) {
			System.out.printf("%-15s %-14s %-22s %-10s%n",
				animal.getName(),
				animal.getTrainingStatus(),
				animal.getAcquisitionLocation(),
				animal.getReserved());
		}
		System.out.println();
	}

}

