package de.emutec.lastschwerpunkt.building;

import java.util.*;

public class BuildingCollection {
	private List<Building> collectionOfBuildings;
	Building building;
	// TODO Create some kind of collection (List/Map/Tree) to store the created
	// buildings until saved away.

	public BuildingCollection() {
		collectionOfBuildings = new LinkedList<>();
	}

	public void addBuilding(Building building) {
		collectionOfBuildings.add(building);
	}

	public void setBuilding(int i, Building building) {
		collectionOfBuildings.set(i, building);
	}

	public Building removeBuilding(Building building) {
		try {
			return collectionOfBuildings.remove(collectionOfBuildings.indexOf(building));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public Building getBuilding(Building building) {
		try {
			return collectionOfBuildings.get(collectionOfBuildings.indexOf(building));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
