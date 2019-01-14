package de.emutec.lastschwerpunkt.model;

import java.io.File;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public enum ProjectConstants {
	INSTANCE;

	private Properties props = new Properties();

	public File getProjectPath() {
		File file = new File(props.getProperty("path"));
		if(file.exists()) {
			return setProjectPath();
		}
		else{
			return file;
		}
	}

	public void setProjectPath(File file) {
		props.setProperty("path", file.getAbsolutePath());
	}

	public File setProjectPath() {
		String path = props.getProperty("path");
		JFileChooser chooser = new JFileChooser(path);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Projektdateien", "txt");
		chooser.setFileFilter(filter);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnValue = chooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			setProjectPath(file);
			return file;
		}
		return null;
	}

	public boolean createProjectFile(File file) {

		return false;

	}
}
