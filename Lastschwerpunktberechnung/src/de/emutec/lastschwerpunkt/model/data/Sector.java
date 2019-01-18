package de.emutec.lastschwerpunkt.model.data;

import java.awt.Color;

public class Sector extends Data{

	private Color color;
	
	/**
	 * Constructor to create a new sector.
	 */
	public Sector() {
		this("", 0, new Color(0));
	}

	/**
	 * Constructor to edit an existing sector.
	 * @param name the name of the sector
	 * @param number the number of the sector
	 * @param color the color the sector shall be painted in.
	 */
	public Sector(String name, int number, Color color) {
		this.setName(name);
		this.setNumber(number);
		this.setColor(color);
	}

	public Sector(Sector data) {
		this(data.getName(), data.getNumber(), data.getColor());
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
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
