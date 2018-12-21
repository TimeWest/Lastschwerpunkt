package de.emutec.lastschwerpunkt.view;

public enum ButtonNames {
	HELP("?"),
	NEW_PROJECT("Neues Projekt"),
	LOAD_PROJECT("Projekt laden"),
	SAVE_PROJECT("Projekt speichern"),
	SAVE_PROJECT_AS("Projekt speichern unter..."),
	EXIT("Beenden"),
	ADD_BUILDING("Gebäude hinzufügen"),
	EDIT_BUILDING("Gebäude bearbeiten"),
	DELETE_BUILDING("Gebäude löschen"),
	ADD_SECTOR("Sektor hinzufügen"),
	EDIT_SECTOR("Sektor bearbeiten"),
	DELETE_SECTOR("Sektor löschen"),
	ADD_IMAGE("Lageplan hinzufügen");
	private String s;

	private ButtonNames(String s) {
		this.s = s;
	}
	/*
	 * private static final String HELP = "?"; private static final String
	 * NEW_PROJECT = "Neues Projekt"; private static final String LOAD_PROJECT =
	 * "Projekt laden"; private static final String SAVE_PROJECT =
	 * "Projekt speichern"; private static final String SAVE_PROJECT_AS =
	 * "Projekt speichern unter..."; private static final String EXIT = "Beenden";
	 * private static final String ADD_BUILDING = "Gebäude hinzufügen"; private
	 * static final String EDIT_BUILDING = "Gebäude bearbeiten"; private static
	 * final String DELETE_BUILDING = "Gebäude löschen"; private static final String
	 * ADD_SECTOR = "Sektor hinzufügen"; private static final String EDIT_SECTOR =
	 * "Sektor bearbeiten"; private static final String DELETE_SECTOR =
	 * "Sektor löschen"; private static final String ADD_IMAGE =
	 * "Lageplan hinzufügen";
	 */

	/**
	 * @return the s
	 */
	public String getS() {
		return s;
	}

}
