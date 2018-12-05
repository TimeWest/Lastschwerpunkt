package de.emutec.lastschwerpunkt.sector;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EditSector extends JDialog {

	// Objects used in this dialog
	private JPanel pnlMainContent = new JPanel();
	private JPanel pnlButtons = new JPanel();

	private JTextField txtSectorName = new JTextField();
	private JTextField txtSectorNumber = new JTextField();
	private JColorChooser ccSectorColor = new JColorChooser();
	
	private JButton btnOk = new JButton("Ok");
	private JButton btnCancel = new JButton("Abbrechen");
	private JButton btnHelp = new JButton("Hilfe");

	private JLabel lblSectorName = new JLabel("Name");
	private JLabel lblSectorNumber = new JLabel("Nummer");
	private JLabel lblSectorColor = new JLabel("Farbe");

	// Constructor
	public EditSector() {

		// Setting MainFrame
		this.setTitle("Sector bearbeiten");
		this.setSize(450, 300);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.getContentPane().add(pnlMainContent, BorderLayout.CENTER);
		this.getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		pnlMainContent.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		// Set contentPane
		c.fill = GridBagConstraints.HORIZONTAL;
		pnlMainContent.add(lblSectorName, c);
		pnlMainContent.add(lblSectorNumber, c);
		pnlMainContent.add(lblSectorColor, c);
		c.gridx++;
		c.gridwidth = GridBagConstraints.REMAINDER;
		pnlMainContent.add(txtSectorName, c);
		pnlMainContent.add(txtSectorNumber,c);		
		pnlMainContent.add(ccSectorColor, c);
		
		// Setting button area
		pnlButtons.add(btnHelp);
		pnlButtons.add(btnOk);
		pnlButtons.add(btnCancel);
		
		this.pack();
	}

	/**
	 * @return the sector name
	 */
	public String getTxtSectorName() {
		return txtSectorName.getText();
	}

	/**
	 * @param arg0
	 *            the sector name
	 */
	public void setTxtSectorName(String arg0) {
		this.txtSectorName.setText(arg0);
	}

	/**
	 * @return the sector Number
	 */
	public String getTxtSectorNumber() {
		return txtSectorNumber.getText();
	}

	/**
	 * @param arg0
	 *            the sector number
	 */
	public void setTxtSectorNumber(String arg0) {
		this.txtSectorNumber.setText(arg0);
	}
	
	public void addOkBtnListener(ActionListener listenForOkBtn) {
		btnOk.addActionListener(listenForOkBtn);
	}
	
	public void addCancelBtnListener(ActionListener listenForCancelBtn) {
		btnCancel.addActionListener(listenForCancelBtn);
	}
	
	public void displayNumberError(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
