package de.emutec.lastschwerpunkt;
/**
 * 
 */

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

	/**
	 * Constructor
	 */
	public Building() {
		gebName = "";
		gebNumber = "";
		description = "";
		sector = 0;
		load = 0;
		glf = 1;
		// Coordinates will later be inherited by class MainWindow
		coordinates[0] = 0d;
		coordinates[1] = (double) 0;
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
		// TODO Auto-generated method stub
	}
}
