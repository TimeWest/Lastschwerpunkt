package de.emutec.lastschwerpunkt.sector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllEditSector {

	class BtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals("ok")) {
				try {
					sector.setName(window.getTxtSectorName());
					sector.setNumber(Integer.parseInt(window.getTxtSectorNumber()));
					sector.setColor(window.getCcSectorColor());

					window.dispose();

				} catch (Exception ex) {
					window.displayNumberError("Fehler! Konnte Sektor nicht speichern.\nBitte Eingaben überprüfen");
				}
			}
			if (e.getActionCommand().equals("cancel")) {
				window.dispose();
			}
			if (e.getActionCommand().equals("?")) {
				window.displayNumberError("Hier entsteht ein Hilfe-Fenster.\nCurrently under maintenance. :(");
			}

		}

	}
	private Sector sector;

	private EditSector window;

	public ControllEditSector() {
		this.window = new EditSector();
		this.window.addButtonListener(new BtnListener());
	}

	public void deleteSector() {
		// TODO get the selected sector from TreeController and Collection and delete it after reassuring that the user is sure.
	}

	public void editSector() {
		// TODO get the selected sector from TreeController and Collection
		this.window.setTxtSectorName(sector.getName());
		this.window.setTxtSectorNumber(sector.getNumber().toString());
		this.window.setCcSectorColor(sector.getColor());
		this.window.setVisible(true);
	}

	public void newSector() {
		sector = new Sector();
		this.window.setVisible(true);
	}
}
