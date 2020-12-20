package main;

import hilos.Server;
import vista.Logger;

public class MainServidor {

	public static void main(String[] args) {
		Logger logger = new Logger();
		Server srv = Server.getInstance();
		srv.setearLogger(logger);
		srv.start();
	}

}
