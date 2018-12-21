package de.emutec.lastschwerpunkt.controller;

import javax.swing.tree.TreePath;

import de.emutec.lastschwerpunkt.datahandling.DataCollection;
import de.emutec.lastschwerpunkt.view.MainWindow;

public class TreeController {

	private MainWindow mainWindow;

	public TreeController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.mainWindow.treeSelectionListener(e -> setPath(new TreePath(e.getNewLeadSelectionPath())));
	}

	/**
	 * @return the path
	 */
	public TreePath getPath() {
		return (TreePath) DataCollection.INSTANCE.getCurrentObject();
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(TreePath path) {
		DataCollection.INSTANCE.setCurrentObject(path);
	}

}
