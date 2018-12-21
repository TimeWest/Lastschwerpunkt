package de.emutec.lastschwerpunkt.controller;

import de.emutec.lastschwerpunkt.editing.ControllEditBuilding;
import de.emutec.lastschwerpunkt.editing.ControllEditSector;
import de.emutec.lastschwerpunkt.view.MainWindow;

public class MainButtonController {

	private MainWindow mainWindow;

	// Constructor
	public MainButtonController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.mainWindow.buttonListener(e -> {

			if (e.getActionCommand().equals("addBuilding"))
				new ControllEditBuilding(EditingType.ADD);
			
			if (e.getActionCommand().equals("editBuilding"))
				new ControllEditBuilding(EditingType.EDIT);

			if (e.getActionCommand().equals("deleteBuilding"))
				// TODO get the selected Object from tree and ask if sure, then delete
				new ControllEditBuilding(EditingType.DELETE);

			if (e.getActionCommand().equals("addSector"))
				new ControllEditSector(EditingType.ADD);

			if (e.getActionCommand().equals("editSector"))
				new ControllEditSector(EditingType.EDIT);

			if (e.getActionCommand().equals("addSector"))
				// TODO get the selected Sector from tree and ask if sure, then delete
				new ControllEditSector(EditingType.DELETE);

		});
	}

}