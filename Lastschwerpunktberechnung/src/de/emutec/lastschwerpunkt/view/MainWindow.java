package de.emutec.lastschwerpunkt.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
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

import de.emutec.lastschwerpunkt.model.DataCollection;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JButton btnAddSector;
	private JButton btnAddImage;
	private JButton btnDelData;
	private JButton btnEditData;

	private JButton btnAddBuilding;
	private JButton btnScaleUp;
	private JButton btnScaleDown;
	
	private JLabel imageLabel;

	private JScrollPane imageScrollPane;

	private JMenu menu;
	private JMenuBar mainMenuBar;

	private JMenuItem mntmExit;
	private JMenuItem mntmHelp;
	private JMenuItem mntmLoadProject;
	private JMenuItem mntmNewProject;
	private JMenuItem mntmSaveProject;
	private JMenuItem mntmSaveProjectAs;

	private JPanel panelMap;
	private JPanel panelNavigation;

	private JToolBar toolBar;
	private JScrollPane treeScrollPane;

	// Create the application
	public MainWindow() {
		super("Lastschwerpunktberechnung");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Timo.Nordhorn\\git\\Lastschwerpunkt\\Lastschwerpunktberechnung\\src\\de\\emutec\\lastschwerpunkt\\emutec GRID SYSTEMS.png"));
		this.setMinimumSize(new Dimension(800, 600));
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Set the main parts of the window
		mainMenuBar = new JMenuBar();
		this.setJMenuBar(mainMenuBar);
		this.getContentPane().setLayout(new BorderLayout(0, 0));

		this.panelNavigation = new JPanel();
		this.getContentPane().add(panelNavigation, BorderLayout.WEST);

		this.panelMap = new JPanel();
		this.getContentPane().add(panelMap, BorderLayout.CENTER);

		// Setting up the menu bar
		menu = new JMenu("Datei");
		mainMenuBar.add(menu);

		/*
		 * mntmHelp = new JMenuItem(MainWindowConstants.HELP);
		 * mntmHelp.setActionCommand(MainWindowConstants.HELP);
		 * mainMenuBar.add(mntmHelp);
		 */

		mntmNewProject = new JMenuItem(MainWindowConstants.NEW_PROJECT);
		mntmNewProject.setActionCommand(MainWindowConstants.NEW_PROJECT);
		menu.add(mntmNewProject);

		mntmLoadProject = new JMenuItem(MainWindowConstants.LOAD_PROJECT);
		mntmLoadProject.setActionCommand(MainWindowConstants.LOAD_PROJECT);
		menu.add(mntmLoadProject);

		mntmSaveProject = new JMenuItem(MainWindowConstants.SAVE_PROJECT);
		mntmSaveProject.setActionCommand(MainWindowConstants.SAVE_PROJECT);
		menu.add(mntmSaveProject);

		mntmSaveProjectAs = new JMenuItem(MainWindowConstants.SAVE_PROJECT_AS);
		mntmSaveProjectAs.setActionCommand(MainWindowConstants.SAVE_PROJECT_AS);
		menu.add(mntmSaveProjectAs);

		mntmExit = new JMenuItem(MainWindowConstants.EXIT);
		mntmExit.setActionCommand(MainWindowConstants.EXIT);
		menu.add(mntmExit);

		// Left panel for tree and buttons
		panelNavigation.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 1;
		treeScrollPane = new JScrollPane(DataCollection.INSTANCE.getTree());
		panelNavigation.add(treeScrollPane, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;

		btnAddBuilding = new JButton(MainWindowConstants.ADD_BUILDING);
		btnAddBuilding.setActionCommand(MainWindowConstants.ADD_BUILDING);
		panelNavigation.add(btnAddBuilding, c);

		btnAddSector = new JButton(MainWindowConstants.ADD_SECTOR);
		btnAddSector.setActionCommand(MainWindowConstants.ADD_SECTOR);
		panelNavigation.add(btnAddSector, c);

		btnEditData = new JButton(MainWindowConstants.EDIT_DATA);
		btnEditData.setActionCommand(MainWindowConstants.EDIT_DATA);
		panelNavigation.add(btnEditData, c);

		btnDelData = new JButton(MainWindowConstants.DELETE_DATA);
		btnDelData.setActionCommand(MainWindowConstants.DELETE_DATA);
		panelNavigation.add(btnDelData, c);

		// Panel for the Map and editingToolbar
		panelMap.setLayout(new BorderLayout());
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBackground(new Color(0, 123, 10));
		panelMap.add(toolBar, BorderLayout.NORTH);

		btnAddImage = new JButton(MainWindowConstants.ADD_IMAGE);
		btnAddImage.setActionCommand(MainWindowConstants.ADD_IMAGE);
		toolBar.add(btnAddImage);
		
		btnScaleUp = new JButton("+");
		btnScaleUp.setActionCommand("+");
		toolBar.add(btnScaleUp);
		
		btnScaleDown = new JButton("-");
		btnScaleDown.setActionCommand("-");
		toolBar.add(btnScaleDown);

		imageLabel = new JLabel();
		imageScrollPane = new JScrollPane(imageLabel);
		panelMap.add(imageScrollPane, BorderLayout.CENTER);

	} // End of constructor

	public void btnChooseImage(ActionListener a) {
		btnAddImage.addActionListener(a);
	}
	
	public void btnScaleImage(ActionListener a) {
		btnScaleUp.addActionListener(a);
		btnScaleDown.addActionListener(a);
	}

	public void buttonListener(ActionListener a) {
		btnAddBuilding.addActionListener(a);
		btnAddSector.addActionListener(a);
		btnEditData.addActionListener(a);
		btnDelData.addActionListener(a);
	}

	public void mntmListener(ActionListener menuActionListener) {
		mntmExit.addActionListener(menuActionListener);
		// mntmHelp.addActionListener(menuActionListener);
		mntmLoadProject.addActionListener(menuActionListener);
		mntmNewProject.addActionListener(menuActionListener);
		mntmSaveProject.addActionListener(menuActionListener);
		mntmSaveProjectAs.addActionListener(menuActionListener);
	}

	public void setImage(BufferedImage image) {
		imageLabel.setIcon(new ImageIcon(image));
	}
	
	public void mapPosition(MouseListener l) {
		imageLabel.addMouseListener(l);
	}

}
