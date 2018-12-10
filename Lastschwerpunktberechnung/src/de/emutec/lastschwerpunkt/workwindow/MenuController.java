package de.emutec.lastschwerpunkt.workwindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {

	private MainWindow mainWindow;

	public MenuController(MainWindow mainWindow) {
		// TODO Auto-generated constructor stub
		this.mainWindow = mainWindow;
		this.mainWindow.mntmExitListener(new MenuActionListener());
	}

	class MenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Ask if sure to exit, when not saved
			if ("exit".equals(arg0.getActionCommand())) {
				System.exit(0);
			}
		}

	}

}
