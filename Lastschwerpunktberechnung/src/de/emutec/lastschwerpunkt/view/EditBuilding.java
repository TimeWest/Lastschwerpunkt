package de.emutec.lastschwerpunkt.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class EditBuilding extends EditingWindow {

	private static final int SPINNER_MAX = 10;

	private JButton btnNeuSetzen;
	private JCheckBox chkbxIsActive;
	private JSpinner spinnerSector;
	
	private JTextField txtGebudeNummer;
	private JTextField txtGLF;
	private JTextField txtLoad;
	private JTextField txtName;
	private JTextArea txtrBeschreibung;
	private JTextField txtXcoordinate;
	
	private JTextField txtYcoordinate;

	public EditBuilding() {

		// Setting the main frame
		super("Gebäude bearbeiten");
		contentPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Setting the editing area

		gbc.fill = GridBagConstraints.HORIZONTAL;
		contentPanel.add(new JLabel("Gebäudename"), gbc);
		txtName = new JTextField(5);
		contentPanel.add(txtName, gbc);

		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.gridheight = 6;
		contentPanel.add(new JSeparator(SwingConstants.VERTICAL), gbc);

		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contentPanel.add(new JLabel("Position"), gbc);

		btnNeuSetzen = new JButton("Im Lageplan markieren");
		contentPanel.add(btnNeuSetzen, gbc);

		gbc.gridx = 0;
		contentPanel.add(new JLabel("Gebäudenummer"), gbc);

		gbc.gridx = 1;
		txtGebudeNummer = new JTextField(5);
		contentPanel.add(txtGebudeNummer, gbc);

		gbc.gridx = 3;
		contentPanel.add(new JLabel("X-Koordinate"), gbc);

		gbc.gridx = 4;
		txtXcoordinate = new JTextField(5);
		contentPanel.add(txtXcoordinate, gbc);

		gbc.gridx = 0;
		contentPanel.add(new JLabel("Last [kVA]"), gbc);

		gbc.gridx = 1;
		txtLoad = new JTextField(5);
		contentPanel.add(txtLoad, gbc);

		gbc.gridx = 3;
		contentPanel.add(new JLabel("Y-Koordinate"), gbc);

		gbc.gridx = 4;
		txtYcoordinate = new JTextField(5);
		contentPanel.add(txtYcoordinate, gbc);

		gbc.gridx = 0;
		contentPanel.add(new JLabel("GLF"), gbc);

		gbc.gridx = 1;
		txtGLF = new JTextField(5);
		contentPanel.add(txtGLF, gbc);

		gbc.gridx = 0;
		contentPanel.add(new JLabel("Sektor"), gbc);
		
		gbc.gridx = 1;
		spinnerSector = new JSpinner(new SpinnerNumberModel(1, 1, SPINNER_MAX, 1));
		contentPanel.add(spinnerSector, gbc);

		gbc.gridx = 0;
		contentPanel.add(new JLabel("Gebäude aktiv"), gbc);

		gbc.gridx = 1;
		chkbxIsActive = new JCheckBox();
		contentPanel.add(chkbxIsActive, gbc);

		gbc.gridx = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		contentPanel.add(new JSeparator(), gbc);

		gbc.gridx = 0;
		contentPanel.add(new JLabel("Beschreibung"), gbc);

		// Adding JTextArea
		gbc.gridx = 0;
		txtrBeschreibung = new JTextArea();
		contentPanel.add(txtrBeschreibung, gbc);

		this.pack();
	}

	/**
	 * @return the value of the checkBox to determine if a building is active and
	 *         thus has to be included in the calculation
	 */
	public boolean getChkbxIsActive() {
		return chkbxIsActive.isSelected();
	}

	/**
	 * @return the Sector the chosen building is located in
	 */
	public int getSpinnerSector() {
		return (int) spinnerSector.getValue();
	}

	/**
	 * @return the name of the building
	 */
	public String getTxtGebudeName() {
		return txtName.getText();
	}

	/**
	 * @return the number of the building
	 */
	public String getTxtGebudeNummer() {
		return txtGebudeNummer.getText();
	}

	/**
	 * @return the "Gleichzeitigkeitsfaktor" (GLF)
	 */
	public double getTxtGLF() {
		return Double.parseDouble(txtGLF.getText().replace(',', '.'));
	}

	/**
	 * @return the load of the specified building
	 */
	public double getTxtLoad() {
		return Double.parseDouble(txtLoad.getText().replace(',', '.'));
	}

	/**
	 * @return the description of the building
	 */
	public String getTxtrBeschreibung() {
		return txtrBeschreibung.getText();
	}
	
	public Point getCoordinates() {
		double x = Double.parseDouble(txtXcoordinate.getText().replace(',', '.'));
		double y = Double.parseDouble(txtYcoordinate.getText().replace(',', '.'));
		return new Point((int) x, (int) y);
	}

	/**
	 * @param isActive
	 *            set the value of the checkBox that marks a building as active or
	 *            inactive
	 */
	public void setChkbxIsActive(boolean isActive) {
		this.chkbxIsActive.setSelected(isActive);
	}

	/**
	 * @param sector
	 *            the sector the building is located in
	 */
	public void setSpinnerSector(int sector) {
		this.spinnerSector.setValue(sector);
	}

	/**
	 * @param name
	 *            the name of the building
	 */
	public void setTxtGebudeName(String name) {
		this.txtName.setText(name);
	}

	/**
	 * @param buildingNumber
	 *            the number of the building (house number)
	 */
	public void setTxtGebudeNummer(String buildingNumber) {
		this.txtGebudeNummer.setText(buildingNumber);
	}

	/**
	 * @param glf
	 *            the glf of the building
	 */
	public void setTxtGLF(Double glf) {
		this.txtGLF.setText(glf.toString());
	}

	/**
	 * @param load
	 *            the electrical load of the building
	 */
	public void setTxtLoad(Double load) {
		this.txtLoad.setText(load.toString());
	}

	/**
	 * @param description
	 *            A string used to describe the building more detailed
	 */
	public void setTxtrBeschreibung(String description) {
		this.txtrBeschreibung.setText(description);
	}

	/**
	 * @param p
	 * 
	 */
	public void setCoordinates(Point p) {
		this.txtXcoordinate.setText(Integer.toString((int) p.getX()));
		this.txtYcoordinate.setText(Integer.toString((int) p.getY()));
	}

}
