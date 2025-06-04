package rescueanimals;
import helpers.*;

public class Dog extends RescueAnimal {
	private String breed;

	// Constructors
	public Dog() {
		setAnimalType("dog");  // Ensures animalType is set
		setTrainingStatus(RescueAnimalHelper.generateTrainingStatus());
	}

	public Dog(String name, String breed, String gender, String age,
	String weight, String acquisitionDate, String acquisitionCountry,
	TrainingStatus trainingStatus, boolean reserved, String inServiceCountry) {
		setName(name);
		setBreed(breed);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);

		// Sets internal properties, not set by the user
		setAcquisitionDate(acquisitionDate != null ? acquisitionDate : RescueAnimalHelper.generateAcquisitionDate());
    setAcquisitionLocation(acquisitionCountry != null ? acquisitionCountry : RescueAnimalHelper.generateAcquisitionLocation());
    setInServiceCountry(inServiceCountry != null ? inServiceCountry : RescueAnimalHelper.generateInServiceCountry());

		setAnimalType("dog"); // Ensures animalType is set
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String dogBreed) {
		breed = dogBreed;
	}
}
