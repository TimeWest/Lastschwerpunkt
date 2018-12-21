package de.emutec.lastschwerpunkt.datahandling;

public class DataFactory {

	private DataFactory() {
	}

	public static Data getInstance(DataType type) {

		switch (type) {
		case BUILDING:
			return new Building();
		case SECTOR:
			return new Sector();
		default:
			throw new IllegalArgumentException("Valid DataType expected.");
		}
	}
}
