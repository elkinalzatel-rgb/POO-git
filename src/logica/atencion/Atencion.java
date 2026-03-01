package logica.atencion;

import logica.personas.Paciente;

/**
 * Clase que representa la atencion a un paciente
 */
public class Atencion {

    /**
     * Constructor de la clase atencion
     */
    public Atencion() {
    }

    /**
     * Envia a un paciente a un pabellon según su eps
     *
     * @param p Paciente a enviar
     * @return Pabellon asignado al paciente
     */
    public String procesarIngreso(Paciente p) {
        String pabellon = switch (p.getEps()) {
            case "Sura" -> " EPS: " + p.getEps() +
                    "               Paciente asignado al pabellon 1";
            case "Comeva" -> "  EPS: " + p.getEps() +
                    "               Paciente asignado al pabellon 2";
            case "Nueva EPS" -> " EPS: " + p.getEps() +
                    "               Paciente asignado al pabellon 3";
            default -> null;
        };
        return (pabellon != null) ? pabellon : "ERROR: ingrese una EPS válida";
    }

}
