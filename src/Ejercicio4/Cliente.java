package Ejercicio4;


public class Cliente {
    
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

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
