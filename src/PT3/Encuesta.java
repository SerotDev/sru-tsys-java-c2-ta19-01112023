package PT3;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.Slider;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class Encuesta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JCheckBox chckbxOption_1, chckbxOption_2, chckbxOption_3;
	private JRadioButton rdbtnOption_1, rdbtnOption_2, rdbtnOption_3;
	private JSlider slider;
	
	/**
	 * Create the frame.
	 */
	public Encuesta() {
		setTitle("Encuesta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Title explanatory for chose the option
		JLabel lblNewLabel = new JLabel("Elije un sistema operativo");
		lblNewLabel.setBounds(10, 24, 162, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel);
		
		//It makes the radiobuttons
		rdbtnOption_1 = new JRadioButton("Windows");
		rdbtnOption_1.setSelected(true);
		rdbtnOption_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnOption_1.setBounds(10, 47, 162, 21);
		contentPane.add(rdbtnOption_1);
		rdbtnOption_2 = new JRadioButton("Linux");
		lblNewLabel.setLabelFor(rdbtnOption_2);
		rdbtnOption_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnOption_2.setBounds(10, 70, 162, 21);
		contentPane.add(rdbtnOption_2);
		rdbtnOption_3 = new JRadioButton("Mac");
		rdbtnOption_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnOption_3.setBounds(10, 93, 162, 21);
		contentPane.add(rdbtnOption_3);
		
		//Adds the radiobuttons to a new group
		ButtonGroup rdbtn_group = new ButtonGroup();
		rdbtn_group.add(rdbtnOption_1);
		rdbtn_group.add(rdbtnOption_2);
		rdbtn_group.add(rdbtnOption_3);
		
		//Title explanatory for chose one or multiple options
		JLabel lblNewLabel_1 = new JLabel("Elije tu especilidad");
		lblNewLabel_1.setLabelFor(rdbtnOption_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 139, 162, 21);
		contentPane.add(lblNewLabel_1);
		
		//It makes the checkoxes
		chckbxOption_1 = new JCheckBox("Programacion");
		chckbxOption_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxOption_1.setBounds(10, 166, 162, 21);
		contentPane.add(chckbxOption_1);
		chckbxOption_2 = new JCheckBox("Diseño gráfico");
		chckbxOption_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxOption_2.setBounds(10, 189, 162, 21);
		contentPane.add(chckbxOption_2);
		chckbxOption_3 = new JCheckBox("Administración");
		chckbxOption_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxOption_3.setBounds(10, 212, 162, 21);
		contentPane.add(chckbxOption_3);
		
		//Title explanatory for chose the spend time in the computer
		JLabel lblNewLabel_1_1 = new JLabel("Horas dedicadas en el ordenador");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 262, 206, 21);
		contentPane.add(lblNewLabel_1_1);
		
		//slider 0 to 10 
		slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setToolTipText("");
		slider.setPaintTicks(true);
		slider.setValue(5);
		slider.setMaximum(10);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(1);
		slider.setBounds(0, 293, 247, 37);
		contentPane.add(slider);
		
		//Separator
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(192, 192, 192));
		separator.setBounds(0, 360, 286, 10);
		contentPane.add(separator);
		
		//button to send the data
		JButton btnNewButton = new JButton("Enviar datos");
		btnNewButton.addActionListener(sendDataToResultados);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(51, 373, 179, 37);
		contentPane.add(btnNewButton);
		
		//it moves the window to the middle
		setLocationRelativeTo(null);
	}
	
	ActionListener sendDataToResultados = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// Hide the current window
	        setVisible(false);
	        
			//get radiobuton checked and data from checkboxes checkeds
			ResultadosEncuesta resultadosEncuesta = new ResultadosEncuesta(getCheckOfRdbtn(), getcChecksOfChckbx(), slider.getValue());
			resultadosEncuesta.setVisible(true);
		}
	};
	
	public String getCheckOfRdbtn() {
		String stringOfRdbtnResult = "";
		// Check which radio button is selected
        if (rdbtnOption_1.isSelected()) {
            stringOfRdbtnResult = "Windows";
        } else if (rdbtnOption_2.isSelected()) {
        	stringOfRdbtnResult = "Linux";
        } else if (rdbtnOption_3.isSelected()) {
        	stringOfRdbtnResult = "Mac";
        } else {
            System.out.println("Nada seleccionado. (Imposible)");
        }
        
        return stringOfRdbtnResult;
	}
	
	
	public String getcChecksOfChckbx() {
		ArrayList<String> chckbxResult = new ArrayList<String>();
		String stringOfChckbxResults; //message without selection
		
		//check if checkboxes are selected and add the selected into the arraylist
		if (chckbxOption_1.isSelected()) {
			chckbxResult.add(chckbxOption_1.getText());
		}
		if (chckbxOption_2.isSelected()) {
			chckbxResult.add(chckbxOption_2.getText());
		}
		if (chckbxOption_3.isSelected()) {
			chckbxResult.add(chckbxOption_3.getText());
		}
		
		//if arraylist have data we fill it with the new data
		if (chckbxResult.size() == 0) {
			stringOfChckbxResults = "No se ha seleccionado nungun elemento.";
		} else {
			stringOfChckbxResults = chckbxResult.toString();
			
			stringOfChckbxResults = stringOfChckbxResults.replace("] [", ", ").replace("[", "").replace("]", ".");
		}
		
		return stringOfChckbxResults;
	}
	
	
}
