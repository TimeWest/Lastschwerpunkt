package de.emutec.lastschwerpunkt.sector;

/**
 * @author Timo.Nordhorn
 *
 */
public class Sector {

	// Properties of a sector
	private String name;
	private int number;
	private int[] color = new int[3];

	public Sector() {

	}

	public Sector(String name, int number, int[] color) {
		this.name = name;
		this.number = number;
		this.color = color;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the color
	 */
	public int[] getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(int[] color) {
		this.color = color;
	}

}
