package de.emutec.lastschwerpunkt.workwindow;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class MainWindow extends JFrame {

	// Objects to use on this window
	private JPanel panelNavigation = new JPanel();
	private JPanel panelMap = new JPanel();
	private JPanel panelImage = new JPanel();
	
	private JLabel imageLabel = new JLabel();

	private JMenuBar menuBar = new JMenuBar();

	private JMenu menu = new JMenu("Datei");

	private JMenuItem mntmNewProject = new JMenuItem("Neues Projekt");
	private JMenuItem mntmLoadProject = new JMenuItem("Projekt Laden");
	private JMenuItem mntmSaveProject = new JMenuItem("Projekt speichern");
	private JMenuItem mntmSaveProjectAs = new JMenuItem("Projekt speichern unter...");
	private JMenuItem mntmExit = new JMenuItem("Beenden");
	private JMenuItem mntmHelp = new JMenuItem("?");

	private JTree tree = new JTree();
	private JScrollPane scrollPane1 = new JScrollPane(tree);

	private JButton btnAddBuilding = new JButton("Geb\u00E4ude hinzuf\u00FCgen");
	private JButton btnDelBuilding = new JButton("Geb\u00E4ude l\u00F6schen");
	private JButton btnEditBuilding = new JButton("Geb\u00E4ude bearbeiten");
	private JButton btnAddSector = new JButton("Sektor hinzufügen");
	private JButton btnEditSector = new JButton("Sektor bearbeiten");
	private JButton btnDelSector = new JButton("Sektor löschen");
	private JButton btnAddImage = new JButton("Bild");

	private JToolBar toolBar = new JToolBar();

	// Create the application
	public MainWindow() {

		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("I:\\Vorlagen\\Logos-emutec-GROUP\\Logo GRID SYSTEMS\\Logo_emutec_Grid_System_RGB.jpg"));
		this.setMinimumSize(new Dimension(800, 600));
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("Lastschwerpunktberechnung");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

		c.gridx = 0;
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 1;

		panelNavigation.add(scrollPane1, c);
		tree.setDragEnabled(true);
		tree.setRowHeight(25);
		tree.setAutoscrolls(true);
		tree.setShowsRootHandles(true);
		tree.setRootVisible(false);
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

		panelMap.add(imageLabel, BorderLayout.CENTER);

		this.pack();
	} // End of constructor

	public void btnChooseImage(ActionListener a) {
		btnAddImage.addActionListener(a);
	}
	
	public void setImage(BufferedImage image) {
		imageLabel.setIcon(new ImageIcon(image));		
	}

	public void btnListener(ActionListener a) {
		btnAddBuilding.addActionListener(a);
		btnEditBuilding.addActionListener(a);
		btnDelBuilding.addActionListener(a);
		btnAddSector.addActionListener(a);
		btnEditSector.addActionListener(a);
		btnDelSector.addActionListener(a);
	}

	public void treeSelectionListener(TreeSelectionListener t) {
		tree.getSelectionModel().addTreeSelectionListener(t);
	}

	public void mntmExitListener(ActionListener menuActionListener) {
		mntmExit.addActionListener(menuActionListener);
	}
	
	

}
