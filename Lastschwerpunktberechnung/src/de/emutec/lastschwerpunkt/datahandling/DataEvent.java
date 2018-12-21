package de.emutec.lastschwerpunkt.datahandling;

import java.util.EventObject;

public class DataEvent extends EventObject {

	private Data data;

	/**
	 * 
	 * @param source Object that triggered the event
	 * @param data Data to handle
	 */
	public DataEvent(Object source, Data data) {
		super(source);
		this.data = data;
	}

	public Data getData() {
		return data;
	}

}
