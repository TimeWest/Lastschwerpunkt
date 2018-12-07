package de.emutec.lastschwerpunkt;

import javax.swing.tree.TreePath;

import de.emutec.lastschwerpunkt.building.BuildingCollection;
import de.emutec.lastschwerpunkt.sector.SectorCollection;
import de.emutec.lastschwerpunkt.workwindow.MainButtonController;
import de.emutec.lastschwerpunkt.workwindow.MainWindow;
import de.emutec.lastschwerpunkt.workwindow.MapController;
import de.emutec.lastschwerpunkt.workwindow.MenuController;
import de.emutec.lastschwerpunkt.workwindow.TreeController;


/**
 * @author Timo.Nordhorn
 */
public class Main {

	public static void main(String[] args) {
		/**
		 * Launch the application.
		 */
		TreePath path = null;
		MainWindow mainWindow = new MainWindow();
		SectorCollection sectorCollection = new SectorCollection();
		BuildingCollection buildingCollection = new BuildingCollection();
		new TreeController(mainWindow, path);
		new MapController(mainWindow);
		new MenuController(mainWindow);
		new MainButtonController(mainWindow, buildingCollection, sectorCollection);
	
		mainWindow.setVisible(true);
		
	}	
}
