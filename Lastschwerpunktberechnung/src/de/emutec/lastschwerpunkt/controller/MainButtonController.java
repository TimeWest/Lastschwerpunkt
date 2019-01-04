package de.emutec.lastschwerpunkt.controller;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import de.emutec.lastschwerpunkt.datahandling.Building;
import de.emutec.lastschwerpunkt.datahandling.DataCollection;
import de.emutec.lastschwerpunkt.datahandling.Sector;
import de.emutec.lastschwerpunkt.editing.ControllEditBuilding;
import de.emutec.lastschwerpunkt.editing.ControllEditSector;
import de.emutec.lastschwerpunkt.editing.ControllEditWindow;
import de.emutec.lastschwerpunkt.view.MainWindow;
import de.emutec.lastschwerpunkt.view.MainWindowConstants;

public class MainButtonController {

	private MainWindow mainWindow;

	// Constructor
	public MainButtonController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.mainWindow.buttonListener(e -> {

			String command = e.getActionCommand();
			TreePath selectionPath = DataCollection.INSTANCE.getTree().getSelectionPath();
			DefaultMutableTreeNode selection;
			ControllEditWindow editController;
			Object returnValue;

			if (selectionPath == null) {
				selection = (DefaultMutableTreeNode) DataCollection.INSTANCE.getTreeModel().getRoot();
			} else {
				selection = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
			}
			Object data = selection.getUserObject();
			
			if (command == MainWindowConstants.DELETE_DATA) {
				System.out.println("Es soll also: " + selection + " gelöscht werden?");
				returnValue = -1;
			} else if (data instanceof Building || command == MainWindowConstants.ADD_BUILDING) {
				editController = new ControllEditBuilding(command, data);
				returnValue = editController.run();
			} else if (data instanceof Sector || command == MainWindowConstants.ADD_SECTOR) {
				editController = new ControllEditSector(command, data);
				returnValue = editController.run();
			} else {
				returnValue = -1;
			}
			DataCollection.INSTANCE.insertData(returnValue);

		});
	}

}