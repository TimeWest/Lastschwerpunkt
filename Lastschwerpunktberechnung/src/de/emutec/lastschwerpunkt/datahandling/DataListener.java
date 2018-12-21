package de.emutec.lastschwerpunkt.datahandling;

import java.util.EventListener;

public interface DataListener extends EventListener {

	void dataEventHappened(DataEvent e);
}
