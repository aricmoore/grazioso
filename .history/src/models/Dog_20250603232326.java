package models;
import app.RescueAnimal;
import helpers.*;
import utils.Utils.Gender;
import utils.Utils.TrainingStatus;

public class Dog extends RescueAnimal {
	private String breed;

	// Default constructor
	public Dog() {
		setAnimalType("dog");  // Ensures animalType is set
		setTrainingStatus(RescueAnimalHelper.generateTrainingStatus());
	}

	// TODO: Consider different data types and validation
	// Detailed constructor
	public Dog(String name, String breed, Gender gender, String age,
						 String weight, boolean reserved, TrainingStatus trainingStatus,
						 String acquisitionDate, String acquisitionCountry, String inServiceCountry) {
		setName(name);
		setBreed(breed);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);

		// Sets metadata, generates values if not set by the user
		setAcquisitionDate(acquisitionDate != null ? acquisitionDate : RescueAnimalHelper.generateAcquisitionDate());
    setAcquisitionLocation(acquisitionCountry != null ? acquisitionCountry : RescueAnimalHelper.generateAcquisitionLocation());
    setInServiceCountry(inServiceCountry != null ? inServiceCountry : RescueAnimalHelper.generateInServiceCountry());

		setAnimalType("dog"); // Ensures animalType is set
	}

	@Override
	public String toString() {
		return String.format(
			"Name: %s, Breed: %s, Gender: %s, Age: %s, Weight: %s, Reserved: %s, Status: %s, Acquisition Date: %s, Acquisition Location: %s",
			getName(),
			getBreed(),
			getGender(),
			getAge(),
			getWeight(),
			getReserved(),
			getTrainingStatus(),
			getAcquisitionDate(),
			getAcquisitionLocation()    );
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String dogBreed) {
		breed = dogBreed;
	}
}
