package de.emutec.lastschwerpunkt.workwindow;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;

import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {

	// Objects to use on this window
	private JPanel panelNavigation = new JPanel();
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
	private JScrollPane scrollPane1 = new JScrollPane(tree);
	
	private JButton btnAddBuilding = new JButton("Geb\u00E4ude hinzuf\u00FCgen");
	private JButton btnDelBuilding = new JButton("Geb\u00E4ude l\u00F6schen");
	private JButton btnEditBuilding = new JButton("Geb\u00E4ude bearbeiten");
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

		panelNavigation.add(btnAddBuilding, c);
		panelNavigation.add(btnEditBuilding, c);
		panelNavigation.add(btnDelBuilding, c);
		panelNavigation.add(btnAddSector, c);
		panelNavigation.add(btnEditSector, c);
		panelNavigation.add(btnDelSector, c);
		
		// Panel for the Map and editing
		panelMap.setLayout(new BorderLayout(5, 5));
		panelMap.add(toolBar, BorderLayout.NORTH);
		toolBar.setFloatable(false);
		toolBar.setBackground(new Color(0, 123, 10));
		toolBar.add(new JLabel("Toolbar"));

		panelMap.add(panelImage, BorderLayout.CENTER);
		panelImage.setBackground(new Color(53, 66, 132));
		
		this.pack();
	} // End of constructor

	public void btnAddBuildingListener(ActionListener listenForAddBuildingButton) {
		btnAddBuilding.addActionListener(listenForAddBuildingButton);
	}

	public void btnEditBuildingListener(ActionListener listenForEditBuildingButton) {
		btnEditBuilding.addActionListener(listenForEditBuildingButton);
	}

	public void btnDelBuildingListener(ActionListener listenForDeleteBuildingButton) {
		btnDelBuilding.addActionListener(listenForDeleteBuildingButton);
	}
	
	public void btnAddSectorListener(ActionListener listenForAddSectorButton) {
		btnAddSector.addActionListener(listenForAddSectorButton);
	}

	public void btnEditSectorListener(ActionListener listenForEditSectorButton) {
		btnEditSector.addActionListener(listenForEditSectorButton);
	}

	public void btnDelSectorListener(ActionListener listenForDeleteSectorButton) {
		btnDelSector.addActionListener(listenForDeleteSectorButton);
	}
	
	public void treeSelectionListener(TreeSelectionListener listenForChangedTreeSelection) {
		tree.getSelectionModel().addTreeSelectionListener(listenForChangedTreeSelection);
	}

}
