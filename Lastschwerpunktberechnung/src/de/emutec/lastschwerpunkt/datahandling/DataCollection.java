package de.emutec.lastschwerpunkt.datahandling;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

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

	/** Collection of data */
	private List<Data> data = new LinkedList<>();

	/** Current selected data */
	private Object currentObject;
	private DefaultMutableTreeNode root;
	private DefaultTreeModel treeModel;
	private JTree tree;

	/**
	 * @return the treeModel
	 */
	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}

	/**
	 * @param treeModel
	 *            the treeModel to set
	 */
	public void setTreeModel(DefaultTreeModel treeModel) {
		this.treeModel = treeModel;
	}

	/**
	 * @return the tree
	 */
	public JTree getTree() {
		return tree;
	}

	/**
	 * @return the current object
	 */
	public Object getCurrentObjectPath() {
		return currentObject;
	}

	public Object getCurrentObject() {
		return ((DefaultMutableTreeNode) getCurrentObjectPath()).getUserObject();
	}

	/**
	 * @param o
	 *            the o to set
	 */
	public void setCurrentObject(TreePath o) {
		this.currentObject = o;
		System.out.println(o.toString());
	}

	/**
	 * Add data to a Collection
	 * 
	 * @param currentObject
	 *            Object that triggered the Event
	 * @param data
	 *            element to add to Collection
	 * @return {@code true} if element has successfully been added
	 */
	private boolean putData(Object data) {
		treeModel.insertNodeInto(new DefaultMutableTreeNode(data), root, root.getChildCount());
		return true;
	}

	private void insertSector(Object data) {
		treeModel.insertNodeInto(new DefaultMutableTreeNode(data), root, root.getChildCount());
	}

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

	private void reload(Object data) {
		treeModel.reload();
		tree.scrollPathToVisible(new TreePath(new DefaultMutableTreeNode(data).getPath()));
	}

	/**
	 * 
	 * @return the complete collection as {@code Object[]}
	 */
	public Object[] getDataCollection() {
		return data.toArray();
	}

	public Object[] getObjectsOfClass(Class<?> newType) {
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
	 * Edit an existing element in this collection if it is contained. Else add it
	 * to the collection.
	 * 
	 * @param currentObject
	 *            Object that triggered the Event
	 * @param d
	 *            element to add to collection
	 * @return {@code true} if element has successfully been added to collection.
	 */
	public boolean editData(Data d) {
		boolean returnValue;
		if (!this.data.contains(d)) {
			returnValue = putData(d);
		} else {
			this.data.set(this.data.indexOf(getCurrentObjectPath()), d);
			returnValue = true;
		}
		if (returnValue) {
			DataHandler.INSTANCE.notifyListeners(new DataEvent(this, d));
		}
		return returnValue;
	}

	/**
	 * remove given data from collection
	 * 
	 * @param d
	 *            data to be deleted
	 * @return {@code true} if this collection contained the specified element
	 */
	public boolean removeData(Data d) {
		return data.remove(d);
	}

	/**
	 * removes all of the elements from the collection all entries will be lost.
	 */
	public void clearData() {
		data.clear();
	}

	public void setUpTreeAndModel() {
		treeModel = new DefaultTreeModel(new DefaultMutableTreeNode(new Sector("MSSA", 0, Color.WHITE)));
		root = (DefaultMutableTreeNode) treeModel.getRoot();
		treeModel.addTreeModelListener(new MyTreeModelListener());
		tree = new JTree(treeModel);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setRootVisible(false);
	}

	private class MyTreeModelListener implements TreeModelListener {
		// TODO Notification for Map and painting on it
		@Override
		public void treeNodesChanged(TreeModelEvent e) {

		}

		@Override
		public void treeNodesInserted(TreeModelEvent e) {

		}

		@Override
		public void treeNodesRemoved(TreeModelEvent e) {

		}

		@Override
		public void treeStructureChanged(TreeModelEvent e) {

		}

	}

	public void insertData(Object returnValue, String command) {
		// TODO insert returnValue from EditWindow into TreeModel
		if (returnValue == null) {
			return;
		}
		switch (command) {
		case MainWindowConstants.EDIT_DATA:
			break;
		case MainWindowConstants.ADD_BUILDING:
			insertBuilding(returnValue);
			break;
		case MainWindowConstants.ADD_SECTOR:
			insertSector(returnValue);
			break;
		case MainWindowConstants.DELETE_DATA:
			break;
		default:

			break;
		}
		reload(returnValue);
		System.out.println("Dieses Objekt kam zurück: " + returnValue + "\nKlasse: " + returnValue.getClass());
	}
}
