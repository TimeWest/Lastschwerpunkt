import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dialog;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSpinner;
import java.awt.Rectangle;
import javax.swing.border.MatteBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.ToDoubleFunction;

import javax.swing.JFormattedTextField;
import javax.swing.SpinnerNumberModel;

public class EditBuilding extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtGebudeName;
	private JTextField txtGebudeNummer;
	private JTextField txtLoad;
	private JTextField txtGLF;
	private JTextField txtXcoordinate;
	private JTextField txtYcoordinate;
	private JSpinner spinnerSector;
	private JTextArea txtrBeschreibung;
	private Building building;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			EditBuilding dialog = new EditBuilding();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public EditBuilding(Building building) {
		this.building = building;
		setTitle("Geb\u00E4ude bearbeiten");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblGebudeName = new JLabel("Geb\u00E4ude Name");
			lblGebudeName.setBounds(10, 13, 73, 14);
			contentPanel.add(lblGebudeName);
		}
		{
			txtGebudeName = new JTextField();
			txtGebudeName.setBounds(103, 10, 120, 20);
			contentPanel.add(txtGebudeName);
			txtGebudeName.setColumns(10);
		}
		{
			JLabel lblGebudeNummer = new JLabel("Geb\u00E4ude Nummer");
			lblGebudeNummer.setBounds(10, 38, 85, 14);
			contentPanel.add(lblGebudeNummer);
		}
		{
			txtGebudeNummer = new JTextField();
			txtGebudeNummer.setAlignmentX(Component.RIGHT_ALIGNMENT);
			txtGebudeNummer.setBounds(103, 35, 43, 20);
			contentPanel.add(txtGebudeNummer);
			txtGebudeNummer.setColumns(10);
		}
		
		JLabel lblLastkw = new JLabel("Last [kW]");
		lblLastkw.setBounds(10, 63, 85, 14);
		contentPanel.add(lblLastkw);
		
		txtLoad = new JTextField();
		txtLoad.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtLoad.setBounds(103, 60, 43, 20);
		contentPanel.add(txtLoad);
		txtLoad.setColumns(10);
		
		JLabel lblGlf = new JLabel("GLF");
		lblGlf.setBounds(10, 88, 46, 14);
		contentPanel.add(lblGlf);
		
		txtGLF = new JTextField();
		txtGLF.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtGLF.setBounds(103, 85, 43, 20);
		contentPanel.add(txtGLF);
		txtGLF.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(250, 13, 46, 14);
		contentPanel.add(lblPosition);
		
		JLabel lblXkoordinate = new JLabel("X-Koordinate");
		lblXkoordinate.setBounds(250, 38, 73, 14);
		contentPanel.add(lblXkoordinate);
		
		JLabel lblYkoordinate = new JLabel("Y-Koordinate");
		lblYkoordinate.setBounds(250, 63, 73, 14);
		contentPanel.add(lblYkoordinate);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setOpaque(true);
		separator.setForeground(new Color(160, 160, 160));
		separator.setBounds(233, 2, 1, 135);
		contentPanel.add(separator);
		
		txtXcoordinate = new JTextField();
		txtXcoordinate.setBounds(338, 35, 86, 20);
		contentPanel.add(txtXcoordinate);
		txtXcoordinate.setColumns(10);
		
		txtYcoordinate = new JTextField();
		txtYcoordinate.setBounds(338, 60, 86, 20);
		contentPanel.add(txtYcoordinate);
		txtYcoordinate.setColumns(10);
		
		JButton btnNeuSetzen = new JButton("Neu setzen");
		btnNeuSetzen.setBounds(250, 85, 174, 20);
		contentPanel.add(btnNeuSetzen);
		
		JLabel lblSektor = new JLabel("Sektor");
		lblSektor.setBounds(10, 113, 46, 14);
		contentPanel.add(lblSektor);
		
		spinnerSector = new JSpinner();
//		spinnerSector.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerSector.setBounds(103, 110, 43, 20);
		contentPanel.add(spinnerSector);
		
		txtrBeschreibung = new JTextArea();
		txtrBeschreibung.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		txtrBeschreibung.setBounds(10, 138, 414, 80);
		contentPanel.add(txtrBeschreibung);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						applyChanges();
						//MainWindow.insertBuilding(building);
						dispose();
					}
				
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						System.out.println("BEENDEN!");
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		/**
		 * Loading the buildings properties and placing them in the designated fields
		 */
		txtGebudeName.setText(building.getGebName());
		txtGebudeNummer.setText(building.getGebNumber());
		txtrBeschreibung.setText(building.getDescription());
		spinnerSector.setValue(building.getSector());
		txtLoad.setText(building.getLoad().toString());
		txtGLF.setText(building.getGlf().toString());
		txtXcoordinate.setText(building.getCoordinates()[0].toString());
		txtYcoordinate.setText(building.getCoordinates()[1].toString());
		spinnerSector.getValue();
	}
	
	/**
	 * Funktion zum Speichern der Werte, wenn Änderungen vorliegen
	 */
	protected void applyChanges() {
		building.setGebName(txtGebudeName.getText());
		building.setGebNumber(txtGebudeNummer.getText());
		building.setDescription(txtrBeschreibung.getText());
		building.setSector((int) spinnerSector.getValue());
		try {
			building.setLoad(Double.parseDouble(txtLoad.getText().replace(",", ".")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			return null;
		}
		try {
			building.setGlf(Double.parseDouble(txtGLF.getText().replace(",", ".")));
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		building.setCoordinates(Double.parseDouble(txtXcoordinate.getText().replace(",", ".")), Double.parseDouble(txtYcoordinate.getText().replace(",", ".")));
		
	}
}
