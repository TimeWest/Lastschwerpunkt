package de.emutec.lastschwerpunkt.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public abstract class EditingWindow extends JDialog {

	// ********************************
	// ***** Dialog Return Values *****
	// ********************************

	/**
	 * Return value if cancel is chosen.
	 */
	public static final String CANCEL_OPTION = "CANCEL";

	/**
	 * Return value if approve (yes, ok) is chosen.
	 */
	public static final String APPROVE_OPTION = "OK";

	/**
	 * Return value if an error occurred.
	 */
	public static final String HELP_OPTION = "HELP";

	protected JButton btnCancel;
	protected JButton btnHelp;
	protected JButton btnOk;
	protected JPanel buttonPanel;
	protected JPanel contentPanel;
	protected JTextField txtName;
	protected JTextField txtNumber;

	public EditingWindow(String string) {
		this.setTitle(string);
		this.setAlwaysOnTop(true);
		this.setLocationByPlatform(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		this.getContentPane().setLayout(new BorderLayout());
		
		contentPanel = new JPanel();
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		buttonPanel = new JPanel();
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

	/**
	 * 
	 * @param a
	 */
	public void addButtonListener(ActionListener a) {
		btnOk.setActionCommand(APPROVE_OPTION);
		btnOk.addActionListener(a);

		btnCancel.setActionCommand(CANCEL_OPTION);
		btnCancel.addActionListener(a);

		btnHelp.setActionCommand(HELP_OPTION);
		btnHelp.addActionListener(a);
	}

	/**
	 * 
	 * @param errorMessage
	 */
	public void displayNumberError(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

	/**
	 * 
	 */
	@Override
	public String getName() {
		return txtName.getText();
	}
	
	/**
	 * @return the number of the building
	 */
	public String getNumber() {
		return txtNumber.getText();
	}
	
	/**
	 * @param name
	 *            the name of the building
	 */
	@Override
	public void setName(String name) {
		this.txtName.setText(name);
	}

	/**
	 * @param i.toString
	 *            the number of the building (house number)
	 */
	public void setNumber(int i) {
		this.txtNumber.setText(Integer.toString(i));
	}

}
