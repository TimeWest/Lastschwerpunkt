package de.emutec.lastschwerpunkt.view;

import de.emutec.lastschwerpunkt.datahandling.DataType;

public class EditWindowFactory {

	private EditWindowFactory() {
	}

	public static EditingWindow getInstance(DataType type) {

		switch (type) {
		case BUILDING:
			return new EditBuilding();
		case SECTOR:
			return new EditSector();
		default:
			throw new IllegalArgumentException();
		}
	}
}
