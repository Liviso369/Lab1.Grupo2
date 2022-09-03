package Ejercicio4;

import java.util.*;

public class DirectorioTelefonico {

    Map<Long, Cliente> directorio;

    public DirectorioTelefonico() {
        this.directorio = new LinkedHashMap<>();
    }

    public void agregarCliente(long phone, Cliente client) {
        directorio.put(phone, client);
        System.out.println("CLiente añadido");
    }

    public Cliente buscarCliente(long phone) {
        return directorio.get(phone);
    }

    public List<Long> buscarTelefono(String lastName) {
        boolean validar = true;///no sirve para validar si hay clientes o no hubo un cliente con ese apellido
        List<Long> listphone = new ArrayList<>();//se inicializa la lista la cual vamos a devolver

        for (Map.Entry<Long, Cliente> entry : directorio.entrySet()) {///se recorre el mapa por parejas

            if (entry.getValue().getApellido().equalsIgnoreCase(lastName)) {

                listphone.add(entry.getKey());
                validar = false;
            }
        }
        if (validar) {
            System.out.println("no se encontro el cliente");
        } else {
            System.out.print("El o los numeros del cliente o los cliente que buscaba son: ");
        }
        return listphone;
    }

    public Set<Cliente> buscarClientes(String city) {

        boolean validar = true;

        Set<Cliente> setClient = new HashSet<>();

        for (Map.Entry<Long, Cliente> entry : directorio.entrySet()) {

            if (entry.getValue().getCiudad().equalsIgnoreCase(city)) {

                setClient.add(entry.getValue());
                validar = false;
            }
        }
        if (validar) {
            System.out.println("no se encontro el cliente de la ciudad de " + city);
        } else {
            System.out.println("El o los clientes que buscaba son: ");
        }
        return setClient;
    }

    public void borrarCliente(long document) {

        boolean validar = true;

        Set<Long> claves = directorio.keySet();///se trasforma el mapa en un Set para asi aplicar el iterator

        Iterator<Long> itera = claves.iterator();///se utiliza el iterator para borrar algun elemento mientras recorremos la coleccion

        while (itera.hasNext()) {

            if (directorio.get(itera.next()).getDni() == document) { // con el get traemos el valor de esa clave y si coincide con el documento lo remueve
                itera.remove();
                validar = false;
            }
        }
        if (validar) {
            System.out.println("no se encontro el cliente");
        } else {
            System.out.println("cliente removido");
        }
    }

    public void mostrarClientes() {
        boolean validar = true;

        for (Map.Entry<Long, Cliente> entry : directorio.entrySet()) {///Recorre la coleccion y la muestra
            System.out.println("El cliente es: " + entry.getValue() + " y " + "su telefono es " + entry.getKey());
            validar = false;
        }
        if (validar) {
            System.out.println("no hay ningun cliente en la lista");
        }
    }

    public boolean verificarCLave(long phone) {

        for (Long clave : directorio.keySet()) {///verifica la clave/telefono que ingresa el usuario para avisarle si esta repetida

            if (phone == clave) {

                return true;
            }
        }
        return false;
    }

}
