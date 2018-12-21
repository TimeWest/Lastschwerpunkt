package de.emutec.lastschwerpunkt.datahandling;

import javax.swing.event.EventListenerList;

public enum DataHandler {
	INSTANCE;
	/** List of listeners */
	private EventListenerList listeners = new EventListenerList();

	/**
	 * Adds an {@code DataListener} to the DataCollection.
	 * 
	 * @param listener
	 *            the {@code DataListener} to be added
	 */
	public void addDataListener(DataListener listener) {
		listeners.add(DataListener.class, listener);
	}

	/**
	 * Removes an {@code DataListener} from the DataCollection.
	 * 
	 * @param listener
	 *            the {@code DataListener} to be removed
	 */
	public void removeDataListener(DataListener listener) {
		listeners.remove(DataListener.class, listener);
	}

	protected synchronized void notifyListeners(DataEvent e) {
		for (DataListener l : listeners.getListeners(DataListener.class)) {
			l.dataEventHappened(e);
		}
	}
}
