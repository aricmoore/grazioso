package rescueanimals;
import java.util.ArrayList;
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
	public static void displayMenu() {
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
	public static void initializeDogList() {
		Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", false, RescueAnimal.TrainingStatus.INTAKE, "05-12-2019", "United States", "United States");
		Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", false, RescueAnimal.TrainingStatus.PHASE_I, "02-03-2020", "United States", "United States");
		Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", true, RescueAnimal.TrainingStatus.IN_SERVICE, "12-12-2019", "Canada", "Canada");


		dogList.add(dog1);
		dogList.add(dog2);
		dogList.add(dog3);
	}


	// Adds monkeys to a list for testing
	public static void initializeMonkeyList() {
		Monkey monkey1 = new Monkey("Bojangles", "female", "10", "46.7", "macaque", "2.3", "3.2", "100", true, RescueAnimal.TrainingStatus.INTAKE, "12-12-2019", "Canada", "Canada");
		Monkey monkey2 = new Monkey("Alabaster Jones", "male", "35", "56.2", "guenon", "4.3", "5.6", "234", false, RescueAnimal.TrainingStatus.PHASE_I, "02-03-2020", "United States", "United States");
		Monkey monkey3 = new Monkey("Steve", "female", "200", "77.3", "capuchin", "2.6", "4.5", "201", true, RescueAnimal.TrainingStatus.INTAKE, "12-12-2019", "Canada", "Canada");


		monkeyList.add(monkey1);
		monkeyList.add(monkey2);
		monkeyList.add(monkey3);
	}

	public static void intakeNewDog(Scanner scanner) {
		System.out.println("What is the dog's name?");
		String name = scanner.nextLine();

		for (Dog dog: dogList) {
			if (dog.getName().equalsIgnoreCase(name)) {
					System.out.println("\n\nThis dog is already in our system\n\n");
					return; //returns to menu
			}
		}

		// Add the code to instantiate a new dog and add it to the appropriate list
		Dog incomingDog = new Dog();
		incomingDog.setName(name);
		System.out.println("What is the dog's breed?");
		incomingDog.setName(scanner.nextLine().trim());
		System.out.println("What is the dog's gender? M/F");
		incomingDog.setGender(scanner.nextLine().trim());
		System.out.println("What is the dog's age?");
		incomingDog.setAge(scanner.nextLine());
		System.out.println("What is the dog's weight?");
		incomingDog.setWeight(scanner.nextLine());

		// Set metadata
		incomingDog.setAcquisitionDate(RescueAnimalHelper.generateAcquisitionDate());
		incomingDog.setAcquisitionLocation(RescueAnimalHelper.generateAcquisitionLocation());
		incomingDog.setTrainingStatus(RescueAnimalHelper.generateTrainingStatus());
		incomingDog.setReserved(false);
		incomingDog.setInServiceCountry(RescueAnimalHelper.generateInServiceCountry());

		dogList.add(incomingDog);
		System.out.println("\nDog successfully added to the system.\n");
	}


	// Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
	// For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
	public static void intakeNewMonkey(Scanner scanner) {
		System.out.println("What is the monkey's name?");
		String name = scanner.nextLine();

		for (Monkey monkey: monkeyList) {
			if (monkey.getName().equalsIgnoreCase(name)) {
					System.out.println("\n\nThis monkey is already in our system\n\n");
					return; // Exit method, ask for menu input again
			}
		}

		System.out.println("What is the monkey's species?");
    String species = scanner.nextLine().trim().toLowerCase();

    // Validate eligible species
    if (!RescueAnimalHelper.VALID_SPECIES.contains(species)) {
        System.out.println("\n\nInvalid species. Allowed species are: " + RescueAnimalHelper.VALID_SPECIES + "\n\n");
        return; // Exit method, ask for menu input again
    }

    System.out.println("What is the monkey's gender? (M/F)");
    String gender = scanner.nextLine().trim();

    System.out.println("What is the monkey's age?");
    String age = scanner.nextLine().trim();

    System.out.println("What is the monkey's weight?");
    String weight = scanner.nextLine().trim();

    System.out.println("What is the monkey's tail length?");
    double tailLength = Double.parseDouble(scanner.nextLine().trim());

    System.out.println("What is the monkey's height?");
    double height = Double.parseDouble(scanner.nextLine().trim());

    System.out.println("What is the monkey's body length?");
    double bodyLength = Double.parseDouble(scanner.nextLine().trim());

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
    System.out.println("\nMonkey successfully added to the system.\n");
	}

	// Complete reserveAnimal
	// You will need to find the animal by animal type and in service country
	public static void reserveAnimal(Scanner scanner) {
		System.out.println("The method reserveAnimal needs to be implemented");

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
	public static void printAnimals(String input) {
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
				System.out.println("List of all available (not reserved) animals:");
				// Loop through both lists and print only animals not reserved
				for (Dog dog : dogList) {
					if (!dog.getName().equalsIgnoreCase(name)) {
						System.out.println(dog);
					}
				}
				for (Monkey monkey : monkeyList) {
					if (!monkey.getName().equalsIgnoreCase(name)) {
						System.out.println(monkey);
					}
				}
				break;
			default:
				System.out.println("Invalid animal print selection.");
				break;
		}
	}
}

