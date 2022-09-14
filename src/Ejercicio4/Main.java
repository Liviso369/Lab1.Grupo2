package Ejercicio4;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        DirectorioTelefonico directorio = DirectorioTelefonico.getInstance();

        //probando metodo agregar
        directorio.agregarCliente(2664, new Cliente(111, "Federico", "Muñoz", "San luis", "Lince"));
        directorio.agregarCliente(2665, new Cliente(222, "Federico", "Muñoz", "San luis", "Lince"));
        directorio.agregarCliente(2666, new Cliente(333, "Facundo", "Bustos", "Buenos Aires", "Maipu"));
        directorio.agregarCliente(2667, new Cliente(444, "Pablo", "Luna", "Formosa", "Maipu"));
        directorio.agregarCliente(2667, new Cliente(444, "Pablo", "Luna", "Formosa", "Maipu"));

        //probando metodo buscar por telefono
        System.out.println("El cliente es: " + directorio.buscarCliente(2665));

        //probando metodo buscar por apellido
        List<Long> listaTelef = directorio.buscarTelefono("Luna");

        for (Iterator listaN = listaTelef.iterator(); listaN.hasNext();) {

            System.out.print(listaN.next());

            if (listaN.hasNext()) {

                System.out.print(",");
            } else {
                System.out.println(".");
            }
        }
        //probando metodo buscar por ciudad
        Set<Cliente> listaClient = directorio.buscarClientes("Buenos Aires");

        for (Cliente cliente : listaClient) {

            System.out.println(cliente);
        }

        //probando metodo borrar cliente por numero/clave
        directorio.borrarCliente(2665);
        
        ///mostrar los clientes que quedaron
        
        for (Map.Entry<Long, Cliente> entry : directorio.getDirectorio().entrySet()) {///Recorre la coleccion y la muestra
            System.out.println("El cliente es: " + entry.getValue() + " y " + "su telefono es " + entry.getKey());
        }
    }
}
