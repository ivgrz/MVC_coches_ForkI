/**
 * Clase que representa el objeto principal del programa
 * @author Ivan Gutierrez
 * @version 1.0
 */
public class Coche {
    String matricula;
    String modelo;
    Integer velocidad;

    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
    }
}
