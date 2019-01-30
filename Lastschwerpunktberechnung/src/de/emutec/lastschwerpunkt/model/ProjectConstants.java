package de.emutec.lastschwerpunkt.model;

import java.io.File;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public enum ProjectConstants {
	INSTANCE;

	private Properties props = new Properties();

	public File getProjectFile() {
		try {
			return new File(props.getProperty("path"));
		} catch (Exception e) {
			return setProjectPath();
		}
	}

	public File setProjectPath(File file) {
		props.setProperty("path", file.getAbsolutePath());
		return new File(props.getProperty("path"));
	}

	public File setProjectPath() {
		String path = props.getProperty("path");
		JFileChooser chooser = new JFileChooser(path);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Projektdateien", "txt");
		chooser.setFileFilter(filter);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnValue = chooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			return setProjectPath(chooser.getSelectedFile());
		}
		return null;
	}

	public boolean createProjectFile(File file) {

		return false;

	}
}
