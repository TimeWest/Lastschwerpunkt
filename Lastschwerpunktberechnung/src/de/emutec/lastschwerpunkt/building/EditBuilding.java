package de.emutec.lastschwerpunkt.building;

import java.awt.*;
import javax.swing.*;

import javafx.scene.control.Separator;

import java.awt.event.*;

public class EditBuilding extends JDialog {

	private static final int SPINNER_MAX = 10;
	/**
	 * Every Object (Button, Label etc.) on this interface
	 */
	private JPanel contentPanel = new JPanel();
	private JPanel buttonPane = new JPanel();

	private JTextField txtGebudeName = new JTextField(10);
	private JTextField txtGebudeNummer = new JTextField(10);
	private JTextField txtLoad = new JTextField(5);
	private JTextField txtGLF = new JTextField(5);
	private JTextField txtXcoordinate = new JTextField(10);
	private JTextField txtYcoordinate = new JTextField(10);

	private JSpinner spinnerSector = new JSpinner();

	private JTextArea txtrBeschreibung = new JTextArea(5,15);

	private JLabel lblGebudeName = new JLabel("Geb\u00E4ude Name");
	private JLabel lblGebudeNummer = new JLabel("Gebäude Nummer");
	private JLabel lblLastkw = new JLabel("Last [kVA]");
	private JLabel lblGlf = new JLabel("GLF");
	private JLabel lblPosition = new JLabel("Position");
	private JLabel lblXkoordinate = new JLabel("X-Koordinate");
	private JLabel lblYkoordinate = new JLabel("Y-Koordinate");
	private JLabel lblSektor = new JLabel("Sektor");
	private JLabel lblActive = new JLabel("Gebäude aktiv?");
	private JLabel lblBeschreibung = new JLabel("Beschreibung");
	
	private JButton btnNeuSetzen = new JButton("Neu setzen");
	private JButton btnOk = new JButton("OK");

	private JButton btnCancel = new JButton("Cancel");
	private JButton btnHelp = new JButton("Hilfe");

	private JCheckBox chkbxIsActive = new JCheckBox();
	
	private JSeparator separator = new JSeparator();
	

	/**
	 * Create the dialog.
	 */
	public EditBuilding() {

		// Setting the main frame
		this.setTitle("Gebäude bearbeiten");
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setLocationByPlatform(true);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.getContentPane().add(buttonPane, BorderLayout.SOUTH);
		this.setSpinnerMax(SPINNER_MAX);
		contentPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		// Setting the editing area
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 1, 0, 2);
		contentPanel.add(lblGebudeName, c);
		
		c.gridy = GridBagConstraints.RELATIVE;
		contentPanel.add(lblGebudeNummer, c);
		
		contentPanel.add(lblLastkw, c);

		contentPanel.add(lblGlf, c);
		
		contentPanel.add(lblSektor, c);
		
		contentPanel.add(lblActive, c);

		contentPanel.add(lblBeschreibung , c);

		c.gridwidth = GridBagConstraints.REMAINDER;
		contentPanel.add(txtrBeschreibung, c);
		
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 0;
		contentPanel.add(txtGebudeName, c);

		c.gridy = GridBagConstraints.RELATIVE;
		contentPanel.add(txtGebudeNummer, c);
		
		contentPanel.add(txtLoad, c);

		contentPanel.add(txtGLF, c);
		
		contentPanel.add(spinnerSector, c);

		contentPanel.add(chkbxIsActive, c);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 2;
		c.gridy = 0;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.insets = new Insets(0, 5, 0, 5);
		separator.setOrientation(SwingConstants.VERTICAL);
		contentPanel.add(separator, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 1, 0, 2);
		c.gridheight = 1;
		c.gridx = 3;
		contentPanel.add(lblPosition, c);

		c.gridy = GridBagConstraints.RELATIVE;
		contentPanel.add(lblXkoordinate, c);
		
		contentPanel.add(lblYkoordinate, c);
		
		c.gridx = 4;
		c.gridy = 1;
		contentPanel.add(txtXcoordinate, c);

		c.gridy = GridBagConstraints.RELATIVE;
		contentPanel.add(txtYcoordinate, c);
		
		c.gridx = 3;
		c.gridwidth = GridBagConstraints.REMAINDER;
		contentPanel.add(btnNeuSetzen, c);
		
				
		
		
		// Setting button area
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));

		btnCancel.setActionCommand("Cancel");
		buttonPane.add(btnCancel);

		btnOk.setActionCommand("OK");
		buttonPane.add(btnOk);

		buttonPane.add(btnHelp);
		this.pack();
	}

	/**
	 * Getter & Setter for text fields/checkboxes
	 * 
	 */
	/**
	 * @return the name of the building
	 */
	public String getTxtGebudeName() {
		return txtGebudeName.getText();
	}

	/**
	 * @param name
	 *            the name of the building
	 */
	public void setTxtGebudeName(String name) {
		this.txtGebudeName.setText(name);
	}

	/**
	 * @return the number of the building
	 */
	public String getTxtGebudeNummer() {
		return txtGebudeNummer.getText();
	}

	/**
	 * @param buildingNumber
	 *            the number of the building (house number)
	 */
	public void setTxtGebudeNummer(String buildingNumber) {
		this.txtGebudeNummer.setText(buildingNumber);
	}

	/**
	 * @return the load of the specified building
	 */
	public double getTxtLoad() {
		return Double.parseDouble(txtLoad.getText().replace(',', '.'));
	}

	/**
	 * @param load
	 *            the electrical load of the building
	 */
	public void setTxtLoad(Double load) {
		this.txtLoad.setText(load.toString());
	}

	/**
	 * @return the "Gleichzeitigkeitsfaktor" (GLF)
	 */
	public double getTxtGLF() {
		return Double.parseDouble(txtGLF.getText().replace(',', '.'));
	}

	/**
	 * @param glf
	 *            the glf of the building
	 */
	public void setTxtGLF(Double glf) {
		this.txtGLF.setText(glf.toString());
	}

	/**
	 * @return the xCoordinate of the chosen building
	 */
	public double getTxtXcoordinate() {
		return Double.parseDouble(txtXcoordinate.getText().replace(',', '.'));
	}

	/**
	 * @param xCoordinate
	 *            the x-coordinate to set
	 */
	public void setTxtXcoordinate(Double xCoordinate) {
		this.txtXcoordinate.setText(xCoordinate.toString());
	}

	/**
	 * @return the txtYcoordinate
	 */
	public double getTxtYcoordinate() {
		return Double.parseDouble(txtYcoordinate.getText().replace(',', '.'));
	}

	/**
	 * @param yCoordinate
	 *            the y-coordinate to set
	 */
	public void setTxtYcoordinate(Double yCoordinate) {
		this.txtXcoordinate.setText(yCoordinate.toString());
	}

	/**
	 * @return the Sector the chosen building is located in
	 */
	public int getSpinnerSector() {
		return (int) spinnerSector.getValue();
	}

	/**
	 * @param sector
	 *            the sector the building is located in
	 */
	public void setSpinnerSector(int sector) {
		this.spinnerSector.setValue(sector);
	}
	
	/**
	 * @param max
	 * the maximum value of the spinner to allow only available sectors 
	 */
	public void setSpinnerMax(int max) {
		this.spinnerSector.setModel(new SpinnerNumberModel(1,1,max,1));;
	}

	/**
	 * @return the description of the building
	 */
	public String getTxtrBeschreibung() {
		return txtrBeschreibung.getText();
	}

	/**
	 * @param description
	 *            A string used to describe the building more detailed
	 */
	public void setTxtrBeschreibung(String description) {
		this.txtrBeschreibung.setText(description);
	}

	/**
	 * @return the value of the checkbox to determine if a building is active and
	 *         thus has to be included in the calculation
	 */
	public boolean getChkbxIsActive() {
		return chkbxIsActive.isSelected();
	}

	/**
	 * @param isActive
	 *            set the value of the checkbox that marks a building as active or
	 *            inactive
	 */
	public void setChkbxIsActive(boolean isActive) {
		this.chkbxIsActive.setSelected(isActive);
	}

	/**
	 * Action Listener
	 */
	/**
	 * 
	 * @param listenForOkBtn
	 */
	public void addOkButtonListener(ActionListener listenForOkBtn) {
		btnOk.addActionListener(listenForOkBtn);
	}

	public void addCancelButtonListener(ActionListener listenForCancelBtn) {
		btnCancel.addActionListener(listenForCancelBtn);
	}

	public void displayNumberError(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
}
