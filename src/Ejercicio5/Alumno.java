package Ejercicio5;

import java.util.*;

public class Alumno {

    private int legajo;

    private String apellido;

    private String nombre;

    private Set<Materia> materias;

    public Alumno(int legajo, String apellido, String nombre) {
        
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.materias = new LinkedHashSet<>();  
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }

    public void agregarMateria(Materia m) {
        
        if (materias.add(m)) {
            
            materias.add(m);
            
        }else{
            System.out.println("ya la materia fue agregada");
        }  
    }

    public int cantidadMaterias() {
        return materias.size();
    }
}
