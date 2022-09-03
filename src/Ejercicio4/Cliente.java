package Ejercicio4;

import java.util.Scanner;

public class Cliente {
    
    Scanner leer = new Scanner(System.in);
    private long dni;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String direccion;

    public Cliente(long dni, String nombre, String apellido, String ciudad, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }


    public Cliente() {
    }
    
    public long getDni() {
        return dni;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCiudad() {
        return ciudad;
    }
    
    public void agregarDatos(){
        
        System.out.println("Ingrese su dni");
        this.dni = leer.nextLong();
        leer.nextLine();
        
        System.out.println("Ingrese su nombre");
        this.nombre = leer.nextLine();
        
        System.out.println("Ingrese su apellido");
        this.apellido = leer.nextLine();
        
        System.out.println("Ingrese su ciudad");
        this.ciudad = leer.nextLine();
        
        System.out.println("Ingrese su direccion");
        this.direccion = leer.nextLine();  
    }

    @Override
    public String toString() {
        return nombre + " con su: " + "dni = " + dni + ", apellido = " + apellido + ", ciudad = " + ciudad + ", direccion = " + direccion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.dni ^ (this.dni >>> 32));
        return hash;
    }///se aplico hashcode y equals para que en el Set de buscar por ciudad no salieran repetidos en caso de que la misma persona tenga dos numeros telefonicos

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }
}
