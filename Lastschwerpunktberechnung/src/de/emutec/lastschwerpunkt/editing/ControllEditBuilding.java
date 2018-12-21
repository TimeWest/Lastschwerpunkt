package de.emutec.lastschwerpunkt.editing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.emutec.lastschwerpunkt.controller.EditingType;
import de.emutec.lastschwerpunkt.datahandling.Building;
import de.emutec.lastschwerpunkt.datahandling.DataCollection;
import de.emutec.lastschwerpunkt.datahandling.DataFactory;
import de.emutec.lastschwerpunkt.datahandling.DataType;
import de.emutec.lastschwerpunkt.view.EditBuilding;
import de.emutec.lastschwerpunkt.view.EditWindowFactory;
import de.emutec.lastschwerpunkt.view.EditingWindow;

public class ControllEditBuilding implements ControllEditWindows {

	Building data;
	EditBuilding window;

	// Constructor for editing an existing building
	public ControllEditBuilding(EditingType type) {

		window = (EditBuilding) EditWindowFactory.getInstance(DataType.BUILDING);
		data = (Building) DataFactory.getInstance(DataType.BUILDING);
		
		switch (type) {
		case ADD:
			break;
		case EDIT:
			data = (Building) DataCollection.INSTANCE.getData();
			edit();
			break;
		case DELETE:
			delete();
			break;
		default:
			break;
		}

		window.addButtonListener(new ButtonListener());
		window.setVisible(true);

	}

	@Override
	public void edit() {
		// TODO Get the selected building from tree
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

			if (e.getActionCommand().equals(EditingWindow.APPROVE_OPTION)) {
				try {
					data.setName(window.getName());
					data.setNumber(Integer.parseInt(window.getNumber()));
					data.setGlf(window.getTxtGLF());
					data.setLoad(window.getTxtLoad());
					data.setDescription(window.getTxtrBeschreibung());
					data.setCoordinates(window.getCoordinates());
					data.setSector(window.getSpinnerSector());
					data.setActive(window.getChkbxIsActive());

					window.removeAll();
					window.dispose();
					DataCollection.INSTANCE.editData(data);
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
