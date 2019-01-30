package de.emutec.lastschwerpunkt.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JFileChooser;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import de.emutec.lastschwerpunkt.model.data.Building;
import de.emutec.lastschwerpunkt.model.data.Data;
import de.emutec.lastschwerpunkt.model.data.Sector;

public class JSonHandler {

	private static final String BUILDING = "building";
	private static final String SECTOR = "sector";
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
			} else if (allData[i] instanceof Sector) {
				sectors.add((Sector) allData[i]);
			} else {
				throw new IllegalArgumentException("Unexpected type: Expected objects of class Data");
			}
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(getPath(), "data.txt")))) {
			writer.write(gson.toJson(buildings));
			writer.newLine();
			writer.write(gson.toJson(sectors));
		} catch (IOException e) {
			// TODO handle exception
			e.printStackTrace();
		}
	}

	public void saveToFile2() {
		ArrayList<Data> allData = new ArrayList<>();
		ArrayList<String> allNodes = new ArrayList<>();
		for (Enumeration<TreeNode> e = ((DefaultMutableTreeNode) DataCollection.INSTANCE.getTreeModel().getRoot())
				.breadthFirstEnumeration(); e.hasMoreElements();) {
			DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) e.nextElement();
			allData.add((Data) currentNode.getUserObject());
			if (currentNode.getParent() != null) {
				allNodes.add(currentNode.getParent().toString());
			} else {
				allNodes.add("null");
			}
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(getPath()))) {
			writer.write(gson.toJson(allData));
			writer.newLine();
			writer.write(gson.toJson(allNodes));
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public void loadFromFile2() {
		File file = ProjectConstants.INSTANCE.setProjectPath();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String json = reader.readLine();
			JsonParser parser = new JsonParser();
			JsonArray arr = parser.parse(json).getAsJsonArray();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 
	 * @return
	 */
	private synchronized Object[] getDataCollection() {
		return DataCollection.INSTANCE.getObjectsOfClass(Data.class);
	}

	/**
	 * 
	 */
	public void loadFromFile() {
		// clear collection from previous project

		JFileChooser chooser = new JFileChooser(ProjectConstants.INSTANCE.getProjectFile());
		File file = chooser.getSelectedFile();

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String s = reader.readLine();
			addLoadedObjects(s, BUILDING);
			s = reader.readLine();
			addLoadedObjects(s, SECTOR);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("ERFOLG!");
	}

	/**
	 * 
	 * @param s
	 */
	private synchronized void addLoadedObjects(String s, String type) {
		JsonParser parser = new JsonParser();
		JsonArray array = parser.parse(s).getAsJsonArray();

		switch (type) {
		case BUILDING:
			for (int i = 0; i < array.size(); i++) {
				JsonElement buildings = array.get(i);
				Data data = gson.fromJson(buildings, Building.class);
				DataCollection.INSTANCE.insertData(data);
			}
			break;
		case SECTOR:
			for (int i = 0; i < array.size(); i++) {
				JsonElement sectors = array.get(i);
				Data data = gson.fromJson(sectors, Sector.class);
				DataCollection.INSTANCE.insertData(data);
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
	private File getPath() {
		return ProjectConstants.INSTANCE.getProjectFile();
	}
}
