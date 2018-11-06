package de.emutec.lastschwerpunkt;

import de.emutec.lastschwerpunkt.controller.ControllMainButtons;
import de.emutec.lastschwerpunkt.view.EditBuilding;
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
		ControllMainButtons buttonController = new ControllMainButtons(mainWindow);
		
		EditBuilding editBuildingWindow = new EditBuilding();
		
		
		mainWindow.setVisible(true);
		
	}	
}
