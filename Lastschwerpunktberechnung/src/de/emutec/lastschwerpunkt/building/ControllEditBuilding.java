package de.emutec.lastschwerpunkt.building;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class ControllEditBuilding {
	private EditBuilding window;
	private Building building;
	private BuildingCollection collection;

	// Constructor for adding a new Building
	public ControllEditBuilding(BuildingCollection collection) {
		this.window = new EditBuilding();
		this.building = new Building();
		this.collection = collection;
		this.window.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.window.addOkButtonListener(new OkBtnListener());
		this.window.addCancelButtonListener(new CancelBtnListener());
		this.window.setVisible(true);
	}

	// Constructor for editing an existing building
	public ControllEditBuilding(BuildingCollection collection, Building building) {
		this.window = new EditBuilding();
		this.building = building;
		this.collection = collection;
		this.window.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		window.setTxtGebudeName(building.getGebName());
		window.setTxtGebudeNummer(building.getGebNumber());
		window.setTxtGLF(building.getGlf());
		window.setTxtLoad(building.getLoad());
		window.setTxtrBeschreibung(building.getDescription());
		window.setTxtXcoordinate(building.getCoordinates()[0]);
		window.setTxtYcoordinate(building.getCoordinates()[1]);
		window.setSpinnerSector(building.getSector());
		window.setChkbxIsActive(building.isActive());
		this.window.setVisible(true);
	}

	class OkBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				building = new Building();
				building.setGebName(window.getTxtGebudeName());
				building.setGebNumber(window.getTxtGebudeNummer());
				building.setGlf(window.getTxtGLF());
				building.setLoad(window.getTxtLoad());
				building.setDescription(window.getTxtrBeschreibung());
				building.setCoordinates(window.getTxtXcoordinate(), window.getTxtYcoordinate());
				building.setSector(window.getSpinnerSector());
				building.setActive(window.getChkbxIsActive());
				window.dispose();
				collection.addBuilding(building);

			} catch (Exception e) {
				window.displayNumberError("Fehler! Konnte Gebäude nicht speichern.\nBitte Eingaben überprüfen");
			}

		}

	}

	class CancelBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Einfügen, dass bei vorliegenden Änderungen diese wirklich verworfen
			// werden sollen
			window.dispose();
		}

	}

}
