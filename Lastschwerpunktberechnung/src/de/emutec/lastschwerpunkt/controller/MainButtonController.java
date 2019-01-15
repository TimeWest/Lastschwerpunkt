package de.emutec.lastschwerpunkt.controller;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import de.emutec.lastschwerpunkt.editing.ControllEditBuilding;
import de.emutec.lastschwerpunkt.editing.ControllEditSector;
import de.emutec.lastschwerpunkt.editing.ControllEditWindow;
import de.emutec.lastschwerpunkt.model.DataCollection;
import de.emutec.lastschwerpunkt.model.data.Building;
import de.emutec.lastschwerpunkt.model.data.Sector;
import de.emutec.lastschwerpunkt.view.MainWindow;
import de.emutec.lastschwerpunkt.view.MainWindowConstants;

/**
 * processes the actions occurred by clicking on the buttons
 * 
 * @author Timo.Nordhorn
 * 
 */
public class MainButtonController {

	private MainWindow mainWindow;

	public MainButtonController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.mainWindow.buttonListener(e -> {

			// define the button from the editing group that was clicked
			String command = e.getActionCommand();

			// TreePath to selected node, in case an entry shall be deleted or edited
			TreePath selectionPath = DataCollection.INSTANCE.getTree().getSelectionPath();
			
			DefaultMutableTreeNode selection;
			ControllEditWindow editController;
			Object returnValue;

			// make sure that not nothing is selected to prevent nullPointer exception
			if (selectionPath != null) {
				selection = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
			} else {
				selection = (DefaultMutableTreeNode) DataCollection.INSTANCE.getTreeModel().getRoot();
			}
			
			// object behind node that was selected
			Object data = selection.getUserObject();

			// decide what to do
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
			
			// process edited/created data
			DataCollection.INSTANCE.insertData(returnValue, command);

		});
	}

}