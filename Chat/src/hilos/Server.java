package hilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

import vista.Logger;

public final class Server implements Runnable{
	private final int PUERTO = 5000;
	private String idConexion = null;
	private static Server INSTANCE = null;
	private int status = 1;
	
	private Logger ventanaServidor;
	
	private Server() {
		Thread hiloSrv = new Thread(this);
		hilo.start();
	}
	
	public void setearLogger(Logger ventanaServidor) {this.ventanaServidor = ventanaServidor;}
	
	
	private static void createInstance() {
        if (INSTANCE == null) {
            // Solo se accede a la zona sincronizada cuando la instancia no está creada
            synchronized(Server.class) {
                // En la zona sincronizada sería necesario volver a comprobar que no se ha creado la instancia
                if (INSTANCE == null) { 
                    INSTANCE = new Server();
                }
            }
        }
    }

    public static Server getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
		
    //Sobreescribimos el metodo clone para evitar la instanciacion multiple a traves de la clonacion
    @Override
    public Server clone() throws CloneNotSupportedException {
    	System.out.println(" \nWARNING: Una instancia de la clase ha sido inicializada\n Utiliza el metodo .getInstance()");
        throw new CloneNotSupportedException(); 
    }
    
	@Override
	public void run() {
		try {
			ServerSocket servidor = null;
			Socket cliente = null;
			while ((status == 1) | (status == 2)){
				if (status == 1){ 
					System.out.println(" *** SERVIDOR CONECTADO ***");

					System.out.println("\n - Numero actual de conexiones: " + ConnectionManager.getInstance().getNumUsuarios());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						
					}
					System.out.println("\n //Esperando conexiones del cliente...");

					try {				
						servidor = new ServerSocket(PUERTO);
						cliente = servidor.accept();
						InputListener hilo = new InputListener(cliente, ventanaServidor.getTxtAreaServidor());
						idConexion = srvR.getIdConexion();
						srvR.start();
						
						ConnectionManager.getInstance().registrarConexion(srvR);

						
						System.out.println("\n => CLIENTE " + srvR.getIdConexion() + " conectado"); 
					} catch (IOException e) {
						System.out.println("\n Error_1: " + e.getMessage() + " (id:" + idConexion + ")");
					} catch (Exception e) {
						System.out.println("\n Error_2: " + e.getMessage() + " (id:" + idConexion + ")");
					} finally {
						try {
							if (servidor != null)
								servidor.close();
						} catch (IOException e) {
							System.out.println("\n Error_3: " + e.getMessage());
						}
						
					}
				}
				while(status == 2) { 
					wait(); 
				}
			}
			
		}catch (InterruptedException e) {
			System.out.println(" *** SERVIDOR CAIDO ***");
		}
	}
		
	public void refrescar(){
		notify();
	}

	public void setStatus(int status){

		this.status = status;
	}
	
	public synchronized void reanudarServidor() {
		setStatus(1);
		refrescar();
		System.out.println(" *** SERVIDOR REANUDADO ***");

	}
	public synchronized void pausarServidor() {
		setStatus(2);
		refrescar();
		System.out.println(" *** SERVIDOR PAUSADO ***");
	}
	
	public synchronized void desconectar(){
		setStatus(3);
		refrescar();
		System.out.println(" *** SERVIDOR CONECTADO ***");
	}
	//GETTERS & SETTERS
	


}


