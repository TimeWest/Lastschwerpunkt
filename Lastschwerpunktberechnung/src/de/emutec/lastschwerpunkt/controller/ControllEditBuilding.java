package de.emutec.lastschwerpunkt.controller;

import javax.swing.JDialog;

import de.emutec.lastschwerpunkt.model.Building;
import de.emutec.lastschwerpunkt.view.EditBuilding;

public class ControllEditBuilding {
	private EditBuilding window = new EditBuilding();
	private Building building;
	
	//Constructor for adding a new Building
	public ControllEditBuilding() {
//		building = new Building();
		this.window.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.window.setVisible(true);
		System.out.println("check, gebäude erstellt, fenster geöffnet");
	}
	 
	//Constructor for editing an existing building
	public ControllEditBuilding(Building building) {
		this.building = building;
		this.window.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTextFields();
	}
	
	private void setTextFields() {
		window.setTxtGebudeName(building.getGebName());
		window.setTxtGebudeNummer(building.getGebNumber());
		window.setTxtGLF(building.getGlf());
		window.setTxtLoad(building.getLoad());
		window.setTxtrBeschreibung(building.getDescription());
		window.setTxtXcoordinate(building.getCoordinates()[0]);
		window.setTxtYcoordinate(building.getCoordinates()[1]);
		window.setSpinnerSector(building.getSector());
		window.setChkbxIsActive(building.isActive());
	}
	
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
