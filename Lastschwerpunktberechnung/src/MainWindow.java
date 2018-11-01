import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTree;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.Lastschwerpunktberechnung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Lastschwerpunktberechnung = new JFrame();
		Lastschwerpunktberechnung.setMaximumSize(new Dimension(0, 0));
		Lastschwerpunktberechnung.setIconImage(Toolkit.getDefaultToolkit().getImage("I:\\Vorlagen\\Logos-emutec-GROUP\\Logo GRID SYSTEMS\\Logo_emutec_Grid_System_RGB.jpg"));
		Lastschwerpunktberechnung.setMinimumSize(new Dimension(800, 600));
		Lastschwerpunktberechnung.setExtendedState(Frame.MAXIMIZED_BOTH);
		Lastschwerpunktberechnung.setTitle("Lastschwerpunktberechnung");
		Lastschwerpunktberechnung.setBounds(100, 100, 1550, 910);
		Lastschwerpunktberechnung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		Lastschwerpunktberechnung.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Datei");
		menuBar.add(menu);
		
		JMenuItem mntmNewProject = new JMenuItem("Neues Projekt");
		mntmNewProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
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
		mntmHelp.setHorizontalTextPosition(SwingConstants.RIGHT);
		mntmHelp.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmHelp);
		Lastschwerpunktberechnung.getContentPane().setLayout(new BorderLayout(0, 0));
		
		Panel panelNavigation = new Panel();
		panelNavigation.setMinimumSize(new Dimension(50, 200));
		panelNavigation.setPreferredSize(new Dimension(250, 0));
		Lastschwerpunktberechnung.getContentPane().add(panelNavigation, BorderLayout.WEST);
		panelNavigation.setLayout(new BorderLayout(0, 0));
		
		JTree tree = new JTree();
		tree.setDragEnabled(true);
		tree.setRowHeight(30);
	
		panelNavigation.add(tree, BorderLayout.CENTER);
		tree.setAutoscrolls(true);
		tree.setMaximumSize(new Dimension(200, 0));
		tree.setMinimumSize(new Dimension(100, 0));
		tree.setModel(new DefaultTreeModel(
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
		tree.setShowsRootHandles(true);
		tree.setVisibleRowCount(10);
		tree.setRootVisible(false);
		//Lastschwerpunktberechnung.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{Lastschwerpunktberechnung.getContentPane(), tree, menuBar, menu, mntmExit}));
		
		JPanel panelEditBuildings = new JPanel();
		panelEditBuildings.setPreferredSize(new Dimension(0, 100));
		panelEditBuildings.setMinimumSize(new Dimension(10, 150));
		panelNavigation.add(panelEditBuildings, BorderLayout.SOUTH);
		FlowLayout fl_panelEditBuildings = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panelEditBuildings.setLayout(fl_panelEditBuildings);
		
		JButton btnGebudeHinzufgen = new JButton("Geb\u00E4ude hinzuf\u00FCgen");
		btnGebudeHinzufgen.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnGebudeHinzufgen.setAutoscrolls(true);
		buttonGroup.add(btnGebudeHinzufgen);
		panelEditBuildings.add(btnGebudeHinzufgen);
		
		JButton btnGebudeLschen = new JButton("Geb\u00E4ude l\u00F6schen");
		btnGebudeLschen.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnGebudeLschen.setAutoscrolls(true);
		buttonGroup.add(btnGebudeLschen);
		panelEditBuildings.add(btnGebudeLschen);
		
		JButton btnGebudeBearbeiten = new JButton("Geb\u00E4ude bearbeiten");
		btnGebudeBearbeiten.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode(tree.getLastSelectedPathComponent());
			if(temp.isLeaf()) {
				System.out.println("Zu bearbeitendes Gebäude: " + temp + temp.getLeafCount());	
			}
			else {
				System.out.println("Zu bearbeitender Sektor: " + temp);
			}
			}
		});
		btnGebudeBearbeiten.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnGebudeBearbeiten.setAutoscrolls(true);
		buttonGroup.add(btnGebudeBearbeiten);
		panelEditBuildings.add(btnGebudeBearbeiten);
		btnGebudeHinzufgen.addMouseListener(new MouseAdapter() {
			@Override
			//Methode zum erstellen eines Gebäudes aufrufen
			public void mouseClicked(MouseEvent arg0) {
				tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Liegenschaft") {
					{
						DefaultMutableTreeNode Section = new DefaultMutableTreeNode("Penis");
						Section.add(new DefaultMutableTreeNode("Pimmel"));
						add(Section);						
					}
				}));
				
				
				
				
				
			}
		});
		
		JPanel panelMap = new JPanel();
		panelMap.setPreferredSize(new Dimension(0, 0));
		panelMap.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Lastschwerpunktberechnung.getContentPane().add(panelMap);
		panelMap.setLayout(new BorderLayout(5, 5));
		
		JToolBar toolBar = new JToolBar();
		panelMap.add(toolBar, BorderLayout.NORTH);
		toolBar.setFloatable(false);
		
		JPanel panelImage = new JPanel();
		panelImage.setForeground(Color.MAGENTA);
		panelImage.setMaximumSize(new Dimension(0, 0));
		panelMap.add(panelImage, BorderLayout.CENTER);
		panelImage.setBackground(Color.PINK);
		panelImage.setLayout(new BorderLayout(0, 0));
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
