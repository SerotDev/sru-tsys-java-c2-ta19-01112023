package PT1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Saludador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public Saludador() {
		setTitle("Saludador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscribeUnNombre = new JLabel("Escribe un nombre para saludar:");
		lblEscribeUnNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEscribeUnNombre.setBounds(128, 43, 217, 13);
		contentPane.add(lblEscribeUnNombre);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(154, 88, 160, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("¡Saludar!");
		btnNewButton.addActionListener(saludar);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(190, 132, 95, 25);
		contentPane.add(btnNewButton);
	}
	
    ActionListener saludar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//recogemos datos del textField y procesamos para validar y saludar
			JOptionPane.showMessageDialog(null, msgIfNotEmpty(textField.getText()));
		}
	};
	
	public String msgIfNotEmpty(String text) {
		String message = text;
		if (text.length() > 0) {
			message = "Hello " + message + "!";
		} else {
			message = "Error: textField is empty.";
		}
		return message;
	}
}
