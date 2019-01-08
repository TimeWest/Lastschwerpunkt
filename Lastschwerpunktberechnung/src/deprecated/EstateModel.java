package de.emutec.lastschwerpunkt.datahandling;

import java.util.ArrayList;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class EstateModel {

	private ArrayList<TreeModelListener> treeModelListeners = new ArrayList<>();
	private Sector root;

	public EstateModel(Sector root) {
		this.root = root;
	}


}
