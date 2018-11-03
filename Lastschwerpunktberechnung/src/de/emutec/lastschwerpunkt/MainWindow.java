package de.emutec.lastschwerpunkt;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTree;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.TextStyle;
import java.util.Collection;
import java.util.Enumeration;

import javax.swing.JSplitPane;
import java.awt.Canvas;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.TreeModelListener;
import javax.swing.Box;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import javafx.stage.Screen;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.List;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import java.awt.Button;
import java.awt.event.KeyEvent;
import javax.swing.DropMode;
import java.awt.event.ActionListener;

public class MainWindow {

	private JFrame Lastschwerpunktberechnung;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		
		Lastschwerpunktberechnung = new JFrame();
		Lastschwerpunktberechnung.setMaximumSize(new Dimension(0, 0));
		Lastschwerpunktberechnung.setIconImage(Toolkit.getDefaultToolkit().getImage("I:\\Vorlagen\\Logos-emutec-GROUP\\Logo GRID SYSTEMS\\Logo_emutec_Grid_System_RGB.jpg"));
		Lastschwerpunktberechnung.setMinimumSize(new Dimension(800, 600));
		Lastschwerpunktberechnung.setExtendedState(Frame.MAXIMIZED_BOTH);
		Lastschwerpunktberechnung.setTitle("Lastschwerpunktberechnung");
		Lastschwerpunktberechnung.setBounds(100, 100, 1550, 910);
		Lastschwerpunktberechnung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Lastschwerpunktberechnung.setVisible(true);
		JMenuBar menuBar = new JMenuBar();
		Lastschwerpunktberechnung.setJMenuBar(menuBar);
		Lastschwerpunktberechnung.getContentPane().setLayout(new BorderLayout(0, 0));
		
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
		Lastschwerpunktberechnung.getContentPane().add(panelNavigation, BorderLayout.WEST);
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
		Lastschwerpunktberechnung.getContentPane().add(panelMap);
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

	protected void editBuilding() {
		// TODO Auto-generated method stub
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
