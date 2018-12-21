package de.emutec.lastschwerpunkt;

import de.emutec.lastschwerpunkt.controller.MainButtonController;
import de.emutec.lastschwerpunkt.controller.MapController;
import de.emutec.lastschwerpunkt.controller.MenuController;
import de.emutec.lastschwerpunkt.controller.TreeController;
import de.emutec.lastschwerpunkt.view.MainWindow;

/**
 * @author Timo.Nordhorn
 */
public class Main {

	public static void main(String[] args) {
		/**
		 * Launch the application.
		 */
		MainWindow mainWindow = new MainWindow();
		
		new MainButtonController(mainWindow);
		new MenuController(mainWindow);
		new MapController(mainWindow);
		new TreeController(mainWindow);
		
		mainWindow.setVisible(true);

	}
}
