package de.emutec.lastschwerpunkt.building;

/**
 * @author Timo.Nordhorn
 *
 */
public class Building {

	private boolean active;
	private Double[] coordinates = new Double[2];
	private String description;
	private String gebName;
	private String gebNumber;
	private double glf;
	private double load;
	private int sector;

	public Building() {
		// Basic initialization of a building
	}

	/**
	 * @return the coordinates
	 */
	public Double[] getCoordinates() {
		return coordinates;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the gebName
	 */
	public String getGebName() {
		return gebName;
	}

	/**
	 * @return the gebNumber
	 */
	public String getGebNumber() {
		return gebNumber;
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
	public void setCoordinates(double x, double y) {
		this.coordinates[0] = x;
		this.coordinates[1] = y;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param gebName
	 *            the gebName to set
	 */
	public void setGebName(String gebName) {
		this.gebName = gebName;
	}

	/**
	 * @param gebNumber
	 *            the gebNumber to set
	 */
	public void setGebNumber(String gebNumber) {
		this.gebNumber = gebNumber;
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
	
}
