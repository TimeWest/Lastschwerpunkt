package de.emutec.lastschwerpunkt.model;

import java.awt.Color;
import java.awt.geom.Point2D;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

import de.emutec.lastschwerpunkt.model.data.Building;
import de.emutec.lastschwerpunkt.model.data.Sector;

public abstract class ExampleData {

	public static void insert(DefaultTreeModel treeModel) {
		DefaultMutableTreeNode sec1 = new DefaultMutableTreeNode(new Sector("Mars", 1, Color.RED));
		DefaultMutableTreeNode sec2 = new DefaultMutableTreeNode(new Sector("Jupiter", 5, Color.LIGHT_GRAY));
		sec1.add(new DefaultMutableTreeNode(new Building("Phobos", 1, 2139, new Point2D.Double(27, 22), 1, "Nächster Mond des Mars", sec1, true)));
		sec1.add(new DefaultMutableTreeNode(new Building("Deimos", 2, 1351, new Point2D.Double(15, 12.2), 1, "Zweiter Mond des Mars", sec1, true)));
		sec2.add(new DefaultMutableTreeNode(new Building("Io", 1, 17.3, new Point2D.Double(4216000, 0), 1, "Größter Mond des Jupiter", sec2, true)));
		sec2.add(new DefaultMutableTreeNode(new Building("Europa", 2, 13.74, new Point2D.Double(670900, 0), 1, "Zweitgrößter Mond des Jupiter", sec2, true)));
		sec2.add(new DefaultMutableTreeNode(new Building("Ganymed", 3, 10.88, new Point2D.Double(1070400, 0), 1, "Drittgrößter Mond des Jupiter", sec2, true)));
		sec2.add(new DefaultMutableTreeNode(new Building("Kallisto", 4, 8.2, new Point2D.Double(1882700, 0), 1, "Viertgrößter Mond des Jupiter", sec2, true)));	
		
		treeModel.insertNodeInto(sec1, (MutableTreeNode) treeModel.getRoot(), 0);
		treeModel.insertNodeInto(sec2, (MutableTreeNode) treeModel.getRoot(), 1);
	}
}
