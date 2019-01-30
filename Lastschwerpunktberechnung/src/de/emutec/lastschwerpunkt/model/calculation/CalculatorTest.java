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
		DefaultMutableTreeNode test = new DefaultMutableTreeNode(new Sector("Test", 1, Color.BLACK));
		DefaultMutableTreeNode b1 = new DefaultMutableTreeNode(new Building("Test 1", 1, 20, new Point(10,100), 0, null, test, true));
		DefaultMutableTreeNode b2 = new DefaultMutableTreeNode(new Building("Test 2", 2, 10, new Point(25,7), 0, null, test, true));
		DefaultMutableTreeNode b3 = new DefaultMutableTreeNode(new Building("Test 3", 3, 70, new Point(102,55), 0, null, test, true));
		test.add(b1);
		test.add(b2);
		test.add(b3);
		assertArrayEquals(new Object[] {new Point2D.Double(75.9, 59.2), 100d}, Calculator.calculate(test));
	}

}
