package de.emutec.lastschwerpunkt.datahandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class JSonHandler {

	private Gson gson;

	public JSonHandler() {
		gson = new Gson();
	}

	/**
	 * 
	 */
	public void saveToFile() {
		Object[] allData = getDataCollection();
		ArrayList<Data> buildings = new ArrayList<>();
		ArrayList<Data> sectors = new ArrayList<>();
		for (int i = 0; i < allData.length; i++) {
			if (allData[i] instanceof Building) {
				buildings.add((Building) allData[i]);
			}
			else if (allData[i] instanceof Sector){
				sectors.add((Sector) allData[i]);
			}
			else throw new IllegalArgumentException("Unexpected type: Expected objects of class Data");
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(getPath(), "data.txt")))) {
			writer.write(gson.toJson(buildings));
			writer.newLine();
			writer.write(gson.toJson(sectors));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	private synchronized Object[] getDataCollection() {
		return DataCollection.INSTANCE.getDataCollection();
	}

	/**
	 * 
	 */
	public void loadFromFile() {
		// clear collection from previous project
		DataCollection.INSTANCE.clearData();

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		chooser.setFileFilter(filter);
		int returnValue = chooser.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			ProjectConstants.INSTANCE.setProjectPath(file.getAbsolutePath());

			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				String s = reader.readLine();
				addLoadedObjects(s, DataType.BUILDING);
				s = reader.readLine();
				addLoadedObjects(s, DataType.SECTOR);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("ERFOLG!");
		}
	}

	/**
	 * 
	 * @param s
	 */
	private synchronized void addLoadedObjects(String s, DataType type) {
		JsonParser parser = new JsonParser();
		JsonArray array = parser.parse(s).getAsJsonArray();

		switch (type) {
		case BUILDING:
			for (int i = 0; i < array.size(); i++) {
				JsonElement buildings = array.get(i);
				Data data = gson.fromJson(buildings, Building.class);
				DataCollection.INSTANCE.editData(data);
			}
			break;
		case SECTOR:
			for (int i = 0; i < array.size(); i++) {
				JsonElement sectors = array.get(i);
				Data data = gson.fromJson(sectors, Sector.class);
				DataCollection.INSTANCE.editData(data);
			}
			break;
		default:
			break;
		}

	}

	/**
	 * 
	 */
	public void setNewPath() {
		ProjectConstants.INSTANCE.setProjectPath();
	}

	/**
	 * 
	 * @return
	 */
	private String getPath() {
		return ProjectConstants.INSTANCE.getProjectPath();
	}
}