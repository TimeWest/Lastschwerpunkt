package de.emutec.lastschwerpunkt.controller;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import de.emutec.lastschwerpunkt.view.MainWindow;
import de.emutec.lastschwerpunkt.view.MainWindowConstants;

public class MapController {

	private String imagePath = null;

	private BufferedImage image = null;
	private MainWindow mainWindow;

	public MapController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
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
						mainWindow.setImage(ImageIO.read(file));
					} catch (IOException e) {
						// TODO Auto-generated catch block
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
	
	/**
	 * get the cursors position on the image
	 */
	private Point getCursorPosition() {
		return new Point();
	}

}
