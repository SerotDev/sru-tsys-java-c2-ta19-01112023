package PT3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultadosEncuesta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public ResultadosEncuesta(String so, String especialidades, int horas) {
		setTitle("Resultados Encuesta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Title explanatory of the result of the operative sistem
		JLabel lblNewLabel = new JLabel("Sistema Operativo: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(27, 34, 238, 13);
		contentPane.add(lblNewLabel);
		
		//Title explanatory of the result of the specialities
		JLabel lblEspecialidades = new JLabel("Especialidades: ");
		lblEspecialidades.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEspecialidades.setBounds(27, 102, 238, 13);
		contentPane.add(lblEspecialidades);
		
		//Title explanatory of the result of the hours
		JLabel lblHorasDedicadas = new JLabel("Horas dedicadas: ");
		lblHorasDedicadas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHorasDedicadas.setBounds(27, 172, 238, 13);
		contentPane.add(lblHorasDedicadas);
		
		//label to show the operative sistem
		JLabel lblSo = new JLabel(so);
		lblSo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSo.setBounds(27, 57, 360, 23);
		contentPane.add(lblSo);
		
		//label to show the specialities
		JLabel lblSo_1 = new JLabel(especialidades);
		lblSo_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSo_1.setBounds(27, 125, 360, 23);
		contentPane.add(lblSo_1);
		
		//label to show the hours
		JLabel lblHoras = new JLabel(String.valueOf(horas));
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoras.setBounds(27, 195, 360, 23);
		contentPane.add(lblHoras);
		
		//button to get back
		JButton btnNewButton = new JButton("Volver a introducir datos");
		btnNewButton.addActionListener(goBack);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(27, 242, 194, 33);
		contentPane.add(btnNewButton);
		
		//it moves the window to the middle
		setLocationRelativeTo(null);
	}
	
	ActionListener goBack = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// Hide the current window
	        setVisible(false);
	        
	        // Create a new instance of the Encuesta frame and make it visible
	        Encuesta encuesta = new Encuesta();
	        encuesta.setVisible(true);
		}
	};

}
