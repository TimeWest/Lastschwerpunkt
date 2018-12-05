package de.emutec.lastschwerpunkt.workwindow;

import java.awt.event.*;
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
		this.mainWindow.btnEditBuildingListener(new EditBuildingListener());
		this.mainWindow.btnDelBuildingListener(new DeleteBuildingListener());
		this.mainWindow.btnAddBuildingListener(new AddBuildingListener());
		this.mainWindow.btnAddSectorListener(new AddSectorListener());
		this.mainWindow.btnEditSectorListener(new EditSectorListener());
		this.mainWindow.btnDelSectorListener(new DeleteSectorListener());
	}

	class AddBuildingListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO First set buildings position by clicking on the map
			edit = new ControllEditBuilding(buildingCollection);
		}

	}

	class EditBuildingListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO get the selected building from BuildingsCollection and give it to
			// ControllEditBuilding(Building building);
			
			new ControllEditBuilding(buildingCollection);
		}
	}

	class DeleteBuildingListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Get the selected building and delete it.
		}

	}

	class AddSectorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				new ControllEditSector(sectorCollection);
			} catch (Exception e) {

			}

		}

	}

	class EditSectorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				new ControllEditSector(sectorCollection);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	class DeleteSectorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
	
}