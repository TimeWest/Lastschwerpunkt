package de.emutec.lastschwerpunkt.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.event.TreeSelectionListener;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JButton btnAddBuilding = new JButton("Geb\u00E4ude hinzuf\u00FCgen");
	private JButton btnAddImage = new JButton("Bild");
	private JButton btnAddSector = new JButton("Sektor hinzufügen");
	private JButton btnDelBuilding = new JButton("Geb\u00E4ude l\u00F6schen");
	private JButton btnDelSector = new JButton("Sektor löschen");
	private JButton btnEditBuilding = new JButton("Geb\u00E4ude bearbeiten");
	private JButton btnEditSector = new JButton("Sektor bearbeiten");

	private JLabel imageLabel = new JLabel();
	
	private JScrollPane imageScrollPane = new JScrollPane(imageLabel);
	
	private JMenu menu = new JMenu("Datei");
	private JMenuBar menuBar = new JMenuBar();

	private JMenuItem mntmExit = new JMenuItem("Beenden");
	private JMenuItem mntmHelp = new JMenuItem("?");
	private JMenuItem mntmLoadProject = new JMenuItem("Projekt Laden");
	private JMenuItem mntmNewProject = new JMenuItem("Neues Projekt");
	private JMenuItem mntmSaveProject = new JMenuItem("Projekt speichern");
	private JMenuItem mntmSaveProjectAs = new JMenuItem("Projekt speichern unter...");
	
	private JPanel panelMap = new JPanel();
	private JPanel panelNavigation = new JPanel();

	private JToolBar toolBar = new JToolBar();
	
	private JTree tree = new JTree();
	private JScrollPane treeScrollPane = new JScrollPane(tree);

	// Create the application
	public MainWindow() {
		super("Lastschwerpunktberechnung");
		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("I:\\Vorlagen\\Logos-emutec-GROUP\\Logo GRID SYSTEMS\\Logo_emutec_Grid_System_RGB.jpg"));
		this.setMinimumSize(new Dimension(800, 600));
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Set the main parts of the window
		this.setJMenuBar(menuBar);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.getContentPane().add(panelNavigation, BorderLayout.WEST);
		this.getContentPane().add(panelMap);

		// Setting up the menu bar
		menuBar.add(menu);
		menuBar.add(mntmHelp);
		menu.add(mntmNewProject);
		mntmNewProject.setActionCommand("newProject");
		menu.add(mntmLoadProject);
		mntmLoadProject.setActionCommand("loadProject");
		menu.add(mntmSaveProject);
		mntmSaveProject.setActionCommand("SaveProject");
		menu.add(mntmSaveProjectAs);
		mntmSaveProjectAs.setActionCommand("newProjectAs");
		menu.add(mntmExit);
		mntmExit.setActionCommand("exit");

		// Left panel for tree and buttons
		panelNavigation.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		tree.setRowHeight(25);
		tree.setShowsRootHandles(true);
		tree.setRootVisible(false);
		tree.setEditable(true);

		c.gridx = 0;
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 1;
		panelNavigation.add(treeScrollPane, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;

		btnAddBuilding.setActionCommand("addBuilding");
		panelNavigation.add(btnAddBuilding, c);
		btnEditBuilding.setActionCommand("editBuilding");
		panelNavigation.add(btnEditBuilding, c);
		btnDelBuilding.setActionCommand("deleteBuilding");
		panelNavigation.add(btnDelBuilding, c);

		btnAddSector.setActionCommand("addSector");
		panelNavigation.add(btnAddSector, c);
		btnEditSector.setActionCommand("editSector");
		panelNavigation.add(btnEditSector, c);
		btnDelSector.setActionCommand("deleteSector");
		panelNavigation.add(btnDelSector, c);

		// Panel for the Map and editingToolbar
		panelMap.setLayout(new BorderLayout());
		panelMap.add(toolBar, BorderLayout.NORTH);
		toolBar.setFloatable(false);
		toolBar.setBackground(new Color(0, 123, 10));

		btnAddImage.setActionCommand("addImage");
		toolBar.add(btnAddImage);

		panelMap.add(imageScrollPane, BorderLayout.CENTER);

		this.pack();
	} // End of constructor

	public void btnChooseImage(ActionListener a) {
		btnAddImage.addActionListener(a);
	}

	public void buttonListener(ActionListener a) {
		btnAddBuilding.addActionListener(a);
		btnEditBuilding.addActionListener(a);
		btnDelBuilding.addActionListener(a);
		btnAddSector.addActionListener(a);
		btnEditSector.addActionListener(a);
		btnDelSector.addActionListener(a);
	}

	public void mntmExitListener(ActionListener menuActionListener) {
		mntmExit.addActionListener(menuActionListener);
	}

	public void setImage(BufferedImage image) {
		imageLabel.setIcon(new ImageIcon(image));
	}

	public void treeSelectionListener(TreeSelectionListener t) {
		tree.getSelectionModel().addTreeSelectionListener(t);
	}

}
