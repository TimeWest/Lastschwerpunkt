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
import javax.swing.Box;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.ScrollPaneConstants;

public class MainWindow {

	private JFrame Lastschwerpunktberechnung;

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
		Lastschwerpunktberechnung.setTitle("Lastschwerpunktberechnung");
		Lastschwerpunktberechnung.setBounds(100, 100, 450, 300);
		Lastschwerpunktberechnung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		Lastschwerpunktberechnung.setJMenuBar(menuBar);
		
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
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator);
		
		JMenuItem menuItem_1 = new JMenuItem("?");
		menuItem_1.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(menuItem_1);
		Lastschwerpunktberechnung.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		Lastschwerpunktberechnung.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(5, 5));
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		panel.add(toolBar, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignOnBaseline(true);
		flowLayout.setHgap(0);
		flowLayout.setVgap(0);
		panel_1.setBackground(Color.PINK);
		scrollPane_1.setViewportView(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		Lastschwerpunktberechnung.getContentPane().add(scrollPane, BorderLayout.WEST);
		
		JTree tree = new JTree();
		tree.setEditable(true);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
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
							node_2.add(new DefaultMutableTreeNode("green"));
						node_1.add(node_2);
					add(node_1);
				}
			}
		));
		
		scrollPane.setRowHeaderView(tree);
		tree.setShowsRootHandles(true);
		tree.setVisibleRowCount(10);
		tree.setRootVisible(false);
		Lastschwerpunktberechnung.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{Lastschwerpunktberechnung.getContentPane(), panel, toolBar, scrollPane_1, panel_1, scrollPane, tree, menuBar, menu, mntmExit}));
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
