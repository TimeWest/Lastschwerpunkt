package de.emutec.lastschwerpunkt.sector;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class Collection {

	private TreePath path;
	private DefaultMutableTreeNode root;
	private DefaultTreeModel treeModel;

	public Collection() {
		root = new DefaultMutableTreeNode("rootNode");
		treeModel = new DefaultTreeModel(root);
	}

	/**
	 * @return the path
	 */
	public TreePath getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(TreePath path) {
		this.path = path;
	}
}
