package de.emutec.lastschwerpunkt.model.data;

import javax.swing.tree.DefaultMutableTreeNode;

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

	String name;
	int number;

	DefaultMutableTreeNode parent;

/*	public abstract boolean equals(Object o);*/

	/**
	 * @return the parent
	 */
	public DefaultMutableTreeNode getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(DefaultMutableTreeNode parent) {
		this.parent = parent;
	}

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

/*	public abstract int hashCode();*/

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
