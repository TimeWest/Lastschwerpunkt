package de.emutec.lastschwerpunkt.controller;

import de.emutec.lastschwerpunkt.model.Collection;
import de.emutec.lastschwerpunkt.view.MainWindow;

public class TreeController {

	private Collection collection;

	private MainWindow mainWindow;

	public TreeController(MainWindow mainWindow, Collection collection) {
		this.mainWindow = mainWindow;
		this.collection = collection;
		this.mainWindow.treeSelectionListener(e -> {
			collection.setPath(e.getNewLeadSelectionPath());
		});
	}

}
