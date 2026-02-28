package logica.personas;

import logica.interfaces.ICirujano;

import java.util.List;

/**
 * Clase que representa un medico cirujano del hospital San Jose
 * Hereda de medico e implementa la interfaz ICirujano
 */
public class MedicoCirujano extends Medico implements ICirujano {
    /**
     * Numero del quirofano asignado al medico cirujano
     */
    private int numQuirofano;


    /**
     * Constructor para crear un medico cirujano
     *
     * @param nombre             Nombre del medico cirujano
     * @param dni                DNI del medico cirujano
     * @param edad               Edad del medico cirujano
     * @param genero             Genero del medico cirujano
     * @param especialidad       Especialidad del medico cirujano
     * @param numRegistro        Numero de registro del medico cirujano
     * @param pacientesAsignados Pacientes asignados al medico cirujano
     * @param numQuirofano       Numero de quirofano del medico cirujano
     */
    public MedicoCirujano(String nombre, String dni, int edad, String genero, String especialidad, String numRegistro, List<Paciente> pacientesAsignados, int numQuirofano) {
        super(nombre, dni, genero, edad, especialidad, numRegistro, pacientesAsignados);
        this.numQuirofano = numQuirofano;
    }

    /**
     * Obtiene el numero de quirofano del medico cirujano
     *
     * @return Numero del quirofano del medico cirujano
     */
    public int getNumQuirofano() {
        return numQuirofano;
    }

    /**
     * Actualiza el numero de quirofano del medico cirujano
     *
     * @param numQuirofano Numero de quirofano del medico cirujano
     */
    public void setNumQuirofano(int numQuirofano) {
        this.numQuirofano = numQuirofano;
    }

    /**
     * Metodo que valida el estado del quirofano
     *
     * @param estado Estado del quirofano
     * @return True si esta disponible, false si no esta disponible
     */
    @Override
    public boolean validarQuirofano(boolean estado) {
        if (estado) {
            System.out.println("El quirofano esta disponible");
            return true;
        }
        System.out.println("El quirofano no esta disponible en este momento");
        return false;
    }


    /**
     * Metodo que aprueba o no la operacion segun la validacion del quirofano
     *
     * @param estado Estado del quirofano
     * @return Un string que informa si la operacion fue aprobada o no
     */
    @Override
    public String decidirOperacion(boolean estado) {
        if (validarQuirofano(estado)) {
            return "Operacion aprobada, el quirofano esta disponible";
        }
        return "No se puede realizar la operacion";
    }


    /**
     * Metodo de presentacion del medico
     */

    @Override
    public String presentarse() {
        return "Hola soy un cirujano y me llamo: " + getNombre();
    }
}
