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

	/**
	 * default constructor creates a building without useful values to be filled
	 */
	public Building() {
		// Basic initialization of a building
		this("", 0, 0d, new Point2D.Double(), 0d, "", null, false);
	}

	/**
	 * 
	 * @param name
	 * @param number
	 * @param load
	 * @param coordinates
	 * @param glf
	 * @param description
	 * @param sector
	 * @param active
	 * 
	 */
	public Building(String name, int number, double load, Point2D coordinates, double glf, String description,
			Sector sector, boolean active) {
		setName(name);
		setNumber(number);
		setLoad(load);
		setCoordinates(coordinates);
		setGlf(glf);
		setDescription(description);
		setSector(sector);
		setActive(active);
	}

	public Building(Building b) {
		this(b.getName(), b.getNumber(), b.getLoad(), b.getCoordinates(), b.getGlf(), b.getDescription(), b.getSector(),
				b.isActive());
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
		this.coordinates = new Point2D.Double(p.getX(), p.getY());
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
	 * @param object
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
