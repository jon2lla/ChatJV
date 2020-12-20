package hilos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class InputListener extends Thread{
	private static int ID_CLIENTE = 0;

	private int pausar = 1;

	private JTextArea txtArea;
	private JTextField tf;
	private JButton btnEnviar;
	private String idConexion;
	private Socket cliente;
	private boolean conectado;
	private ObjectInputStream entrada = null;
	private ObjectOutputStream salida = null;
		

	public InputListener(Socket cliente, JTextArea txtArea) {
		ID_CLIENTE++;
		this.cliente = cliente;
		this.idConexion = String.valueOf(ID_CLIENTE);
		this.txtArea = txtArea;
	}

	@Override
	public void run() {
		try {
			while ((pausar == 1) | (pausar == 2)) {
				if (pausar == 1) {
					try {
						conectado = true;
						salida = new ObjectOutputStream(cliente.getOutputStream());
						entrada = new ObjectInputStream(cliente.getInputStream());
					} catch (Exception e) {
						// TODO: handle exception
					}
					

					Thread.sleep(2000);
				}
				while (pausar == 2) {

					wait();
				}
			}

		} catch (InterruptedException e) {
		}
	}

	public synchronized void resumirHilo() {
		notify();
	}

	public void setPause(int pPause) {

		this.pausar = pPause;
	}

	public synchronized void reanudarConexion() {
		setPause(1);
		resumirHilo();
//		System.out.println("El hilo " + this.getNombre() + " ha sido reanudado");

	}

	public synchronized void pausarConexion() {
		setPause(2);
		resumirHilo();
//		System.out.println("El hilo " + this.getNombre() + " ha sido pausado");
	}

	public synchronized void desconectar() {
		setPause(3);
		resumirHilo();
//		System.out.println("El hilo " + this.getNombre() + " ha finalizado");
	}

	public void enviarMensaje(String mensaje) {
		try {
			salida.writeObject("Eii");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public String getIdConexion() {
		// TODO Auto-generated method stub
		return null;
	}

}
