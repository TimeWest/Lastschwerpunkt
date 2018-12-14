package de.emutec.lastschwerpunkt.editing;

import de.emutec.lastschwerpunkt.model.Sector;
import de.emutec.lastschwerpunkt.view.EditSector;
import de.emutec.lastschwerpunkt.view.EditingWindow;

public class ControllEditSector implements ControllEditWindows {

	private Sector sector;
	private EditSector window;

	public ControllEditSector() {
		this.window = new EditSector();
		this.window.addButtonListener(e -> {

			if (e.getActionCommand().equals(EditingWindow.APPROVE_OPTION)) {

				try {
					sector.setName(window.getTxtSectorName());
					sector.setNumber(Integer.parseInt(window.getTxtSectorNumber()));
					sector.setColor(window.getCcSectorColor());

					window.removeAll();
					window.dispose();
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
		});
	}

	@Override
	public void edit() {
		this.sector = new Sector();
		this.window.setTxtSectorName(sector.getName());
		this.window.setTxtSectorNumber(sector.getNumber().toString());
		this.window.setCcSectorColor(sector.getColor());
		this.window.setVisible(true);
	}

	@Override
	public void add() {
		sector = new Sector();
		this.window.setVisible(true);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}
