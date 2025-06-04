package models;
import app.RescueAnimal;
import helpers.*;
import app.TrainingStatus;

public class Monkey extends RescueAnimal {
	private String species;
	private String tailLength;
	private String height;
	private String bodyLength;
	private String gender;

	// Default constructor
	public Monkey() {
		setAnimalType("monkey"); 														// Ensures animalType is set
		setTrainingStatus(RescueAnimalHelper.generateTrainingStatus()); // Sets trainingStatus to INTAKE
	}

	// TODO: Consider different data types and validation
	// Detailed constructor
	public Monkey(String name, String gender, String age, String weight, String species, String tailLength,
								String height, String bodyLength, boolean reserved, TrainingStatus trainingStatus,
								String acquisitionDate, String acquisitionCountry, String inServiceCountry) {
		// Restricts gender to M or F
		if (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")) {
			throw new IllegalArgumentException("Gender must be 'M' or 'F'");
		}

		setName(name);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setSpecies(species);
		setTailLength(tailLength);
		setHeight(height);
		setBodyLength(bodyLength);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);

		// Sets metadata, generates values if not set by the user
		setAcquisitionDate(acquisitionDate != null ? acquisitionDate : RescueAnimalHelper.generateAcquisitionDate());
    setAcquisitionLocation(acquisitionCountry != null ? acquisitionCountry : RescueAnimalHelper.generateAcquisitionLocation());
    setInServiceCountry(inServiceCountry != null ? inServiceCountry : RescueAnimalHelper.generateInServiceCountry());

		setAnimalType("monkey"); // Ensures animalType is set
	}

	@Override
	public String toString() {
			return String.format(
				"Name: %s, Gender: %s, Age: %s, Weight: %s, Species: %s, Tail Length: %s, Height: %s, Body Length: %s, Reserved: %s, Training Status: %s, Acquisition Date: %s, Acquisition Country: %s, In Service Country: %s",
				getName(),
				getGender(),
				getAge(),
				getWeight(),
				getSpecies(),
				getTailLength(),
				getHeight(),
				getBodyLength(),
				getReserved(),
				getTrainingStatus(),
				getAcquisitionDate(),
				getAcquisitionLocation(),
				getInServiceCountry()
			);
	}


	public String getSpecies() {
		return species;
	}

	// Sets species with validation
	public void setSpecies(String species) {
		if (species == null) {
				throw new IllegalArgumentException("Species cannot be null");
		}
		String speciesFormatted = species.trim().toLowerCase();

		if (!RescueAnimalHelper.VALID_SPECIES.contains(speciesFormatted)) {
				throw new IllegalArgumentException("Invalid species: " + species +
						". Valid species are: " + RescueAnimalHelper.VALID_SPECIES);
		}

		this.species = speciesFormatted;
	}

	public String getTailLength() {
		return tailLength;
	}

	public void setTailLength(String tailLength) {
		this.tailLength = tailLength;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getBodyLength() {
		return bodyLength;
	}

	public void setBodyLength(String bodyLength) {
		this.bodyLength = bodyLength;
	}
}
