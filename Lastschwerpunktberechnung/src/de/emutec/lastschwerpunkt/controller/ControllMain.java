package de.emutec.lastschwerpunkt.controller;

import de.emutec.lastschwerpunkt.model.Collection;
import de.emutec.lastschwerpunkt.view.MainWindow;

public class ControllMain {
	
	private MainWindow mainWindow;
	private Collection collection;
	
	public ControllMain(MainWindow mainWindow) {
		// TODO Auto-generated constructor stub
		this.mainWindow = mainWindow;
		this.collection = new Collection();
		new MainButtonController(this.mainWindow);
		new MenuController(this.mainWindow);
		new MapController(this.mainWindow);
		new TreeController(this.mainWindow, this.collection);
	}
	
	
	
}
