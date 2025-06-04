package rescueanimals;
import java.util.HashSet;
import java.util.Set;
import helpers.*;

public class Monkey extends RescueAnimal {
	private String species;
	private String tailLength;
	private String height;
	private String bodyLength;

	// Eligible monkey species for training (lowercase for validation)
	private static final Set<String> VALID_SPECIES = new HashSet<>(Set.of(
			"capuchin", "guenon", "macaque", "marmoset", "squirrel monkey", "tamarin"
	));

	// Default constructor
	public Monkey() {
		setAnimalType("monkey"); // Ensures animalType is set
	}

	// Detailed constructor
	public Monkey(String name, String gender, String age,
								String weight, String species, String tailLength,
								String height, String bodyLength, boolean reserved) {
		setName(name);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setSpecies(species);
		setTailLength(tailLength);
		setHeight(height);
		setBodyLength(bodyLength);
		setReserved(reserved);

		// Sets internal properties, not set by the user
		setAcquisitionDate(acquisitionDate != null ? acquisitionDate : RescueAnimalHelper.generateAcquisitionDate());
    setAcquisitionLocation(acquisitionCountry != null ? acquisitionCountry : RescueAnimalHelper.generateAcquisitionLocation());
    setInServiceCountry(inServiceCountry != null ? inServiceCountry : RescueAnimalHelper.generateInServiceCountry());
		setAnimalType("monkey");
	}

	// Getter and Setter for species with validation
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		if (species == null) {
				throw new IllegalArgumentException("Species cannot be null");
		}
		String speciesFormatted = species.trim().toLowerCase();

		if (!VALID_SPECIES.contains(speciesFormatted)) {
				throw new IllegalArgumentException("Invalid species: " + species +
						". Valid species are: " + VALID_SPECIES);
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
