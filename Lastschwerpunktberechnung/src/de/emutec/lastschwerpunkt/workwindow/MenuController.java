package de.emutec.lastschwerpunkt.workwindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {

	class MenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Ask if sure to exit, when not saved
			if ("exit".equals(e.getActionCommand())) {
				System.exit(0);
			}
		}

	}

	private MainWindow mainWindow;

	public MenuController(MainWindow mainWindow) {
		
		this.mainWindow = mainWindow;
		this.mainWindow.mntmExitListener(new MenuActionListener());
	}

}
