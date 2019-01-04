package de.emutec.lastschwerpunkt.editing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.emutec.lastschwerpunkt.datahandling.Building;
import de.emutec.lastschwerpunkt.view.EditBuilding;
import de.emutec.lastschwerpunkt.view.EditingWindow;
import de.emutec.lastschwerpunkt.view.MainWindowConstants;

public class ControllEditBuilding implements ControllEditWindow {

	Building data;
	EditBuilding window;

	// Constructor for editing an existing building
	public ControllEditBuilding(String command, Object data) {
		window = new EditBuilding();

		if (command == MainWindowConstants.EDIT_DATA) {
			this.data = (Building) data;
			edit();
		} else {
			this.data = new Building();
		}

		window.addButtonListener(new ButtonListener());
	}

	@Override
	public void accept() {
		data.setName(window.getName());
		data.setNumber(Integer.parseInt(window.getNumber()));
		data.setGlf(window.getTxtGLF());
		data.setLoad(window.getTxtLoad());
		data.setDescription(window.getTxtrBeschreibung());
		data.setCoordinates(window.getCoordinates());
		data.setSector(window.getSpinnerSector());
		data.setActive(window.getChkbxIsActive());
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit() {
		window.setName(data.getName());
		window.setNumber(data.getNumber());
		window.setTxtGLF(data.getGlf());
		window.setTxtLoad(data.getLoad());
		window.setTxtrBeschreibung(data.getDescription());
		window.setCoordinates(data.getCoordinates());
		window.setSpinnerSector(data.getSector());
		window.setChkbxIsActive(data.isActive());
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand() == EditingWindow.APPROVE_OPTION) {
				try {
					accept();
					window.setVisible(false);
					window.removeAll();
					window.dispose();
					window = null;
					return;
				} catch (Exception ex) {
					window.displayNumberError("Fehler! Konnte Gebäude nicht speichern.\nBitte Eingaben überprüfen");
				}
			}

			if (e.getActionCommand() == EditingWindow.CANCEL_OPTION) {
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

	@Override
	public Object run() {
		window.setVisible(true);
		return data;
	}

}
