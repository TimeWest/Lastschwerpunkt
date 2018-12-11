package de.emutec.lastschwerpunkt;

import de.emutec.lastschwerpunkt.sector.Collection;
import de.emutec.lastschwerpunkt.workwindow.MainButtonController;
import de.emutec.lastschwerpunkt.workwindow.MainWindow;
import de.emutec.lastschwerpunkt.workwindow.MapController;
import de.emutec.lastschwerpunkt.workwindow.MenuController;
import de.emutec.lastschwerpunkt.workwindow.TreeController;

/**
 * @author Timo.Nordhorn
 */
public class Main {

	public static void main(String[] args) {
		/**
		 * Launch the application.
		 */
		MainWindow mainWindow = new MainWindow();
		Collection collection = new Collection();
		new TreeController(mainWindow, collection);
		new MapController(mainWindow);
		new MenuController(mainWindow);
		new MainButtonController(mainWindow);

		mainWindow.setVisible(true);

	}
}
