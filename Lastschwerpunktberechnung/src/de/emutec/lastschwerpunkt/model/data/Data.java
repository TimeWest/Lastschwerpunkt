package de.emutec.lastschwerpunkt.model.data;

import java.util.ArrayList;

/**
 * Base class for data Objects "Building" and "Sector"
 * 
 * @author Timo.Nordhorn
 *
 */
public abstract class Data {

	public static Class<? extends Data> checkType(Data data) {
		return data.getClass();
	}

	ArrayList<Data> children;
	String name;
	int number;

	Data parent;

	public abstract boolean equals(Object o);

	/**
	 * @return an instance of the data
	 */
	public Data getInstance() {
		return this;
	}

	/**
	 * @return the gebName
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the gebNumber
	 */
	public int getNumber() {
		return number;
	}

	public abstract int hashCode();

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

	@Override
	public String toString() {
		return (getNumber() + ": " + getName());
	}
}
