package de.emutec.lastschwerpunkt.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import de.emutec.lastschwerpunkt.view.MainWindow;

public class MapController {

	private String currentPath = null;

	private BufferedImage image = null;
	private MainWindow mainWindow;

	public MapController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.mainWindow.btnChooseImage(a -> {
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
		});
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
