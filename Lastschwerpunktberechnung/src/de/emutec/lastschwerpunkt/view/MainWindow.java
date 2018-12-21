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
import java.util.Enumeration;

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
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private static final String HELP = "?";
	private static final String NEW_PROJECT = "Neues Projekt";
	private static final String LOAD_PROJECT = "Projekt laden";
	private static final String SAVE_PROJECT = "Projekt speichern";
	private static final String SAVE_PROJECT_AS = "Projekt speichern unter...";
	private static final String EXIT = "Beenden";
	private static final String ADD_BUILDING = "Gebäude hinzufügen";
	private static final String EDIT_BUILDING = "Gebäude bearbeiten";
	private static final String DELETE_BUILDING = "Gebäude löschen";
	private static final String ADD_SECTOR = "Sektor hinzufügen";
	private static final String EDIT_SECTOR = "Sektor bearbeiten";
	private static final String DELETE_SECTOR = "Sektor löschen";
	private static final String ADD_IMAGE = "Lageplan hinzufügen";

	private JButton btnAddBuilding;
	private JButton btnAddImage;
	private JButton btnAddSector;
	private JButton btnDelBuilding;
	private JButton btnDelSector;
	private JButton btnEditBuilding;
	private JButton btnEditSector;

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

	private JTree tree;
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
		mainMenuBar = new JMenuBar();
		this.setJMenuBar(mainMenuBar);
		this.getContentPane().setLayout(new BorderLayout(0, 0));

		this.panelNavigation = new JPanel();
		this.getContentPane().add(panelNavigation, BorderLayout.WEST);

		panelMap = new JPanel();
		this.getContentPane().add(panelMap);

		// Setting up the menu bar
		menu = new JMenu("Datei");
		mainMenuBar.add(menu);

		mntmHelp = new JMenuItem(HELP);
		mntmHelp.setActionCommand(HELP);
		mainMenuBar.add(mntmHelp);

		mntmNewProject = new JMenuItem(NEW_PROJECT);
		mntmNewProject.setActionCommand(NEW_PROJECT);
		menu.add(mntmNewProject);

		mntmLoadProject = new JMenuItem(LOAD_PROJECT);
		mntmLoadProject.setActionCommand(LOAD_PROJECT);
		menu.add(mntmLoadProject);

		mntmSaveProject = new JMenuItem(SAVE_PROJECT);
		mntmSaveProject.setActionCommand(SAVE_PROJECT);
		menu.add(mntmSaveProject);

		mntmSaveProjectAs = new JMenuItem(SAVE_PROJECT_AS);
		mntmSaveProjectAs.setActionCommand(SAVE_PROJECT_AS);
		menu.add(mntmSaveProjectAs);

		mntmExit = new JMenuItem(EXIT);
		mntmExit.setActionCommand(EXIT);
		menu.add(mntmExit);

		// Left panel for tree and buttons
		panelNavigation.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		tree = new JTree();
		tree.setModel(new DefaultTreeModel(new TreeNode() {
			
			@Override
			public boolean isLeaf() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public TreeNode getParent() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getIndex(TreeNode node) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getChildCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public TreeNode getChildAt(int childIndex) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean getAllowsChildren() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Enumeration<? extends TreeNode> children() {
				// TODO Auto-generated method stub
				return null;
			}
		}));
		tree.setRowHeight(25);
		tree.setShowsRootHandles(true);
		tree.setRootVisible(true);
		tree.setEditable(true);

		c.gridx = 0;
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 1;
		panelNavigation.add(treeScrollPane, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;

		btnAddBuilding = new JButton(ADD_BUILDING);
		btnAddBuilding.setActionCommand(ADD_BUILDING);
		panelNavigation.add(btnAddBuilding, c);

		btnEditBuilding = new JButton(EDIT_BUILDING);
		btnEditBuilding.setActionCommand(EDIT_BUILDING);
		panelNavigation.add(btnEditBuilding, c);

		btnDelBuilding = new JButton(DELETE_BUILDING);
		btnDelBuilding.setActionCommand(DELETE_BUILDING);
		panelNavigation.add(btnDelBuilding, c);

		btnAddSector = new JButton(ADD_SECTOR);
		btnAddSector.setActionCommand(ADD_SECTOR);
		panelNavigation.add(btnAddSector, c);

		btnEditSector = new JButton(EDIT_SECTOR);
		btnEditSector.setActionCommand(EDIT_SECTOR);
		panelNavigation.add(btnEditSector, c);

		btnDelSector = new JButton(DELETE_SECTOR);
		btnDelSector.setActionCommand(DELETE_SECTOR);
		panelNavigation.add(btnDelSector, c);

		// Panel for the Map and editingToolbar
		panelMap.setLayout(new BorderLayout());
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBackground(new Color(0, 123, 10));
		panelMap.add(toolBar, BorderLayout.NORTH);

		btnAddImage = new JButton(ADD_IMAGE);
		btnAddImage.setActionCommand(ADD_IMAGE);
		toolBar.add(btnAddImage);

		imageLabel = new JLabel();
		imageScrollPane = new JScrollPane(imageLabel);
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
