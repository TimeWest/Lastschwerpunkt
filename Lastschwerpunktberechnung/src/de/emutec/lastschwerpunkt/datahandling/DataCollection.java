package de.emutec.lastschwerpunkt.datahandling;

import java.util.LinkedList;
import java.util.List;

/**
 * This Enumeration is storing data (buildings/sectors) that have been created during
 * runtime.
 * 
 * @author Timo.Nordhorn
 * @see Data
 *
 */
public enum DataCollection {
	INSTANCE;
	
	/** Collection of data */
	private List<Data> data = new LinkedList<>();
	
	/** Current selected data */
	private Object currentObject;
	
	/**
	 * @return the current object
	 */
	public Object getCurrentObject() {
		return currentObject;
	}

	/**
	 * @param o the o to set
	 */
	public void setCurrentObject(Object o) {
		this.currentObject = o;
	}

	/**
	 * Add data to a Collection
	 * 
	 * @param currentObject
	 *            Object that triggered the Event
	 * @param data
	 *            element to add to Collection
	 * @return {@code true} if element has successfully been added
	 */
	private boolean putData(Data data) {
		return this.data.add(data);
	}

	/**
	 * 
	 * @return the complete collection as {@code Object[]}
	 */
	public Object[] getDataCollection() {
		return data.toArray();
	}

	/**
	 * 
	 * @param d
	 *            element to receive
	 * @return Object of class {@code Data}
	 * @throws IllegalArgumentException
	 */
	public Data getData() {
		if (data.contains(getCurrentObject())) {
			return data.get(data.indexOf(getCurrentObject()));
		}
		throw new IllegalArgumentException();
	}

	/**
	 * Edit an existing element in this collection if it is contained. Else add it
	 * to the collection.
	 * 
	 * @param currentObject
	 *            Object that triggered the Event
	 * @param d
	 *            element to add to collection
	 * @return {@code true} if element has successfully been added to collection.
	 */
	public boolean editData(Data d) {
		if (!this.data.contains(d)) {
			return putData(d);
		}
		else {
			this.data.set(this.data.indexOf(getCurrentObject()), d);
			return true;
		}
		
	}

	/**
	 * remove given data from collection
	 * 
	 * @param d
	 *            data to be deleted
	 * @return {@code true} if this collection contained the specified element
	 */
	public boolean removeData(Data d) {
		return data.remove(d);
	}

}
