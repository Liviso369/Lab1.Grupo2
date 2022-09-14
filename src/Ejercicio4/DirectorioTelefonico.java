package Ejercicio4;

import java.util.*;
import javax.swing.JOptionPane;

public class DirectorioTelefonico {

    Map<Long, Cliente> directorio;

    private static DirectorioTelefonico dire = null;

    private DirectorioTelefonico() {
        this.directorio = new LinkedHashMap<>();
    }

    public static DirectorioTelefonico getInstance() {

        if (dire == null) {

            dire = new DirectorioTelefonico();
        }
        return dire;
    }

    public Map<Long, Cliente> getDirectorio() {
        return directorio;
    }

    public void setDirectorio(Map<Long, Cliente> directorio) {
        this.directorio = directorio;
    }

    public void agregarCliente(long phone, Cliente client) {

        if (directorio.get(phone) != null) {///si existe el cliente devuelve true quiere decir que la clave ya existe,sino false

            JOptionPane.showMessageDialog(null, "ya existe este numero de telefono");
        } else {
            directorio.put(phone, client);
            JOptionPane.showMessageDialog(null, "Cliente añadido");
        }
    }

    public Cliente buscarCliente(long phone) {
        return directorio.get(phone);
    }

    public List<Long> buscarTelefono(String lastName) {

        List<Long> listphone = new ArrayList<>();

        for (Long key : directorio.keySet()) {

            if (directorio.get(key).getApellido().equalsIgnoreCase(lastName)) {

                listphone.add(key);
            }
        }
        return listphone;//no es necesario comprobar si hay algo en la lista ya que su funcion es delvolver la lista, validar desde el main
    }

    public Set<Cliente> buscarClientes(String city) {

        Set<Cliente> setClient = new HashSet<>();

        for (Cliente valores : directorio.values()) {

            if (valores.getCiudad().equalsIgnoreCase(city)) {

                setClient.add(valores);
            }
        }

        return setClient;
    }

    public void borrarCliente(long phone) {

        if (directorio.remove(phone) != null) {
            JOptionPane.showMessageDialog(null, "Cliente Borrado");

        } else {
            JOptionPane.showMessageDialog(null, "No existe el cliente");
        }
    }
}
