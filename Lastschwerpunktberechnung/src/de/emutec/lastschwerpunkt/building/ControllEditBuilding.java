package de.emutec.lastschwerpunkt.building;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllEditBuilding {
	class BtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals("ok")) {
				try {
					building.setGebName(window.getTxtGebudeName());
					building.setGebNumber(window.getTxtGebudeNummer());
					building.setGlf(window.getTxtGLF());
					building.setLoad(window.getTxtLoad());
					building.setDescription(window.getTxtrBeschreibung());
					building.setCoordinates(window.getTxtXcoordinate(), window.getTxtYcoordinate());
					building.setSector(window.getSpinnerSector());
					building.setActive(window.getChkbxIsActive());
					window.dispose();
					buildingCollection.addBuilding(building);
				} catch (Exception ex) {
					window.displayNumberError("Fehler! Konnte Gebäude nicht speichern.\nBitte Eingaben überprüfen");
				}
			}

			if (e.getActionCommand().equals("cancel")) {
				// TODO Einfügen, dass bei vorliegenden Änderungen diese wirklich verworfen
				// werden sollen
				window.dispose();
			}

			if (e.getActionCommand().equals("?")) {
				window.displayNumberError("Hier entsteht ein Hilfefenster!\nCurrently under maintenance!");
			}
		}
	}

	private Building building;
	private BuildingCollection buildingCollection;

	private EditBuilding window;

	// Constructor for editing an existing building
	public ControllEditBuilding() {
		this.window = new EditBuilding();
		this.window.addButtonListener(new BtnListener());
	}

	public void deleteBuilding() {
		// TODO Get selected building from tree and delete it after reassuring the user is sure. 
	}

	public void editBuilding() {
		// TODO Get the selected building from tree
		this.window.setTxtGebudeName(building.getGebName());
		this.window.setTxtGebudeNummer(building.getGebNumber());
		this.window.setTxtGLF(building.getGlf());
		this.window.setTxtLoad(building.getLoad());
		this.window.setTxtrBeschreibung(building.getDescription());
		this.window.setTxtXcoordinate(building.getCoordinates()[0]);
		this.window.setTxtYcoordinate(building.getCoordinates()[1]);
		this.window.setSpinnerSector(building.getSector());
		this.window.setChkbxIsActive(building.isActive());
		this.window.setVisible(true);
	}

	public void newBuilding() {
		building = new Building();
		this.window.setVisible(true);
	}
}
