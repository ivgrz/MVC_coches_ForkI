import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario
 */
public class View {
    /**
     * Muestra la velocidad de un coche
     * @param matricula del coche
     * @param v velocidad
     * @return true si se ha mostrado correctamente
     */
    public boolean muestraVelocidad(String matricula, Integer v){
        System.out.println(matricula + ": " + v + " km/hr");
        return true;
    }

    public static void main(String[] args) {
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
                    System.out.println("Cual es la matricula del coche?: ");
                    String matricula = new Scanner(System.in).next();
                    System.out.println("Cual es el modelo? ");
                    String modelo = new Scanner(System.in).next();
                    Model model = new Model();
                    try{

                        model.crearCoche(modelo, matricula);
                        System.out.println("Coche creado correctamente");
                    }catch(Exception e){
                        System.out.println("No se ha podido crear el coche " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Cual es la matricula?");
                    String matricula_velocidad = new Scanner(System.in).next();
                    System.out.println("Cual es la velocidad?: ");
                    int velcidadm = new Scanner(System.in).nextInt();

                    View miview = new View();
                    try{
                        miview.muestraVelocidad(matricula_velocidad, velcidadm);
                        System.out.println("Mostrando...");
                    }catch (NumberFormatException e){
                        System.out.println("No se ha podido ver la velocidad " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");

            }


        }while(opcion != 3);

    }
}
