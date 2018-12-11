package de.emutec.lastschwerpunkt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class EditingWindow extends JDialog {
	
	protected JButton btnOk;
	protected JButton btnCancel;
	protected JButton btnHelp;
	protected JPanel buttonPanel = new JPanel();

	protected JPanel contentPanel = new JPanel();

	public EditingWindow(String string) {
		this.setTitle(string);
		this.setAlwaysOnTop(true);
		this.setLocationByPlatform(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		// Setting button area
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		btnOk = new JButton("Ok");
		buttonPanel.add(btnOk);

		btnCancel = new JButton("Abbrechen");
		buttonPanel.add(btnCancel);

		btnHelp = new JButton("?");
		buttonPanel.add(btnHelp);
	}

	public void addButtonListener(ActionListener a) {
		btnOk.setActionCommand("ok");
		btnOk.addActionListener(a);

		btnCancel.setActionCommand("cancel");
		btnCancel.addActionListener(a);

		btnHelp.setActionCommand("?");
		btnHelp.addActionListener(a);
	}

	public void displayNumberError(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

}
