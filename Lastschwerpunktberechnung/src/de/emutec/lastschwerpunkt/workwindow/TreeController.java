package de.emutec.lastschwerpunkt.workwindow;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class TreeController {

	private MainWindow mainWindow;
	private TreePath path;

	public TreeController(MainWindow mainWindow, TreePath path) {
		// TODO Auto-generated constructor stub
		this.mainWindow = mainWindow;
		this.path = path;
		this.mainWindow.treeSelectionListener(new TreeSelection());
	}

	class TreeSelection implements TreeSelectionListener {

		@Override
		public void valueChanged(TreeSelectionEvent arg0) {
			// TODO Auto-generated method stub
			path = arg0.getNewLeadSelectionPath();
		}
	}
}
