package vista;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Logger {

	private JFrame ventanaServidor;
	private JLabel lblNumClientes;
	private JTextArea txtAreaServidor;
	private JButton btnDesconectarSrvr;

	public Logger() {
		crearVentana();
	}

	private void crearVentana() {
		ventanaServidor = new JFrame();
		ventanaServidor.setBounds(100, 100, 450, 300);
		ventanaServidor.setDefaultCloseOperation(0);
		ventanaServidor.getContentPane().setLayout(null);
		
		txtAreaServidor = new JTextArea();
		txtAreaServidor.setBounds(64, 71, 333, 107);
		ventanaServidor.getContentPane().add(txtAreaServidor);
		
		btnDesconectarSrvr = new JButton("Desconectar Servidor");
		btnDesconectarSrvr.setBounds(167, 208, 145, 27);
		ventanaServidor.getContentPane().add(btnDesconectarSrvr);
		
		lblNumClientes = new JLabel("New label");
		lblNumClientes.setBounds(74, 48, 45, 13);
		ventanaServidor.getContentPane().add(lblNumClientes);
	}

	public JFrame getVentanaServidor() {
		return ventanaServidor;
	}

	public JButton getBtnDesconectarSrvr() {
		return btnDesconectarSrvr;
	}

	public void setLblNumClientes(JLabel lblNumClientes) {
		this.lblNumClientes = lblNumClientes;
	}

	public JTextArea getTxtAreaServidor() {
		return txtAreaServidor;
	}
	
	public void setTxtAreaServidor(JTextArea txtAreaServidor) {
		this.txtAreaServidor = txtAreaServidor;
	}
	
	
}
