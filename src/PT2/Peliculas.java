package PT2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Peliculas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox = new JComboBox();

	/**
	 * Create the frame.
	 */
	public Peliculas() {
		//set window preferences
		setTitle("Peliculas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//center the window to the middle
		setLocationRelativeTo(null);
		
		//Title of explanatory text to enter data
		JLabel lblNewLabel = new JLabel("Escriba el título de la película:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(78, 42, 208, 39);
		contentPane.add(lblNewLabel);
		
		//Field to enter keyboard data
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(30, 125, 283, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//button to add movie name
		JButton btnNewButton = new JButton("AÑADIR");
		btnNewButton.addActionListener(addPelicula);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(109, 207, 121, 39);
		contentPane.add(btnNewButton);
		
		//horizontal separator to separate left (data introduction) and right (show data)
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(192, 192, 192));
		separator.setBounds(346, 0, 10, 313);
		contentPane.add(separator);
		
		//title of the left section (show data)
		JLabel lblNewLabel_1 = new JLabel("LISTA DE PELÍCULAS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(420, 10, 208, 26);
		contentPane.add(lblNewLabel_1);
		
		//combo box to show data inserted
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Avatar", "Interestelar", "Idiocracy"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(371, 46, 283, 30);
		contentPane.add(comboBox);
	}
	
	//action that runs when user click on the button
	ActionListener addPelicula = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (!textField.getText().isEmpty()) {
				comboBox.addItem(textField.getText());
			} else {
				JOptionPane.showMessageDialog(null, "Campo vacío, introduce algún nombre de película.");
			}
		}
	};
	

	
}
