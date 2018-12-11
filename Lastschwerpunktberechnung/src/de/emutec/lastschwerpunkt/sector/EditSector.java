package de.emutec.lastschwerpunkt.sector;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.emutec.lastschwerpunkt.EditingWindow;

@SuppressWarnings("serial")
public class EditSector extends EditingWindow {

	private JColorChooser ccSectorColor = new JColorChooser();
	
	private JTextField txtSectorName = new JTextField();
	private JTextField txtSectorNumber = new JTextField();

	// Constructor
	public EditSector() {
		
		super("Sektor bearbeiten");
		contentPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// Set contentPanel
		c.fill = GridBagConstraints.HORIZONTAL;
		contentPanel.add(new JLabel("Name"), c);

		c.gridwidth = GridBagConstraints.REMAINDER;
		contentPanel.add(txtSectorName, c);
		
		c.weightx = 0;
		c.gridwidth = GridBagConstraints.RELATIVE;
		contentPanel.add(new JLabel("Nummer"), c);

		c.weightx = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		contentPanel.add(txtSectorNumber, c);

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
	 * @return the sector name
	 */
	public String getTxtSectorName() {
		return txtSectorName.getText();
	}

	/**
	 * @return the sector Number
	 */
	public String getTxtSectorNumber() {
		return txtSectorNumber.getText();
	}

	/**
	 * @param ccSectorColor
	 *            the ccSectorColor to set
	 */
	public void setCcSectorColor(Color color) {
		this.ccSectorColor.setColor(color);
	}

	/**
	 * @param arg0
	 *            the sector name
	 */
	public void setTxtSectorName(String name) {
		this.txtSectorName.setText(name);
	}

	/**
	 * @param arg0
	 *            the sector number
	 */
	public void setTxtSectorNumber(String number) {
		this.txtSectorNumber.setText(number);
	}
}
