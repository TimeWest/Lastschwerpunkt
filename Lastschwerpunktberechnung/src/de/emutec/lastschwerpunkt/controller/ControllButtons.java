package de.emutec.lastschwerpunkt.controller;

import de.emutec.lastschwerpunkt.view.MainWindow;

public class ControllButtons {

	private MainWindow mainWindow;
	
	public ControllButtons(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		
		
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
	
	/**
	 * @param string
	 *            Method to check if the entered value is actually a double and and
	 *            else catch exception Also replaces "," by "."
	 * @return double
	 * 
	 * @throws NumberFormatException
	 *             ex
	 *
	private double checkForNumberFormatException(String string) {
		try {
			return Double.parseDouble(string.replace(",", "."));
			//return value;
		} catch (NumberFormatException ex) {
			displayNumberError(errorMessage);
		}
	}
	*/
}
