package hilos;

import java.util.*;

public class ConnectionManager {
    
	private Map<String, InputListener> conexiones = new Hashtable<String, InputListener>();
    
    private ConnectionManager() {}
    
    public static ConnectionManager getInstance() {
        return Holder.INSTANCE;
    }
    
    private static class Holder {
        private static final ConnectionManager INSTANCE = new ConnectionManager();
    }

    private Object readResolve()  {
        return Holder.INSTANCE;
    }
    
    public void registrarConexion(InputListener conexion){
    	conexiones.put(conexion.getIdConexion(), conexion);
    }
    
    public InputListener recuperarConexion(String idConexion) {
    	return conexiones.get(idConexion);
    }
    
    public void cerrarConexion(String idConexion){
    	InputListener conexion = conexiones.get(idConexion);
        if (conexion != null) {
        	conexion.desconectar();
            conexiones.remove(idConexion);
        }
    }
    
    public void mensajeDeDifusion(String mensaje){
        for (Map.Entry<String, InputListener> entrada : conexiones.entrySet()){
        	entrada.getValue().enviarMensaje(mensaje);            
        }
    }  
    
    public int getNumUsuarios() {
		return conexiones.size();
	}
}