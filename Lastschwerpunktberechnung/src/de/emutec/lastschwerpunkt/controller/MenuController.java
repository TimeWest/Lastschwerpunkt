package de.emutec.lastschwerpunkt.controller;

import de.emutec.lastschwerpunkt.datahandling.JSonHandler;
import de.emutec.lastschwerpunkt.datahandling.ProjectConstants;
import de.emutec.lastschwerpunkt.view.MainWindow;
import de.emutec.lastschwerpunkt.view.MainWindowConstants;

public class MenuController {

	private MainWindow mainWindow;
	private JSonHandler converter;

	public MenuController(MainWindow mainWindow) {

		this.mainWindow = mainWindow;
		this.mainWindow.mntmListener(e -> {
			if (e.getActionCommand().equals(MainWindowConstants.EXIT)) {
				System.exit(0);
			}
			if (e.getActionCommand().equals(MainWindowConstants.SAVE_PROJECT)) {
				converter = new JSonHandler();
				converter.saveToFile();
				converter = null;
			}
			if (e.getActionCommand().equals(MainWindowConstants.SAVE_PROJECT_AS)) {
				converter = new JSonHandler();
				converter.setNewPath();
				converter.saveToFile();
				converter = null;
			}
			if (e.getActionCommand().equals(MainWindowConstants.LOAD_PROJECT)) {
				converter = new JSonHandler();
				converter.loadFromFile();
				converter = null;
			}
			if (e.getActionCommand().equals(MainWindowConstants.NEW_PROJECT)) {
				// TODO open JFileChooser with option to type in the name for the project
				ProjectConstants.INSTANCE.setProjectPath();
				System.out.println(ProjectConstants.INSTANCE.getProjectPath());
			}

			if (e.getActionCommand().equals(MainWindowConstants.HELP)) {
				// TODO open help-dialog
			}
		});
	}

}
