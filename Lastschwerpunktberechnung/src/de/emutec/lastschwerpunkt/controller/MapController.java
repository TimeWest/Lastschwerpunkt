package de.emutec.lastschwerpunkt.controller;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;

import de.emutec.lastschwerpunkt.model.DataCollection;
import de.emutec.lastschwerpunkt.view.MainWindow;
import de.emutec.lastschwerpunkt.view.MainWindowConstants;

/**
 * processes the actions on the right hand
 * 
 * @author Timo.Nordhorn
 *
 */
public class MapController {

	private int zoom = 100; // %
	private int originalWidth = 1;
	private int originalHeight = 1;

	// path to currently loaded plan
	private String imagePath = null;

	private BufferedImage image = null;
	private MainWindow mainWindow;

	public MapController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

		// process
		this.mainWindow.btnChooseImage(a -> {

			if (a.getActionCommand().equals(MainWindowConstants.ADD_IMAGE)) {
				JFileChooser chooser = new JFileChooser(imagePath);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
				chooser.setFileFilter(filter);
				int returnValue = chooser.showOpenDialog(mainWindow);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					imagePath = file.getAbsolutePath();
					try {
						setImage(ImageIO.read(file));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					this.originalWidth = getImage().getWidth();
					this.originalHeight = getImage().getHeight();
					zoom = 100;
				}
			}
		});

		this.mainWindow.btnScaleImage(a -> {
			if (a.getActionCommand() == "+") {
				zoom += 50;
				zoomImage(zoom);
			} else if (a.getActionCommand() == "-" && zoom > 50) {
				zoom -= 50;
				zoomImage(zoom);
			}
		});

		this.mainWindow.mapPosition(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				System.out.println(new Point(e.getX(), e.getY()));
			}
		});

		DataCollection.INSTANCE.getTreeModel().addTreeModelListener(new MyTreeModelListener());
	}

	private void zoomImage(int zoom) {
		int newWidth = originalWidth * zoom / 100;
		int newHeight = originalHeight * zoom / 100;
		BufferedImage zoomedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = zoomedImage.createGraphics();
		g.drawImage(getImage(), 0, 0, newWidth, newHeight, null);
		g.dispose();
		setImage(zoomedImage);
	}

	/**
	 * @return the image
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set as currently shown image/plan
	 */
	private void setImage(BufferedImage image) {
		this.image = image;
		mainWindow.setImage(this.image);
	}

	// /**
	// * get the cursors position on the image
	// */
	// private Point getCursorPosition() {
	// return new Point();
	// }

	private class MyTreeModelListener implements TreeModelListener {

		@Override
		public void treeNodesChanged(TreeModelEvent e) {
			System.out.println("MapController: treeNodesChanged:\n" + e);
			DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) e.getTreePath().getLastPathComponent();
			for (int i = 0; i < parentNode.getChildCount(); i++) {
				parentNode.getChildAt(i);
				System.out.println("Changed node:" + parentNode.getChildAt(i));
			}
		}

		@Override
		public void treeNodesInserted(TreeModelEvent e) {
			System.out.println("MapController: treeNodesInserted:\n" + e);
		}

		@Override
		public void treeNodesRemoved(TreeModelEvent e) {
			System.out.println("DataCollection: treeNodesRemoved:\n" + e);

		}

		@Override
		public void treeStructureChanged(TreeModelEvent e) {
			System.out.println("MapController: treeStructureChanged:\n" + e);
		}

	}

}
