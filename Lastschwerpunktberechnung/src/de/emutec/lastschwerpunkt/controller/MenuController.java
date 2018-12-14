package de.emutec.lastschwerpunkt.controller;

import de.emutec.lastschwerpunkt.view.MainWindow;

public class MenuController {

	private MainWindow mainWindow;

	public MenuController(MainWindow mainWindow) {

		this.mainWindow = mainWindow;
		this.mainWindow.mntmExitListener(e -> {
			if (e.getActionCommand().equals("exit")) {
				System.exit(0);
			}
		});
	}

}
