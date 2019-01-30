package de.emutec.lastschwerpunkt.model.calculation;

import java.awt.Point;
import java.awt.geom.Point2D;

import javax.swing.tree.DefaultMutableTreeNode;

import de.emutec.lastschwerpunkt.model.data.Building;

public class Calculator {

	private Calculator() {
		
	}
	/**
	 * 
	 * @return Object[] containing a Point2D for Location and summed-up load.
	 */
	public static Object[] calculate(DefaultMutableTreeNode sector) {
		// zu späterem Zeitpunkt mit rekursivem Aufruf über Abfrage, ob Kindknoten vorhanden sind.
		// machbar mit Enumeration von sector.children()
		Point2D schwerpunkt = new Point2D.Double();
		double loadSum = 0;
		for (int i = 0; i < sector.getChildCount(); i++) {
			Building currentChild = (Building) ((DefaultMutableTreeNode) sector.getChildAt(i)).getUserObject();
			double currentLoad = currentChild.getLoad();
			loadSum += currentChild.getLoad();
			schwerpunkt.setLocation(
					schwerpunkt.getX() + currentChild.getCoordinates().getX()*currentLoad,
					schwerpunkt.getY() + currentChild.getCoordinates().getY()*currentLoad);
			
		}
		if (loadSum != 0) {
			schwerpunkt.setLocation(schwerpunkt.getX() / loadSum, schwerpunkt.getY() / loadSum);
			return new Object[] { schwerpunkt, loadSum };
		}
		return new Object[] { new Point(), loadSum };

	}

}
