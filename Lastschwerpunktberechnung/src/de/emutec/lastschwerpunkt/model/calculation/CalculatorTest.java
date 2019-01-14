package de.emutec.lastschwerpunkt.model.calculation;

import static org.junit.Assert.assertArrayEquals;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

import javax.swing.tree.DefaultMutableTreeNode;

import org.junit.jupiter.api.Test;

import de.emutec.lastschwerpunkt.model.data.Building;
import de.emutec.lastschwerpunkt.model.data.Sector;

class CalculatorTest {	
	
	@Test
	void testCalculate() {
		Sector test = new Sector("Test", 1, Color.BLACK);
		Building b1 = new Building("Test 1", 1, 20, new Point(10,100), test);
		Building b2 = new Building("Test 2", 2, 10, new Point(25,7), test);
		Building b3 = new Building("Test 3", 3, 70, new Point(102,55), test);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(test);
		root.add(new DefaultMutableTreeNode(b1));
		root.add(new DefaultMutableTreeNode(b2));
		root.add(new DefaultMutableTreeNode(b3));
		assertArrayEquals(new Object[] {new Point2D.Double(75.9, 59.2), 100d}, Calculator.calculate(root));
	}

}
