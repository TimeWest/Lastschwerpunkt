package de.emutec.lastschwerpunkt;

import de.emutec.lastschwerpunkt.controller.ControllButtons;
import de.emutec.lastschwerpunkt.view.MainWindow;

/**
 * 
 */

/**
 * @author Timo.Nordhorn
 */
public class Main {
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Launch the application.
		 */
		MainWindow mainWindow = new MainWindow();
		ControllButtons buttonController = new ControllButtons(mainWindow);
		mainWindow.setVisible(true);
	}	
}
