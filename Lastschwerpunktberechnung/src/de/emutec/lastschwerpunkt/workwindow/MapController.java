package de.emutec.lastschwerpunkt.workwindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MapController {

	class ToolbarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			if (a.getActionCommand().equals("addImage")) {
				JFileChooser chooser = new JFileChooser(currentPath);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
				chooser.setFileFilter(filter);
				int returnValue = chooser.showOpenDialog(mainWindow);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					currentPath = file.getAbsolutePath();
					try {
						setImage(ImageIO.read(file));
						mainWindow.setImage(getImage());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}

	private String currentPath = null;
	private BufferedImage image = null;

	private MainWindow mainWindow;

	public MapController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.mainWindow.btnChooseImage(new ToolbarListener());
	}

	/**
	 * @return the image
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
