import java.lang.module.ModuleDescriptor;

/**
 * Clase encargada de manejar la logica del programa y conectar las clases Model y View
 * @author Ivan Gutierrez
 * @version 1.0
 */
public class Controller {
    private Model miModel;
    private View miView;

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

    public void procesarCrearCoche(String modelo, String matricula){
        Coche coche_e = miModel.crearCoche(modelo, matricula);

        if (coche_e != null){

            miView.mostrarMensaje("Error: La matricula " + matricula + "ya existe. ");
        }else {
            miModel.crearCoche(modelo, matricula);
            miView.mostrarMensaje("Coche con matricula: " + matricula + " creado correctamente");
        }

    }
    public void procesarMostrarVelocidad(String matricula){
        Coche coche_e = miModel.getCoche(matricula);
        if (coche_e != null){
            int v_actual = coche_e.velocidad;
            miView.muestraVelocidad(coche_e.matricula, v_actual);
        }else{
            miView.mostrarMensaje("Error: Matricula" + matricula + " no encontrada");
        }


    }


}