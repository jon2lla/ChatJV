package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class VentanaCliente {

	private JFrame ventanaCliente;
	private JTextArea txtAreaCliente;
	private JTextField tfEnviar;
	private JButton btnEnviar;

	public static void main(String[] args) {
		VentanaCliente v = new VentanaCliente();
		v.getFrame().setVisible(true);
	}
	
	public VentanaCliente() {
		crearVentana();
	}

	private void crearVentana() {
		ventanaCliente = new JFrame();
		ventanaCliente.setTitle("Cliente");
		
		ventanaCliente.setBounds(500, 100, 500, 600);
		ventanaCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaCliente.getContentPane().setLayout(null);
		
		txtAreaCliente = new JTextArea();
		txtAreaCliente.setDragEnabled(true);
		txtAreaCliente.setBackground(Color.LIGHT_GRAY);
		txtAreaCliente.setBounds(0, 0, 486, 517);
		ventanaCliente.getContentPane().add(txtAreaCliente);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 516, 486, 47);
		ventanaCliente.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(415, 10, 61, 21);
		panel.add(btnEnviar);
		
		tfEnviar = new JTextField();
		tfEnviar.setBounds(10, 10, 395, 21);
		panel.add(tfEnviar);
		tfEnviar.setColumns(10);
	
	}

	public JFrame getFrame() {
		return ventanaCliente;
	}
}
