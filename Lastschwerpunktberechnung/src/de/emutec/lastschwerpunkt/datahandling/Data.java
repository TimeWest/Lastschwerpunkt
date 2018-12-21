package de.emutec.lastschwerpunkt.datahandling;

/**
 * Base class for data Objects "Building" and "Sector"
 * 
 * @author Timo.Nordhorn
 *
 */
public abstract class Data {
	String name;
	int number;

	Data() {
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
