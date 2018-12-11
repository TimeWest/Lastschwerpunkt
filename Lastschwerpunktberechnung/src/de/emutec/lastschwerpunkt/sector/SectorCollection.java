package de.emutec.lastschwerpunkt.sector;

import java.util.LinkedList;
import java.util.List;

public class SectorCollection {
	private List<Sector> collectionOfSectors;
	// TODO Create some kind of collection (List/Map/Tree) to store the created
	// sectors until saved away.

	public SectorCollection() {
		collectionOfSectors = new LinkedList<>();
	}

	public void addSector(Sector sector) {
		collectionOfSectors.add(sector);
	}

	public Sector getSector(Sector sector) {
		try {
			return collectionOfSectors.get(collectionOfSectors.indexOf(sector));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public Sector removeSector(Sector sector) {
		try {
			return collectionOfSectors.remove(collectionOfSectors.indexOf(sector));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public void setSector(int i, Sector sector) {
		collectionOfSectors.set(i, sector);
	}
}
