/**
 * Clase que representa el objeto principal del programa
 * @author Ivan Gutierrez
 * @version 1.0
 */
public class Coche {
    /**
     * Propiedades de la clase Coche
     */
    String matricula;
    String modelo;
    Integer velocidad;
    public int metros_recorridos = 0;
    public int litros_gasolina = 0;

    /**
     * Constructor de la clase Coche
     * @param modelo: String
     * @param matricula: String
     * @param metros_recorridos: Integer
     * @param litros_gasolina: Integer
     */
    public Coche(String modelo, String matricula, int metros_recorridos, int litros_gasolina ) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.metros_recorridos = 0;
        this.litros_gasolina = 20;
    }
}
