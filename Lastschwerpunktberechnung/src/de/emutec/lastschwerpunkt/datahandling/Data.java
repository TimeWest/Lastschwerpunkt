package de.emutec.lastschwerpunkt.datahandling;

import java.util.ArrayList;

/**
 * Base class for data Objects "Building" and "Sector"
 * 
 * @author Timo.Nordhorn
 *
 */
public abstract class Data {
	String name;
	int number;
	ArrayList<Data> children;
	Data parent;

	/**
	 * @return the gebName
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return (getNumber() + ": " + getName());
	}

	/**
	 * @return the gebNumber
	 */
	public int getNumber() {
		return number;
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

	/**
	 * @return an instance of the data
	 */
	public Data getInstance() {
		return this;
	}

	public abstract int hashCode();

	public abstract boolean equals(Object o);
}
