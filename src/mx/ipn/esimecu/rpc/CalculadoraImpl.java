package mx.ipn.esimecu.rpc;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {
    private static final long serialVersionUID = 1L;

    public CalculadoraImpl() throws RemoteException {
        super();
    }

    @Override
    public double sumar(double a, double b) {
        return a + b;
    }

    @Override
    public double restar(double a, double b) {
        return a - b;
    }

    @Override
    public double multiplicar(double a, double b) {
        return a * b;
    }

    @Override
    public double dividir(double a, double b) throws RemoteException {
        if (b == 0.0) {
            throw new RemoteException("División entre cero");
        }
        return a / b;
    }

    @Override
    public String quienSoy() throws RemoteException {
        try {
            return "Calculadora remota en " + InetAddress.getLocalHost();
        } catch (Exception e) {
            throw new RemoteException("No se pudo resolver el host", e);
        }
    }
}
