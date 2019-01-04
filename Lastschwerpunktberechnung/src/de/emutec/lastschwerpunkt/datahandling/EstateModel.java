package de.emutec.lastschwerpunkt.datahandling;

import java.util.ArrayList;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class EstateModel implements TreeModel {

	private ArrayList<TreeModelListener> treeModelListeners = new ArrayList<>();
	private Sector root;

	public EstateModel(Sector root) {
		this.root = root;
	}

	@Override
	public Object getRoot() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public Object getChild(Object parent, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount(Object parent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isLeaf(Object node) {
		return (node instanceof Building && this.getChildCount(node) == 0);
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TDO Auto-generated method stub

	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		treeModelListeners.add(l);

	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		treeModelListeners.remove(l);

	}


}
