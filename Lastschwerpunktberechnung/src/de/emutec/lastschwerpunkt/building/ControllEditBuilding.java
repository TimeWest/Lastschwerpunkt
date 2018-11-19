package de.emutec.lastschwerpunkt.building;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.event.ChangeEvent;

import de.emutec.lastschwerpunkt.sector.SectorCollection;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class ControllEditBuilding {
	private EditBuilding window;
	private Building building;
	private BuildingCollection buildingCollection;
	public boolean finished;

	// Constructor for adding a new Building
	public ControllEditBuilding(BuildingCollection buildingCollection) {
		this.window = new EditBuilding();
		this.building = new Building();
		this.buildingCollection = buildingCollection;
		this.window.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.window.addOkButtonListener(new OkBtnListener());
		this.window.addCancelButtonListener(new CancelBtnListener());
		this.window.setVisible(true);
	}

	// Constructor for editing an existing building
	public ControllEditBuilding(BuildingCollection collection, Building building) {
		this.window = new EditBuilding();
		this.building = building;
		this.buildingCollection = collection;
		this.window.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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

	class OkBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

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
				finished = true;
				wait();
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
