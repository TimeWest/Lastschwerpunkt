package de.emutec.lastschwerpunkt.model.data;

import java.util.EventListener;

public interface DataListener extends EventListener {

	void dataEventHappened(DataEvent e);
}
