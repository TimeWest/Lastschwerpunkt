package de.emutec.lastschwerpunkt.workwindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.emutec.lastschwerpunkt.building.ControllEditBuilding;
import de.emutec.lastschwerpunkt.sector.ControllEditSector;

public class MainButtonController {

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("addBuilding")) {
				new ControllEditBuilding().newBuilding();
			}

			if (e.getActionCommand().equals("editBuilding")) {
				new ControllEditBuilding().editBuilding();
			}

			if (e.getActionCommand().equals("deleteBuilding")) {
				// TODO get the selected Object from tree and ask if sure, then delete
				new ControllEditBuilding().deleteBuilding();
			}

			if (e.getActionCommand().equals("addSector")) {
				new ControllEditSector().newSector();
			}

			if (e.getActionCommand().equals("editSector")) {
				new ControllEditSector().editSector();
			}

			if (e.getActionCommand().equals("addSector")) {
				// TODO get the selected Sector from tree and ask if sure, then delete
				new ControllEditSector().deleteSector();
			}

		}

	}

	private MainWindow mainWindow;

	// Constructor
	public MainButtonController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.mainWindow.btnListener(new ButtonListener());
	}

}