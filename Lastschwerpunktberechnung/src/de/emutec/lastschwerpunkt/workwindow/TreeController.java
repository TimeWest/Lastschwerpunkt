package de.emutec.lastschwerpunkt.workwindow;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import de.emutec.lastschwerpunkt.sector.Collection;

public class TreeController {

	class TreeSelection implements TreeSelectionListener {

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			collection.setPath(e.getNewLeadSelectionPath());
		}
	}

	private Collection collection;
	private MainWindow mainWindow;

	public TreeController(MainWindow mainWindow, Collection collection) {
		this.mainWindow = mainWindow;
		this.collection = collection;
		this.mainWindow.treeSelectionListener(new TreeSelection());
	}
}
