package de.emutec.lastschwerpunkt.editing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.emutec.lastschwerpunkt.model.DataCollection;
import de.emutec.lastschwerpunkt.model.data.Building;
import de.emutec.lastschwerpunkt.model.data.Sector;
import de.emutec.lastschwerpunkt.view.EditBuilding;
import de.emutec.lastschwerpunkt.view.EditingWindow;
import de.emutec.lastschwerpunkt.view.MainWindowConstants;

public class ControllEditBuilding implements ControllEditWindow {

	Building data;
	EditBuilding window;

	// Constructor for editing an existing building
	public ControllEditBuilding(Object data) {
		window = new EditBuilding();
		window.addButtonListener(new ButtonListener());

		if (data != null) {
			this.data = new Building((Building) data);
			edit();
		} else {
			this.data = new Building();
		}
	}

	@Override
	public void accept() {
		data.setName(window.getName());
		data.setNumber(Integer.parseInt(window.getNumber()));
		data.setGlf(window.getTxtGLF());
		data.setLoad(window.getTxtLoad());
		data.setDescription(window.getTxtrBeschreibung());
		data.setCoordinates(window.getCoordinates());
		Sector sector = getSectorObjectFromComboBox(window.getSelectedSector());
		data.setSector(sector);
		data.setActive(window.getChkbxIsActive());
	}

	private Sector getSectorObjectFromComboBox(Object selectedSector) {
		for (Object sector : DataCollection.INSTANCE.getObjectsOfClass(Sector.class)) {
			if (sector != null && sector.toString().equals(selectedSector)) {
				return (Sector) sector;
			}
		}
		return null;

	}

	@Override
	public void delete() {
		// TODO later: Auto-generated method stub

	}

	@Override
	public void edit() {
		window.setName(data.getName());
		window.setNumber(data.getNumber());
		window.setTxtGLF(data.getGlf());
		window.setTxtLoad(data.getLoad());
		window.setTxtrBeschreibung(data.getDescription());
		window.setCoordinates(data.getCoordinates());
		window.setSelectedSector(data.getSector().toString());
		window.setChkbxIsActive(data.isActive());
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
	
			if (e.getActionCommand().equals(EditingWindow.HELP_OPTION)) {
				window.displayNumberError("Hier entsteht ein Hilfefenster!\nCurrently under maintenance!");
			}

			if (e.getActionCommand() == EditingWindow.APPROVE_OPTION) {
				try {
					accept();
					window.setVisible(false);
					window.removeAll();
					window.dispose();
					window = null;
				} catch (Exception ex) {
					window.displayNumberError("Fehler! Konnte Gebäude nicht speichern.\nBitte Eingaben überprüfen");
				}
			}

			if (e.getActionCommand() == EditingWindow.CANCEL_OPTION) {
				// TODO later: Einfügen, dass bei vorliegenden Änderungen diese wirklich
				// verworfen
				// werden sollen
				data = null;
				window.removeAll();
				window.dispose();
				window = null;
			}

		}

	}

	@Override
	public Object run() {
		window.setVisible(true);
		return data;
	}

}
