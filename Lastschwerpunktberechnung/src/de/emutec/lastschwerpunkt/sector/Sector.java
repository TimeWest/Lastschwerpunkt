package de.emutec.lastschwerpunkt.sector;

import java.awt.Color;

public class Sector {

	private Color color;
	// Properties of a sector
	private String name;
	private int number;

	public Sector() {
	}

	public Sector(String name, int number, Color color) {
		this.name = name;
		this.number = number;
		this.color = color;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

}
