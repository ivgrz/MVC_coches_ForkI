import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario
 * @author Ivan Gutierrez
 * @version 1.0
 */
public class View {
    /**
     * Propiedades de la clase View
     */
    private Controller c;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Setter de controller
     * @param control: void
     */
    public void setController(Controller control){
        this.c = control;

    }


    /**
     * Metodo que muestra la velocidad
     * @param matricula: String
     * @param v: integer
     * @return boolean
     */
    public boolean muestraVelocidad(String matricula, Integer v){
        System.out.println(matricula + ": " + v + " km/hr");
        return true;
    }
// Menu de View

    /**
     * Metodo que permite la interaccion del programa con el usuario
     * Sin parametros (void)
     */
    public void MostrarMenu(){
        int opcion;
        do {

            System.out.println("===== COCHES =====");
            System.out.println("Que quieres realizar? ");
            System.out.println("1. Crear Coche");
            System.out.println("2. Mostrar velocidad");
            System.out.println("3. Avanzar");


            opcion = new Scanner(System.in).nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Cual es el modelo?: ");
                    String modelo = scanner.next();
                    System.out.println("Cual es la matricula?: ");
                    String matricula = scanner.next();
                    c.procesarCrearCoche(modelo, matricula,0,0);

                    break;

                case 2:
                    System.out.println("Cual es la matricula?");
                    String matricula_velocidad = scanner.next();
                    c.procesarMostrarVelocidad(matricula_velocidad);
                    break;
                case 3:
                    System.out.println("Que coche debe avanzar? (introducir matricula): ");
                    String matricula_avanzar = scanner.next();
                    c.avanzar_coche(matricula_avanzar);
                    break;
                case 4:
                    System.out.println("Matricula: ");
                    String matricula_repostar = scanner.next();
                    System.out.println("Cantidad a repostar: ");
                    int cant_l = scanner.nextInt();
                    c.cargar_gasolina(matricula_repostar,cant_l);
                case 5:
                    System.out.println("Saliendo...");
                default:
                    System.out.println("Opcion invalida");

            }


        }while(opcion != 5);


    }

    /**
     * Metodo que permite al Controller mostrar mensajes a usuarios sin recurrir a un print
     * @param mensaje: String
     */
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);

    }

    /**
     * Metodo "main" que permite la compilacion del programa
     * @param args: String[]
     */
    public static void main(String[] args) {


        View miView = new View();
        Model miModel = new Model();


        Controller controlador = new Controller(miModel, miView);
        miView.setController(controlador);
        miView.MostrarMenu();
    }
}
