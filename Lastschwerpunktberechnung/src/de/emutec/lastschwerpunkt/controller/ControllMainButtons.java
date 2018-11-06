package de.emutec.lastschwerpunkt.controller;

import javax.swing.*;
import java.awt.event.*;

import de.emutec.lastschwerpunkt.view.EditBuilding;
import de.emutec.lastschwerpunkt.view.EditSector;
import de.emutec.lastschwerpunkt.view.MainWindow;

public class ControllMainButtons {

	private MainWindow mainWindow;
	//Constructor
	public ControllMainButtons(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.mainWindow.btnGebudeHinzufgenListener(new addButtonListener());
	
	}
	
	
	class addButtonListener implements ActionListener{

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
	
	class editButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO get the selected building from BuildingsCollection and give it to ControllEditBuilding(Building building);
			try {
				new ControllEditBuilding();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
