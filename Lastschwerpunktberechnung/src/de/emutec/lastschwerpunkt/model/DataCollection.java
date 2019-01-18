package de.emutec.lastschwerpunkt.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import de.emutec.lastschwerpunkt.model.calculation.Calculator;
import de.emutec.lastschwerpunkt.model.data.Building;
import de.emutec.lastschwerpunkt.model.data.Data;
import de.emutec.lastschwerpunkt.model.data.Sector;

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
				DefaultMutableTreeNode sectorNode = (DefaultMutableTreeNode) root.getChildAt(i);
				treeModel.insertNodeInto(new DefaultMutableTreeNode(data, false), sectorNode,
						sectorNode.getChildCount());
				success = true;
				break;
			}
		}

		if (!success) {
			treeModel.insertNodeInto(new DefaultMutableTreeNode(data), root, root.getChildCount());
			((Building) data).setSector(root.getUserObject());
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
	public void insertData(Object data) throws IllegalArgumentException {
		if (data == null) {
			System.out.println("Abbruch");
			return;
		}

		if (data instanceof Building) {
			insertBuilding(data);
		} else if (data instanceof Sector) {
			insertSector(data);
		} else {
			throw new IllegalArgumentException();
		}
		
//		reload(data);
		System.out.println("Dieses Objekt kam zurück: " + data + "\nKlasse: " + data.getClass());
	}

	private class MyTreeModelListener implements TreeModelListener {
		// TODO Notification for Map and painting on it
		@Override
		public void treeNodesChanged(TreeModelEvent e) {
			System.out.println("DataCollection: treeNodesChanged:\n" + e);
		}

		@Override
		public void treeNodesInserted(TreeModelEvent e) {
			System.out.println("DataCollection: treeNodesInserted:\n" + e);
			// Expand TreePath to inserted node
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
			System.out.println("DataCollection: treeNodesRemoved:\n" + e);
		}

		@Override
		public void treeStructureChanged(TreeModelEvent e) {
			System.out.println("DataCollection: treeStructureChanged:\n" + e);
		}
		
	}

	public void editData(Object newData, Object oldData) {
		// TODO implement editData
		System.out.println("TODO: implement editData");
		Enumeration<TreeNode> e = ((DefaultMutableTreeNode) treeModel.getRoot()).breadthFirstEnumeration();
		while (e.hasMoreElements()) {
			DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) e.nextElement();
			if (treeNode.toString().equals(oldData.toString())) {
				((DefaultMutableTreeNode) treeModel.getChild(treeNode.getParent(), treeNode.getParent().getIndex(treeNode))).setUserObject(newData);
				
				
				//treeModel.insertNodeInto(new DefaultMutableTreeNode(newData), (DefaultMutableTreeNode) treeNode.getParent(), treeNode.getParent().getIndex(treeNode));
				break;
			}
			
		}

	}

	public void deleteData(Object data) {
		// TODO implement deleteData
		System.out.println("TODO: implement deleteData");
	}

}
