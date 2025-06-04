package utils;

public class Utils {

	public enum AnimalType {
    DOG, MONKEY;

		// For display or input parsing
    @Override
    public String toString() {
      return name().toLowerCase();
    }

    public static AnimalType fromString(String value) {
      return AnimalType.valueOf(value.trim().toUpperCase());
    }
	}

	public enum TrainingStatus {
    INTAKE,
    PHASE_I,
    PHASE_II,
    PHASE_III,
    PHASE_IV,
    PHASE_V,
    IN_SERVICE,
    FARM
	}

	public enum Gender {
    M, F;
	}
}
