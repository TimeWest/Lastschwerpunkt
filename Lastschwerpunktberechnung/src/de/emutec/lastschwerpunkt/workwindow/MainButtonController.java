package de.emutec.lastschwerpunkt.workwindow;

import java.awt.event.*;

import javax.swing.JFileChooser;
import javax.swing.tree.*;
import de.emutec.lastschwerpunkt.building.BuildingCollection;
import de.emutec.lastschwerpunkt.building.ControllEditBuilding;
import de.emutec.lastschwerpunkt.sector.ControllEditSector;
import de.emutec.lastschwerpunkt.sector.SectorCollection;

public class MainButtonController {

	private MainWindow mainWindow;
	private BuildingCollection buildingCollection;
	private SectorCollection sectorCollection;
	private ControllEditBuilding edit;

	// Constructor
	public MainButtonController(MainWindow mainWindow, BuildingCollection buildingCollection,
			SectorCollection sectorCollection) {
		this.mainWindow = mainWindow;
		this.buildingCollection = buildingCollection;
		this.sectorCollection = sectorCollection;
		this.mainWindow.btnListener(new ButtonListener());

	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("addBuilding")) {
				edit = new ControllEditBuilding(buildingCollection);
			}

			if (e.getActionCommand().equals("editBuilding")) {
				new ControllEditBuilding(buildingCollection);
			}

			if (e.getActionCommand().equals("deleteBuilding")) {
				// TODO get the selected Object from tree and ask if sure, then delete
			}

			if (e.getActionCommand().equals("addSector")) {
				new ControllEditSector(sectorCollection);
			}

			if (e.getActionCommand().equals("editSector")) {
				new ControllEditSector(sectorCollection);
			}

			if (e.getActionCommand().equals("addSector")) {
				// TODO get the selected Sector from tree and ask if sure, then delete
			}

		}

	}

}