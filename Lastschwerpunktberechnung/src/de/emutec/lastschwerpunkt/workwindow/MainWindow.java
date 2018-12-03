package de.emutec.lastschwerpunkt.workwindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {

	// Objects to use on this window
	private JPanel panelNavigation = new JPanel();
	private JPanel panelEditBuildings = new JPanel();
	private JPanel panelEditSectors = new JPanel();
	private JPanel panelMap = new JPanel();
	private JPanel panelImage = new JPanel();

	private JMenuBar menuBar = new JMenuBar();

	private JMenu menu = new JMenu("Datei");

	private JMenuItem mntmNewProject = new JMenuItem("Neues Projekt");
	private JMenuItem mntmLoadProject = new JMenuItem("Projekt Laden");
	private JMenuItem mntmSaveProject = new JMenuItem("Projekt speichern");
	private JMenuItem mntmSaveProjectAs = new JMenuItem("Projekt speichern unter...");
	private JMenuItem mntmExit = new JMenuItem("Beenden");
	private JMenuItem mntmHelp = new JMenuItem("?");

	private JTree tree = new JTree();

	private JButton btnGebudeHinzufgen = new JButton("Geb\u00E4ude hinzuf\u00FCgen");
	private JButton btnGebudeLschen = new JButton("Geb\u00E4ude l\u00F6schen");
	private JButton btnGebudeBearbeiten = new JButton("Geb\u00E4ude bearbeiten");
	private JButton btnAddSector = new JButton("Sektor hinzufügen");
	private JButton btnEditSector = new JButton("Sektor bearbeiten");
	private JButton btnDelSector = new JButton("Sektor löschen");

	private JToolBar toolBar = new JToolBar();

	// Create the application
	public MainWindow() {

		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("I:\\Vorlagen\\Logos-emutec-GROUP\\Logo GRID SYSTEMS\\Logo_emutec_Grid_System_RGB.jpg"));
		this.setMinimumSize(new Dimension(800, 600));
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("Lastschwerpunktberechnung");
		this.setBounds(100, 100, 1550, 910);
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
		menu.add(mntmLoadProject);
		menu.add(mntmSaveProject);
		menu.add(mntmSaveProjectAs);
		menu.add(mntmExit);

		// Left panel for tree and buttons
		panelNavigation.setMinimumSize(new Dimension(50, 200));
		panelNavigation.setPreferredSize(new Dimension(250, 0));
		panelNavigation.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		tree.setDragEnabled(true);
		tree.setRowHeight(25);
		tree.setAutoscrolls(true);
		tree.setMaximumSize(new Dimension(200, 0));
		tree.setMinimumSize(new Dimension(100, 0));
		tree.setShowsRootHandles(true);
		tree.setRootVisible(false);

		panelNavigation.add(tree, c);

		// Panel for building-editing buttons
		// panelEditBuildings.setPreferredSize(new Dimension(0, 100));
		// panelEditBuildings.setMinimumSize(new Dimension(10, 150));
		c.anchor = GridBagConstraints.SOUTH;
		c.gridwidth = GridBagConstraints.REMAINDER;

		panelNavigation.add(btnGebudeHinzufgen, c);
		panelNavigation.add(btnGebudeLschen, c);
		panelNavigation.add(btnGebudeBearbeiten, c);

		// panel for the sector-editing buttons
		// panelEditSectors.setPreferredSize(new Dimension(0,100));
		// panelEditSectors.setMinimumSize(new Dimension(10,150));
		c.gridy = 2;
		panelNavigation.add(panelEditSectors, c);
		panelEditSectors.setLayout(new GridBagLayout());

		c.gridy = 0;
		panelEditSectors.add(btnAddSector, c);
		c.gridy = 1;
		panelEditSectors.add(btnEditSector, c);
		c.gridy = 2;
		panelEditSectors.add(btnDelSector, c);

		// Panel for the Map and editing
		panelMap.setLayout(new BorderLayout(5, 5));
		panelMap.add(toolBar, BorderLayout.NORTH);
		toolBar.setFloatable(false);

		panelMap.add(panelImage, BorderLayout.CENTER);

	} // End of constructor

	public void btnGebudeHinzufgenListener(ActionListener listenForAddBuildingButton) {
		btnGebudeHinzufgen.addActionListener(listenForAddBuildingButton);
	}

	public void btnGebudeBearbeitenListener(ActionListener listenForEditBuildingButton) {
		btnGebudeBearbeiten.addActionListener(listenForEditBuildingButton);
	}

	public void btnGebudeEntfernenListener(ActionListener listenForDeleteBuildingButton) {
		btnGebudeBearbeiten.addActionListener(listenForDeleteBuildingButton);
	}

}
