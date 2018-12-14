package de.emutec.lastschwerpunkt.editing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.emutec.lastschwerpunkt.model.Building;
import de.emutec.lastschwerpunkt.view.EditBuilding;
import de.emutec.lastschwerpunkt.view.EditingWindow;

public class ControllEditBuilding implements ControllEditWindows {

	private Building building;
	private EditBuilding window;

	// Constructor for editing an existing building
	public ControllEditBuilding() {
		this.window = new EditBuilding();
		this.window.addButtonListener(new ButtonListener());
	}

	@Override
	public void delete() {
		// TODO Get selected building from tree and delete it after reassuring the user
		// is sure.
	}

	@Override
	public void edit() {
		// TODO Get the selected building from tree
		this.building = new Building();
		this.window.setTxtGebudeName(building.getGebName());
		this.window.setTxtGebudeNummer(building.getGebNumber());
		this.window.setTxtGLF(building.getGlf());
		this.window.setTxtLoad(building.getLoad());
		this.window.setTxtrBeschreibung(building.getDescription());
		this.window.setCoordinates(building.getCoordinates());
		this.window.setSpinnerSector(building.getSector());
		this.window.setChkbxIsActive(building.isActive());
		this.window.setVisible(true);
	}

	@Override
	public void add() {
		building = new Building();
		this.window.setVisible(true);
	}

	private class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			if (e.getActionCommand().equals(EditingWindow.APPROVE_OPTION)) {
				try {
					building.setGebName(window.getTxtGebudeName());
					building.setGebNumber(window.getTxtGebudeNummer());
					building.setGlf(window.getTxtGLF());
					building.setLoad(window.getTxtLoad());
					building.setDescription(window.getTxtrBeschreibung());
					building.setCoordinates(window.getCoordinates());
					building.setSector(window.getSpinnerSector());
					building.setActive(window.getChkbxIsActive());

					window.removeAll();
					window.dispose();
					window = null;
					return;
				} catch (Exception ex) {
					window.displayNumberError("Fehler! Konnte Gebäude nicht speichern.\nBitte Eingaben überprüfen");
				}
			}

			if (e.getActionCommand().equals(EditingWindow.CANCEL_OPTION)) {
				// TODO Einfügen, dass bei vorliegenden Änderungen diese wirklich verworfen
				// werden sollen
				window.removeAll();
				window.dispose();
				window = null;
				return;
			}

			if (e.getActionCommand().equals(EditingWindow.HELP_OPTION)) {
				window.displayNumberError("Hier entsteht ein Hilfefenster!\nCurrently under maintenance!");
			}
		}
	}

}
