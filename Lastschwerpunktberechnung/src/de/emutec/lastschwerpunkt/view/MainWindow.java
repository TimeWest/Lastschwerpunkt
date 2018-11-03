package de.emutec.lastschwerpunkt.view;
import javax.swing.JFrame;
import javax.swing.JTree;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import de.emutec.lastschwerpunkt.Building;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.Toolkit;

public class MainWindow {

	private JFrame lastschwerpunktberechnung;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		
		lastschwerpunktberechnung = new JFrame();
		lastschwerpunktberechnung.setMaximumSize(new Dimension(0, 0));
		lastschwerpunktberechnung.setIconImage(Toolkit.getDefaultToolkit().getImage("I:\\Vorlagen\\Logos-emutec-GROUP\\Logo GRID SYSTEMS\\Logo_emutec_Grid_System_RGB.jpg"));
		lastschwerpunktberechnung.setMinimumSize(new Dimension(800, 600));
		lastschwerpunktberechnung.setExtendedState(Frame.MAXIMIZED_BOTH);
		lastschwerpunktberechnung.setTitle("Lastschwerpunktberechnung");
		lastschwerpunktberechnung.setBounds(100, 100, 1550, 910);
		lastschwerpunktberechnung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lastschwerpunktberechnung.setVisible(true);
		JMenuBar menuBar = new JMenuBar();
		lastschwerpunktberechnung.setJMenuBar(menuBar);
		lastschwerpunktberechnung.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JMenu menu = new JMenu("Datei");
		menuBar.add(menu);
		
		JMenuItem mntmNewProject = new JMenuItem("Neues Projekt");
		menu.add(mntmNewProject);
		
		JMenuItem mntmLoadProject = new JMenuItem("Projekt Laden");
		menu.add(mntmLoadProject);
		
		JMenuItem mntmSaveProject = new JMenuItem("Projekt speichern");
		menu.add(mntmSaveProject);
		
		JMenuItem mntmSaveProjectAs = new JMenuItem("Projekt speichern unter...");
		menu.add(mntmSaveProjectAs);
		
		JMenuItem mntmExit = new JMenuItem("Beenden");
		menu.add(mntmExit);
		
		JMenuItem mntmHelp = new JMenuItem("?");
		menuBar.add(mntmHelp);
		
		//Left panel for tree and buttons
		Panel panelNavigation = new Panel();
		panelNavigation.setMinimumSize(new Dimension(50, 200));
		panelNavigation.setPreferredSize(new Dimension(250, 0));
		lastschwerpunktberechnung.getContentPane().add(panelNavigation, BorderLayout.WEST);
		panelNavigation.setLayout(new BorderLayout(0, 0));
		
		JTree tree = new JTree();
		tree.setDragEnabled(true);
		tree.setRowHeight(30);
		tree.setAutoscrolls(true);
		tree.setMaximumSize(new Dimension(200, 0));
		tree.setMinimumSize(new Dimension(100, 0));
		tree.setShowsRootHandles(true);
		tree.setVisibleRowCount(10);
		tree.setRootVisible(false);
		
		panelNavigation.add(tree, BorderLayout.CENTER);
		
		
		/*tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					DefaultMutableTreeNode node_3;
					node_1 = new DefaultMutableTreeNode("colors");
						node_1.add(new DefaultMutableTreeNode("blue"));
						node_1.add(new DefaultMutableTreeNode("violet"));
						node_1.add(new DefaultMutableTreeNode("red"));
						node_1.add(new DefaultMutableTreeNode("yellow"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("sports");
						node_1.add(new DefaultMutableTreeNode("basketball"));
						node_1.add(new DefaultMutableTreeNode("soccer"));
						node_1.add(new DefaultMutableTreeNode("football"));
						node_1.add(new DefaultMutableTreeNode("hockey"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("food");
						node_1.add(new DefaultMutableTreeNode("hot dogs"));
						node_1.add(new DefaultMutableTreeNode("pizza"));
						node_1.add(new DefaultMutableTreeNode("ravioli"));
						node_2 = new DefaultMutableTreeNode("bananas");
							node_2.add(new DefaultMutableTreeNode("yellow"));
							node_3 = new DefaultMutableTreeNode("green");
								node_3.add(new DefaultMutableTreeNode("light green"));
								node_3.add(new DefaultMutableTreeNode("dark green"));
							node_2.add(node_3);
						node_1.add(node_2);
					add(node_1);
				}
			}
		));
		*/		
		
		//Panel for building-editing buttons
		JPanel panelEditBuildings = new JPanel();
		panelEditBuildings.setPreferredSize(new Dimension(0, 100));
		panelEditBuildings.setMinimumSize(new Dimension(10, 150));
		panelNavigation.add(panelEditBuildings, BorderLayout.SOUTH);
		FlowLayout fl_panelEditBuildings = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panelEditBuildings.setLayout(fl_panelEditBuildings);
		
		JButton btnGebudeHinzufgen = new JButton("Geb\u00E4ude hinzuf\u00FCgen");
		panelEditBuildings.add(btnGebudeHinzufgen);
		
		JButton btnGebudeLschen = new JButton("Geb\u00E4ude l\u00F6schen");
		panelEditBuildings.add(btnGebudeLschen);
		
		JButton btnGebudeBearbeiten = new JButton("Geb\u00E4ude bearbeiten");
		panelEditBuildings.add(btnGebudeBearbeiten);
		
		//Panel for the Map and editing
		JPanel panelMap = new JPanel();
		panelMap.setPreferredSize(new Dimension(0, 0));
		lastschwerpunktberechnung.getContentPane().add(panelMap);
		panelMap.setLayout(new BorderLayout(5, 5));
		
		JToolBar toolBar = new JToolBar();
		panelMap.add(toolBar, BorderLayout.NORTH);
		toolBar.setFloatable(false);
		
		JPanel panelImage = new JPanel();
		panelImage.setForeground(Color.MAGENTA);
		panelMap.add(panelImage, BorderLayout.CENTER);
		panelImage.setBackground(Color.PINK);
		panelImage.setLayout(new BorderLayout(0, 0));
	}


	private void createBuilding() {
		// TODO First set buildings position by clicking on the map
		try {
			EditBuilding dialog = new EditBuilding(new Building());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
