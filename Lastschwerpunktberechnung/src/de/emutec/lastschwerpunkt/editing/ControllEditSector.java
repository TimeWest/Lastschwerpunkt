package de.emutec.lastschwerpunkt.editing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.emutec.lastschwerpunkt.model.DataCollection;
import de.emutec.lastschwerpunkt.model.data.Sector;
import de.emutec.lastschwerpunkt.view.EditSector;
import de.emutec.lastschwerpunkt.view.EditingWindow;
import de.emutec.lastschwerpunkt.view.MainWindowConstants;

public class ControllEditSector implements ControllEditWindow {
	EditSector window;
	Sector data;

	public ControllEditSector(Object data) {
		
		window = new EditSector();
		window.addButtonListener(new ButtonListener());
		
		if (data != null) {
			this.data = new Sector((Sector) data);
			edit();
		} else {
			this.data = new Sector();
		}
		
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

			if (e.getActionCommand() == EditingWindow.APPROVE_OPTION) {

				try {
					accept();
					window.setVisible(false);
					window.removeAll();
					window.dispose();
					window = null;
					return;
				} catch (Exception ex) {
					window.displayNumberError("Fehler! Konnte Sektor nicht speichern.\nBitte Eingaben überprüfen");
				}
			}
			if (e.getActionCommand() == EditingWindow.CANCEL_OPTION) {

				window.removeAll();
				window.dispose();
				data = null;
				window = null;
				return;
			}
			if (e.getActionCommand() == EditingWindow.HELP_OPTION) {
				window.displayNumberError("Hier entsteht ein Hilfe-Fenster.\nCurrently under maintenance. :(");
			}

		}
	}

	@Override
	public void delete() {
		// TODO later: Auto-generated method stub

	}

	@Override
	public void accept() {
		data.setName(window.getName());
		data.setNumber(Integer.parseInt(window.getNumber()));
		data.setColor(window.getCcSectorColor());
	}

	@Override
	public Object run() {
		window.setVisible(true);
		return data;
	}
}
