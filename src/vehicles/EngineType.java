package vehicles;

import java.util.InputMismatchException;

public enum EngineType {
	BENZINE, SOLAR;

	public static EngineType fromInteger(int type) {
		if (type == 1)
			return BENZINE;
		else if (type == 2)
			return SOLAR;
		else
			throw new InputMismatchException();
	}
}
