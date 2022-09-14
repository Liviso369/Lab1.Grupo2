package Ejercicio5;

public class Colegio {

    public static void main(String[] args) {

        Materia ingles = new Materia(01, "Ingles I", 1);
        Materia mate = new Materia(02, "Matematica", 1);
        Materia lab = new Materia(03, "Laboratorio", 1);

        Alumno alum1 = new Alumno(1001, "Lopez", "Martin");
        Alumno alum2 = new Alumno(1002, "Martinez", "Brenda");

        alum1.agregarMateria(ingles);
        alum1.agregarMateria(mate);
        alum1.agregarMateria(lab);
        
        
        alum2.agregarMateria(ingles);
        alum2.agregarMateria(mate);
        alum2.agregarMateria(lab);
        System.out.println("ATENCION al alumno "+alum2.getNombre()+" se lo inscribe nuevamente a laboratorio 1 el resultado es:");
        alum2.agregarMateria(lab);
        
        
        System.out.println("La cantidad de materia de " + alum1.getNombre() + " es: " + alum1.cantidadMaterias());
        System.out.println("La cantidad de materia de " + alum2.getNombre() + " es: " + alum2.cantidadMaterias());
    }
}
