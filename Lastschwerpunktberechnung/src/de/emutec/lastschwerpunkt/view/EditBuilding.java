package de.emutec.lastschwerpunkt.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EditBuilding extends JDialog{

	/**
	 * Every Object (Button, Label etc.) on this interface
	 */
	private JPanel contentPanel = new JPanel();
	private JPanel buttonPane = new JPanel();

	private JTextField txtGebudeName = new JTextField();
	private JTextField txtGebudeNummer = new JTextField();
	private JTextField txtLoad = new JTextField();
	private JTextField txtGLF = new JTextField();
	private JTextField txtXcoordinate = new JTextField();
	private JTextField txtYcoordinate = new JTextField();

	private JSpinner spinnerSector = new JSpinner();

	private JTextArea txtrBeschreibung = new JTextArea();

	private JLabel lblGebudeName = new JLabel("Geb\u00E4ude Name");
	private JLabel lblGebudeNummer = new JLabel("Geb\u00E4ude Nummer");
	private JLabel lblLastkw = new JLabel("Last [kW]");
	private JLabel lblGlf = new JLabel("GLF");
	private JLabel lblPosition = new JLabel("Position");
	private JLabel lblXkoordinate = new JLabel("X-Koordinate");
	private JLabel lblYkoordinate = new JLabel("Y-Koordinate");
	private JLabel lblSektor = new JLabel("Sektor");
	private JLabel lblActive = new JLabel("Geb\u00E4ude aktiv?");

	private JSeparator separator = new JSeparator();

	private JButton btnNeuSetzen = new JButton("Neu setzen");
	private JButton okButton = new JButton("OK");
	private JButton cancelButton = new JButton("Cancel");
	private JButton btnHelp = new JButton("Hilfe");

	private JCheckBox chkbxIsActive = new JCheckBox();
	/**
	 * Create the dialog.
	 */
	public EditBuilding() {

		// Setting the main frame
		this.setTitle("Geb\u00E4ude bearbeiten");
		this.setResizable(false);
		this.setBounds(100, 100, 450, 300);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.getContentPane().add(buttonPane, BorderLayout.SOUTH);

		// Setting the editing area
		lblGebudeName.setBounds(10, 13, 73, 14);
		contentPanel.add(lblGebudeName);

		txtGebudeName.setBounds(103, 10, 120, 20);
		contentPanel.add(txtGebudeName);

		lblGebudeNummer.setBounds(10, 38, 85, 14);
		contentPanel.add(lblGebudeNummer);

		txtGebudeNummer.setBounds(103, 35, 43, 20);
		contentPanel.add(txtGebudeNummer);

		lblLastkw.setBounds(10, 63, 85, 14);
		contentPanel.add(lblLastkw);

		txtLoad.setBounds(103, 60, 43, 20);
		contentPanel.add(txtLoad);

		lblGlf.setBounds(10, 88, 46, 14);
		contentPanel.add(lblGlf);

		txtGLF.setBounds(103, 85, 43, 20);
		contentPanel.add(txtGLF);

		contentPanel.add(lblActive);

		contentPanel.add(chkbxIsActive);

		lblPosition.setBounds(250, 13, 46, 14);
		contentPanel.add(lblPosition);

		lblXkoordinate.setBounds(250, 38, 73, 14);
		contentPanel.add(lblXkoordinate);

		lblYkoordinate.setBounds(250, 63, 73, 14);
		contentPanel.add(lblYkoordinate);

		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setOpaque(true);
		separator.setForeground(new Color(160, 160, 160));
		separator.setBounds(233, 2, 1, 135);
		contentPanel.add(separator);

		txtXcoordinate.setBounds(338, 35, 86, 20);
		contentPanel.add(txtXcoordinate);

		txtYcoordinate.setBounds(338, 60, 86, 20);
		contentPanel.add(txtYcoordinate);

		btnNeuSetzen.setBounds(250, 85, 174, 20);
		contentPanel.add(btnNeuSetzen);

		lblSektor.setBounds(10, 113, 46, 14);
		contentPanel.add(lblSektor);

		spinnerSector.setBounds(103, 110, 43, 20);
		contentPanel.add(spinnerSector);

		txtrBeschreibung.setBounds(10, 138, 414, 80);
		contentPanel.add(txtrBeschreibung);

		// Setting button area
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));

		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		okButton.setActionCommand("OK");
		buttonPane.add(okButton);

		buttonPane.add(btnHelp);
	}

	// Getter & Setter for text fields/checkboxes
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
		return Double.parseDouble(txtLoad.getText());
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
		return Double.parseDouble(txtGLF.getText());
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
		return Double.parseDouble(txtXcoordinate.getText());
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
		return Double.parseDouble(txtYcoordinate.getText());
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

	void addOkButtonListener(ActionListener listenForOkButton) {
		okButton.addActionListener(listenForOkButton);
	}
	
	void displayNumberError(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
