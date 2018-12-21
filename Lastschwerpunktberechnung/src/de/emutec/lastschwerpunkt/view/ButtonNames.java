package de.emutec.lastschwerpunkt.view;

public enum ButtonNames {
	HELP("?"),
	NEW_PROJECT("Neues Projekt"),
	LOAD_PROJECT("Projekt laden"),
	SAVE_PROJECT("Projekt speichern"),
	SAVE_PROJECT_AS("Projekt speichern unter..."),
	EXIT("Beenden"),
	ADD_BUILDING("Geb�ude hinzuf�gen"),
	EDIT_BUILDING("Geb�ude bearbeiten"),
	DELETE_BUILDING("Geb�ude l�schen"),
	ADD_SECTOR("Sektor hinzuf�gen"),
	EDIT_SECTOR("Sektor bearbeiten"),
	DELETE_SECTOR("Sektor l�schen"),
	ADD_IMAGE("Lageplan hinzuf�gen");
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
	 * private static final String ADD_BUILDING = "Geb�ude hinzuf�gen"; private
	 * static final String EDIT_BUILDING = "Geb�ude bearbeiten"; private static
	 * final String DELETE_BUILDING = "Geb�ude l�schen"; private static final String
	 * ADD_SECTOR = "Sektor hinzuf�gen"; private static final String EDIT_SECTOR =
	 * "Sektor bearbeiten"; private static final String DELETE_SECTOR =
	 * "Sektor l�schen"; private static final String ADD_IMAGE =
	 * "Lageplan hinzuf�gen";
	 */

	/**
	 * @return the s
	 */
	public String getS() {
		return s;
	}

}
