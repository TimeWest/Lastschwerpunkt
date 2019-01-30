package de.emutec.lastschwerpunkt.model.data;

public class DataFactory {

	private static final String BUILDING = "building";
	private static final String SECTOR = "sector";

	private DataFactory() {
	}

	public static Data getInstance(String type) {

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
