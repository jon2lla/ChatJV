package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VentanaIntro {

	private JLabel mensaje;
	private JButton btnAceptar; 
	private JFrame frame;
	private JTextField tfNick;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaIntro window = new VentanaIntro();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
	public VentanaIntro() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfNick = new JTextField();
		tfNick.setBounds(232, 101, 96, 19);
		frame.getContentPane().add(tfNick);
		tfNick.setColumns(10);
		
		btnAceptar = new JButton("New button");
		btnAceptar.setBounds(172, 172, 85, 21);
		frame.getContentPane().add(btnAceptar);
		
		mensaje = new JLabel("New label");
		mensaje.setBounds(130, 104, 45, 13);
		frame.getContentPane().add(mensaje);
	}
}
