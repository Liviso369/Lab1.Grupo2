package Ejercicio4;

import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        Scanner leer = new Scanner(System.in);

        DirectorioTelefonico directorio = new DirectorioTelefonico();

        int opcion;

        do {
            Cliente cliente = new Cliente();

            System.out.println("Seleccione una opcion");
            System.out.println("1_Agregar cliente");
            System.out.println("2_Buscar cliente por telefono");
            System.out.println("3_Buscar cliente por apellido");
            System.out.println("4_Buscar cliente por ciudad");
            System.out.println("5_Eliminar cliente por dni");
            System.out.println("6_Mostra directorio");
            System.out.println("7_salir");

            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    agregarCLiente(directorio, cliente, leer);
                    break;
                case 2:
                    buscarClientePorTelefono(directorio, leer);
                    break;
                case 3:
                    buscarClientePorApellido(directorio, leer);
                    break;
                case 4:
                    buscarClientePorCiudad(directorio, leer);
                    break;
                case 5:
                    borrarClientePorDni(directorio, leer);
                    break;
                case 6:
                    directorio.mostrarClientes();
                    break;
                case 7:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("no existe esa opcion");
            }
        } while (opcion != 7);

    }

    public static void agregarCLiente(DirectorioTelefonico x, Cliente y, Scanner z) {///si la clave esta repetida le avisa al usuario,sino lo agrega al directorio
        System.out.println("Ingrese el telefono");
        long telefono = z.nextLong();
        
        if (x.verificarCLave(telefono) ) {
            
            System.out.println("ya hay un cliente con el mismo telefono");   
        }else{
            y.agregarDatos();
            x.agregarCliente(telefono, y);   
        }
    }

    public static void buscarClientePorTelefono(DirectorioTelefonico x, Scanner z) {//comprueba si lo que viene son datos de tipo cliente en caso de que no quiere decir que es null
        System.out.println("Ingrese el telefono a buscar");
        long telefono = z.nextLong();

        if (x.buscarCliente(telefono) instanceof Cliente) {
            System.out.println("El cliente que buscaba es: " + x.buscarCliente(telefono));
        } else {
            System.out.println("no se encontro ningun cliente con el telefono: " + telefono);
        }
    }

    public static void buscarClientePorApellido(DirectorioTelefonico x, Scanner z) {//imprime la lista de telefonos

        System.out.println("Ingrese el apellido a buscar");
        String apellido = z.nextLine();

        for (Iterator listaN = x.buscarTelefono(apellido).iterator(); listaN.hasNext();) {

            System.out.print(listaN.next());

            if (listaN.hasNext()) {

                System.out.print(",");
            } else {
                System.out.println(".");
            }
        }
    }

    public static void buscarClientePorCiudad(DirectorioTelefonico x, Scanner z) {///imprime el Set de clientes

        System.out.println("Ingrese la ciudad a buscar");
        String ciudad = z.nextLine();

        for (Iterator listaN = x.buscarClientes(ciudad).iterator(); listaN.hasNext();) {

            System.out.println(listaN.next() + ".");
        }
    }

    public static void borrarClientePorDni(DirectorioTelefonico x, Scanner z) {//pide el dni y lo borra si esta
        System.out.println("Ingrese el DNI del cliente que desea eliminar");
        long dni = z.nextLong();
        x.borrarCliente(dni);
    }

}
