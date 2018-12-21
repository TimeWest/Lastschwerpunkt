package de.emutec.lastschwerpunkt.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EditSector extends EditingWindow {

	private JColorChooser ccSectorColor = new JColorChooser();

	// Constructor
	public EditSector() {

		super("Sektor bearbeiten");
		contentPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// Set contentPanel
		c.fill = GridBagConstraints.HORIZONTAL;
		contentPanel.add(new JLabel("Name"), c);

		c.gridwidth = GridBagConstraints.REMAINDER;
		txtName = new JTextField();
		contentPanel.add(txtName, c);

		c.weightx = 0;
		c.gridwidth = GridBagConstraints.RELATIVE;
		contentPanel.add(new JLabel("Nummer"), c);

		c.weightx = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		txtNumber = new JTextField();
		contentPanel.add(txtNumber, c);

		contentPanel.add(new JLabel("Farbe"), c);
		contentPanel.add(ccSectorColor, c);

		this.pack();
	}

	/**
	 * @return the ccSectorColor
	 */
	public Color getCcSectorColor() {
		return ccSectorColor.getColor();
	}

	/**
	 * @param ccSectorColor
	 *            the ccSectorColor to set
	 */
	public void setCcSectorColor(Color color) {
		this.ccSectorColor.setColor(color);
	}
}
