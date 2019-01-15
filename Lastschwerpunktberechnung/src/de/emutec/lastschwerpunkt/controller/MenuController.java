package de.emutec.lastschwerpunkt.controller;

import de.emutec.lastschwerpunkt.model.JSonHandler;
import de.emutec.lastschwerpunkt.model.ProjectConstants;
import de.emutec.lastschwerpunkt.view.MainWindow;
import de.emutec.lastschwerpunkt.view.MainWindowConstants;
/**
 * Controller to process the events from clicking the menuItems in the main window
 * @author Timo.Nordhorn
 *
 */
public class MenuController {

	private MainWindow mainWindow;
	
	/**
	 * Encode and decode the objects created during runtime to save or load them from the filesystem
	 */
	private JSonHandler converter;

	public MenuController(MainWindow mainWindow) {

		this.mainWindow = mainWindow;
		
		/**
		 * actionPerformed lambda expression
		 */
		this.mainWindow.mntmListener(e -> {
			if (e.getActionCommand().equals(MainWindowConstants.EXIT)) {
				System.exit(0);
			}
			// save project
			if (e.getActionCommand().equals(MainWindowConstants.SAVE_PROJECT)) {
				converter = new JSonHandler();
				converter.saveToFile();
				converter = null;
			}
			// save project as
			if (e.getActionCommand().equals(MainWindowConstants.SAVE_PROJECT_AS)) {
				converter = new JSonHandler();
				converter.setNewPath();
				converter.saveToFile();
				converter = null;
			}
			// load project (from filesystem)
			if (e.getActionCommand().equals(MainWindowConstants.LOAD_PROJECT)) {
				converter = new JSonHandler();
				converter.loadFromFile();
				converter = null;
			}
			// create new project
			if (e.getActionCommand().equals(MainWindowConstants.NEW_PROJECT)) {
				// TODO open JFileChooser with option to type in the name for the project
				ProjectConstants.INSTANCE.setProjectPath();
				System.out.println(ProjectConstants.INSTANCE.getProjectPath());
			}
			// open help dialog/manual
			if (e.getActionCommand().equals(MainWindowConstants.HELP)) {
				// TODO open help-dialog
			}
		});
	}

}
