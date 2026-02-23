package hospitalSanJose.atencion;

import hospitalSanJose.personas.Paciente;

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
            case "Sura" -> " Pabellon 1";
            case "Comeva" -> "Pabellon 2";
            case "VidaLoca" -> "Pabellon 3";
            default -> null;
        };
        System.out.println("Paciente asignado al pabellon: " + pabellon);
        return (pabellon != null) ? pabellon : "ERROR: ingrese una EPS válida";
    }

}
