package de.emutec.lastschwerpunkt.building;

/**
 * @author Timo.Nordhorn
 *
 */
public class Building {
	// Basic Properties of the object type "Building"
	private String gebName;
	private String gebNumber;
	private String description;
	private int sector;
	private double load;
	private double glf;
	private Double[] coordinates = new Double[2];
	private boolean active;

	/**
	 * Constructor
	 */
	public Building() {
		setGebName(null);
		setDescription(null);
		// Coordinates will later be inherited by clicking on image in main window
		coordinates[0] = 0d;
		coordinates[1] = 0d;
		setActive(false);		
	}

	/**
	 * @return the gebName
	 */
	public String getGebName() {
		return gebName;
	}

	/**
	 * @param gebName the gebName to set
	 */
	public void setGebName(String gebName) {
		this.gebName = gebName;
	}

	/**
	 * @return the gebNumber
	 */
	public String getGebNumber() {
		return gebNumber;
	}

	/**
	 * @param gebNumber the gebNumber to set
	 */
	public void setGebNumber(String gebNumber) {
		this.gebNumber = gebNumber;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the sector
	 */
	public int getSector() {
		return sector;
	}

	/**
	 * @param sector the sector to set
	 */
	public void setSector(int sector) {
		this.sector = sector;
	}

	/**
	 * @return the glf
	 */
	public Double getGlf() {
		return glf;
	}

	/**
	 * @param glf the glf to set
	 */
	public void setGlf(double glf) {
		this.glf = glf;
	}

	/**
	 * @return the coordinates
	 */
	public Double[] getCoordinates() {
		return coordinates;
	}

	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(double x, double y) {
		this.coordinates[0] = x;
		this.coordinates[1] = y;
	}

	/**
	 * @param load the load to set
	 */
	public void setLoad(double load) {
		this.load = load;
	}

	public Double getLoad() {
		return load;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
}
