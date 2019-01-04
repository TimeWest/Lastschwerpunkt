package de.emutec.lastschwerpunkt.datahandling;

import java.io.File;
import java.util.Properties;

import javax.swing.JFileChooser;

public enum ProjectConstants {
	INSTANCE;

	private Properties props = new Properties();

	public String getProjectPath() {
		if (props.getProperty("path") != null) {
			return props.getProperty("path");
		}
		return setProjectPath();

	}
	
	public void setProjectPath(String s) {
		props.setProperty("path", s);
	}

	public String setProjectPath() {
		String path = props.getProperty("path");
		JFileChooser chooser = new JFileChooser(path);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnValue = chooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File folder = chooser.getSelectedFile();
			path = folder.getAbsolutePath();
			props.setProperty("path", path);
		}
		return path;

	}

}
