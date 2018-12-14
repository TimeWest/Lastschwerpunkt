package de.emutec.lastschwerpunkt;

import de.emutec.lastschwerpunkt.controller.ControllMain;
import de.emutec.lastschwerpunkt.controller.MainButtonController;
import de.emutec.lastschwerpunkt.controller.MapController;
import de.emutec.lastschwerpunkt.controller.MenuController;
import de.emutec.lastschwerpunkt.controller.TreeController;
import de.emutec.lastschwerpunkt.editing.ControllEditBuilding;
import de.emutec.lastschwerpunkt.editing.ControllEditSector;
import de.emutec.lastschwerpunkt.model.Collection;
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
		new ControllMain(mainWindow);

		// new TreeController(mainWindow, collection);
		// new MapController(mainWindow);
		// new MenuController(mainWindow);
		// new MainButtonController(mainWindow);
		// new ControllEditBuilding();
		// new ControllEditSector();

		mainWindow.setVisible(true);

	}
}
