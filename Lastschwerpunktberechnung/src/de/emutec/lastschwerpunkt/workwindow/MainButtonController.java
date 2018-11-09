package de.emutec.lastschwerpunkt.workwindow;

import java.awt.event.*;

import de.emutec.lastschwerpunkt.building.BuildingCollection;
import de.emutec.lastschwerpunkt.building.ControllEditBuilding;

public class MainButtonController {

	private MainWindow mainWindow;

	// Constructor
	public MainButtonController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		
		this.mainWindow.btnGebudeBearbeitenListener(new EditButtonListener());
		this.mainWindow.btnGebudeEntfernenListener(new DeleteButtonListener());
		this.mainWindow.btnGebudeHinzufgenListener(new AddButtonListener());
	}

	class AddButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO First set buildings position by clicking on the map
			try {
				new ControllEditBuilding();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	class EditButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO get the selected building from BuildingsCollection and give it to
			// ControllEditBuilding(Building building);
			try {
				new ControllEditBuilding();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	class DeleteButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Get the selected building and delete it.
		}

	}
	/**
	 * Funktion zum Speichern der Werte, wenn Änderungen vorliegen
	 */
	/*
	 * protected void applyChanges() { building.setGebName(txtGebudeName.getText());
	 * building.setGebNumber(txtGebudeNummer.getText());
	 * building.setDescription(txtrBeschreibung.getText());
	 * building.setSector((int); spinnerSector.getValue()); try {
	 * building.setLoad(Double.parseDouble(txtLoad.getText().replace(",", "."))); }
	 * catch (NumberFormatException e) {
	 * displayNumberError("Bitte eine Zahl eingeben."); } try {
	 * building.setGlf(Double.parseDouble(txtGLF.getText().replace(",", "."))); }
	 * catch (NumberFormatException e) {
	 * displayNumberError("Bitte eine Zahl eingeben."); }
	 * building.setCoordinates(Double.parseDouble(txtXcoordinate.getText().replace(
	 * ",", ".")), Double.parseDouble(txtYcoordinate.getText().replace(",", ".")));
	 * }
	 */

}
