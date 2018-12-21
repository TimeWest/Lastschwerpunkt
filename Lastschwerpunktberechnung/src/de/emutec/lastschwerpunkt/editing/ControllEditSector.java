package de.emutec.lastschwerpunkt.editing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.emutec.lastschwerpunkt.controller.EditingType;
import de.emutec.lastschwerpunkt.datahandling.DataCollection;
import de.emutec.lastschwerpunkt.datahandling.DataFactory;
import de.emutec.lastschwerpunkt.datahandling.DataType;
import de.emutec.lastschwerpunkt.datahandling.Sector;
import de.emutec.lastschwerpunkt.view.EditSector;
import de.emutec.lastschwerpunkt.view.EditWindowFactory;
import de.emutec.lastschwerpunkt.view.EditingWindow;

public class ControllEditSector implements ControllEditWindows {
	Sector data;
	EditSector window;

	public ControllEditSector(EditingType type) {
		switch (type) {
		case ADD:
			break;
		case EDIT:
			edit();
			break;
		case DELETE:
			delete();
			break;
		default:
			break;
		}

		window = (EditSector) EditWindowFactory.getInstance(DataType.SECTOR);
		data = (Sector) DataFactory.getInstance(DataType.SECTOR);

		window.addButtonListener(new ButtonListener());
		window.setVisible(true);
	}

	@Override
	public void edit() {
		window.setName(data.getName());
		window.setNumber(data.getNumber());
		window.setCcSectorColor(data.getColor());
	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals(EditingWindow.APPROVE_OPTION)) {

				try {
					data.setName(window.getName());
					data.setNumber(Integer.parseInt(window.getNumber()));
					data.setColor(window.getCcSectorColor());

					window.removeAll();
					window.dispose();
					DataCollection.INSTANCE.editData(data);
					window = null;
					return;
				} catch (Exception ex) {
					window.displayNumberError("Fehler! Konnte Sektor nicht speichern.\nBitte Eingaben überprüfen");
				}
			}
			if (e.getActionCommand().equals(EditingWindow.CANCEL_OPTION)) {

				window.removeAll();
				window.dispose();
				window = null;
				return;
			}
			if (e.getActionCommand().equals(EditingWindow.HELP_OPTION)) {
				window.displayNumberError("Hier entsteht ein Hilfe-Fenster.\nCurrently under maintenance. :(");
			}

		}
	}
}
