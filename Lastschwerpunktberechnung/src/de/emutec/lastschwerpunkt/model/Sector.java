package de.emutec.lastschwerpunkt.model;

import java.awt.Color;

public class Sector {

	private Color color;
	private String name;
	private int number;

	public Sector() {
		this.setName("");
		this.setNumber(0);
		this.setColor(new Color(0));
	}

	public Sector(String name, int number, Color color) {
		this.setName(name);
		this.setNumber(number);
		this.setColor(color);
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
	 * @return this
	 */
	public Sector getSector() {
		return this;
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
