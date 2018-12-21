package de.emutec.lastschwerpunkt.datahandling;

import java.awt.Point;

/**
 * @author Timo.Nordhorn
 *
 */
public class Building extends Data {

	private boolean active;
	private Point coordinates;
	private String description;
	private double glf;
	private double load;
	private int sector;

	public Building() {
		// Basic initialization of a building
		this.setName("");
		this.setNumber(0);
		this.setLoad(0d);
		this.setGlf(0d);
		this.setActive(false);
		this.coordinates = new Point();
		this.setDescription("");
	}

	/**
	 * @return the coordinates
	 */
	public Point getCoordinates() {
		return coordinates;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the glf
	 */
	public Double getGlf() {
		return glf;
	}

	public Double getLoad() {
		return load;
	}

	/**
	 * @return the sector
	 */
	public int getSector() {
		return sector;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @param coordinates
	 *            the coordinates to set
	 */
	public void setCoordinates(Point p) {
		this.coordinates.setLocation(p);
//		this.coordinates.x = (int) p.getX();
//		this.coordinates.y = (int) p.getY();
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param glf
	 *            the glf to set
	 */
	public void setGlf(double glf) {
		this.glf = glf;
	}

	/**
	 * @param load
	 *            the load to set
	 */
	public void setLoad(double load) {
		this.load = load;
	}

	/**
	 * @param sector
	 *            the sector to set
	 */
	public void setSector(int sector) {
		this.sector = sector;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
