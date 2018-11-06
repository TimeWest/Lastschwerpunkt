package de.emutec.lastschwerpunkt.view;

import java.awt.*;
import javax.swing.*;

public class EditSector extends JDialog{
	
	//Objects used in this dialog
	private JPanel pnlMainContent = new JPanel();
	private JPanel pnlButtons = new JPanel();
	
	private JTextField txtSectorName = new JTextField();
	private JTextField txtSectorNumber = new JTextField();
	
	private JButton btnOk = new JButton("Ok");
	private JButton btnCancel = new JButton("Abbrechen");
	private JButton btnHelp = new JButton("Hilfe");
	
	private JLabel lblSectorName = new JLabel("Name");
	private JLabel lblSectorNumber = new JLabel("Nummer");
	private JLabel lblSectorColor = new JLabel("Farbe");
	
	//Constructor
	public EditSector() {
		
		//Setting MainFrame
		this.setTitle("Sector bearbeiten");
		this.setSize(450, 300);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.getContentPane().add(pnlMainContent, BorderLayout.CENTER);
		this.getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		
		
		//Set contentPane
		pnlMainContent.add(lblSectorName);
		pnlMainContent.add(txtSectorName);
		pnlMainContent.add(lblSectorNumber);
		pnlMainContent.add(txtSectorNumber);
		pnlMainContent.add(lblSectorColor);
		
		
		//Setting button area
		pnlButtons.add(btnHelp);
		pnlButtons.add(btnOk);
		pnlButtons.add(btnCancel);
	}
}
