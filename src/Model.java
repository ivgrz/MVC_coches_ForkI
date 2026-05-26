import java.util.ArrayList;

/**
 * Clase encargada de manejar los datos
 * @author Ivan Gutierrez
 * @version 1.0
 */
public class Model {
    static ArrayList<Coche> parking = new ArrayList<>();


    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public Coche crearCoche(String modelo, String matricula, int metros_recorridos, int litros_gasolina){
        Coche aux = new Coche(modelo, matricula, metros_recorridos, litros_gasolina);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca coche segun matricula
     * @param matricula a buscar
     * @return chche o null si no existe
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Cambia la velocidad de un coche
     * @param matricula: String
     * @param v nueva velocidad
     * @return velocidad modificada
     */
    public int cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;
        // retorna la nueva velocidad
        return getCoche(matricula).velocidad;
    }

    /**
     * Ddevuelve la velocidad segun la matricula
     * @param matricula: String
     * @return velocidad: int
     */
    public int getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}
