package de.emutec.lastschwerpunkt.model.data;

import java.awt.geom.Point2D;

/**
 * @author Timo.Nordhorn
 *
 */
public class Building extends Data {

	private boolean active;
	private Point2D coordinates;
	private String description;
	private double glf;
	private double load;
	private Sector sector;

	public Building() {
		// Basic initialization of a building
		this.setName("");
		this.setNumber(0);
		this.setLoad(0d);
		this.setGlf(0d);
		this.setActive(false);
		this.coordinates = new Point2D.Double();
		this.setDescription("");
	}
	
	public Building(String name, int number, double load, Point2D coordinates, Sector sector) {
		setName(name);
		setNumber(number);
		setLoad(load);
		this.coordinates = new Point2D.Double();
		setCoordinates(coordinates);
		setGlf(0.8);
		setDescription("");
		setSector(sector);
		setActive(true);
	}

	/**
	 * @return the coordinates
	 */
	public Point2D getCoordinates() {
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
	public double getGlf() {
		return glf;
	}

	public double getLoad() {
		return load;
	}

	/**
	 * @return the sector
	 */
	public Sector getSector() {
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
	public void setCoordinates(Point2D p) {
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
	 * @param  object
	 *            the sector to set
	 */
	public void setSector(Object object) {
		this.sector = (Sector) object;
	}

	@Override
	public int hashCode() {
		// TODO later: Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		// TODO later: Auto-generated method stub
		return false;
	}
	
	

}
