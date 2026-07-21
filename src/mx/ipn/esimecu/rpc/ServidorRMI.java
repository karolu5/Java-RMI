package mx.ipn.esimecu.rpc;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            // Levanta el registro RMI en el puerto 1099
            LocateRegistry.createRegistry(1099);
            Calculadora servicio = new CalculadoraImpl();
            Naming.rebind("rmi://localhost:1099/CalculadoraIPN", servicio);
            System.out.println("Servidor RMI listo en rmi://localhost:1099/CalculadoraIPN");
        } catch (Exception e) {
            System.err.println("Error en el servidor RMI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
