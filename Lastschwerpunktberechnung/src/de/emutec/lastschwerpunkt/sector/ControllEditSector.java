package de.emutec.lastschwerpunkt.sector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class ControllEditSector {

	private EditSector window;
	private SectorCollection collection;
	private Sector sector;

	public ControllEditSector(SectorCollection collection) {
		this.window = new EditSector();
		this.collection = collection;
		this.sector = new Sector();
		this.window.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.window.addOkBtnListener(new OkBtnListener());
		
		this.window.setVisible(true);
	}

	public ControllEditSector(SectorCollection collection, Sector sector) {
		this.window = new EditSector();
		this.collection = collection;
		this.sector = sector;
		this.window.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.window.setTxtSectorName(sector.getName());
		this.window.setTxtSectorNumber(sector.getNumber().toString());
		this.window.addOkBtnListener(new OkBtnListener());
		
		this.window.setVisible(true);
	}

	class OkBtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				sector.setName(window.getTxtSectorName());
				sector.setNumber(Integer.parseInt(window.getTxtSectorNumber()));
				window.dispose();
				collection.addSector(sector);
				
			} catch (Exception e) {
				window.displayNumberError("Fehler! Konnte Sektor nicht speichern.\nBitte Eingaben überprüfen");
			}
		}

	}
}
