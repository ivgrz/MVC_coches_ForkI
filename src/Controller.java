import java.lang.module.ModuleDescriptor;

/**
 * Clase encargada de manejar la logica del programa y conectar las clases Model y View
 * @author Ivan Gutierrez
 * @version 1.0
 */
public class Controller {
    private Model miModel;
    private View miView;

    /**
     * Constructor de la clase Controller
     * @param model: Model
     * @param view: View
     */
    public Controller(Model model, View view){
        this.miModel = model;
        this.miView = view;


    }
/*
    public static void main(String[] args) {



        // Instanciamos la vista y el modelo
        View miView = new View();
        Model miModel = new Model();


        // Crear tres coches
        miModel.crearCoche("LaFerrari", "SBC 1234");
        miModel.crearCoche("Alpine", "HYU 4567");
        miModel.crearCoche("Aston Martin", "FGH 3333");

        Coche ferrari = miModel.getCoche("SBC 1234");
        // modifica la velocidad
        int nuevaVelocidad = miModel.cambiarVelocidad("SBC 1234", 30);

        // recoje la velocidad y la muestra (tarea de la View)
        boolean hecho = miView.muestraVelocidad("SBC 1234", miModel.getVelocidad("SBC 1234"));

        if (hecho) {
            System.out.println("Correcto");
        } else {
            System.out.println("Error");
        }
    }
    */

    /**
     * Metodo que permite la creacion de objetos tipo Coche
     * @param modelo: String
     * @param matricula: String
     * @param metros_recorridos: int
     * @param litros: int
     */
    public void procesarCrearCoche(String modelo, String matricula, int metros_recorridos, int litros){
        Coche coche_e = miModel.crearCoche(modelo, matricula, metros_recorridos, litros);

        if (coche_e != null){

            miView.mostrarMensaje("Error: La matricula " + matricula + "ya existe. ");
        }else {
            miModel.crearCoche(modelo, matricula,metros_recorridos,litros);
            miView.mostrarMensaje("Coche con matricula: " + matricula + " creado correctamente");
        }

    }

    /**
     * Metodo que permite mostrar la velocidad inicial del coche
     * @param matricula: String
     */
    public void procesarMostrarVelocidad(String matricula){
        Coche coche_e = miModel.getCoche(matricula);
        if (coche_e != null){
            int v_actual = coche_e.velocidad;
            miView.muestraVelocidad(coche_e.matricula, v_actual);
        }else{
            miView.mostrarMensaje("Error: Matricula" + matricula + " no encontrada");
        }


    }
    public void avanzar_coche(String matricula){
        Coche coche_a = miModel.getCoche(matricula);

        if (coche_a != null){
            int metros_r = coche_a.metros_recorridos += 5;
            procesarMostrarVelocidad(matricula);
            int lg = coche_a.litros_gasolina -= 10;
            miView.mostrarMensaje("Avanzando..." + "distancia recorrida: " + metros_r + ", litros de gasolina: " + lg);
            if (lg < 5){
                System.out.println("Gasolina insuficiente, repostar si quiere continuar");
            }
        } else {
            miView.mostrarMensaje("Error: Matricula " + matricula + " no encontrada...");
        }
    }

    public void cargar_gasolina(String matricula, int litros_n){
        Coche c = miModel.getCoche(matricula);
        if (litros_n > 0){
            c.litros_gasolina += litros_n;
            miView.mostrarMensaje("Coche con matricula" + matricula + "repuesto correctamente");

        }else {
            miView.mostrarMensaje("Error: Coche con matricula: " + matricula + " no encontrado....");
        }

    }


}