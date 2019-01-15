package de.emutec.lastschwerpunkt.model;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import de.emutec.lastschwerpunkt.model.calculation.Calculator;
import de.emutec.lastschwerpunkt.model.data.Building;
import de.emutec.lastschwerpunkt.model.data.Data;
import de.emutec.lastschwerpunkt.model.data.Sector;
import de.emutec.lastschwerpunkt.view.MainWindowConstants;

/**
 * This Enumeration is storing data (buildings/sectors) that have been created
 * during runtime.
 * 
 * @author Timo.Nordhorn
 * @see Data
 *
 */
public enum DataCollection {
	INSTANCE;

	private DefaultMutableTreeNode root;
	private DefaultTreeModel treeModel;
	private JTree tree;

	{
		treeModel = new DefaultTreeModel(new DefaultMutableTreeNode(new Sector("MSSA", 0, Color.WHITE)));
		root = (DefaultMutableTreeNode) treeModel.getRoot();
		treeModel.addTreeModelListener(new MyTreeModelListener());
		tree = new JTree(treeModel);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setRootVisible(false);
		tree.addTreeSelectionListener(new MyTreeSelectionListener());
	}

	/**
	 * @return the treeModel
	 */
	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}

	/**
	 * @return the tree
	 */
	public JTree getTree() {
		return tree;
	}

	/**
	 * 
	 * @param data
	 */
	private void insertSector(Object data) {
		treeModel.insertNodeInto(new DefaultMutableTreeNode(data), root, root.getChildCount());
	}

	/**
	 * 
	 * @param data
	 */
	private void insertBuilding(Object data) {
		Sector sector = ((Building) data).getSector();
		boolean success = false;
		Object[] sectors = getObjectsOfClass(Sector.class);
		for (int i = 0; i < root.getChildCount(); i++) {

			if (sectors[i] == sector) {
				treeModel.insertNodeInto(new DefaultMutableTreeNode(data, false),
						(DefaultMutableTreeNode) root.getChildAt(i), i);
				success = true;
				break;
			}
		}

		if (!success) {
			treeModel.insertNodeInto(new DefaultMutableTreeNode(data), root, root.getChildCount());
		}
	}

	/**
	 * 
	 * @param data
	 */
	private void reload(Object data) {
		treeModel.reload();
		tree.scrollPathToVisible(new TreePath(new DefaultMutableTreeNode(data).getPath()));
	}

	/**
	 * 
	 * @param newType
	 * @return
	 */
	public <T> Object[] getObjectsOfClass(Class<T> newType) {
		ArrayList<Object> returnValue = new ArrayList<>();
		for (int i = 0; i < root.getChildCount(); i++) {
			Object obj = ((DefaultMutableTreeNode) root.getChildAt(i)).getUserObject();
			if (newType.isInstance(obj)) {
				returnValue.add(obj);
			}

		}
		return returnValue.toArray();
	}

	/**
	 * 
	 * @param data
	 * @param command
	 */
	public void insertData(Object data, String command) {
		if (data == null) {
			System.out.println("Abbruch");
			return;
		}
		switch (command) {
		case MainWindowConstants.EDIT_DATA:
			break;
		case MainWindowConstants.ADD_BUILDING:
			insertBuilding(data);
			break;
		case MainWindowConstants.ADD_SECTOR:
			insertSector(data);
			break;
		case MainWindowConstants.DELETE_DATA:
			break;
		default:

			break;
		}
		reload(data);
		System.out.println("Dieses Objekt kam zur�ck: " + data + "\nKlasse: " + data.getClass());
	}

	private class MyTreeModelListener implements TreeModelListener {
		// TODO Notification for Map and painting on it
		@Override
		public void treeNodesChanged(TreeModelEvent e) {

		}

		@Override
		public void treeNodesInserted(TreeModelEvent e) {
			DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) e.getTreePath().getLastPathComponent();
			int index = e.getChildIndices()[0];
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) parentNode.getChildAt(index);
			Data data = (Data) node.getUserObject();
			
			if (data instanceof Building) {
				Object[] result = Calculator.calculate(parentNode);
				System.out.println(result[0]);
			}
			tree.expandPath(new TreePath(parentNode.getPath()));
		}

		@Override
		public void treeNodesRemoved(TreeModelEvent e) {

		}

		@Override
		public void treeStructureChanged(TreeModelEvent e) {
		}

	}
	
	private class MyTreeSelectionListener implements TreeSelectionListener{

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}