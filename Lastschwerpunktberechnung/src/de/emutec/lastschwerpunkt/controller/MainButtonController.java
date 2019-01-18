package de.emutec.lastschwerpunkt.controller;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import de.emutec.lastschwerpunkt.editing.ControllEditBuilding;
import de.emutec.lastschwerpunkt.editing.ControllEditSector;
import de.emutec.lastschwerpunkt.editing.ControllEditWindow;
import de.emutec.lastschwerpunkt.model.DataCollection;
import de.emutec.lastschwerpunkt.model.data.Building;
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
	private ControllEditWindow editController;

	public MainButtonController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.mainWindow.buttonListener(e -> {

			if (e.getActionCommand() == MainWindowConstants.ADD_BUILDING) {
				editController = new ControllEditBuilding(null);
				DataCollection.INSTANCE.insertData(editController.run());
			} else if (e.getActionCommand() == MainWindowConstants.ADD_SECTOR) {
				editController = new ControllEditSector(null);
				DataCollection.INSTANCE.insertData(editController.run());
			} else {
				// TreePath to selected node, in case an entry shall be deleted or edited
				TreePath selectionPath = DataCollection.INSTANCE.getTree().getSelectionPath();
				DefaultMutableTreeNode selection;

				// make sure that not nothing is selected to prevent nullPointer exception and get selected node
				if (selectionPath != null) {
					selection = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();
				} else {
					selection = (DefaultMutableTreeNode) DataCollection.INSTANCE.getTreeModel().getRoot();
				}
				// userObject of node that was selected
				Object data = selection.getUserObject();
				// edit/delete
				if (e.getActionCommand() == MainWindowConstants.EDIT_DATA) {
					if (data instanceof Building) {
						editController = new ControllEditBuilding(data);
					} else {
						editController = new ControllEditSector(data);
					}
					DataCollection.INSTANCE.editData(editController.run(), data);
				} else {
					DataCollection.INSTANCE.deleteData(data);
				}
			}
		});
	}
}