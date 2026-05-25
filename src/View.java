import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario
 * @author Ivan Gutierrez
 * @version 1.0
 */
public class View {
    /**
     * Muestra la velocidad de un coche
     * @param matricula del coche
     * @param v velocidad
     * @return true si se ha mostrado correctamente
     */
    private Controller c;
    private Scanner scanner = new Scanner(System.in);

    public void setController(Controller control){
        this.c = control;

    }



    public boolean muestraVelocidad(String matricula, Integer v){
        System.out.println(matricula + ": " + v + " km/hr");
        return true;
    }
// Menu de View
    public void MostrarMenu(){
        int opcion = 0;
        do {

            System.out.println("===== COCHES =====");
            System.out.println("Que quieres realizar? ");
            System.out.println("1. Crear Coche");
            System.out.println("2. Mostrar velocidad");
            System.out.println("3. Salir");

            opcion = new Scanner(System.in).nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Cual es el modelo?: ");
                    String modelo = scanner.next();
                    System.out.println("Cual es la matricula?: ");
                    String matricula = scanner.next();
                    c.procesarCrearCoche(modelo, matricula);

                    break;

                case 2:
                    System.out.println("Cual es la matricula?");
                    String matricula_velocidad = scanner.next();
                    c.procesarMostrarVelocidad(matricula_velocidad);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");

            }


        }while(opcion != 3);


    }
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);

    }
    public static void main(String[] args) {


        View miView = new View();
        Model miModel = new Model();


        Controller controlador = new Controller(miModel, miView);
        miView.setController(controlador);
        miView.MostrarMenu();
    }
}
