package de.emutec.lastschwerpunkt;

import de.emutec.lastschwerpunkt.controller.MainButtonController;
import de.emutec.lastschwerpunkt.controller.MapController;
import de.emutec.lastschwerpunkt.controller.MenuController;
import de.emutec.lastschwerpunkt.view.MainWindow;

/**
 * @author Timo.Nordhorn
 */
public class Main {

	public static void main(String[] args) {
		/**
		 * Launch the application.
		 */
         javax.swing.SwingUtilities.invokeLater( () -> createAndShowGUI());
        
	}
	
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
    	//Create and set up the window.
    	MainWindow frame = new MainWindow();
        //Create and set up the content pane.
		new MainButtonController(frame);
		new MenuController(frame);
		new MapController(frame);
		
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
